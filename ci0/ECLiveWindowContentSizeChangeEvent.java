package ci0;

import com.tencent.ecommerce.biz.live.LiveTabId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lci0/b;", "", "Lcom/tencent/ecommerce/base/eventbus/EVENT;", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "a", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", "b", "I", "()I", "listSize", "<init>", "(Lcom/tencent/ecommerce/biz/live/LiveTabId;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: ci0.b, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ECLiveWindowContentSizeChangeEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final LiveTabId tabId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int listSize;

    public ECLiveWindowContentSizeChangeEvent(LiveTabId liveTabId, int i3) {
        this.tabId = liveTabId;
        this.listSize = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getListSize() {
        return this.listSize;
    }

    public int hashCode() {
        LiveTabId liveTabId = this.tabId;
        return ((liveTabId != null ? liveTabId.hashCode() : 0) * 31) + this.listSize;
    }

    public String toString() {
        return "ECLiveWindowContentSizeChangeEvent(tabId=" + this.tabId + ", listSize=" + this.listSize + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECLiveWindowContentSizeChangeEvent)) {
            return false;
        }
        ECLiveWindowContentSizeChangeEvent eCLiveWindowContentSizeChangeEvent = (ECLiveWindowContentSizeChangeEvent) other;
        return Intrinsics.areEqual(this.tabId, eCLiveWindowContentSizeChangeEvent.tabId) && this.listSize == eCLiveWindowContentSizeChangeEvent.listSize;
    }
}
