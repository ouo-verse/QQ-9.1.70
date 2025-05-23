package com.tencent.avcore.jni.dav;

import androidx.annotation.RequiresApi;
import com.tencent.avcore.jni.data.NtrtcSessionParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NtrtcSession {
    static IPatchRedirector $redirector_;
    private static volatile NtrtcSession sInstance;
    private NtrtcSessionCallbackImplWrapper mCallbackWrapper;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15716);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            sInstance = null;
        }
    }

    NtrtcSession() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCallbackWrapper = null;
        }
    }

    public static void destroyInstance() {
        if (sInstance != null) {
            synchronized (NtrtcSession.class) {
                sInstance = null;
            }
        }
    }

    public static NtrtcSession getInstance() {
        if (sInstance == null) {
            synchronized (NtrtcSession.class) {
                if (sInstance == null) {
                    sInstance = new NtrtcSession();
                }
            }
        }
        return sInstance;
    }

    public native int accept(long j3, int i3, int i16, int i17);

    public native int close(long j3, int i3);

    public native int ignore(long j3);

    public native int receiveSharpVideoAck(byte[] bArr);

    public native int receiveSharpVideoCall(byte[] bArr);

    public native int reject(long j3, int i3);

    public native int request(NtrtcSessionParam ntrtcSessionParam);

    public native int requestSwitchTerminal(long j3, int i3, int i16, long j16, String str);

    public native int sendQueryRoomInfoRequest(long j3, long j16);

    @RequiresApi(api = 21)
    public int setCallback(NtrtcSessionCallback ntrtcSessionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) ntrtcSessionCallback)).intValue();
        }
        if (ntrtcSessionCallback != null) {
            NtrtcSessionCallbackImplWrapper ntrtcSessionCallbackImplWrapper = new NtrtcSessionCallbackImplWrapper();
            this.mCallbackWrapper = ntrtcSessionCallbackImplWrapper;
            ntrtcSessionCallbackImplWrapper.setBusiCallback(ntrtcSessionCallback);
            return setCallbackNative(this.mCallbackWrapper);
        }
        NtrtcSessionCallbackImplWrapper ntrtcSessionCallbackImplWrapper2 = this.mCallbackWrapper;
        if (ntrtcSessionCallbackImplWrapper2 != null) {
            ntrtcSessionCallbackImplWrapper2.setBusiCallback(null);
            this.mCallbackWrapper = null;
        }
        return setCallbackNative(null);
    }

    public native int setCallbackNative(NtrtcSessionCallback ntrtcSessionCallback);
}
