package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStGPS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StGPS;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"toCommonStGPS", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStGPS;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StGPS;", "toStGPS", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class AlbumStGPSConverterKt {
    public static final CommonStGPS toCommonStGPS(StGPS stGPS) {
        CommonStGPS commonStGPS = new CommonStGPS();
        Long l3 = stGPS.lat;
        commonStGPS.setLat(l3 != null ? l3.longValue() : 0L);
        Long l16 = stGPS.lon;
        commonStGPS.setLon(l16 != null ? l16.longValue() : 0L);
        Long l17 = stGPS.eType;
        commonStGPS.setEType(l17 != null ? l17.longValue() : 0L);
        Long l18 = stGPS.alt;
        commonStGPS.setAlt(l18 != null ? l18.longValue() : 0L);
        return commonStGPS;
    }

    public static final StGPS toStGPS(CommonStGPS commonStGPS) {
        StGPS stGPS = new StGPS(null, null, null, null, 15, null);
        stGPS.lat = Long.valueOf(commonStGPS.getLat());
        stGPS.lon = Long.valueOf(commonStGPS.getLon());
        stGPS.eType = Long.valueOf(commonStGPS.getEType());
        stGPS.alt = Long.valueOf(commonStGPS.getAlt());
        return stGPS;
    }
}
