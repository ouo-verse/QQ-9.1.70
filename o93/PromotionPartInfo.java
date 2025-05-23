package o93;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lo93/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "showPromotionPart", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "partName", "c", "partDesc", "", "Lo93/a;", "Ljava/util/List;", "()Ljava/util/List;", "promotionChannelList", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: o93.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PromotionPartInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean showPromotionPart;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String partName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String partDesc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<PromotionChannelItem> promotionChannelList;

    public PromotionPartInfo(boolean z16, @NotNull String partName, @NotNull String partDesc, @NotNull List<PromotionChannelItem> promotionChannelList) {
        Intrinsics.checkNotNullParameter(partName, "partName");
        Intrinsics.checkNotNullParameter(partDesc, "partDesc");
        Intrinsics.checkNotNullParameter(promotionChannelList, "promotionChannelList");
        this.showPromotionPart = z16;
        this.partName = partName;
        this.partDesc = partDesc;
        this.promotionChannelList = promotionChannelList;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getPartDesc() {
        return this.partDesc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPartName() {
        return this.partName;
    }

    @NotNull
    public final List<PromotionChannelItem> c() {
        return this.promotionChannelList;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getShowPromotionPart() {
        return this.showPromotionPart;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromotionPartInfo)) {
            return false;
        }
        PromotionPartInfo promotionPartInfo = (PromotionPartInfo) other;
        if (this.showPromotionPart == promotionPartInfo.showPromotionPart && Intrinsics.areEqual(this.partName, promotionPartInfo.partName) && Intrinsics.areEqual(this.partDesc, promotionPartInfo.partDesc) && Intrinsics.areEqual(this.promotionChannelList, promotionPartInfo.promotionChannelList)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.showPromotionPart;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((r06 * 31) + this.partName.hashCode()) * 31) + this.partDesc.hashCode()) * 31) + this.promotionChannelList.hashCode();
    }

    @NotNull
    public String toString() {
        return "PromotionPartInfo(showPromotionPart=" + this.showPromotionPart + ", partName=" + this.partName + ", partDesc=" + this.partDesc + ", promotionChannelList=" + this.promotionChannelList + ")";
    }
}
