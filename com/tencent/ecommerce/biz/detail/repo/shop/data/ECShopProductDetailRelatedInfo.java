package com.tencent.ecommerce.biz.detail.repo.shop.data;

import com.tencent.ark.ark;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "productID", "Lorg/json/JSONObject;", "b", "Lorg/json/JSONObject;", "infoData", "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.detail.repo.shop.data.g, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShopProductDetailRelatedInfo {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String productID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final JSONObject infoData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/g$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/g;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.detail.repo.shop.data.g$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECShopProductDetailRelatedInfo a(JSONObject json) {
            String optString;
            JSONObject optJSONObject = json.optJSONObject("recom_card");
            String str = "";
            if (optJSONObject != null && (optString = optJSONObject.optString("spu_id", "")) != null) {
                str = optString;
            }
            return new ECShopProductDetailRelatedInfo(str, json);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECShopProductDetailRelatedInfo(String str, JSONObject jSONObject) {
        this.productID = str;
        this.infoData = jSONObject;
    }

    public int hashCode() {
        String str = this.productID;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        JSONObject jSONObject = this.infoData;
        return hashCode + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "ECShopProductDetailRelatedInfo(productID=" + this.productID + ", infoData=" + this.infoData + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShopProductDetailRelatedInfo)) {
            return false;
        }
        ECShopProductDetailRelatedInfo eCShopProductDetailRelatedInfo = (ECShopProductDetailRelatedInfo) other;
        return Intrinsics.areEqual(this.productID, eCShopProductDetailRelatedInfo.productID) && Intrinsics.areEqual(this.infoData, eCShopProductDetailRelatedInfo.infoData);
    }
}
