package kotlinx.coroutines.test;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated(level = DeprecationLevel.WARNING, message = "This API has been deprecated to integrate with Structured Concurrency.", replaceWith = @ReplaceWith(expression = "TestCoroutineScope", imports = {"kotlin.coroutines.test"}))
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001<B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0019J$\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!0 J$\u0010\"\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!0 J*\u0010#\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\u0018\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020!0 J$\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!0 J\u0006\u0010%\u001a\u00020\u001bJ\u0014\u0010&\u001a\u00020\u001b2\n\u0010'\u001a\u00060(j\u0002`)H\u0002J5\u0010*\u001a\u0002H+\"\u0004\b\u0000\u0010+2\u0006\u0010,\u001a\u0002H+2\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002H+0.H\u0016\u00a2\u0006\u0002\u00100J(\u00101\u001a\u0004\u0018\u0001H2\"\b\b\u0000\u00102*\u00020/2\f\u00103\u001a\b\u0012\u0004\u0012\u0002H204H\u0096\u0002\u00a2\u0006\u0002\u00105J\u0014\u00106\u001a\u00020\u00012\n\u00103\u001a\u0006\u0012\u0002\b\u000304H\u0016J\u0010\u00107\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u001c\u00108\u001a\u00020\u00122\n\u0010'\u001a\u00060(j\u0002`)2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u00109\u001a\u00020\u0006H\u0002J\b\u0010:\u001a\u00020\u0003H\u0016J\u0006\u0010;\u001a\u00020\u001bJ\u0010\u0010;\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lkotlinx/coroutines/test/TestCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "name", "", "(Ljava/lang/String;)V", "counter", "", "ctxDispatcher", "Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", "ctxHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptions", "", "", "getExceptions", "()Ljava/util/List;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/test/TimedRunnableObsolete;", "time", "uncaughtExceptions", "", "advanceTimeBy", "delayTime", "unit", "Ljava/util/concurrent/TimeUnit;", "advanceTimeTo", "", "targetTime", "assertAllUnhandledExceptions", "message", "predicate", "Lkotlin/Function1;", "", "assertAnyUnhandledException", "assertExceptions", "assertUnhandledException", "cancelAllActions", "enqueue", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", QCircleDaTongConstant.ElementParamValue.PYMK_FOLD, BdhLogUtil.LogTag.Tag_Req, "initial", QCircleDaTongConstant.ElementParamValue.OPERATION, "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "now", "postDelayed", "processNextEvent", "toString", "triggerActions", "Dispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class TestCoroutineContext implements CoroutineContext {
    private long counter;

    @NotNull
    private final Dispatcher ctxDispatcher;

    @NotNull
    private final CoroutineExceptionHandler ctxHandler;

    @Nullable
    private final String name;

    @NotNull
    private final ThreadSafeHeap<TimedRunnable> queue;
    private long time;

    @NotNull
    private final List<Throwable> uncaughtExceptions;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0016J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016\u00a8\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", "Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/Delay;", "(Lkotlinx/coroutines/test/TestCoroutineContext;)V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "processNextEvent", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "shouldBeProcessedFromContext", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    private final class Dispatcher extends EventLoop implements Delay {
        public Dispatcher() {
            EventLoop.incrementUseCount$default(this, false, 1, null);
        }

        @Override // kotlinx.coroutines.Delay
        @Nullable
        public Object delay(long j3, @NotNull Continuation<? super Unit> continuation) {
            return Delay.DefaultImpls.delay(this, j3, continuation);
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        /* renamed from: dispatch */
        public void mo2047dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
            TestCoroutineContext.this.enqueue(block);
        }

        @Override // kotlinx.coroutines.Delay
        @NotNull
        public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
            final TimedRunnable postDelayed = TestCoroutineContext.this.postDelayed(block, timeMillis);
            final TestCoroutineContext testCoroutineContext = TestCoroutineContext.this;
            return new DisposableHandle() { // from class: kotlinx.coroutines.test.TestCoroutineContext$Dispatcher$invokeOnTimeout$1
                @Override // kotlinx.coroutines.DisposableHandle
                public void dispose() {
                    ThreadSafeHeap threadSafeHeap;
                    threadSafeHeap = TestCoroutineContext.this.queue;
                    threadSafeHeap.remove(postDelayed);
                }
            };
        }

        @Override // kotlinx.coroutines.EventLoop
        public long processNextEvent() {
            return TestCoroutineContext.this.processNextEvent();
        }

        @Override // kotlinx.coroutines.Delay
        /* renamed from: scheduleResumeAfterDelay */
        public void mo2048scheduleResumeAfterDelay(long timeMillis, @NotNull final CancellableContinuation<? super Unit> continuation) {
            TestCoroutineContext.this.postDelayed(new Runnable() { // from class: kotlinx.coroutines.test.TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    CancellableContinuation.this.resumeUndispatched(this, Unit.INSTANCE);
                }
            }, timeMillis);
        }

        @Override // kotlinx.coroutines.EventLoop
        public boolean shouldBeProcessedFromContext() {
            return true;
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        @NotNull
        public String toString() {
            return "Dispatcher(" + TestCoroutineContext.this + ')';
        }
    }

    public TestCoroutineContext() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ long advanceTimeBy$default(TestCoroutineContext testCoroutineContext, long j3, TimeUnit timeUnit, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.advanceTimeBy(j3, timeUnit);
    }

    public static /* synthetic */ void advanceTimeTo$default(TestCoroutineContext testCoroutineContext, long j3, TimeUnit timeUnit, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        testCoroutineContext.advanceTimeTo(j3, timeUnit);
    }

    public static /* synthetic */ void assertAllUnhandledExceptions$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAllUnhandledExceptions(str, function1);
    }

    public static /* synthetic */ void assertAnyUnhandledException$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAnyUnhandledException(str, function1);
    }

    public static /* synthetic */ void assertExceptions$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertExceptions(str, function1);
    }

    public static /* synthetic */ void assertUnhandledException$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertUnhandledException(str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueue(Runnable block) {
        ThreadSafeHeap<TimedRunnable> threadSafeHeap = this.queue;
        long j3 = this.counter;
        this.counter = 1 + j3;
        threadSafeHeap.addLast(new TimedRunnable(block, j3, 0L, 4, null));
    }

    public static /* synthetic */ long now$default(TestCoroutineContext testCoroutineContext, TimeUnit timeUnit, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.now(timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TimedRunnable postDelayed(Runnable block, long delayTime) {
        long j3 = this.counter;
        this.counter = 1 + j3;
        TimedRunnable timedRunnable = new TimedRunnable(block, j3, this.time + TimeUnit.MILLISECONDS.toNanos(delayTime));
        this.queue.addLast(timedRunnable);
        return timedRunnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long processNextEvent() {
        TimedRunnable peek = this.queue.peek();
        if (peek != null) {
            triggerActions(peek.time);
        }
        if (this.queue.isEmpty()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final long advanceTimeBy(long delayTime, @NotNull TimeUnit unit) {
        long j3 = this.time;
        long nanos = unit.toNanos(delayTime) + j3;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        advanceTimeTo(nanos, timeUnit);
        return unit.convert(this.time - j3, timeUnit);
    }

    public final void advanceTimeTo(long targetTime, @NotNull TimeUnit unit) {
        long nanos = unit.toNanos(targetTime);
        triggerActions(nanos);
        if (nanos > this.time) {
            this.time = nanos;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void assertAllUnhandledExceptions(@NotNull String message, @NotNull Function1<? super Throwable, Boolean> predicate) {
        List<Throwable> list = this.uncaughtExceptions;
        boolean z16 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!predicate.invoke(it.next()).booleanValue()) {
                    z16 = false;
                    break;
                }
            }
        }
        if (z16) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void assertAnyUnhandledException(@NotNull String message, @NotNull Function1<? super Throwable, Boolean> predicate) {
        List<Throwable> list = this.uncaughtExceptions;
        boolean z16 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (predicate.invoke(it.next()).booleanValue()) {
                    z16 = true;
                    break;
                }
            }
        }
        if (z16) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(message);
    }

    public final void assertExceptions(@NotNull String message, @NotNull Function1<? super List<? extends Throwable>, Boolean> predicate) {
        if (predicate.invoke(this.uncaughtExceptions).booleanValue()) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(message);
    }

    public final void assertUnhandledException(@NotNull String message, @NotNull Function1<? super Throwable, Boolean> predicate) {
        if (this.uncaughtExceptions.size() == 1 && predicate.invoke(this.uncaughtExceptions.get(0)).booleanValue()) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(message);
    }

    public final void cancelAllActions() {
        if (!this.queue.isEmpty()) {
            this.queue.clear();
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return operation.invoke(operation.invoke(initial, this.ctxDispatcher), this.ctxHandler);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        if (key == ContinuationInterceptor.INSTANCE) {
            return this.ctxDispatcher;
        }
        if (key == CoroutineExceptionHandler.INSTANCE) {
            return this.ctxHandler;
        }
        return null;
    }

    @NotNull
    public final List<Throwable> getExceptions() {
        return this.uncaughtExceptions;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        if (key == ContinuationInterceptor.INSTANCE) {
            return this.ctxHandler;
        }
        if (key == CoroutineExceptionHandler.INSTANCE) {
            return this.ctxDispatcher;
        }
        return this;
    }

    public final long now(@NotNull TimeUnit unit) {
        return unit.convert(this.time, TimeUnit.NANOSECONDS);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    @NotNull
    public String toString() {
        String str = this.name;
        if (str == null) {
            return Intrinsics.stringPlus("TestCoroutineContext@", DebugStringsKt.getHexAddress(this));
        }
        return str;
    }

    public final void triggerActions() {
        triggerActions(this.time);
    }

    public TestCoroutineContext(@Nullable String str) {
        this.name = str;
        this.uncaughtExceptions = new ArrayList();
        this.ctxDispatcher = new Dispatcher();
        this.ctxHandler = new TestCoroutineContext$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this);
        this.queue = new ThreadSafeHeap<>();
    }

    private final void triggerActions(long targetTime) {
        TimedRunnable timedRunnable;
        while (true) {
            ThreadSafeHeap<TimedRunnable> threadSafeHeap = this.queue;
            synchronized (threadSafeHeap) {
                TimedRunnable firstImpl = threadSafeHeap.firstImpl();
                if (firstImpl != null) {
                    timedRunnable = (firstImpl.time > targetTime ? 1 : (firstImpl.time == targetTime ? 0 : -1)) <= 0 ? threadSafeHeap.removeAtImpl(0) : null;
                }
            }
            TimedRunnable timedRunnable2 = timedRunnable;
            if (timedRunnable2 == null) {
                return;
            }
            long j3 = timedRunnable2.time;
            if (j3 != 0) {
                this.time = j3;
            }
            timedRunnable2.run();
        }
    }

    public /* synthetic */ TestCoroutineContext(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str);
    }
}
