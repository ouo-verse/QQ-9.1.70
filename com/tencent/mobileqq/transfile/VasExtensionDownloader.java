package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.JobQueue;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.NativeGifImage;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.e;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.h;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteLottieEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class VasExtensionDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "VasExtensionDownloader";
    protected MobileQQ application;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class ThumbGifImage extends NativeGifImage {
        static IPatchRedirector $redirector_;

        public ThumbGifImage(File file, boolean z16, float f16) throws IOException {
            super(file, z16, true, 0, 0, f16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VasExtensionDownloader.this, file, Boolean.valueOf(z16), Float.valueOf(f16));
            }
        }

        @Override // com.tencent.image.NativeGifImage, com.tencent.image.AbstractGifImage
        public void draw(Canvas canvas, Rect rect, Paint paint, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, canvas, rect, paint, Boolean.valueOf(z16));
                return;
            }
            try {
                super.draw(canvas, rect, paint, z16);
            } catch (Throwable th5) {
                QLog.e(NativeGifImage.TAG, 1, "[ThumbGifImage] draw error! stack=", th5);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.image.NativeGifImage, com.tencent.image.AbstractGifImage
        public void executeNewTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                if (h.b() && this.mCurrentFrameIndex >= 1) {
                    return;
                }
                super.executeNewTask();
            }
        }
    }

    public VasExtensionDownloader(MobileQQ mobileQQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileQQ);
        } else {
            this.application = mobileQQ;
        }
    }

    @Nullable
    private Object decodeFileBusinessDrainage(File file) throws FileNotFoundException {
        if (file == null) {
            QLog.e(TAG, 1, "decodeFile commercial drainage send pic f is null");
            return null;
        }
        String absolutePath = file.getAbsolutePath();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "decodeFile commercial drainage send pic fileName = " + absolutePath);
        }
        FileInputStream fileInputStream = new FileInputStream(absolutePath);
        try {
            Bitmap decodeStream = SafeBitmapFactory.decodeStream(new BufferedInputStream(fileInputStream));
            try {
                fileInputStream.close();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "decodeFile commercial drainage send pic decode io close exception e = " + e16.getMessage());
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(decodeStream.getWidth(), decodeStream.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, decodeStream.getWidth(), decodeStream.getHeight());
                RectF rectF = new RectF(new Rect(0, 0, decodeStream.getWidth(), decodeStream.getHeight()));
                paint.setAntiAlias(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(-16777216);
                canvas.drawRoundRect(rectF, 4.0f, 4.0f, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(decodeStream, new Rect(0, 0, decodeStream.getWidth(), decodeStream.getHeight()), rect, paint);
                return createBitmap;
            } catch (Exception e17) {
                QLog.e(TAG, 1, "decode BUSINESS_COMMERCIAL_DRAINAGE exception e = ", e17);
                return decodeStream;
            }
        } catch (Exception e18) {
            QLog.e(TAG, 1, "decodeFile commercial drainage send pic decode exception e = " + e18.getMessage());
            return null;
        }
    }

    @Nullable
    private Object decodeFileBusinessEmoDiy(DownloadParams downloadParams) {
        String file;
        Bitmap bitmap;
        try {
            file = downloadParams.url.getFile();
        } catch (FileNotFoundException e16) {
            QLog.e(TAG, 1, "decode MARKET File", e16);
        } catch (IOException e17) {
            QLog.e(TAG, 1, "decode MARKET File", e17);
        } catch (Exception e18) {
            QLog.e(TAG, 1, "decode MARKET File", e18);
        }
        if (e.B(file)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "decodeFile isGifFile,path=" + file);
            }
            return NativeGifFactory.getNativeGifObject(new File(file), true, true, 0, 0, 0.0f);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "decodeFile getDecryptFileData,path=" + file);
        }
        byte[] q16 = e.q(file);
        if (q16 != null) {
            try {
                bitmap = BitmapFactory.decodeByteArray(q16, 0, q16.length, null);
            } catch (OutOfMemoryError unused) {
                QLog.e("emoticon", 1, "decode oom path = " + file);
                bitmap = null;
            }
            if (bitmap == null) {
                QLog.e(TAG, 2, "decode MARKET File:file error" + file);
                return null;
            }
            return bitmap;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c1 A[Catch: Exception -> 0x0168, TryCatch #1 {Exception -> 0x0168, blocks: (B:10:0x002f, B:12:0x0035, B:14:0x003b, B:15:0x0050, B:17:0x0058, B:19:0x005e, B:20:0x007e, B:25:0x00a5, B:27:0x00c1, B:29:0x00e4, B:32:0x00e9, B:34:0x00ef, B:35:0x00f5, B:36:0x00f8, B:38:0x0109, B:40:0x0112, B:42:0x011b, B:44:0x0134, B:45:0x0145, B:47:0x014f, B:50:0x013d, B:60:0x0164, B:61:0x0167, B:55:0x00bb), top: B:9:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0112 A[Catch: Exception -> 0x0168, TryCatch #1 {Exception -> 0x0168, blocks: (B:10:0x002f, B:12:0x0035, B:14:0x003b, B:15:0x0050, B:17:0x0058, B:19:0x005e, B:20:0x007e, B:25:0x00a5, B:27:0x00c1, B:29:0x00e4, B:32:0x00e9, B:34:0x00ef, B:35:0x00f5, B:36:0x00f8, B:38:0x0109, B:40:0x0112, B:42:0x011b, B:44:0x0134, B:45:0x0145, B:47:0x014f, B:50:0x013d, B:60:0x0164, B:61:0x0167, B:55:0x00bb), top: B:9:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011b A[Catch: Exception -> 0x0168, TryCatch #1 {Exception -> 0x0168, blocks: (B:10:0x002f, B:12:0x0035, B:14:0x003b, B:15:0x0050, B:17:0x0058, B:19:0x005e, B:20:0x007e, B:25:0x00a5, B:27:0x00c1, B:29:0x00e4, B:32:0x00e9, B:34:0x00ef, B:35:0x00f5, B:36:0x00f8, B:38:0x0109, B:40:0x0112, B:42:0x011b, B:44:0x0134, B:45:0x0145, B:47:0x014f, B:50:0x013d, B:60:0x0164, B:61:0x0167, B:55:0x00bb), top: B:9:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0164 A[Catch: Exception -> 0x0168, TryCatch #1 {Exception -> 0x0168, blocks: (B:10:0x002f, B:12:0x0035, B:14:0x003b, B:15:0x0050, B:17:0x0058, B:19:0x005e, B:20:0x007e, B:25:0x00a5, B:27:0x00c1, B:29:0x00e4, B:32:0x00e9, B:34:0x00ef, B:35:0x00f5, B:36:0x00f8, B:38:0x0109, B:40:0x0112, B:42:0x011b, B:44:0x0134, B:45:0x0145, B:47:0x014f, B:50:0x013d, B:60:0x0164, B:61:0x0167, B:55:0x00bb), top: B:9:0x002f }] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object decodeFileBusinessFavorite(DownloadParams downloadParams, String str) {
        FileInputStream fileInputStream;
        Bitmap bitmap;
        Object obj = downloadParams.tag;
        if (!(obj instanceof LocalMediaInfo)) {
            QLog.e(TAG, 1, "decode favorite panel thumb error, tag error ,url = " + downloadParams.url);
            return null;
        }
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
        if (localMediaInfo != null) {
            String str2 = localMediaInfo.path;
            File file = new File(str2);
            try {
                if (GifDrawable.isGifFile(file)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "decodeFile isGifFile,path=" + str2);
                    }
                    return new ThumbGifImage(file, true, downloadParams.mGifRoundCorner);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "decodeFile is not gifFile,path=" + str2 + ",HARDWARE:" + Build.HARDWARE);
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                SafeBitmapFactory.decodeFile(localMediaInfo.path, options);
                options.inSampleSize = BaseImageUtil.calculateInSampleSize(options, localMediaInfo.thumbWidth, localMediaInfo.thumbHeight);
                options.inJustDecodeBounds = false;
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
                try {
                    try {
                        bitmap = SafeBitmapFactory.decodeStream(new BufferedInputStream(fileInputStream), null, options);
                        fileInputStream.close();
                    } catch (Throwable th6) {
                        th = th6;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                    QLog.e(TAG, 2, e, new Object[0]);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (!VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB_NEW.equals(str)) {
                    }
                }
                if (bitmap == null) {
                    QLog.e(TAG, 2, "decode favorite panel thumb bitmap return null,url = " + downloadParams.url);
                    j.a aVar = new j.a();
                    j.e(str2, options, aVar);
                    int i3 = aVar.f306779b;
                    if (i3 == 0 && aVar.f306778a != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "decode favorite panel thumb bitmap second time success.");
                        }
                        bitmap = aVar.f306778a;
                    }
                    QLog.e(TAG, 1, "decode favorite panel thumb bitmap second time failed. result = ", Integer.valueOf(i3));
                    return null;
                }
                if (!VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB_NEW.equals(str)) {
                    return zoomBitmap(bitmap, localMediaInfo.thumbWidth, localMediaInfo.thumbHeight);
                }
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Rect rect = new Rect();
                int i16 = localMediaInfo.thumbWidth;
                RectF rectF = new RectF(0.0f, 0.0f, i16, i16);
                if (width > height) {
                    int i17 = (width - height) / 2;
                    rect.set(i17, 0, i17 + height, height + 0);
                } else {
                    int i18 = (height - width) / 2;
                    rect.set(0, i18, width + 0, width + i18);
                }
                int i19 = localMediaInfo.thumbWidth;
                Bitmap createBitmap = Bitmap.createBitmap(i19, i19, Bitmap.Config.ARGB_8888);
                if (createBitmap != null) {
                    new Canvas(createBitmap).drawBitmap(bitmap, rect, rectF, new Paint(6));
                    bitmap.recycle();
                    return createBitmap;
                }
                return bitmap;
            } catch (Exception e18) {
                QLog.e(TAG, 2, "decode favorite panel thumb bitmap exception,url = " + downloadParams.url, e18);
                return null;
            }
        }
        QLog.e(TAG, 1, "decode favorite panel thumb error, thumbinfo is null ,url = " + downloadParams.url);
        return null;
    }

    private Object decodeFileBusinessFontBubble(File file, DownloadParams downloadParams) {
        if (GifDrawable.isGifFile(file)) {
            return NativeGifFactory.getNativeGifObject(file, false, false, downloadParams.reqWidth, downloadParams.reqHeight, 0.0f);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i3 = this.application.getResources().getDisplayMetrics().densityDpi;
        options.inTargetDensity = i3;
        options.inDensity = Math.max(i3, 320);
        return j.d(file.getAbsolutePath(), options);
    }

    @Nullable
    private Object decodeFileBusinessRedPacketPic(File file) throws FileNotFoundException {
        if (file == null) {
            QLog.e(TAG, 1, "decodeFile redpacket send pic f is null");
            return null;
        }
        String absolutePath = file.getAbsolutePath();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "decodeFile redpacket send pic fileName = " + absolutePath);
        }
        FileInputStream fileInputStream = new FileInputStream(absolutePath);
        try {
            Bitmap decodeStream = SafeBitmapFactory.decodeStream(new BufferedInputStream(fileInputStream));
            try {
                fileInputStream.close();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "decodeFile redpacket send pic decode io close exception e = " + e16.getMessage());
            }
            return decodeStream;
        } catch (Exception e17) {
            QLog.e(TAG, 1, "decodeFile redpacket send pic decode exception e = " + e17.getMessage());
            return null;
        }
    }

    @Nullable
    private Object decodeFileBusinessResImg(DownloadParams downloadParams) {
        String file = downloadParams.url.getFile();
        if (file.startsWith("/")) {
            file = file.substring(1, file.length());
        }
        if (TextUtils.isEmpty(file)) {
            QLog.e(TAG, 1, "decodeFile res is null ");
            return null;
        }
        try {
            return BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), Integer.valueOf(file).intValue());
        } catch (Resources.NotFoundException unused) {
            QLog.e(TAG, 1, "decodeFile res not fontexcetpion ;res = " + file);
            return null;
        } catch (NumberFormatException unused2) {
            QLog.e(TAG, 1, "decodeFile resid number exception res = " + file);
            return null;
        } catch (OutOfMemoryError unused3) {
            QLog.e(TAG, 1, "decodeFile res OutOfMemoryError ;res = " + file);
            return null;
        }
    }

    @Nullable
    private Object decodeFileSiteImage(File file, String str) throws FileNotFoundException {
        if (file == null) {
            QLog.e(TAG, 1, "decodeFile comic_ip_site send pic f is null");
            return null;
        }
        String absolutePath = file.getAbsolutePath();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "decodeFile comic_ip_site send pic fileName = " + absolutePath);
        }
        FileInputStream fileInputStream = new FileInputStream(absolutePath);
        try {
            Bitmap decodeStream = SafeBitmapFactory.decodeStream(new BufferedInputStream(fileInputStream));
            try {
                fileInputStream.close();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "decodeFile comic_ip_site send pic decode io close exception e = " + e16.getMessage());
            }
            if (VasExtensionDownloaderConstant.COMIC_IP_SITE_ROUND_IMAGE.equals(str)) {
                return toRoundBitmap(decodeStream);
            }
            if (VasExtensionDownloaderConstant.COMIC_IPSITE_GAME_IMAGE.equals(str)) {
                return toRoundBitmap(decodeStream, true);
            }
            return decodeStream;
        } catch (Exception e17) {
            QLog.e(TAG, 1, "decodeFile ccomic_ip_site send pic decode exception e = " + e17.getMessage());
            return null;
        }
    }

    @Nullable
    private File downloadCameraThumb(DownloadParams downloadParams, String str, String str2) throws MalformedURLException {
        String str3;
        File localFile = getLocalFile(str2);
        if (localFile != null) {
            return localFile;
        }
        Object obj = downloadParams.mExtraInfo;
        if (obj instanceof CameraEmoticonInfo) {
            str3 = ((CameraEmoticonInfo) obj).url;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("File path %s is not exits, now need download %s", str2, str3));
            }
        } else {
            str2 = null;
            str3 = null;
        }
        return realDownloadFile(downloadParams, str, str3, str2);
    }

    @Nullable
    private File downloadDynamicImage(DownloadParams downloadParams, String str, String str2) throws MalformedURLException {
        String str3;
        File localFile = getLocalFile(str2);
        if (localFile != null) {
            return localFile;
        }
        Object obj = downloadParams.mExtraInfo;
        if (obj instanceof FavoriteEmoticonInfo) {
            str3 = ((FavoriteEmoticonInfo) obj).url;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("File path %s is not exits, now need download %s", str2, str3));
            }
        } else if (obj instanceof CameraEmoticonInfo) {
            str3 = ((CameraEmoticonInfo) obj).url;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("File path %s is not exits, now need download %s", str2, str3));
            }
        } else if (obj instanceof String) {
            str3 = (String) obj;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("File path %s is not exits, now need download %s", str2, str3));
            }
        } else {
            QLog.e(TAG, 1, "[downloadDynamicImage] failed. epId=", str2);
            return null;
        }
        return realDownloadFile(downloadParams, str, str3, str2);
    }

    @Nullable
    private File downloadFavoriteImage(DownloadParams downloadParams, String str, String str2) throws MalformedURLException {
        String str3;
        File localFile = getLocalFile(str2);
        if (localFile != null) {
            return localFile;
        }
        Object obj = downloadParams.mExtraInfo;
        if (obj instanceof FavoriteEmoticonInfo) {
            str3 = ((FavoriteEmoticonInfo) obj).url;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("File path %s is not exits, now need download %s", str2, str3));
            }
        } else {
            str2 = null;
            str3 = null;
        }
        return realDownloadFile(downloadParams, str, str3, str2);
    }

    private File downloadFile(String str, DownloadParams downloadParams) {
        String substring;
        URL url = downloadParams.url;
        if (url != null && !TextUtils.isEmpty(url.getFile())) {
            String file = downloadParams.url.getFile();
            if (file.startsWith("/")) {
                file = file.substring(1, file.length());
            }
            String md5 = MD5.toMD5(file);
            StringBuilder sb5 = new StringBuilder();
            String str2 = File.separator;
            sb5.append(str2);
            if (TextUtils.isEmpty(md5)) {
                substring = "null";
            } else {
                substring = md5.substring(0, 2);
            }
            sb5.append(substring);
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + str + sb5.toString() + str2 + md5);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, str + " save local filePath: " + sDKPrivatePath);
            }
            File file2 = new File(sDKPrivatePath);
            if (file2.exists()) {
                return file2;
            }
            g gVar = new g(file, file2);
            gVar.B = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
            if (((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, MobileQQ.sMobileQQ.waitAppRuntime(null)) == 0) {
                return file2;
            }
        }
        return null;
    }

    @Nullable
    private File downloadFromEmoticonTab(DownloadParams downloadParams, String str, String str2) throws MalformedURLException {
        String n3;
        String p16;
        String str3 = null;
        if (downloadParams.mExtraInfo == null || str2 == null) {
            return null;
        }
        if (str2.startsWith("/")) {
            str2 = str2.substring(1, str2.length());
        }
        String[] split = str2.split("_");
        String str4 = split[0];
        Boolean bool = (Boolean) downloadParams.mExtraInfo;
        boolean booleanValue = Boolean.valueOf(split[1]).booleanValue();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "downloadImage, completed = " + booleanValue + ", epId = " + str4);
        }
        if (booleanValue) {
            n3 = e.n(3, str4);
        } else {
            n3 = e.n(4, str4);
        }
        File file = new File(n3);
        try {
        } catch (OutOfMemoryError unused) {
            if (QLog.isColorLevel()) {
                QLog.w("EmoticonTabAdapter", 2, "getTabDrawable OOM return null");
            }
        }
        if (file.exists()) {
            return file;
        }
        if (booleanValue) {
            if (!bool.booleanValue()) {
                p16 = e.p(3, str4);
            } else {
                p16 = e.p(17, str4);
            }
        } else if (!bool.booleanValue()) {
            p16 = e.p(4, str4);
        } else {
            p16 = e.p(18, str4);
        }
        str3 = p16;
        return realDownloadFile(downloadParams, str, str3, n3);
    }

    @Nullable
    private File downloadRedpacketImage() {
        AppInterface appInterface;
        try {
            appInterface = (AppInterface) this.application.getAppRuntime(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
        } catch (Throwable th5) {
            QLog.d(TAG, 2, "exception:" + th5.getMessage());
            appInterface = null;
        }
        if (appInterface != null && (appInterface instanceof BaseQQAppInterface)) {
            Manager individualRedPacketManager = ((IEmosmService) QRoute.api(IEmosmService.class)).getIndividualRedPacketManager(appInterface);
            if (individualRedPacketManager != null) {
                String sendCombineImg = ((IEmosmService) QRoute.api(IEmosmService.class)).getSendCombineImg(individualRedPacketManager);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "downloadImage redpacket send img filename = " + sendCombineImg);
                }
                if (!TextUtils.isEmpty(sendCombineImg)) {
                    return new File(sendCombineImg);
                }
            }
            return null;
        }
        QLog.e(TAG, 2, "downloadImage redpacket send img app ==null or app not instanceof qqapp");
        return null;
    }

    @Nullable
    private File downloadSiteImage(DownloadParams downloadParams, String str, String str2) {
        int i3;
        URL url = downloadParams.url;
        if (url != null && !TextUtils.isEmpty(url.getFile())) {
            String[] split = str2.split("_");
            String str3 = split[1];
            String substring = split[0].substring(1);
            if (VasExtensionDownloaderConstant.BUSINESS_COMMERCIAL_DRAINAGE.equals(str)) {
                i3 = 22;
            } else {
                i3 = 23;
            }
            String o16 = e.o(i3, str3, MD5.toMD5(downloadParams.url.getFile()));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "emotion save local filePath: " + o16);
            }
            File file = new File(o16);
            if (file.exists()) {
                return file;
            }
            g gVar = new g(substring, file);
            gVar.B = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
            if (((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, MobileQQ.sMobileQQ.waitAppRuntime(null)) == 0) {
                return file;
            }
        }
        return null;
    }

    private File getLocalFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                return file;
            }
            return null;
        }
        return null;
    }

    private File realDownloadFile(DownloadParams downloadParams, String str, String str2, String str3) throws MalformedURLException {
        if (str2 != null) {
            if (!VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB.equals(str) && !VasExtensionDownloaderConstant.BUSINESS_CAMERA_EMO_PANEL_THUMB.equals(str) && !VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB_NEW.equals(str)) {
                downloadParams.url = new URL(str2);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downloadImage : " + str2 + " -> " + str3);
            }
            File file = new File(str3);
            g gVar = new g(str2, file);
            gVar.B = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
            int download = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, MobileQQ.sMobileQQ.waitAppRuntime(null));
            reportFavoriteDownloadStatus(str, download);
            if (download == 0) {
                if ((downloadParams.mExtraInfo instanceof FavoriteEmoticonInfo) && (VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB.equals(str) || VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB_NEW.equals(str))) {
                    updateFavEmoticonInDB((FavoriteEmoticonInfo) downloadParams.mExtraInfo);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "download sucessful " + str2 + " to path " + str3);
                }
                return file;
            }
        } else {
            Object obj = downloadParams.mExtraInfo;
            if (obj instanceof FavoriteLottieEmoticonInfo) {
                String str4 = ((FavoriteLottieEmoticonInfo) obj).resID;
                try {
                    QQSysAndEmojiResMgr.getInstance().getResImpl(1).addReloadDrawable(Integer.parseInt(str4));
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "[realDownloadFile] download fav lottie error. resId=", str4, ", stack=", QLog.getStackTraceString(th5));
                }
            }
        }
        return null;
    }

    private void reportFavoriteDownloadStatus(String str, int i3) {
        if (VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_DYNAMIC.equals(str) || VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB.equals(str) || VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB_NEW.equals(str)) {
            EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus(String.valueOf(i3), 6);
        }
    }

    private Bitmap toRoundBitmap(Bitmap bitmap, boolean z16) {
        float f16;
        float f17;
        float f18;
        float f19;
        if (bitmap == null || this.application == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f17 = width / 2;
            f18 = width;
            f19 = 0.0f;
            f16 = f18;
        } else {
            float f26 = (width - height) / 2;
            float f27 = height;
            f16 = width - f26;
            width = height;
            f17 = height / 2;
            f18 = f27;
            f19 = f26;
        }
        if (z16) {
            f17 = 0.5f + (this.application.getResources().getDisplayMetrics().density * 5.0f);
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect((int) f19, (int) 0.0f, (int) f16, (int) f18);
        Rect rect2 = new Rect((int) 0.0f, (int) 0.0f, (int) f18, (int) f18);
        RectF rectF = new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f17, f17, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, this, file, downloadParams, uRLDrawableHandler);
        }
        if (downloadParams == null || downloadParams.url == null) {
            return null;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "decodeFile, url = " + downloadParams.url);
        }
        String host = downloadParams.url.getHost();
        if (VasExtensionDownloaderConstant.BUSINESS_RESOURCE_IMG.equals(host)) {
            return decodeFileBusinessResImg(downloadParams);
        }
        if (VasExtensionDownloaderConstant.BUSINESS_EMOTICON_DIY.equals(host)) {
            return decodeFileBusinessEmoDiy(downloadParams);
        }
        if (VasExtensionDownloaderConstant.BUSINESS_REDPACKET_SEND_PIC.equals(host)) {
            return decodeFileBusinessRedPacketPic(file);
        }
        if (!VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB.equals(host) && !VasExtensionDownloaderConstant.BUSINESS_CAMERA_EMO_PANEL_THUMB.equals(host) && !VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB_NEW.equals(host)) {
            if (VasExtensionDownloaderConstant.BUSINESS_COMMERCIAL_DRAINAGE.equals(host)) {
                return decodeFileBusinessDrainage(file);
            }
            if (!VasExtensionDownloaderConstant.COMIC_IP_SITE_ROUND_IMAGE.equals(host) && !VasExtensionDownloaderConstant.COMIC_IPSITE_GAME_IMAGE.equals(host)) {
                if (!VasExtensionDownloaderConstant.BUSINESS_FONT_BUBBLE.equals(host)) {
                    return null;
                }
                return decodeFileBusinessFontBubble(file, downloadParams);
            }
            return decodeFileSiteImage(file, host);
        }
        return decodeFileBusinessFavorite(downloadParams, host);
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        if (downloadParams == null || (url = downloadParams.url) == null) {
            return null;
        }
        String host = url.getHost();
        String file = downloadParams.url.getFile();
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "downloadImage, host = " + host + ", epId = " + file);
        }
        if (VasExtensionDownloaderConstant.BUSINESS_EMOTICON_TAB.equals(host)) {
            return downloadFromEmoticonTab(downloadParams, host, file);
        }
        if (!VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_DYNAMIC.equals(host) && !VasExtensionDownloaderConstant.BUSINESS_CAMERA_EMO_PANEL_DYNAMIC.equals(host)) {
            if (!VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB.equals(host) && !VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB_NEW.equals(host)) {
                if (VasExtensionDownloaderConstant.BUSINESS_CAMERA_EMO_PANEL_THUMB.equals(host)) {
                    return downloadCameraThumb(downloadParams, host, file);
                }
                if (VasExtensionDownloaderConstant.BUSINESS_RESOURCE_IMG.equals(host)) {
                    return null;
                }
                if (VasExtensionDownloaderConstant.BUSINESS_EMOTICON_DIY.equals(host)) {
                    return new File(AppConstants.SDCARD_PATH);
                }
                if (VasExtensionDownloaderConstant.BUSINESS_REDPACKET_SEND_PIC.equals(host)) {
                    return downloadRedpacketImage();
                }
                if (!VasExtensionDownloaderConstant.BUSINESS_COMMERCIAL_DRAINAGE.equals(host) && !VasExtensionDownloaderConstant.IP_SITE_IMAGE.equals(host)) {
                    if (!VasExtensionDownloaderConstant.COMIC_IP_SITE_ROUND_IMAGE.equals(host) && !VasExtensionDownloaderConstant.COMIC_IPSITE_GAME_IMAGE.equals(host)) {
                        if (!VasExtensionDownloaderConstant.BUSINESS_FONT_BUBBLE.equals(host)) {
                            return null;
                        }
                        return downloadFile(".fontbubble", downloadParams);
                    }
                    return downloadFile(".comicIPSite", downloadParams);
                }
                return downloadSiteImage(downloadParams, host, file);
            }
            return downloadFavoriteImage(downloadParams, host, file);
        }
        return downloadDynamicImage(downloadParams, host, file);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public JobQueue getQueue(URL url) {
        IEmojiManagerService iEmojiManagerService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JobQueue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        try {
            iEmojiManagerService = (IEmojiManagerService) ((BaseQQAppInterface) MobileQQ.sMobileQQ.getAppRuntime(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount())).getRuntimeService(IEmojiManagerService.class);
        } catch (Throwable unused) {
            iEmojiManagerService = null;
        }
        if (iEmojiManagerService == null) {
            return null;
        }
        return iEmojiManagerService.getEmoQueue();
    }

    public void updateFavEmoticonInDB(FavoriteEmoticonInfo favoriteEmoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) favoriteEmoticonInfo);
        } else {
            if (favoriteEmoticonInfo == null) {
                return;
            }
            ThreadManagerV2.post(new Runnable(favoriteEmoticonInfo) { // from class: com.tencent.mobileqq.transfile.VasExtensionDownloader.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ FavoriteEmoticonInfo val$info;

                {
                    this.val$info = favoriteEmoticonInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VasExtensionDownloader.this, (Object) favoriteEmoticonInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IFavroamingDBManagerService iFavroamingDBManagerService;
                    CustomEmotionData emotionDataByUrl;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                    if ((waitAppRuntime instanceof AppInterface) && (emotionDataByUrl = (iFavroamingDBManagerService = (IFavroamingDBManagerService) waitAppRuntime.getRuntimeService(IFavroamingDBManagerService.class, "")).getEmotionDataByUrl(this.val$info.url)) != null && new File(this.val$info.path).exists()) {
                        if (FavEmoConstant.ROAMING_TYPE_PANEL.equals(emotionDataByUrl.RomaingType)) {
                            emotionDataByUrl.RomaingType = "isUpdate";
                        } else if ("overflow".equals(emotionDataByUrl.RomaingType)) {
                            emotionDataByUrl.RomaingType = FavEmoConstant.ROAMING_TYPE_OVERFLOW_DOWNLOADED;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(VasExtensionDownloader.TAG, 2, "update CustomEmotionData romaing type  isUpdate, path: " + this.val$info.path);
                        }
                        if (TextUtils.isEmpty(emotionDataByUrl.md5) && !TextUtils.isEmpty(emotionDataByUrl.emoPath)) {
                            emotionDataByUrl.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(emotionDataByUrl.emoPath));
                            if (QLog.isColorLevel()) {
                                QLog.i(VasExtensionDownloader.TAG, 2, "update CustomEmotionData md5 , path: " + this.val$info.path);
                            }
                        }
                        if (!"needDel".equals(emotionDataByUrl.RomaingType)) {
                            iFavroamingDBManagerService.updateCustomEmotion(emotionDataByUrl);
                        }
                    }
                }
            }, 5, null, false);
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    public Bitmap zoomBitmap(Bitmap bitmap, int i3, int i16) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            f16 = i3 / width;
        } else {
            f16 = i16 / height;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f16, f16);
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, config);
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    private Bitmap toRoundBitmap(Bitmap bitmap) {
        return toRoundBitmap(bitmap, false);
    }
}
