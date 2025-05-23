package com.tencent.timi.game.web.business.api.race;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/web/business/api/race/LivingRaceNativeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", AdMetricTag.EVENT_NAME, "", "(Ljava/lang/String;)V", "data", "", "(Ljava/lang/String;Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "getEventName", "()Ljava/lang/String;", "setEventName", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class LivingRaceNativeEvent extends SimpleBaseEvent {

    @Nullable
    private Object data;

    @NotNull
    private String eventName;

    public LivingRaceNativeEvent(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
    }

    @Nullable
    public final Object getData() {
        return this.data;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    public final void setData(@Nullable Object obj) {
        this.data = obj;
    }

    public final void setEventName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventName = str;
    }

    public LivingRaceNativeEvent(@NotNull String eventName, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
        this.data = obj;
    }
}
