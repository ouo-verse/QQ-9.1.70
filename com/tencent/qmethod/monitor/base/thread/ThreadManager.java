package com.tencent.qmethod.monitor.base.thread;

import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qmethod/monitor/base/thread/ThreadManager;", "", "Landroid/os/Looper;", "a", "Lkotlin/Lazy;", "b", "()Landroid/os/Looper;", "REPORTER_LOOPER", "NETWORK_LOOPER", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class ThreadManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy REPORTER_LOOPER;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy NETWORK_LOOPER;

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadManager f343506c = new ThreadManager();

    static {
        Lazy lazy;
        Lazy lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Looper>() { // from class: com.tencent.qmethod.monitor.base.thread.ThreadManager$REPORTER_LOOPER$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Looper invoke() {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("PrimaryMonitorReporter");
                baseHandlerThread.start();
                return baseHandlerThread.getLooper();
            }
        });
        REPORTER_LOOPER = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Looper>() { // from class: com.tencent.qmethod.monitor.base.thread.ThreadManager$NETWORK_LOOPER$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Looper invoke() {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("PrimaryMonitorNetwork");
                baseHandlerThread.start();
                return baseHandlerThread.getLooper();
            }
        });
        NETWORK_LOOPER = lazy2;
    }

    ThreadManager() {
    }

    @NotNull
    public final Looper a() {
        return (Looper) NETWORK_LOOPER.getValue();
    }

    @NotNull
    public final Looper b() {
        return (Looper) REPORTER_LOOPER.getValue();
    }
}
