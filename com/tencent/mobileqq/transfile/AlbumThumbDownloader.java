package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.AppVideoDecoder;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.ThumbDecoder;
import com.tencent.mobileqq.activity.photo.VideoDecoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AlbumThumbDownloader extends ProtocolDownloader.Adapter {
    static IPatchRedirector $redirector_ = null;
    public static final String ALBUM_THUMB_APP_VIDEO = "APP_VIDEO";
    public static final String ALBUM_THUMB_DEFAULT = "DEFAULT";
    public static final String ALBUM_THUMB_FLOW_THUMB = "FLOW_THUMB";
    public static final String ALBUM_THUMB_PROTOCAL = "AlbumThumb";
    public static final String ALBUM_THUMB_VIDEO = "VIDEO";
    public static int THUMB_WIDHT;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28071);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            THUMB_WIDHT = 200;
        }
    }

    public AlbumThumbDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        BitmapDecoder thumbDecoder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, this, file, downloadParams, uRLDrawableHandler);
        }
        BaseApplication context = BaseApplication.getContext();
        if (LocalMediaInfo.class.isInstance(downloadParams.tag)) {
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) downloadParams.tag;
            try {
                String ref = downloadParams.url.getRef();
                if ("VIDEO".equals(ref)) {
                    thumbDecoder = new VideoDecoder(context, localMediaInfo);
                } else if ("FLOW_THUMB".equals(ref)) {
                    thumbDecoder = new FlowThumbDecoder(context, localMediaInfo);
                } else if ("APP_VIDEO".equals(ref)) {
                    thumbDecoder = new AppVideoDecoder(context, localMediaInfo);
                } else {
                    thumbDecoder = new ThumbDecoder(context, localMediaInfo);
                }
                Bitmap thumb = AlbumThumbManager.getInstance(context).getThumb(downloadParams.url, thumbDecoder, downloadParams);
                if (thumb != null && localMediaInfo != null) {
                    localMediaInfo.thumbSize = thumb.getByteCount();
                }
                return thumb;
            } catch (NumberFormatException unused) {
                throw new RuntimeException("Decode type is invalid");
            }
        }
        throw new RuntimeException("Decode info is invalide");
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public boolean hasDiskFile(DownloadParams downloadParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler);
        }
        return new File("");
    }
}
