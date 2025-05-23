package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.VoByK;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class L32b7 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static volatile VoByK f381876a;

    public L32b7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static VoByK a(String str) {
        try {
            return new VoByK(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static VoByK.SkEpO b(String str) {
        VoByK.SkEpO skEpO;
        VoByK.ShGzN shGzN = new VoByK.ShGzN(str, str, 5000L);
        try {
            if (f381876a == null) {
                synchronized (L32b7.class) {
                    if (f381876a == null) {
                        f381876a = a("sh");
                    }
                }
            }
            skEpO = f381876a.a(shGzN);
        } catch (Exception e16) {
            if (((e16 instanceof IOException) || (e16 instanceof InterruptedException)) && f381876a != null) {
                synchronized (L32b7.class) {
                    if (f381876a != null) {
                        VoByK voByK = f381876a;
                        voByK.getClass();
                        try {
                            voByK.a();
                        } catch (Throwable unused) {
                        }
                        f381876a = null;
                    }
                }
            }
            skEpO = null;
        }
        if (skEpO == null) {
            return new VoByK.SkEpO("", "e");
        }
        return skEpO;
    }
}
