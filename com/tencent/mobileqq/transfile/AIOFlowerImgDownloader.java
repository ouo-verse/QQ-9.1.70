package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AIOFlowerImgDownloader extends HttpDownloader {
    static IPatchRedirector $redirector_;

    public AIOFlowerImgDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        float density = getDensity();
        options.inSampleSize = (int) Math.min(options.outWidth / ((115.0f * density) + 0.5f), options.outHeight / ((105.0f * density) + 0.5f));
        options.inJustDecodeBounds = false;
        Bitmap bitmap2 = null;
        try {
            bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        } catch (OutOfMemoryError unused) {
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        try {
            bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmap2.setDensity(160);
            Canvas canvas = new Canvas(bitmap2);
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            Rect rect = new Rect(0, 0, width, height - ((int) (density * 5.0f)));
            canvas.drawBitmap(bitmap, rect, new RectF(rect), paint);
        } catch (OutOfMemoryError unused2) {
        }
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    @Override // com.tencent.mobileqq.transfile.HttpDownloader, com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        URL url = downloadParams.url;
        String str = downloadParams.urlStr;
        URL url2 = new URL(downloadParams.url.getFile());
        downloadParams.url = url2;
        downloadParams.urlStr = url2.toString();
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOFlowerImgDownloader", 4, downloadParams.urlStr);
        }
        File downloadImage = super.downloadImage(outputStream, downloadParams, uRLDrawableHandler);
        downloadParams.url = url;
        downloadParams.urlStr = str;
        return downloadImage;
    }

    float getDensity() {
        return BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    }
}
