package com.tencent.mobileqq.kandian.base.video.player.videourl.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import r52.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IThirdVideoManager extends QRouteApi {
    public static final String CMD_VIDEO_SHOP_AD = "SQQShopAdSvr.GetUrlByVid";
    public static final String CMD_VIDEO_URLFORUUID = "PubAccountArticleCenter.GetVidByUrl";
    public static final String CMD_VIDEO_UUIDFORURL = "PubAccountArticleCenter.GetUrlByVid";
    public static final int ERROR_VIDEO_DELETED = 2;
    public static final int URL_TYPE_HLS = 1;
    public static final int URL_TYPE_MP4 = 0;

    String getUrlByVid(String str);

    a getVidUrlObjectFromCache(String str);

    void sendUrlToUUIDRequest(String str, s52.a aVar);
}
