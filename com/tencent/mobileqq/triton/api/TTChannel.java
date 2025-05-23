package com.tencent.mobileqq.triton.api;

import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.utils.TritonKeep;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@TritonKeep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0017H\u0007J\b\u0010\u0019\u001a\u00020\u0017H\u0007J\b\u0010\u001a\u001a\u00020\u0007H\u0007J\b\u0010\u001b\u001a\u00020\u0017H\u0007J\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0007J\b\u0010\u001e\u001a\u00020\u0007H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/triton/api/TTChannel;", "", "mDebugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "(Lcom/tencent/mobileqq/triton/model/DebugConfig;)V", "onRenderErrorCallback", "Lkotlin/Function0;", "", "getOnRenderErrorCallback", "()Lkotlin/jvm/functions/Function0;", "setOnRenderErrorCallback", "(Lkotlin/jvm/functions/Function0;)V", "onScriptErrorCallback", "Lkotlin/Function1;", "", "getOnScriptErrorCallback", "()Lkotlin/jvm/functions/Function1;", "setOnScriptErrorCallback", "(Lkotlin/jvm/functions/Function1;)V", "v8OOMCallback", "getV8OOMCallback", "setV8OOMCallback", "g_frameNoChangeLimit", "", "g_noPresentDurationLimit", "g_noPresentTouchLimit", "g_onErrorDialog", "g_presentDetectInterval", "handleJavaScriptException", "bytes", "handleV8OOM", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class TTChannel {

    @NotNull
    public static final String NAME = "TTChannel";
    private final DebugConfig mDebugConfig;

    @Nullable
    private Function0<Unit> onRenderErrorCallback;

    @Nullable
    private Function1<? super byte[], Unit> onScriptErrorCallback;

    @Nullable
    private Function0<Unit> v8OOMCallback;

    public TTChannel(@NotNull DebugConfig mDebugConfig) {
        Intrinsics.checkParameterIsNotNull(mDebugConfig, "mDebugConfig");
        this.mDebugConfig = mDebugConfig;
    }

    @TritonKeep
    public final int g_frameNoChangeLimit() {
        return this.mDebugConfig.getFrameNoChangeToCheckLimit();
    }

    @TritonKeep
    public final int g_noPresentDurationLimit() {
        return (int) this.mDebugConfig.getNoPresentDurationToCheckLimitMillis();
    }

    @TritonKeep
    public final int g_noPresentTouchLimit() {
        return this.mDebugConfig.getNoPresentTouchLimit();
    }

    @TritonKeep
    public final void g_onErrorDialog() {
        Function0<Unit> function0 = this.onRenderErrorCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @TritonKeep
    public final int g_presentDetectInterval() {
        return (int) this.mDebugConfig.getPresentDetectIntervalMillis();
    }

    @Nullable
    public final Function0<Unit> getOnRenderErrorCallback() {
        return this.onRenderErrorCallback;
    }

    @Nullable
    public final Function1<byte[], Unit> getOnScriptErrorCallback() {
        return this.onScriptErrorCallback;
    }

    @Nullable
    public final Function0<Unit> getV8OOMCallback() {
        return this.v8OOMCallback;
    }

    @TritonKeep
    public final void handleJavaScriptException(@Nullable byte[] bytes) {
        Function1<? super byte[], Unit> function1 = this.onScriptErrorCallback;
        if (function1 != null) {
            function1.invoke(bytes);
        }
    }

    @TritonKeep
    public final void handleV8OOM() {
        Function0<Unit> function0 = this.v8OOMCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setOnRenderErrorCallback(@Nullable Function0<Unit> function0) {
        this.onRenderErrorCallback = function0;
    }

    public final void setOnScriptErrorCallback(@Nullable Function1<? super byte[], Unit> function1) {
        this.onScriptErrorCallback = function1;
    }

    public final void setV8OOMCallback(@Nullable Function0<Unit> function0) {
        this.v8OOMCallback = function0;
    }
}
