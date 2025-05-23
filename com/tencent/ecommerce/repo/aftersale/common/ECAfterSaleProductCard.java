package com.tencent.ecommerce.repo.aftersale.common;

import com.tencent.ecommerce.biz.util.j;
import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleShopInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$OrderFulfilDetail;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ServiceItem;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$SpecItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001+Bo\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0018\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\t\u0010 R\u0014\u0010#\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\nR\u0014\u0010%\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\nR\u0014\u0010'\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\n\u00a8\u0006,"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "cover", "b", "productTitle", "c", "I", "productNumber", "d", "productPrice", "e", "specification", "Lcom/tencent/ecommerce/repo/aftersale/common/b;", "f", "Lcom/tencent/ecommerce/repo/aftersale/common/b;", "shopInfo", "g", "Z", "hasDivider", "", "Lcom/tencent/ecommerce/repo/aftersale/common/a;", h.F, "Ljava/util/List;", "()Ljava/util/List;", "serviceInfos", "i", "firstCategoryId", "j", "spuId", "k", "skuId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/repo/aftersale/common/b;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "l", "Companion", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class ECAfterSaleProductCard {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String cover;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String productTitle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int productNumber;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String productPrice;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String specification;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECAfterSaleShopInfo shopInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean hasDivider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ECAfterSaleServiceInfo> serviceInfos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final String firstCategoryId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final String spuId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    public final String skuId;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard$Companion;", "", "Lorg/json/JSONObject;", "orderCardJson", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "b", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$OrderFulfilDetail;", "orderInfo", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ECAfterSaleProductCard a(ECQshopSampleSvr$OrderFulfilDetail orderInfo) {
            String joinToString$default;
            int collectionSizeOrDefault;
            String str = orderInfo.product.spu_id.get();
            String str2 = orderInfo.product.sku_id.get();
            String str3 = orderInfo.product.pic_list.get(0).url.get();
            String str4 = orderInfo.product.title.get();
            int i3 = orderInfo.product.count.get();
            String a16 = j.f104870a.a(orderInfo.product.price.get());
            boolean z16 = false;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(orderInfo.product.spec_info.items.get(), "; ", null, null, 0, null, new Function1<ECSampleData$SpecItem, CharSequence>() { // from class: com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleProductCard$Companion$from$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(ECSampleData$SpecItem eCSampleData$SpecItem) {
                    return eCSampleData$SpecItem.value.get();
                }
            }, 30, null);
            List<ECSampleData$ServiceItem> list = orderInfo.product.service.items.get();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ECAfterSaleServiceInfo.INSTANCE.a((ECSampleData$ServiceItem) it.next()));
            }
            return new ECAfterSaleProductCard(str3, str4, i3, a16, joinToString$default, ECAfterSaleShopInfo.INSTANCE.a(orderInfo.shop), z16, arrayList, orderInfo.product.first_cat_id.get(), str, str2, 64, null);
        }

        public final ECAfterSaleProductCard b(JSONObject orderCardJson) {
            String optString = orderCardJson.optString("cover");
            String optString2 = orderCardJson.optString("product_title");
            int optInt = orderCardJson.optInt("product_num");
            String optString3 = orderCardJson.optString("price");
            String optString4 = orderCardJson.optString("specification");
            ECAfterSaleShopInfo.Companion companion = ECAfterSaleShopInfo.INSTANCE;
            JSONObject optJSONObject = orderCardJson.optJSONObject("shop_info");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return new ECAfterSaleProductCard(optString, optString2, optInt, optString3, optString4, companion.b(optJSONObject), false, null, null, null, null, 1984, null);
        }
    }

    public ECAfterSaleProductCard(String str, String str2, int i3, String str3, String str4, ECAfterSaleShopInfo eCAfterSaleShopInfo, boolean z16, List<ECAfterSaleServiceInfo> list, String str5, String str6, String str7) {
        this.cover = str;
        this.productTitle = str2;
        this.productNumber = i3;
        this.productPrice = str3;
        this.specification = str4;
        this.shopInfo = eCAfterSaleShopInfo;
        this.hasDivider = z16;
        this.serviceInfos = list;
        this.firstCategoryId = str5;
        this.spuId = str6;
        this.skuId = str7;
    }

    public final List<ECAfterSaleServiceInfo> a() {
        return this.serviceInfos;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.cover;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.productTitle;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.productNumber) * 31;
        String str3 = this.productPrice;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.specification;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        ECAfterSaleShopInfo eCAfterSaleShopInfo = this.shopInfo;
        int hashCode5 = (hashCode4 + (eCAfterSaleShopInfo != null ? eCAfterSaleShopInfo.hashCode() : 0)) * 31;
        boolean z16 = this.hasDivider;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode5 + i3) * 31;
        List<ECAfterSaleServiceInfo> list = this.serviceInfos;
        int hashCode6 = (i16 + (list != null ? list.hashCode() : 0)) * 31;
        String str5 = this.firstCategoryId;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.spuId;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.skuId;
        return hashCode8 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "ECAfterSaleProductCard(cover=" + this.cover + ", productTitle=" + this.productTitle + ", productNumber=" + this.productNumber + ", productPrice=" + this.productPrice + ", specification=" + this.specification + ", shopInfo=" + this.shopInfo + ", hasDivider=" + this.hasDivider + ", serviceInfos=" + this.serviceInfos + ", firstCategoryId=" + this.firstCategoryId + ", spuId=" + this.spuId + ", skuId=" + this.skuId + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ECAfterSaleProductCard(String str, String str2, int i3, String str3, String str4, ECAfterSaleShopInfo eCAfterSaleShopInfo, boolean z16, List list, String str5, String str6, String str7, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, str3, str4, eCAfterSaleShopInfo, r9, r10, (i16 & 256) != 0 ? "" : str5, (i16 & 512) != 0 ? "" : str6, (i16 & 1024) != 0 ? "" : str7);
        List list2;
        List emptyList;
        boolean z17 = (i16 & 64) != 0 ? true : z16;
        if ((i16 & 128) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAfterSaleProductCard)) {
            return false;
        }
        ECAfterSaleProductCard eCAfterSaleProductCard = (ECAfterSaleProductCard) other;
        return Intrinsics.areEqual(this.cover, eCAfterSaleProductCard.cover) && Intrinsics.areEqual(this.productTitle, eCAfterSaleProductCard.productTitle) && this.productNumber == eCAfterSaleProductCard.productNumber && Intrinsics.areEqual(this.productPrice, eCAfterSaleProductCard.productPrice) && Intrinsics.areEqual(this.specification, eCAfterSaleProductCard.specification) && Intrinsics.areEqual(this.shopInfo, eCAfterSaleProductCard.shopInfo) && this.hasDivider == eCAfterSaleProductCard.hasDivider && Intrinsics.areEqual(this.serviceInfos, eCAfterSaleProductCard.serviceInfos) && Intrinsics.areEqual(this.firstCategoryId, eCAfterSaleProductCard.firstCategoryId) && Intrinsics.areEqual(this.spuId, eCAfterSaleProductCard.spuId) && Intrinsics.areEqual(this.skuId, eCAfterSaleProductCard.skuId);
    }
}
