package ci0;

import com.tencent.ecommerce.biz.live.LiveTabId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lci0/d;", "", "Lcom/tencent/ecommerce/base/eventbus/EVENT;", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "a", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", "b", "Z", "()Z", "success", "<init>", "(Lcom/tencent/ecommerce/biz/live/LiveTabId;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: ci0.d, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ECLiveWindowFirstLoadEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final LiveTabId tabId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean success;

    public ECLiveWindowFirstLoadEvent(LiveTabId liveTabId, boolean z16) {
        this.tabId = liveTabId;
        this.success = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        LiveTabId liveTabId = this.tabId;
        int hashCode = (liveTabId != null ? liveTabId.hashCode() : 0) * 31;
        boolean z16 = this.success;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "ECLiveWindowFirstLoadEvent(tabId=" + this.tabId + ", success=" + this.success + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECLiveWindowFirstLoadEvent)) {
            return false;
        }
        ECLiveWindowFirstLoadEvent eCLiveWindowFirstLoadEvent = (ECLiveWindowFirstLoadEvent) other;
        return Intrinsics.areEqual(this.tabId, eCLiveWindowFirstLoadEvent.tabId) && this.success == eCLiveWindowFirstLoadEvent.success;
    }
}
