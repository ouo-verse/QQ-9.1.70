package com.tencent.mobileqq.mini.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppObserver implements BusinessObserver {
    public static final int MINI_APP_ADD_PHONE_NUMBER = 1073;
    public static final int MINI_APP_BATCH_GET_CONTACT = 1039;
    public static final int MINI_APP_BATCH_GET_GAME_FOLLOW_COUNT = 1091;
    public static final int MINI_APP_BATCH_GET_USER_INFO = 1028;
    public static final int MINI_APP_BATCH_QUERY_APP_INFO = 1013;
    public static final int MINI_APP_BOOKSHIEF_INSERT = 1080;
    public static final int MINI_APP_BOOKSHIEF_QUERY = 1081;
    public static final int MINI_APP_BOOKSHIEF_UPDATE = 1082;
    static final int MINI_APP_CHANGE_SHARE_IMAGE_URL = 1029;
    public static final int MINI_APP_CHECK_BINDING_STATE = 1083;
    public static final int MINI_APP_CHECK_NAVIGATE_RIGHT = 1023;
    public static final int MINI_APP_CHECK_OFFER_ID = 1021;
    public static final int MINI_APP_CHECK_SESSION = 1002;
    public static final int MINI_APP_CREATE_UPDATABLE_MSG = 1076;
    public static final int MINI_APP_DC_REPORT = 1005;
    public static final int MINI_APP_DEL_ITEM = 1006;
    public static final int MINI_APP_DEL_PHONE_NUMBER = 1074;
    public static final int MINI_APP_DO_GAME_RAFFLE = 1090;
    public static final int MINI_APP_DO_LIKE = 1009;
    public static final int MINI_APP_GENERAL_CODE = 9000;
    public static final int MINI_APP_GET_APPINFO_BY_ID = 1024;
    public static final int MINI_APP_GET_APPINFO_BY_ID_FOR_SDK = 1055;
    public static final int MINI_APP_GET_APPINFO_BY_LINK = 1003;
    public static final int MINI_APP_GET_APPINFO_BY_LINK_FOR_SDK = 1056;
    public static final int MINI_APP_GET_AUTH_LIST = 1043;
    public static final int MINI_APP_GET_CM_SHOW_INFO = 1088;
    public static final int MINI_APP_GET_CONETNT_ACCELERATE = 1070;
    public static final int MINI_APP_GET_CONTAINER_INFO_BY_ID_FOR_SDK = 1100;
    public static final int MINI_APP_GET_EXT_CONFIG_DETAIL = 1040;
    static final int MINI_APP_GET_FORM_ID = 1020;
    public static final int MINI_APP_GET_FRIEND_CLOUD_STORAGE = 1019;
    public static final int MINI_APP_GET_GAME_BOX_OPTIONS = 1103;
    public static final int MINI_APP_GET_GAME_RAFFLE_MATERIAL = 1089;
    public static final int MINI_APP_GET_GAME_TASK_TICKET = 1098;
    public static final int MINI_APP_GET_GROUP_CLOUD_STORAGE = 1018;
    public static final int MINI_APP_GET_GROUP_SHARE_INFO = 1033;
    public static final int MINI_APP_GET_HOT_SEARCH_APPS = 1071;
    public static final int MINI_APP_GET_HOT_SEARCH_APPS_V2 = 1101;
    public static final int MINI_APP_GET_KUOLIE_APPLIST = 1044;
    public static final int MINI_APP_GET_LAUNCH_CONFIG = 1099;
    public static final int MINI_APP_GET_LOGIN_CODE = 1000;
    public static final int MINI_APP_GET_MATERIAL_RELEVANT_APP = 1031;
    public static final int MINI_APP_GET_NATIVE_APPINFO = 1030;
    public static final int MINI_APP_GET_NEW_BASELIB = 1004;
    public static final int MINI_APP_GET_NEW_BASELIB_FOR_SDK = 1057;
    public static final int MINI_APP_GET_PHONE_NUMBER = 1053;
    public static final int MINI_APP_GET_POTENTIAL_FRIEND_LIST = 1060;
    public static final int MINI_APP_GET_PROFILE = 1001;
    public static final int MINI_APP_GET_REACTIVE_FRIEND_LIST = 1084;
    public static final int MINI_APP_GET_RECOMMEND_APP_LIST = 1048;
    public static final int MINI_APP_GET_REWARDED_VIDEO_AD_RESULT = 1027;
    public static final int MINI_APP_GET_ROBOT_UIN = 1045;
    public static final int MINI_APP_GET_SHARE_INFO = 1012;
    static final int MINI_APP_GET_STORE_APP_LIST = 1022;
    public static final int MINI_APP_GET_SWITCH_LIST = 1049;
    public static final int MINI_APP_GET_TCB_TICKET = 1046;
    public static final int MINI_APP_GET_TEENAGER_CONFIG = 1093;
    public static final int MINI_APP_GET_USER_APP_INFO = 1008;
    public static final int MINI_APP_GET_USER_APP_LIST = 1010;
    public static final int MINI_APP_GET_USER_APP_LIST_V2 = 1047;
    public static final int MINI_APP_GET_USER_APP_LIST_V3 = 1105;
    public static final int MINI_APP_GET_USER_CLOUD_STORAGE = 1016;
    public static final int MINI_APP_GET_USER_GROUP_INFO = 1062;
    public static final int MINI_APP_GET_USER_HEALTH_DATA = 1041;
    public static final int MINI_APP_GET_USER_INFO_EXTRA = 1032;
    public static final int MINI_APP_GET_USER_INTERACTIVE_STORAGE_SERVLET = 1059;
    public static final int MINI_APP_GET_USER_ROLE_GROUP = 1097;
    public static final int MINI_APP_GET_USER_SETTING = 1051;
    public static final int MINI_APP_GET_VIP_WITHOUT_AD_MEMBER_STATE = 1102;
    public static final int MINI_APP_GET_WEIXIN_SDK_APPINFO = 1092;
    public static final int MINI_APP_GET_WX_APP_URL = 1095;
    public static final int MINI_APP_LOCAL_SEARCH_DATA = 1011;
    public static final int MINI_APP_MIDAS_CONSUME_RESULT = 1025;
    public static final int MINI_APP_MIDAS_QUERY_RESULT = 1026;
    public static final int MINI_APP_MODIFY_FRIEND_INTERACTIVE_STORAGE_SERVLET = 1058;
    public static final int MINI_APP_OPEN_CHANNEL = 1054;
    public static final int MINI_APP_REAL_TIME_LOG_REPORT = 1075;
    public static final int MINI_APP_REJECT_FREQUENTLY_RECOMMENDS = 1085;
    public static final int MINI_APP_REMOVE_USER_CLOUD_STORAGE = 1017;
    public static final int MINI_APP_REPORT_LOG_FILE_URL = 1035;
    public static final int MINI_APP_REPORT_SHARE = 1063;
    public static final int MINI_APP_SEARCH_APP = 1072;
    public static final int MINI_APP_SEARCH_GUESS_YOU_LIKE = 1086;
    public static final int MINI_APP_SEND_ARK_MSG = 1061;
    public static final int MINI_APP_SET_AUTH = 1042;
    public static final int MINI_APP_SET_AVATAR = 1034;
    public static final int MINI_APP_SET_CM_SHOW_PET_STATUS = 1087;
    public static final int MINI_APP_SET_GAME_BOX_OPTIONS = 1104;
    public static final int MINI_APP_SET_TOP = 1007;
    public static final int MINI_APP_SET_USER_CLOUD_STORAGE = 1015;
    public static final int MINI_APP_SET_USER_SWITCH = 1050;
    public static final int MINI_APP_SET_WX_APP_INFO = 1096;
    public static final int MINI_APP_SET_WX_APP_URL = 1094;
    public static final int MINI_APP_TRANS_FOR_ROOM_ID = 1037;
    public static final int MINI_APP_TRANS_FOR_TINY_ID = 1036;
    public static final int MINI_APP_UPDATE_USER_SETTING = 1052;
    public static final int MINI_APP_USE_USER_APP = 1014;
    public static final int MINI_APP_VERIFY_PLUGIN = 1038;
    public static final int MINI_APP_WX_PAY_CHECK_URL = 1077;
    public static final String TAG = "[mini] MiniAppObserver";

    @Override // mqq.observer.BusinessObserver
    public void onReceive(final int i3, final boolean z16, final Bundle bundle) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppObserver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MiniAppObserver.this.doOnReceive(i3, z16, bundle);
                } catch (Throwable th5) {
                    QLog.e(MiniAppObserver.TAG, 1, "MiniAppObserver onReceive exception!", th5);
                }
            }
        }, 16, null, false);
    }

    public static String getCmdByObserverId(int i3) {
        if (9000 == i3) {
            return "MINI_APP_GENERAL_CODE";
        }
        if (1000 == i3) {
            return "MINI_APP_GET_LOGIN_CODE";
        }
        if (1001 == i3) {
            return "MINI_APP_GET_PROFILE";
        }
        if (1002 == i3) {
            return "MINI_APP_CHECK_SESSION";
        }
        if (1003 == i3) {
            return "MINI_APP_GET_APPINFO_BY_LINK";
        }
        if (1004 == i3) {
            return "MINI_APP_GET_NEW_BASELIB";
        }
        if (1005 == i3) {
            return "MINI_APP_DC_REPORT";
        }
        if (1006 == i3) {
            return "MINI_APP_DEL_ITEM";
        }
        if (1007 == i3) {
            return "MINI_APP_SET_TOP";
        }
        if (1009 == i3) {
            return "MINI_APP_DO_LIKE";
        }
        if (1010 == i3) {
            return "MINI_APP_GET_USER_APP_LIST";
        }
        if (1011 == i3) {
            return "MINI_APP_LOCAL_SEARCH_DATA";
        }
        if (1012 == i3) {
            return "MINI_APP_GET_SHARE_INFO";
        }
        if (1013 == i3) {
            return "MINI_APP_BATCH_QUERY_APP_INFO";
        }
        if (1014 == i3) {
            return "MINI_APP_USE_USER_APP";
        }
        if (1015 == i3) {
            return "MINI_APP_SET_USER_CLOUD_STORAGE";
        }
        if (1016 == i3) {
            return "MINI_APP_GET_USER_CLOUD_STORAGE";
        }
        if (1017 == i3) {
            return "MINI_APP_REMOVE_USER_CLOUD_STORAGE";
        }
        if (1018 == i3) {
            return "MINI_APP_GET_GROUP_CLOUD_STORAGE";
        }
        if (1019 == i3) {
            return "MINI_APP_GET_FRIEND_CLOUD_STORAGE";
        }
        if (1020 == i3) {
            return "MINI_APP_GET_FORM_ID";
        }
        if (1021 == i3) {
            return "MINI_APP_CHECK_OFFER_ID";
        }
        if (1022 == i3) {
            return "MINI_APP_GET_STORE_APP_LIST";
        }
        if (1023 == i3) {
            return "MINI_APP_CHECK_NAVIGATE_RIGHT";
        }
        if (1024 == i3) {
            return "MINI_APP_GET_APPINFO_BY_ID";
        }
        if (1025 == i3) {
            return "MINI_APP_MIDAS_CONSUME_RESULT";
        }
        if (1026 == i3) {
            return "MINI_APP_MIDAS_QUERY_RESULT";
        }
        if (1027 == i3) {
            return "MINI_APP_GET_REWARDED_VIDEO_AD_RESULT";
        }
        if (1028 == i3) {
            return "MINI_APP_BATCH_GET_USER_INFO";
        }
        if (1029 == i3) {
            return "MINI_APP_CHANGE_SHARE_IMAGE_URL";
        }
        if (1030 == i3) {
            return "MINI_APP_GET_NATIVE_APPINFO";
        }
        if (1032 == i3) {
            return "MINI_APP_GET_USER_INFO_EXTRA";
        }
        if (1033 == i3) {
            return "MINI_APP_GET_GROUP_SHARE_INFO";
        }
        if (1034 == i3) {
            return "MINI_APP_SET_AVATAR";
        }
        if (1035 == i3) {
            return "MINI_APP_REPORT_LOG_FILE_URL";
        }
        if (1040 == i3) {
            return "MINI_APP_GET_EXT_CONFIG_DETAIL";
        }
        if (1051 == i3) {
            return "MINI_APP_GET_USER_SETTING";
        }
        if (1049 == i3) {
            return "MINI_APP_GET_SWITCH_LIST";
        }
        if (1050 == i3) {
            return "MINI_APP_SET_USER_SWITCH";
        }
        if (1046 == i3) {
            return "MINI_APP_GET_TCB_TICKET";
        }
        if (1047 == i3) {
            return "MINI_APP_GET_USER_APP_LIST_V2";
        }
        if (1105 == i3) {
            return "MINI_APP_GET_USER_APP_LIST_V3";
        }
        if (1048 == i3) {
            return "MINI_APP_GET_RECOMMEND_APP_LIST";
        }
        if (1038 == i3) {
            return "MINI_APP_VERIFY_PLUGIN";
        }
        if (1039 == i3) {
            return "MINI_APP_BATCH_GET_CONTACT";
        }
        if (1008 == i3) {
            return "MINI_APP_GET_USER_APP_INFO";
        }
        if (1036 == i3) {
            return "MINI_APP_TRANS_FOR_TINY_ID";
        }
        if (1037 == i3) {
            return "MINI_APP_TRANS_FOR_ROOM_ID";
        }
        if (1041 == i3) {
            return "MINI_APP_GET_USER_HEALTH_DATA";
        }
        if (1042 == i3) {
            return "MINI_APP_SET_AUTH";
        }
        if (1043 == i3) {
            return "MINI_APP_GET_AUTH_LIST";
        }
        if (1044 == i3) {
            return "MINI_APP_GET_KUOLIE_APPLIST";
        }
        if (1045 == i3) {
            return "MINI_APP_GET_ROBOT_UIN";
        }
        if (1054 == i3) {
            return "MINI_APP_OPEN_CHANNEL";
        }
        if (1055 == i3) {
            return "MINI_APP_GET_APPINFO_BY_ID_FOR_SDK";
        }
        if (1100 == i3) {
            return "MINI_APP_GET_CONTAINER_INFO_BY_ID_FOR_SDK";
        }
        if (1056 == i3) {
            return "MINI_APP_GET_APPINFO_BY_LINK_FOR_SDK";
        }
        if (1057 == i3) {
            return "MINI_APP_GET_NEW_BASELIB_FOR_SDK";
        }
        if (1058 == i3) {
            return "MINI_APP_MODIFY_FRIEND_INTERACTIVE_STORAGE_SERVLET";
        }
        if (1059 == i3) {
            return "MINI_APP_GET_USER_INTERACTIVE_STORAGE_SERVLET";
        }
        if (1060 == i3) {
            return "MINI_APP_GET_POTENTIAL_FRIEND_LIST";
        }
        if (1061 == i3) {
            return "MINI_APP_SEND_ARK_MSG";
        }
        if (1062 == i3) {
            return "MINI_APP_GET_USER_GROUP_INFO";
        }
        if (1063 == i3) {
            return "MINI_APP_REPORT_SHARE";
        }
        if (1070 == i3) {
            return "MINI_APP_GET_CONETNT_ACCELERATE";
        }
        if (1071 == i3) {
            return "MINI_APP_GET_HOT_SEARCH_APPS";
        }
        if (1101 == i3) {
            return "MINI_APP_GET_HOT_SEARCH_APPS_V2";
        }
        if (1072 == i3) {
            return "MINI_APP_SEARCH_APP";
        }
        if (1073 == i3) {
            return "MINI_APP_ADD_PHONE_NUMBER";
        }
        if (1074 == i3) {
            return "MINI_APP_DEL_PHONE_NUMBER";
        }
        if (1075 == i3) {
            return "MINI_APP_REAL_TIME_LOG_REPORT";
        }
        if (1077 == i3) {
            return "MINI_APP_WX_PAY_CHECK_URL";
        }
        if (1083 == i3) {
            return "MINI_APP_CHECK_BINDING_STATE";
        }
        if (1087 == i3) {
            return "MINI_APP_SET_CM_SHOW_PET_STATUS";
        }
        if (1088 == i3) {
            return "MINI_APP_GET_CM_SHOW_INFO";
        }
        if (1084 == i3) {
            return "MINI_APP_GET_REACTIVE_FRIEND_LIST";
        }
        if (1086 == i3) {
            return "MINI_APP_SEARCH_GUESS_YOU_LIKE";
        }
        if (1089 == i3) {
            return "MINI_APP_GET_GAME_RAFFLE_MATERIAL";
        }
        if (1090 == i3) {
            return "MINI_APP_DO_GAME_RAFFLE";
        }
        if (1091 == i3) {
            return "MINI_APP_BATCH_GET_GAME_FOLLOW_COUNT";
        }
        if (1092 == i3) {
            return "MINI_APP_GET_WEIXIN_SDK_APPINFO";
        }
        if (1093 == i3) {
            return "MINI_APP_GET_TEENAGER_CONFIG";
        }
        if (1094 == i3) {
            return "MINI_APP_SET_WX_APP_URL";
        }
        if (1095 == i3) {
            return "MINI_APP_GET_WX_APP_URL";
        }
        if (1096 == i3) {
            return "MINI_APP_SET_WX_APP_INFO";
        }
        if (1098 == i3) {
            return "MINI_APP_GET_GAME_TASK_TICKET";
        }
        if (1099 == i3) {
            return "MINI_APP_GET_LAUNCH_CONFIG";
        }
        if (1102 == i3) {
            return "MINI_APP_GET_VIP_WITHOUT_AD_MEMBER_STATE";
        }
        return "default cmd";
    }

    public void doOnReceive(int i3, boolean z16, Bundle bundle) {
        if (bundle == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onReceive data is null");
                return;
            }
            return;
        }
        int i16 = bundle.getInt(MiniAppCmdUtil.KEY_INDEX, -1);
        String string = bundle.getString("key_appid");
        if (i3 == 9000) {
            onGetGeneralCmdFin(i16, bundle.getLong("retCode"), bundle.getByteArray(MiniAppCmdUtil.KEY_RSP_DATA), bundle.getString("errMsg"));
        } else {
            if (i3 != 1000) {
                if (i3 == 1001) {
                    onGetProfileFin(i16, string, z16, bundle.getString("nick"), bundle.getString("avatar"), bundle.getInt("gender"), bundle.getString("country"), bundle.getString("province"), bundle.getString("city"), bundle.getString(IjkMediaMeta.IJKM_KEY_LANGUAGE), bundle.getString("rawData", ""), bundle.getString("signature", ""), bundle.getString(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, ""), bundle.getString("iv", ""), bundle.getLong("retCode", -1L), bundle.getString("errMsg", ""));
                    return;
                }
                if (i3 == 1002) {
                    onCheckSessionFin(i16, z16, (int) bundle.getLong("ret"), bundle.getString("errMsg"));
                    return;
                }
                if (i3 == 1003) {
                    onGetAppInfoByLinkFin(i16, z16, bundle);
                    return;
                }
                if (i3 == 1004) {
                    onGetNewBaseLibFin(i16, z16, bundle.getString("version"), bundle.getString("downloadUrl"), bundle);
                    return;
                }
                if (i3 == 1005) {
                    onDcReport(i16, z16, bundle.getInt("ret"));
                    return;
                }
                if (i3 == 1006) {
                    onDelMiniAppFin(i16, z16, bundle);
                    return;
                }
                if (i3 == 1007) {
                    onSetTopMiniAppFin(i16, z16, bundle);
                    return;
                }
                if (i3 == 1008) {
                    onGetUserAppInfoFin(i16, z16, bundle);
                    return;
                }
                if (i3 == 1009) {
                    onSetUserAppLikeFin(i16, z16, bundle);
                    return;
                }
                if (i3 == 1010) {
                    onGetUserAppList(i16, z16, bundle);
                    return;
                }
                if (i3 == 1011) {
                    onLocalSearchDataFin(i16, z16, bundle);
                    return;
                }
                if (i3 == 1012) {
                    onGetShareInfo(i16, z16, bundle);
                    return;
                }
                if (i3 == 1029) {
                    onChangeShareImageUrl(i16, z16, bundle);
                    return;
                }
                if (i3 == 1013) {
                    onBatchQueryAppInfoFin(i16, z16, bundle);
                    return;
                }
                if (i3 == 1014) {
                    onUseUserAppFin(i16, z16, bundle);
                    return;
                }
                if (i3 == 1015) {
                    onSetuserCloudStorage(i16, z16);
                    return;
                }
                if (i3 == 1017) {
                    onRemoveuserCloudStorage(i16, z16);
                    return;
                }
                if (i3 == 1016) {
                    onGetuserCloudStorage(i16, z16, bundle);
                    return;
                }
                if (i3 == 1018) {
                    onGetGroupCloudStorage(i16, z16, bundle);
                    return;
                }
                if (i3 == 1019) {
                    onGetFriendCloudStorage(i16, z16, bundle);
                    return;
                }
                if (i3 == 1020) {
                    onGetFormId(i16, z16, bundle);
                    return;
                }
                if (i3 == 1021) {
                    onCheckOfferIdFin(i16, z16, bundle);
                    return;
                }
                if (i3 == 1022) {
                    onGetStoreAppList(i16, z16, bundle);
                    return;
                }
                if (i3 == 1023) {
                    onCheckNavigateRightServlet(i16, z16, bundle);
                    return;
                }
                if (i3 == 1024) {
                    onGetAppInfoByIdServlet(i16, z16, bundle);
                    return;
                }
                if (i3 == 1025) {
                    onGetMidasConsumeResult(i16, z16, bundle);
                    return;
                }
                if (i3 == 1026) {
                    onGetMidasQueryResult(i16, z16, bundle);
                    return;
                }
                if (i3 == 1027) {
                    onGetRewardedVideoAdResult(i16, z16, bundle);
                    return;
                }
                if (i3 == 1028) {
                    onBatchGetUserInfoResult(i16, z16, bundle);
                    return;
                }
                if (i3 == 1030) {
                    onGetNativeAppInfoForJump(i16, z16, bundle);
                    return;
                }
                if (i3 == 1032) {
                    onGetUserInfoExtra(i16, z16, bundle);
                    return;
                }
                if (i3 == 1033) {
                    onGetGroupShareInfo(i16, z16, bundle);
                    return;
                }
                if (i3 == 1034) {
                    onSetAvatar(i16, z16, bundle);
                    return;
                }
                if (i3 == 1035) {
                    onReportLogFileUrlServlet(i16, z16, bundle);
                    return;
                }
                if (i3 == 1036) {
                    onTransForOpenIdAndTinyId(i16, z16, bundle);
                    return;
                }
                if (i3 == 1037) {
                    onTransForRoomId(i16, z16, bundle);
                    return;
                }
                if (i3 == 1039) {
                    onBatchGetContact(i16, z16, bundle);
                    return;
                }
                if (i3 == 1038) {
                    onVerifyPlugin(i16, z16, bundle);
                    return;
                }
                if (i3 == 1040) {
                    onGetExtConfigDetail(i16, z16, bundle);
                    return;
                }
                if (i3 == 1041) {
                    onGetUserHealthData(i16, z16, bundle);
                    return;
                }
                if (i3 == 1042) {
                    onSetAuth(i16, z16, bundle);
                    return;
                }
                if (i3 == 1043) {
                    onGetAuthList(i16, z16, bundle);
                    return;
                }
                if (i3 == 1044) {
                    onGetKuolieAppListServlet(i16, z16, bundle);
                    return;
                }
                if (i3 == 1045) {
                    onGetRobotUin(i16, z16, bundle);
                    return;
                }
                if (i3 == 1046) {
                    onGetTcbTicket(i16, z16, bundle);
                    return;
                }
                if (i3 == 1047) {
                    onGetUserAppListV2(i16, z16, bundle);
                    return;
                }
                if (i3 == 1105) {
                    onGetUserAppListV3(i16, z16, bundle);
                    return;
                }
                if (i3 == 1048) {
                    onGetRecommendAppList(i16, z16, bundle);
                    return;
                }
                if (i3 == 1049) {
                    onGetSwitchList(i16, z16, bundle);
                    return;
                }
                if (i3 == 1050) {
                    onSetUserSwitch(i16, z16, bundle);
                    return;
                }
                if (i3 == 1051) {
                    onGetUserSetting(i16, z16, bundle);
                    return;
                }
                if (i3 == 1052) {
                    onUpdateUserSetting(i16, z16, bundle);
                    return;
                }
                if (i3 == 1053) {
                    onGetPhoneNumber(i16, z16, bundle);
                    return;
                }
                if (i3 == 1054) {
                    onOpenChannel(i16, z16, bundle);
                    return;
                }
                if (i3 == 1055) {
                    onGetAppInfoByIdForSDKServlet(i16, z16, bundle);
                    return;
                }
                if (i3 == 1100) {
                    onGetContainerInfoByIdForSDKServlet(i16, z16, bundle);
                    return;
                }
                if (i3 == 1056) {
                    onGetAppInfoByLinkFinForSDK(i16, z16, bundle);
                    return;
                }
                if (i3 == 1057) {
                    onGetNewBaseLibFinForSDK(i16, z16, bundle.getString("version"), bundle.getString("downloadUrl"), bundle);
                    return;
                }
                if (i3 == 1058) {
                    onModifyFriendInteractiveStorage(i16, z16, bundle);
                    return;
                }
                if (i3 == 1059) {
                    onGetUserInteractiveStorage(i16, z16, bundle);
                    return;
                }
                if (i3 == 1060) {
                    onGetPotentialFriendList(i16, z16, bundle);
                    return;
                }
                if (i3 == 1061) {
                    onSendArkMsg(i16, z16, bundle);
                    return;
                }
                if (i3 == 1062) {
                    onGetUserGroupInfo(i16, z16, bundle);
                    return;
                }
                if (i3 == 1063) {
                    onReportShare(i16, z16, bundle);
                    return;
                }
                if (i3 == 1070) {
                    onGetContentAccelerateServlet(i16, z16, bundle);
                    return;
                }
                if (i3 == 1071) {
                    onGetHotSearchApps(i16, z16, bundle);
                    return;
                }
                if (i3 == 1101) {
                    onGetHotSearchAppsV2(i16, z16, bundle);
                    return;
                }
                if (i3 == 1072) {
                    onSearchApp(i16, z16, bundle);
                    return;
                }
                if (i3 == 1075) {
                    onRealTimeLogReport(i16, z16, bundle);
                    return;
                }
                if (i3 == 1076) {
                    onCreateUpdatableMsgResult(i16, z16, bundle);
                    return;
                }
                if (i3 == 1073) {
                    onAddPhoneNumber(i16, z16, bundle);
                    return;
                }
                if (i3 == 1074) {
                    onDelPhoneNumber(i16, z16, bundle);
                    return;
                }
                if (i3 == 1077) {
                    onWxPayCheckUrlResult(i16, z16, bundle);
                    return;
                }
                if (i3 == 1080) {
                    onBookShelfInsertResult(i16, z16, bundle);
                    return;
                }
                if (i3 == 1081) {
                    onBookShelfQueryResult(i16, z16, bundle);
                    return;
                }
                if (i3 == 1082) {
                    onBookShelfUpdateResult(i16, z16, bundle);
                    return;
                }
                if (i3 == 1083) {
                    onCheckBindingState(i16, z16, bundle);
                    return;
                }
                if (i3 == 1087) {
                    onSetCMShowPetStatus(i16, z16, bundle);
                    return;
                }
                if (i3 == 1088) {
                    onGetCMShowInfo(i16, z16, bundle);
                    return;
                }
                if (i3 == 1084) {
                    onGetReactiveFriendList(i16, z16, bundle);
                    return;
                }
                if (i3 == 1085) {
                    onRejectFrequentlyRecommends(i16, z16, bundle);
                    return;
                }
                if (i3 == 1086) {
                    onGuessYouLike(i16, z16, bundle);
                    return;
                }
                if (i3 == 1089) {
                    onGetGameRaffleMaterial(i16, z16, bundle);
                    return;
                }
                if (i3 == 1090) {
                    onDoGameRaffle(i16, z16, bundle);
                    return;
                }
                if (i3 == 1091) {
                    onBatchGetFollowingCount(i16, z16, bundle);
                    return;
                }
                if (i3 == 1092) {
                    onGetWeixinSDKAppInfoFin(i16, z16, bundle);
                    return;
                }
                if (i3 == 1093) {
                    onGetTeenagerConfig(i16, z16, bundle);
                    return;
                }
                if (i3 == 1094) {
                    onSetWxAppUrlResponse(i16, z16, bundle);
                    return;
                }
                if (i3 == 1095) {
                    onGetWxAppUrlResponse(i16, z16, bundle);
                    return;
                }
                if (i3 == 1096) {
                    onSetWxAppInfoResponse(i16, z16, bundle);
                    return;
                }
                if (i3 == 1098) {
                    onGetGameTaskTicket(i16, z16, bundle);
                    return;
                }
                if (i3 == 1099) {
                    onGetConfigAfterLaunchGame(i16, z16, bundle);
                    return;
                }
                if (i3 == 1102) {
                    onGetVipWithoutAdMemberState(i16, z16, bundle);
                    return;
                } else if (i3 == 1103) {
                    onGetGameBoxOptions(i16, z16, bundle);
                    return;
                } else {
                    if (i3 == 1104) {
                        onSetGameBoxOptions(i16, z16, bundle);
                        return;
                    }
                    return;
                }
            }
            onGetLoginCodeFin(i16, z16, bundle.getString("code"), bundle.getLong("retCode", -1L), bundle.getString("errMsg", ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetProfileFin(int i3, String str, boolean z16, String str2, String str3, int i16, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j3, String str12) {
    }

    protected void onRemoveuserCloudStorage(int i3, boolean z16) {
    }

    protected void onSetuserCloudStorage(int i3, boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAddPhoneNumber(int i3, boolean z16, Bundle bundle) {
    }

    protected void onBatchGetContact(int i3, boolean z16, Bundle bundle) {
    }

    protected void onBatchGetFollowingCount(int i3, boolean z16, Bundle bundle) {
    }

    protected void onBatchGetUserInfoResult(int i3, boolean z16, Bundle bundle) {
    }

    protected void onBatchQueryAppInfoFin(int i3, boolean z16, Bundle bundle) {
    }

    protected void onBookShelfInsertResult(int i3, boolean z16, Bundle bundle) {
    }

    protected void onBookShelfQueryResult(int i3, boolean z16, Bundle bundle) {
    }

    protected void onBookShelfUpdateResult(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeShareImageUrl(int i3, boolean z16, Bundle bundle) {
    }

    protected void onCheckBindingState(int i3, boolean z16, Bundle bundle) {
    }

    protected void onCheckNavigateRightServlet(int i3, boolean z16, Bundle bundle) {
    }

    protected void onCheckOfferIdFin(int i3, boolean z16, Bundle bundle) {
    }

    protected void onCreateUpdatableMsgResult(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDcReport(int i3, boolean z16, int i16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDelMiniAppFin(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDelPhoneNumber(int i3, boolean z16, Bundle bundle) {
    }

    protected void onDoGameRaffle(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetAppInfoByIdForSDKServlet(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetAppInfoByIdServlet(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetAppInfoByLinkFin(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetAppInfoByLinkFinForSDK(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetAuthList(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetCMShowInfo(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetConfigAfterLaunchGame(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetContainerInfoByIdForSDKServlet(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetContentAccelerateServlet(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetExtConfigDetail(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetFormId(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetFriendCloudStorage(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetGameBoxOptions(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetGameRaffleMaterial(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetGameTaskTicket(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetGroupCloudStorage(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetGroupShareInfo(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetHotSearchApps(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetHotSearchAppsV2(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetKuolieAppListServlet(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetMidasConsumeResult(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetMidasQueryResult(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetNativeAppInfoForJump(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetPhoneNumber(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetPotentialFriendList(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetReactiveFriendList(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetRecommendAppList(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetRewardedVideoAdResult(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetRobotUin(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetShareInfo(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetStoreAppList(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetSwitchList(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetTcbTicket(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetTeenagerConfig(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetUserAppInfoFin(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetUserAppList(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetUserAppListV2(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetUserAppListV3(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetUserGroupInfo(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetUserHealthData(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetUserInfoExtra(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetUserInteractiveStorage(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetUserSetting(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetVipWithoutAdMemberState(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetWeixinSDKAppInfoFin(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetWxAppUrlResponse(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGetuserCloudStorage(int i3, boolean z16, Bundle bundle) {
    }

    protected void onGuessYouLike(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLocalSearchDataFin(int i3, boolean z16, Bundle bundle) {
    }

    protected void onModifyFriendInteractiveStorage(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onOpenChannel(int i3, boolean z16, Bundle bundle) {
    }

    protected void onRealTimeLogReport(int i3, boolean z16, Bundle bundle) {
    }

    protected void onRejectFrequentlyRecommends(int i3, boolean z16, Bundle bundle) {
    }

    protected void onReportLogFileUrlServlet(int i3, boolean z16, Bundle bundle) {
    }

    protected void onReportShare(int i3, boolean z16, Bundle bundle) {
    }

    protected void onSearchApp(int i3, boolean z16, Bundle bundle) {
    }

    protected void onSendArkMsg(int i3, boolean z16, Bundle bundle) {
    }

    protected void onSetAuth(int i3, boolean z16, Bundle bundle) {
    }

    protected void onSetAvatar(int i3, boolean z16, Bundle bundle) {
    }

    protected void onSetCMShowPetStatus(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetGameBoxOptions(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetTopMiniAppFin(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetUserAppLikeFin(int i3, boolean z16, Bundle bundle) {
    }

    protected void onSetUserSwitch(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetWxAppInfoResponse(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetWxAppUrlResponse(int i3, boolean z16, Bundle bundle) {
    }

    protected void onTransForOpenIdAndTinyId(int i3, boolean z16, Bundle bundle) {
    }

    protected void onTransForRoomId(int i3, boolean z16, Bundle bundle) {
    }

    protected void onUpdateUserSetting(int i3, boolean z16, Bundle bundle) {
    }

    protected void onUseUserAppFin(int i3, boolean z16, Bundle bundle) {
    }

    protected void onVerifyPlugin(int i3, boolean z16, Bundle bundle) {
    }

    protected void onWxPayCheckUrlResult(int i3, boolean z16, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCheckSessionFin(int i3, boolean z16, int i16, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetGeneralCmdFin(int i3, long j3, byte[] bArr, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetLoginCodeFin(int i3, boolean z16, String str, long j3, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetNewBaseLibFin(int i3, boolean z16, String str, String str2, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetNewBaseLibFinForSDK(int i3, boolean z16, String str, String str2, Bundle bundle) {
    }
}
