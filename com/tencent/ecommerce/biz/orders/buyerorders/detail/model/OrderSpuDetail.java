package com.tencent.ecommerce.biz.orders.buyerorders.detail.model;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$PicInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$PropertyItem;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$SpuInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$LabelInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$PicInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ProductSnapshot;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001\tBi\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u0012\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000e\u0010\u0016R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\f\u0010\u0016R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u00128\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016\u00a8\u0006'"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "id", "b", "title", "c", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "d", "firstCategoryId", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/d;", "e", "Ljava/util/List;", "()Ljava/util/List;", Constants.Service.PROPERTIES, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/c;", "f", "mainPicInfos", "g", "detailPicInfos", "", h.F, "J", "minPrice", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$LabelInfo;", "i", "spuLabels", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;JLjava/util/List;)V", "j", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.model.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class OrderSpuDetail {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String link;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String firstCategoryId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<OrderSpuProperty> properties;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<OrderSpuPicInfo> mainPicInfos;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<OrderSpuPicInfo> detailPicInfos;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final long minPrice;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ECOrderInfo$LabelInfo> spuLabels;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_common/ECOrderCommon$SpuInfo;", "spuInfo", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$LabelInfo;", "labels", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a;", "a", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr_sample_data/ECSampleData$ProductSnapshot;", "product", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.model.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final OrderSpuDetail a(ECOrderCommon$SpuInfo spuInfo, List<ECOrderInfo$LabelInfo> labels) {
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            int collectionSizeOrDefault3;
            String str = spuInfo.spu_id.get();
            String str2 = spuInfo.title.get();
            String str3 = spuInfo.spu_link.get();
            String str4 = spuInfo.category.get().first_cat_id.get();
            List<ECOrderCommon$PropertyItem> list = spuInfo.property.items.get();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(b.c((ECOrderCommon$PropertyItem) it.next()));
            }
            List<ECOrderCommon$PicInfo> list2 = spuInfo.main_pics.get();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                arrayList2.add(b.a((ECOrderCommon$PicInfo) it5.next()));
            }
            List<ECOrderCommon$PicInfo> list3 = spuInfo.detail_pics.get();
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
            Iterator<T> it6 = list3.iterator();
            while (it6.hasNext()) {
                arrayList3.add(b.a((ECOrderCommon$PicInfo) it6.next()));
            }
            long j3 = spuInfo.price.min.get();
            if (labels == null) {
                labels = CollectionsKt__CollectionsKt.emptyList();
            }
            return new OrderSpuDetail(str, str2, str3, str4, arrayList, arrayList2, arrayList3, j3, labels);
        }

        public final OrderSpuDetail b(ECSampleData$ProductSnapshot product) {
            List emptyList;
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            String str = product.spu_id.get();
            String str2 = product.title.get();
            String str3 = product.detail_link.get();
            String str4 = product.first_cat_id.get();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            List<ECSampleData$PicInfo> list = product.pic_list.get();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(b.b((ECSampleData$PicInfo) it.next()));
            }
            List<ECSampleData$PicInfo> list2 = product.pic_list.get();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                arrayList2.add(b.b((ECSampleData$PicInfo) it5.next()));
            }
            return new OrderSpuDetail(str, str2, str3, str4, emptyList, arrayList, arrayList2, 0L, null, 256, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OrderSpuDetail(String str, String str2, String str3, String str4, List<OrderSpuProperty> list, List<OrderSpuPicInfo> list2, List<OrderSpuPicInfo> list3, long j3, List<ECOrderInfo$LabelInfo> list4) {
        this.id = str;
        this.title = str2;
        this.link = str3;
        this.firstCategoryId = str4;
        this.properties = list;
        this.mainPicInfos = list2;
        this.detailPicInfos = list3;
        this.minPrice = j3;
        this.spuLabels = list4;
    }

    public final List<OrderSpuPicInfo> a() {
        return this.detailPicInfos;
    }

    public final List<OrderSpuPicInfo> b() {
        return this.mainPicInfos;
    }

    public final List<OrderSpuProperty> c() {
        return this.properties;
    }

    public final List<ECOrderInfo$LabelInfo> d() {
        return this.spuLabels;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.link;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.firstCategoryId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<OrderSpuProperty> list = this.properties;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        List<OrderSpuPicInfo> list2 = this.mainPicInfos;
        int hashCode6 = (hashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<OrderSpuPicInfo> list3 = this.detailPicInfos;
        int hashCode7 = (((hashCode6 + (list3 != null ? list3.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.minPrice)) * 31;
        List<ECOrderInfo$LabelInfo> list4 = this.spuLabels;
        return hashCode7 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        return "OrderSpuDetail(id=" + this.id + ", title=" + this.title + ", link=" + this.link + ", firstCategoryId=" + this.firstCategoryId + ", properties=" + this.properties + ", mainPicInfos=" + this.mainPicInfos + ", detailPicInfos=" + this.detailPicInfos + ", minPrice=" + this.minPrice + ", spuLabels=" + this.spuLabels + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ OrderSpuDetail(String str, String str2, String str3, String str4, List list, List list2, List list3, long j3, List list4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, list, list2, list3, j3, r11);
        List list5;
        List emptyList;
        if ((i3 & 256) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list5 = emptyList;
        } else {
            list5 = list4;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderSpuDetail)) {
            return false;
        }
        OrderSpuDetail orderSpuDetail = (OrderSpuDetail) other;
        return Intrinsics.areEqual(this.id, orderSpuDetail.id) && Intrinsics.areEqual(this.title, orderSpuDetail.title) && Intrinsics.areEqual(this.link, orderSpuDetail.link) && Intrinsics.areEqual(this.firstCategoryId, orderSpuDetail.firstCategoryId) && Intrinsics.areEqual(this.properties, orderSpuDetail.properties) && Intrinsics.areEqual(this.mainPicInfos, orderSpuDetail.mainPicInfos) && Intrinsics.areEqual(this.detailPicInfos, orderSpuDetail.detailPicInfos) && this.minPrice == orderSpuDetail.minPrice && Intrinsics.areEqual(this.spuLabels, orderSpuDetail.spuLabels);
    }
}
