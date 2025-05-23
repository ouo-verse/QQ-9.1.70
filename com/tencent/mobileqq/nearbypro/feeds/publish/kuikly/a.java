package com.tencent.mobileqq.nearbypro.feeds.publish.kuikly;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import cooperation.qzone.LbsDataV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Lcooperation/qzone/LbsDataV2$GpsInfo;", "gps", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "a", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    @NotNull
    public static final LatLng a(@NotNull LbsDataV2.GpsInfo gps) {
        Intrinsics.checkNotNullParameter(gps, "gps");
        return new LatLng(gps.lat / 1000000.0d, gps.lon / 1000000.0d);
    }
}
