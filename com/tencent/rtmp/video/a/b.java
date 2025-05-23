package com.tencent.rtmp.video.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;

/* compiled from: P */
/* loaded from: classes25.dex */
final /* synthetic */ class b implements ThreadFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f368826a;

    b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f368826a = str;
        }
    }

    public static ThreadFactory a(String str) {
        return new b(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new BaseThread(runnable, this.f368826a);
    }
}
