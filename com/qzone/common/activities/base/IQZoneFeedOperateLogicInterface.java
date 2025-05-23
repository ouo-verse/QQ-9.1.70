package com.qzone.common.activities.base;

import android.os.Bundle;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface IQZoneFeedOperateLogicInterface {
    public static final String EVENT_PARAMETER_KEY_HIDE_FEEDS_KEY = "hideFeedsKey";
    public static final String EVENT_PARAMETER_KEY_HIDE_FEEDS_POSITION = "hideVideoFeedsPosition";

    void handleFavorRespone(boolean z16, String str, boolean z17);

    void handleGetShareUrl(QZoneResult qZoneResult);

    void handleGetShareUrl(boolean z16, Bundle bundle);

    void handleHidePersonFeedsCallback(QZoneResult qZoneResult);

    void hideNewUserRecommendFeeds(int i3);

    boolean isFavorite();

    void onHideFeeds(boolean z16, int i3);

    void onInform();

    void onShareToQQ();

    void onShareToWeixin();

    void onShareToWxMoments();

    void onShareToXHS();

    void setFeedData(BusinessFeedData businessFeedData);

    void toggleFavorite(boolean z16);
}
