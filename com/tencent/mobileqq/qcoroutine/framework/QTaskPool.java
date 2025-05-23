package com.tencent.mobileqq.qcoroutine.framework;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.LogLever;
import com.tencent.mobileqq.qcoroutine.api.g;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010U\u001a\u00020R\u00a2\u0006\u0004\bV\u0010WJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u000bJ)\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010 \u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR#\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0!8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010&R\u0017\u0010,\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010.\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010)\u001a\u0004\b-\u0010+R\"\u00105\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0017\u0010:\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b#\u00107\u001a\u0004\b8\u00109R\u0017\u0010?\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010E\u001a\u00020@8\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010J\u001a\u00020F8\u0006\u00a2\u0006\f\n\u0004\b=\u0010G\u001a\u0004\bH\u0010IR$\u0010Q\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bA\u0010N\"\u0004\bO\u0010PR\u0017\u0010U\u001a\u00020R8\u0006\u00a2\u0006\f\n\u0004\b1\u0010S\u001a\u0004\bL\u0010T\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/QTaskPool;", "", "Lcom/tencent/mobileqq/qcoroutine/api/g;", "runnable", "", "c", "b", "a", "d", "Lcom/tencent/mobileqq/qcoroutine/framework/b;", "g", "Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/c;", "f", "", "name", "", "isMain", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/coroutines/CoroutineContext;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/coroutines/CoroutineScope;)Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/CoroutineScope;", "i", "()Lkotlinx/coroutines/CoroutineScope;", "setScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "Lkotlin/coroutines/CoroutineContext;", "e", "()Lkotlin/coroutines/CoroutineContext;", "setContextNoJob", "(Lkotlin/coroutines/CoroutineContext;)V", "contextNoJob", "", "Ljava/util/Map;", h.F, "()Ljava/util/Map;", "runnablePools", "Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/c;", "coroutRunablePools", "Lcom/tencent/mobileqq/qcoroutine/framework/report/a;", "Lcom/tencent/mobileqq/qcoroutine/framework/report/a;", "getStaticData", "()Lcom/tencent/mobileqq/qcoroutine/framework/report/a;", "staticData", "getSerialStaticData", "serialStaticData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setClose", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isClose", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CompletableJob;", "k", "()Lkotlinx/coroutines/CompletableJob;", "superJob", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "j", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lcom/tencent/mobileqq/qcoroutine/framework/a;", "Lcom/tencent/mobileqq/qcoroutine/framework/a;", "getContextType", "()Lcom/tencent/mobileqq/qcoroutine/framework/a;", "contextType", "Lcom/tencent/mobileqq/qcoroutine/framework/SerialExecutor;", "l", "Lcom/tencent/mobileqq/qcoroutine/framework/SerialExecutor;", "()Lcom/tencent/mobileqq/qcoroutine/framework/SerialExecutor;", "setSerialExecutor", "(Lcom/tencent/mobileqq/qcoroutine/framework/SerialExecutor;)V", "serialExecutor", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "()Lcom/tencent/mobileqq/qcoroutine/api/i;", "type", "<init>", "(Lcom/tencent/mobileqq/qcoroutine/api/i;)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class QTaskPool {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public CoroutineScope scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public CoroutineContext contextNoJob;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<g, b> runnablePools;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.qcoroutine.framework.coroutine.c coroutRunablePools;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qcoroutine.framework.report.a staticData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qcoroutine.framework.report.a serialStaticData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isClose;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineDispatcher dispatcher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CompletableJob superJob;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineExceptionHandler handler;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qcoroutine.framework.a contextType;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SerialExecutor serialExecutor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i type;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes16.dex */
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QTaskPool f261806d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CoroutineContext.Key key, QTaskPool qTaskPool) {
            super(key);
            this.f261806d = qTaskPool;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) key, (Object) qTaskPool);
            }
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) exception);
                return;
            }
            e.d("TaskPoolType:" + this.f261806d.l().c() + " Caught " + exception, LogLever.ERROR);
            throw exception;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/QTaskPool$b;", "", "Lcom/tencent/mobileqq/qcoroutine/api/d;", "runnable", "Lcom/tencent/mobileqq/qcoroutine/framework/b;", "job", "", "a", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.qcoroutine.framework.QTaskPool$b, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public final void a(@NotNull com.tencent.mobileqq.qcoroutine.api.d runnable, @Nullable b job) {
            long j3;
            long j16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable, (Object) job);
                return;
            }
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            d dVar = d.f261833c;
            if (dVar.d() == null) {
                long j17 = -1;
                if (job != null && job.d() != null) {
                    Long d16 = job.d();
                    Intrinsics.checkNotNull(d16);
                    long longValue = d16.longValue() - job.e();
                    if (job.g() != null) {
                        Long d17 = job.d();
                        Intrinsics.checkNotNull(d17);
                        long longValue2 = d17.longValue();
                        Long g16 = job.g();
                        Intrinsics.checkNotNull(g16);
                        j16 = longValue2 - g16.longValue();
                    } else {
                        j16 = -1;
                    }
                    if (job.h() != null) {
                        Long d18 = job.d();
                        Intrinsics.checkNotNull(d18);
                        long longValue3 = d18.longValue();
                        Long h16 = job.h();
                        Intrinsics.checkNotNull(h16);
                        j17 = longValue3 - h16.longValue();
                    }
                    long j18 = j17;
                    j17 = longValue;
                    j3 = j18;
                } else {
                    j3 = -1;
                    j16 = -1;
                }
                e.e("onRunnableFinish type:" + runnable.e().c() + ", name:" + runnable.d() + ",allTime:" + j17 + ",runTime:" + j16 + ",blockTime:" + j3, null, 2, null);
                return;
            }
            com.tencent.mobileqq.qcoroutine.api.e d19 = dVar.d();
            if (d19 != null) {
                d19.b(runnable, job);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9787);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QTaskPool(@NotNull i type) {
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) type);
            return;
        }
        this.type = type;
        this.runnablePools = new ConcurrentHashMap();
        this.coroutRunablePools = new com.tencent.mobileqq.qcoroutine.framework.coroutine.c(type);
        this.staticData = new com.tencent.mobileqq.qcoroutine.framework.report.a(type, 0L, 0L, 0L, 0, 30, null);
        this.serialStaticData = new com.tencent.mobileqq.qcoroutine.framework.report.a(type, 0L, 0L, 0L, 0, 30, null);
        this.isClose = new AtomicBoolean(true);
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.superJob = SupervisorJob$default;
        a aVar = new a(CoroutineExceptionHandler.INSTANCE, this);
        this.handler = aVar;
        com.tencent.mobileqq.qcoroutine.framework.a aVar2 = new com.tencent.mobileqq.qcoroutine.framework.a(type);
        this.contextType = aVar2;
        int i3 = c.f261819a[type.b().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                this.dispatcher = com.tencent.mobileqq.qcoroutine.souce.d.a(Dispatchers.getIO(), type.a());
            } else {
                this.dispatcher = com.tencent.mobileqq.qcoroutine.souce.d.a(Dispatchers.getDefault(), type.a());
            }
        } else {
            this.dispatcher = Dispatchers.getMain().getImmediate();
        }
        CoroutineContext plus = this.dispatcher.plus(aVar2);
        this.contextNoJob = plus;
        if (plus == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contextNoJob");
        }
        this.scope = CoroutineScopeKt.CoroutineScope(plus.plus(SupervisorJob$default).plus(aVar));
        if (type.a() > 1) {
            this.serialExecutor = new SerialExecutor(this);
        }
        this.isClose.set(false);
    }

    public final void a(@NotNull g runnable) {
        Job f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        runnable.f().set(true);
        b bVar = this.runnablePools.get(runnable);
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        this.isClose.set(true);
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scope");
        }
        CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        SerialExecutor serialExecutor = this.serialExecutor;
        if (serialExecutor != null) {
            serialExecutor.c();
        }
    }

    public final void c(@NotNull g runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) runnable);
        } else {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            DispatcherThread.C.d(new QTaskPool$execute$1(this, runnable));
        }
    }

    public final void d(@NotNull g runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (runnable.j() == null) {
            this.staticData.a(this.runnablePools.get(runnable));
        } else {
            this.serialStaticData.a(this.runnablePools.get(runnable));
        }
        INSTANCE.a(runnable, this.runnablePools.get(runnable));
        this.runnablePools.remove(runnable);
    }

    @NotNull
    public final CoroutineContext e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CoroutineContext) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        CoroutineContext coroutineContext = this.contextNoJob;
        if (coroutineContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contextNoJob");
        }
        return coroutineContext;
    }

    @NotNull
    public final com.tencent.mobileqq.qcoroutine.framework.coroutine.c f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (com.tencent.mobileqq.qcoroutine.framework.coroutine.c) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.coroutRunablePools;
    }

    @Nullable
    public final b g(@NotNull g runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (b) iPatchRedirector.redirect((short) 21, (Object) this, (Object) runnable);
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return this.runnablePools.get(runnable);
    }

    @NotNull
    public final Map<g, b> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.runnablePools;
    }

    @NotNull
    public final CoroutineScope i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scope");
        }
        return coroutineScope;
    }

    @Nullable
    public final SerialExecutor j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (SerialExecutor) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.serialExecutor;
    }

    @NotNull
    public final CompletableJob k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (CompletableJob) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.superJob;
    }

    @NotNull
    public final i l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (i) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.type;
    }

    @NotNull
    public final AtomicBoolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AtomicBoolean) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.isClose;
    }

    @NotNull
    public final CoroutineContext n(@NotNull String name, @Nullable Boolean isMain, @Nullable CoroutineScope scope) {
        CoroutineName c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (CoroutineContext) iPatchRedirector.redirect((short) 23, this, name, isMain, scope);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
        if (scope != null) {
            c16 = e.a(name, scope);
        } else {
            c16 = e.c(name);
        }
        if (c16 != null) {
            coroutineContext = coroutineContext.plus(c16);
        }
        if (isMain != null) {
            CoroutineContext coroutineContext2 = this.dispatcher;
            if (isMain.booleanValue()) {
                coroutineContext2 = Dispatchers.getMain().getImmediate();
            }
            return coroutineContext.plus(coroutineContext2);
        }
        return coroutineContext;
    }
}
