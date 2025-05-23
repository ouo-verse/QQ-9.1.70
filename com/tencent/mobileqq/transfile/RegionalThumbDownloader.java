package com.tencent.mobileqq.transfile;

import android.app.Application;
import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RegionalThumbDownloader extends ProtocolDownloader.Adapter {
    static IPatchRedirector $redirector_;

    public RegionalThumbDownloader(Application application) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) application);
        }
    }

    public static URL generateURL(String str, int i3, int i16) {
        return generateURL(str, i3, i16, false);
    }

    public static URL generateURLForNew(String str, int i3, int i16) {
        return generateURL(str, i3, i16, true);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        BitmapDecoder iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, this, file, downloadParams, uRLDrawableHandler);
        }
        LocalMediaInfo parseUrl = LocalMediaInfo.parseUrl(downloadParams.url);
        if (parseUrl != null) {
            if (parseUrl.isRegionThumbUseNewDecoder) {
                iVar = new com.tencent.mobileqq.activity.photo.b();
            } else {
                iVar = new i();
            }
            Bitmap bitmap = iVar.getBitmap(downloadParams.url);
            if (bitmap != null) {
                downloadParams.outWidth = bitmap.getWidth();
                downloadParams.outHeight = bitmap.getHeight();
                return bitmap;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public boolean hasDiskFile(DownloadParams downloadParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams)).booleanValue();
        }
        LocalMediaInfo parseUrl = LocalMediaInfo.parseUrl(downloadParams.url);
        if (parseUrl != null && new File(parseUrl.path).exists()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler);
        }
        LocalMediaInfo parseUrl = LocalMediaInfo.parseUrl(downloadParams.url);
        if (parseUrl != null) {
            File file = new File(parseUrl.path);
            if (file.exists()) {
                return file;
            }
            return null;
        }
        return null;
    }

    public static URL generateURL(String str, int i3, int i16, boolean z16) {
        if (str == null) {
            return null;
        }
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = str;
        File file = new File(str);
        if (file.exists()) {
            localMediaInfo.modifiedDate = file.lastModified();
        }
        localMediaInfo.thumbWidth = i3;
        localMediaInfo.thumbHeight = i16;
        localMediaInfo.isRegionThumbUseNewDecoder = z16;
        try {
            return new URL(ProtocolDownloaderConstants.PROTOCOL_REGIONAL_THUMB, (String) null, LocalMediaInfo.getUrl(localMediaInfo));
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}
