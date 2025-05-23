package com.qzone.component.banner.util;

import TianShuJce.AdItem;
import TianShuJce.AdPlacementInfo;
import com.qzone.component.banner.BusinessADBannerData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {
    public static AdItem a(com.qzone.feed.business.model.a aVar) {
        if (aVar == null) {
            QLog.d("QZoneBannerUtil", 2, "banner validData: bannerData is null");
            return null;
        }
        BusinessADBannerData businessADBannerData = aVar.f47123g;
        if (businessADBannerData == null) {
            QLog.d("QZoneBannerUtil", 2, "banner validData: buAdBannerData is null");
            return null;
        }
        AdPlacementInfo adPlacementInfo = businessADBannerData.tianshuAdPlacementInfo;
        if (adPlacementInfo == null) {
            QLog.d("QZoneBannerUtil", 2, "banner validData: tianShuAdPlacementInfo is null");
            return null;
        }
        ArrayList<AdItem> arrayList = adPlacementInfo.lst;
        if (arrayList != null && arrayList.size() > 0) {
            return arrayList.get(0);
        }
        QLog.d("QZoneBannerUtil", 2, "banner validData: tianShuAdPlacementInfo.lst is empty");
        return null;
    }
}
