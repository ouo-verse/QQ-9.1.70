package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/event/QQStrangerSquareDTReportExposureEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "elementId", "", "params", "", "enableRepeat", "", "(Ljava/lang/String;Ljava/util/Map;Z)V", "getElementId", "()Ljava/lang/String;", "getEnableRepeat", "()Z", "getParams", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerSquareDTReportExposureEvent extends SimpleBaseEvent {
    private final String elementId;
    private final boolean enableRepeat;
    private final Map<String, String> params;

    public /* synthetic */ QQStrangerSquareDTReportExposureEvent(String str, Map map, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : map, (i3 & 4) != 0 ? true : z16);
    }

    /* renamed from: component1, reason: from getter */
    public final String getElementId() {
        return this.elementId;
    }

    public final Map<String, String> component2() {
        return this.params;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnableRepeat() {
        return this.enableRepeat;
    }

    public final QQStrangerSquareDTReportExposureEvent copy(String elementId, Map<String, String> params, boolean enableRepeat) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        return new QQStrangerSquareDTReportExposureEvent(elementId, params, enableRepeat);
    }

    public final String getElementId() {
        return this.elementId;
    }

    public final boolean getEnableRepeat() {
        return this.enableRepeat;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.elementId.hashCode() * 31;
        Map<String, String> map = this.params;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        boolean z16 = this.enableRepeat;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode2 + i3;
    }

    public String toString() {
        return "QQStrangerSquareDTReportExposureEvent(elementId=" + this.elementId + ", params=" + this.params + ", enableRepeat=" + this.enableRepeat + ")";
    }

    public QQStrangerSquareDTReportExposureEvent(String elementId, Map<String, String> map, boolean z16) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        this.elementId = elementId;
        this.params = map;
        this.enableRepeat = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QQStrangerSquareDTReportExposureEvent copy$default(QQStrangerSquareDTReportExposureEvent qQStrangerSquareDTReportExposureEvent, String str, Map map, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = qQStrangerSquareDTReportExposureEvent.elementId;
        }
        if ((i3 & 2) != 0) {
            map = qQStrangerSquareDTReportExposureEvent.params;
        }
        if ((i3 & 4) != 0) {
            z16 = qQStrangerSquareDTReportExposureEvent.enableRepeat;
        }
        return qQStrangerSquareDTReportExposureEvent.copy(str, map, z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerSquareDTReportExposureEvent)) {
            return false;
        }
        QQStrangerSquareDTReportExposureEvent qQStrangerSquareDTReportExposureEvent = (QQStrangerSquareDTReportExposureEvent) other;
        return Intrinsics.areEqual(this.elementId, qQStrangerSquareDTReportExposureEvent.elementId) && Intrinsics.areEqual(this.params, qQStrangerSquareDTReportExposureEvent.params) && this.enableRepeat == qQStrangerSquareDTReportExposureEvent.enableRepeat;
    }
}
