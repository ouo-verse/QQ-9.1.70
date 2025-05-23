package com.tencent.biz.pubaccount.util.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountUtil extends QRouteApi {
    public static final int MSG_RECENT_CLICK_ONCE = 200;
    public static final String NEED_FINISH = "need_finish";
    public static final int PB_PROTOCOL_VERSION = 1;
    public static final int PUBLIC_ACCOUNT_OPEN_PROFILE_SOURCE_AIO = 1;
    public static final int PUBLIC_ACCOUNT_OPEN_PROFILE_SOURCE_AIO_BUBBLE = 2;
    public static final int PUBLIC_ACCOUNT_OPEN_PROFILE_SOURCE_BMQQ_PROFILE = 3;
    public static final int PUBLIC_ACCOUNT_OPEN_PROFILE_SOURCE_ECSHOP = 4;
    public static final int PUBLIC_ACCOUNT_TYPE_BMQQ = -6;
    public static final int PUBLIC_ACCOUNT_TYPE_CERTIFIED = -10;
    public static final int PUBLIC_ACCOUNT_TYPE_EQQ = -7;
    public static final int PUBLIC_ACCOUNT_TYPE_INTEREST = -2;
    public static final int PUBLIC_ACCOUNT_TYPE_MEDIA = -3;
    public static final int PUBLIC_ACCOUNT_TYPE_OM = -8;
    public static final int PUBLIC_ACCOUNT_TYPE_OTHER_SUBSCRIPT = -4;
    public static final int PUBLIC_ACCOUNT_TYPE_SCHOOL = -9;
    public static final int PUBLIC_ACCOUNT_TYPE_SERVICE = -11;
    public static final int PUBLIC_ACCOUNT_TYPE_SHOP = -5;
    public static final int PUBLIC_ACCOUNT_TYPE_UNKNOW = -1;
    public static final String TAG = "PublicAccountUtil";
    public static final String TAG_FROM_READINJOY = "is_come_from_readinjoy";
    public static final String UIN_FOR_HEALTH = "3026775809";
    public static final String UIN_FOR_SHOP = "3046055438";
    public static final String UIN_FOR_WALLET = "2711679534";
    public static final String UIN_QQ_NEWS = "2909288299";
    public static final String VIDEO_REALTIME_REPORT_AID = "VIDEO_REALTIME_REPORT_AID";
    public static final String VIDEO_REALTIME_REPORT_RCODE = "VIDEO_REALTIME_REPORT_RCODE";
    public static final String VIDEO_REALTIME_REPORT_RTYPE = "VIDEO_REALTIME_REPORT_RTYPE";
    public static final String VIDEO_REALTIME_REPORT_URL = "https://c.mp.qq.com/post/pageview/report?ftype=5&ctype=1&aid=%s&vid=%s&rtype=%d&rowkey=%s";
    public static final String VIDEO_REALTIME_REPORT_VID = "VIDEO_REALTIME_REPORT_VID";

    /* loaded from: classes4.dex */
    public interface a<T> {
        void onResult(boolean z16, T t16);
    }

    boolean articleReport(String str, int i3, String str2);

    void cleanPublicAccountObserver();

    String constructAttributeL();

    void deletePubAccountMsg(AppInterface appInterface, Context context, String str, int i3, long j3, boolean z16);

    void doVideoPlayRealtimeReport(String str, String str2, int i3, int i16);

    void enterTimTeam(Context context, AppInterface appInterface);

    void followUin(AppInterface appInterface, Context context, String str, IPublicAccountObserver iPublicAccountObserver);

    void followUin(AppInterface appInterface, Context context, String str, IPublicAccountObserver iPublicAccountObserver, int i3);

    void followUin(AppInterface appInterface, Context context, String str, IPublicAccountObserver iPublicAccountObserver, boolean z16);

    void followUin(AppInterface appInterface, Context context, String str, IPublicAccountObserver iPublicAccountObserver, boolean z16, int i3);

    void followUin(AppInterface appInterface, Context context, String str, IPublicAccountObserver iPublicAccountObserver, boolean z16, int i3, boolean z17);

    int getAccountType(int i3);

    int getAccountType(AppInterface appInterface, String str);

    int getAccountType(AppInterface appInterface, String str, int i3);

    long getAccountType2(long j3);

    String getNickName(AppRuntime appRuntime, String str);

    int getPubAccountRecentUserPosInMessageList();

    void getPublicAccountDetail(String str, a<IPublicAccountDetail> aVar);

    NewIntent getPublicAccountDetailRequest(AppInterface appInterface, Context context, MqqHandler mqqHandler, String str);

    String getSourceId(String str);

    String getUid(AppRuntime appRuntime, String str);

    void getUidAsync(String str, a<String> aVar);

    int getUinType(AppInterface appInterface, String str);

    String getVersionInfo();

    void gotoProfile(Intent intent, AppInterface appInterface, Context context, String str, int i3);

    void gotoProfileForResult(Intent intent, AppInterface appInterface, Activity activity, String str, int i3, int i16, int i17, boolean z16);

    boolean isComeFromReadInJoy();

    boolean isDeleteOldKandian(AppInterface appInterface);

    boolean isFollowUin(AppInterface appInterface, String str);

    boolean isHitPublicAccountFolderExp();

    boolean isInPublicAccountFolder(long j3);

    boolean isInterestAccount(AppInterface appInterface, String str);

    boolean isInterestAccountOrUnSupportMsgType(AppInterface appInterface, String str, int i3);

    boolean isKandianHost(String str);

    boolean isKandianNeedAddSkinParamsUrl(String str);

    boolean isKandianUrl(String str);

    boolean isMediaAndOtherSubscript(AppInterface appInterface, String str);

    boolean isMsgTabStoryNodeListVisible();

    boolean isOnFetchMsgStage(BaseQQAppInterface baseQQAppInterface);

    boolean isPublicAccountFolderSettingShow(long j3);

    boolean isPublicAccountUrl(String str);

    boolean isQWalletPubAccount(Object obj);

    boolean isSubscript(int i3, long j3);

    void modifyIntentForSpecificBrowserIfNeeded(Intent intent, String str);

    void modifyIntentForSpecificBrowserIfNeeded(MessageRecord messageRecord, Intent intent, String str);

    void onPublicAccountArkMsgClick(AppInterface appInterface, ChatMessage chatMessage);

    void openPublicAccountCommonAIO(Context context, String str);

    void openPublicAccountProfile(Intent intent, Context context, String str);

    JSONObject parseString2Json(String str);

    IPublicAccountDetail queryAccountDetail(AppInterface appInterface, String str);

    void removeLbsUin(AppInterface appInterface, String str);

    void reportForPublicAccountExposure(String str);

    void reportPAShareButtonEvent(String str);

    void reportPAShareItemEvent(int i3, String str, int i16);

    void reportPAShareItemEvent(int i3, String str, String str2, String str3, String str4);

    void resetDeleteOldKandian();

    void sendDetailInfoRequest(AppInterface appInterface, Context context, String str);

    void sendReadConfirm(BaseQQAppInterface baseQQAppInterface, String str);

    void setComeFromReadInJoy(boolean z16);

    long setInPublicAccountFolder(long j3, boolean z16);

    void setLSAccountDetailRequestHandler(Handler handler);

    boolean shouldPreloadWebProcess(String str);

    boolean showPubAccUin(AppInterface appInterface);

    void unfollowUin(AppInterface appInterface, Context context, String str, boolean z16, IPublicAccountObserver iPublicAccountObserver);

    void unfollowUin(AppInterface appInterface, Context context, String str, boolean z16, IPublicAccountObserver iPublicAccountObserver, boolean z17);

    void updateDeleteOldKandian(AppInterface appInterface, boolean z16);

    void updateRecentList(BaseQQAppInterface baseQQAppInterface);

    void videoPlayRealtimeReport(String str, String str2, int i3, int i16);
}
