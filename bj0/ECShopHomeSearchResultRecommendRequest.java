package bj0;

import com.qzone.module.feedcomponent.manage.FeedManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0014\u0010\u001a\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\t\u0010 \u00a8\u0006$"}, d2 = {"Lbj0/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "shopId", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "spuIds", "c", "I", "searchScene", "d", "searchQuery", "e", "cookie", "f", "Z", "isSelect", "g", FeedManager.LOAD_MORE, h.F, "isDistributor", "i", "()I", "source", "<init>", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;ZZZI)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: bj0.d, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ECShopHomeSearchResultRecommendRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shopId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> spuIds;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int searchScene;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String searchQuery;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String cookie;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isSelect;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean loadMore;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isDistributor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int source;

    public ECShopHomeSearchResultRecommendRequest(String str, List<String> list, int i3, String str2, String str3, boolean z16, boolean z17, boolean z18, int i16) {
        this.shopId = str;
        this.spuIds = list;
        this.searchScene = i3;
        this.searchQuery = str2;
        this.cookie = str3;
        this.isSelect = z16;
        this.loadMore = z17;
        this.isDistributor = z18;
        this.source = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    public final List<String> b() {
        return this.spuIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.shopId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.spuIds;
        int hashCode2 = (((hashCode + (list != null ? list.hashCode() : 0)) * 31) + this.searchScene) * 31;
        String str2 = this.searchQuery;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.cookie;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z16 = this.isSelect;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode4 + i3) * 31;
        boolean z17 = this.loadMore;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z18 = this.isDistributor;
        return ((i18 + (z18 ? 1 : z18 ? 1 : 0)) * 31) + this.source;
    }

    public String toString() {
        return "ECShopHomeSearchResultRecommendRequest(shopId=" + this.shopId + ", spuIds=" + this.spuIds + ", searchScene=" + this.searchScene + ", searchQuery=" + this.searchQuery + ", cookie=" + this.cookie + ", isSelect=" + this.isSelect + ", loadMore=" + this.loadMore + ", isDistributor=" + this.isDistributor + ", source=" + this.source + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShopHomeSearchResultRecommendRequest)) {
            return false;
        }
        ECShopHomeSearchResultRecommendRequest eCShopHomeSearchResultRecommendRequest = (ECShopHomeSearchResultRecommendRequest) other;
        return Intrinsics.areEqual(this.shopId, eCShopHomeSearchResultRecommendRequest.shopId) && Intrinsics.areEqual(this.spuIds, eCShopHomeSearchResultRecommendRequest.spuIds) && this.searchScene == eCShopHomeSearchResultRecommendRequest.searchScene && Intrinsics.areEqual(this.searchQuery, eCShopHomeSearchResultRecommendRequest.searchQuery) && Intrinsics.areEqual(this.cookie, eCShopHomeSearchResultRecommendRequest.cookie) && this.isSelect == eCShopHomeSearchResultRecommendRequest.isSelect && this.loadMore == eCShopHomeSearchResultRecommendRequest.loadMore && this.isDistributor == eCShopHomeSearchResultRecommendRequest.isDistributor && this.source == eCShopHomeSearchResultRecommendRequest.source;
    }
}
