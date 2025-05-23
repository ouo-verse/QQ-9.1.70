package com.tencent.ecommerce.biz.orders.common;

import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$Coordinate;
import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$LogisticsInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$TraceItem;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$Logistics;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u0000 22\u00020\u0001:\u0001\u0016Bs\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\f\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b0\u00101J\u0089\u0001\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u00c6\u0001J\t\u0010\u0017\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0014H\u00d6\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u001cR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f8\u0006\u00a2\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b#\u0010'R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\f8\u0006\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b\u001f\u0010'R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\u001cR\u0016\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0013\u0010/\u001a\u0004\u0018\u00010\r8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/e;", "", "", "code", "Lcom/tencent/ecommerce/biz/orders/common/l;", "shipperCompany", "Lcom/tencent/ecommerce/biz/orders/common/m;", "currentStatus", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "receiverAddress", "Lcom/tencent/ecommerce/biz/orders/common/h;", "packageInfo", "", "Lcom/tencent/ecommerce/biz/orders/common/g;", "traceItems", "trailUrl", "Lcom/tencent/ecommerce/biz/orders/common/c;", "preCoordinates", "coordinates", "estimatedDeliveryTime", "", WadlProxyConsts.CHANNEL, "a", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "Lcom/tencent/ecommerce/biz/orders/common/l;", "c", "Lcom/tencent/ecommerce/biz/orders/common/m;", "d", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "e", "Lcom/tencent/ecommerce/biz/orders/common/h;", "f", "Ljava/util/List;", "()Ljava/util/List;", "g", tl.h.F, "i", "j", "k", "I", "()Lcom/tencent/ecommerce/biz/orders/common/g;", "latestTraceItem", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/common/l;Lcom/tencent/ecommerce/biz/orders/common/m;Lcom/tencent/ecommerce/biz/orders/address/ECAddress;Lcom/tencent/ecommerce/biz/orders/common/h;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;I)V", "l", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.common.e, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class LogisticsInfo {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final ShipperCompany shipperCompany;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final TrailStatusInfo currentStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECAddress receiverAddress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final PackageInfo packageInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<LogisticsTraceItem> traceItems;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final String trailUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<Coordinate> preCoordinates;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<Coordinate> coordinates;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final String estimatedDeliveryTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    public int channel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/e$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_logistics_common/ECLogisticsCommon$LogisticsInfo;", "info", "Lcom/tencent/ecommerce/biz/orders/common/e;", "a", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr_sample_data/ECSampleData$Logistics;", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.common.e$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final LogisticsInfo b(ECSampleData$Logistics info) {
            List listOf;
            LogisticsInfo a16 = f.a();
            String str = info.logistics_code.get();
            ShipperCompany a17 = ShipperCompany.INSTANCE.a(info.shipper_company);
            TrailStatusInfo a18 = TrailStatusInfo.INSTANCE.a(info.trace_item.status);
            listOf = CollectionsKt__CollectionsJVMKt.listOf(LogisticsTraceItem.INSTANCE.a(info.trace_item.get()));
            return LogisticsInfo.b(a16, str, a17, a18, null, null, listOf, null, null, null, null, 0, 2008, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LogisticsInfo a(ECLogisticsCommon$LogisticsInfo info) {
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            int collectionSizeOrDefault3;
            String str = info.logistics_code.get();
            ShipperCompany a16 = ShipperCompany.INSTANCE.a(info.shipper_company);
            TrailStatusInfo a17 = TrailStatusInfo.INSTANCE.a(info.current_status);
            ECAddress c16 = com.tencent.ecommerce.biz.orders.address.b.c(info.receive_address);
            PackageInfo a18 = PackageInfo.INSTANCE.a(info.package_info);
            List<ECLogisticsCommon$TraceItem> list = info.trail_trace.trace_items.get();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(LogisticsTraceItem.INSTANCE.a((ECLogisticsCommon$TraceItem) it.next()));
            }
            String str2 = info.trail_trace.trail_url.get();
            List<ECLogisticsCommon$Coordinate> list2 = info.trail_trace.pre_coordinates.get();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                arrayList2.add(Coordinate.INSTANCE.a((ECLogisticsCommon$Coordinate) it5.next()));
            }
            List<ECLogisticsCommon$Coordinate> list3 = info.trail_trace.coordinates.get();
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
            Iterator<T> it6 = list3.iterator();
            while (it6.hasNext()) {
                arrayList3.add(Coordinate.INSTANCE.a((ECLogisticsCommon$Coordinate) it6.next()));
            }
            return new LogisticsInfo(str, a16, a17, c16, a18, arrayList, str2, arrayList2, arrayList3, info.trail_trace.estimated_delivery_time.get(), 0, 1024, null);
        }
    }

    public LogisticsInfo(String str, ShipperCompany shipperCompany, TrailStatusInfo trailStatusInfo, ECAddress eCAddress, PackageInfo packageInfo, List<LogisticsTraceItem> list, String str2, List<Coordinate> list2, List<Coordinate> list3, String str3, int i3) {
        this.code = str;
        this.shipperCompany = shipperCompany;
        this.currentStatus = trailStatusInfo;
        this.receiverAddress = eCAddress;
        this.packageInfo = packageInfo;
        this.traceItems = list;
        this.trailUrl = str2;
        this.preCoordinates = list2;
        this.coordinates = list3;
        this.estimatedDeliveryTime = str3;
        this.channel = i3;
    }

    public static /* synthetic */ LogisticsInfo b(LogisticsInfo logisticsInfo, String str, ShipperCompany shipperCompany, TrailStatusInfo trailStatusInfo, ECAddress eCAddress, PackageInfo packageInfo, List list, String str2, List list2, List list3, String str3, int i3, int i16, Object obj) {
        return logisticsInfo.a((i16 & 1) != 0 ? logisticsInfo.code : str, (i16 & 2) != 0 ? logisticsInfo.shipperCompany : shipperCompany, (i16 & 4) != 0 ? logisticsInfo.currentStatus : trailStatusInfo, (i16 & 8) != 0 ? logisticsInfo.receiverAddress : eCAddress, (i16 & 16) != 0 ? logisticsInfo.packageInfo : packageInfo, (i16 & 32) != 0 ? logisticsInfo.traceItems : list, (i16 & 64) != 0 ? logisticsInfo.trailUrl : str2, (i16 & 128) != 0 ? logisticsInfo.preCoordinates : list2, (i16 & 256) != 0 ? logisticsInfo.coordinates : list3, (i16 & 512) != 0 ? logisticsInfo.estimatedDeliveryTime : str3, (i16 & 1024) != 0 ? logisticsInfo.channel : i3);
    }

    public final LogisticsInfo a(String code, ShipperCompany shipperCompany, TrailStatusInfo currentStatus, ECAddress receiverAddress, PackageInfo packageInfo, List<LogisticsTraceItem> traceItems, String trailUrl, List<Coordinate> preCoordinates, List<Coordinate> coordinates, String estimatedDeliveryTime, int channel) {
        return new LogisticsInfo(code, shipperCompany, currentStatus, receiverAddress, packageInfo, traceItems, trailUrl, preCoordinates, coordinates, estimatedDeliveryTime, channel);
    }

    public final List<Coordinate> c() {
        return this.coordinates;
    }

    public final LogisticsTraceItem d() {
        Object firstOrNull;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.traceItems);
        return (LogisticsTraceItem) firstOrNull;
    }

    public final List<Coordinate> e() {
        return this.preCoordinates;
    }

    public final List<LogisticsTraceItem> f() {
        return this.traceItems;
    }

    public int hashCode() {
        String str = this.code;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ShipperCompany shipperCompany = this.shipperCompany;
        int hashCode2 = (hashCode + (shipperCompany != null ? shipperCompany.hashCode() : 0)) * 31;
        TrailStatusInfo trailStatusInfo = this.currentStatus;
        int hashCode3 = (hashCode2 + (trailStatusInfo != null ? trailStatusInfo.hashCode() : 0)) * 31;
        ECAddress eCAddress = this.receiverAddress;
        int hashCode4 = (hashCode3 + (eCAddress != null ? eCAddress.hashCode() : 0)) * 31;
        PackageInfo packageInfo = this.packageInfo;
        int hashCode5 = (hashCode4 + (packageInfo != null ? packageInfo.hashCode() : 0)) * 31;
        List<LogisticsTraceItem> list = this.traceItems;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.trailUrl;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Coordinate> list2 = this.preCoordinates;
        int hashCode8 = (hashCode7 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Coordinate> list3 = this.coordinates;
        int hashCode9 = (hashCode8 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str3 = this.estimatedDeliveryTime;
        return ((hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.channel;
    }

    public String toString() {
        return "LogisticsInfo(code=" + this.code + ", shipperCompany=" + this.shipperCompany + ", currentStatus=" + this.currentStatus + ", receiverAddress=" + this.receiverAddress + ", packageInfo=" + this.packageInfo + ", traceItems=" + this.traceItems + ", trailUrl=" + this.trailUrl + ", preCoordinates=" + this.preCoordinates + ", coordinates=" + this.coordinates + ", estimatedDeliveryTime=" + this.estimatedDeliveryTime + ", channel=" + this.channel + ")";
    }

    public /* synthetic */ LogisticsInfo(String str, ShipperCompany shipperCompany, TrailStatusInfo trailStatusInfo, ECAddress eCAddress, PackageInfo packageInfo, List list, String str2, List list2, List list3, String str3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, shipperCompany, trailStatusInfo, eCAddress, packageInfo, list, str2, list2, list3, str3, (i16 & 1024) != 0 ? 0 : i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogisticsInfo)) {
            return false;
        }
        LogisticsInfo logisticsInfo = (LogisticsInfo) other;
        return Intrinsics.areEqual(this.code, logisticsInfo.code) && Intrinsics.areEqual(this.shipperCompany, logisticsInfo.shipperCompany) && Intrinsics.areEqual(this.currentStatus, logisticsInfo.currentStatus) && Intrinsics.areEqual(this.receiverAddress, logisticsInfo.receiverAddress) && Intrinsics.areEqual(this.packageInfo, logisticsInfo.packageInfo) && Intrinsics.areEqual(this.traceItems, logisticsInfo.traceItems) && Intrinsics.areEqual(this.trailUrl, logisticsInfo.trailUrl) && Intrinsics.areEqual(this.preCoordinates, logisticsInfo.preCoordinates) && Intrinsics.areEqual(this.coordinates, logisticsInfo.coordinates) && Intrinsics.areEqual(this.estimatedDeliveryTime, logisticsInfo.estimatedDeliveryTime) && this.channel == logisticsInfo.channel;
    }
}
