package com.tencent.avcore.jni.dav;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NtrtcUtil {
    static IPatchRedirector $redirector_;
    private static volatile NtrtcUtil sInstance;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15869);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            sInstance = null;
        }
    }

    NtrtcUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void destroyInstance() {
        if (sInstance != null) {
            synchronized (NtrtcUtil.class) {
                sInstance = null;
            }
        }
    }

    public static NtrtcUtil getInstance() {
        if (sInstance == null) {
            synchronized (NtrtcUtil.class) {
                if (sInstance == null) {
                    sInstance = new NtrtcUtil();
                }
            }
        }
        return sInstance;
    }

    public native int doQuaReport(long j3, long j16, int i3, int i16);

    public native void enableDumpAudioData(boolean z16);

    public native boolean quaReport(long j3, long j16, long j17, int i3, long j18);

    public native void setAVSDKInfo(long j3, String str, String str2);

    public native void setQosParams(String str);

    public native int updateProcessInfo(long j3, String str, String str2);
}
