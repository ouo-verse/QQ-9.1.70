package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes27.dex */
public class zVR7H {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorService f382476a;

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f382477b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19780);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f382476a = ProxyExecutors.newFixedThreadPool(5);
            f382477b = ProxyExecutors.newCachedThreadPool();
        }
    }
}
