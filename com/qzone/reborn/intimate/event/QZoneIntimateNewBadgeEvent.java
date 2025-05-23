package com.qzone.reborn.intimate.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/intimate/event/QZoneIntimateNewBadgeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "spaceId", "", "(Ljava/lang/String;)V", "getSpaceId", "()Ljava/lang/String;", "setSpaceId", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateNewBadgeEvent extends SimpleBaseEvent {
    private String spaceId;

    public QZoneIntimateNewBadgeEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final void setSpaceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public /* synthetic */ QZoneIntimateNewBadgeEvent(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }

    public QZoneIntimateNewBadgeEvent(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        this.spaceId = spaceId;
    }
}
