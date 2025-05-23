package com.tencent.ecommerce.biz.detail.repo.shop.data;

import com.tencent.ark.ark;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "productID", "", "b", "J", "stockNum", "Lorg/json/JSONObject;", "c", "Lorg/json/JSONObject;", "infoData", "<init>", "(Ljava/lang/String;JLorg/json/JSONObject;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.detail.repo.shop.data.j, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShopProductDetailSkuStockInfo {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String productID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final long stockNum;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final JSONObject infoData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/j$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/j;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.detail.repo.shop.data.j$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECShopProductDetailSkuStockInfo a(JSONObject json) {
            return new ECShopProductDetailSkuStockInfo(json.optString("spu_id", ""), json.optLong("stock_num", 0L), json);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECShopProductDetailSkuStockInfo(String str, long j3, JSONObject jSONObject) {
        this.productID = str;
        this.stockNum = j3;
        this.infoData = jSONObject;
    }

    public int hashCode() {
        String str = this.productID;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.stockNum)) * 31;
        JSONObject jSONObject = this.infoData;
        return hashCode + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "ECShopProductDetailSkuStockInfo(productID=" + this.productID + ", stockNum=" + this.stockNum + ", infoData=" + this.infoData + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShopProductDetailSkuStockInfo)) {
            return false;
        }
        ECShopProductDetailSkuStockInfo eCShopProductDetailSkuStockInfo = (ECShopProductDetailSkuStockInfo) other;
        return Intrinsics.areEqual(this.productID, eCShopProductDetailSkuStockInfo.productID) && this.stockNum == eCShopProductDetailSkuStockInfo.stockNum && Intrinsics.areEqual(this.infoData, eCShopProductDetailSkuStockInfo.infoData);
    }
}
