package com.tencent.tgpa.lite.d;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tgpa.lite.Callback;
import com.tencent.tgpa.lite.e.k;
import com.tencent.tgpa.lite.g.b;
import com.tencent.tgpa.lite.g.h;
import com.tencent.tgpa.lite.g.i;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends BaseThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Callback f375912a;

    /* renamed from: b, reason: collision with root package name */
    private static final CountDownLatch f375913b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14895);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375913b = new CountDownLatch(1);
        }
    }

    public a(Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
        } else {
            f375912a = callback;
        }
    }

    public static CountDownLatch a() {
        return f375913b;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        new com.tencent.tgpa.lite.a.a().a();
        b.a();
        if (com.tencent.tgpa.lite.a.b.a().f375868a.f375880g) {
            new k().a();
        }
        if (com.tencent.tgpa.lite.a.b.a().f375868a.f375876c) {
            i.a(new HashMap());
        }
        if (com.tencent.tgpa.lite.a.b.a().f375868a.f375881h) {
            a("deviceType", String.valueOf(com.tencent.tgpa.lite.a.b.a().f375870c.f375873a));
        }
        f375913b.countDown();
        h.c("tgpa async init run time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static void a(String str, String str2) {
        Callback callback = f375912a;
        if (callback != null) {
            callback.getInfo(str, str2);
        } else {
            h.d("no callback, ple check!", new Object[0]);
        }
    }
}
