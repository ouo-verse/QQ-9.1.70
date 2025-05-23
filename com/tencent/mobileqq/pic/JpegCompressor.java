package com.tencent.mobileqq.pic;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class JpegCompressor {
    static IPatchRedirector $redirector_ = null;
    public static final int COLOR_SPACE_GRAY = 3;
    public static final int COLOR_SPACE_RGB = 1;
    public static final int COLOR_SPACE_RGBA = 2;
    static boolean soLoadStatus;
    private long nativePtr;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class JpegDataDestImpl implements JpegDataDest {
        static IPatchRedirector $redirector_;
        private FileOutputStream writer;

        public JpegDataDestImpl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.writer = null;
            File file = new File(str);
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                this.writer = new FileOutputStream(file);
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.mobileqq.pic.JpegDataDest
        public void dataArrived(ByteBuffer byteBuffer, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, byteBuffer, Boolean.valueOf(z16), obj);
                return;
            }
            try {
                int capacity = byteBuffer.capacity();
                byte[] bArr = new byte[capacity];
                byteBuffer.get(bArr);
                this.writer.write(bArr, 0, capacity);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (z16) {
                try {
                    this.writer.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14877);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        soLoadStatus = false;
        try {
            jpegcompressLoadSo();
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            soLoadStatus = false;
        }
    }

    public JpegCompressor(JpegDataDest jpegDataDest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jpegDataDest);
        } else {
            try {
                this.nativePtr = init(jpegDataDest);
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    }

    private native long compressBitMap(long j3, Bitmap bitmap, byte[] bArr);

    private native long compressByteArray(long j3, byte[] bArr, int i3, int i16, int i17, byte[] bArr2);

    private native int compressCb(long j3, Bitmap bitmap);

    public static void compressJpeg(Bitmap bitmap, String str, JpegCompressOptions jpegCompressOptions) throws Exception {
        JpegCompressor jpegCompressor = new JpegCompressor(new JpegDataDestImpl(str));
        if (jpegCompressOptions == null) {
            jpegCompressOptions = JpegCompressOptions.DEFAULT;
        }
        try {
            jpegCompressor.setParams(jpegCompressOptions.CompressQuality, jpegCompressOptions.isOptimize, jpegCompressOptions.isProgress, jpegCompressOptions.isArithCode, jpegCompressOptions.isPreferQualityOverSpeed);
            jpegCompressor.compress(bitmap);
        } finally {
            jpegCompressor.close();
        }
    }

    private native void destroy(long j3);

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        if (r7 == null) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float getJpegQuality(String str) {
        IOException e16;
        BufferedInputStream bufferedInputStream;
        FileNotFoundException e17;
        if (!soLoadStatus) {
            JpegError.throwException(50);
        }
        int i3 = 0;
        float f16 = 0.0f;
        ?? r26 = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)));
            } catch (FileNotFoundException e18) {
                e17 = e18;
                bufferedInputStream = null;
            } catch (IOException e19) {
                e16 = e19;
                bufferedInputStream = null;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th5) {
                th = th5;
                if (r26 != 0) {
                }
                throw th;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1000);
                byte[] bArr = new byte[1000];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                f16 = getQuality(byteArray, byteArray.length);
            } catch (FileNotFoundException e26) {
                e17 = e26;
                e17.printStackTrace();
            } catch (IOException e27) {
                e16 = e27;
                e16.printStackTrace();
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (i3 != 0) {
                }
                return f16;
            } catch (UnsatisfiedLinkError unused2) {
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                i3 = 52;
                if (i3 != 0) {
                }
                return f16;
            }
            try {
                bufferedInputStream.close();
            } catch (IOException unused4) {
                if (i3 != 0) {
                    JpegError.throwException(i3);
                }
                return f16;
            }
        } catch (Throwable th6) {
            th = th6;
            r26 = str;
            if (r26 != 0) {
                try {
                    r26.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private static native float getQuality(byte[] bArr, int i3);

    private native long init(JpegDataDest jpegDataDest);

    public static void jpegcompressLoadSo() {
        if (!soLoadStatus && JpegSoLoad.LoadJpegExtractedSo(JpegSoLoad.SO_NAME, BaseApplication.getContext()) == 0) {
            Bitmap createBitmap = Bitmap.createBitmap(new int[]{Color.argb(255, 0, 1, 2)}, 1, 1, Bitmap.Config.ARGB_8888);
            if (createBitmap != null) {
                predictPixelStorage(createBitmap);
            }
            soLoadStatus = true;
        }
    }

    private static native void predictPixelStorage(Bitmap bitmap);

    private native void setParams(long j3, int i3, boolean z16, boolean z17, boolean z18, boolean z19);

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            long j3 = this.nativePtr;
            if (j3 != 0) {
                destroy(j3);
                this.nativePtr = 0L;
            }
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public int compress(Bitmap bitmap, byte[] bArr) throws Exception {
        long j3;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap, (Object) bArr)).intValue();
        }
        if (!soLoadStatus) {
            JpegError.throwException(50);
        }
        try {
            j3 = compressBitMap(this.nativePtr, bitmap, bArr);
            i3 = (int) (j3 & (-1));
        } catch (UnsatisfiedLinkError unused) {
            j3 = 0;
            i3 = 52;
        }
        if (i3 != 0) {
            JpegError.throwException(i3);
        }
        return (int) ((j3 >> 32) & (-1));
    }

    public int computeOutSize(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap)).intValue();
        }
        if (bitmap != null) {
            return (bitmap.getHeight() * bitmap.getRowBytes()) + 2048;
        }
        return 0;
    }

    public void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        try {
            try {
                close();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            super.finalize();
        }
    }

    public void setParams(int i3, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        } else {
            try {
                setParams(this.nativePtr, i3, z16, z17, z18, false);
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    }

    public void setParams(int i3, boolean z16, boolean z17, boolean z18, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
        } else {
            try {
                setParams(this.nativePtr, i3, z16, z17, z18, z19);
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    }

    public int compress(byte[] bArr, int i3, int i16, int i17, byte[] bArr2) throws Exception {
        long j3;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bArr2)).intValue();
        }
        if (!soLoadStatus) {
            JpegError.throwException(50);
        }
        if (i17 == 2) {
            i19 = 4;
        } else if (i17 != 3) {
            i19 = 3;
        }
        if (i3 * i16 * i19 > bArr.length) {
            JpegError.throwException(4);
        }
        try {
            j3 = compressByteArray(this.nativePtr, bArr, i3, i16, i17, bArr2);
            i18 = (int) (j3 & (-1));
        } catch (UnsatisfiedLinkError unused) {
            j3 = 0;
            i18 = 52;
        }
        if (i18 != 0) {
            JpegError.throwException(i18);
        }
        return (int) ((j3 >> 32) & (-1));
    }

    public void compress(Bitmap bitmap) throws Exception {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
            return;
        }
        if (!soLoadStatus) {
            JpegError.throwException(50);
        }
        try {
            i3 = compressCb(this.nativePtr, bitmap);
        } catch (UnsatisfiedLinkError unused) {
            i3 = 52;
        }
        if (i3 != 0) {
            JpegError.throwException(i3);
        }
    }
}
