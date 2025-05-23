package bj0;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.ecommerce.biz.shophome.model.ECOrderByTabInfo;
import com.tencent.ecommerce.biz.shophome.model.ECShopCategoryInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\nR\u0014\u0010\u001c\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0014\u0010\u001e\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000fR\u0014\u0010!\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b\t\u0010#\u00a8\u0006'"}, d2 = {"Lbj0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "shopId", "b", "cookie", "c", "Z", FeedManager.LOAD_MORE, "Lcom/tencent/ecommerce/biz/shophome/model/b;", "d", "Lcom/tencent/ecommerce/biz/shophome/model/b;", "category", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "e", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "orderByInfo", "f", "query", "g", "isSelect", h.F, "isDistributor", "i", "I", "source", "j", "()Ljava/lang/String;", "couponId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/ecommerce/biz/shophome/model/b;Lcom/tencent/ecommerce/biz/shophome/model/a;Ljava/lang/String;ZZILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: bj0.b, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ECShopHomeProductRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shopId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String cookie;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean loadMore;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECShopCategoryInfo category;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECOrderByTabInfo orderByInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String query;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isSelect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isDistributor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final int source;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final String couponId;

    public ECShopHomeProductRequest(String str, String str2, boolean z16, ECShopCategoryInfo eCShopCategoryInfo, ECOrderByTabInfo eCOrderByTabInfo, String str3, boolean z17, boolean z18, int i3, String str4) {
        this.shopId = str;
        this.cookie = str2;
        this.loadMore = z16;
        this.category = eCShopCategoryInfo;
        this.orderByInfo = eCOrderByTabInfo;
        this.query = str3;
        this.isSelect = z17;
        this.isDistributor = z18;
        this.source = i3;
        this.couponId = str4;
    }

    /* renamed from: a, reason: from getter */
    public final String getCouponId() {
        return this.couponId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.shopId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cookie;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.loadMore;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        ECShopCategoryInfo eCShopCategoryInfo = this.category;
        int hashCode3 = (i16 + (eCShopCategoryInfo != null ? eCShopCategoryInfo.hashCode() : 0)) * 31;
        ECOrderByTabInfo eCOrderByTabInfo = this.orderByInfo;
        int hashCode4 = (hashCode3 + (eCOrderByTabInfo != null ? eCOrderByTabInfo.hashCode() : 0)) * 31;
        String str3 = this.query;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z17 = this.isSelect;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (hashCode5 + i17) * 31;
        boolean z18 = this.isDistributor;
        int i19 = (((i18 + (z18 ? 1 : z18 ? 1 : 0)) * 31) + this.source) * 31;
        String str4 = this.couponId;
        return i19 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ECShopHomeProductRequest(shopId=" + this.shopId + ", cookie=" + this.cookie + ", loadMore=" + this.loadMore + ", category=" + this.category + ", orderByInfo=" + this.orderByInfo + ", query=" + this.query + ", isSelect=" + this.isSelect + ", isDistributor=" + this.isDistributor + ", source=" + this.source + ", couponId=" + this.couponId + ")";
    }

    public /* synthetic */ ECShopHomeProductRequest(String str, String str2, boolean z16, ECShopCategoryInfo eCShopCategoryInfo, ECOrderByTabInfo eCOrderByTabInfo, String str3, boolean z17, boolean z18, int i3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? false : z16, (i16 & 8) != 0 ? null : eCShopCategoryInfo, (i16 & 16) != 0 ? null : eCOrderByTabInfo, (i16 & 32) != 0 ? "" : str3, z17, (i16 & 128) != 0 ? false : z18, (i16 & 256) != 0 ? 0 : i3, (i16 & 512) != 0 ? "" : str4);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShopHomeProductRequest)) {
            return false;
        }
        ECShopHomeProductRequest eCShopHomeProductRequest = (ECShopHomeProductRequest) other;
        return Intrinsics.areEqual(this.shopId, eCShopHomeProductRequest.shopId) && Intrinsics.areEqual(this.cookie, eCShopHomeProductRequest.cookie) && this.loadMore == eCShopHomeProductRequest.loadMore && Intrinsics.areEqual(this.category, eCShopHomeProductRequest.category) && Intrinsics.areEqual(this.orderByInfo, eCShopHomeProductRequest.orderByInfo) && Intrinsics.areEqual(this.query, eCShopHomeProductRequest.query) && this.isSelect == eCShopHomeProductRequest.isSelect && this.isDistributor == eCShopHomeProductRequest.isDistributor && this.source == eCShopHomeProductRequest.source && Intrinsics.areEqual(this.couponId, eCShopHomeProductRequest.couponId);
    }
}
