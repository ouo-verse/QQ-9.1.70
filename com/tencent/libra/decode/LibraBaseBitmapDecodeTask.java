package com.tencent.libra.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.LoadContext;
import com.tencent.libra.LoadState;
import com.tencent.libra.cache.BitmapPool;
import com.tencent.libra.h;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.LibraImageUtil;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.libra.util.RFWThumbnailUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class LibraBaseBitmapDecodeTask extends LibraBaseDecodeTask {
    public LibraBaseBitmapDecodeTask(LoadContext loadContext, LibraRequestKey libraRequestKey) {
        super(loadContext, libraRequestKey);
        if (loadContext.getOption().isAllowRotate() && loadContext.getOption().getRotationDegree() == 0) {
            loadContext.getOption().setRotationDegree(LibraImageUtil.getRotateDegree(loadContext.getOption()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap adjustBitmap(Bitmap bitmap, int i3, int i16, boolean z16) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth() - i3;
        int height = bitmap.getHeight() - i16;
        if (width >= 0 && height >= 0) {
            if (width != 0 || height != 0) {
                return RFWThumbnailUtils.extractThumbnail(bitmap, i3, i16, 2, z16);
            }
            return bitmap;
        }
        return bitmap;
    }

    @Override // com.tencent.libra.decode.LibraBaseDecodeTask
    protected void decode(Option option) {
        Bitmap decodeBitmap = decodeBitmap(this.mOption);
        this.mOption.setResultBitMap(decodeBitmap);
        if (decodeBitmap == null) {
            String localPath = this.mOption.getLocalPath();
            if (localPath.contains(this.mPicLoader.getDownloadRootPath())) {
                RFWFileUtils.deleteFile(localPath);
            }
            LibraLogUtil.INSTANCE.i(getLogTag(), RFWLog.USR, option, "[decode] result is null");
        }
        if (this.mStatus == LoadState.STATE_CANCEL) {
            return;
        }
        this.mPicLoader.afterDecode(this.mOption, this.mTaskStartTime, decodeBitmap);
    }

    @Nullable
    protected abstract Bitmap decodeBitmap(Option option);

    public void decodeBitmapSize(Option option, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        try {
            InputStream a16 = h.f118788a.a(option.getModel(), new File(option.getLocalPath()));
            try {
                BitmapFactory.decodeStream(a16, null, options);
                if (a16 != null) {
                    a16.close();
                }
            } finally {
            }
        } catch (Throwable th5) {
            LibraLogUtil.INSTANCE.e(getLogTag(), RFWLog.USR, this.mOption, "[decodeBitmapSize] decode exception:", th5);
        }
    }

    public Bitmap handleDecodeBitmap(Option option, BitmapFactory.Options options) {
        options.inJustDecodeBounds = false;
        try {
            InputStream a16 = h.f118788a.a(option.getModel(), new File(option.getLocalPath()));
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(a16, null, options);
                if (a16 != null) {
                    a16.close();
                }
                setPicType(options);
                return rotateDegree(option, decodeStream);
            } catch (Throwable th5) {
                if (a16 != null) {
                    try {
                        a16.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        } catch (IOException | OutOfMemoryError | RuntimeException e16) {
            LibraLogUtil.INSTANCE.e(getLogTag(), RFWLog.USR, option, "[decodeBitmap] decode exception:", e16);
            return null;
        }
    }

    public Bitmap rotateDegree(Option option, Bitmap bitmap) {
        if (option.isAllowRotate() && option.getRotationDegree() != 0 && bitmap != null) {
            Matrix matrix = new Matrix();
            LibraLogUtil.INSTANCE.i(getLogTag(), RFWLog.USR, option, "[rotateDegree] rotate ", Integer.valueOf(option.getRotationDegree()));
            matrix.setRotate(option.getRotationDegree(), bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return bitmap;
    }

    public void setInBitmap(Option option, @NonNull BitmapFactory.Options options, int i3, int i16) {
        BitmapPool bitmapPool = this.mPicLoader.getBitmapPool(option);
        if (bitmapPool != null) {
            Bitmap.Config config = options.inPreferredConfig;
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            if (config == config2) {
                if (options.inSampleSize <= 1) {
                    options.inSampleSize = 1;
                }
                int i17 = options.inSampleSize;
                options.inBitmap = bitmapPool.get(i3 / i17, i16 / i17, config2);
            }
        }
    }
}
