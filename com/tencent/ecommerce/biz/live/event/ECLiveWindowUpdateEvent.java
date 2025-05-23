package com.tencent.ecommerce.biz.live.event;

import com.tencent.ecommerce.biz.live.ECLiveEvent;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.repo.live.LiveProduct;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00060\u0001j\u0002`\u0002B=\u0012\b\b\u0001\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/live/event/ECLiveWindowUpdateEvent;", "", "Lcom/tencent/ecommerce/base/eventbus/EVENT;", "other", "", "equals", "", "hashCode", "", "toString", "event", "I", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "mediaProductId", "Ljava/lang/String;", "liveUserId", "liveRoomId", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "Lcom/tencent/ecommerce/repo/live/q;", "getLiveProduct", "()Lcom/tencent/ecommerce/repo/live/q;", "<init>", "(ILcom/tencent/ecommerce/biz/live/LiveTabId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/repo/live/q;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class ECLiveWindowUpdateEvent {
    public final int event;
    private final LiveProduct liveProduct;
    public final String liveRoomId;
    public final String liveUserId;
    public final String mediaProductId;
    public final LiveTabId tabId;

    public ECLiveWindowUpdateEvent(@ECLiveEvent int i3, LiveTabId liveTabId, String str, String str2, String str3, LiveProduct liveProduct) {
        this.event = i3;
        this.tabId = liveTabId;
        this.mediaProductId = str;
        this.liveUserId = str2;
        this.liveRoomId = str3;
        this.liveProduct = liveProduct;
    }

    public final LiveProduct getLiveProduct() {
        return this.liveProduct;
    }

    public int hashCode() {
        int hashCode = ((this.event * 31) + this.tabId.hashCode()) * 31;
        String str = this.mediaProductId;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.liveUserId.hashCode()) * 31) + this.liveRoomId.hashCode()) * 31;
        LiveProduct liveProduct = this.liveProduct;
        return hashCode2 + (liveProduct != null ? liveProduct.hashCode() : 0);
    }

    public String toString() {
        return getClass().getSimpleName() + "(event=" + this.event + ", tabId=" + this.tabId + ", mediaProductId=" + this.mediaProductId + ", liveUserId='" + this.liveUserId + "', liveRoomId='" + this.liveRoomId + "', liveProduct=" + this.liveProduct + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECLiveWindowUpdateEvent)) {
            return false;
        }
        ECLiveWindowUpdateEvent eCLiveWindowUpdateEvent = (ECLiveWindowUpdateEvent) other;
        return (this.event != eCLiveWindowUpdateEvent.event || this.tabId != eCLiveWindowUpdateEvent.tabId || (Intrinsics.areEqual(this.mediaProductId, eCLiveWindowUpdateEvent.mediaProductId) ^ true) || (Intrinsics.areEqual(this.liveUserId, eCLiveWindowUpdateEvent.liveUserId) ^ true) || (Intrinsics.areEqual(this.liveRoomId, eCLiveWindowUpdateEvent.liveRoomId) ^ true) || (Intrinsics.areEqual(this.liveProduct, eCLiveWindowUpdateEvent.liveProduct) ^ true)) ? false : true;
    }
}
