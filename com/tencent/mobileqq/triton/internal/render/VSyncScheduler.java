package com.tencent.mobileqq.triton.internal.render;

import android.view.Choreographer;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB>\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\bH\u0007J\b\u0010\u001d\u001a\u00020\bH\u0007R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/render/VSyncScheduler;", "", "vSyncListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "drawingTimeNanos", "", "targetFps", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "", "scheduleExecutor", "Ljava/util/concurrent/Executor;", "(Lkotlin/jvm/functions/Function1;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Ljava/util/concurrent/Executor;)V", "callbackMainLoop", "Ljava/lang/Runnable;", "fpsStabilizer", "Lcom/tencent/mobileqq/triton/internal/render/FpsStabilizer;", "lastFrameTimeNanos", "pendingVSyncCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "requestResetFrameDuration", "", "totalDrawTimeNanos", "vSyncCallback", "Landroid/view/Choreographer$FrameCallback;", "getDefaultFrameDuration", "startScheduleVSync", "stopScheduleVSync", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class VSyncScheduler {
    private static final int MAX_PENDING_VSYNC = 1;
    private final Runnable callbackMainLoop;
    private final FpsStabilizer fpsStabilizer;
    private long lastFrameTimeNanos;
    private final AtomicInteger pendingVSyncCount;
    private volatile boolean requestResetFrameDuration;
    private final Executor scheduleExecutor;
    private final ValueHolder<Float> targetFps;
    private long totalDrawTimeNanos;
    private final Choreographer.FrameCallback vSyncCallback;
    private final Function1<Long, Unit> vSyncListener;

    /* JADX WARN: Multi-variable type inference failed */
    public VSyncScheduler(@NotNull Function1<? super Long, Unit> vSyncListener, @NotNull ValueHolder<Float> targetFps, @NotNull Executor scheduleExecutor) {
        Intrinsics.checkParameterIsNotNull(vSyncListener, "vSyncListener");
        Intrinsics.checkParameterIsNotNull(targetFps, "targetFps");
        Intrinsics.checkParameterIsNotNull(scheduleExecutor, "scheduleExecutor");
        this.vSyncListener = vSyncListener;
        this.targetFps = targetFps;
        this.scheduleExecutor = scheduleExecutor;
        this.pendingVSyncCount = new AtomicInteger();
        this.fpsStabilizer = new FpsStabilizer();
        this.callbackMainLoop = new Runnable() { // from class: com.tencent.mobileqq.triton.internal.render.VSyncScheduler$callbackMainLoop$1
            /* JADX WARN: Code restructure failed: missing block: B:7:0x002d, code lost:
            
                if (r4 != false) goto L10;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                AtomicInteger atomicInteger;
                long j3;
                long j16;
                long j17;
                long j18;
                long j19;
                Function1 function1;
                long j26;
                boolean z16;
                atomicInteger = VSyncScheduler.this.pendingVSyncCount;
                atomicInteger.decrementAndGet();
                long nanoTime = System.nanoTime();
                j3 = VSyncScheduler.this.lastFrameTimeNanos;
                if (j3 != 0) {
                    j16 = VSyncScheduler.this.lastFrameTimeNanos;
                    j17 = nanoTime - j16;
                } else {
                    j17 = 0;
                }
                if (j17 >= 0) {
                    z16 = VSyncScheduler.this.requestResetFrameDuration;
                }
                VSyncScheduler.this.requestResetFrameDuration = false;
                j17 = VSyncScheduler.this.getDefaultFrameDuration();
                VSyncScheduler.this.lastFrameTimeNanos = nanoTime;
                VSyncScheduler vSyncScheduler = VSyncScheduler.this;
                j18 = vSyncScheduler.totalDrawTimeNanos;
                vSyncScheduler.totalDrawTimeNanos = j18 + j17;
                FpsStabilizer fpsStabilizer = VSyncScheduler.this.fpsStabilizer;
                j19 = VSyncScheduler.this.totalDrawTimeNanos;
                if (fpsStabilizer.shouldDoFrame(j19)) {
                    function1 = VSyncScheduler.this.vSyncListener;
                    j26 = VSyncScheduler.this.totalDrawTimeNanos;
                    function1.invoke(Long.valueOf(j26));
                }
            }
        };
        this.vSyncCallback = new Choreographer.FrameCallback() { // from class: com.tencent.mobileqq.triton.internal.render.VSyncScheduler$vSyncCallback$1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long frameTimeNanos) {
                AtomicInteger atomicInteger;
                AtomicInteger atomicInteger2;
                Executor executor;
                Runnable runnable;
                atomicInteger = VSyncScheduler.this.pendingVSyncCount;
                if (atomicInteger.get() < 1) {
                    atomicInteger2 = VSyncScheduler.this.pendingVSyncCount;
                    atomicInteger2.incrementAndGet();
                    executor = VSyncScheduler.this.scheduleExecutor;
                    runnable = VSyncScheduler.this.callbackMainLoop;
                    executor.execute(runnable);
                }
                Choreographer.getInstance().postFrameCallback(this);
            }
        };
        targetFps.observe(new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.triton.internal.render.VSyncScheduler.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                invoke(f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f16) {
                VSyncScheduler.this.fpsStabilizer.setTargetFps(f16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getDefaultFrameDuration() {
        if (this.targetFps.getValue().floatValue() > 0) {
            return ((float) TimeUnit.SECONDS.toNanos(1L)) / r0;
        }
        return TimeUnit.SECONDS.toNanos(1L) / 60;
    }

    @MainThread
    public final void startScheduleVSync() {
        Choreographer.getInstance().postFrameCallback(this.vSyncCallback);
    }

    @MainThread
    public final void stopScheduleVSync() {
        Choreographer.getInstance().removeFrameCallback(this.vSyncCallback);
        this.requestResetFrameDuration = true;
    }
}
