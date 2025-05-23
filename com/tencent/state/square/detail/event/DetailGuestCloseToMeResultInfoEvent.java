package com.tencent.state.square.detail.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.state.square.friendsetting.PlaceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/detail/event/DetailGuestCloseToMeResultInfoEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "placeInfo", "Lcom/tencent/state/square/friendsetting/PlaceInfo;", "(Lcom/tencent/state/square/friendsetting/PlaceInfo;)V", "getPlaceInfo", "()Lcom/tencent/state/square/friendsetting/PlaceInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailGuestCloseToMeResultInfoEvent extends SimpleBaseEvent {
    private final PlaceInfo placeInfo;

    public DetailGuestCloseToMeResultInfoEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final PlaceInfo getPlaceInfo() {
        return this.placeInfo;
    }

    public DetailGuestCloseToMeResultInfoEvent(PlaceInfo placeInfo) {
        this.placeInfo = placeInfo;
    }

    public /* synthetic */ DetailGuestCloseToMeResultInfoEvent(PlaceInfo placeInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : placeInfo);
    }
}
