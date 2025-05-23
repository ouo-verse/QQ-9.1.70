package com.tencent.mobileqq.onlinestatus.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.u;
import com.tencent.mobileqq.onlinestatus.v;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IOnLineStatueHelperApi extends QRouteApi {
    public static final String FIRST_FRIENDS_UIN_KEY = "FIRST_FRIENDS_UIN_KEY";
    public static final String FRIENDS_UPDATE_ONLINE_STATUS_MIN_TIME_KEY = "FRIENDS_UPDATE_ONLINE_STATUS_MIN_TIME_KEY";
    public static final String FRIENDS_UPDATE_ONLINE_STATUS_NUMS_KEY = "FRIENDS_UPDATE_ONLINE_STATUS_NUMS_KEY";
    public static final String KEY_ONLINE_STATE_ACTIVITY_CHANGED_EXTID = "key_activity_online_changed_extstatusid";
    public static final String KEY_RED_HEART_UNREAD_NUM = "KEY_RED_HEART_UNREAD_NUM";
    public static final String ONLINE_STATUS_AGGREGATION_LAST_CLICK_TIME = "ONLINE_STATUS_AGGREGATION_LAST_CLICK_TIME";
    public static final String ONLINE_STATUS_AGGREGATION_SCENE = "ONLINE_STATUS_AGGREGATION_SCENE";
    public static final int ONLINE_STATUS_FROM_ACCOUNT_MANAGE = 7;
    public static final int ONLINE_STATUS_FROM_AIO = 1;
    public static final int ONLINE_STATUS_FROM_AIO_POPUP_DIALOG = 5;
    public static final int ONLINE_STATUS_FROM_AIO_POPUP_DIALOG_OLYMPIC = 6;
    public static final int ONLINE_STATUS_FROM_CHAT_LIST = 8;
    public static final int ONLINE_STATUS_FROM_CONTACTS = 2;
    public static final int ONLINE_STATUS_FROM_CONVERSATION = 4;
    public static final int ONLINE_STATUS_FROM_PANEL = 3;
    public static final String ONLINE_STATUS_TIMEOUT = "ONLINE_STATUS_TIMEOUT";
    public static final String SHOWED_BIAOTAI_ITEM_POP = "SHOWED_BIAOTAI_ITEM_POP";
    public static final String UPDATE_FRIEND_UIN_KEY_TIME = "UPDATE_FRIEND_UIN_KEY_TIME";

    @Deprecated
    boolean bindOnlineStatusView(AppRuntime appRuntime, Friends friends, OnlineStatusView onlineStatusView);

    boolean bindOnlineStatusView(AppRuntime appRuntime, c cVar, OnlineStatusView onlineStatusView);

    Bundle buildSyncBatteryData(AppRuntime appRuntime);

    boolean enableAIOSubTitleClicked(AppRuntime appRuntime, String str);

    void fetchAvatarAtShareSheetOpened(u uVar);

    v getAvatarStatusIdByStatusId(AppRuntime.Status status, long j3);

    v getAvatarStatusInfo(AppRuntime appRuntime, String str);

    v getAvatarStatusInfoByKey(int i3, int i16);

    int getButtonId(AppRuntime.Status status);

    String getDisplayOnlineStatusInfo(AppRuntime appRuntime, c cVar, TextView textView, int i3, au auVar, Boolean bool);

    int getLocalBatteryCapacity();

    AppRuntime.Status getOldStatus(c cVar);

    Bitmap getOldStatusAIOIcon(au auVar);

    Bitmap getOnlineStatusBatteryIcon(int i3, int i16);

    au getOnlineStatusItem(String str);

    au getOnlineStatusItem(AppRuntime.Status status, long j3);

    au getOnlineStatusItem(AppRuntime.Status status, long j3, boolean z16);

    String getOnlineStatusName(AppRuntime.Status status, long j3);

    long getSelfExtOnlineStatus(AppRuntime appRuntime);

    Drawable getSelfStatusDrawable(long j3, AppRuntime.Status status, int i3, c cVar, int i16);

    String getSelfStatusNameBySubTitle(long j3, AppRuntime.Status status);

    int getSendBatteryStatus(int i3, int i16);

    Drawable getStatusDrawableWithBigType(c cVar, long j3);

    AppRuntime.Status getStatusFromProfile(int i3);

    au getStatusItem(int i3);

    String getStatusName(AppRuntime.Status status);

    String getStatusNamePlusNetWorkType(int i3);

    Drawable[] getSubtitleOnlineDrawable(AppRuntime appRuntime, c cVar, boolean z16, boolean z17);

    boolean handleAIOSubTitleClicked(AppRuntime appRuntime, Activity activity, String str, View view);

    void handleEventStatusEgg(AppRuntime appRuntime, au auVar, Activity activity, ViewGroup viewGroup, int i3, int i16);

    boolean handleOlympicEggAnim(AppRuntime appRuntime, View view);

    boolean hasPermission(String str);

    boolean isAvatarAccountAutoWhite(String str);

    boolean isInOlympicMedalEvent();

    boolean isWeatherInfoValid(c cVar);

    void launchDebugFragment(Context context);

    void launchOlympicShareFragment(Activity activity, Intent intent);

    boolean needShowEventStatusEgg(AppRuntime appRuntime, au auVar);

    void onDestroyOlympicEggAnim(AppRuntime appRuntime);

    void onFriendChatPieFinish(AppRuntime appRuntime);

    @Deprecated
    void parseExtOnlineBusinessInfo(Friends friends, byte[] bArr, String str);

    @Deprecated
    void parseFriendMusicInfo(Friends friends, byte[] bArr, String str);

    @Deprecated
    void parseVecExtInfo(Friends friends, byte[] bArr, long j3, HashMap<String, Long> hashMap);

    void refreshOnlineStatusDNDBanner();

    void requestNTOnlineStatus(String str, boolean z16, String str2);

    void requestNTOnlineStatusByUin(String str, boolean z16, String str2);

    void setOnlineStatusTextAndIcon(String str, @Nullable TextView textView, @Nullable ImageView imageView);

    void sortAndSaveMap(HashMap<String, Long> hashMap);

    void startAccountOnlineStateActivity(Activity activity, Intent intent, int i3);

    void startAccountOnlineStateActivity(Context context, Intent intent);

    AppRuntime.Status translateNT(c cVar);

    AppRuntime.Status translateStatus(int i3);

    void updateOlympicMedalEventInfo(AppRuntime appRuntime, int i3, long j3, long j16, String str);
}
