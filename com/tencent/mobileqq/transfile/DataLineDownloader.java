package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes19.dex */
public class DataLineDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "_dataline_file";
    protected BaseApplicationImpl application;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class DatalineDownLoadInfo {
        static IPatchRedirector $redirector_;
        public boolean isDrawRound;
        public LocalMediaInfo photoInfo;

        DatalineDownLoadInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class VideoBitmapDecoder implements BitmapDecoder {
        static IPatchRedirector $redirector_;
        public DatalineDownLoadInfo downloadInfo;

        VideoBitmapDecoder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataLineDownloader.this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder
        public Bitmap getBitmap(URL url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
            }
            DatalineDownLoadInfo parseUrl = DataLineDownloader.this.parseUrl(url);
            this.downloadInfo = parseUrl;
            return DataLineDownloader.this.makeThumb(parseUrl);
        }
    }

    public DataLineDownloader(BaseApplicationImpl baseApplicationImpl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl);
        } else {
            this.application = baseApplicationImpl;
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, options, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (i3 != 0 && i16 != 0 && i3 != -1 && i16 != -1) {
            int i18 = options.outHeight;
            int i19 = options.outWidth;
            while (i18 > i16 && i19 > i3) {
                int round = Math.round(i18 / i16);
                int round2 = Math.round(i19 / i3);
                if (round >= round2) {
                    round = round2;
                }
                if (round < 2) {
                    break;
                }
                i19 /= 2;
                i18 /= 2;
                i17 *= 2;
            }
            return i17;
        }
        if (options.outWidth * options.outHeight <= 5000000) {
            return 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "calculateInSampleSize options.outWidth*options.outHeight=" + (options.outWidth * options.outHeight));
        }
        return 2;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, this, file, downloadParams, uRLDrawableHandler);
        }
        try {
            Bitmap bitmap = new VideoBitmapDecoder().getBitmap(downloadParams.url);
            if (bitmap != null) {
                Bitmap round = BaseImageUtil.round(bitmap, BaseAIOUtils.f(12.0f, BaseApplication.getContext().getResources()));
                bitmap.recycle();
                return round;
            }
            throw new IOException("step:decode error, not valid pic");
        } catch (OutOfMemoryError e16) {
            throw e16;
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        DatalineDownLoadInfo parseUrl = parseUrl(downloadParams.url);
        if (parseUrl != null) {
            return new File(parseUrl.photoInfo.path);
        }
        return new File(AppConstants.SDCARD_ROOT);
    }

    Bitmap makeThumb(DatalineDownLoadInfo datalineDownLoadInfo) {
        int i3;
        if (datalineDownLoadInfo == null) {
            return null;
        }
        LocalMediaInfo localMediaInfo = datalineDownLoadInfo.photoInfo;
        int i16 = localMediaInfo.thumbWidth;
        int i17 = localMediaInfo.thumbHeight;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inDensity = 160;
            options.inTargetDensity = 160;
            options.inScreenDensity = 160;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(datalineDownLoadInfo.photoInfo.path, options);
            int i18 = 0;
            options.inJustDecodeBounds = false;
            options.inSampleSize = calculateInSampleSize(options, i16, i17);
            Bitmap m3 = FilePicURLDrawlableHelper.m(datalineDownLoadInfo.photoInfo.path, options);
            int f16 = BaseAIOUtils.f(135.0f, BaseApplication.getContext().getResources());
            int i19 = options.outHeight;
            float f17 = i19;
            int i26 = options.outWidth;
            if (f17 > i26 * 2.0f) {
                i3 = (int) ((i19 - (i26 * 2.0f)) / 2.0f);
                options.outHeight = (int) (i26 * 2.0f);
            } else if (i26 > i19 * 2.0f) {
                int i27 = (int) ((i26 - (i19 * 2.0f)) / 2.0f);
                options.outWidth = (int) (i19 * 2.0f);
                i3 = 0;
                i18 = i27;
            } else {
                i3 = 0;
            }
            Bitmap createBitmap = Bitmap.createBitmap(m3, i18, i3, options.outWidth, options.outHeight);
            if (options.outWidth > f16 || options.outHeight > f16) {
                createBitmap = BaseImageUtil.scaleBitmap(createBitmap, f16);
            }
            if (createBitmap != null) {
                return ((IPicUtil) QRoute.api(IPicUtil.class)).getExifBitmap(datalineDownLoadInfo.photoInfo.path, createBitmap);
            }
            return createBitmap;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "make Thumb ", e16);
            }
            return null;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "make Thumb OOM ", e17);
            }
            return null;
        }
    }

    public DatalineDownLoadInfo parseUrl(URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (DatalineDownLoadInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) url);
        }
        try {
            DatalineDownLoadInfo datalineDownLoadInfo = new DatalineDownLoadInfo();
            String[] split = url.getFile().split("\\|");
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            datalineDownLoadInfo.photoInfo = localMediaInfo;
            localMediaInfo.path = split[0];
            localMediaInfo.thumbWidth = Integer.parseInt(split[1]);
            datalineDownLoadInfo.photoInfo.thumbHeight = Integer.parseInt(split[2]);
            datalineDownLoadInfo.photoInfo.modifiedDate = Long.parseLong(split[3]);
            datalineDownLoadInfo.isDrawRound = Boolean.parseBoolean(split[4]);
            return datalineDownLoadInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }
}
