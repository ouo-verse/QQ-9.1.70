package com.tencent.avcore.jni.dav;

import androidx.annotation.RequiresApi;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NtrtcAudio implements IAVEngineCommon {
    static IPatchRedirector $redirector_;
    private static volatile NtrtcAudio sInstance;
    private NtrtcAudioCallbackImplWrapper mCallbackWrapper;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15157);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            sInstance = null;
        }
    }

    NtrtcAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCallbackWrapper = null;
        }
    }

    public static void destroyInstance() {
        if (sInstance != null) {
            synchronized (NtrtcAudio.class) {
                sInstance = null;
            }
        }
    }

    public static NtrtcAudio getInstance() {
        if (sInstance == null) {
            synchronized (NtrtcAudio.class) {
                if (sInstance == null) {
                    sInstance = new NtrtcAudio();
                }
            }
        }
        return sInstance;
    }

    private native int registerAudioDataCallbackNative(int i3, boolean z16);

    private native int setAudioDataFormatNative(int i3, int i16, int i17, int i18);

    private native int unregisterAudioDataCallback(int i3, boolean z16);

    public native boolean enableAIDenoise(boolean z16);

    @Override // com.tencent.avcore.engine.common.IAVEngineCommon
    public void enableLocalSpeechRecognizeModel(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
    }

    public native boolean enableLoopback(boolean z16);

    public native int getAudioScene();

    public native int getVolume(boolean z16);

    public native boolean isEnableLoopback();

    @Override // com.tencent.avcore.engine.common.IAVEngineCommon
    public int registerAudioDataCallback(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Boolean.valueOf(z16))).intValue();
        }
        return registerAudioDataCallbackNative(i3, z16);
    }

    @Override // com.tencent.avcore.engine.common.IAVEngineCommon
    public int setAudioDataFormat(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).intValue();
        }
        return setAudioDataFormatNative(i3, i16, i17, i18);
    }

    @Override // com.tencent.avcore.engine.common.IAVEngineCommon
    public int setAudioDataVolume(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Float.valueOf(f16))).intValue();
    }

    public native int setAudioOutputMode(int i3);

    public native boolean setAudioScene(int i3);

    @RequiresApi(api = 21)
    public int setCallback(NtrtcAudioCallback ntrtcAudioCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) ntrtcAudioCallback)).intValue();
        }
        if (ntrtcAudioCallback != null) {
            NtrtcAudioCallbackImplWrapper ntrtcAudioCallbackImplWrapper = new NtrtcAudioCallbackImplWrapper();
            this.mCallbackWrapper = ntrtcAudioCallbackImplWrapper;
            ntrtcAudioCallbackImplWrapper.setBusiCallback(ntrtcAudioCallback);
            return setCallbackNative(this.mCallbackWrapper);
        }
        NtrtcAudioCallbackImplWrapper ntrtcAudioCallbackImplWrapper2 = this.mCallbackWrapper;
        if (ntrtcAudioCallbackImplWrapper2 != null) {
            ntrtcAudioCallbackImplWrapper2.setBusiCallback(null);
            this.mCallbackWrapper = null;
        }
        return setCallbackNative(null);
    }

    public native int setCallbackNative(NtrtcAudioCallback ntrtcAudioCallback);

    public native int setVoiceType(int i3);

    public native int startAudioRecv();

    public native int startAudioSend();

    public native int stopAudioRecv();

    public native int stopAudioSend();

    @Override // com.tencent.avcore.engine.common.IAVEngineCommon
    public int unregisterAudioDataCallback(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, i3)).intValue();
        }
        return unregisterAudioDataCallback(i3, false);
    }

    public native int unregisterAudioDataCallbackAll();
}
