package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

/* loaded from: classes19.dex */
public class ThirdPartAppIconDownloader extends HttpDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String PROTOCOL_THIRD_PART = "third_part";
    private float mDensity;

    public ThirdPartAppIconDownloader(BaseApplicationImpl baseApplicationImpl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl);
            return;
        }
        this.mDensity = 2.0f;
        try {
            this.mDensity = baseApplicationImpl.getResources().getDisplayMetrics().density;
        } catch (Exception unused) {
        }
    }

    public static Bitmap fixImageSize(Bitmap bitmap, double d16, double d17) {
        if (bitmap == null) {
            return null;
        }
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) d16) / width, ((float) d17) / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), null);
        } catch (Exception e16) {
            e16.printStackTrace();
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
        }
        float f16 = this.mDensity;
        Bitmap fixImageSize = fixImageSize(bitmap, f16 * 50.0f, f16 * 50.0f);
        int width = fixImageSize.getWidth();
        int height = fixImageSize.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setDensity(160);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        Rect rect = new Rect(0, 0, width, height);
        RectF rectF = new RectF(rect);
        float f17 = this.mDensity * 10.0f;
        canvas.drawRoundRect(rectF, f17, f17, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(fixImageSize, rect, rect, paint);
        try {
            if (!fixImageSize.isRecycled()) {
                fixImageSize.recycle();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return createBitmap;
    }

    @Override // com.tencent.mobileqq.transfile.HttpDownloader, com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        URL url = downloadParams.url;
        downloadParams.url = new URL("http", url.getAuthority(), url.getFile());
        return super.downloadImage(outputStream, downloadParams, uRLDrawableHandler);
    }
}
