package com.tencent.mobileqq.search.searchdetail.eventbus;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/eventbus/QSearchPostEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", AdMetricTag.EVENT_NAME, "", "eventData", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getEventData", "()Lorg/json/JSONObject;", "getEventName", "()Ljava/lang/String;", "toString", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class QSearchPostEvent extends SimpleBaseEvent {

    @NotNull
    private final JSONObject eventData;

    @NotNull
    private final String eventName;

    public QSearchPostEvent(@NotNull String eventName, @NotNull JSONObject eventData) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.eventName = eventName;
        this.eventData = eventData;
    }

    @NotNull
    public final JSONObject getEventData() {
        return this.eventData;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    @NotNull
    public String toString() {
        return "QSearchPostEvent(eventName:" + this.eventName + ", eventData:" + this.eventData + ")";
    }
}
