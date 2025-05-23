package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StGPS;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonGPS;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StGPS;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonGPSKt {
    public static final CommonGPS toCommon(StGPS stGPS) {
        if (stGPS == null) {
            return null;
        }
        CommonGPS commonGPS = new CommonGPS();
        Long l3 = stGPS.lat;
        commonGPS.setLat(l3 != null ? l3.longValue() : 0L);
        Long l16 = stGPS.lon;
        commonGPS.setLon(l16 != null ? l16.longValue() : 0L);
        Long l17 = stGPS.eType;
        commonGPS.setEType(l17 != null ? l17.longValue() : 0L);
        Long l18 = stGPS.alt;
        commonGPS.setAlt(l18 != null ? l18.longValue() : 0L);
        return commonGPS;
    }

    public static final StGPS toPb(CommonGPS commonGPS) {
        if (commonGPS != null) {
            return new StGPS(Long.valueOf(commonGPS.getLat()), Long.valueOf(commonGPS.getLon()), Long.valueOf(commonGPS.getEType()), Long.valueOf(commonGPS.getAlt()));
        }
        return null;
    }
}
