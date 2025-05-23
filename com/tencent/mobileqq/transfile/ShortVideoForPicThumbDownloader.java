package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;

/* loaded from: classes19.dex */
public class ShortVideoForPicThumbDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String PROTOCOL_SHORT_VIDEO_FOR_PIC_THUMB = "shortvideoforpicthumb";
    private static final String TAG = "ShortVideoForPicThumbDownloader";

    public ShortVideoForPicThumbDownloader() {
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
        options.inDensity = 160;
        options.inTargetDensity = 160;
        options.inScreenDensity = 160;
        options.inJustDecodeBounds = false;
        String absolutePath = file.getAbsolutePath();
        if (!FileUtils.fileExistsAndNotEmpty(absolutePath)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "decodeFile file not exits. just return");
                return null;
            }
            return null;
        }
        Bitmap decodeFile = SafeBitmapFactory.decodeFile(file.getAbsolutePath(), options);
        SafeBitmapFactory.decodeFile(absolutePath, options);
        RoundRectBitmap resizeAndClipBitmap = ShortVideoUtils.resizeAndClipBitmap(decodeFile, downloadParams, CommonImgThumbHelper.getThumbWidthHeightDP(false), false);
        if (!decodeFile.equals(resizeAndClipBitmap.mBitmap)) {
            decodeFile.recycle();
        }
        RoundRectBitmap roundRectBitmap = new RoundRectBitmap(((IPicUtil) QRoute.api(IPicUtil.class)).getExifBitmap(file.getAbsolutePath(), resizeAndClipBitmap.mBitmap), resizeAndClipBitmap.mCornerRadius, resizeAndClipBitmap.mBoardColor, resizeAndClipBitmap.mBorderWidth);
        roundRectBitmap.mDisplayWidth = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
        roundRectBitmap.mDisplayHeight = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().heightPixels;
        return roundRectBitmap;
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
