package com.tencent.biz.pubaccount.weishi.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSHomePagerChangeEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final class WSHomePagerChangeEvent extends WSSimpleBaseEvent {
    private final String id;

    public WSHomePagerChangeEvent(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
    }

    public final String getId() {
        return this.id;
    }
}
