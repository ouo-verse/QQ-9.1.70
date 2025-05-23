package com.tencent.ecommerce.biz.orders.common;

import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\"\u0017\u0010\u0007\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/c;", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "b", "Lcom/tencent/ecommerce/biz/orders/common/e;", "a", "Lcom/tencent/ecommerce/biz/orders/common/e;", "()Lcom/tencent/ecommerce/biz/orders/common/e;", "EMPTY_LOGISTICS_INFO", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final LogisticsInfo f103693a;

    static {
        List emptyList;
        List emptyList2;
        List emptyList3;
        ShipperCompany shipperCompany = new ShipperCompany("", "", "");
        TrailStatusInfo trailStatusInfo = new TrailStatusInfo(TrailStatus.NO_MSG, TrailSubStatus.NO_MSG, "");
        ECAddress eCAddress = new ECAddress(0L, "", "", "", "", "", "", "", null, false, null, 1281, null);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        f103693a = new LogisticsInfo("", shipperCompany, trailStatusInfo, eCAddress, new PackageInfo("", "", "", "", 0, 16, null), emptyList, "", emptyList2, emptyList3, "", 0, 1024, null);
    }

    public static final LogisticsInfo a() {
        return f103693a;
    }

    public static final LatLng b(Coordinate coordinate) {
        return new LatLng(coordinate.latitude, coordinate.longitude);
    }
}
