package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.strictfp, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cstrictfp {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorService f383431a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14452);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f383431a = new BaseThreadPoolExecutor(5, 15, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
        }
    }
}
