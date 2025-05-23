package com.tencent.mvi.dispatcher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.log.c;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00078VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mvi/dispatcher/AIODispatcherExecutor;", "Lcom/tencent/mvi/dispatcher/a;", "", "Lcom/tencent/mvi/dispatcher/AIOTask;", Constants.Raft.TASKS, "", "a", "", "Lkotlin/Lazy;", "d", "()I", "maxPoolSize", "Ljava/util/concurrent/CountDownLatch;", "b", "Ljava/util/concurrent/CountDownLatch;", "tasksCountDown", "Ljava/util/concurrent/ThreadPoolExecutor;", "c", "e", "()Ljava/util/concurrent/ThreadPoolExecutor;", "subExecutor", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public class AIODispatcherExecutor implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy maxPoolSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile CountDownLatch tasksCountDown;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy subExecutor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mvi/dispatcher/AIODispatcherExecutor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mvi.dispatcher.AIODispatcherExecutor$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11079);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIODispatcherExecutor() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            lazy = LazyKt__LazyJVMKt.lazy(AIODispatcherExecutor$maxPoolSize$2.INSTANCE);
            this.maxPoolSize = lazy;
            this.tasksCountDown = new CountDownLatch(0);
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: com.tencent.mvi.dispatcher.AIODispatcherExecutor$subExecutor$2
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mvi/dispatcher/AIODispatcherExecutor$subExecutor$2$a", "Ljava/util/concurrent/ThreadFactory;", "Ljava/lang/Runnable;", "r", "Ljava/lang/Thread;", "newThread", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadNumber", "mvi_debug"}, k = 1, mv = {1, 4, 2})
                /* loaded from: classes21.dex */
                public static final class a implements ThreadFactory {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
                    private final AtomicInteger threadNumber;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            this.threadNumber = new AtomicInteger(1);
                        }
                    }

                    @Override // java.util.concurrent.ThreadFactory
                    @NotNull
                    public Thread newThread(@Nullable Runnable r16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            return (Thread) iPatchRedirector.redirect((short) 1, (Object) this, (Object) r16);
                        }
                        BaseThread baseThread = new BaseThread(r16, "aio_dispatcher_" + this.threadNumber.getAndIncrement());
                        if (baseThread.getPriority() != 10) {
                            baseThread.setPriority(10);
                        }
                        return baseThread;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AIODispatcherExecutor.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ThreadPoolExecutor invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        return (ThreadPoolExecutor) iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                    BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(AIODispatcherExecutor.this.d(), AIODispatcherExecutor.this.d(), 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a());
                    baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
                    return baseThreadPoolExecutor;
                }
            });
            this.subExecutor = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.mvi.dispatcher.a
    public void a(@NotNull final List<? extends AIOTask> tasks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tasks);
            return;
        }
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        if (tasks.isEmpty()) {
            return;
        }
        this.tasksCountDown = new CountDownLatch(tasks.size());
        final int size = tasks.size();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i3 = 0; i3 < size; i3++) {
            b().execute(new Runnable(atomicInteger, size, tasks) { // from class: com.tencent.mvi.dispatcher.AIODispatcherExecutor$dispatch$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AtomicInteger f337768d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f337769e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ List f337770f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f337768d = atomicInteger;
                    this.f337769e = size;
                    this.f337770f = tasks;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, AIODispatcherExecutor.this, atomicInteger, Integer.valueOf(size), tasks);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    CountDownLatch countDownLatch;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    int andIncrement = this.f337768d.getAndIncrement();
                    if (andIncrement >= this.f337769e) {
                        c.f337783b.a("AIOStartUpExecutor", "\u4efb\u52a1\u6267\u884c\u5b8c\u4e86");
                        return;
                    }
                    AIOTask aIOTask = (AIOTask) this.f337770f.get(andIncrement);
                    c.f337783b.a("AIOStartUpExecutor", "\u5b50\u7ebf\u7a0b\u6267\u884c  " + andIncrement + "  " + aIOTask);
                    aIOTask.c();
                    countDownLatch = AIODispatcherExecutor.this.tasksCountDown;
                    countDownLatch.countDown();
                }
            });
        }
        while (true) {
            if (atomicInteger.get() >= size) {
                break;
            }
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement >= size) {
                c.f337783b.a("AIOStartUpExecutor", "\u4efb\u52a1\u6267\u884c\u5b8c\u4e86");
                break;
            }
            AIOTask aIOTask = tasks.get(andIncrement);
            c.f337783b.a("AIOStartUpExecutor", "\u4e3b\u7ebf\u7a0b\u6267\u884c   " + andIncrement + "  " + aIOTask);
            aIOTask.c();
            this.tasksCountDown.countDown();
        }
        c cVar = c.f337783b;
        cVar.a("AIOStartUpExecutor", "\u4e3b\u7ebf\u7a0b\u7b49\u5f85");
        this.tasksCountDown.await();
        cVar.a("AIOStartUpExecutor", "\u4e3b\u7ebf\u7a0b\u6062\u590d");
    }

    public int d() {
        throw null;
    }

    @Override // com.tencent.mvi.dispatcher.a
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ThreadPoolExecutor b() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            value = iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            value = this.subExecutor.getValue();
        }
        return (ThreadPoolExecutor) value;
    }
}
