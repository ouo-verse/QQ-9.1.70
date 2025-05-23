package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import com.tencent.mobileqq.triton.statistic.FpsUpdateListener;
import com.tencent.mobileqq.triton.statistic.FrameCallback;
import com.tencent.mobileqq.triton.statistic.GetTraceInfoCallback;
import com.tencent.mobileqq.triton.statistic.JankTraceLevel;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;
import com.tencent.mobileqq.triton.statistic.SubpackageLoadStatisticsCallback;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010K\u001a\u0002052\u0006\u0010L\u001a\u00020IH\u0016J\u0012\u0010M\u001a\u0002052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010N\u001a\u0002052\b\u0010O\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010P\u001a\u0002052\b\u0010Q\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010R\u001a\u0002052\u0006\u0010L\u001a\u00020@H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000eR+\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!8V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020!0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000eR\u0014\u0010+\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010\nR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u000eR\u0014\u0010/\u001a\u0002008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R%\u00103\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000205\u0018\u0001040\f\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u000eR\u0014\u00107\u001a\u0002008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00102R%\u00109\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000205\u0018\u0001040\f\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\u000eR\u0014\u0010;\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010\nR%\u0010=\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u000205\u0018\u0001040\f\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\u000eR\u0019\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010@0\f\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010\u000eR\u0014\u0010B\u001a\u00020C8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010ER\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020C0\f\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010\u000eR\u0019\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010I0\f\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u000e\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/StatisticsManagerImpl;", "Lcom/tencent/mobileqq/triton/statistic/StatisticsManager;", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "engineLock", "Ljava/util/concurrent/locks/Lock;", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;Ljava/util/concurrent/locks/Lock;)V", "accumulatedDrawCalls", "", "getAccumulatedDrawCalls", "()J", "accumulatedDrawCallsHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "getAccumulatedDrawCallsHolder", "()Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "accumulatedFrames", "getAccumulatedFrames", "accumulatedFramesHolder", "getAccumulatedFramesHolder", "currentDrawCalls", "getCurrentDrawCalls", "currentDrawCallsHolder", "getCurrentDrawCallsHolder", "errorCallback", "Lcom/tencent/mobileqq/triton/statistic/ErrorCallback;", "getErrorCallback", "fpsListenerHolder", "Lcom/tencent/mobileqq/triton/statistic/FpsUpdateListener;", "getFpsListenerHolder", "frameCallbackHolder", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "getFrameCallbackHolder", "<set-?>", "Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "jankTraceLevel", "getJankTraceLevel", "()Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "setJankTraceLevel", "(Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;)V", "jankTraceLevel$delegate", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "jankTraceLevelHolder", "getJankTraceLevelHolder", "lastBlackScreenTimeMillis", "getLastBlackScreenTimeMillis", "lastBlackScreenTimeMillisHolder", "getLastBlackScreenTimeMillisHolder", "lastClickInfo", "", "getLastClickInfo", "()Ljava/lang/String;", "lastClickInfoHolder", "Lkotlin/Function1;", "", "getLastClickInfoHolder", "lastClicks", "getLastClicks", "lastClicksHolder", "getLastClicksHolder", "lastTouchTimestamp", "getLastTouchTimestamp", "lastTouchTimestampHolder", "getLastTouchTimestampHolder", "subpackageLoadStatisticsCallback", "Lcom/tencent/mobileqq/triton/statistic/SubpackageLoadStatisticsCallback;", "getSubpackageLoadStatisticsCallback", "targetFPS", "", "getTargetFPS", "()F", "targetFPSHolder", "getTargetFPSHolder", "traceInfoCallbackHolder", "Lcom/tencent/mobileqq/triton/statistic/GetTraceInfoCallback;", "getTraceInfoCallbackHolder", "getTraceInfo", "callback", "setErrorCallback", "setFpsUpdateListener", "fpsUpdateListener", "setFrameCallback", "frameCallback", "setSubpackageLoadStatisticsCallback", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class StatisticsManagerImpl implements StatisticsManager {

    @NotNull
    private final ValueHolder<Long> accumulatedDrawCallsHolder;

    @NotNull
    private final ValueHolder<Long> accumulatedFramesHolder;

    @NotNull
    private final ValueHolder<Long> currentDrawCallsHolder;

    @NotNull
    private final ValueHolder<ErrorCallback> errorCallback;

    @NotNull
    private final ValueHolder<FpsUpdateListener> fpsListenerHolder;

    @NotNull
    private final ValueHolder<FrameCallback> frameCallbackHolder;

    /* renamed from: jankTraceLevel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ValueHolder jankTraceLevel;

    @NotNull
    private final ValueHolder<JankTraceLevel> jankTraceLevelHolder;

    @NotNull
    private final ValueHolder<Long> lastBlackScreenTimeMillisHolder;

    @NotNull
    private final ValueHolder<Function1<String, Unit>> lastClickInfoHolder;

    @NotNull
    private final ValueHolder<Function1<String, Unit>> lastClicksHolder;

    @NotNull
    private final ValueHolder<Function1<Long, Unit>> lastTouchTimestampHolder;

    @NotNull
    private final ValueHolder<SubpackageLoadStatisticsCallback> subpackageLoadStatisticsCallback;

    @NotNull
    private final ValueHolder<Float> targetFPSHolder;

    @NotNull
    private final ValueHolder<GetTraceInfoCallback> traceInfoCallbackHolder;

    public StatisticsManagerImpl(@NotNull LifeCycleOwner lifeCycleOwner, @NotNull Lock engineLock) {
        Intrinsics.checkParameterIsNotNull(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.checkParameterIsNotNull(engineLock, "engineLock");
        this.accumulatedDrawCallsHolder = new ValueHolder<>(0L, lifeCycleOwner, engineLock);
        this.currentDrawCallsHolder = new ValueHolder<>(0L, lifeCycleOwner, engineLock);
        this.accumulatedFramesHolder = new ValueHolder<>(0L, lifeCycleOwner, engineLock);
        this.targetFPSHolder = new ValueHolder<>(Float.valueOf(0.0f), lifeCycleOwner, engineLock);
        ValueHolder<JankTraceLevel> valueHolder = new ValueHolder<>(JankTraceLevel.NONE, lifeCycleOwner, engineLock);
        this.jankTraceLevelHolder = valueHolder;
        this.jankTraceLevel = valueHolder;
        this.traceInfoCallbackHolder = new ValueHolder<>(null, lifeCycleOwner, engineLock);
        this.lastBlackScreenTimeMillisHolder = new ValueHolder<>(0L, lifeCycleOwner, engineLock);
        this.lastClicksHolder = new ValueHolder<>(null, lifeCycleOwner, engineLock);
        this.lastClickInfoHolder = new ValueHolder<>(null, lifeCycleOwner, engineLock);
        this.frameCallbackHolder = new ValueHolder<>(null, lifeCycleOwner, engineLock);
        this.fpsListenerHolder = new ValueHolder<>(null, lifeCycleOwner, engineLock);
        this.lastTouchTimestampHolder = new ValueHolder<>(null, lifeCycleOwner, engineLock);
        this.errorCallback = new ValueHolder<>(null, lifeCycleOwner, engineLock);
        this.subpackageLoadStatisticsCallback = new ValueHolder<>(null, lifeCycleOwner, engineLock);
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    public long getAccumulatedDrawCalls() {
        return this.accumulatedDrawCallsHolder.getValue().longValue();
    }

    @NotNull
    public final ValueHolder<Long> getAccumulatedDrawCallsHolder() {
        return this.accumulatedDrawCallsHolder;
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    public long getAccumulatedFrames() {
        return this.accumulatedFramesHolder.getValue().longValue();
    }

    @NotNull
    public final ValueHolder<Long> getAccumulatedFramesHolder() {
        return this.accumulatedFramesHolder;
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    public long getCurrentDrawCalls() {
        return this.currentDrawCallsHolder.getValue().longValue();
    }

    @NotNull
    public final ValueHolder<Long> getCurrentDrawCallsHolder() {
        return this.currentDrawCallsHolder;
    }

    @NotNull
    public final ValueHolder<ErrorCallback> getErrorCallback() {
        return this.errorCallback;
    }

    @NotNull
    public final ValueHolder<FpsUpdateListener> getFpsListenerHolder() {
        return this.fpsListenerHolder;
    }

    @NotNull
    public final ValueHolder<FrameCallback> getFrameCallbackHolder() {
        return this.frameCallbackHolder;
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    @NotNull
    public JankTraceLevel getJankTraceLevel() {
        return (JankTraceLevel) this.jankTraceLevel.getValue();
    }

    @NotNull
    public final ValueHolder<JankTraceLevel> getJankTraceLevelHolder() {
        return this.jankTraceLevelHolder;
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    public long getLastBlackScreenTimeMillis() {
        return this.lastBlackScreenTimeMillisHolder.getValue().longValue();
    }

    @NotNull
    public final ValueHolder<Long> getLastBlackScreenTimeMillisHolder() {
        return this.lastBlackScreenTimeMillisHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    @NotNull
    public String getLastClickInfo() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        this.lastClickInfoHolder.setValue(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl$lastClickInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                Ref.ObjectRef.this.element = it;
            }
        });
        return (String) objectRef.element;
    }

    @NotNull
    public final ValueHolder<Function1<String, Unit>> getLastClickInfoHolder() {
        return this.lastClickInfoHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    @NotNull
    public String getLastClicks() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        this.lastClicksHolder.setValue(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl$lastClicks$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                Ref.ObjectRef.this.element = it;
            }
        });
        return (String) objectRef.element;
    }

    @NotNull
    public final ValueHolder<Function1<String, Unit>> getLastClicksHolder() {
        return this.lastClicksHolder;
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    public long getLastTouchTimestamp() {
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = 0L;
        this.lastTouchTimestampHolder.setValue(new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl$lastTouchTimestamp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke(l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j3) {
                Ref.LongRef.this.element = j3;
            }
        });
        return longRef.element;
    }

    @NotNull
    public final ValueHolder<Function1<Long, Unit>> getLastTouchTimestampHolder() {
        return this.lastTouchTimestampHolder;
    }

    @NotNull
    public final ValueHolder<SubpackageLoadStatisticsCallback> getSubpackageLoadStatisticsCallback() {
        return this.subpackageLoadStatisticsCallback;
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    public float getTargetFPS() {
        return this.targetFPSHolder.getValue().floatValue();
    }

    @NotNull
    public final ValueHolder<Float> getTargetFPSHolder() {
        return this.targetFPSHolder;
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    public void getTraceInfo(@NotNull GetTraceInfoCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.traceInfoCallbackHolder.setValue(callback);
    }

    @NotNull
    public final ValueHolder<GetTraceInfoCallback> getTraceInfoCallbackHolder() {
        return this.traceInfoCallbackHolder;
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    public void setErrorCallback(@Nullable ErrorCallback errorCallback) {
        this.errorCallback.setValue(errorCallback);
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    public void setFpsUpdateListener(@Nullable FpsUpdateListener fpsUpdateListener) {
        this.fpsListenerHolder.setValue(fpsUpdateListener);
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    public void setFrameCallback(@Nullable FrameCallback frameCallback) {
        this.frameCallbackHolder.setValue(frameCallback);
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    public void setJankTraceLevel(@NotNull JankTraceLevel jankTraceLevel) {
        Intrinsics.checkParameterIsNotNull(jankTraceLevel, "<set-?>");
        this.jankTraceLevel.setValue(jankTraceLevel);
    }

    @Override // com.tencent.mobileqq.triton.statistic.StatisticsManager
    public void setSubpackageLoadStatisticsCallback(@NotNull SubpackageLoadStatisticsCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.subpackageLoadStatisticsCallback.setValue(callback);
    }
}
