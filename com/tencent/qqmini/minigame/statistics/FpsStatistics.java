package com.tencent.qqmini.minigame.statistics;

import com.tencent.mobileqq.triton.statistic.FpsUpdateListener;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqmini/minigame/statistics/FpsStatistics;", "Lcom/tencent/mobileqq/triton/statistic/FpsUpdateListener;", "", "fps", "", "onFpsUpdate", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqmini/minigame/GameRuntime;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "runtimeRef", "runtime", "<init>", "(Lcom/tencent/qqmini/minigame/GameRuntime;)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class FpsStatistics implements FpsUpdateListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<GameRuntime> runtimeRef;

    public FpsStatistics(@NotNull GameRuntime runtime) {
        Intrinsics.checkParameterIsNotNull(runtime, "runtime");
        this.runtimeRef = new WeakReference<>(runtime);
    }

    @Override // com.tencent.mobileqq.triton.statistic.FpsUpdateListener
    public void onFpsUpdate(final float fps) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.statistics.FpsStatistics$onFpsUpdate$1
            @Override // java.lang.Runnable
            public final void run() {
                WeakReference weakReference;
                weakReference = FpsStatistics.this.runtimeRef;
                GameRuntime gameRuntime = (GameRuntime) weakReference.get();
                if (gameRuntime != null) {
                    gameRuntime.onFpsUpdate(fps);
                }
            }
        });
    }
}
