package com.tencent.ecommerce.repo.aftersale.common;

import com.heytap.databaseengine.type.DeviceType;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ShopSnapshot;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\tB/\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/common/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "shopId", "b", "shopName", "c", "shopImg", "d", "()Ljava/lang/String;", DeviceType.DeviceCategory.MOBILE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.aftersale.common.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAfterSaleShopInfo {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shopId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shopName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shopImg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String mobile;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/common/b$a;", "", "Lorg/json/JSONObject;", "shopInfoJson", "Lcom/tencent/ecommerce/repo/aftersale/common/b;", "b", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr_sample_data/ECSampleData$ShopSnapshot;", "shopInfo", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.aftersale.common.b$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECAfterSaleShopInfo a(ECSampleData$ShopSnapshot shopInfo) {
            return new ECAfterSaleShopInfo(shopInfo.shop_id.get(), shopInfo.shop_title.get(), shopInfo.shop_icon.get(), shopInfo.contact_details.get());
        }

        public final ECAfterSaleShopInfo b(JSONObject shopInfoJson) {
            return new ECAfterSaleShopInfo(shopInfoJson.optString("shop_id"), shopInfoJson.optString("shop_name"), shopInfoJson.optString("shop_img"), null, 8, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECAfterSaleShopInfo() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getMobile() {
        return this.mobile;
    }

    public int hashCode() {
        String str = this.shopId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.shopName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.shopImg;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mobile;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ECAfterSaleShopInfo(shopId=" + this.shopId + ", shopName=" + this.shopName + ", shopImg=" + this.shopImg + ", mobile=" + this.mobile + ")";
    }

    public ECAfterSaleShopInfo(String str, String str2, String str3, String str4) {
        this.shopId = str;
        this.shopName = str2;
        this.shopImg = str3;
        this.mobile = str4;
    }

    public /* synthetic */ ECAfterSaleShopInfo(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAfterSaleShopInfo)) {
            return false;
        }
        ECAfterSaleShopInfo eCAfterSaleShopInfo = (ECAfterSaleShopInfo) other;
        return Intrinsics.areEqual(this.shopId, eCAfterSaleShopInfo.shopId) && Intrinsics.areEqual(this.shopName, eCAfterSaleShopInfo.shopName) && Intrinsics.areEqual(this.shopImg, eCAfterSaleShopInfo.shopImg) && Intrinsics.areEqual(this.mobile, eCAfterSaleShopInfo.mobile);
    }
}
