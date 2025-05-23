package cooperation.qzone.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.component.network.utils.Base64;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes28.dex */
public class GifCoder {
    private static final String LIB_SO_NAME = "androidndkgif";
    private static final String TAG = "GifCoder";
    public static final String TEMP_FILE_NAME_PREFIX = "tempfile_";
    private static boolean mNativeLibLoaded = false;
    private OnEncodeGifFinishedListener callBack;
    private int GIFPicSize = gifCoderWnsConfig.getCurrentDeviceGifSize();
    private boolean mPicSizeForLongEdge = false;
    private final int NONE = 0;
    private final int VERTICAL = 1;
    private final int HORIZONAL = 2;
    private int mLastPicOrientation = 0;
    private boolean mUserOrignalBitmap = false;
    private boolean mIsSetDither = true;
    private int mDispose = 0;
    private boolean mNeedRemoveSamePixels = true;
    private int mTransparentThreshold = 0;
    private String gifPalette = "";
    private EncodingType mEncodingType = EncodingType.ENCODING_TYPE_SIMPLE_FAST;
    private long instance = 0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum EncodingType {
        ENCODING_TYPE_SIMPLE_FAST,
        ENCODING_TYPE_NORMAL_LOW_MEMORY,
        ENCODING_TYPE_STABLE_HIGH_MEMORY,
        ENCODING_TYPE_FAST_WITH_HIGH_MEMORY
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface GifDispose {
        public static final int DO_NOT_DISPOSE = 1;
        public static final int NO_DISPOSAL_SPECIFIED = 0;
        public static final int RESTORE_TO_BACKGROUND_COLOR = 2;
        public static final int RESTORE_TO_PREVIOUS = 3;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface OnEncodeGifFinishedListener {
        void onFailed(String str);

        void onSuccess();
    }

    static {
        tryToLoadGifLib();
    }

    private Bitmap bitMapIsSameOrientation(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            int i3 = this.mLastPicOrientation;
            if (i3 != 1 && i3 != 0) {
                return null;
            }
            this.mLastPicOrientation = 1;
        } else if (width > height) {
            int i16 = this.mLastPicOrientation;
            if (i16 != 2 && i16 != 0) {
                return null;
            }
            this.mLastPicOrientation = 2;
        }
        return bitmap;
    }

    @TargetApi(19)
    static boolean canUseForInBitmap(Bitmap bitmap, BitmapFactory.Options options) {
        if (bitmap == null || !bitmap.isMutable() || bitmap.isRecycled()) {
            return false;
        }
        int i3 = options.outWidth;
        int i16 = options.inSampleSize;
        if ((i3 / i16) * (options.outHeight / i16) * getBytesPerPixel(bitmap.getConfig()) > bitmap.getAllocationByteCount()) {
            return false;
        }
        return true;
    }

    public static boolean checkIsValidTempFileName(String str) {
        if (str == null || str.length() > 50 || !str.startsWith("tempfile_")) {
            return false;
        }
        return Pattern.compile("[a-zA-Z0-9_]+").matcher(str).matches();
    }

    private String cutHeadIfNeeded(String str) {
        int indexOf;
        int i3;
        if (str == null) {
            return null;
        }
        if (str.startsWith("data:image") && (indexOf = str.indexOf("base64,")) >= 0 && (i3 = indexOf + 7) < str.length()) {
            return str.substring(i3);
        }
        return str;
    }

    private static Bitmap decodeBitmapFromBase64(String str, int i3, int i16, boolean z16, Bitmap bitmap) {
        int i17;
        if (str == null || "".equals(str) || str.length() <= 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            options.inJustDecodeBounds = false;
            if (i3 != 0 && i16 != 0) {
                if (z16) {
                    i17 = Math.max(options.outWidth / i3, options.outHeight / i16);
                } else {
                    i17 = Math.min(options.outWidth / i3, options.outHeight / i16);
                }
            } else {
                i17 = 1;
            }
            if (i17 < 1) {
                i17 = 1;
            }
            options.inSampleSize = i17;
            options.inMutable = true;
            if (canUseForInBitmap(bitmap, options)) {
                options.inBitmap = bitmap;
            }
            return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
        } catch (IllegalArgumentException e16) {
            QLog.w(TAG, 1, "", e16);
            return decodeBitmapFromBase64(str, i3, i16, z16, null);
        } catch (OutOfMemoryError e17) {
            QLog.e(TAG, 1, "", e17);
            return null;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "", th5);
            return null;
        }
    }

