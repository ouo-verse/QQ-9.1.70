package com.tencent.sharpP;

import android.graphics.Bitmap;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.sharpP.SharpPDecoder;
import java.util.Objects;

/* loaded from: classes25.dex */
public class SharpPDecoderWrapper {
    static IPatchRedirector $redirector_ = null;
    public static final int MAX_LAYER_NUM = 3;
    private static final String TAG = "SharpPDecoderWrapper";
    public static final int emMode_Animation = 3;
    public static final int emMode_AnimationWithAlpha = 4;
    public static final int emMode_BlendAlpha = 2;
    public static final int emMode_EncodeAlpha = 1;
    public static final int emMode_Normal = 0;
    private static boolean sSoLoaded;
    private int[] byteBuffer;
    private SharpPDecoder mDecoder;

    /* loaded from: classes25.dex */
    public static class SharpPFeatureWrapper {
        static IPatchRedirector $redirector_;
        SharpPDecoder.SharpPFeature info;

        public SharpPFeatureWrapper(SharpPDecoder.SharpPFeature sharpPFeature) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sharpPFeature);
            } else {
                this.info = sharpPFeature;
            }
        }

        public SharpPDecoder.SharpPFeature getFeatureInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (SharpPDecoder.SharpPFeature) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.info;
        }

        public int getFrameCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.info.frameCount;
        }

        public int getHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.info.height;
        }

        public int getImageMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.info.imageMode;
        }

        public int getLayerNum() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.info.layerNum;
        }

        public int getWidth() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.info.width;
        }
    }

    /* loaded from: classes25.dex */
    public static class WriteableInteger {
        static IPatchRedirector $redirector_;
        Integer realInt;

        public WriteableInteger(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.realInt = new Integer(i3);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17029);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            loadLibrary();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharpPDecoderWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        if (!sSoLoaded) {
            loadLibrary();
        }
        this.mDecoder = new SharpPDecoder();
    }

    private static void loadLibrary() {
        try {
            sSoLoaded = ImageManagerEnv.g().loadLibrary(SoLoadConstants.SONAME_SHARPDEC);
        } catch (UnsatisfiedLinkError e16) {
            ImageManagerEnv.getLogger().w(TAG, "catch an exception:", e16);
        }
    }

    public void closeDecoderInNative(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
        } else {
            this.mDecoder.CloseDecoder2(j3);
            this.byteBuffer = null;
        }
    }

    public long createDecoderInNative(String str, SharpPDecoder.SharpPFeature sharpPFeature) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) sharpPFeature)).longValue();
        }
        return this.mDecoder.CreateDecoder2(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharpPFeatureWrapper createSharpPFeatureWrapper() {
        SharpPDecoder sharpPDecoder = this.mDecoder;
        Objects.requireNonNull(sharpPDecoder);
        return new SharpPFeatureWrapper(new SharpPDecoder.SharpPFeature());
    }

    public Bitmap decodeImageInNative(String str, SharpPDecoder.SharpPFeature sharpPFeature, int i3, int i16, int i17, Bitmap.Config config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, this, str, sharpPFeature, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), config);
        }
        long createDecoderInNative = createDecoderInNative(str, sharpPFeature);
        if (createDecoderInNative == 0) {
            ImageManagerEnv.getLogger().e(TAG, "decodeImageInNative error:hDec=0");
            return null;
        }
        int[] iArr = new int[i16 * i17];
        SharpPDecoder sharpPDecoder = this.mDecoder;
        Objects.requireNonNull(sharpPDecoder);
        SharpPDecoder.SharpPOutFrame sharpPOutFrame = new SharpPDecoder.SharpPOutFrame();
        sharpPOutFrame.pOutBuf = iArr;
        sharpPOutFrame.dstWidth = i16;
        sharpPOutFrame.dstHeight = i17;
        sharpPOutFrame.fmt = i3;
        int i19 = 0;
        int i26 = 0;
        while (i19 < sharpPFeature.layerNum) {
            int decodeImageInNative = decodeImageInNative(createDecoderInNative, i19, sharpPOutFrame);
            if (decodeImageInNative != 0) {
                ILog logger = ImageManagerEnv.getLogger();
                Object[] objArr = new Object[i18];
                objArr[0] = "decodeSharpP error:layerNo=" + i19 + ",status=" + decodeImageInNative;
                logger.e(TAG, objArr);
                i26++;
            }
            i19++;
            i18 = 1;
        }
        closeDecoderInNative(createDecoderInNative);
        if (i26 != sharpPFeature.layerNum) {
            return Bitmap.createBitmap(iArr, 0, i16, i16, i17, config);
        }
        return null;
    }

    public int decodeImageToBitmapInNative(long j3, int i3, Bitmap bitmap, Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), Integer.valueOf(i3), bitmap, num)).intValue();
        }
        return this.mDecoder.DecodeImageToBitmap2(j3, i3, bitmap, num);
    }

    public int decodeOneFrameInNative(long j3, int i3, Bitmap bitmap, WriteableInteger writeableInteger) {
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Integer.valueOf(i3), bitmap, writeableInteger)).intValue();
        }
        if (writeableInteger.realInt.intValue() == 0) {
            intValue = this.mDecoder.GetDelayTime2(j3, i3);
        } else {
            intValue = writeableInteger.realInt.intValue();
        }
        Integer valueOf = Integer.valueOf(intValue);
        writeableInteger.realInt = valueOf;
        int decodeImageToBitmapInNative = decodeImageToBitmapInNative(j3, i3, bitmap, valueOf);
        if (decodeImageToBitmapInNative != 0) {
            ImageManagerEnv.getLogger().e(TAG, "decodeSharpP error:frameIndex=" + i3 + ",status=" + decodeImageToBitmapInNative);
        }
        return decodeImageToBitmapInNative;
    }

    public Bitmap decodeOneFrameWithAlphaInNative(long j3, int i3, int i16, int i17, WriteableInteger writeableInteger, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), writeableInteger, bitmap);
        }
        int[] iArr = this.byteBuffer;
        if (iArr == null || (iArr != null && iArr.length < i16 * i17)) {
            this.byteBuffer = new int[i16 * i17];
        }
        int[] iArr2 = this.byteBuffer;
        SharpPDecoder sharpPDecoder = this.mDecoder;
        Objects.requireNonNull(sharpPDecoder);
        SharpPDecoder.SharpPOutFrame sharpPOutFrame = new SharpPDecoder.SharpPOutFrame();
        sharpPOutFrame.pOutBuf = iArr2;
        sharpPOutFrame.dstWidth = i16;
        sharpPOutFrame.dstHeight = i17;
        sharpPOutFrame.fmt = 4;
        int decodeImageInNative = decodeImageInNative(j3, i3, sharpPOutFrame);
        if (decodeImageInNative != 0) {
            ImageManagerEnv.getLogger().e(TAG, "decodeSharpP gif alpha mode error:status=" + decodeImageInNative);
            return null;
        }
        writeableInteger.realInt = Integer.valueOf(sharpPOutFrame.delayTime);
        if (bitmap != null && bitmap.isMutable()) {
            bitmap.setPixels(iArr2, 0, i16, 0, 0, i16, i17);
            return bitmap;
        }
        return Bitmap.createBitmap(iArr2, i16, i17, Bitmap.Config.ARGB_8888);
    }

    public Bitmap decodeSharpP2PNGInNative(String str, SharpPDecoder.SharpPFeature sharpPFeature, int i3, int i16, Bitmap.Config config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, str, sharpPFeature, Integer.valueOf(i3), Integer.valueOf(i16), config);
        }
        return decodeSharpPInNative(str, sharpPFeature, i3, i16, config);
    }

    public Bitmap decodeSharpPInNative(String str, SharpPDecoder.SharpPFeature sharpPFeature, int i3, int i16, Bitmap.Config config) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, str, sharpPFeature, Integer.valueOf(i3), Integer.valueOf(i16), config);
        }
        long createDecoderInNative = createDecoderInNative(str, sharpPFeature);
        if (createDecoderInNative == 0) {
            ImageManagerEnv.getLogger().e(TAG, "decodeSharpPInNative error:hDec=0");
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, config);
        Integer num = new Integer(0);
        int i17 = 0;
        int i18 = 0;
        while (i18 < sharpPFeature.layerNum) {
            int i19 = i17;
            int i26 = i18;
            int decodeImageToBitmapInNative = decodeImageToBitmapInNative(createDecoderInNative, i18, createBitmap, num);
            if (decodeImageToBitmapInNative != 0) {
                z16 = false;
                ImageManagerEnv.getLogger().e(TAG, "decodeSharpP error:layerNo=" + i26 + ",status=" + decodeImageToBitmapInNative);
                i17 = i19 + 1;
            } else {
                z16 = false;
                i17 = i19;
            }
            i18 = i26 + 1;
        }
        int i27 = i17;
        closeDecoderInNative(createDecoderInNative);
        if (i27 == sharpPFeature.layerNum) {
            return null;
        }
        return createBitmap;
    }

    public int getAllocationByteCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int[] iArr = this.byteBuffer;
        if (iArr != null) {
            return iArr.length;
        }
        return 0;
    }

    public int parseHeaderInNative(String str, SharpPDecoder.SharpPFeature sharpPFeature) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) sharpPFeature)).intValue();
        }
        return this.mDecoder.ParseHeader2(str, sharpPFeature);
    }

    public int decodeImageInNative(long j3, int i3, SharpPDecoder.SharpPOutFrame sharpPOutFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this.mDecoder.DecodeImage2(j3, i3, sharpPOutFrame) : ((Integer) iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), Integer.valueOf(i3), sharpPOutFrame)).intValue();
    }
}
