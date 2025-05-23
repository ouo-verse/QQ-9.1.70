package com.tencent.icgame.common.monitor;

import kotlin.Metadata;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/icgame/common/monitor/e;", "Lcom/tencent/icgame/common/monitor/j;", "", "b", "e", "com/tencent/icgame/common/monitor/e$a", "Lcom/tencent/icgame/common/monitor/e$a;", "simpleQActivityLifecycleCallbacks", "<init>", "()V", "ic-game-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class e extends j {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a simpleQActivityLifecycleCallbacks;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/icgame/common/monitor/e$a", "Lcom/tencent/icgame/common/monitor/l;", "", "onProcessBackground", "ic-game-common-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a extends l {
        a() {
        }

        @Override // com.tencent.icgame.common.monitor.l, mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            e.this.d();
        }
    }

    public e() {
        super(null);
        this.simpleQActivityLifecycleCallbacks = new a();
    }

    @Override // com.tencent.icgame.common.monitor.j
    public void b() {
        Foreground.addActivityLifeCallback(this.simpleQActivityLifecycleCallbacks);
    }

    @Override // com.tencent.icgame.common.monitor.j
    public void e() {
        Foreground.removeActivityLifeCallback(this.simpleQActivityLifecycleCallbacks);
    }
}
