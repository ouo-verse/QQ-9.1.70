package com.tencent.avcore.jni.dav;

import androidx.annotation.RequiresApi;
import com.tencent.avcore.jni.data.NtrtcVideoParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NtrtcVideo {
    static IPatchRedirector $redirector_;
    private static volatile NtrtcVideo sInstance;
    private NtrtcVideoCallbackImplWrapper mCallbackWrapper;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15875);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            sInstance = null;
        }
    }

    NtrtcVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCallbackWrapper = null;
        }
    }

    public static void destroyInstance() {
        if (sInstance != null) {
            synchronized (NtrtcVideo.class) {
                sInstance = null;
            }
        }
    }

    public static NtrtcVideo getInstance() {
        if (sInstance == null) {
            synchronized (NtrtcVideo.class) {
                if (sInstance == null) {
                    sInstance = new NtrtcVideo();
                }
            }
        }
        return sInstance;
    }

    public native long getOnPeerFrameRenderEndFunctionPtr();

    public native byte[] postData(long j3, byte[] bArr);

    @RequiresApi(api = 21)
    public int setCallback(NtrtcVideoCallback ntrtcVideoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) ntrtcVideoCallback)).intValue();
        }
        if (ntrtcVideoCallback != null) {
            NtrtcVideoCallbackImplWrapper ntrtcVideoCallbackImplWrapper = new NtrtcVideoCallbackImplWrapper();
            this.mCallbackWrapper = ntrtcVideoCallbackImplWrapper;
            ntrtcVideoCallbackImplWrapper.setBusiCallback(ntrtcVideoCallback);
            return setCallbackNative(this.mCallbackWrapper);
        }
        NtrtcVideoCallbackImplWrapper ntrtcVideoCallbackImplWrapper2 = this.mCallbackWrapper;
        if (ntrtcVideoCallbackImplWrapper2 != null) {
            ntrtcVideoCallbackImplWrapper2.setBusiCallback(null);
            this.mCallbackWrapper = null;
        }
        return setCallbackNative(null);
    }

    public native int setCallbackNative(NtrtcVideoCallback ntrtcVideoCallback);

    public native int setGroundGlassSwitch(long j3, int i3);

    public native int startVideoSend();

    public native int stopVideoSend();

    public native void updateVideoParam(NtrtcVideoParam ntrtcVideoParam);
}
