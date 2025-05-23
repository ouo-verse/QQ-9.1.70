package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u00c6\u0003J+\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/event/QQStrangerSquareDTReportClickEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "elementId", "", "params", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getElementId", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerSquareDTReportClickEvent extends SimpleBaseEvent {
    private final String elementId;
    private final Map<String, String> params;

    public /* synthetic */ QQStrangerSquareDTReportClickEvent(String str, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getElementId() {
        return this.elementId;
    }

    public final Map<String, String> component2() {
        return this.params;
    }

    public final QQStrangerSquareDTReportClickEvent copy(String elementId, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        return new QQStrangerSquareDTReportClickEvent(elementId, params);
    }

    public final String getElementId() {
        return this.elementId;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public int hashCode() {
        int hashCode = this.elementId.hashCode() * 31;
        Map<String, String> map = this.params;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "QQStrangerSquareDTReportClickEvent(elementId=" + this.elementId + ", params=" + this.params + ")";
    }

    public QQStrangerSquareDTReportClickEvent(String elementId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        this.elementId = elementId;
        this.params = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QQStrangerSquareDTReportClickEvent copy$default(QQStrangerSquareDTReportClickEvent qQStrangerSquareDTReportClickEvent, String str, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = qQStrangerSquareDTReportClickEvent.elementId;
        }
        if ((i3 & 2) != 0) {
            map = qQStrangerSquareDTReportClickEvent.params;
        }
        return qQStrangerSquareDTReportClickEvent.copy(str, map);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerSquareDTReportClickEvent)) {
            return false;
        }
        QQStrangerSquareDTReportClickEvent qQStrangerSquareDTReportClickEvent = (QQStrangerSquareDTReportClickEvent) other;
        return Intrinsics.areEqual(this.elementId, qQStrangerSquareDTReportClickEvent.elementId) && Intrinsics.areEqual(this.params, qQStrangerSquareDTReportClickEvent.params);
    }
}
