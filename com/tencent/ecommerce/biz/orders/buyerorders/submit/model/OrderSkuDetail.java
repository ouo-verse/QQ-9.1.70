package com.tencent.ecommerce.biz.orders.buyerorders.submit.model;

import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$PicInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ProductCart;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ServiceItem;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ShopInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$SpecItem;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$PicInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ProductSnapshot;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ServiceItem;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ShopSnapshot;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$SpecItem;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u0000 52\u00020\u0001:\u0001\u0018B\u008d\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b3\u00104J\u00ab\u0001\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u00c6\u0001J\t\u0010\u0019\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001eR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010(R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b)\u0010'\u001a\u0004\b \u0010(R\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u0011\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010\u001eR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010\u001eR\u0014\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010!R\u0014\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010!R\u0014\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "", "", "skuId", "spuId", "", "quantity", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/b;", "shop", "coverUrl", "name", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/e;", "specifications", "logisticsPolicy", "", "unitPrice", "originUnitPrice", "note", "freight", "maxQuantity", "minQuantity", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;", "productType", "a", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "c", "I", "d", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/b;", "e", "f", "g", "Ljava/util/List;", "()Ljava/util/List;", tl.h.F, "i", "J", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/b;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JJLjava/lang/String;Ljava/lang/String;IILcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;)V", "p", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.model.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class OrderSkuDetail {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String skuId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String spuId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int quantity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final OrderShop shop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String coverUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<OrderSkuSpec> specifications;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> logisticsPolicy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final long unitPrice;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final long originUnitPrice;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    public final String note;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    public final String freight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    public final int maxQuantity;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    public final int minQuantity;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    public final j productType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017JJ\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_common/ECOrderCommon$ProductCart;", "cart", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_common/ECOrderCommon$ShopInfo;", "shopInfo", "", "isFreeShipping", "", "shippingCost", "", "originUnitPrice", "skuBuyMaxNumLimits", "skuBuyMinNumLimits", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;", "productType", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "a", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr_sample_data/ECSampleData$ProductSnapshot;", "product", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr_sample_data/ECSampleData$ShopSnapshot;", "c", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.model.c$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OrderSkuDetail a(ECOrderCommon$ProductCart cart, ECOrderCommon$ShopInfo shopInfo, boolean isFreeShipping, int shippingCost, long originUnitPrice, int skuBuyMaxNumLimits, int skuBuyMinNumLimits, j productType) {
            Object firstOrNull;
            String str;
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            String sb5;
            PBStringField pBStringField;
            String str2 = cart.order_sku.sku.sku_id.get();
            String str3 = cart.order_sku.spu.spu_id.get();
            OrderShop a16 = wj0.a.a(shopInfo);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) cart.order_sku.sku.preview_pics.get());
            ECOrderCommon$PicInfo eCOrderCommon$PicInfo = (ECOrderCommon$PicInfo) firstOrNull;
            if (eCOrderCommon$PicInfo == null || (pBStringField = eCOrderCommon$PicInfo.url) == null || (str = pBStringField.get()) == null) {
                str = "";
            }
            String str4 = str;
            String str5 = cart.order_sku.spu.title.get();
            List<ECOrderCommon$SpecItem> list = cart.order_sku.sku.spec.items.get();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (ECOrderCommon$SpecItem eCOrderCommon$SpecItem : list) {
                arrayList.add(new OrderSkuSpec(eCOrderCommon$SpecItem.name.get(), eCOrderCommon$SpecItem.value.get()));
            }
            List<ECOrderCommon$ServiceItem> list2 = cart.service.items.get();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ECOrderCommon$ServiceItem) it.next()).title.get());
            }
            long j3 = cart.order_sku.sku.price.get();
            int i3 = cart.sku_num.get();
            if (isFreeShipping) {
                sb5 = "\u5305\u90ae";
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append('\u00a5');
                sb6.append(shippingCost);
                sb5 = sb6.toString();
            }
            return new OrderSkuDetail(str2, str3, i3, a16, str4, str5, arrayList, arrayList2, j3, originUnitPrice, "", sb5, skuBuyMaxNumLimits, skuBuyMinNumLimits, productType);
        }

        public final OrderSkuDetail c(ECSampleData$ProductSnapshot product, ECSampleData$ShopSnapshot shopInfo) {
            Object firstOrNull;
            String str;
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            PBStringField pBStringField;
            String str2 = product.sku_id.get();
            String str3 = product.first_cat_id.get();
            OrderShop b16 = wj0.a.b(shopInfo);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) product.pic_list.get());
            ECSampleData$PicInfo eCSampleData$PicInfo = (ECSampleData$PicInfo) firstOrNull;
            if (eCSampleData$PicInfo == null || (pBStringField = eCSampleData$PicInfo.url) == null || (str = pBStringField.get()) == null) {
                str = "";
            }
            String str4 = str;
            String str5 = product.title.get();
            List<ECSampleData$SpecItem> list = product.spec_info.items.get();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (ECSampleData$SpecItem eCSampleData$SpecItem : list) {
                arrayList.add(new OrderSkuSpec(eCSampleData$SpecItem.name.get(), eCSampleData$SpecItem.value.get()));
            }
            List<ECSampleData$ServiceItem> list2 = product.service.items.get();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ECSampleData$ServiceItem) it.next()).title.get());
            }
            return new OrderSkuDetail(str2, str3, product.count.get(), b16, str4, str5, arrayList, arrayList2, product.price.get(), product.price.get(), "", "\u5305\u90ae", 1, 0, new j.PhysicalProduct(0), 8192, null);
        }
    }

    public OrderSkuDetail(String str, String str2, int i3, OrderShop orderShop, String str3, String str4, List<OrderSkuSpec> list, List<String> list2, long j3, long j16, String str5, String str6, int i16, int i17, j jVar) {
        this.skuId = str;
        this.spuId = str2;
        this.quantity = i3;
        this.shop = orderShop;
        this.coverUrl = str3;
        this.name = str4;
        this.specifications = list;
        this.logisticsPolicy = list2;
        this.unitPrice = j3;
        this.originUnitPrice = j16;
        this.note = str5;
        this.freight = str6;
        this.maxQuantity = i16;
        this.minQuantity = i17;
        this.productType = jVar;
    }

    public final List<String> c() {
        return this.logisticsPolicy;
    }

    public final List<OrderSkuSpec> d() {
        return this.specifications;
    }

    public int hashCode() {
        String str = this.skuId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.spuId;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.quantity) * 31;
        OrderShop orderShop = this.shop;
        int hashCode3 = (hashCode2 + (orderShop != null ? orderShop.hashCode() : 0)) * 31;
        String str3 = this.coverUrl;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<OrderSkuSpec> list = this.specifications;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.logisticsPolicy;
        int hashCode7 = (((((hashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.unitPrice)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.originUnitPrice)) * 31;
        String str5 = this.note;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.freight;
        int hashCode9 = (((((hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.maxQuantity) * 31) + this.minQuantity) * 31;
        j jVar = this.productType;
        return hashCode9 + (jVar != null ? jVar.hashCode() : 0);
    }

    public String toString() {
        return "OrderSkuDetail(skuId=" + this.skuId + ", spuId=" + this.spuId + ", quantity=" + this.quantity + ", shop=" + this.shop + ", coverUrl=" + this.coverUrl + ", name=" + this.name + ", specifications=" + this.specifications + ", logisticsPolicy=" + this.logisticsPolicy + ", unitPrice=" + this.unitPrice + ", originUnitPrice=" + this.originUnitPrice + ", note=" + this.note + ", freight=" + this.freight + ", maxQuantity=" + this.maxQuantity + ", minQuantity=" + this.minQuantity + ", productType=" + this.productType + ")";
    }

    public /* synthetic */ OrderSkuDetail(String str, String str2, int i3, OrderShop orderShop, String str3, String str4, List list, List list2, long j3, long j16, String str5, String str6, int i16, int i17, j jVar, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, orderShop, str3, str4, list, list2, j3, j16, str5, str6, i16, (i18 & 8192) != 0 ? 1 : i17, jVar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderSkuDetail)) {
            return false;
        }
        OrderSkuDetail orderSkuDetail = (OrderSkuDetail) other;
        return Intrinsics.areEqual(this.skuId, orderSkuDetail.skuId) && Intrinsics.areEqual(this.spuId, orderSkuDetail.spuId) && this.quantity == orderSkuDetail.quantity && Intrinsics.areEqual(this.shop, orderSkuDetail.shop) && Intrinsics.areEqual(this.coverUrl, orderSkuDetail.coverUrl) && Intrinsics.areEqual(this.name, orderSkuDetail.name) && Intrinsics.areEqual(this.specifications, orderSkuDetail.specifications) && Intrinsics.areEqual(this.logisticsPolicy, orderSkuDetail.logisticsPolicy) && this.unitPrice == orderSkuDetail.unitPrice && this.originUnitPrice == orderSkuDetail.originUnitPrice && Intrinsics.areEqual(this.note, orderSkuDetail.note) && Intrinsics.areEqual(this.freight, orderSkuDetail.freight) && this.maxQuantity == orderSkuDetail.maxQuantity && this.minQuantity == orderSkuDetail.minQuantity && Intrinsics.areEqual(this.productType, orderSkuDetail.productType);
    }

    public final OrderSkuDetail a(String skuId, String spuId, int quantity, OrderShop shop, String coverUrl, String name, List<OrderSkuSpec> specifications, List<String> logisticsPolicy, long unitPrice, long originUnitPrice, String note, String freight, int maxQuantity, int minQuantity, j productType) {
        return new OrderSkuDetail(skuId, spuId, quantity, shop, coverUrl, name, specifications, logisticsPolicy, unitPrice, originUnitPrice, note, freight, maxQuantity, minQuantity, productType);
    }
}
