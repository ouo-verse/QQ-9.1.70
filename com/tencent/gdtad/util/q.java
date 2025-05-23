package com.tencent.gdtad.util;

import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class q {
    public static GdtVideoCeilingData a(AdVideoCeiling.Params params) {
        if (params != null && params.isValid()) {
            GdtVideoData gdtVideoData = new GdtVideoData();
            gdtVideoData.setUrl(params.videoUrl);
            gdtVideoData.setLoop(params.videoLoop);
            gdtVideoData.setDirectPlay(params.videoPlayForced);
            GdtVideoCeilingData gdtVideoCeilingData = new GdtVideoCeilingData();
            gdtVideoCeilingData.setAd((GdtAd) GdtAd.class.cast(params.f61336ad));
            gdtVideoCeilingData.setWebUrl(params.webUrl);
            gdtVideoCeilingData.setVideoData(gdtVideoData);
            gdtVideoCeilingData.setWidthHeightRatio(params.widthHeightRatio);
            gdtVideoCeilingData.setActionCode(params.actionCode);
            return gdtVideoCeilingData;
        }
        GdtLog.e("GdtVideoCeilingUtil", "GdtVideoCeilingUtil error");
        return null;
    }
}
