package com.tencent.sharpP;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@Keep
/* loaded from: classes25.dex */
public class SharpPEncoder {
    static IPatchRedirector $redirector_;

    @Keep
    /* loaded from: classes25.dex */
    public static class SharpPEncCreateParam {
        static IPatchRedirector $redirector_;
        public long appid;
        public int frame_count;
        public int height;
        public int image_mode;
        public int layer_num;
        public int level;
        public byte[] pStreamData;
        public int thread_num;
        public int width;

        public SharpPEncCreateParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    @Keep
    /* loaded from: classes25.dex */
    public static class SharpPInFrame {
        static IPatchRedirector $redirector_;
        public int delayTime;
        public int fmt;
        public byte[] pData;

        public SharpPInFrame() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public SharpPEncoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private native void CloseEncoder(long j3);

    private native long CreateEncoder(SharpPEncCreateParam sharpPEncCreateParam);

    private native long EncodeToImage(long j3, SharpPInFrame sharpPInFrame, int[] iArr, int i3);

    private native long appencoder(SharpPEncCreateParam sharpPEncCreateParam, int[] iArr, SharpPInFrame sharpPInFrame, byte[] bArr);

    private native long nativeEncodeBitmapToSharpP(SharpPEncCreateParam sharpPEncCreateParam, int[] iArr, Bitmap bitmap, byte[] bArr);

    public void closeEncode(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            CloseEncoder(j3);
        }
    }

    public long encode(long j3, SharpPInFrame sharpPInFrame, int[] iArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), sharpPInFrame, iArr, Integer.valueOf(i3))).longValue();
        }
        return EncodeToImage(j3, sharpPInFrame, iArr, i3);
    }

    public long startEncode(SharpPEncCreateParam sharpPEncCreateParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sharpPEncCreateParam)).longValue();
        }
        return CreateEncoder(sharpPEncCreateParam);
    }
}
