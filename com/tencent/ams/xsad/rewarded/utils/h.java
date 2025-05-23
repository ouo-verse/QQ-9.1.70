package com.tencent.ams.xsad.rewarded.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final h f71865c;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f71866a;

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f71867b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14983);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f71865c = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static h a() {
        return f71865c;
    }

    public synchronized ExecutorService b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ExecutorService) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f71867b == null) {
            this.f71867b = new BaseThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new e("RewardedAdReportThreadPool"));
        }
        return this.f71867b;
    }

    public synchronized ExecutorService c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ExecutorService) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f71866a == null) {
            this.f71866a = new BaseThreadPoolExecutor(3, 6, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new e("RewardedAdResLoadThreadPool"));
        }
        return this.f71866a;
    }
}
