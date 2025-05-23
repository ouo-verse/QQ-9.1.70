package com.tencent.ecommerce.biz.showwindow.repo.window;

import ck0.Category;
import ck0.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020%0$\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0$\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010$\u0012\b\b\u0002\u00106\u001a\u00020\u0004\u0012\b\b\u0002\u00108\u001a\u00020\u0004\u0012\b\b\u0002\u0010;\u001a\u00020\u0002\u00a2\u0006\u0004\b<\u0010=J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0011\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010+\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\u001d\u0010(\"\u0004\b)\u0010*R(\u00100\u001a\b\u0012\u0004\u0012\u00020,0$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010(\"\u0004\b/\u0010*R*\u00103\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010'\u001a\u0004\b\n\u0010(\"\u0004\b2\u0010*R\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0012\u001a\u0004\b-\u0010\u0014\"\u0004\b5\u0010\u0016R\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b&\u0010\u0014\"\u0004\b7\u0010\u0016R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u0018\u001a\u0004\b4\u0010\u0019\"\u0004\b:\u0010\u001b\u00a8\u0006>"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/json/JSONObject;", "a", "Lorg/json/JSONObject;", "c", "()Lorg/json/JSONObject;", "setDataJson", "(Lorg/json/JSONObject;)V", "dataJson", "b", "I", "g", "()I", "setTotal", "(I)V", "total", "Ljava/lang/String;", "()Ljava/lang/String;", "setCookie", "(Ljava/lang/String;)V", "cookie", "d", "Z", "i", "()Z", "setEnd", "(Z)V", "isEnd", "", "Lck0/c;", "e", "Ljava/util/List;", "()Ljava/util/List;", "setProductList", "(Ljava/util/List;)V", "productList", "Lck0/b;", "f", "getCategoryList", "setCategoryList", "categoryList", "Lck0/a;", "setBannerList", "bannerList", tl.h.F, "setSelectedProductsLimit", "selectedProductsLimit", "setSelectedProductsCount", "selectedProductsCount", "j", "setWindowTitle", "windowTitle", "<init>", "(Lorg/json/JSONObject;ILjava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/util/List;IILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.showwindow.repo.window.j, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class GetProductListRsp {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private JSONObject dataJson;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int total;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String cookie;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isEnd;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private List<Product> productList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private List<Category> categoryList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private List<ck0.a> bannerList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int selectedProductsLimit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int selectedProductsCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private String windowTitle;

    public GetProductListRsp(JSONObject jSONObject, int i3, String str, boolean z16, List<Product> list, List<Category> list2, List<ck0.a> list3, int i16, int i17, String str2) {
        this.dataJson = jSONObject;
        this.total = i3;
        this.cookie = str;
        this.isEnd = z16;
        this.productList = list;
        this.categoryList = list2;
        this.bannerList = list3;
        this.selectedProductsLimit = i16;
        this.selectedProductsCount = i17;
        this.windowTitle = str2;
    }

    public final List<ck0.a> a() {
        return this.bannerList;
    }

    /* renamed from: b, reason: from getter */
    public final String getCookie() {
        return this.cookie;
    }

    /* renamed from: c, reason: from getter */
    public final JSONObject getDataJson() {
        return this.dataJson;
    }

    public final List<Product> d() {
        return this.productList;
    }

    /* renamed from: e, reason: from getter */
    public final int getSelectedProductsCount() {
        return this.selectedProductsCount;
    }

    /* renamed from: f, reason: from getter */
    public final int getSelectedProductsLimit() {
        return this.selectedProductsLimit;
    }

    /* renamed from: g, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* renamed from: h, reason: from getter */
    public final String getWindowTitle() {
        return this.windowTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        JSONObject jSONObject = this.dataJson;
        int hashCode = (((jSONObject != null ? jSONObject.hashCode() : 0) * 31) + this.total) * 31;
        String str = this.cookie;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z16 = this.isEnd;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        List<Product> list = this.productList;
        int hashCode3 = (i16 + (list != null ? list.hashCode() : 0)) * 31;
        List<Category> list2 = this.categoryList;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ck0.a> list3 = this.bannerList;
        int hashCode5 = (((((hashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31) + this.selectedProductsLimit) * 31) + this.selectedProductsCount) * 31;
        String str2 = this.windowTitle;
        return hashCode5 + (str2 != null ? str2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    public String toString() {
        return "GetProductListRsp(dataJson=" + this.dataJson + ", total=" + this.total + ", cookie=" + this.cookie + ", isEnd=" + this.isEnd + ", productList=" + this.productList + ", categoryList=" + this.categoryList + ", bannerList=" + this.bannerList + ", selectedProductsLimit=" + this.selectedProductsLimit + ", selectedProductsCount=" + this.selectedProductsCount + ", windowTitle=" + this.windowTitle + ")";
    }

    public /* synthetic */ GetProductListRsp(JSONObject jSONObject, int i3, String str, boolean z16, List list, List list2, List list3, int i16, int i17, String str2, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, (i18 & 2) != 0 ? 0 : i3, (i18 & 4) != 0 ? "" : str, (i18 & 8) != 0 ? false : z16, list, list2, (i18 & 64) != 0 ? null : list3, (i18 & 128) != 0 ? -1 : i16, (i18 & 256) != 0 ? 0 : i17, (i18 & 512) != 0 ? "" : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetProductListRsp)) {
            return false;
        }
        GetProductListRsp getProductListRsp = (GetProductListRsp) other;
        return Intrinsics.areEqual(this.dataJson, getProductListRsp.dataJson) && this.total == getProductListRsp.total && Intrinsics.areEqual(this.cookie, getProductListRsp.cookie) && this.isEnd == getProductListRsp.isEnd && Intrinsics.areEqual(this.productList, getProductListRsp.productList) && Intrinsics.areEqual(this.categoryList, getProductListRsp.categoryList) && Intrinsics.areEqual(this.bannerList, getProductListRsp.bannerList) && this.selectedProductsLimit == getProductListRsp.selectedProductsLimit && this.selectedProductsCount == getProductListRsp.selectedProductsCount && Intrinsics.areEqual(this.windowTitle, getProductListRsp.windowTitle);
    }
}
