package com.tencent.qqnt.qbasealbum.coroutine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u001c\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0003\u00a8\u0006\u0007"}, d2 = {"Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "a", "Ljava/util/concurrent/ExecutorService;", "queryExecutor", "b", "albumExecutor", "nt_album_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f361078a;

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f361079b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35804);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f361078a = ProxyExecutors.newSingleThreadExecutor();
            f361079b = ProxyExecutors.newSingleThreadExecutor();
        }
    }
}
