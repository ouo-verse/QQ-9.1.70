package kotlinx.coroutines;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\u001bj\u0002`\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0011\u0010\u0007R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0015R\u001e\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/ThreadState;", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "clearInterrupt", "()V", "", "state", "", "invalidState", "(I)Ljava/lang/Void;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "invoke", "(Ljava/lang/Throwable;)V", ColorRingJsPlugin.Method_SetUp, "Lkotlinx/coroutines/DisposableHandle;", "cancelHandle", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "targetThread", "Ljava/lang/Thread;", "kotlinx-coroutines-core", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
final class ThreadState implements Function1<Throwable, Unit> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _state$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state");

    @Nullable
    private DisposableHandle cancelHandle;

    @NotNull
    private final Job job;

    @NotNull
    private volatile /* synthetic */ int _state = 0;
    private final Thread targetThread = Thread.currentThread();

    public ThreadState(@NotNull Job job) {
        this.job = job;
    }

    private final Void invalidState(int state) {
        throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", Integer.valueOf(state)).toString());
    }

    public final void clearInterrupt() {
        while (true) {
            int i3 = this._state;
            if (i3 != 0) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        invalidState(i3);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (_state$FU.compareAndSet(this, i3, 1)) {
                DisposableHandle disposableHandle = this.cancelHandle;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
        invoke2(th5);
        return Unit.INSTANCE;
    }

    public final void setup() {
        int i3;
        this.cancelHandle = this.job.invokeOnCompletion(true, true, this);
        do {
            i3 = this._state;
            if (i3 != 0) {
                if (i3 != 2 && i3 != 3) {
                    invalidState(i3);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!_state$FU.compareAndSet(this, i3, 0));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@Nullable Throwable cause) {
        int i3;
        do {
            i3 = this._state;
            if (i3 != 0) {
                if (i3 == 1 || i3 == 2 || i3 == 3) {
                    return;
                }
                invalidState(i3);
                throw new KotlinNothingValueException();
            }
        } while (!_state$FU.compareAndSet(this, i3, 2));
        this.targetThread.interrupt();
        this._state = 3;
    }
}
