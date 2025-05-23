package com.tencent.youtu.ytagreflectlivecheck.jni;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JNIUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LightLiveCheck";

    public JNIUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Timeval getTimeval(long j3) {
        return new Timeval(j3 / 1000, (int) ((j3 * 1000) % 1000000));
    }
}
