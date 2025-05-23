package com.tencent.mobileqq.qcoroutine.souce;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0017\u0012\u0006\u0010(\u001a\u00020\u0001\u0012\u0006\u0010*\u001a\u00020\u0019\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\b\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u001c\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0017J\u001b\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000f2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u001f\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H\u0096\u0001R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010 \u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010%\u001a\u00060!j\u0002`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/souce/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/Delay;", "", "j", "block", "c", "", TencentLocation.RUN_MODE, "Lkotlin/coroutines/CoroutineContext;", "context", "dispatch", "dispatchYield", "", "time", "delay", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "", "d", "I", "runningWorkers", "Lcom/tencent/mobileqq/qcoroutine/souce/a;", "e", "Lcom/tencent/mobileqq/qcoroutine/souce/a;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "f", "Ljava/lang/Object;", "workerAllocationLock", h.F, "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "i", "parallelism", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class LimitedDispatcher extends CoroutineDispatcher implements Runnable, Delay {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile int runningWorkers;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final a<Runnable> queue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Object workerAllocationLock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher dispatcher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int parallelism;

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ Delay f261845m;

    public LimitedDispatcher(@NotNull CoroutineDispatcher dispatcher, int i3) {
        Object obj;
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dispatcher, i3);
            return;
        }
        if (!(dispatcher instanceof Delay)) {
            obj = null;
        } else {
            obj = dispatcher;
        }
        Delay delay = (Delay) obj;
        this.f261845m = delay == null ? c.c() : delay;
        this.dispatcher = dispatcher;
        this.parallelism = i3;
        this.queue = new a<>(false);
        this.workerAllocationLock = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c(Runnable block) {
        this.queue.a(block);
        if (this.runningWorkers >= this.parallelism) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        synchronized (this.workerAllocationLock) {
            if (this.runningWorkers >= this.parallelism) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @Override // kotlinx.coroutines.Delay
    @Nullable
    public Object delay(long j3, @NotNull Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), continuation);
        }
        return this.f261845m.delay(j3, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public void mo2047dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!c(block) && j()) {
            this.dispatcher.mo2047dispatch(this, this);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @InternalCoroutinesApi
    public void dispatchYield(@NotNull CoroutineContext context, @NotNull Runnable block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!c(block) && j()) {
            this.dispatcher.dispatchYield(this, this);
        }
    }

    @Override // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (DisposableHandle) iPatchRedirector.redirect((short) 6, this, Long.valueOf(timeMillis), block, context);
        }
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f261845m.invokeOnTimeout(timeMillis, block, context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0038, code lost:
    
        r2 = r5.workerAllocationLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003a, code lost:
    
        monitor-enter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003b, code lost:
    
        r5.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0047, code lost:
    
        if (r5.queue.b() != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004b, code lost:
    
        r5.runningWorkers++;
        r3 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0049, code lost:
    
        monitor-exit(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004a, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        while (true) {
            int i3 = 0;
            while (true) {
                Runnable c16 = this.queue.c();
                if (c16 == null) {
                    break;
                }
                try {
                    c16.run();
                } catch (Throwable th5) {
                    CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th5);
                }
                i3++;
                if (i3 >= 16 && this.dispatcher.isDispatchNeeded(this)) {
                    this.dispatcher.mo2047dispatch(this, this);
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Delay
    /* renamed from: scheduleResumeAfterDelay */
    public void mo2048scheduleResumeAfterDelay(long timeMillis, @NotNull CancellableContinuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(timeMillis), continuation);
        } else {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.f261845m.mo2048scheduleResumeAfterDelay(timeMillis, continuation);
        }
    }
}
