package com.tencent.avcore.jni;

import com.tencent.avcore.jni.render.FocusDetectCallback;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NtrtcVideoRender {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "NtrtcVideoRender";
    private static volatile NtrtcVideoRender sInstance;
    private FocusDetectCallback mAutoFocusCallback;
    private final Object mAutoFocusCallbackLock;

    NtrtcVideoRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAutoFocusCallback = null;
            this.mAutoFocusCallbackLock = new Object();
        }
    }

    public static void destroyInstance() {
        sInstance = null;
    }

    private native int getBeautyConfig();

    public static NtrtcVideoRender getInstance() {
        if (sInstance == null) {
            synchronized (NtrtcVideoRender.class) {
                if (sInstance == null) {
                    sInstance = new NtrtcVideoRender();
                }
            }
        }
        return sInstance;
    }

    private native int sendCameraFrame2Native(byte[] bArr, int i3, int i16, int i17, int i18, int i19, long j3, boolean z16, float f16, float f17, float f18, byte[] bArr2, int i26, int i27, int i28);

    private native void setBeautyConfig(int i3);

    public native void clearCameraFrames();

    public native String findConfigValue(String str, String str2, String str3);

    public native void flushGlRender(String str);

    void onFocusDetectResult(boolean z16) {
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i(TAG, "onFocusDetectResult:" + z16);
        }
        FocusDetectCallback focusDetectCallback = this.mAutoFocusCallback;
        if (focusDetectCallback != null) {
            focusDetectCallback.onFocusDetectResult(z16);
        }
    }

    public native void onUinChanged(String str, String str2);

    public int sendCameraFrame(byte[] bArr, int i3, int i16, int i17, int i18, int i19, long j3, boolean z16, float[] fArr, byte[] bArr2, int i26, int i27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? sendCameraFrame(bArr, i3, i16, i17, i18, i19, j3, z16, fArr, bArr2, i26, i27, 0) : ((Integer) iPatchRedirector.redirect((short) 3, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Long.valueOf(j3), Boolean.valueOf(z16), fArr, bArr2, Integer.valueOf(i26), Integer.valueOf(i27))).intValue();
    }

    public native int sendDecodeFrame2GLRender(String str, int i3, byte[] bArr, int i16, int i17, int i18);

    public native void setAccountUin(String str);

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setBeautyOrFaceConfig(int i3, int i16) {
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            i19 = getBeautyConfig();
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        int i26 = i19;
        if (i16 == 0) {
            i17 = (i19 / 100) * 100;
            i18 = Math.min(i3, 99);
        } else {
            if (i16 == 1) {
                i17 = i19 % 100;
                i18 = i3 * 100;
            }
            if (i19 == i26) {
                try {
                    setBeautyConfig(i26);
                } catch (UnsatisfiedLinkError e17) {
                    e17.printStackTrace();
                }
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(TAG, "setBeautyOrFaceConfig, [" + i19 + " --> " + i26 + "], level[" + i3 + "], type[" + i16 + "]");
                    return;
                }
                return;
            }
            return;
        }
        i26 = i17 + i18;
        if (i19 == i26) {
        }
    }

    public native void setEngineFlag(boolean z16);

    public native void setFocusConfig(boolean z16, long j3, int i3, int i16);

    public void setFocusDetectCallback(FocusDetectCallback focusDetectCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) focusDetectCallback);
            return;
        }
        synchronized (this.mAutoFocusCallbackLock) {
            this.mAutoFocusCallback = focusDetectCallback;
        }
    }

    public native void setGlRender(String str, NtrtcVideoRenderTexture ntrtcVideoRenderTexture);

    public native void setIsFocusing(boolean z16);

    public int sendCameraFrame(byte[] bArr, int i3, int i16, int i17, int i18, int i19, long j3, boolean z16, float[] fArr, byte[] bArr2, int i26, int i27, int i28) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Long.valueOf(j3), Boolean.valueOf(z16), fArr, bArr2, Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28))).intValue();
        }
        if (!z16 && fArr != null && fArr.length >= 3) {
            return sendCameraFrame2Native(bArr, i3, i16, i17, i18, i19, j3, z16, fArr[0], fArr[1], fArr[2], bArr2, i26, i27, i28);
        }
        return sendCameraFrame2Native(bArr, i3, i16, i17, i18, i19, j3, z16, 0.0f, 0.0f, 0.0f, bArr2, i26, i27, i28);
    }
}
