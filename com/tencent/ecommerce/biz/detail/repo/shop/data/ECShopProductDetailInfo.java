package com.tencent.ecommerce.biz.detail.repo.shop.data;

import com.tencent.ark.ark;
import com.tencent.ecommerce.biz.detail.ProductSaleStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\tB1\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\t\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "productID", "b", "I", "bizType", "c", "status", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", "infoData", "e", "()Ljava/lang/String;", "shopId", "<init>", "(Ljava/lang/String;IILorg/json/JSONObject;Ljava/lang/String;)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.detail.repo.shop.data.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShopProductDetailInfo {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String productID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int bizType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int status;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final JSONObject infoData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String shopId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.detail.repo.shop.data.c$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECShopProductDetailInfo a(JSONObject json) {
            String optString;
            String optString2 = json.optString("spu_id", "");
            int optInt = json.optInt("biz_type", 0);
            int optInt2 = json.optInt("status", 0);
            JSONObject optJSONObject = json.optJSONObject("shop");
            return new ECShopProductDetailInfo(optString2, optInt, optInt2, json, (optJSONObject == null || (optString = optJSONObject.optString("id", "")) == null) ? "" : optString);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECShopProductDetailInfo(String str, int i3, @ProductSaleStatus int i16, JSONObject jSONObject, String str2) {
        this.productID = str;
        this.bizType = i3;
        this.status = i16;
        this.infoData = jSONObject;
        this.shopId = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getShopId() {
        return this.shopId;
    }

    public int hashCode() {
        String str = this.productID;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.bizType) * 31) + this.status) * 31;
        JSONObject jSONObject = this.infoData;
        int hashCode2 = (hashCode + (jSONObject != null ? jSONObject.hashCode() : 0)) * 31;
        String str2 = this.shopId;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ECShopProductDetailInfo(productID=" + this.productID + ", bizType=" + this.bizType + ", status=" + this.status + ", infoData=" + this.infoData + ", shopId=" + this.shopId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShopProductDetailInfo)) {
            return false;
        }
        ECShopProductDetailInfo eCShopProductDetailInfo = (ECShopProductDetailInfo) other;
        return Intrinsics.areEqual(this.productID, eCShopProductDetailInfo.productID) && this.bizType == eCShopProductDetailInfo.bizType && this.status == eCShopProductDetailInfo.status && Intrinsics.areEqual(this.infoData, eCShopProductDetailInfo.infoData) && Intrinsics.areEqual(this.shopId, eCShopProductDetailInfo.shopId);
    }
}