    static int getBytesPerPixel(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        Bitmap.Config config2 = Bitmap.Config.ALPHA_8;
        return 1;
    }

    public static Bitmap getTransparentBitmap(Bitmap bitmap, int i3) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i16 = (i3 * 255) / 100;
        for (int i17 = 0; i17 < width; i17++) {
            int i18 = iArr[i17];
            int i19 = (i18 >> 24) & 255;
            int i26 = (i18 >> 8) & 255;
            int i27 = (i18 >> 16) & 255;
            if (i27 == 0 && i26 == 0 && i27 == 0 && i19 == 0) {
                iArr[i17] = 16777215;
                iArr[i17] = (16777215 & 16777215) | (i16 << 24);
            }
        }
        return Bitmap.createBitmap(iArr, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }

    private void initPalette() {
        if (this.gifPalette.length() <= 0) {
            return;
        }
        File file = new File(this.gifPalette);
        if (!file.exists()) {
            return;
        }
        Bitmap decodeBitmapFromFile = PhotoUtils.decodeBitmapFromFile(this.gifPalette, null);
        if (decodeBitmapFromFile != null) {
            nativeSetPalette(this.instance, decodeBitmapFromFile, decodeBitmapFromFile.getWidth(), decodeBitmapFromFile.getHeight());
        }
        file.delete();
    }

