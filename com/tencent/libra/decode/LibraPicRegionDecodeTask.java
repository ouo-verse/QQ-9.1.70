package com.tencent.libra.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWIOUtil;
import com.tencent.biz.richframework.util.RFWImageUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadContext;
import com.tencent.libra.exception.RegionDecodeException;
import com.tencent.libra.h;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.LibraLogUtil;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class LibraPicRegionDecodeTask extends LibraBaseBitmapDecodeTask {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraPicRegionDecodeTask");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f118644a;

        static {
            int[] iArr = new int[DecodeFormat.values().length];
            f118644a = iArr;
            try {
                iArr[DecodeFormat.PREFER_RGB_565.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public LibraPicRegionDecodeTask(LoadContext loadContext, LibraRequestKey libraRequestKey) {
        super(loadContext, libraRequestKey);
    }

    private Rect getAutoRegion(int i3, int i16, @NonNull Option option) {
        int i17;
        int i18;
        int i19;
        int i26;
        ImageView.ScaleType regionScaleType = option.getRegionScaleType();
        int requestWidth = option.getRequestWidth();
        int requestHeight = option.getRequestHeight();
        if (requestWidth != 0 && requestHeight != 0) {
            float f16 = i3;
            float f17 = i16;
            float f18 = f16 / f17;
            float f19 = requestWidth;
            float f26 = requestHeight;
            float f27 = f19 / f26;
            if (regionScaleType == ImageView.ScaleType.CENTER_CROP) {
                if (f18 > f27) {
                    int i27 = (int) ((f17 * f19) / f26);
                    int i28 = (i3 - i27) / 2;
                    i17 = i27 + i28;
                    i19 = i28;
                    i26 = 0;
                    i18 = i16;
                } else {
                    int i29 = (int) ((f16 * f26) / f19);
                    int i36 = (i16 - i29) / 2;
                    i26 = i36;
                    i19 = 0;
                    i18 = i29 + i36;
                    i17 = i3;
                }
                LibraLogUtil.INSTANCE.i(getLogTag(), RFWLog.USR, option, "[getAutoRegion] left = ", Integer.valueOf(i19), " , top = ", Integer.valueOf(i26), " , right = ", Integer.valueOf(i17), " , bottom = ", Integer.valueOf(i18), " , srcWidth = ", Integer.valueOf(i3), " , srcHeight = ", Integer.valueOf(i16));
                return new Rect(i19, i26, i17, i18);
            }
        }
        i17 = i3;
        i18 = i16;
        i19 = 0;
        i26 = 0;
        LibraLogUtil.INSTANCE.i(getLogTag(), RFWLog.USR, option, "[getAutoRegion] left = ", Integer.valueOf(i19), " , top = ", Integer.valueOf(i26), " , right = ", Integer.valueOf(i17), " , bottom = ", Integer.valueOf(i18), " , srcWidth = ", Integer.valueOf(i3), " , srcHeight = ", Integer.valueOf(i16));
        return new Rect(i19, i26, i17, i18);
    }

    private Rect getDecodeRegion(int i3, int i16, @NonNull Option option) {
        Rect rect;
        if (isAutoRegion(option)) {
            rect = getAutoRegion(i3, i16, option);
        } else {
            int requestLeft = option.getRequestLeft();
            int requestTop = option.getRequestTop();
            rect = new Rect(requestLeft, requestTop, option.getRegionWidth() + requestLeft, option.getRegionHeight() + requestTop);
        }
        if (isRectValid(rect) && rect.left < i3 && rect.top < i16) {
            return rect;
        }
        LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[getDecodeRegion] rect invalid: srcWidth=", Integer.valueOf(i3), ",srcHeight=", Integer.valueOf(i16), ",rect=", rect);
        return new Rect(0, 0, i3, i16);
    }

    private boolean isRectValid(Rect rect) {
        int i3;
        int i16;
        int i17;
        int i18 = rect.left;
        if (i18 >= 0 && (i3 = rect.right) > 0 && (i16 = rect.top) >= 0 && (i17 = rect.bottom) > 0 && i18 < i3 && i16 < i17) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cc, code lost:
    
        if (r4 != 0) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.graphics.BitmapRegionDecoder] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.graphics.BitmapRegionDecoder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap regionDecode(@NonNull BitmapFactory.Options options, @NonNull Option option) {
        InputStream inputStream;
        ?? r46;
        Object th5;
        Bitmap bitmap;
        BitmapRegionDecoder bitmapRegionDecoder;
        try {
            inputStream = h.f118788a.a(option.getModel(), new File(option.getLocalPath()));
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            r46 = 0;
        }
        try {
            r46 = BitmapRegionDecoder.newInstance(inputStream, true);
            try {
            } catch (Throwable th7) {
                th5 = th7;
                bitmap = null;
            }
        } catch (Throwable th8) {
            th = th8;
            r46 = 0;
            th5 = th;
            bitmap = r46;
            try {
                LibraLogUtil.INSTANCE.e(getLogTag(), RFWLog.USR, option, "[regionDecode] Exception e:", th5);
                RFWIOUtil.closeAll(inputStream);
                bitmapRegionDecoder = r46;
            } catch (Throwable th9) {
                RFWIOUtil.closeAll(inputStream);
                if (r46 != 0) {
                    r46.recycle();
                }
                throw th9;
            }
        }
        if (option.getRequestWidth() > 0 && option.getRequestHeight() > 0) {
            updateDecodeMode(options, option);
            int width = r46.getWidth();
            int height = r46.getHeight();
            com.tencent.libra.util.a.f118813a.u(option, width, height);
            updateInSampleSize(width, height, options, option);
            Rect decodeRegion = getDecodeRegion(width, height, option);
            setInBitmap(option, options, width, height);
            bitmap = r46.decodeRegion(decodeRegion, options);
            try {
            } catch (Throwable th10) {
                th5 = th10;
                LibraLogUtil.INSTANCE.e(getLogTag(), RFWLog.USR, option, "[regionDecode] Exception e:", th5);
                RFWIOUtil.closeAll(inputStream);
                bitmapRegionDecoder = r46;
            }
            if (bitmap == null) {
                LibraLogUtil.INSTANCE.i(getLogTag(), RFWLog.USR, option, "[regionDecode] resultBitmap is null");
                RFWIOUtil.closeAll(inputStream);
                r46.recycle();
                return null;
            }
            bitmap = scaleBitmapSize(bitmap, option);
            RFWIOUtil.closeAll(inputStream);
            bitmapRegionDecoder = r46;
            bitmapRegionDecoder.recycle();
            return bitmap;
        }
        LibraLogUtil.INSTANCE.i(getLogTag(), RFWLog.USR, option, "[regionDecode] requestWidth || requestHeight <= 0");
        if (!RFWApplication.isDebug()) {
            RFWIOUtil.closeAll(inputStream);
            if (r46 != 0) {
                r46.recycle();
            }
            return null;
        }
        throw new RegionDecodeException("requestWidth || requestHeight <= 0");
    }

    private Bitmap scaleBitmapSize(@NonNull Bitmap bitmap, @NonNull Option option) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int requestWidth = option.getRequestWidth();
        int requestHeight = option.getRequestHeight();
        float f16 = width;
        float f17 = height;
        float min = Math.min(requestWidth / f16, requestHeight / f17);
        LibraLogUtil.INSTANCE.i(getLogTag(), RFWLog.USR, option, "[scaleBitmapSize] scale = ", Float.valueOf(min), " , bitmapWith", Integer.valueOf(width), " , bitmapHeight", Integer.valueOf(height));
        if (min < 1.0f && requestWidth > 0 && requestHeight > 0 && f16 * min >= 1.0f && f17 * min >= 1.0f) {
            Matrix matrix = new Matrix();
            matrix.postScale(min, min);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return bitmap;
    }

    private void updateDecodeMode(BitmapFactory.Options options, Option option) {
        if (Build.VERSION.SDK_INT < 24) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        } else if (a.f118644a[option.getDecodeFormat().ordinal()] != 1) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        } else {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
    }

    private void updateInSampleSize(int i3, int i16, BitmapFactory.Options options, Option option) {
        if (!isAutoRegion(option)) {
            return;
        }
        ImageView.ScaleType regionScaleType = option.getRegionScaleType();
        int requestWidth = option.getRequestWidth();
        int requestHeight = option.getRequestHeight();
        LibraLogUtil.INSTANCE.i(getLogTag(), RFWLog.USR, option, "[updateInSampleSize] scaleType = ", regionScaleType, " , viewWidth = ", Integer.valueOf(requestWidth), " , viewHeight = ", Integer.valueOf(requestHeight));
        if (requestWidth > 0 && requestHeight > 0) {
            if (regionScaleType == ImageView.ScaleType.CENTER_CROP) {
                options.inSampleSize = RFWImageUtil.calculateInSampleSize(i3, i16, requestWidth, requestHeight);
            } else if (requestWidth / requestHeight > i3 / i16) {
                options.inSampleSize = i16 / requestHeight;
            } else {
                options.inSampleSize = i3 / requestWidth;
            }
        }
    }

    @Override // com.tencent.libra.decode.LibraBaseBitmapDecodeTask
    protected Bitmap decodeBitmap(Option option) {
        Bitmap bitmap;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        BitmapFactory.Options a16 = com.tencent.libra.a.f118582b.a();
        try {
            bitmap = regionDecode(a16, option);
        } catch (OutOfMemoryError unused) {
            System.gc();
            try {
                bitmap = regionDecode(a16, option);
            } catch (OutOfMemoryError e16) {
                System.gc();
                LibraLogUtil.INSTANCE.e(getLogTag(), RFWLog.USR, option, "[decodeBitmap] out of memory e:", e16);
                bitmap = null;
            }
        }
        setPicType(a16);
        LibraLogUtil libraLogUtil = LibraLogUtil.INSTANCE;
        String logTag = getLogTag();
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[10];
        objArr[0] = "[decodeBitmap] useRegionDecode decode cost : ";
        objArr[1] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        objArr[2] = " sampleSize:";
        objArr[3] = Integer.valueOf(a16.inSampleSize);
        objArr[4] = " origin:";
        objArr[5] = Integer.valueOf(a16.outWidth);
        objArr[6] = HippyTKDListViewAdapter.X;
        objArr[7] = Integer.valueOf(a16.outHeight);
        objArr[8] = " result:";
        if (bitmap == null) {
            str = "null";
        } else {
            str = bitmap.getWidth() + " " + bitmap.getHeight();
        }
        objArr[9] = str;
        libraLogUtil.i(logTag, i3, option, objArr);
        com.tencent.libra.a.f118582b.b(a16);
        return rotateDegree(option, bitmap);
    }

    @Override // com.tencent.libra.task.ILibraTask
    public String getLogTag() {
        return TAG;
    }

    public boolean isAutoRegion(@NonNull Option option) {
        if (option.getRegionScaleType() != null) {
            return true;
        }
        return false;
    }
}
