package com.qzone.reborn.feedx.util;

import android.text.TextUtils;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFollowGuide;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes37.dex */
public class y {
    public static BusinessFeedData a() {
        BusinessFeedData businessFeedData = new BusinessFeedData();
        businessFeedData.setIsFakeMemorySealFeed(true);
        return businessFeedData;
    }

    public static boolean b() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_FEED_LIST_HAS_MORE_SWITCH, 1) == 1;
    }

    public static boolean e() {
        return (TextUtils.isEmpty(QZoneFeedService.f47178j0) && TextUtils.isEmpty(y6.e.H)) ? false : true;
    }

    public static boolean c(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getFeedCommInfo().extendInfo == null || businessFeedData.feedType != 3 || !TextUtils.equals("func_guiding_feed", businessFeedData.getFeedCommInfo().extendInfo.get("_func_type"))) ? false : true;
    }

    public static boolean d(BusinessFeedData businessFeedData) {
        CellFollowGuide cellFollowGuide;
        if (businessFeedData == null || (cellFollowGuide = businessFeedData.cellFollowGuide) == null) {
            return false;
        }
        int i3 = cellFollowGuide.feed_type;
        return i3 == 1 || i3 == 4;
    }

    public static boolean f(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getFeedCommInfo().extendInfo == null) {
            return true;
        }
        String str = businessFeedData.getFeedCommInfo().extendInfo.get("_func_type");
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return "func_friend_feed".equals(str);
    }
}
