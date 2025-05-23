package com.tencent.biz.pubaccount.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp$ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountMenuResponse;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountManager extends QRouteApi {
    public static final String CMD_GET_RECVMSG_STATE = "ConfigSvc.getRecvMsgState";
    public static final String CMD_SET_RECVMSG_STATE = "ConfigSvc.setRecvMsgState";
    public static final String MENU_CACHE_TIME = "menuCacheTime";
    public static final String MENU_EVENT_SHAREPRE = "menuEventSharePre";
    public static final int MENU_TYPE_3x5 = 0;
    public static final int MENU_TYPE_ICON = 1;
    public static final int MENU_TYPE_TEXT = 2;
    public static final int MENU_UPDATE_NEXTTIME = 2;
    public static final int MENU_UPDATE_NOW = 1;
    public static final String MENU_UPDATE_TYPE = "update_type";
    public static final String PA_ACTION_LOCATION_RESULT = "com.tencent.biz.pubaccount.locationResultAction";
    public static final String PA_ACTION_PIC_RESULT = "com.tencent.biz.pubaccount.picResultAction";
    public static final String PA_ACTION_SCAN_RESULT = "com.tencent.biz.pubaccount.scanResultAction";
    public static final String PA_DATA_LOCATION_LATITUDE = "latitude";
    public static final String PA_DATA_LOCATION_LONGITUDE = "longitude";
    public static final String PA_DATA_LOCATION_NAME = "name";
    public static final String PA_DATA_PIC_RESULT = "com.tencent.biz.pubaccount.picResultData";
    public static final String PA_DATA_PIC_RESULT_FILEMD5S = "com.tencent.biz.pubaccount.picResult_md5s";
    public static final String PA_DATA_SCAN_RESULT = "com.tencent.biz.pubaccount.scanResultData";
    public static final String PA_DATA_SCAN_RESULT_TYPE = "com.tencent.biz.pubaccount.scanResultType";
    public static final String PA_PERMISSION_BROADCAST = "com.tencent.msg.permission.pushnotify";
    public static final String SSO_COMMAND_ACCOUNT_DETAIL_DYNAMIC_LIST = "pull_account_detail_dynamic_list";
    public static final String SSO_COMMAND_GET_ACCOUNT_MENU = "get_account_menu";
    public static final String SSO_COMMAND_GET_ACCOUNT_MENU_NEW = "CertifiedAccountSvc.certified_account_read.GetAccountMenu";
    public static final String SSO_COMMAND_GET_DETAIL_INFO = "get_detail_info";
    public static final String SSO_COMMAND_GET_FOLLOW = "follow";
    public static final String SSO_COMMAND_GET_FOLLOW_LIST = "get_follow_list";
    public static final String SSO_COMMAND_GET_FOLLOW_LIST_NEW = "CertifiedAccountSvc.certified_account_read.GetFollowList";
    public static final String SSO_COMMAND_GET_GUIDE_FRIENDS = "getGuideFriends";
    public static final String SSO_COMMAND_GET_RECOMMEND_LIST = "get_business_recommend";
    public static final String SSO_COMMAND_GET_RECV_MSG = "set_recv_msg";
    public static final String SSO_COMMAND_GET_SHARE_LBS = "set_share_lbs";
    public static final String SSO_COMMAND_GET_SHARE_LIST = "get_share_list";
    public static final String SSO_COMMAND_GET_TO_PUBLIC = "share_to_public";
    public static final String SSO_COMMAND_GET_UNFOLLOW = "unfollow";
    public static final String SSO_COMMAND_PREFIX = "PubAccountSvc";
    public static final String SSO_COMMAND_PRE_SEND_MSG_INFO = "send_pre_message_status";
    public static final String SSO_COMMAND_PULL_AIO_HISTORY_MSG = "pull_aio_history_msg";
    public static final String SSO_COMMAND_SEC_MSG_CONFIGS = "secmsg.configs";
    public static final String SSO_COMMAND_SEND_GET_SUBSCRIBE = "get_message_configuration";
    public static final String SSO_COMMAND_SEND_MENU_EVENT = "send_menu_evt";
    public static final String SSO_COMMAND_SEND_MENU_EVENT_NEW = "CertifiedAccountSvc.certified_account_write.SendMenuEvent";
    public static final String SSO_COMMAND_SEND_MSG_RECEIPT = "send_msg_receipt";
    public static final String SSO_COMMAND_SEND_PAY_INFO = "send_pay_info";
    public static final String SSO_COMMAND_SEND_REFUSE_CMD = "set_refuse_follow";
    public static final String SSO_COMMAND_SEND_SET_SUBSCRIBE = "set_message_configuration";
    public static final String SSO_COMMAND_SET_PUBLIC_FLAG = "set_function_flag";
    public static final String TAG = "PublicAccountManager";

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    void addPublicAccountToRu(AppInterface appInterface, String str);

    void clearBroadcastReceiver(Context context);

    void clearOldPublicAccountData(String str);

    mobileqq_mp$ButtonInfo getButtonInfoByMenuId(AppInterface appInterface, String str, int i3);

    String getCurrentUin();

    NewIntent getMenuSetting(Context context, AppInterface appInterface, String str, BusinessObserver businessObserver, boolean z16);

    long getMsgID(AppInterface appInterface, String str);

    int getPublicAccountAioClass(String str, AppInterface appInterface);

    List<mobileqq_mp$ButtonInfo> getPublicAccountMenuButtonList(AppInterface appInterface, String str);

    int getPublicAccountMenuType(String str);

    void handleButtonEvent(String str, Context context, AppInterface appInterface, String str2, int i3, BusinessObserver businessObserver, MqqHandler mqqHandler, int i16, Object obj);

    void handleUrlEvent(Context context, AppInterface appInterface, String str, String str2, String str3);

    void init(Context context, AppInterface appInterface, String str, String str2, a aVar);

    boolean preloadWebProcess(AppInterface appInterface);

    NewIntent refuseFollowAccount(String str, int i3, boolean z16, Context context, AppInterface appInterface, b bVar);

    void refuseFollowAccountCancelCallback(NewIntent newIntent);

    void removeMsgID(AppInterface appInterface, String str);

    void requestQidiKefu(Activity activity, String str, String str2, String str3, String str4, BusinessObserver businessObserver);

    void savePublicAccountMenuSetting(AppInterface appInterface, String str, mobileqq_mp$GetPublicAccountMenuResponse mobileqq_mp_getpublicaccountmenuresponse);

    void sendMenuEventequest(Context context, AppInterface appInterface, String str, String str2, boolean z16, double d16, double d17, BusinessObserver businessObserver);

    void sendMenuEventequest(Context context, AppInterface appInterface, String str, String str2, boolean z16, double d16, double d17, BusinessObserver businessObserver, int i3, long j3, int i16);

    NewIntent sendMsgArriveReceipt(Context context, AppInterface appInterface, long j3, long j16, long j17, long j18, int i3, List<Long> list);

    void setHasPreloadWebProcessor(boolean z16);

    void setKeepOldPublicAccountData(boolean z16);

    void setMsgID(AppInterface appInterface, String str, long j3);
}
