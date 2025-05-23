package com.tencent.mobileqq.zplan.web.impl;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/impl/JsbL2NEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", AdMetricTag.EVENT_NAME, "", "params", "(Ljava/lang/String;Ljava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "getParams", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final /* data */ class JsbL2NEvent extends SimpleBaseEvent {
    private final String eventName;
    private final String params;

    public JsbL2NEvent(String eventName, String params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        this.eventName = eventName;
        this.params = params;
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    public final JsbL2NEvent copy(String eventName, String params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        return new JsbL2NEvent(eventName, params);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final String getParams() {
        return this.params;
    }

    public int hashCode() {
        return (this.eventName.hashCode() * 31) + this.params.hashCode();
    }

    public String toString() {
        return "JsbL2NEvent(eventName=" + this.eventName + ", params=" + this.params + ")";
    }

    public static /* synthetic */ JsbL2NEvent copy$default(JsbL2NEvent jsbL2NEvent, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = jsbL2NEvent.eventName;
        }
        if ((i3 & 2) != 0) {
            str2 = jsbL2NEvent.params;
        }
        return jsbL2NEvent.copy(str, str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JsbL2NEvent)) {
            return false;
        }
        JsbL2NEvent jsbL2NEvent = (JsbL2NEvent) other;
        return Intrinsics.areEqual(this.eventName, jsbL2NEvent.eventName) && Intrinsics.areEqual(this.params, jsbL2NEvent.params);
    }
}