    public static boolean isFullTransBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.getWidth() <= 2 || bitmap.getHeight() <= 2) {
            return false;
        }
        try {
            int pixel = bitmap.getPixel(1, 1) >> 24;
            int pixel2 = bitmap.getPixel(bitmap.getWidth() - 2, bitmap.getHeight() - 2) >> 24;
            if (pixel != 0 || pixel2 != 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    private static synchronized boolean loadNativeLib(String str) {
        boolean z16;
        synchronized (GifCoder.class) {
            try {
                QLog.i(TAG, 1, "gif lib start load");
                System.loadLibrary(str);
                QLog.i(TAG, 1, "gif lib load success");
                mNativeLibLoaded = true;
            } catch (Throwable th5) {
                mNativeLibLoaded = false;
                QLog.e(TAG, 1, "gif lib load happen Exception error: ", th5);
            }
            z16 = mNativeLibLoaded;
        }
        return z16;
    }

    private native boolean nativeEncodeFrame(long j3, Bitmap bitmap, int i3);

    private native void nativeEncoderClose(long j3);

    private native long nativeEncoderInit(int i3, int i16, String str, int i17);

    private native void nativeEncoderSetDispose(long j3, int i3);

    private native void nativeEncoderSetDither(long j3, boolean z16);

    private native void nativeSetNeedRemoveSamePixels(long j3, boolean z16);

    private native void nativeSetPalette(long j3, Bitmap bitmap, int i3, int i16);

    private native void nativeSetTransparentThreshold(long j3, int i3);

    public static String readFile(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream2.available() + 1];
                    fileInputStream2.read(bArr);
                    String str = new String(bArr, "UTF-8");
                    fileInputStream2.close();
                    return str;
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return "";
                } catch (Throwable unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return "";
                }
            } catch (Throwable unused2) {
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private static boolean tryToLoadGifEncoderSo() {
        return false;
    }

    public static boolean tryToLoadGifLib() {
        try {
            System.loadLibrary("c++_shared");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "tryToLoad c++_shared fail", th5);
        }
        return loadNativeLib(LIB_SO_NAME);
    }

    public static Bitmap zoomImage(Bitmap bitmap, double d16, double d17, int i3, boolean z16) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            QLog.i(TAG, 1, "need zoom bgimage is null");
            return null;
        }
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float f16 = ((float) d16) / width;
        float f17 = ((float) d17) / height;
        if (!z16 ? f16 <= f17 : f16 > f17) {
            f16 = f17;
        }
        matrix.postScale(f16, f16);
        matrix.postRotate(i3);
        int i16 = (int) width;
        int i17 = (int) height;
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, i16, i17, matrix, true);
        } catch (Throwable unused) {
            System.gc();
            try {
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, i16, i17, matrix, true);
            } catch (Throwable unused2) {
                QLog.i(TAG, 1, "zoomImage happen exception");
                System.gc();
            }
        }
        if (isFullTransBitmap(bitmap2)) {
            return getTransparentBitmap(bitmap2, 100);
        }
        return bitmap2;
    }

    public void closeEncoder() {
        if (mNativeLibLoaded && this.instance != 0) {
            QLog.i(TAG, 1, "start close gifEncoder");
            nativeEncoderClose(this.instance);
            QLog.i(TAG, 1, "close gifEncoder success");
            this.instance = 0L;
        }
    }

    public boolean encodeFrame(Bitmap bitmap, int i3) {
        if (!mNativeLibLoaded || 0 == this.instance) {
            return false;
        }
        if (bitmap == null) {
            QLog.e(TAG, 1, "[encodeFrame] bitmap is null, error: ", new Exception());
            return false;
        }
        QLog.i(TAG, 1, "start encodeFrame");
        nativeEncodeFrame(this.instance, bitmap, i3);
        QLog.i(TAG, 1, "encodeFrame success");
        return true;
    }

    public boolean encodeGif(Bitmap bitmap, String str, int i3) {
        return encodeGif(bitmap, str, i3, false);
    }

    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r8v8 */
    public boolean encodeGifFromBase64(String str, JSONArray jSONArray, int i3, boolean z16, boolean z17) {
        String cutHeadIfNeeded;
        Bitmap decodeBitmapFromBase64;
        boolean z18;
        int width;
        int height;
        ?? r75 = 0;
        ?? r85 = 1;
        if (!mNativeLibLoaded) {
            tryToLoadGifLib();
            if (!mNativeLibLoaded) {
                QLog.w(TAG, 1, "gif lib loaded failed 2");
                return false;
            }
        }
        QLog.i(TAG, 1, "saxon gif mUserOrignalBitmap=" + z16 + ",perFrameTime=" + i3);
        this.mLastPicOrientation = 0;
        Bitmap bitmap = null;
        int i16 = 0;
        boolean z19 = false;
        while (i16 < jSONArray.length()) {
            if (z17) {
                String optString = jSONArray.optString(i16);
                if (!checkIsValidTempFileName(optString)) {
                    QLog.e(TAG, (int) r85, "file name is invalid. name=" + optString);
                    return r75;
                }
                String path = CacheManager.getWebviewOfflineFileCacheService().getPath(optString);
                if (TextUtils.isEmpty(path)) {
                    QLog.e(TAG, (int) r85, "[encodeGifFromBase64] file path is empty.");
                    return r75;
                }
                File file = new File(path);
                if (!file.exists()) {
                    QLog.e(TAG, (int) r85, "file not exist: " + path);
                    return r75;
                }
                try {
                    String readFile = readFile(file);
                    if (readFile != null && readFile.length() != 0) {
                        QLog.i(TAG, r85, "saxon gif read filePath:" + path + ",content len=" + readFile.length());
                        cutHeadIfNeeded = cutHeadIfNeeded(readFile);
                    }
                    QLog.e(TAG, (int) r85, "file is empty: " + path);
                    return r75;
                } catch (IOException e16) {
                    QLog.e(TAG, (int) r85, "read file error: " + path, e16);
                    return r75;
                }
            }
            cutHeadIfNeeded = cutHeadIfNeeded(jSONArray.optString(i16));
            if (z16) {
                decodeBitmapFromBase64 = decodeBitmapFromBase64(cutHeadIfNeeded, r75, r75, this.mPicSizeForLongEdge, bitmap);
            } else {
                int i17 = this.GIFPicSize;
                decodeBitmapFromBase64 = decodeBitmapFromBase64(cutHeadIfNeeded, i17, i17, this.mPicSizeForLongEdge, bitmap);
            }
            if (!z19 && decodeBitmapFromBase64 != null) {
                try {
                    initEncoder(decodeBitmapFromBase64.getWidth(), decodeBitmapFromBase64.getHeight(), str, this.mEncodingType);
                    z19 = r85;
                } catch (Exception unused) {
                    File file2 = new File(str);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    QLog.i(TAG, r85, "initEncoder happen exception");
                    return r75;
                }
            }
            if (decodeBitmapFromBase64 == null) {
                z18 = r85;
            } else {
                z18 = r75;
            }
            if (decodeBitmapFromBase64 == null) {
                width = r75;
            } else {
                width = decodeBitmapFromBase64.getWidth();
            }
            if (decodeBitmapFromBase64 == null) {
                height = r75;
            } else {
                height = decodeBitmapFromBase64.getHeight();
            }
            r85 = 1;
            QLog.i(TAG, 1, "saxon gif i=" + i16 + ",bitmapIsNull= " + z18 + ",width=" + width + ",height=" + height + ", base64 len=" + cutHeadIfNeeded.length());
            if (decodeBitmapFromBase64 != null) {
                encodeFrame(decodeBitmapFromBase64, i3);
            } else {
                QLog.e(TAG, 1, "bitmap is null, not call encodeFrame");
            }
            if (bitmap == null) {
                bitmap = decodeBitmapFromBase64;
            }
            i16++;
            r75 = 0;
        }
        closeEncoder();
        return r85;
    }

    public void initEncoder(int i3, int i16, String str) throws FileNotFoundException {
        if (!mNativeLibLoaded) {
            tryToLoadGifLib();
            if (!mNativeLibLoaded) {
                return;
            }
        }
        initEncoder(i3, i16, str, EncodingType.ENCODING_TYPE_SIMPLE_FAST);
    }

    public void setEncoderDispose(int i3) {
        this.mDispose = i3;
    }

    public void setEncoderDither(boolean z16) {
        if (!mNativeLibLoaded) {
            return;
        }
        this.mIsSetDither = z16;
    }

    public void setEncoderGifPicSizeForLongEdge(boolean z16) {
        this.mPicSizeForLongEdge = z16;
    }

    public void setEncoderGifSize(int i3) {
        this.GIFPicSize = i3;
    }

    public void setEncodingType(EncodingType encodingType) {
        this.mEncodingType = encodingType;
    }

    public void setNeedRemoveSamePixels(boolean z16) {
        this.mNeedRemoveSamePixels = z16;
    }

    public void setPaletteData(String str) {
        this.gifPalette = str;
    }

    public void setTransparentThreshold(int i3) {
        this.mTransparentThreshold = i3;
    }

    public void setUseOrignalBitmap(boolean z16) {
        this.mUserOrignalBitmap = z16;
    }

    public boolean encodeGif(Bitmap bitmap, String str, int i3, boolean z16) {
        if (bitmap == null) {
            return false;
        }
        if (!mNativeLibLoaded) {
            tryToLoadGifLib();
            if (!mNativeLibLoaded) {
                QLog.w(TAG, 1, "gif lib loaded failed 1");
                return false;
            }
        }
        if (this.mUserOrignalBitmap) {
            if (isFullTransBitmap(bitmap)) {
                bitmap = getTransparentBitmap(bitmap, 100);
            }
        } else {
            int i16 = this.GIFPicSize;
            bitmap = zoomImage(bitmap, i16, i16, 0, this.mPicSizeForLongEdge);
        }
        if (this.instance == 0) {
            try {
                initEncoder(bitmap.getWidth(), bitmap.getHeight(), str, this.mEncodingType);
            } catch (Throwable th5) {
                th5.printStackTrace();
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                QLog.i(TAG, 1, "initEncoder happen exception");
                return false;
            }
        }
        return encodeFrame(bitmap, i3);
    }

    public void initEncoder(int i3, int i16, String str, EncodingType encodingType) throws FileNotFoundException {
        if (!mNativeLibLoaded) {
            tryToLoadGifLib();
            if (!mNativeLibLoaded) {
                return;
            }
        }
        if (0 != this.instance) {
            closeEncoder();
        }
        QLog.i(TAG, 1, "start nativeEncoderInit");
        this.instance = nativeEncoderInit(i3, i16, str, encodingType.ordinal());
        QLog.i(TAG, 1, "nativeEncoderInit success");
        if (0 != this.instance) {
            QLog.i(TAG, 1, "start nativeEncoderSetDither");
            nativeEncoderSetDither(this.instance, this.mIsSetDither);
            QLog.i(TAG, 1, "nativeEncoderSetDither success");
            QLog.i(TAG, 1, "start nativeEncoderSetDispose");
            nativeEncoderSetDispose(this.instance, this.mDispose);
            QLog.i(TAG, 1, "nativeEncoderSetDispose success");
            QLog.i(TAG, 1, "start nativeSetNeedRemoveSamePixels");
            nativeSetNeedRemoveSamePixels(this.instance, this.mNeedRemoveSamePixels);
            QLog.i(TAG, 1, "nativeSetNeedRemoveSamePixels success");
            QLog.i(TAG, 1, "start nativeSetTransparentThreshold");
            nativeSetTransparentThreshold(this.instance, this.mTransparentThreshold);
            QLog.i(TAG, 1, "nativeSetTransparentThreshold success");
            return;
        }
        throw new FileNotFoundException();
    }

    public boolean encodeGif(String str, ArrayList<String> arrayList, int i3) {
        return encodeGif(str, arrayList, i3, false);
    }

    public boolean encodeGif(String str, ArrayList<String> arrayList, int i3, boolean z16) {
        Bitmap decodeBitmapFromFile;
        int i16;
        if (!mNativeLibLoaded) {
            if (z16) {
                if (tryToLoadGifEncoderSo()) {
                    tryToLoadGifLib();
                }
            } else {
                tryToLoadGifLib();
            }
            if (!mNativeLibLoaded) {
                QLog.w(TAG, 1, "gif lib loaded failed 3");
                return false;
            }
        }
        this.mLastPicOrientation = 0;
        Iterator<String> it = arrayList.iterator();
        Bitmap bitmap = null;
        boolean z17 = false;
        while (it.hasNext()) {
            String next = it.next();
            if (this.mUserOrignalBitmap) {
                decodeBitmapFromFile = PhotoUtils.decodeBitmapFromFile(next, bitmap);
            } else {
                int i17 = this.GIFPicSize;
                decodeBitmapFromFile = PhotoUtils.decodeBitmapFromFile(next, i17, i17, this.mPicSizeForLongEdge, bitmap);
            }
            Bitmap bitmap2 = decodeBitmapFromFile;
            if (bitmap == null) {
                bitmap = bitmap2;
            }
            int picRotate = PhotoUtils.getPicRotate(next);
            if (!this.mUserOrignalBitmap) {
                int i18 = this.GIFPicSize;
                bitmap2 = zoomImage(bitmap2, i18, i18, picRotate, this.mPicSizeForLongEdge);
            }
            Bitmap bitMapIsSameOrientation = bitMapIsSameOrientation(bitmap2);
            if (bitMapIsSameOrientation == null) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                QLog.i(TAG, 1, "decode bitmap is NULL,decode pic = " + next);
            } else {
                if (z17) {
                    i16 = i3;
                } else {
                    try {
                        initEncoder(bitMapIsSameOrientation.getWidth(), bitMapIsSameOrientation.getHeight(), str, this.mEncodingType);
                        initPalette();
                        i16 = i3;
                        z17 = true;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        File file2 = new File(str);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        QLog.i(TAG, 1, "initEncoder happen exception");
                        return false;
                    }
                }
                encodeFrame(bitMapIsSameOrientation, i16);
            }
        }
        closeEncoder();
        return true;
    }
}
