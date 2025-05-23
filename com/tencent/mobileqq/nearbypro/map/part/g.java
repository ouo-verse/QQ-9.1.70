package com.tencent.mobileqq.nearbypro.map.part;

import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001e\u0010\n\u001a\n \b*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/part/g;", "", "Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;", com.tencent.luggage.wxa.c8.c.G, "", "fromGesture", "", "a", "kotlin.jvm.PlatformType", "Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;", "lastCameraPosition", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private CameraPosition lastCameraPosition = CameraPosition.fromLatLngZoom(new LatLng(0.0d, 0.0d), 0.0f);

    public final void a(@NotNull CameraPosition pos, boolean fromGesture) {
        boolean z16;
        Map mapOf;
        boolean z17;
        String str;
        Map mapOf2;
        Intrinsics.checkNotNullParameter(pos, "pos");
        if (fromGesture) {
            float f16 = pos.zoom;
            CameraPosition cameraPosition = this.lastCameraPosition;
            float f17 = cameraPosition.zoom;
            if (f16 == f17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (f16 > f17) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                Pair[] pairArr = new Pair[2];
                pairArr[0] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                if (z17) {
                    str = "magnify";
                } else {
                    str = "reduce";
                }
                pairArr[1] = TuplesKt.to("nearby_map_act", str);
                mapOf2 = MapsKt__MapsKt.mapOf(pairArr);
                VideoReport.reportEvent("ev_nearby_map_act", mapOf2);
            } else if (!Intrinsics.areEqual(pos.target, cameraPosition.target)) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU"), TuplesKt.to("nearby_map_act", WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE));
                VideoReport.reportEvent("ev_nearby_map_act", mapOf);
            }
        }
        this.lastCameraPosition = pos;
    }
}
