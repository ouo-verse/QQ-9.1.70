package com.tencent.mobileqq.matchfriend.reborn.kuikly;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/kuikly/QQStrangerKuiklyEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", AdMetricTag.EVENT_NAME, "", "data", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getData", "()Lorg/json/JSONObject;", "getEventName", "()Ljava/lang/String;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerKuiklyEvent extends SimpleBaseEvent {
    private final JSONObject data;
    private final String eventName;

    public QQStrangerKuiklyEvent(String eventName, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
        this.data = jSONObject;
    }

    public final JSONObject getData() {
        return this.data;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public /* synthetic */ QQStrangerKuiklyEvent(String str, JSONObject jSONObject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : jSONObject);
    }
}
