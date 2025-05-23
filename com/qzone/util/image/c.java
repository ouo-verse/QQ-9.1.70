package com.qzone.util.image;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import com.qzone.album.data.model.GifInfo;
import com.qzone.app.ImageEnvImpl;
import com.qzone.app.ImageLogger;
import com.qzone.misc.network.uploader.QZoneImageSizeStrategy;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.network.utils.PlatformUtil;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.upload.uinterface.IUploadConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.GifCoder;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.PhotoUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f59809a = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoTrafficTips", "\u8be5\u89c6\u9891\u4ece\u79fb\u52a8\u7f51\u7edc\u4e0a\u4f20\uff0c\u5c06\u4f1a\u6d88\u8017\u4f60\u7684\u624b\u673a\u6d41\u91cf");

    /* renamed from: b, reason: collision with root package name */
    private static String f59810b = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoTrafficFirstStr", "\u5f53\u524d\u6587\u4ef6\u8d85\u8fc7");

    /* renamed from: c, reason: collision with root package name */
    private static String f59811c = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoTrafficLastStr", "M\uff0c\u5c06\u4f1a\u6d88\u8017\u4f60\u7684\u624b\u673a\u6d41\u91cf");

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f59812a;

        /* renamed from: b, reason: collision with root package name */
        public int f59813b;

        public a(int i3, int i16) {
            this.f59812a = i3;
            this.f59813b = i16;
        }
    }

    public static int A(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            int readOrientation = JpegExifReader.readOrientation(str);
            if (readOrientation == 3) {
                return 180;
            }
            if (readOrientation != 6) {
                return readOrientation != 8 ? 0 : 270;
            }
            return 90;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public static String B(String str) {
        int indexOf;
        BitmapFactory.Options options = BitmapUtils.getOptions();
        options.inJustDecodeBounds = true;
        try {
            n(str, options);
            String str2 = options.outMimeType;
            if (str2 != null && (indexOf = str2.indexOf(47)) != -1) {
                return options.outMimeType.substring(indexOf + 1);
            }
            if (SharpPUtils.isSharpP(new File(str))) {
                QZLog.i("ImageUtil", 1, "judgeImageFormat, path: " + str + ", isSharpP");
                return "sharpp";
            }
            if (com.tencent.qzone.avif.a.a(new File(str))) {
                QZLog.i("ImageUtil", 1, "judgeImageFormat, path: " + str + ", isAvif");
                return "avif";
            }
            return "unknown";
        } catch (Exception e16) {
            QZLog.e("ImageUtil", "getImageFormat error: ", e16);
            xe.b.f447841a.d(e16);
            return "unknown";
        }
    }

    public static String E(Context context, Uri uri) {
        String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            return uri.getPath();
        }
        if ("content".equals(scheme)) {
            Cursor query = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{"_data"}, null, null, null);
            if (query == null) {
                return null;
            }
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            query.moveToFirst();
            String string = query.getString(columnIndexOrThrow);
            query.close();
            return string;
        }
        return uri.toString();
    }

    public static Bitmap F(Bitmap bitmap, float f16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(f16, f16);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static BitmapFactory.Options G(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("file://")) {
            str = str.replaceFirst("file://", "");
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            options.inJustDecodeBounds = true;
            n(str, options);
            options.inJustDecodeBounds = false;
            if (P(str) % 180 != 0) {
                int i3 = options.outHeight;
                options.outHeight = options.outWidth;
                options.outWidth = i3;
            }
        } catch (Exception unused) {
        }
        return options;
    }

    public static String H(long j3, boolean z16) {
        long I = I();
        long j16 = 0;
        do {
            j16 += I;
        } while (j16 <= j3);
        if (z16) {
            return f59809a;
        }
        return f59810b + ((I / 1024) / 1024) + f59811c;
    }

    public static long I() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PHOTO_TRAFFIC_THRESHOLD, 20480) * 1024;
    }

    public static void J(String str, boolean z16, ImageLoader.ImageLoadListener imageLoadListener, Bitmap.Config config) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z16) {
            K(str, 0, imageLoadListener);
            return;
        }
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.useMainThread = true;
        obtain.imageConfig = config;
        if (str != null && str.contains(".9.png")) {
            obtain.extraProcessor = new z4.c(i3 / 720.0f);
        }
        Drawable loadImage = ImageLoader.getInstance().loadImage(str, imageLoadListener, obtain);
        if (loadImage == null || imageLoadListener == null) {
            return;
        }
        imageLoadListener.onImageLoaded(str, loadImage, obtain);
    }

    public static void K(String str, int i3, ImageLoader.ImageLoadListener imageLoadListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.useMainThread = true;
        obtain.imageConfig = Bitmap.Config.ARGB_4444;
        if (str != null && str.contains(".9.png")) {
            obtain.extraProcessor = new z4.c(i3, 0, true);
        }
        Drawable loadImage = ImageLoader.getInstance().loadImage(str, imageLoadListener, obtain);
        if (loadImage == null || imageLoadListener == null) {
            return;
        }
        imageLoadListener.onImageLoaded(str, loadImage, obtain);
    }

    public static void L(String str, boolean z16, ImageLoader.ImageLoadListener imageLoadListener) {
        J(str, z16, imageLoadListener, Bitmap.Config.ARGB_4444);
    }

    public static boolean M(long j3) {
        return !TMSManager.e().h() && j3 > I();
    }

    public static int P(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int readOrientation = JpegExifReader.readOrientation(str);
        if (readOrientation == 3) {
            return 180;
        }
        if (readOrientation != 6) {
            return readOrientation != 8 ? 0 : 270;
        }
        return 90;
    }

    public static Bitmap R(Bitmap bitmap, int i3, int i16, Matrix matrix, boolean z16) {
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, i3, i16, matrix, true);
        } catch (Exception e16) {
            QZLog.e("ImageUtil", "catch exception Matrix ", e16);
            return null;
        } catch (OutOfMemoryError e17) {
            QZLog.e("ImageUtil", "catch out of mem Matrix " + z16, e17);
            if (z16) {
                return R(bitmap, i3, i16, matrix, false);
            }
            return null;
        }
    }

    private static Bitmap T(BitmapFactory.Options options, String str, boolean z16) {
        try {
            return n(str, options);
        } catch (OutOfMemoryError e16) {
            QZLog.e("ImageUtil", "catch out of mem Option " + z16, e16);
            if (z16) {
                return T(options, str, false);
            }
            return null;
        }
    }

    public static boolean V(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i3, boolean z16) {
        return PhotoUtils.saveBitmapToFile(bitmap, str, compressFormat, i3, z16);
    }

    public static boolean W(Bitmap bitmap, String str, String str2, Bitmap.CompressFormat compressFormat, int i3, boolean z16) {
        File file = new File(str);
        if (!(file.exists() || file.mkdirs())) {
            return false;
        }
        return V(bitmap, str + str2, compressFormat, i3, z16);
    }

    public static int a(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        int i19 = 1;
        if (i17 > i16 || i18 > i3) {
            int i26 = i17 / 2;
            int i27 = i18 / 2;
            while (i26 / i19 > i16 && i27 / i19 > i3) {
                i19 *= 2;
            }
        }
        return i19;
    }

    public static boolean b(GifInfo gifInfo) {
        String str = gifInfo.mOrignPath;
        String str2 = gifInfo.mDoodlePath;
        if (QZLog.isColorLevel()) {
            QZLog.d("ImageUtil", 2, "gifOrignPath : " + str + " doodleBitmapPath:" + str2);
        }
        Bitmap n3 = n(str2, null);
        GifCoder gifCoder = new GifCoder();
        gifCoder.setUseOrignalBitmap(true);
        String str3 = gifInfo.mSavePath;
        boolean z16 = false;
        z16 = false;
        try {
            try {
                NewGifDrawable newGifDrawable = new NewGifDrawable(str, (NewGifDecoder.Options) null);
                boolean z17 = false;
                for (int i3 = 0; i3 < newGifDrawable.getNumberOfFrames(); i3++) {
                    try {
                        Bitmap seekToFrameAndGet = newGifDrawable.seekToFrameAndGet(i3);
                        if (n3 != null) {
                            z17 = gifCoder.encodeGif(com.tencent.biz.qqstory.utils.b.j(seekToFrameAndGet, n3), str3, gifInfo.delay, true);
                        } else {
                            z17 = gifCoder.encodeGif(seekToFrameAndGet, str3, gifInfo.delay, true);
                        }
                        if (!z17) {
                            break;
                        }
                        if (seekToFrameAndGet != null && !seekToFrameAndGet.isRecycled()) {
                            seekToFrameAndGet.recycle();
                        }
                    } catch (IOException e16) {
                        e = e16;
                        z16 = z17;
                        e.printStackTrace();
                        return z16;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        z16 = z17;
                        e.printStackTrace();
                        return z16;
                    }
                }
                z16 = z17;
                if (QZLog.isColorLevel()) {
                    QZLog.d("ImageUtil", 2, "encodeSuccess : " + z16 + " delay:" + gifInfo.delay);
                }
            } catch (IOException e18) {
                e = e18;
            } catch (OutOfMemoryError e19) {
                e = e19;
            }
            return z16;
        } finally {
            gifCoder.closeEncoder();
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0033: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:31:0x0033 */
    public static byte[] h(Bitmap bitmap, int i3, boolean z16) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(8192);
                } catch (Exception e16) {
                    e = e16;
                    byteArrayOutputStream = null;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    byteArrayOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        byteArrayOutputStream3.flush();
                        byteArrayOutputStream3.close();
                    } catch (Exception e18) {
                        QZLog.e("ImageUtil", e18.toString());
                    }
                    throw th;
                }
                try {
                    if (bitmap.hasAlpha() && !z16) {
                        bitmap.compress(Bitmap.CompressFormat.PNG, i3, byteArrayOutputStream);
                    } else {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    } catch (Exception e19) {
                        QZLog.e("ImageUtil", e19.toString());
                    }
                    return byteArray;
                } catch (Exception e26) {
                    e = e26;
                    QZLog.e("ImageUtil", e.toString());
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return null;
                } catch (OutOfMemoryError e27) {
                    e = e27;
                    QZLog.e("ImageUtil", e.toString());
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
                byteArrayOutputStream3 = byteArrayOutputStream2;
                byteArrayOutputStream3.flush();
                byteArrayOutputStream3.close();
                throw th;
            }
        } catch (Exception e28) {
            QZLog.e("ImageUtil", e28.toString());
        }
    }

    private static Bitmap k(String str, BitmapFactory.Options options, int i3, int i16) {
        try {
            return n(str, options);
        } catch (OutOfMemoryError unused) {
            if (i3 >= i16) {
                return null;
            }
            options.inSampleSize++;
            return k(str, options, i3 + 1, i16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00e1 A[Catch: IOException -> 0x00dd, TRY_LEAVE, TryCatch #10 {IOException -> 0x00dd, blocks: (B:60:0x00d9, B:53:0x00e1), top: B:59:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap l(String str) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        BitmapFactory.Options options;
        BufferedInputStream bufferedInputStream4 = null;
        try {
            try {
                try {
                    options = new BitmapFactory.Options();
                    int i3 = 1;
                    options.inJustDecodeBounds = true;
                    bufferedInputStream3 = new BufferedInputStream(new FileInputStream(str), 8192);
                    try {
                        BitmapFactory.decodeStream(bufferedInputStream3, null, options);
                        int i16 = options.outWidth;
                        int i17 = options.outHeight;
                        while (i16 / 2 >= 224 && i17 / 2 >= 224) {
                            i16 /= 2;
                            i17 /= 2;
                            i3 *= 2;
                        }
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = i3;
                        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        g8.a.a("ImageUtil", "[decodeBitmap] file path = " + str + ",width = " + options.outWidth + ",height = " + options.outHeight + ",sampleSize = " + i3);
                        bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str), 8192);
                    } catch (Exception e16) {
                        e = e16;
                        bufferedInputStream2 = null;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        bufferedInputStream2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = null;
                        bufferedInputStream4 = bufferedInputStream3;
                        if (bufferedInputStream4 != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    e = e18;
                    bufferedInputStream2 = null;
                    bufferedInputStream3 = null;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    bufferedInputStream2 = null;
                    bufferedInputStream3 = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedInputStream = null;
                    if (bufferedInputStream4 != null) {
                        try {
                            bufferedInputStream4.close();
                        } catch (IOException e26) {
                            g8.a.b("ImageUtil", "[decodeBitmap] finally IOException", e26);
                            throw th;
                        }
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    throw th;
                }
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream2, null, options);
                    if (decodeStream != null && !decodeStream.isRecycled()) {
                        decodeStream = O(decodeStream, str);
                    }
                    try {
                        bufferedInputStream3.close();
                        bufferedInputStream2.close();
                    } catch (IOException e27) {
                        g8.a.b("ImageUtil", "[decodeBitmap] finally IOException", e27);
                    }
                    return decodeStream;
                } catch (Exception e28) {
                    e = e28;
                    g8.a.b("ImageUtil", "[decodeBitmap] failed", e);
                    if (bufferedInputStream3 != null) {
                        bufferedInputStream3.close();
                    }
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    return null;
                } catch (OutOfMemoryError e29) {
                    e = e29;
                    g8.a.b("ImageUtil", "[decodeBitmap] OOM", e);
                    if (bufferedInputStream3 != null) {
                        bufferedInputStream3.close();
                    }
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    return null;
                }
            } catch (IOException e36) {
                g8.a.b("ImageUtil", "[decodeBitmap] finally IOException", e36);
                return null;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static BitmapFactory.Options m(String str) {
        BitmapFactory.Options options = BitmapUtils.getOptions();
        options.inJustDecodeBounds = true;
        n(str, options);
        return options;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a2, code lost:
    
        if (r3 == null) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0091 A[Catch: all -> 0x0087, TryCatch #7 {all -> 0x0087, blocks: (B:45:0x000a, B:47:0x000e, B:17:0x008b, B:19:0x0091, B:31:0x0099, B:33:0x009f, B:4:0x002f, B:6:0x0035, B:7:0x0046, B:9:0x0051, B:13:0x0059, B:43:0x0070), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #7 {all -> 0x0087, blocks: (B:45:0x000a, B:47:0x000e, B:17:0x008b, B:19:0x0091, B:31:0x0099, B:33:0x009f, B:4:0x002f, B:6:0x0035, B:7:0x0046, B:9:0x0051, B:13:0x0059, B:43:0x0070), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap n(String str, BitmapFactory.Options options) {
        Bitmap bitmap;
        Bitmap decodeStream;
        FileInputStream fileInputStream = null;
        try {
            if (options != null) {
                try {
                    if (options.inJustDecodeBounds) {
                        FileInputStream fileInputStream2 = new FileInputStream(str);
                        try {
                            decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream2, 8192), null, options);
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                return decodeStream;
                            }
                            try {
                                fileInputStream.close();
                                return decodeStream;
                            } catch (IOException unused) {
                                return decodeStream;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            bitmap = null;
                            fileInputStream = fileInputStream2;
                            if (QLog.isColorLevel()) {
                            }
                            if (fileInputStream != null) {
                            }
                            return bitmap;
                        } catch (OutOfMemoryError e17) {
                            e = e17;
                            bitmap = null;
                            fileInputStream = fileInputStream2;
                            if (QLog.isColorLevel()) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e18) {
                    e = e18;
                    bitmap = null;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    bitmap = null;
                }
            }
            if (ImageManagerEnv.getAppContext() == null) {
                ImageManagerEnv.init(BaseApplication.getContext(), new ImageEnvImpl(), new ImageLogger());
            }
            if (SharpPUtils.isSharpP(new File(str))) {
                decodeStream = SharpPUtils.decodeSharpP(str);
                if (decodeStream != null && options != null) {
                    try {
                        options.outHeight = decodeStream.getHeight();
                        options.outWidth = decodeStream.getWidth();
                    } catch (Exception e26) {
                        bitmap = decodeStream;
                        e = e26;
                        if (QLog.isColorLevel()) {
                            QLog.e("ImageUtil", 2, "", e);
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return bitmap;
                    } catch (OutOfMemoryError e27) {
                        bitmap = decodeStream;
                        e = e27;
                        if (QLog.isColorLevel()) {
                            QLog.e("ImageUtil", 2, "", e);
                        }
                    }
                }
            } else {
                decodeStream = ImageManager.getInstance().getDecoder().decodeFile(new File(str), options);
            }
            if (fileInputStream != null) {
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static ArrayList<LocalMediaInfo> p(Context context, ArrayList<String> arrayList) {
        ArrayList<LocalMediaInfo> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            return arrayList2;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            String str = arrayList.get(i16);
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            String fileName = FileManagerUtil.getFileName(str);
            localMediaInfo.path = str;
            String mimeType = MimeTypesTools.getMimeType(context, fileName);
            localMediaInfo.mMimeType = mimeType;
            String[] mimeType2 = MimeHelper.getMimeType(mimeType);
            if (MimeHelper.validateVideoType(localMediaInfo.mMimeType)) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(str);
                        String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                        String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                        localMediaInfo.mediaWidth = Integer.parseInt(extractMetadata);
                        localMediaInfo.mediaHeight = Integer.parseInt(extractMetadata2);
                        localMediaInfo.mDuration = Long.parseLong(extractMetadata3);
                        localMediaInfo.position = Integer.valueOf(i3);
                        arrayList2.add(localMediaInfo);
                        i3++;
                    } catch (IllegalArgumentException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("ImageUtil", 2, e16, new Object[0]);
                        }
                    }
                } finally {
                    mediaMetadataRetriever.release();
                }
            } else if (mimeType2 != null && "image".equals(mimeType2[0]) && MimeHelper.validateImageType(mimeType2[1])) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                localMediaInfo.mediaWidth = options.outWidth;
                localMediaInfo.mediaHeight = options.outHeight;
                localMediaInfo.mDuration = 1500L;
                localMediaInfo.position = Integer.valueOf(i3);
                arrayList2.add(localMediaInfo);
                i3++;
            }
        }
        return arrayList2;
    }

    public static Bitmap q(String str, int i3) {
        boolean z16;
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        int A = A(str);
        if (QZLog.isDevelopLevel()) {
            QZLog.d("ImageUtil", 4, "\u8bfb\u53d6\u524d\uff1a" + System.currentTimeMillis());
        }
        BitmapFactory.Options options = BitmapUtils.getOptions();
        options.inJustDecodeBounds = true;
        try {
            n(str, options);
        } catch (Throwable th5) {
            QZLog.e("ImageUtil", "Throwable", th5);
        }
        a aVar = new a(options.outWidth, options.outHeight);
        QZLog.d("ImageUtil", 4, "original size width = " + aVar.f59812a + ", height = " + aVar.f59813b);
        int i16 = aVar.f59812a;
        if (i16 <= i3) {
            z16 = false;
        } else {
            float f16 = i3 / i16;
            if (f16 < 1.0f) {
                aVar = new a(i3, (int) (aVar.f59813b * f16));
            }
            z16 = true;
        }
        QZLog.d("ImageUtil", 4, "resize width = " + aVar.f59812a + ", height = " + aVar.f59813b);
        int a16 = z16 ? a(options, aVar.f59812a, aVar.f59813b) : 1;
        QZLog.d("ImageUtil", 4, "sampleSize = " + a16);
        options.inSampleSize = a16;
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap k3 = k(str, options, 0, 2);
        QZLog.d("ImageUtil", 4, "\u8bfb\u53d6\u5b8c\u6570\u636e\uff1a" + System.currentTimeMillis());
        if (A != 0) {
            k3 = U(k3, A);
        }
        if (k3 == null) {
            return null;
        }
        if (k3.getWidth() != i3) {
            float width = i3 / k3.getWidth();
            Matrix matrix = new Matrix();
            matrix.setScale(width, width);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(i3, (int) (width * k3.getHeight()), Bitmap.Config.ARGB_4444);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setDither(true);
                paint.setFilterBitmap(true);
                new Canvas(createBitmap).drawBitmap(k3, matrix, paint);
                Q(k3);
                QZLog.d("ImageUtil", 4, "\u83b7\u53d6\u6700\u7ec8\u6570\u636e\uff1a" + System.currentTimeMillis());
                return createBitmap;
            } catch (OutOfMemoryError e16) {
                QZLog.e("ImageUtil", "OutOfMemoryError. ", e16);
            }
        }
        return k3;
    }

    public static Bitmap r(String str, int i3, int i16) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i17 = 1;
            options.inJustDecodeBounds = true;
            n(str, options);
            if (i3 > 0 || i16 > 0) {
                i17 = a(options, i3, i16);
            }
            options.inSampleSize = i17;
            options.inJustDecodeBounds = false;
            return n(str, options);
        } catch (Exception e16) {
            e16.printStackTrace();
            QZLog.e("ImageUtil", "getBitmapFromFile, exception", e16);
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            QZLog.e("ImageUtil", "getBitmapFromFile, OutOfMemoryError");
            return null;
        }
    }

    public static Bitmap t(Resources resources, int i3, int i16, int i17) {
        if (resources == null || i3 <= 0) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i18 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(resources, i3, options);
            if (i16 > 0 || i17 > 0) {
                i18 = a(options, i16, i17);
            }
            if (QZLog.isColorLevel()) {
                QZLog.d("ImageUtil", 2, "inSampleSize=" + i18);
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = i18;
            return BitmapFactory.decodeResource(resources, i3, options);
        } catch (Exception e16) {
            e16.printStackTrace();
            QZLog.e("ImageUtil", "getBitmapFromResource, exception", e16);
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            QZLog.e("ImageUtil", "getBitmapFromResource, OutOfMemoryError");
            return null;
        }
    }

    public static a u(String str) {
        if (!new File(str).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        n(str, options);
        options.inJustDecodeBounds = false;
        return new a(options.outWidth, options.outHeight);
    }

    public static Bitmap w(String str, int i3, int i16, boolean z16) {
        if (!new File(str).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        n(str, options);
        options.inJustDecodeBounds = false;
        int min = Math.min(options.outWidth / i3, options.outHeight / i16);
        if (min < 1) {
            min = 1;
        }
        options.inSampleSize = min;
        Bitmap T = T(options, str, true);
        if (T == null) {
            options.inSampleSize++;
            T = S(options, str);
        }
        if (T == null) {
            return null;
        }
        int width = T.getWidth();
        int height = T.getHeight();
        if (i3 <= 0) {
            i3 = width;
        }
        if (i16 <= 0) {
            i16 = height;
        }
        float f16 = i3 / width;
        float f17 = i16 / height;
        if (f16 > 1.0f && f17 > 1.0f) {
            return T;
        }
        Matrix matrix = new Matrix();
        if (z16) {
            if (f16 > f17) {
                f16 = f17;
            }
            matrix.postScale(f16, f16);
        } else {
            matrix.postScale(f16, f17);
        }
        Bitmap R = R(T, width, height, matrix, true);
        if (R != T) {
            T.recycle();
        }
        return R;
    }

    public static Bitmap x(String str, int i3, int i16) {
        if (!new File(str).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        n(str, options);
        options.inJustDecodeBounds = false;
        int max = Math.max((int) ((options.outWidth / i3) + 0.5d), (int) ((options.outHeight / i16) + 0.5d));
        if (max < 1) {
            max = 1;
        }
        options.inSampleSize = max;
        options.inJustDecodeBounds = false;
        Bitmap T = T(options, str, true);
        if (T == null) {
            options.inSampleSize++;
            T = S(options, str);
        }
        if (T != null) {
            return T;
        }
        QZLog.e("ImageUtil", "decode bitmap fail");
        return null;
    }

    public static float y(String str, int i3) {
        int networkType;
        QLog.d("ImageUtil", 1, "getFakeCompressedSize  imgPath = " + str + " , quality = " + i3);
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0.0f;
        }
        float length = (float) file.length();
        if (i3 == 3) {
            return length;
        }
        if ("image/gif".equalsIgnoreCase(D(file.getAbsolutePath())) && (((networkType = NetworkState.getNetworkType()) == 1 && file.length() < 5242880) || ((networkType == 2 && file.length() < 819200) || (networkType == 3 && file.length() < 2097152)))) {
            return length;
        }
        a u16 = u(str);
        if (u16 == null) {
            return 0.0f;
        }
        long j3 = u16.f59813b * 1 * u16.f59812a;
        IUploadConfig.UploadImageSize targetSize = QZoneImageSizeStrategy.getTargetSize(u16, i3, false);
        return (((((float) ((targetSize.height * 1) * targetSize.width)) / ((float) j3)) * ((float) file.length())) * targetSize.quality) / 100.0f;
    }

    public static int z(ArrayList<String> arrayList) {
        String str = "";
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            str = str + arrayList.get(i3);
        }
        return str.hashCode();
    }

    public static Bitmap c(Bitmap bitmap, int i3) {
        byte[] h16 = h(bitmap, i3, true);
        if (h16 != null) {
            return BitmapFactory.decodeByteArray(h16, 0, h16.length);
        }
        return null;
    }

    public static byte[] g(Bitmap bitmap, int i3) {
        return h(bitmap, i3, false);
    }

    public static Bitmap s(Resources resources, int i3) {
        return t(resources, i3, 0, 0);
    }

    public static Bitmap v(String str, int i3, int i16) {
        return w(str, i3, i16, false);
    }

    public static boolean Q(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        bitmap.recycle();
        return true;
    }

    public static boolean e(GifInfo gifInfo) {
        boolean encodeGif;
        GifCoder gifCoder = new GifCoder();
        boolean z16 = false;
        gifCoder.setUseOrignalBitmap(false);
        try {
            try {
                Bitmap bitmap = null;
                if (!TextUtils.isEmpty(gifInfo.mDoodlePath)) {
                    try {
                        bitmap = n(gifInfo.mDoodlePath, null);
                    } catch (OutOfMemoryError e16) {
                        e = e16;
                        e.printStackTrace();
                        return z16;
                    }
                }
                int i3 = 0;
                boolean z17 = false;
                while (i3 < gifInfo.picsOrignPath.size()) {
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(gifInfo.picsOrignPath.get(i3), options);
                        int a16 = a(options, BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels, BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels);
                        options.inJustDecodeBounds = z16;
                        options.inSampleSize = a16;
                        Bitmap n3 = n(gifInfo.picsOrignPath.get(i3), options);
                        if (QZLog.isColorLevel()) {
                            QZLog.d("ImageUtil", 2, "gifInfo.picsOrignPath.get(i) : " + gifInfo.picsOrignPath.get(i3));
                        }
                        int exifOrientation = BaseImageUtil.getExifOrientation(gifInfo.picsOrignPath.get(i3));
                        if (exifOrientation != 0 && exifOrientation % 90 == 0) {
                            int width = n3.getWidth();
                            int height = n3.getHeight();
                            Matrix matrix = new Matrix();
                            matrix.postRotate(exifOrientation, width / 2.0f, height / 2.0f);
                            n3 = Bitmap.createBitmap(n3, 0, 0, width, height, matrix, true);
                        }
                        if (bitmap != null) {
                            encodeGif = gifCoder.encodeGif(com.tencent.biz.qqstory.utils.b.j(n3, bitmap), gifInfo.mSavePath, gifInfo.delay, true);
                        } else {
                            if (QZLog.isColorLevel()) {
                                QZLog.d("ImageUtil", 2, "doodleBitmap == null");
                            }
                            encodeGif = gifCoder.encodeGif(n3, gifInfo.mSavePath, gifInfo.delay, true);
                        }
                        z17 = encodeGif;
                        if (!z17) {
                            break;
                        }
                        if (n3 != null && !n3.isRecycled()) {
                            n3.recycle();
                        }
                        i3++;
                        z16 = false;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        z16 = z17;
                        e.printStackTrace();
                        return z16;
                    }
                }
                z16 = z17;
                if (QZLog.isColorLevel()) {
                    QZLog.d("ImageUtil", 2, "encodeSuccess : " + z16 + " delay:" + gifInfo.delay);
                }
            } finally {
                gifCoder.closeEncoder();
            }
        } catch (OutOfMemoryError e18) {
            e = e18;
            z16 = false;
        }
        return z16;
    }

    public static byte[] f(Bitmap bitmap) {
        return g(bitmap, 90);
    }

    public static byte[] i(String str) {
        Bitmap x16 = x(str, 120, 120);
        if (x16 == null) {
            return null;
        }
        byte[] f16 = f(x16);
        double length = f16.length / 30720.0d;
        if (length > 1.0d) {
            Matrix matrix = new Matrix();
            float sqrt = (float) (1.0d / Math.sqrt(length));
            matrix.postScale(sqrt, sqrt);
            Bitmap createBitmap = Bitmap.createBitmap(x16, 0, 0, x16.getWidth(), x16.getHeight(), matrix, true);
            byte[] f17 = f(createBitmap);
            if (QZLog.isDevelopLevel()) {
                QZLog.d("ImageUtil", 4, "thumbBmp.size:" + (f17.length / 1024) + " thumbBmp.width:" + createBitmap.getWidth() + " thumbBmp.height:" + createBitmap.getHeight());
            }
            createBitmap.recycle();
            f16 = f17;
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("ImageUtil", 4, "bitmap.size:" + (f16.length / 1024) + " bitmap.width:" + x16.getWidth() + " bitmap.height:" + x16.getHeight());
        }
        x16.recycle();
        return f16;
    }

    public static void j(ArrayList<String> arrayList) {
        int i3 = 0;
        while (i3 < arrayList.size()) {
            String str = arrayList.get(i3);
            if (str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                arrayList.remove(i3);
                i3--;
            }
            File file = new File(str);
            if (com.tencent.qzone.avif.a.a(file) || SharpPUtils.isSharpP(file)) {
                Bitmap a16 = com.tencent.qzone.image.api.a.c().a(file, file.getPath(), 0, 0);
                String str2 = file.getParent() + (file.getName() + ".jpeg");
                if (V(a16, str2, Bitmap.CompressFormat.JPEG, 90, true)) {
                    arrayList.set(i3, str2);
                    QZLog.i("ImageUtil", "sharpp file save success:" + str2 + " , exists = " + new File(str2).exists());
                } else {
                    QZLog.e("ImageUtil", "ImageUtil.saveBitmapToFile return false");
                }
            }
            i3++;
        }
    }

    public static long C(HashMap<String, ShuoshuoVideoInfo> hashMap, ArrayList<String> arrayList, int i3, int i16) {
        long j3 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = new ArrayList(arrayList).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (new File(str).exists()) {
                    if (hashMap != null && hashMap.containsKey(str)) {
                        ShuoshuoVideoInfo shuoshuoVideoInfo = hashMap.get(str);
                        if (i16 != 3) {
                            j3 = (long) (j3 + shuoshuoVideoInfo.mEstimateSize);
                        } else {
                            j3 += shuoshuoVideoInfo.mSize;
                        }
                    } else {
                        j3 = ((float) j3) + y(str, i3);
                    }
                }
            }
        }
        return j3;
    }

    public static String D(String str) {
        if (str == null || !new File(str).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        n(str, options);
        return options.outMimeType;
    }

    public static void N(Context context, String str) {
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + str)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap S(BitmapFactory.Options options, String str) {
        Bitmap bitmap = null;
        int i3 = 0;
        while (true) {
            if (i3 > 0 && options.inSampleSize > 7) {
                return bitmap;
            }
            try {
                bitmap = n(str, options);
                if (!QZLog.isColorLevel()) {
                    break;
                }
                QZLog.i("QZoneUpload", 2, "options.inSampleSize \uff1a " + options.inSampleSize);
                break;
            } catch (OutOfMemoryError e16) {
                QZLog.e("ImageUtil", "catch out of mem Option small options", e16);
                options.inSampleSize++;
                i3++;
            }
        }
    }

    public static Bitmap U(Bitmap bitmap, int i3) {
        if (i3 == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i3, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return bitmap != createBitmap ? createBitmap : bitmap;
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return bitmap;
        }
    }

    public static Bitmap o(Drawable drawable) {
        Bitmap.Config config;
        Bitmap bitmap = null;
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        try {
            if (drawable.getOpacity() != -1) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
        } catch (OutOfMemoryError unused) {
        }
        return bitmap;
    }

    public static Bitmap O(Bitmap bitmap, String str) {
        if (bitmap == null || str == null || PlatformUtil.version() < 5) {
            return bitmap;
        }
        ExifInterface exifInterface = null;
        try {
            if (!JpegExifReader.isCrashJpeg(str)) {
                exifInterface = new ExifInterface(str);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (exifInterface == null) {
            return bitmap;
        }
        int i3 = 0;
        int attributeInt = exifInterface.getAttributeInt("Orientation", 0);
        if (attributeInt == 3) {
            i3 = 180;
        } else if (attributeInt == 6) {
            i3 = 90;
        } else if (attributeInt == 8) {
            i3 = 270;
        }
        return U(bitmap, i3);
    }

    public static byte[] d(Bitmap bitmap, int i3, boolean z16) {
        if (bitmap == null || i3 < 1) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i16 = 100;
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        while (i16 > 70 && byteArray.length / 1024 > i3) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.PNG, i16, byteArrayOutputStream);
            i16 -= 5;
            byteArray = byteArrayOutputStream.toByteArray();
        }
        if (z16) {
            bitmap.recycle();
        }
        return byteArray;
    }
}
