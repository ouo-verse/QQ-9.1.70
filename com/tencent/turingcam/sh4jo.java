package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class sh4jo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference<String> f382370a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14184);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f382370a = new AtomicReference<>();
        }
    }

    public static String a() {
        AtomicReference<String> atomicReference = f382370a;
        String str = atomicReference.get();
        if (str == null) {
            synchronized (atomicReference) {
                str = atomicReference.get();
                if (str == null) {
                    str = DeviceInfoMonitor.getModel();
                    atomicReference.set(str);
                }
            }
        }
        return str;
    }
}
