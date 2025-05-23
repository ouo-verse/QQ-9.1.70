package ci0;

import com.tencent.ecommerce.biz.live.LiveTabId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lci0/a;", "", "Lcom/tencent/ecommerce/base/eventbus/EVENT;", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "a", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "()Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", "<init>", "(Lcom/tencent/ecommerce/biz/live/LiveTabId;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: ci0.a, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ECLiveWindowAddEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final LiveTabId tabId;

    public ECLiveWindowAddEvent(LiveTabId liveTabId) {
        this.tabId = liveTabId;
    }

    /* renamed from: a, reason: from getter */
    public final LiveTabId getTabId() {
        return this.tabId;
    }

    public int hashCode() {
        LiveTabId liveTabId = this.tabId;
        if (liveTabId != null) {
            return liveTabId.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ECLiveWindowAddEvent(tabId=" + this.tabId + ")";
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ECLiveWindowAddEvent) && Intrinsics.areEqual(this.tabId, ((ECLiveWindowAddEvent) other).tabId);
        }
        return true;
    }
}
