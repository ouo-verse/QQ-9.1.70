package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes19.dex */
public class CarrierImgDownloader extends HttpDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final int CARRIER_IMG_HEIGHT = 70;
    public static final int CARRIER_IMG_WIDTH = 70;
    public static final String PROTOCAL_CARRIER_IMG = "carrier";

    public CarrierImgDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = Math.min(options.outWidth, options.outHeight) / ((int) ((BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density * 70.0f) + 0.5f));
        options.inJustDecodeBounds = false;
        try {
            decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        } catch (OutOfMemoryError unused) {
        }
        return BaseImageUtil.getRoundFaceBitmap(BaseImageUtil.imageCrop(decodeFile), 70, 70);
    }

    @Override // com.tencent.mobileqq.transfile.HttpDownloader, com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        URL url = new URL(downloadParams.url.getFile());
        downloadParams.url = url;
        downloadParams.urlStr = url.toString();
        return super.downloadImage(outputStream, downloadParams, uRLDrawableHandler);
    }
}
