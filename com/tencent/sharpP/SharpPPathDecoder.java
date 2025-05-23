package com.tencent.sharpP;

import android.graphics.Bitmap;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sharpP.SharpPDecoderWrapper;

/* loaded from: classes25.dex */
public class SharpPPathDecoder {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SharpPPathDecoder";
    protected SharpPDecoderWrapper mDecoder;
    protected SharpPDecoderWrapper.SharpPFeatureWrapper mInfo;
    protected String mPath;

    public SharpPPathDecoder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mDecoder = new SharpPDecoderWrapper();
            this.mPath = str;
        }
    }

    public void closeDecoder(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.mDecoder.closeDecoderInNative(j3);
            closeDecoder();
        }
    }

    public long createDecoder() {
        int parseHeader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        if (this.mInfo == null && (parseHeader = parseHeader()) != 0) {
            ImageManagerEnv.getLogger().e(TAG, "createDecoder error,res=" + parseHeader);
            return parseHeader;
        }
        return this.mDecoder.createDecoderInNative(this.mPath, this.mInfo.getFeatureInfo());
    }

    public Bitmap decodeSharpP(int i3, int i16, Bitmap.Config config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), config);
        }
        if (this.mInfo == null && parseHeader() != 0) {
            return null;
        }
        return this.mDecoder.decodeSharpPInNative(this.mPath, this.mInfo.getFeatureInfo(), i3, i16, config);
    }

    public Bitmap decodeSharpP2GifFrame(long j3, int i3, int i16, int i17, SharpPDecoderWrapper.WriteableInteger writeableInteger, Bitmap bitmap) {
        Bitmap bitmap2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), writeableInteger, bitmap);
        }
        if (this.mInfo == null && parseHeader() != 0) {
            return null;
        }
        if (this.mInfo.getImageMode() == 4) {
            return this.mDecoder.decodeOneFrameWithAlphaInNative(j3, i3, i16, i17, writeableInteger, bitmap);
        }
        if (bitmap == null) {
            bitmap2 = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        } else {
            bitmap2 = bitmap;
        }
        if (this.mDecoder.decodeOneFrameInNative(j3, i3, bitmap2, writeableInteger) != 0) {
            return null;
        }
        return bitmap2;
    }

    public Bitmap decodeSharpP2JPG(int i3, int i16, Bitmap.Config config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), config);
        }
        if (this.mInfo == null && parseHeader() != 0) {
            return null;
        }
        return this.mDecoder.decodeImageInNative(this.mPath, this.mInfo.getFeatureInfo(), 4, i3, i16, config);
    }

    public Bitmap decodeSharpP2PNG(int i3, int i16, Bitmap.Config config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), config);
        }
        if (this.mInfo == null && parseHeader() != 0) {
            return null;
        }
        return this.mDecoder.decodeSharpP2PNGInNative(this.mPath, this.mInfo.getFeatureInfo(), i3, i16, config);
    }

    public int getAllocationByteCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mDecoder.getAllocationByteCount();
    }

    public SharpPDecoderWrapper.SharpPFeatureWrapper getFeatureInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SharpPDecoderWrapper.SharpPFeatureWrapper) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.mInfo == null && parseHeader() != 0) {
            return null;
        }
        return this.mInfo;
    }

    public String getMimeType() {
        SharpPDecoderWrapper.SharpPFeatureWrapper sharpPFeatureWrapper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if ((this.mInfo == null && parseHeader() != 0) || (sharpPFeatureWrapper = this.mInfo) == null) {
            return null;
        }
        int imageMode = sharpPFeatureWrapper.getImageMode();
        if (imageMode != 0) {
            if (imageMode != 1) {
                if (imageMode != 2) {
                    if (imageMode == 3 || imageMode == 4) {
                        return "image/gif";
                    }
                    ImageManagerEnv.getLogger().e(TAG, "-------unknow mimeType:" + this.mInfo.getImageMode());
                    return null;
                }
            } else {
                return "image/png";
            }
        }
        return ImageContentType.MIME_TYPE_JPG;
    }

    public int parseHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (this.mInfo != null) {
            return 0;
        }
        SharpPDecoderWrapper.SharpPFeatureWrapper createSharpPFeatureWrapper = this.mDecoder.createSharpPFeatureWrapper();
        this.mInfo = createSharpPFeatureWrapper;
        int parseHeaderInNative = this.mDecoder.parseHeaderInNative(this.mPath, createSharpPFeatureWrapper.getFeatureInfo());
        if (parseHeaderInNative != 0) {
            this.mInfo = null;
            ImageManagerEnv.getLogger().e(TAG, "parseHeader error,res=" + parseHeaderInNative);
        }
        return parseHeaderInNative;
    }

    public void closeDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.mInfo = null;
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }
}
