package com.tencent.sharpP;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes25.dex */
public class SharpPDecoder {
    static IPatchRedirector $redirector_ = null;
    public static final int FORMAT_BGRA = 4;
    public static final int IMAGE_MODE_Animation = 3;
    public static final int IMAGE_MODE_AnimationWithAlpha = 4;
    public static final int SHARPP_STATUS_OK = 0;
    public int imageHeight;
    public int imageWidth;
    public SharpPFeature mFeatureInfo;
    public long mhDec;

    /* loaded from: classes25.dex */
    public class SharpPFeature {
        static IPatchRedirector $redirector_;
        public int bYUV444;
        public int colorCount;
        public int frameCount;
        public int headerSize;
        public int height;
        public int imageMode;
        public int layerNum;
        public int level;
        public int version;
        public int width;

        public SharpPFeature() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharpPDecoder.this);
            }
        }
    }

    /* loaded from: classes25.dex */
    public class SharpPOutFrame {
        static IPatchRedirector $redirector_;
        public int bufsize;
        public int delayTime;
        public int dstHeight;
        public int dstWidth;
        public int fmt;
        public int[] pOutBuf;

        public SharpPOutFrame() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharpPDecoder.this);
            }
        }
    }

    public SharpPDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public native void CloseDecoder2(long j3);

    public native long CreateDecoder2(String str);

    public native int DecodeImage2(long j3, int i3, SharpPOutFrame sharpPOutFrame);

    public native int DecodeImageToBitmap2(long j3, int i3, Bitmap bitmap, Integer num);

    public native int DecodeImageToBitmapPremultipled(long j3, byte[] bArr, int i3, Bitmap bitmap, boolean z16, Integer num);

    public native int DecodeImageToBitmapPremultipled2(long j3, int i3, Bitmap bitmap, boolean z16, Integer num);

    public native int GetDelayTime2(long j3, int i3);

    public native int ParseHeader2(String str, SharpPFeature sharpPFeature);

    public Bitmap decodeSharpP2PNG2(String str, int i3, int i16) {
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        SharpPFeature sharpPFeature = new SharpPFeature();
        if (ParseHeader2(str, sharpPFeature) != 0) {
            return null;
        }
        long CreateDecoder2 = CreateDecoder2(str);
        this.mhDec = CreateDecoder2;
        if (CreateDecoder2 == 0) {
            return null;
        }
        int i19 = sharpPFeature.width;
        this.imageWidth = i19;
        int i26 = sharpPFeature.height;
        this.imageHeight = i26;
        int i27 = (int) ((i26 / i19) * i16);
        if (i16 <= i19 && i27 <= i26) {
            i17 = i16;
            i18 = i27;
        } else {
            i17 = i19;
            i18 = i26;
        }
        int[] iArr = new int[i17 * i18];
        SharpPOutFrame sharpPOutFrame = new SharpPOutFrame();
        sharpPOutFrame.pOutBuf = iArr;
        sharpPOutFrame.dstWidth = i17;
        sharpPOutFrame.dstHeight = i18;
        sharpPOutFrame.fmt = i3;
        for (int i28 = 0; i28 < sharpPFeature.layerNum; i28++) {
            DecodeImage2(this.mhDec, i28, sharpPOutFrame);
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, 0, i17, i17, i18, Bitmap.Config.ARGB_8888);
        CloseDecoder2(this.mhDec);
        this.mhDec = 0L;
        return createBitmap;
    }

    public int getSharpPType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mFeatureInfo.imageMode;
    }

    public int parseHeader(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).intValue();
        }
        SharpPFeature sharpPFeature = new SharpPFeature();
        this.mFeatureInfo = sharpPFeature;
        return ParseHeader2(str, sharpPFeature);
    }
}
