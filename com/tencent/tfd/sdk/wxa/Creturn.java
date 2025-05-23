package com.tencent.tfd.sdk.wxa;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.return, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Creturn {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference<String> f375771a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62884);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f375771a = new AtomicReference<>();
        }
    }

    public static String a() {
        AtomicReference<String> atomicReference = f375771a;
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

    public static int b() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
