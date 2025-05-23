package com.tencent.mobileqq.troop.utils.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopSPUtilApi extends QRouteApi {
    public static final String KEY_ALBUM_MESSAGE = "troop_photo_message";
    public static final String KEY_ALBUM_NEW_PHOTOES = "troop_photo_new";
    public static final String KEY_FILE_NEW = "troop_file_new";
    public static final String KEY_GROUP_ACTIVITY_NEW = "group_activity_new_message";
    public static final String KEY_GROUP_FILE_INNER_REDDOT_TIM = "group_file_inner_reddot_tim";
    public static final String KEY_GROUP_FILE_REDDOT_TIM = "group_file_reddot_tim";
    public static final String KEY_TROOP_LUCKY_CHARACTER_STATUS = "troop_lucky_character_status";
    public static final String KEY_TROOP_NOTIFICATION_NEW = "troop_notification_new";
    public static final String TROOP_NEWS_NOTIFY = "troop_news_notify";

    boolean getAIOTroopMiniAppEntranceRedPoint(AppRuntime appRuntime, String str);

    boolean getGroupTIMFileNewsInfo(String str, String str2, String str3, boolean z16);

    Object[] getKeyTroopLuckyCharacterStatus(String str, String str2, String str3);

    int getTroopAioKeyWordVersion(Context context, String str);

    boolean getTroopHasNewApp(AppRuntime appRuntime, String str);

    int groupGroupNewsInfo(String str, String str2, String str3);

    boolean hasShowTroopGameCardRedPoint(String str, String str2);

    boolean isShowTroopGameCardRedPoint(String str, String str2, boolean z16);

    void removeGroupTIMFileNewsInfo(String str, String str2, String str3);

    void setAIOTroopMiniAppEntranceRedPoint(AppRuntime appRuntime, String str, boolean z16);

    void setGroupGroupNewsInfo(String str, String str2, String str3, int i3);

    void setGroupPadTemplateNewsInfoTips(String str, String str2, String str3, boolean z16);

    void setGroupTIMFileNewsInfo(String str, String str2, String str3, boolean z16);

    void setTroopGameCardRedPoint(String str, String str2, boolean z16);

    void setTroopGameCardRedPointHasShowed(String str, String str2, boolean z16);

    void setTroopHasNewApp(AppRuntime appRuntime, String str, boolean z16);

    void updateTroopAioKeyWordVersion(Context context, String str, int i3);
}
