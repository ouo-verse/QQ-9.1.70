package com.tencent.biz.qqcircle.utils;

import com.tencent.qphone.base.util.QLog;
import weprotocols.WEProtocolsAdvert$BannerAdvert;

/* compiled from: P */
/* loaded from: classes5.dex */
public class p {
    public static boolean a(e30.b bVar) {
        WEProtocolsAdvert$BannerAdvert wEProtocolsAdvert$BannerAdvert = new WEProtocolsAdvert$BannerAdvert();
        try {
            wEProtocolsAdvert$BannerAdvert = (WEProtocolsAdvert$BannerAdvert) bVar.b("DITTO_FEED_BANNER_BUSI_DATA");
        } catch (Exception e16) {
            QLog.e("QCircleBannerAdUtils", 1, "trans bannerAdvert failed " + e16);
        }
        if (wEProtocolsAdvert$BannerAdvert != null && wEProtocolsAdvert$BannerAdvert.has_banner.get()) {
            return true;
        }
        return false;
    }
}
