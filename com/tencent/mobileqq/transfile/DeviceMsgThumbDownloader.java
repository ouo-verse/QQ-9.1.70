package com.tencent.mobileqq.transfile;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes19.dex */
public class DeviceMsgThumbDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    private static final String FILE_URL_PREFIX = "file://";
    private static final String[] PROJECTION_VIDEO;
    public static final String PROTOCOL_DEVICE_MSG_THUMB = "devicemsgthumb";
    private static final String TAG = "DeviceMsgThumbDownloader";
    private static final int THUMBNAIL_KIND = 1;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class DeviceImgBitmapDecoder implements BitmapDecoder {
        static IPatchRedirector $redirector_;

        DeviceImgBitmapDecoder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DeviceMsgThumbDownloader.this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder
        public Bitmap getBitmap(URL url) {
            Bitmap bitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
            }
            LocalMediaInfo parseUrl = DeviceMsgThumbDownloader.this.parseUrl(url);
            if (parseUrl == null) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = 160;
            options.inTargetDensity = 160;
            options.inScreenDensity = 160;
            try {
                bitmap = BitmapFactory.decodeFile(parseUrl.path, options);
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("VIdeoThumbDownloader", 2, "DeviceImgBitmapDecoder getBitmap", e16);
                }
                bitmap = null;
            }
            if (bitmap == null) {
                return null;
            }
            return ThumbnailUtils.extractThumbnail(bitmap, parseUrl.thumbWidth, parseUrl.thumbHeight, 2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class DeviceVideoBitmapDecoder implements BitmapDecoder {
        static IPatchRedirector $redirector_;

        DeviceVideoBitmapDecoder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DeviceMsgThumbDownloader.this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder
        public Bitmap getBitmap(URL url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
            }
            LocalMediaInfo parseUrl = DeviceMsgThumbDownloader.this.parseUrl(url);
            if (parseUrl == null) {
                return null;
            }
            String str = parseUrl.path;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                Bitmap createVideoThumbnail = DeviceMsgThumbDownloader.this.createVideoThumbnail(str);
                if (createVideoThumbnail == null) {
                    return DeviceMsgThumbDownloader.this.queryVideoThumbnail(str);
                }
                return createVideoThumbnail;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("VIdeoThumbDownloader", 2, "getBitmap", th5);
                }
                return null;
            }
        }
    }

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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75953);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            PROJECTION_VIDEO = new String[]{"DISTINCT _id", "_data"};
        }
    }

    public DeviceMsgThumbDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static URL getUrl(String str, int i3, int i16, String str2) {
        try {
            return new URL(PROTOCOL_DEVICE_MSG_THUMB, "", str + "|" + i3 + "|" + i16 + "|" + str2);
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16.getMessage(), e16);
            }
            return null;
        }
    }

    public static String processPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(FILE_URL_PREFIX)) {
            str = str.substring(7);
        }
        String str2 = File.separator;
        if (!str.startsWith(str2)) {
            return str2 + str;
        }
        return str;
    }

    @SuppressLint({"NewApi"})
    public Bitmap createVideoThumbnail(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return ThumbnailUtils.createVideoThumbnail(str, 1);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        BitmapDecoder deviceImgBitmapDecoder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        LocalMediaInfo parseUrl = parseUrl(downloadParams.url);
        if (parseUrl == null) {
            return null;
        }
        if (!FileUtils.fileExistsAndNotEmpty(parseUrl.path)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "decodeFile file not exits. just return");
            }
            return null;
        }
        BaseApplication context = BaseApplication.getContext();
        if (FileManagerUtil.getFileType(parseUrl.path) == 2) {
            deviceImgBitmapDecoder = new DeviceVideoBitmapDecoder();
        } else {
            deviceImgBitmapDecoder = new DeviceImgBitmapDecoder();
        }
        return AlbumThumbManager.getInstance(context).getThumb(downloadParams.url, deviceImgBitmapDecoder);
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        return new File(AppConstants.SDCARD_ROOT);
    }

    public LocalMediaInfo parseUrl(URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) url);
        }
        try {
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            String[] split = url.getFile().split("\\|");
            localMediaInfo.path = split[0];
            localMediaInfo.thumbWidth = Integer.parseInt(split[1]);
            localMediaInfo.thumbHeight = Integer.parseInt(split[2]);
            return localMediaInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    public Cursor queryVideoCursor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Cursor) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        return ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PROJECTION_VIDEO, "_data='" + processPath(str) + "' COLLATE NOCASE", null, null);
    }

    public Bitmap queryVideoThumbnail(String str) {
        Throwable th5;
        Cursor cursor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
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

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
