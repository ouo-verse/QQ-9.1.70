package com.tencent.mm.graphics;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class MMBitmapFactoryImpl {
    private static final int DENSITY_DEFAULT = 160;
    private static final int REWIND_BUFFER_SIZE = 8388608;
    private static final String TAG = "MicroMsg.MMBitmapFactory";
    private static final int TEMP_STORAGE_SIZE = 4096;
    private static com.tencent.luggage.wxa.ea.a sDecodeCanary = null;
    private static boolean sForceUsingSystemDecoderOpt = false;
    private static com.tencent.luggage.wxa.ea.b sMMCodecListener;
    private static final MMBitmapFactory.a[] sNativeLibraryLoader = {null};
    private static MMBitmapFactory.b sStreamProvider;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        public long f151692a;

        public b(FileInputStream fileInputStream) {
            super(fileInputStream);
            this.f151692a = 0L;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i3) {
            try {
                this.f151692a = ((FileInputStream) ((FilterInputStream) this).in).getChannel().position();
            } catch (IOException e16) {
                com.tencent.luggage.wxa.yp.b.a(MMBitmapFactoryImpl.TAG, e16, "fail to mark position.");
                this.f151692a = -1L;
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (this.f151692a >= 0) {
                ((FileInputStream) ((FilterInputStream) this).in).getChannel().position(this.f151692a);
            } else {
                throw new IOException("Illegal marked position: " + this.f151692a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final MMBitmapFactoryImpl f151693a = new MMBitmapFactoryImpl();
    }

    private void announceDecodeResult(BitmapFactory.Options options, Bitmap bitmap, boolean z16) {
        String str;
        assertNotNull(options, "[-] opts is null.");
        if (z16) {
            str = TVKPlayerMsg.PLAYER_CHOICE_SYSTEM;
        } else {
            str = "mmcodec";
        }
        if ((bitmap != null || options.outMimeType != null) && options.outWidth > 0 && options.outHeight > 0) {
            com.tencent.luggage.wxa.yp.b.c(TAG, "[+] decode success by %s, boundsOnly:%s, w:%s, h:%s, mime-type:%s, sampleSize:%s", str, Boolean.valueOf(options.inJustDecodeBounds), Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), options.outMimeType, Integer.valueOf(options.inSampleSize));
        } else {
            com.tencent.luggage.wxa.yp.b.b(TAG, "[+] fail to decode by %s", str);
        }
    }

    private static void assertNotNull(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    private Bitmap decodeByteArrayInternal(byte[] bArr, int i3, int i16, BitmapFactory.Options options) {
        boolean z16;
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (isForceSystemDecoder(options)) {
            com.tencent.luggage.wxa.yp.b.e(TAG, "[!] force decoding data by system codec.");
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i3, i16, options);
            announceDecodeResult(options, decodeByteArray, true);
            return decodeByteArray;
        }
        try {
            Bitmap nativeDecodeByteArray = nativeDecodeByteArray(bArr, i3, i16, options);
            if (options.outMimeType != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                announceDecodeResult(options, nativeDecodeByteArray, false);
                setDensityFromOptions(nativeDecodeByteArray, options);
                return scaleBitmapOnDemand(nativeDecodeByteArray, options);
            }
            com.tencent.luggage.wxa.yp.b.e(TAG, "[!] unsupported image format, try to decode with system codec.");
            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(bArr, i3, i16, options);
            announceDecodeResult(options, decodeByteArray2, true);
            return decodeByteArray2;
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.yp.b.a(TAG, th5, "decode failed.");
            return null;
        }
    }

    private Bitmap decodeFileDescriptorInternal(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        boolean z16;
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (isForceSystemDecoder(options)) {
            com.tencent.luggage.wxa.yp.b.d(TAG, "[!] force decoding fd %s by system codec.", fileDescriptor);
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
            announceDecodeResult(options, decodeFileDescriptor, true);
            return decodeFileDescriptor;
        }
        if (nativeIsSeekable(fileDescriptor)) {
            try {
                Bitmap nativeDecodeFileDescriptor = nativeDecodeFileDescriptor(fileDescriptor, getOrCreateStorageBuffer(options), rect, options);
                if (options.outMimeType != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    announceDecodeResult(options, nativeDecodeFileDescriptor, false);
                    setDensityFromOptions(nativeDecodeFileDescriptor, options);
                    return scaleBitmapOnDemand(nativeDecodeFileDescriptor, options);
                }
                com.tencent.luggage.wxa.yp.b.e(TAG, "[!] unsupported image format, try to decode with system codec.");
                Bitmap decodeFileDescriptor2 = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
                announceDecodeResult(options, decodeFileDescriptor2, true);
                return decodeFileDescriptor2;
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.yp.b.a(TAG, th5, "decode failed.");
                return null;
            }
        }
        try {
            fileInputStream = new FileInputStream(fileDescriptor);
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
        try {
            return decodeStreamInternal(fileInputStream, rect, options);
        } catch (Throwable th7) {
            th = th7;
            try {
                com.tencent.luggage.wxa.yp.b.a(TAG, th, "decode failed.");
                return null;
            } finally {
                closeQuietly(fileInputStream);
            }
        }
    }

    private Bitmap decodeFileInternal(String str, BitmapFactory.Options options) {
        InputStream inputStream;
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        boolean z16 = true;
        if (isForceSystemDecoder(options)) {
            com.tencent.luggage.wxa.yp.b.d(TAG, "[!] force decoding file %s by system codec.", str);
            return decodeFileWithStreamBySystemInternal(str, options);
        }
        try {
            inputStream = wrapUnResetableStreamOnDemand(getStreamFromPath(str));
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
        try {
            inputStream.mark(getCompatibleRewindBufferSize());
            Bitmap nativeDecodeStream = nativeDecodeStream(inputStream, null, options);
            if (options.outMimeType == null) {
                z16 = false;
            }
            if (z16) {
                announceDecodeResult(options, nativeDecodeStream, false);
                setDensityFromOptions(nativeDecodeStream, options);
                return scaleBitmapOnDemand(nativeDecodeStream, options);
            }
            com.tencent.luggage.wxa.yp.b.e(TAG, "[!] unsupported image format, try to decode with system codec.");
            return decodeFileWithStreamBySystemInternal(str, options);
        } catch (Throwable th6) {
            th = th6;
            try {
                com.tencent.luggage.wxa.yp.b.a(TAG, th, "decode failed.");
                return null;
            } finally {
                closeQuietly(inputStream);
            }
        }
    }

    private Bitmap decodeFileWithStreamBySystemInternal(String str, BitmapFactory.Options options) {
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            announceDecodeResult(options, decodeFile, true);
            return decodeFile;
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.yp.b.a(TAG, th5, "decode by system failed.");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap decodeStreamInternal(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        boolean z16;
        boolean z17;
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (inputStream instanceof AssetManager.AssetInputStream) {
            com.tencent.luggage.wxa.yp.b.e(TAG, "[!] force decoding stream by system codec since it's asset stream.");
        } else if (isForceSystemDecoder(options)) {
            com.tencent.luggage.wxa.yp.b.e(TAG, "[!] force decoding stream by system codec since specific options.");
        } else {
            z16 = false;
            if (!z16) {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, rect, options);
                announceDecodeResult(options, decodeStream, true);
                return decodeStream;
            }
            try {
                InputStream wrapUnResetableStreamOnDemand = wrapUnResetableStreamOnDemand(inputStream);
                wrapUnResetableStreamOnDemand.mark(getCompatibleRewindBufferSize());
                Bitmap nativeDecodeStream = nativeDecodeStream(wrapUnResetableStreamOnDemand, rect, options);
                if (options.outMimeType != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    announceDecodeResult(options, nativeDecodeStream, false);
                    setDensityFromOptions(nativeDecodeStream, options);
                    return scaleBitmapOnDemand(nativeDecodeStream, options);
                }
                com.tencent.luggage.wxa.yp.b.e(TAG, "[!] unsupported image format, try to decode with system codec.");
                wrapUnResetableStreamOnDemand.reset();
                wrapUnResetableStreamOnDemand.mark(getCompatibleRewindBufferSize());
                Bitmap decodeStream2 = BitmapFactory.decodeStream(wrapUnResetableStreamOnDemand, rect, options);
                announceDecodeResult(options, decodeStream2, true);
                return decodeStream2;
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.yp.b.a(TAG, th5, "decode failed.");
                return null;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private static int getCompatibleRewindBufferSize() {
        "HUAWEI".equals(Build.MANUFACTURER);
        return 8388608;
    }

    public static MMBitmapFactoryImpl getInstance() {
        return c.f151693a;
    }

    private static byte[] getOrCreateStorageBuffer(BitmapFactory.Options options) {
        byte[] bArr;
        if (options != null) {
            bArr = options.inTempStorage;
        } else {
            bArr = null;
        }
        if (bArr == null) {
            return new byte[4096];
        }
        return bArr;
    }

    private InputStream getStreamFromPath(@NonNull String str) throws IOException {
        return new FileInputStream(str);
    }

    private boolean isForceSystemDecoder(BitmapFactory.Options options) {
        Bitmap.Config config;
        if (!sForceUsingSystemDecoderOpt) {
            if (options != null && Build.VERSION.SDK_INT >= 26) {
                config = Bitmap.Config.HARDWARE;
                if (config.equals(options.inPreferredConfig)) {
                }
            }
            return false;
        }
        return true;
    }

    private void loadNativeModule(String str) {
        try {
            MMBitmapFactory.a[] aVarArr = sNativeLibraryLoader;
            synchronized (aVarArr) {
                MMBitmapFactory.a aVar = aVarArr[0];
                if (aVar != null) {
                    aVar.loadLibrary(str);
                } else {
                    System.loadLibrary(str);
                }
            }
            com.tencent.luggage.wxa.yp.b.c(TAG, "Successfully load native module: %s", str);
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.yp.b.a(TAG, th5, "Fail to load native module: %s", str);
            throw new RuntimeException(th5);
        }
    }

    private native void nativeAddExternalLibDir(String str);

    private native Bitmap nativeDecodeByteArray(byte[] bArr, int i3, int i16, BitmapFactory.Options options);

    private native Bitmap nativeDecodeFileDescriptor(FileDescriptor fileDescriptor, byte[] bArr, Rect rect, BitmapFactory.Options options);

    private native Bitmap nativeDecodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options);

    private native boolean nativeIsSeekable(FileDescriptor fileDescriptor);

    private native int nativePinBitmap(Bitmap bitmap);

    private native int nativeUnPinBitmap(Bitmap bitmap);

    private static Bitmap scaleBitmapOnDemand(Bitmap bitmap, BitmapFactory.Options options) {
        float f16;
        if (bitmap != null && options != null) {
            if (!options.inScaled) {
                return bitmap;
            }
            int i3 = options.inDensity;
            int i16 = options.inTargetDensity;
            int i17 = options.inScreenDensity;
            if (i3 != 0 && i16 != 0 && i3 != i17) {
                f16 = i16 / i3;
            } else {
                f16 = 1.0f;
            }
            if (f16 == 1.0f) {
                return bitmap;
            }
            int width = (int) ((bitmap.getWidth() * f16) + 0.5f);
            int height = (int) ((bitmap.getHeight() * f16) + 0.5f);
            float width2 = width / bitmap.getWidth();
            float height2 = height / bitmap.getHeight();
            com.tencent.luggage.wxa.yp.b.a(TAG, "[+] Bmp to scale: [sw: %s, sh: %s, dw: %s, dh: %s, scX: %s, scY: %s]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(width2), Float.valueOf(height2));
            Matrix matrix = new Matrix();
            matrix.setScale(width2, height2);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return bitmap;
    }

    private static void setDensityFromOptions(Bitmap bitmap, BitmapFactory.Options options) {
        boolean z16;
        if (bitmap != null && options != null) {
            int i3 = options.inDensity;
            if (i3 != 0) {
                bitmap.setDensity(i3);
                int i16 = options.inTargetDensity;
                if (i16 != 0 && i3 != i16 && i3 != options.inScreenDensity) {
                    byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                    if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (options.inScaled || z16) {
                        bitmap.setDensity(i16);
                        return;
                    }
                    return;
                }
                return;
            }
            if (options.inBitmap != null) {
                bitmap.setDensity(160);
            }
        }
    }

    public static void setForceUsingSystemDecoder(boolean z16) {
        com.tencent.luggage.wxa.yp.b.d(TAG, "[!] setForceUsingSystemDecoder, value: %s", Boolean.valueOf(z16));
        sForceUsingSystemDecoderOpt = z16;
    }

    public static void setNativeLibraryLoader(@Nullable MMBitmapFactory.a aVar) {
        MMBitmapFactory.a[] aVarArr = sNativeLibraryLoader;
        synchronized (aVarArr) {
            aVarArr[0] = aVar;
        }
    }

    private static InputStream wrapUnResetableStreamOnDemand(InputStream inputStream) {
        if (inputStream.markSupported()) {
            return inputStream;
        }
        if (inputStream instanceof FileInputStream) {
            return new b((FileInputStream) inputStream);
        }
        return new BufferedInputStream(inputStream);
    }

    public void addExternalCodecLibDir(String str) {
        com.tencent.luggage.wxa.yp.b.c(TAG, "[+] add external codec library path: %s", str);
        nativeAddExternalLibDir(str);
    }

    @Nullable
    public Bitmap decodeByteArray(byte[] bArr, int i3, int i16) {
        assertNotNull(bArr, "'data' is null.");
        return decodeByteArrayInternal(bArr, i3, i16, null);
    }

    @Nullable
    public Bitmap decodeFile(String str) {
        assertNotNull(str, "'pathName' is null.");
        return decodeFileInternal(str, null);
    }

    @Nullable
    public Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        assertNotNull(fileDescriptor, "'fd' is null.");
        return decodeFileDescriptorInternal(fileDescriptor, null, null);
    }

    @Nullable
    public Bitmap decodeResource(Resources resources, int i3) {
        com.tencent.luggage.wxa.yp.b.a(TAG, "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s", resources, Integer.valueOf(i3));
        return BitmapFactory.decodeResource(resources, i3);
    }

    @Nullable
    public Bitmap decodeResourceStream(@Nullable Resources resources, @Nullable TypedValue typedValue, @Nullable InputStream inputStream, @Nullable Rect rect, @Nullable BitmapFactory.Options options) {
        com.tencent.luggage.wxa.yp.b.a(TAG, "[*] transfer invocation to BitmapFactory.decodeResourceStream, res: %s, value: %s, is: %s, pad: %s, opts: %s", resources, typedValue, inputStream, rect, options);
        return BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
    }

    @Nullable
    public Bitmap decodeStream(InputStream inputStream) {
        assertNotNull(inputStream, "'is' is null.");
        return decodeStreamInternal(inputStream, null, null);
    }

    public Bitmap pinBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            com.tencent.luggage.wxa.yp.b.c(TAG, "[tomys] Try to pin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), bitmap.getConfig(), Integer.valueOf(bitmap.getByteCount()));
            int nativePinBitmap = nativePinBitmap(bitmap);
            if (nativePinBitmap < 0) {
                com.tencent.luggage.wxa.yp.b.b(TAG, "pinBitmap failed, ret: %s", Integer.valueOf(nativePinBitmap));
            }
        }
        return bitmap;
    }

    public Bitmap unPinBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            com.tencent.luggage.wxa.yp.b.c(TAG, "[tomys] Try to unpin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), bitmap.getConfig(), Integer.valueOf(bitmap.getByteCount()));
            int nativeUnPinBitmap = nativeUnPinBitmap(bitmap);
            if (nativeUnPinBitmap < 0) {
                com.tencent.luggage.wxa.yp.b.b(TAG, "unPinBitmap failed, ret: %s", Integer.valueOf(nativeUnPinBitmap));
            }
        }
        return bitmap;
    }

    MMBitmapFactoryImpl() {
        loadNativeModule("mmimgcodec");
    }

    @Nullable
    public Bitmap decodeByteArray(byte[] bArr, int i3, int i16, BitmapFactory.Options options) {
        assertNotNull(bArr, "'data' is null.");
        return decodeByteArrayInternal(bArr, i3, i16, options);
    }

    @Nullable
    public Bitmap decodeFile(String str, @Nullable BitmapFactory.Options options) {
        assertNotNull(str, "'pathName' is null.");
        return decodeFileInternal(str, options);
    }

    @Nullable
    public Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, @Nullable Rect rect, @Nullable BitmapFactory.Options options) {
        assertNotNull(fileDescriptor, "'fd' is null.");
        return decodeFileDescriptorInternal(fileDescriptor, rect, options);
    }

    @Nullable
    public Bitmap decodeResource(Resources resources, int i3, BitmapFactory.Options options) {
        com.tencent.luggage.wxa.yp.b.a(TAG, "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s, opts: %s", resources, Integer.valueOf(i3), options);
        return BitmapFactory.decodeResource(resources, i3, options);
    }

    @Nullable
    public Bitmap decodeStream(InputStream inputStream, @Nullable Rect rect, @Nullable BitmapFactory.Options options) {
        assertNotNull(inputStream, "'is' is null.");
        return decodeStreamInternal(inputStream, rect, options);
    }

    public static void setDecodeCanary(com.tencent.luggage.wxa.ea.a aVar) {
    }

    public static void setMMCodecListener(com.tencent.luggage.wxa.ea.b bVar) {
    }

    public static void setStreamProvider(MMBitmapFactory.b bVar) {
    }
}
