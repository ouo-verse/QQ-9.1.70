package com.tencent.biz.pubaccount.weishi.event;

import UserGrowth.stSimpleMetaPerson;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSRedDotPersonEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "person", "LUserGrowth/stSimpleMetaPerson;", "(LUserGrowth/stSimpleMetaPerson;)V", "getPerson", "()LUserGrowth/stSimpleMetaPerson;", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final class WSRedDotPersonEvent extends WSSimpleBaseEvent {
    private final stSimpleMetaPerson person;

    public WSRedDotPersonEvent(stSimpleMetaPerson stsimplemetaperson) {
        this.person = stsimplemetaperson;
    }

    public final stSimpleMetaPerson getPerson() {
        return this.person;
    }
}
