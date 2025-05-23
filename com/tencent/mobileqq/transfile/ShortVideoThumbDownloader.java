package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ShortVideoThumbDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String PROTOCOL_SHORT_VIDEO_THUMB = "shortvideothumb";
    private static final String TAG = "ShortVideoThumbDownloader";

    public ShortVideoThumbDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int i3) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            createBitmap.setDensity(160);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
            float f16 = i3;
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-16777216);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
            return createBitmap;
        } catch (Exception unused) {
            return bitmap;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        BufferedInputStream bufferedInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        String absolutePath = file.getAbsolutePath();
        BufferedInputStream bufferedInputStream2 = null;
        if (!FileUtils.fileExistsAndNotEmpty(absolutePath)) {
            QLog.i(TAG, 2, "decodeFile file not exits. just return");
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 160;
        options.inTargetDensity = 160;
        options.inScreenDensity = 160;
        options.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(absolutePath, options);
        options.inJustDecodeBounds = false;
        ?? calculateSampleSize = calculateSampleSize(options, downloadParams.reqWidth, downloadParams.reqHeight);
        options.inSampleSize = calculateSampleSize;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(absolutePath));
            } catch (OutOfMemoryError e16) {
                e = e16;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedInputStream2 != null) {
                }
                throw th;
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                Object obj = downloadParams.tag;
                if ((obj instanceof int[]) && ((int[]) obj).length == 3) {
                    decodeStream = getRoundedCornerBitmap(decodeStream, ((int[]) obj)[2]);
                }
                bufferedInputStream.close();
                return decodeStream;
            } catch (OutOfMemoryError e17) {
                e = e17;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "decodeFile : OutOfMemoryError ", e);
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream2 = calculateSampleSize;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        return new File(downloadParams.url.getFile());
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
