package com.tencent.hippy.qq.adapter.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.adapter.image.decoder.ImageDetector;
import com.tencent.hippy.qq.obj.PerformanceData;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.m;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyImageInfo {
    private static final String FIELD_THIS = "this$0";
    public static final String IMAGE_FLAG_BMP = "424D";
    public static final String IMAGE_FLAG_GIF = "47494638";
    public static final String IMAGE_FLAG_JPG = "FFD8FF";
    public static final String IMAGE_FLAG_PNG = "89504E470D0A1A0A";
    public static final String IMAGE_FLAG_TIF = "49492A00";
    public static final String IMAGE_TYPE_AVIF = "avif";
    public static final String IMAGE_TYPE_BMP = "bmp";
    public static final String IMAGE_TYPE_GIF = "gif";
    public static final String IMAGE_TYPE_JPG = "jpg";
    private static final String IMAGE_TYPE_PNG = "png";
    public static final String IMAGE_TYPE_TIF = "tif";
    public static final String IMAGE_TYPE_WEBP = "webp";
    static final int MAX_READ_APNG_HEADER_LENGTH = 80;
    public static final String MIME_TYPE_IMAGE = "image/*";
    public static final String MIME_TYPE_PNG = "image/png";
    private static final String PROTOCOL_FILE = "file:";
    private static final String PROTOCOL_HTTP = "http:";
    private static final String PROTOCOL_HTTPS = "https:";
    public static final String QUALITY_HIGH = "high";
    public static final String QUALITY_LOW = "low";
    public static final String RESIZE_MODE_COVER = "cover";
    private static final String TAG = "HippyImageInfo";
    private static final int WEBP_HEADER_LENGTH = 12;
    private String mImageCacheKey;
    public final SoftReference<HippyImageLoader.Callback> refCallback;
    public int repeatCount;
    public int reqHeight;
    public int reqWidth;
    public String url;
    static final byte[] PNG_SIG = {-119, 80, 78, 71, 13, 10, 26, 10};
    static final byte[] SIGNATURE_APNG = {97, 99, 84, 76};
    private static final byte[] WEBP_FILE_HEADER_WEBP = "WEBP".getBytes();
    private static final byte[] WEBP_FILE_HEADER_RIFF = "RIFF".getBytes();
    public String resizeMode = "";
    private String type = "";
    public String quality = QUALITY_LOW;
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());
    private final PerformanceData mPerformanceData = new PerformanceData();

    public HippyImageInfo(String str, Object obj, HippyImageLoader.Callback callback) {
        setUrl(str);
        setProperties(getPropertiesMap(obj));
        generateImageCacheKey();
        this.refCallback = new SoftReference<>(callback);
        bindImageInfo(callback);
    }

    private void bindImageInfo(HippyImageLoader.Callback callback) {
        HippyImageLoader.Callback callback2;
        SoftReference<HippyImageLoader.Callback> softReference = this.refCallback;
        if (softReference != null) {
            callback2 = softReference.get();
        } else {
            callback2 = null;
        }
        if (callback2 == null) {
            return;
        }
        try {
            Field declaredField = callback.getClass().getDeclaredField(FIELD_THIS);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(callback2);
            if (obj instanceof HippyQQImageView) {
                ((HippyQQImageView) obj).bindImageInfo(this);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0021, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int bytesSearch(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            int i3 = 0;
            while (i3 < (bArr.length - bArr2.length) + 1) {
                for (int i16 = 0; i16 < bArr2.length; i16++) {
                    if (bArr[i3 + i16] != bArr2[i16]) {
                        break;
                    }
                }
                return i3;
            }
        }
        return -1;
    }

    private boolean checkImageTypeFromFileHeader() {
        if (!"apng".equals(this.type) && !"gif".equals(this.type) && !"png".equals(this.type)) {
            return true;
        }
        return false;
    }

    public static int computeSimilarSampleSize(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        int i19 = 1;
        if (i3 > 0 && i16 > 0) {
            while (i17 > i16 && i18 > i3) {
                int round = Math.round(i17 / i16);
                int round2 = Math.round(i18 / i3);
                if (round <= round2) {
                    round = round2;
                }
                if (round < 2) {
                    break;
                }
                i18 >>= 1;
                i17 >>= 1;
                i19 <<= 1;
            }
        }
        return i19;
    }

    public static int computeStrictSampleSize(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        int i19 = 1;
        if (i3 > 0 && i16 > 0) {
            while (i17 > i16 && i18 > i3) {
                int i26 = i18 / i3;
                int i27 = i17 / i16;
                if (i27 < i26) {
                    i26 = i27;
                }
                if (i26 < 2) {
                    break;
                }
                i18 >>= 1;
                i17 >>= 1;
                i19 <<= 1;
            }
        }
        return i19;
    }

    private void generateImageCacheKey() {
        this.mImageCacheKey = this.reqWidth + "_" + this.reqHeight + "_" + this.url;
    }

    public static String getImageType(File file) {
        FileInputStream fileInputStream;
        String str;
        byte[] bArr = new byte[16];
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException unused) {
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            fileInputStream.read(bArr, 0, 16);
            String upperCase = HexUtil.bytes2HexStr(bArr).toUpperCase();
            if (upperCase.contains(IMAGE_FLAG_JPG)) {
                str = "jpg";
            } else if (upperCase.contains(IMAGE_FLAG_PNG)) {
                str = "png";
            } else if (upperCase.contains(IMAGE_FLAG_GIF)) {
                str = "gif";
            } else if (upperCase.contains(IMAGE_FLAG_TIF)) {
                str = IMAGE_TYPE_TIF;
            } else if (upperCase.contains(IMAGE_FLAG_BMP)) {
                str = "bmp";
            } else if (isWebp(bArr)) {
                str = "webp";
            } else {
                FileInputStream fileInputStream3 = new FileInputStream(file);
                if (ImageDetector.isAvif(fileInputStream3)) {
                    upperCase = "avif";
                }
                fileInputStream3.close();
                str = upperCase;
            }
            try {
                fileInputStream.close();
            } catch (IOException e16) {
                QLog.e(TAG, 1, "file read errors!" + e16.getMessage());
            }
            return str;
        } catch (IOException unused2) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    QLog.e(TAG, 1, "file read errors!" + e17.getMessage());
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e18) {
                    QLog.e(TAG, 1, "file read errors!" + e18.getMessage());
                }
            }
            throw th;
        }
    }

    private HippyMap getPropertiesMap(Object obj) {
        if (obj instanceof Map) {
            obj = ((Map) obj).get("props");
        }
        if (obj instanceof HippyMap) {
            return (HippyMap) obj;
        }
        return new HippyMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        if (bytesSearch(r3, com.tencent.hippy.qq.adapter.image.HippyImageInfo.SIGNATURE_APNG) <= 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004d, code lost:
    
        com.tencent.qphone.base.util.QLog.e(com.tencent.hippy.qq.adapter.image.HippyImageInfo.TAG, 1, "isApngFile close e:", r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isApngFile(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[80];
            int read = randomAccessFile.read(bArr);
            randomAccessFile.close();
            boolean z16 = false;
            if (read < 80) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th6) {
                    QLog.e(TAG, 1, "isApngFile close e:", th6);
                }
                return false;
            }
            int i3 = 0;
            while (true) {
                byte[] bArr2 = PNG_SIG;
                if (i3 >= bArr2.length) {
                    break;
                }
                if (bArr[i3] != bArr2[i3]) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th7) {
                        QLog.e(TAG, 1, "isApngFile close e:", th7);
                    }
                    return false;
                }
                i3++;
            }
            return z16;
        } catch (Throwable th8) {
            th = th8;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Throwable th9) {
                    QLog.e(TAG, 1, "isApngFile close e:", th9);
                }
            }
            throw th;
        }
    }

    private boolean isLargeMemoryDevice() {
        if (m.c() >= 6442450944L) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0018, code lost:
    
        r2 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001a, code lost:
    
        if (r2 >= 12) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0024, code lost:
    
        if (com.tencent.hippy.qq.adapter.image.HippyImageInfo.WEBP_FILE_HEADER_WEBP[r2 - 8] == r6[r2]) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0027, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0026, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002a, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isWebp(byte[] bArr) {
        try {
            if (bArr.length < 12) {
                return false;
            }
            int i3 = 0;
            while (true) {
                byte[] bArr2 = WEBP_FILE_HEADER_RIFF;
                if (i3 >= bArr2.length) {
                    break;
                }
                if (bArr2[i3] != bArr[i3]) {
                    return false;
                }
                i3++;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "isWebp,e:" + e16.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestFail(Throwable th5, String str) {
        HippyImageLoader.Callback callback;
        getPerformanceData().recordDataLoadEndTime();
        SoftReference<HippyImageLoader.Callback> softReference = this.refCallback;
        if (softReference != null) {
            callback = softReference.get();
        } else {
            callback = null;
        }
        if (callback != null) {
            callback.onRequestFail(th5, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onRequestSuccess, reason: merged with bridge method [inline-methods] */
    public void lambda$onRequestSuccessInUiThread$0(HippyDrawable hippyDrawable) {
        HippyImageLoader.Callback callback;
        getPerformanceData().recordDataLoadEndTime();
        SoftReference<HippyImageLoader.Callback> softReference = this.refCallback;
        if (softReference != null) {
            callback = softReference.get();
        } else {
            callback = null;
        }
        if (callback != null) {
            callback.onRequestSuccess(hippyDrawable);
        }
    }

    private void setProperties(HippyMap hippyMap) {
        HippyMap map;
        if (hippyMap == null) {
            return;
        }
        if (hippyMap.containsKey("style") && (map = hippyMap.getMap("style")) != null) {
            this.reqWidth = Math.round(PixelUtil.dp2px(map.getDouble("width")));
            this.reqHeight = Math.round(PixelUtil.dp2px(map.getDouble("height")));
            this.resizeMode = map.getString(NodeProps.RESIZE_MODE);
        }
        this.repeatCount = hippyMap.getInt("repeatCount");
        this.type = hippyMap.getString(NodeProps.CUSTOM_PROP_IMAGE_TYPE);
        if (hippyMap.getBoolean(NodeProps.CUSTOM_PROP_ISGIF)) {
            this.type = "gif";
        }
        if (TextUtils.isEmpty(this.resizeMode)) {
            this.resizeMode = hippyMap.getString(NodeProps.RESIZE_MODE);
        }
        String string = hippyMap.getString(CustomImageProps.QUALITY);
        this.quality = string;
        if (TextUtils.isEmpty(string)) {
            this.quality = QUALITY_LOW;
        }
        if (this.repeatCount < 0) {
            this.repeatCount = 0;
        }
        if (this.resizeMode == null) {
            this.resizeMode = "";
        }
        if (this.type == null) {
            this.type = "";
        }
    }

    private void setUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("//")) {
            str = PROTOCOL_HTTPS + str;
        }
        if (!str.startsWith(PROTOCOL_HTTP) && !str.startsWith(PROTOCOL_HTTPS) && !str.startsWith("file:")) {
            return;
        }
        if (str.startsWith("file:") && (str.contains("\\..\\") || str.contains("/../") || str.contains("\\../") || str.contains("/..\\"))) {
            return;
        }
        this.url = str;
    }

    public Bitmap decodeStaticImage(File file) {
        try {
            String absolutePath = file.getAbsolutePath();
            if (isHighQuality()) {
                return decodeStaticImage(absolutePath, 1, Bitmap.Config.ARGB_8888);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            if (isLargeMemoryDevice()) {
                return decodeStaticImage(absolutePath, computeStrictSampleSize(options, this.reqWidth, this.reqHeight), Bitmap.Config.ARGB_8888);
            }
            int computeSimilarSampleSize = computeSimilarSampleSize(options, this.reqWidth, this.reqHeight);
            boolean equals = "image/png".equals(options.outMimeType);
            Bitmap decodeStaticImage = decodeStaticImage(absolutePath, computeSimilarSampleSize, equals ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            if (!equals || decodeStaticImage == null || !decodeStaticImage.hasAlpha()) {
                return decodeStaticImage;
            }
            decodeStaticImage.recycle();
            return decodeStaticImage(absolutePath, computeSimilarSampleSize, Bitmap.Config.RGB_565);
        } catch (OutOfMemoryError e16) {
            QLog.e(TAG, 1, "decodeStaticImage error:", e16);
            return null;
        }
    }

    public String getImageCacheKey() {
        return this.mImageCacheKey;
    }

    @NonNull
    public PerformanceData getPerformanceData() {
        return this.mPerformanceData;
    }

    public boolean isApng(File file) throws IOException {
        if (checkImageTypeFromFileHeader()) {
            return isApngFile(file);
        }
        return "apng".equals(this.type);
    }

    public boolean isAvif(File file) {
        if (file == null) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    boolean isAvif = ImageDetector.isAvif(fileInputStream2);
                    HippyUtils.safeClose(fileInputStream2);
                    return isAvif;
                } catch (IOException e16) {
                    e = e16;
                    fileInputStream = fileInputStream2;
                    QLog.e(TAG, 1, "isAvif e:", e);
                    HippyUtils.safeClose(fileInputStream);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    HippyUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e17) {
            e = e17;
        }
    }

    public boolean isGif(File file) {
        if (checkImageTypeFromFileHeader()) {
            return GifDrawable.isGifFile(file);
        }
        return "gif".equals(this.type);
    }

    public boolean isHighQuality() {
        return "high".equals(this.quality);
    }

    public void onRequestFailInUiThread(String str) {
        onRequestFailInUiThread(null, str);
    }

    public void onRequestSuccessInUiThread(Bitmap bitmap) {
        HippyDrawable hippyDrawable = new HippyDrawable();
        hippyDrawable.setImageType("image/*");
        hippyDrawable.setData(bitmap);
        onRequestSuccessInUiThread(hippyDrawable);
    }

    public void onRequestFailInUiThread(final Throwable th5, final String str) {
        this.mPerformanceData.recordDecodeEndTime();
        if (th5 == null) {
            th5 = new Exception("HippyImageFailure");
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            onRequestFail(th5, str);
        } else {
            this.mUiHandler.post(new Runnable() { // from class: com.tencent.hippy.qq.adapter.image.HippyImageInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    HippyImageInfo.this.onRequestFail(th5, str);
                }
            });
        }
    }

    public void onRequestSuccessInUiThread(final HippyDrawable hippyDrawable) {
        this.mPerformanceData.recordDecodeEndTime();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            lambda$onRequestSuccessInUiThread$0(hippyDrawable);
        } else {
            this.mUiHandler.post(new Runnable() { // from class: com.tencent.hippy.qq.adapter.image.a
                @Override // java.lang.Runnable
                public final void run() {
                    HippyImageInfo.this.lambda$onRequestSuccessInUiThread$0(hippyDrawable);
                }
            });
        }
    }

    private Bitmap decodeStaticImage(String str, int i3, Bitmap.Config config) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i3;
            options.inPreferredConfig = config;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e16) {
            QLog.e(TAG, 1, "decodeStaticImage error:", e16);
            return null;
        }
    }
}
