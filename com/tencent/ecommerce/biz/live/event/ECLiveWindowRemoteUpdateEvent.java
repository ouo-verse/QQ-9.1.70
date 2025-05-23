package com.tencent.ecommerce.biz.live.event;

import com.tencent.ecommerce.biz.live.ECLiveEvent;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.repo.live.LiveProduct;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B=\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/live/event/ECLiveWindowRemoteUpdateEvent;", "Lcom/tencent/ecommerce/biz/live/event/ECLiveWindowUpdateEvent;", "", "event", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", "", "mediaProductId", "liveUserId", "liveRoomId", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "<init>", "(ILcom/tencent/ecommerce/biz/live/LiveTabId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/repo/live/q;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowRemoteUpdateEvent extends ECLiveWindowUpdateEvent {
    public ECLiveWindowRemoteUpdateEvent(@ECLiveEvent int i3, LiveTabId liveTabId, String str, String str2, String str3, LiveProduct liveProduct) {
        super(i3, liveTabId, str, str2, str3, liveProduct);
    }
}
