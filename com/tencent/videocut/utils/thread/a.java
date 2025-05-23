package com.tencent.videocut.utils.thread;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\u0007R \u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\u0005R \u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lcom/tencent/videocut/utils/thread/a;", "", "Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor;", "a", "Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor;", "()Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor;", "getThreadPoolForComputation$annotations", "()V", "threadPoolForComputation", "b", "getThreadPoolForIo$annotations", "threadPoolForIo", "<init>", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final PriorityThreadPoolExecutor threadPoolForComputation;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final PriorityThreadPoolExecutor threadPoolForIo;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f384280c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10819);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f384280c = new a();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int max = Math.max(2, availableProcessors);
        int max2 = Math.max(2, availableProcessors / 2);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        PriorityThreadPoolExecutor priorityThreadPoolExecutor = new PriorityThreadPoolExecutor(max2, 60L, timeUnit);
        threadPoolForComputation = priorityThreadPoolExecutor;
        priorityThreadPoolExecutor.setThreadFactory(new PriorityThreadFactory("app-compute", 10));
        PriorityThreadPoolExecutor priorityThreadPoolExecutor2 = new PriorityThreadPoolExecutor(max, 60L, timeUnit);
        threadPoolForIo = priorityThreadPoolExecutor2;
        priorityThreadPoolExecutor2.setThreadFactory(new PriorityThreadFactory("app-io", 10));
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public static final PriorityThreadPoolExecutor a() {
        return threadPoolForComputation;
    }

    @NotNull
    public static final PriorityThreadPoolExecutor b() {
        return threadPoolForIo;
    }
}
