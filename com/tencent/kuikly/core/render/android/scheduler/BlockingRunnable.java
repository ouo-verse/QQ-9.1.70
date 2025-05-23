package com.tencent.kuikly.core.render.android.scheduler;

import android.os.ConditionVariable;
import android.os.Handler;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00020\u000fj\u0002`\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00020\u000fj\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/kuikly/core/render/android/scheduler/BlockingRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Landroid/os/Handler;", "handler", "", "delayMs", "timeout", "", "a", "Landroid/os/ConditionVariable;", "d", "Landroid/os/ConditionVariable;", "conditionVariable", "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreTask;", "e", "Lkotlin/jvm/functions/Function0;", "mTask", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
final class BlockingRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConditionVariable conditionVariable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> mTask;

    public BlockingRunnable(@NotNull Function0<Unit> mTask) {
        Intrinsics.checkNotNullParameter(mTask, "mTask");
        this.mTask = mTask;
        this.conditionVariable = new ConditionVariable();
    }

    public final boolean a(@NotNull Handler handler, long delayMs, long timeout) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (!handler.postDelayed(this, delayMs)) {
            return false;
        }
        this.conditionVariable.block(timeout);
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.mTask.invoke();
        } finally {
            this.conditionVariable.open();
        }
    }
}
