package com.tencent.zplan.meme;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.zplan.meme.Scheduler$job$2;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0005B\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/zplan/meme/Scheduler;", "", "", "g", "", "a", "Z", "running", "com/tencent/zplan/meme/Scheduler$job$2$1", "b", "Lkotlin/Lazy;", "f", "()Lcom/tencent/zplan/meme/Scheduler$job$2$1;", "job", "", "c", "J", WidgetCacheConstellationData.INTERVAL, "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "task", "<init>", "(JLkotlin/jvm/functions/Function0;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class Scheduler {

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final Lazy f385763e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f385764f = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean running;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy job;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long interval;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Function0<Boolean> task;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/meme/Scheduler$a;", "", "Llx4/f;", "threadPool$delegate", "Lkotlin/Lazy;", "a", "()Llx4/f;", "threadPool", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        a() {
        }

        @NotNull
        public final lx4.f a() {
            Lazy lazy = Scheduler.f385763e;
            a unused = Scheduler.f385764f;
            return (lx4.f) lazy.getValue();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<lx4.f>() { // from class: com.tencent.zplan.meme.Scheduler$Companion$threadPool$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final lx4.f invoke() {
                Object a16 = mx4.a.f417748a.a(lx4.f.class);
                Intrinsics.checkNotNull(a16);
                return (lx4.f) a16;
            }
        });
        f385763e = lazy;
    }

    public Scheduler(long j3, @NotNull Function0<Boolean> task) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(task, "task");
        this.interval = j3;
        this.task = task;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Scheduler$job$2.AnonymousClass1>() { // from class: com.tencent.zplan.meme.Scheduler$job$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.zplan.meme.Scheduler$job$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                return new Runnable() { // from class: com.tencent.zplan.meme.Scheduler$job$2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Function0 function0;
                        long j16;
                        function0 = Scheduler.this.task;
                        if (!((Boolean) function0.invoke()).booleanValue()) {
                            Scheduler.this.running = false;
                            return;
                        }
                        lx4.f a16 = Scheduler.f385764f.a();
                        j16 = Scheduler.this.interval;
                        a16.c(this, j16);
                    }
                };
            }
        });
        this.job = lazy;
    }

    private final Scheduler$job$2.AnonymousClass1 f() {
        return (Scheduler$job$2.AnonymousClass1) this.job.getValue();
    }

    public final void g() {
        if (this.running) {
            return;
        }
        this.running = true;
        f385764f.a().c(f(), this.interval);
    }
}
