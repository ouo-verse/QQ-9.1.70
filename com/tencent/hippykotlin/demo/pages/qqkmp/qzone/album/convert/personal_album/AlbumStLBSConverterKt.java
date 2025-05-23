package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStGPS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StGPS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLBS;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"toCommonStLBS", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStLBS;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;", "toNTStLBS", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class AlbumStLBSConverterKt {
    public static final CommonStLBS toCommonStLBS(StLBS stLBS) {
        CommonStGPS commonStGPS;
        CommonStLBS commonStLBS = new CommonStLBS();
        StGPS stGPS = stLBS.gps;
        if (stGPS == null || (commonStGPS = AlbumStGPSConverterKt.toCommonStGPS(stGPS)) == null) {
            commonStGPS = new CommonStGPS();
        }
        commonStLBS.setGps(commonStGPS);
        String str = stLBS.location;
        if (str == null) {
            str = "";
        }
        commonStLBS.setLocation(str);
        String str2 = stLBS.address;
        commonStLBS.setAddress(str2 != null ? str2 : "");
        return commonStLBS;
    }

    public static final StLBS toNTStLBS(CommonStLBS commonStLBS) {
        StLBS stLBS = new StLBS(null, null, null, null, 15, null);
        stLBS.gps = AlbumStGPSConverterKt.toStGPS(commonStLBS.getGps());
        stLBS.location = commonStLBS.getLocation();
        stLBS.address = commonStLBS.getAddress();
        return stLBS;
    }
}
