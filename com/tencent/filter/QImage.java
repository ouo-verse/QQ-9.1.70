package com.tencent.filter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.util.SoInfo;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QImage {
    static IPatchRedirector $redirector_;
    private int height;
    private long nativeImage;
    private int pixelBytes;
    private int pixelFormat;
    private int width;

    public QImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.width = 0;
        this.height = 0;
        this.nativeImage = 0L;
        this.pixelBytes = 0;
    }

    @SoInfo(libName = "image_filter_common")
    public static native QImage BindBitmap(Bitmap bitmap);

    @SoInfo(libName = "image_filter_common")
    public static native QImage Bitmap2QImage(Bitmap bitmap);

    @SoInfo(libName = "")
    public static native byte[] CompressJPEGFromRGBA(byte[] bArr, int i3, int i16, int i17);

    @SoInfo(libName = "image_filter_common")
    public native int AverageChannels();

    @SoInfo(libName = "")
    public native void CopyExif(QImage qImage);

    @SoInfo(libName = "image_filter_common")
    public native void CopyPixels(int[] iArr, int i3);

    @SoInfo(libName = "image_filter_common")
    public native void CopyPixelsRGB(int[] iArr, int i3);

    @SoInfo(libName = "image_filter_common")
    public native void CreateImage(int i3, int i16, int i17);

    @SoInfo(libName = "image_filter_common")
    public native QImage CreateImageFromQImage();

    @SoInfo(libName = "image_filter_common")
    public native void Dispose();

    @SoInfo(libName = "image_filter_common")
    public native boolean FromBitmap(Bitmap bitmap);

    @SoInfo(libName = "image_filter_common")
    public native QImage InplaceBlur8bitQImage(int i3, int i16);

    @SoInfo(libName = "image_filter_common")
    public native void RGB565toRGB(byte[] bArr, int i3, int i16);

    @SoInfo(libName = "image_filter_common")
    public native boolean ToBitmap(Bitmap bitmap);

    @SoInfo(libName = "image_filter_common")
    public native boolean UnBindBitmap(Bitmap bitmap);

    @SoInfo(libName = "image_filter_common")
    public native void WrapExif(QImage qImage);

    @SoInfo(libName = "image_filter_common")
    public native void YUV420sp2RGB(byte[] bArr, int i3, int i16);

    @SoInfo(libName = "image_filter_common")
    public native void YUV420sp2YUV(byte[] bArr, int i3, int i16);

    @SoInfo(libName = "image_filter_common")
    public native void YUV420sp2YUV2(byte[] bArr, int i3, int i16, int i17);

    @SoInfo(libName = "image_filter_common")
    public native void YUV422toRGB(byte[] bArr, int i3, int i16);

    @SoInfo(libName = "image_filter_common")
    public native boolean alphaMix(Bitmap bitmap, int i3, int i16);

    @SoInfo(libName = "image_filter_common")
    public native QImage createSubImage(int i3, int i16, int i17, int i18);

    @SoInfo(libName = "image_filter_common")
    public native long getByteSize();

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.height;
    }

    public int getPixelBytes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.pixelBytes;
    }

    public int getPixelFormat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.pixelFormat;
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.width;
    }

    @SoInfo(libName = "image_filter_common")
    public native boolean nativeFlip(int i3, int i16);

    @SoInfo(libName = "image_filter_common")
    public native int[] nativeGetArrayHistogram();

    @SoInfo(libName = "image_filter_common")
    public native int[] nativeGetArrayHistogramChannels();

    @SoInfo(libName = "image_filter_common")
    public native boolean nativeRotate(int i3);

    @SoInfo(libName = "image_filter_common")
    public native void nativeUpdateROI();

    @SoInfo(libName = "image_filter_common")
    public native void toGPUTexture(int i3);

    public QImage(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            CreateImage(i3, i16, 4);
        } else {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }
}
