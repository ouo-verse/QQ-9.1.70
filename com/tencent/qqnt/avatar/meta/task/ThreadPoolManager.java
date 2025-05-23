package com.tencent.qqnt.avatar.meta.task;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\u0006\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001b\u0010\t\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/task/ThreadPoolManager;", "", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "b", "Lkotlin/Lazy;", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "threadPoolExecutor", "c", "a", "taskManagerExecutor", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ThreadPoolManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ThreadPoolManager f352976a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy threadPoolExecutor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy taskManagerExecutor;

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40563);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f352976a = new ThreadPoolManager();
        lazy = LazyKt__LazyJVMKt.lazy(ThreadPoolManager$threadPoolExecutor$2.INSTANCE);
        threadPoolExecutor = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ThreadPoolManager$taskManagerExecutor$2.INSTANCE);
        taskManagerExecutor = lazy2;
    }

    ThreadPoolManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final ExecutorCoroutineDispatcher a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ExecutorCoroutineDispatcher) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (ExecutorCoroutineDispatcher) taskManagerExecutor.getValue();
    }

    @NotNull
    public final ExecutorCoroutineDispatcher b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ExecutorCoroutineDispatcher) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (ExecutorCoroutineDispatcher) threadPoolExecutor.getValue();
    }
}
