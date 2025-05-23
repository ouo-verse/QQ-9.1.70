package ci0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lci0/i;", "", "Lcom/tencent/ecommerce/base/eventbus/EVENT;", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "mediaProductId", "b", "sellingPointTxt", "c", "I", "positionInList", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: ci0.i, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ECSetSellingPointFinishEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String mediaProductId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String sellingPointTxt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int positionInList;

    public ECSetSellingPointFinishEvent(String str, String str2, int i3) {
        this.mediaProductId = str;
        this.sellingPointTxt = str2;
        this.positionInList = i3;
    }

    public int hashCode() {
        String str = this.mediaProductId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sellingPointTxt;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.positionInList;
    }

    public String toString() {
        return "ECSetSellingPointFinishEvent(mediaProductId=" + this.mediaProductId + ", sellingPointTxt=" + this.sellingPointTxt + ", positionInList=" + this.positionInList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECSetSellingPointFinishEvent)) {
            return false;
        }
        ECSetSellingPointFinishEvent eCSetSellingPointFinishEvent = (ECSetSellingPointFinishEvent) other;
        return Intrinsics.areEqual(this.mediaProductId, eCSetSellingPointFinishEvent.mediaProductId) && Intrinsics.areEqual(this.sellingPointTxt, eCSetSellingPointFinishEvent.sellingPointTxt) && this.positionInList == eCSetSellingPointFinishEvent.positionInList;
    }
}
