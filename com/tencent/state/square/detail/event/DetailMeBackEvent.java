package com.tencent.state.square.detail.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.state.square.data.AvatarLocationInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/detail/event/DetailMeBackEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "locationInfo", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "publish", "", "(Lcom/tencent/state/square/data/AvatarLocationInfo;Z)V", "getLocationInfo", "()Lcom/tencent/state/square/data/AvatarLocationInfo;", "getPublish", "()Z", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailMeBackEvent extends SimpleBaseEvent {
    private final AvatarLocationInfo locationInfo;
    private final boolean publish;

    public DetailMeBackEvent(AvatarLocationInfo locationInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
        this.locationInfo = locationInfo;
        this.publish = z16;
    }

    public final AvatarLocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    public final boolean getPublish() {
        return this.publish;
    }

    public /* synthetic */ DetailMeBackEvent(AvatarLocationInfo avatarLocationInfo, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(avatarLocationInfo, (i3 & 2) != 0 ? false : z16);
    }
}
