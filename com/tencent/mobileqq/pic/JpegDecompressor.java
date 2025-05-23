package com.tencent.mobileqq.pic;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class JpegDecompressor {
    static IPatchRedirector $redirector_;
    private boolean idRgb;
    public int imageHeight;
    public int imageWidth;
    private int insample;
    private long nativePtr;
    public int outHeight;
    public int outWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14892);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        try {
            if (!JpegCompressor.soLoadStatus) {
                JpegCompressor.jpegcompressLoadSo();
            }
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            JpegCompressor.soLoadStatus = false;
        }
    }

    public JpegDecompressor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.outWidth = 0;
        this.outHeight = 0;
        this.insample = 0;
        this.idRgb = true;
        try {
            this.nativePtr = init();
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    private void computeOutWidthHeight(Rect rect) {
        int i3 = rect.right - rect.left;
        int i16 = rect.bottom - rect.top;
        if (this.insample <= 0) {
            this.insample = 1;
        }
        int i17 = this.insample;
        this.outWidth = ((i3 + i17) - 1) / i17;
        this.outHeight = ((i16 + i17) - 1) / i17;
    }

    public static Bitmap decodeByteArray(byte[] bArr, JpegOptions jpegOptions) throws Exception {
        Bitmap createBitmap;
        if (jpegOptions == null) {
            jpegOptions = JpegOptions.DEFAULT;
        }
        JpegDecompressor jpegDecompressor = new JpegDecompressor();
        try {
            if (jpegOptions.inJustDecodeBounds) {
                jpegDecompressor.computeOutSize(bArr, jpegOptions.inPreferredConfig);
                jpegOptions.outHeight = jpegDecompressor.imageHeight;
                jpegOptions.outWidth = jpegDecompressor.imageWidth;
                createBitmap = null;
            } else {
                createBitmap = jpegDecompressor.createBitmap(bArr, jpegOptions);
            }
            return createBitmap;
        } finally {
            jpegDecompressor.close();
        }
    }

    public static Bitmap decodeFile(String str, JpegOptions jpegOptions) throws Exception {
        Bitmap createBitmap;
        if (jpegOptions == null) {
            jpegOptions = JpegOptions.DEFAULT;
        }
        JpegDecompressor jpegDecompressor = new JpegDecompressor();
        try {
            if (jpegOptions.inJustDecodeBounds) {
                jpegDecompressor.computeOutSize(str, jpegOptions.inPreferredConfig);
                jpegOptions.outHeight = jpegDecompressor.imageHeight;
                jpegOptions.outWidth = jpegDecompressor.imageWidth;
                createBitmap = null;
            } else {
                createBitmap = jpegDecompressor.createBitmap(str, jpegOptions);
            }
            return createBitmap;
        } finally {
            jpegDecompressor.close();
        }
    }

    private native long decompress(long j3, byte[] bArr);

    private native long decompressBitmap(long j3, Bitmap bitmap);

    private native int decompressFileHeader(long j3, String str);

    private native int decompressHeader(long j3, byte[] bArr);

    private native void destroy(long j3);

    private int getPixelSize(Bitmap.Config config) {
        int i3;
        if (this.idRgb) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        if (config == null) {
            return i3;
        }
        if (Bitmap.Config.ARGB_8888 == config) {
            return 4;
        }
        if (Bitmap.Config.RGB_565 == config) {
            return 2;
        }
        if (Bitmap.Config.ALPHA_8 == config) {
            return 1;
        }
        return i3;
    }

    private Bitmap getReuseBitmap(Bitmap.Config config, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() != this.outWidth || bitmap.getHeight() != this.outHeight || bitmap.getConfig() != config) {
            return Bitmap.createBitmap(this.outWidth, this.outHeight, config);
        }
        return bitmap;
    }

    private native long init();

    private native void setParams(long j3, boolean z16, int i3, boolean z17);

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
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

    public int computeOutSize(byte[] bArr, Bitmap.Config config) throws Exception {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr, (Object) config)).intValue();
        }
        if (!JpegCompressor.soLoadStatus) {
            JpegError.throwException(50);
        }
        try {
            i3 = decompressHeader(this.nativePtr, bArr);
        } catch (UnsatisfiedLinkError unused) {
            i3 = 52;
        }
        if (i3 != 0) {
            JpegError.throwException(i3);
        }
        computeOutWidthHeight();
        return this.outWidth * this.outHeight * getPixelSize(config);
    }

    public Bitmap createBitmap(String str, JpegOptions jpegOptions) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) jpegOptions);
        }
        if (!JpegCompressor.soLoadStatus) {
            JpegError.throwException(50);
        }
        setParams(true, jpegOptions.inSampleSize, jpegOptions.inPreferQualityOverSpeed);
        computeOutSize(str, jpegOptions.inPreferredConfig);
        return getBitmap(jpegOptions.inPreferredConfig, jpegOptions.inBitmap);
    }

    public int decompress(byte[] bArr) throws Exception {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr)).intValue();
        }
        if (!JpegCompressor.soLoadStatus) {
            JpegError.throwException(50);
        }
        try {
            long decompress = decompress(this.nativePtr, bArr);
            i16 = (int) (decompress & (-1));
            i3 = (int) ((decompress >> 32) & (-1));
        } catch (UnsatisfiedLinkError unused) {
            i3 = 0;
            i16 = 52;
        }
        if (i16 != 0) {
            JpegError.throwException(i16);
        }
        return i3;
    }

    Bitmap getBitmap(Bitmap.Config config, Bitmap bitmap) {
        int i3;
        Bitmap reuseBitmap = getReuseBitmap(config, bitmap);
        try {
            i3 = (int) (decompressBitmap(this.nativePtr, reuseBitmap) & (-1));
        } catch (UnsatisfiedLinkError unused) {
            i3 = 52;
        }
        if (i3 != 0) {
            reuseBitmap.recycle();
            JpegError.throwException(i3);
            return null;
        }
        return reuseBitmap;
    }

    public void setParams(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            try {
                setParams(this.nativePtr, z16, i3, false);
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    }

    public void setParams(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            try {
                setParams(this.nativePtr, z16, 0, false);
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    }

    public void setParams(boolean z16, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
            return;
        }
        try {
            this.insample = i3;
            setParams(this.nativePtr, z16, i3, z17);
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public Bitmap createBitmap(byte[] bArr, JpegOptions jpegOptions) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr, (Object) jpegOptions);
        }
        if (!JpegCompressor.soLoadStatus) {
            JpegError.throwException(50);
        }
        setParams(true, jpegOptions.inSampleSize, jpegOptions.inPreferQualityOverSpeed);
        computeOutSize(bArr, jpegOptions.inPreferredConfig);
        return getBitmap(jpegOptions.inPreferredConfig, jpegOptions.inBitmap);
    }

    private void computeOutWidthHeight() {
        computeOutWidthHeight(new Rect(0, 0, this.imageWidth, this.imageHeight));
    }

    public int computeOutSize(String str, Bitmap.Config config) throws Exception {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) config)).intValue();
        }
        if (!JpegCompressor.soLoadStatus) {
            JpegError.throwException(50);
        }
        try {
            i3 = decompressFileHeader(this.nativePtr, str);
        } catch (UnsatisfiedLinkError unused) {
            i3 = 52;
        }
        if (i3 != 0) {
            JpegError.throwException(i3);
        }
        computeOutWidthHeight();
        return this.outWidth * this.outHeight * getPixelSize(config);
    }
}
