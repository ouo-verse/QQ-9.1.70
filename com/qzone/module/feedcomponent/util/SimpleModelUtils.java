package com.qzone.module.feedcomponent.util;

import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SimpleModelUtils {
    private static final String TAG = "CF-SimpleModelUtils";

    public static boolean isSimpleModeFeed() {
        return i.H().v1() && i.H().n1(i.H().L());
    }

    public static void printDebugLog(String str) {
        if (!TextUtils.isEmpty(str) && com.qzone.proxy.feedcomponent.b.g()) {
            com.qzone.proxy.feedcomponent.b.a(TAG, str);
        }
    }

    public static boolean isFirstFeed(int i3) {
        return i3 == 1 && !i.H().o1();
    }

    public static boolean isFeedSkinPlus(BusinessFeedData businessFeedData) {
        FeedSkinData cellFeedSkinInfo = businessFeedData == null ? null : businessFeedData.getCellFeedSkinInfo();
        return cellFeedSkinInfo != null && cellFeedSkinInfo.nSkinType == 392;
    }

    public static boolean isLoadFeedSkin(BusinessFeedData businessFeedData, boolean z16) {
        String str;
        FeedSkinData cellFeedSkinInfo = businessFeedData == null ? null : businessFeedData.getCellFeedSkinInfo();
        boolean d16 = i.H().d1();
        boolean z17 = (cellFeedSkinInfo == null || cellFeedSkinInfo.nSkinType == 0) ? false : true;
        if (com.qzone.proxy.feedcomponent.b.g()) {
            int i3 = cellFeedSkinInfo == null ? 0 : cellFeedSkinInfo.nSkinType;
            if (cellFeedSkinInfo == null) {
                str = "null";
            } else {
                str = cellFeedSkinInfo.sPicUrl;
            }
            com.qzone.proxy.feedcomponent.b.a(TAG, "[isLoadFeedSkin] isCanShowFeedSkin: " + z16 + " | isFeedSkinSwitchEnable: " + d16 + " | isExistsSkin: " + z17 + " | skinType: " + i3 + " | picUrl: " + str);
        }
        return z16 && z17;
    }
}
