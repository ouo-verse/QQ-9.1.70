package com.tencent.icgame.common.monitor;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/icgame/common/monitor/PeriodicallyTriggerSignal;", "Lcom/tencent/icgame/common/monitor/j;", "", "b", "e", "", "J", "intervalInMs", "com/tencent/icgame/common/monitor/PeriodicallyTriggerSignal$task$1", "c", "Lcom/tencent/icgame/common/monitor/PeriodicallyTriggerSignal$task$1;", "task", "<init>", "(J)V", "ic-game-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class PeriodicallyTriggerSignal extends j {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long intervalInMs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PeriodicallyTriggerSignal$task$1 task;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.icgame.common.monitor.PeriodicallyTriggerSignal$task$1] */
    public PeriodicallyTriggerSignal(long j3) {
        super(null);
        this.intervalInMs = j3;
        this.task = new Runnable() { // from class: com.tencent.icgame.common.monitor.PeriodicallyTriggerSignal$task$1
            @Override // java.lang.Runnable
            public void run() {
                long j16;
                PeriodicallyTriggerSignal.this.d();
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                j16 = PeriodicallyTriggerSignal.this.intervalInMs;
                uIHandlerV2.postDelayed(this, j16);
            }
        };
    }

    @Override // com.tencent.icgame.common.monitor.j
    public void b() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.task, this.intervalInMs);
    }

    @Override // com.tencent.icgame.common.monitor.j
    public void e() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.task);
    }
}
