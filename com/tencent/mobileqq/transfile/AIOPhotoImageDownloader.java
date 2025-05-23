package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* loaded from: classes19.dex */
public class AIOPhotoImageDownloader extends ChatImageDownloader {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AIOPhotoImageDownloader";

    public AIOPhotoImageDownloader(BaseApplication baseApplication) {
        super(baseApplication);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplication);
        }
    }

    @Override // com.tencent.mobileqq.transfile.ChatImageDownloader, com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        try {
            uRLDrawableHandler.publishProgress(9900);
            String str = downloadParams.urlStr;
            boolean equals = ProtocolDownloaderConstants.PROTOCOL_AIO_THUMB.equals(downloadParams.url.getProtocol());
            if (QLog.isColorLevel()) {
                ChatImageDownloader.log(TAG, "DecodeFile", "DecodeFile START,cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str);
            }
            if (GifDrawable.isGifFile(file) && !equals) {
                if (QLog.isColorLevel()) {
                    ChatImageDownloader.log(TAG, "DecodeFile", "DecodeFile END,GIF image,cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str);
                }
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inDensity = 160;
            options.inTargetDensity = 160;
            options.inScreenDensity = 160;
            if (equals) {
                try {
                    options.inJustDecodeBounds = false;
                    Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                    if (decodeFile != null) {
                        return new ExifBitmapCreator(file.getAbsolutePath()).creatBitmap(decodeFile);
                    }
                    file.delete();
                    throw new IOException("step:decode error, not valid pic");
                } catch (OutOfMemoryError e16) {
                    throw e16;
                }
            }
            if (QLog.isColorLevel()) {
                ChatImageDownloader.log(TAG, "DecodeFile", "DecodeFile END,is not Thumb,cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str);
            }
            return null;
        } catch (Exception e17) {
            String exceptionMessage = ProcessorReport.getExceptionMessage(e17);
            if (exceptionMessage == null || exceptionMessage.length() == 0) {
                exceptionMessage = e17.toString();
            }
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, exceptionMessage);
                ChatImageDownloader.log(TAG, "DecodeFile", "DecodeFile FAIL,exceptionmsg:" + exceptionMessage);
            }
            throw e17;
        }
    }

    public String getUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return AbsDownloader.covertUrlForAioImage(str);
    }
}
