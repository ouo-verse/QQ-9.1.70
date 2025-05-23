package com.tencent.avcore.jni;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NtrtcAudioWwise {
    static IPatchRedirector $redirector_;
    private static volatile NtrtcAudioWwise sInstance;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13601);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            sInstance = null;
        }
    }

    NtrtcAudioWwise() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void destroyInstance() {
        if (sInstance != null) {
            synchronized (NtrtcAudioWwise.class) {
                sInstance = null;
            }
        }
    }

    public static NtrtcAudioWwise getInstance() {
        if (sInstance == null) {
            synchronized (NtrtcAudioWwise.class) {
                if (sInstance == null) {
                    sInstance = new NtrtcAudioWwise();
                }
            }
        }
        return sInstance;
    }

    public native boolean bindWwiseAudioPlugin();

    public native boolean init();

    public native boolean isWwiseAudioPluginBound();

    public native void unbindWwiseAudioPlugin();

    public native void uninit();
}
