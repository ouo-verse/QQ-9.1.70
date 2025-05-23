package com.qzone.proxy.personalitycomponent.adapter;

import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;

/* loaded from: classes39.dex */
public class PersonalityConfig {
    public static final int ACTION_COVER_GUAJIAN = 308;
    public static final String ACTION_TYPE_ACTIVE_FEEDS_REDPOCKET = "302";
    public static final String ACTION_TYPE_FRIENDFEEDS = "1";
    public static final String ACTION_TYPE_FRIENDFEEDS_COVER = "302";
    public static final String ACTION_TYPE_STAR_VIP = "446";
    public static final String DEFAULT_ICON_DOWNLOAD_URL_PREFIX = "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/";
    public static final String MAIN_KEY_H5URL = "H5Url";
    public static final String MAIN_KEY_QZONE_SETTING = "QZoneSetting";
    public static final int MSG_GET_LBS_PERMISSION_REJECT = 20191113;
    public static final int MSG_REFRESH_VIP_WEDGET = 1000055;
    public static final int MSG_REFRESH_WIDGET = 20130703;
    public static final int MSG_REFRESH_WIDGET_FAILED = 20160112;
    public static final int MSG_REFRESH_WIDGET_VISITOR_NUM = 20190721;
    public static final int MSG_REQUEST_DRAW = 20140716;
    public static final int MSG_REQUEST_INVALID = 20190416;
    public static final String QZONE_FRIEND_FEED = "getActiveFeeds";
    public static final String RESERVES_COVER_CLICK_WIDGET_VISITOR = "401";
    public static final String RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE = "406";
    public static final String RESERVES_ENTER_WIDGET_DETAIL_CONSTELLATION = "2";
    public static final String RESERVES_ENTER_WIDGET_DETAIL_FLOWER = "4";
    public static final String RESERVES_ENTER_WIDGET_DETAIL_LUNAR = "3";
    public static final String RESERVES_ENTER_WIDGET_DETAIL_WEATHER = "1";
    public static final String RESERVES_STAR_VIP_SHOW = "1";
    public static final String SECONDARY_VISITOR_WIDGET_AVATAR_EACH_AVATAR_TIME_DURATION = "VisitorWidgetAvatarEachAvatarTimeDuration";
    public static final String SECONDARY_VISITOR_WIDGET_AVATAR_NOTICE_MAX_COUNT = "VisitorWidgetAvatarNoticeMaxCount";
    public static final String SECONDARY_VISITOR_WIDGET_SHOW_AVATAR_MAX_COUNT = "VisitorWidgetShowAvatarMaxCount";
    public static final String SECONDARY_WIDGET_DETAIL_URL = "WidgetDetail";
    public static final String SECONDARY_WIDGET_UNOPENYELLOWDIAMOND = "widgetOpenVipUrl";
    public static final String SECONDARY_WIDGET_UNOPEN_YELLOW_DIAMOND_ANIMATION = "WidgetOpenVipAnimationUrl";
    public static final int SUBACTION_COVER_GUAJIAN = 12;
    public static final String SUBACTION_TYPE_CLICKCOVER = "7";
    public static final String SUBACTION_TYPE_COVER = "4";
    public static final String SUBACTION_TYPE_STAR_VIP_WIDGET = "2";
    public static final String SUB_ACTION_TYPE_ACTIVE_FEEDS_REDPOCKET_DECORATE_CLICK = "73";
    public static final String SUB_ACTION_TYPE_ACTIVE_FEEDS_REDPOCKET_DECORATE_EXPOSED = "72";
    public static final int SUB_ACTION_TYPE_ACTIVE_FEEDS_REDPOCKET_PUSH_BANNER_CLICK = 8;
    public static final int SUB_ACTION_TYPE_ACTIVE_FEEDS_REDPOCKET_PUSH_BANNER_EXPOSED = 7;
    public static final String WIDGET_DETAIL_URL = "https://h5.qzone.qq.com/pendant/index?_wv=3";
    public static final int WIDGET_TYPE_CONSTELLATION = 2;
    public static final int WIDGET_TYPE_FLOWER = 3;
    public static final int WIDGET_TYPE_LUNAR = 1;
    public static final int WIDGET_TYPE_QZONEVIP = 1000;
    public static final int WIDGET_TYPE_UNKNOWN = -1;
    public static final int WIDGET_TYPE_VISITOR = 4;
    public static final int WIDGET_TYPE_WEATHER = 0;

    public static String getConfig(String str, String str2, String str3) {
        return QzoneConfig.getInstance().getConfig(str, str2, str3);
    }

    public static String getMultiProcessString(String str, String str2, String str3) {
        return LocalMultiProcConfig.getString(str, str2, str3);
    }

    public static int getConfig(String str, String str2, int i3) {
        return QzoneConfig.getInstance().getConfig(str, str2, i3);
    }
}
