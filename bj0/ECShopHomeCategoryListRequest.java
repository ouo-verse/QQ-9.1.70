package bj0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lbj0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "shopId", "b", "Z", "isSelect", "c", "isDistributor", "d", "I", "()I", "source", "<init>", "(Ljava/lang/String;ZZI)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: bj0.a, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ECShopHomeCategoryListRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shopId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isSelect;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isDistributor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int source;

    public ECShopHomeCategoryListRequest(String str, boolean z16, boolean z17, int i3) {
        this.shopId = str;
        this.isSelect = z16;
        this.isDistributor = z17;
        this.source = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.shopId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z16 = this.isSelect;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        boolean z17 = this.isDistributor;
        return ((i16 + (z17 ? 1 : z17 ? 1 : 0)) * 31) + this.source;
    }

    public String toString() {
        return "ECShopHomeCategoryListRequest(shopId=" + this.shopId + ", isSelect=" + this.isSelect + ", isDistributor=" + this.isDistributor + ", source=" + this.source + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShopHomeCategoryListRequest)) {
            return false;
        }
        ECShopHomeCategoryListRequest eCShopHomeCategoryListRequest = (ECShopHomeCategoryListRequest) other;
        return Intrinsics.areEqual(this.shopId, eCShopHomeCategoryListRequest.shopId) && this.isSelect == eCShopHomeCategoryListRequest.isSelect && this.isDistributor == eCShopHomeCategoryListRequest.isDistributor && this.source == eCShopHomeCategoryListRequest.source;
    }
}
