package com.tencent.mobileqq.transfile;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes19.dex */
public class VideoThumbDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    private static final String FILE_URL_PREFIX = "file://";
    private static final String[] PROJECTION_VIDEO;
    private static final int THUMBNAIL_KIND = 1;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static class VersionCodes {
        static IPatchRedirector $redirector_ = null;
        public static final int ECLAIR = 5;
        public static final int FROYO = 8;

        VersionCodes() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class VideoBitmapCreator implements BitmapDecoder {
        static IPatchRedirector $redirector_;

        VideoBitmapCreator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoThumbDownloader.this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder
        public Bitmap getBitmap(URL url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
            }
            String path = url.getPath();
            try {
                Bitmap createVideoThumbnail = VideoThumbDownloader.this.createVideoThumbnail(path);
                if (createVideoThumbnail == null) {
                    return VideoThumbDownloader.this.queryVideoThumbnail(path);
                }
                return createVideoThumbnail;
            } catch (Throwable th5) {
                QLog.e("VIdeoThumbDownloader", 2, "getBitmap", th5);
                return null;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76042);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            PROJECTION_VIDEO = new String[]{"DISTINCT _id", "_data"};
        }
    }

    public VideoThumbDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public Bitmap createVideoThumbnail(String str) {
        return ThumbnailUtils.createVideoThumbnail(str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap queryVideoThumbnail(String str) {
        Throwable th5;
        Cursor cursor;
        Bitmap bitmap = null;
        try {
            cursor = queryVideoCursor(str);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        long j3 = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                        if (cursor.moveToFirst()) {
                            bitmap = MediaStore.Video.Thumbnails.getThumbnail(BaseApplication.getContext().getContentResolver(), j3, 1, null);
                        }
                    }
                } catch (Throwable th6) {
                    th5 = th6;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th5;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return bitmap;
        } catch (Throwable th7) {
            th5 = th7;
            cursor = null;
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, this, file, downloadParams, uRLDrawableHandler);
        }
        return AlbumThumbManager.getInstance(BaseApplication.getContext()).getThumb(downloadParams.url, new VideoBitmapCreator());
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        return new File(AppConstants.SDCARD_ROOT);
    }

    public Cursor queryVideoCursor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Cursor) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PROJECTION_VIDEO, "_data='" + DeviceMsgThumbDownloader.processPath(str) + "' COLLATE NOCASE", null, null);
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }
}
