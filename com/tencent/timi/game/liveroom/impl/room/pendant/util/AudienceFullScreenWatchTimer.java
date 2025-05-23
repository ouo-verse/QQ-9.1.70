package com.tencent.timi.game.liveroom.impl.room.pendant.util;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.timi.game.liveroom.impl.room.pendant.util.AudienceFullScreenWatchTimer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\u0007*\u0001\u0013\u0018\u0000 \u00072\u00020\u0001:\u0002\n\u000eB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0002R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/pendant/util/AudienceFullScreenWatchTimer;", "", "", "f", "g", "Lcom/tencent/timi/game/liveroom/impl/room/pendant/util/AudienceFullScreenWatchTimer$b;", "listener", "e", h.F, "", "a", "Ljava/util/List;", "listenerList", "", "b", "J", "fullScreenWatchTime", "c", WidgetCacheConstellationData.INTERVAL, "com/tencent/timi/game/liveroom/impl/room/pendant/util/AudienceFullScreenWatchTimer$timer$1", "d", "Lcom/tencent/timi/game/liveroom/impl/room/pendant/util/AudienceFullScreenWatchTimer$timer$1;", SemanticAttributes.FaasTriggerValues.TIMER, "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AudienceFullScreenWatchTimer {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long fullScreenWatchTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long interval;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> listenerList = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AudienceFullScreenWatchTimer$timer$1 timer = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.util.AudienceFullScreenWatchTimer$timer$1
        @Override // java.lang.Runnable
        public void run() {
            long j3;
            long j16;
            List<AudienceFullScreenWatchTimer.b> list;
            long j17;
            AudienceFullScreenWatchTimer audienceFullScreenWatchTimer = AudienceFullScreenWatchTimer.this;
            j3 = audienceFullScreenWatchTimer.fullScreenWatchTime;
            j16 = AudienceFullScreenWatchTimer.this.interval;
            audienceFullScreenWatchTimer.fullScreenWatchTime = j3 + j16;
            list = AudienceFullScreenWatchTimer.this.listenerList;
            for (AudienceFullScreenWatchTimer.b bVar : list) {
                j17 = AudienceFullScreenWatchTimer.this.fullScreenWatchTime;
                bVar.a(j17);
            }
            AudienceFullScreenWatchTimer.this.f();
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/pendant/util/AudienceFullScreenWatchTimer$b;", "", "", "fullScreenWatchTime", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(long fullScreenWatchTime);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.tencent.timi.game.liveroom.impl.room.pendant.util.AudienceFullScreenWatchTimer$timer$1] */
    public AudienceFullScreenWatchTimer() {
        this.interval = 2000L;
        this.interval = ht3.a.c("qqlive_audience_watchtime_count_interval", 2000L);
    }

    public final void e(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listenerList.add(listener);
    }

    public final void f() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.timer);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.timer, this.interval);
    }

    public final void g() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.timer);
    }

    public final void h() {
        this.listenerList.clear();
        this.fullScreenWatchTime = 0L;
    }
}
