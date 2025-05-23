package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.utils.EnvUtils;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniProgramLpReportDC04239 {
    public static final String AD_ACTION = "ad";
    public static final String AD_RESERVES_CLICK = "click";
    public static final String AD_RESERVES_EXPO_CALL = "expo_call";
    public static final String AD_RESERVES_EXPO_SUCC = "expo_success";
    public static final String AD_RESERVES_PRELOAD_CALL = "preload_call";
    public static final String AD_RESERVES_PRELOAD_FAIL = "preload_fail";
    public static final String AD_RESERVES_PRELOAD_SUCC = "preload_success";
    public static final String AD_RESERVES_REQUEAST_SUCCESS_REALTIME = "request_success_realtime";
    public static final String AD_RESERVES_REQUEST_CALL_CNT = "request_call_cnt";
    public static final String AD_RESERVES_REQUEST_SUCC_OFFLINE = "request_success_offline";
    public static final String AD_RESERVES_REQUEST_SUCC_ONLINE = "request_success_online";
    public static final String AD_RESERVES_REQUEST_TIMEOUT = "request_timeout";
    public static final String AD_RESERVES_SKIP = "skip";
    public static final String AD_RESERVES_SPEC_DOWNLOAD_FAIL = "spec_download_fail";
    public static final String AD_RESERVES_SPEC_DOWNLOAD_SUCCESS = "spec_download_success";
    public static final String AD_RESERVES_SPEC_DOWNLOAD_TIMEOUT = "spec_download_timeout";
    public static final String AD_SUB_ACTION_LOADING_AD = "ad_loading";
    public static final String AIO_CMGAME_ACTION = "cmgame_aio";
    public static final String AIO_CMGAME_C2C_CM_PANEL_SUB_ACTION = "cmgame_aio_cm_c2c";
    public static final String AIO_CMGAME_C2C_SUB_ACTION = "cmgame_aio_c2c";
    public static final String AIO_CMGAME_CM_PANEL_ACTION = "cmgame_aio_cm";
    public static final String AIO_CMGAME_GROUP_CM_PANEL_SUB_ACTION = "cmgame_aio_cm_qun";
    public static final String AIO_CMGAME_GROUP_SUB_ACTION = "cmgame_aio_qun";
    public static final String APP_TYPE_MINI_APP = "0";
    public static final String APP_TYPE_MINI_GAME = "1";
    public static final String ARK_ACTION = "ark";
    public static final String ARK_SUB_ACTION_BATTLE = "ark_battle";
    public static final String COLOR_SIGN_ACTION_CLICK = "click";
    public static final String COLOR_SIGN_ACTION_EXPO = "expo";
    public static final String COLOR_SIGN_ACTION_REMOVE = "remove_ColorSign";
    public static final String COLOR_SIGN_ACTION_TYPE = "addColorSign";
    public static final String COLOR_SIGN_SUB_ACTION_TYPE = "colorSign_enter";
    public static final String DESKTOP_ACTION = "desktop";
    public static final String DESKTOP_COMMONLY_ACTION_TYPE = "desktop";
    public static final String DESKTOP_COMMONLY_SUB_ACTION_TYPE = "commonly";
    public static final String DESKTOP_RESERVES_ACTION_ADD_COMMONLY = "add_commonly";
    public static final String DESKTOP_RESERVES_ACTION_CLICK = "click";
    public static final String DESKTOP_RESERVES_ACTION_CLOSE = "close";
    public static final String DESKTOP_RESERVES_ACTION_EXPO = "expo";
    public static final String DESKTOP_RESERVES_ACTION_SHOW = "show";
    public static final String DESKTOP_SEARCH_ACTION_TYPE = "desktop";
    public static final String DESKTOP_SEARCH_SUB_ACTION_BUTTON = "search_button";
    public static final String DESKTOP_SEARCH_SUB_ACTION_CLICK = "result_click";
    public static final String DESKTOP_SEARCH_SUB_ACTION_EXPOSE = "result_expo";
    public static final String DESKTOP_SEARCH_SUB_ACTION_TYPE = "search";
    public static final String DESKTOP_SUB_ACTION_TYPE_MY_APP = "my_miniprogram";
    public static final String DESKTOP_SUB_ACTION_TYPE_RECENT_APP = "recentplay";
    public static final String DESKTOP_SUB_ACTION_TYPE_SEARCH = "search";
    public static final String DESKTOP_SUB_ACTION_TYPE_SERVICE_EXPRESS = "service_express";
    public static final String DETAIN_DIALOG_ACTION_TYPE = "custom_popup";
    public static final String DETAIN_DIALOG_SUB_ACTION_CLICK_L = "left_icon";
    public static final String DETAIN_DIALOG_SUB_ACTION_CLICK_R = "right_icon";
    public static final String DETAIN_DIALOG_SUB_ACTION_POPUP = "popup";
    public static final String DROP_DOWN_ACTION = "drop_down";
    public static final String DROP_DOWN_RESERVERS_DELETE = "delete";
    public static final String DROP_DOWN_RESERVERS_SETTOP_OFF = "settop_off";
    public static final String DROP_DOWN_RESERVERS_SETTOP_ON = "settop_on";
    public static final String DROP_DOWN_SUB_ACTION_CONTACT = "contact";
    public static final String DROP_DOWN_SUB_ACTION_MESSAGE = "message";
    public static final String DROP_DOWN_SUB_ACTION_MORE = "more";
    public static final String DROP_DOWN_SUB_ACTION_NOTIFICATION = "notification";
    public static final String DROP_DOWN_SUB_ACTION_PULLDOWN = "pulldown";
    public static final String DROP_DOWN_SUB_ACTION_REFRESH = "refresh";
    public static final String DROP_GUIDE_DIALOG_ACTION_TYPE = "xiala_popup";
    public static final String DROP_GUIDE_DIALOG_RESERVES_CLICK = "click";
    public static final String DROP_GUIDE_DIALOG_RESERVES_EXPOSE = "expo";
    public static final String DROP_GUIDE_DIALOG_SUB_ACTION_TYPE = "popup";
    public static final String EXPO_REPORT_ALKAID_PT_KEY = "alkaid_pt";
    public static final String FILE_MATERIAL_ACTION_CLICK = "click";
    public static final String FILE_MATERIAL_ACTION_EXPOSE = "expo";
    public static final String FILE_MATERIAL_ACTION_TYPE = "aio_file";
    public static final String FILE_MATERIAL_SUB_ACTION_LIST = "miniprogram_list";
    public static final String FILE_MATERIAL_SUB_ACTION_MENU = "miniprogram_open";
    public static final String GAME_INNER_ACTION = "game_inner";
    public static final String INNER_SUB_ACTION_LOGIN = "login";
    public static final String INNER_SUB_ACTION_REGISTER = "regist";
    public static final String INTIMATE_PLAY_ACTION = "c2close";
    public static final String KEY_ACTION_TYPE = "actiontype";
    public static final String KEY_RESERVES_ACTION = "reserves_action";
    public static final String KEY_SUB_ACTION_TYPE = "sub_actiontype";
    public static final String MIDAS_ACTION = "midas";
    public static final String MIDAS_RESERVES_OPEN_FAIL = "openfail";
    public static final String MIDAS_SUB_ACTION_H5 = "h5midas";
    public static final String MINI_ADD_TO_COLLECTION = "pg_add_to_collection";
    public static final String MINI_GAME_PUBLIC_ACCOUNT_ACTION = "minigamechengzaiye";
    public static final String MINI_GAME_RESERVES_CLICK = "click";
    public static final String MINI_GAME_RESERVES_EXPOSE = "expo";
    public static final String MINI_GAME_RESERVES_EXPOSE_INVALID = "expo_invalid";
    public static final String MINI_GAME_RESERVES_PERIOD = "period";
    public static final String MINI_GAME_SUB_ACTION_APP_MSG_SUBSCRIBED = "appMsgSubscribed";
    public static final String MINI_GAME_SUB_ACTION_GAME_STORE = "top_minigame";
    public static final String MINI_GAME_SUB_ACTION_MORE_MSG = "top_news_more";
    public static final String MINI_GAME_SUB_ACTION_ONCE_MSG_SUBSCRIBED = "onceMsgSubscribed";
    public static final String MINI_GAME_SUB_ACTION_PROFILE = "profile";
    public static final String MINI_GAME_SUB_ACTION_RECENT_COLOR_SIGN = "recentColorSign";
    public static final String MINI_GAME_SUB_ACTION_SYS_MSG_SUBSCRIBED = "sysMsgSubscribed";
    public static final String MINI_GAME_SUM_ACTION_TOP_NEWS_ARK_TEST = "top_news_ark_test";
    public static final String MINI_LATELY_MORE_ICON = "lately_more_icon";
    public static final String MINI_LATELY_MORE_PAGE = "lately_more_page";
    public static final String MINI_MYMINIAPP_MORE_ICON = "myminiapp_more_icon";
    public static final String MINI_MYMINIAPP_MORE_PAGE = "myminiapp_more_page";
    public static final String MINI_PG_CLICK = "pg_click";
    public static final String MINI_SUB_PAGE_DELETE = "pg_delete";
    public static final String MORE_ABOUT_RESERVERS_FEEDBACK = "feedback";
    public static final String MORE_ABOUT_RESERVERS_LAUNCH = "launch";
    public static final String MORE_ABOUT_RESERVERS_LIKE_OFF = "like_off";
    public static final String MORE_ABOUT_RESERVERS_LIKE_ON = "like_on";
    public static final String MORE_ABOUT_RESERVERS_PRIVACY = "privacy";
    public static final String MORE_ABOUT_RESERVERS_PROFILE = "profile";
    public static final String MORE_ABOUT_RESERVERS_REPORT = "report";
    public static final String MORE_ABOUT_RESERVERS_SERVICE_TERMS = "service_terms";
    public static final String MORE_ABOUT_RESERVERS_SET = "set";
    public static final String MORE_ABOUT_RESERVERS_SETTOP_OFF = "settop_off";
    public static final String MORE_ABOUT_RESERVERS_SETTOP_ON = "settop_on";
    public static final String MORE_ABOUT_RESERVERS_SHARE = "share";
    public static final String MORE_BUTTON_RESERVERS_ABOUT = "about";
    public static final String MORE_BUTTON_RESERVERS_ADD_FOLDER = "add_folder";
    public static final String MORE_BUTTON_RESERVERS_BACK_HOME = "back_home";
    public static final String MORE_BUTTON_RESERVERS_CANCEL = "cancel";
    public static final String MORE_BUTTON_RESERVERS_CANCEL_SYSTEM = "cancel_system";
    public static final String MORE_BUTTON_RESERVERS_FAV = "fav";
    public static final String MORE_BUTTON_RESERVERS_MESSAGE = "message";
    public static final String MORE_BUTTON_RESERVERS_OPEN = "open";
    public static final String MORE_BUTTON_RESERVERS_QUN_SET = "qun_set";
    public static final String MORE_BUTTON_RESERVERS_REMOVE_FOLDER = "remove_folder";
    public static final String MORE_BUTTON_RESERVERS_RESTART = "restart";
    public static final String MORE_BUTTON_RESERVERS_SETTING = "setting";
    public static final String MORE_BUTTON_RESERVERS_SETTOP_OFF = "settop_off";
    public static final String MORE_BUTTON_RESERVERS_SETTOP_ON = "settop_on";
    public static final String MORE_BUTTON_RESERVERS_SHARE_CHANNEL = "share_channel";
    public static final String MORE_BUTTON_RESERVERS_SHARE_Moments = "share_Moments";
    public static final String MORE_BUTTON_RESERVERS_SHARE_QQ = "share_QQ";
    public static final String MORE_BUTTON_RESERVERS_SHARE_QZ = "share_QZ";
    public static final String MORE_BUTTON_RESERVERS_SHARE_WX = "share_WX";
    public static final String MORE_BUTTON_RESERVERS_SHORTCUT = "add_desktop";
    public static final String MORE_SET_RESERVERS_APP_MSG_SUBSCRIBED_OFF = "appMsgSubscribed_off";
    public static final String MORE_SET_RESERVERS_APP_MSG_SUBSCRIBED_ON = "appMsgSubscribed_on";
    public static final String MORE_SET_RESERVERS_ONCE_MSG_SUBSCRIBED_OFF = "onceMsgSubscribed_off";
    public static final String MORE_SET_RESERVERS_ONCE_MSG_SUBSCRIBED_ON = "onceMsgSubscribed_on";
    public static final String MORE_SET_RESERVERS_PROFILE_OFF = "profile_off";
    public static final String MORE_SET_RESERVERS_PROFILE_ON = "profile_on";
    public static final String MORE_SET_RESERVERS_RECENT_COLOR_SIGN_OFF = "recentColorSign_off";
    public static final String MORE_SET_RESERVERS_RECENT_COLOR_SIGN_ON = "recentColorSign_on";
    public static final String MORE_SET_RESERVERS_SYS_MSG_SUBSCRIBED_OFF = "sysMsgSubscribed_off";
    public static final String MORE_SET_RESERVERS_SYS_MSG_SUBSCRIBED_ON = "sysMsgSubscribed_on";
    public static final String NAVIGATE_TO_MINI_APP = "navigateToMiniProgram";
    public static final String NORMAL_URL_ACTION_TYPE = "urlapp";
    public static final String NORMAL_URL_DIALOG_CANCEL = "cancel";
    public static final String NORMAL_URL_DIALOG_CONFIRM = "confirm";
    public static final String NORMAL_URL_DIALOG_SUB_ACTION_TYPE = "bottom";
    public static final String PAGE_VIEW_ACTION = "page_view";
    public static final String PAGE_VIEW_MINIAPP_PULL_DESKTOP = "miniapp_pull_desktop";
    public static final String PAGE_VIEW_SUB_ACTION_CLICK = "click";
    public static final String PAGE_VIEW_SUB_ACTION_CLOSE = "close";
    public static final String PAGE_VIEW_SUB_ACTION_EXPO = "expo";
    public static final String PAGE_VIEW_SUB_ACTION_FINISHSHOW = "finishshow";
    public static final String PAGE_VIEW_SUB_ACTION_GAME_CLICK = "game_click";
    public static final String PAGE_VIEW_SUB_ACTION_GAME_EXPO = "game_expo";
    public static final String PAGE_VIEW_SUB_ACTION_HIDE = "hide";
    public static final String PAGE_VIEW_SUB_ACTION_LOAD = "load";
    public static final String PAGE_VIEW_SUB_ACTION_LOAD_FAIL = "load_fail";
    public static final String PAGE_VIEW_SUB_ACTION_SHOW = "show";
    public static final String PAGE_VIEW_SUB_ACTION_SHOW_FAIL = "show_fail";
    public static final String PAGE_VIEW_SUB_ACTION_UNLOAD = "unload";
    public static final String PAY_WX_ACTION = "wechat_pay";
    public static final String PAY_WX_SUB_ACTION_LAUNCH = "launch_wechatpay";
    public static final String PROFILE_CARD_ACTION = "id_card";
    public static final String PULLDOWN_ACTION = "pulldown";
    public static final String RECENT_COLOR_SIGN_ACTION_CLICK = "click";
    public static final String RECENT_COLOR_SIGN_ACTION_EXPO = "expo";
    public static final String RECENT_COLOR_SIGN_ACTION_REMOVE = "remove_ColorSign";
    public static final String RECENT_COLOR_SIGN_ACTION_TYPE = "addRecentColorSign";
    public static final String RECENT_COLOR_SIGN_SUB_ACTION_TYPE = "recentColorSign_enter";
    public static final String RESERVES_ACTION_CLICK = "click";
    public static final String RESERVES_ACTION_EM_CLICK = "em_click";
    public static final String RESERVES_ACTION_EM_EXPO = "em_expo";
    public static final String RESERVES_ACTION_EXPO = "expo";
    public static final String RESERVES_ACTION_MINIGAME_XIALA_PAGE = "minagame_xiala_page";
    public static final String RESERVES_ACTION_PG_CLICK = "pg_click";
    public static final String RETAIN_DIALOG_ACTION_TYPE = "minigame_popup";
    public static final String RETAIN_DIALOG_RESERVES_CLICK = "click";
    public static final String RETAIN_DIALOG_RESERVES_EXPOSE = "expo";
    public static final String RETAIN_DIALOG_SUB_ACTION_CANCEL = "cancel";
    public static final String RETAIN_DIALOG_SUB_ACTION_EXPOSE = "popup";
    public static final String RETAIN_DIALOG_SUB_ACTION_ICON = "icon";
    public static final String RETAIN_DIALOG_SUB_ACTION_MORE = "moregame";
    public static final String RETAIN_DIALOG_SUB_ACTION_REFRESH = "refresh";
    public static final String SCOPE_ACTION = "scope";
    public static final String SEARCH_ACTION_TYPE = "search";
    public static final String SEARCH_RESERVES_UNUSED = "unused";
    public static final String SEARCH_RESERVES_USED = "used";
    public static final String SEARCH_SUB_ACTION_BUTTON_CLICK = "click_button";
    public static final String SEARCH_SUB_ACTION_RESULT_CLICK = "result_click";
    public static final String SEARCH_SUB_ACTION_RESULT_VIEW = "result_view";
    public static final String SET_ACTION = "set";
    public static final String SHARE_ALERT_RESERVERS_ACTION = "show";
    public static final String SORT_PAGE_REFER = "7004";
    public static final String SORT_PAGE_VIA_ALL = "7004_1";
    public static final String SORT_PAGE_VIA_ENTERTAINMENT = "7004_5";
    public static final String SORT_PAGE_VIA_GAME = "7004_2";
    public static final String SORT_PAGE_VIA_SERVICE = "7004_3";
    public static final String SORT_PAGE_VIA_SOCIAL = "7004_4";
    public static final String SORT_RESULT_REFER = "3026";
    public static final String SORT_RESULT_VIA_ENTERTAINMENT = "3026_4";
    public static final String SORT_RESULT_VIA_GAME = "3026_1";
    public static final String SORT_RESULT_VIA_SERVICE = "3026_2";
    public static final String SORT_RESULT_VIA_SOCIAL = "3026_3";
    public static final String SORT_SELECTED_ENTERTAINMENT = "sortselected_audiovisual_icon";
    public static final String SORT_SELECTED_ENTERTAINMENT_PAGE = "sortselected_audiovisual_page";
    public static final String SORT_SELECTED_ENTRY = "sortselected_entry";
    public static final String SORT_SELECTED_GAME = "sortselected_populargames_icon";
    public static final String SORT_SELECTED_GAME_PAGE = "sortselected_populargames_page";
    public static final String SORT_SELECTED_SERVICE = "sortselected_convenientservice_icon";
    public static final String SORT_SELECTED_SERVICE_PAGE = "sortselected_convenientservice_page";
    public static final String SORT_SELECTED_SOCIAL = "sortselected_socialcontact_icon";
    public static final String SORT_SELECTED_SOCIAL_PAGE = "sortselected_socialcontact_page";
    public static final String SYS_ALERT_ACTION = "sys_alert";
    private static final String TAG = "MiniProgramLpReportDC04239";
    public static final String USER_CLICK_ACTION = "user_click";
    public static final String USER_CLICK_SUB_ACTION_MORE_ABOUT = "more_about";
    public static final String USER_CLICK_SUB_ACTION_MORE_BUTTON = "more_button";
    public static final String USER_CLICK_SUB_ACTION_SHARE_ALERT = "share_alert";
    private static MiniAppConfig showMiniAppConfig;
    public static final HashMap<String, String> CLASSIFY_PAGE_ACTION_MAP = new HashMap<String, String>() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.1
        {
            put(HardCodeUtil.qqStr(R.string.f167462d0), MiniProgramLpReportDC04239.SORT_SELECTED_GAME_PAGE);
            put(HardCodeUtil.qqStr(R.string.f167472d1), MiniProgramLpReportDC04239.SORT_SELECTED_SERVICE_PAGE);
            put(HardCodeUtil.qqStr(R.string.f167482d2), MiniProgramLpReportDC04239.SORT_SELECTED_SOCIAL_PAGE);
            put(HardCodeUtil.qqStr(R.string.f167452cz), MiniProgramLpReportDC04239.SORT_SELECTED_ENTERTAINMENT_PAGE);
        }
    };
    public static final HashMap<String, String> CLASSIFY_PAGE_VIA_MAP = new HashMap<String, String>() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.2
        {
            put(HardCodeUtil.qqStr(R.string.f167462d0), MiniProgramLpReportDC04239.SORT_RESULT_VIA_GAME);
            put(HardCodeUtil.qqStr(R.string.f167472d1), MiniProgramLpReportDC04239.SORT_RESULT_VIA_SERVICE);
            put(HardCodeUtil.qqStr(R.string.f167482d2), MiniProgramLpReportDC04239.SORT_RESULT_VIA_SOCIAL);
            put(HardCodeUtil.qqStr(R.string.f167452cz), MiniProgramLpReportDC04239.SORT_RESULT_VIA_ENTERTAINMENT);
        }
    };
    private static long mRecordDurationInterval = GameWnsUtils.getRecordDurationInterval();
    private static Runnable recordDurationRunnable = new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.23
        @Override // java.lang.Runnable
        public void run() {
            if (MiniProgramLpReportDC04239.showMiniAppConfig != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("app_config", MiniProgramLpReportDC04239.showMiniAppConfig);
                bundle.putLong("add_duration_ms", MiniProgramLpReportDC04239.mRecordDurationInterval);
                QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "record_duration", bundle);
                MiniProgramLpReportDC04239.sendRecordDurationMsg();
            }
        }
    };

    MiniProgramLpReportDC04239() {
    }

    public static void deleteRecordDurationMsg() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "deleteRecordDurationMsg");
        }
        MiniProgramReporter.getInstance().getReportHandler().removeCallbacks(recordDurationRunnable);
    }

    public static void exposureReport(final List<MiniAppExposureManager.BaseExposureReport> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.20
            @Override // java.lang.Runnable
            public void run() {
                for (MiniAppExposureManager.BaseExposureReport baseExposureReport : list) {
                    if (baseExposureReport != null) {
                        baseExposureReport.handleReport();
                    }
                }
                MiniProgramReporter.getInstance().flush();
            }
        });
    }

    public static void gameInnerReport(final MiniAppConfig miniAppConfig, final JSONObject jSONObject) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.14
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2 = JSONObject.this;
                if (jSONObject2 != null) {
                    MiniProgramLpReportDC04239.report(miniAppConfig, "1", (String) null, jSONObject2.optString("actiontype"), JSONObject.this.optString("sub_actiontype"), JSONObject.this.optString("reserves_action"));
                }
            }
        });
    }

    public static String getAppType(MiniAppConfig miniAppConfig) {
        if (miniAppConfig == null || !miniAppConfig.isReportTypeMiniGame()) {
            return "0";
        }
        return "1";
    }

    public static boolean isLifeCycle(String str) {
        return "click".equals(str) || "load".equals(str) || "load_fail".equals(str) || "show".equals(str) || "show_fail".equals(str) || "finishshow".equals(str) || "hide".equals(str) || "unload".equals(str) || "close".equals(str);
    }

    public static String[] parseModeAndLocation(String str) {
        String str2 = "";
        String str3 = "";
        for (String str4 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            if (str4.contains("mode")) {
                String[] split = str4.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length > 1) {
                    str2 = split[1];
                }
            }
            if (str4.contains("location")) {
                String[] split2 = str4.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length > 1) {
                    str3 = split2[1];
                }
            }
        }
        return new String[]{str2, str3};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5) {
        report(miniAppConfig, str, str2, str3, str4, str5, "", null, null, null, null);
    }

    public static void reportApiInvoke(final MiniAppConfig miniAppConfig, final String str) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.15
            @Override // java.lang.Runnable
            public void run() {
                MiniAppConfig miniAppConfig2 = miniAppConfig;
                if (miniAppConfig2 == null || miniAppConfig2.config == null) {
                    return;
                }
                MiniProgramLpReportDC04239.report(miniAppConfig2, MiniProgramLpReportDC04239.getAppType(miniAppConfig2), (String) null, "inner-app", "from_api", str);
            }
        });
    }

    public static void reportAsync(String str, String str2, String str3, String str4) {
        reportAsync(str, str2, str3, str4, (String) null, (String) null);
    }

    public static void reportAsyncWithExtraEntries(final String str, final String str2, final String str3, final ArrayList<COMM.Entry> arrayList) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.8
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramLpReportDC04239.report(str, str2, str3, (String) null, (String) null, (String) null, (ArrayList<COMM.Entry>) arrayList);
            }
        });
    }

    public static void reportAsyncWithIcon(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.10
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramLpReportDC04239.reportWithIcon(MiniAppConfig.this, str, str2, str3, str4, str5, str6, str7, str8);
            }
        });
    }

    public static void reportAsyncWithReferAndVia(String str, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MiniProgramReportHelper.newEntry("refer", String.valueOf(str4)));
        arrayList.add(MiniProgramReportHelper.newEntry("via", String.valueOf(str5)));
        reportAsyncWithExtraEntries(str, str2, str3, arrayList);
    }

    public static void reportByQQ(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        reportByQQ(null, str, str2, str3, str4, str5, str6, str7);
    }

    public static void reportByQzoneFeed(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(MiniProgramReportHelper.newEntry("appid", str));
        }
        if (!TextUtils.isEmpty(str4)) {
            arrayList.add(MiniProgramReportHelper.newEntry("mode", str4));
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(Arrays.asList(MiniProgramReportHelper.newEntry("actiontype", String.valueOf(str5)), MiniProgramReportHelper.newEntry("sub_actiontype", String.valueOf(str6)), MiniProgramReportHelper.newEntry("reserves_action", String.valueOf(str7)), MiniProgramReportHelper.newEntry("reserves6", String.valueOf(str8)), MiniProgramReportHelper.newEntry("refer", String.valueOf(str2)), MiniProgramReportHelper.newEntry("via", String.valueOf(str3))));
        arrayList.addAll(arrayList2);
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    public static void reportDropDown(final MiniAppConfig miniAppConfig, final String str, final String str2) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.18
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramLpReportDC04239.report(MiniAppConfig.this, MiniProgramLpReportDC04239.getAppType(MiniAppConfig.this), (String) null, "drop_down", str, str2);
                MiniProgramReporter.getInstance().flush();
            }
        });
    }

    public static void reportForSDK(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.16
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramLpReportDC04239.report(MiniAppConfig.this, str, str2, str3, str4, str5, str6, null, null, null, null);
            }
        });
    }

    public static void reportMiniAppEvent(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.4
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramLpReportDC04239.report(miniAppConfig, str, str2, str3, str4, str5, str6, str7, null, null, null);
            }
        });
    }

    public static void reportMiniGameVirtual(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final String str4) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.21
            @Override // java.lang.Runnable
            public void run() {
                String str5;
                String str6;
                LaunchParam launchParam;
                LaunchParam launchParam2;
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
                MiniAppConfig miniAppConfig2 = MiniAppConfig.this;
                arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppConfig2, null, (miniAppConfig2 == null || (launchParam2 = miniAppConfig2.launchParam) == null) ? null : String.valueOf(launchParam2.scene), str, str2, str3, null, null, null, null, null, null, str4, "1", ""));
                if (!str3.equals("minagame_xiala_page")) {
                    MiniAppConfig miniAppConfig3 = MiniAppConfig.this;
                    if (miniAppConfig3 != null && (launchParam = miniAppConfig3.launchParam) != null && !TextUtils.isEmpty(launchParam.reportData)) {
                        QLog.d(MiniProgramLpReportDC04239.TAG, 4, "reportMiniGameVirtual reportData: " + MiniAppConfig.this.launchParam.reportData);
                        String[] parseModeAndLocation = MiniProgramLpReportDC04239.parseModeAndLocation(MiniAppConfig.this.launchParam.reportData);
                        str5 = parseModeAndLocation[0];
                        str6 = parseModeAndLocation[1];
                    } else {
                        str5 = "";
                        str6 = "";
                    }
                    arrayList.addAll(MiniProgramReportHelper.newModeAndLocation(str5, str6));
                }
                arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
                MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
                MiniProgramReporter.getInstance().flush();
            }
        });
    }

    public static void reportMorePageExposure(int i3) {
        QLog.e(TAG, 1, "reportMorePageExposure" + i3);
        if (i3 == 1) {
            MiniAppConfig miniAppConfig = new MiniAppConfig(new MiniAppInfo());
            miniAppConfig.launchParam.scene = 3005;
            miniAppConfig.config.via = "3005_1";
            reportMiniAppEvent(miniAppConfig, "0", null, "page_view", "em_expo", MINI_LATELY_MORE_PAGE, null);
            return;
        }
        if (i3 == 3) {
            MiniAppConfig miniAppConfig2 = new MiniAppConfig(new MiniAppInfo());
            miniAppConfig2.launchParam.scene = 3043;
            miniAppConfig2.config.via = "3043_1";
            reportMiniAppEvent(null, "0", null, "page_view", "em_expo", MINI_MYMINIAPP_MORE_PAGE, null);
        }
    }

    public static void reportNavigatorbarExpose() {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.7
            @Override // java.lang.Runnable
            public void run() {
                MiniAppInfo miniAppInfo = new MiniAppInfo();
                MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                miniAppConfig.launchParam.scene = 2009;
                miniAppInfo.via = "2009_1";
                miniAppInfo.appId = "1108291530";
                MiniProgramLpReportDC04239.reportMiniAppEvent(miniAppConfig, "0", null, "page_view", "expo", null, null);
                MiniProgramReporter.getInstance().flush();
            }
        });
    }

    public static void reportPageView(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final String str4) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.5
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramLpReportDC04239.report(miniAppConfig, str, str2, "page_view", str3, str4);
            }
        });
    }

    public static void reportUserClick(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final String str4, final String str5) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.3
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramLpReportDC04239.report(miniAppConfig, str, str2, str3, str4, str5);
            }
        });
    }

    public static void reportWithGroupId(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.22
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
                arrayList.addAll(MiniProgramReportHelper.newQQqunInfoBusinessEntries(str, str2, str3, str4, str5, str6, str7));
                arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
                arrayList.addAll(MiniProgramReportHelper.newVersionEntries(miniAppConfig));
                MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
                MiniProgramReporter.getInstance().flush();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendRecordDurationMsg() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "sendRecordDurationMsg");
        }
        MiniProgramReporter.getInstance().getReportHandler().removeCallbacks(recordDurationRunnable);
        MiniProgramReporter.getInstance().getReportHandler().postDelayed(recordDurationRunnable, mRecordDurationInterval);
    }

    public static void report(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, String str7, String str8, String str9, String str10) {
        String str11;
        LaunchParam launchParam;
        if (isLifeCycle(str4)) {
            MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.17
                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("app_config", MiniAppConfig.this);
                    bundle.putString("action_type", str3);
                    bundle.putString("sub_action", str4);
                    bundle.putString("path", str2);
                    bundle.putString("reserves", str5);
                    bundle.putString("reserves2", str6);
                    bundle.putString("app_type", str);
                    MiniAppConfig miniAppConfig2 = MiniAppConfig.this;
                    bundle.putBoolean("x5_enable", EnvUtils.isX5Enabled(miniAppConfig2 != null ? miniAppConfig2.config : null));
                    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "launch_report", bundle);
                }
            });
            str11 = str4;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
            str11 = str4;
            arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppConfig, AppBrandUtil.getUrlWithoutParams(str2), (miniAppConfig == null || (launchParam = miniAppConfig.launchParam) == null) ? null : String.valueOf(launchParam.scene), str3, str4, str5, str6, str7, str8, str9, str10, null, null, str, null));
            arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
            MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        }
        if ("unload".equals(str11) || "close".equals(str11) || "hide".equals(str11) || "finishshow".equals(str11) || "sys_alert".equals(str3)) {
            MiniProgramReporter.getInstance().flush();
        }
        if ("show".equals(str11)) {
            showMiniAppConfig = miniAppConfig;
            sendRecordDurationMsg();
            return;
        }
        String str12 = str11;
        if ("unload".equals(str12) || "hide".equals(str12) || "close".equals(str12)) {
            deleteRecordDurationMsg();
        }
    }

    public static void reportAsync(final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.9
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramLpReportDC04239.report(str, str2, str3, str4, str5, str6);
            }
        });
    }

    public static void reportByQQ(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(MiniProgramReportHelper.newEntry("appid", str));
        }
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBaseBusinessEntries(str2, str3, str4, str5, str6, str7, str8));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    public static void reportMiniAppEvent(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5, String str6) {
        reportMiniAppEvent(miniAppConfig, str, str2, str3, str4, str5, str6, null);
    }

    public static void reportPageView(final String str, final String str2) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.6
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramLpReportDC04239.exposureReport("page_view", str, str2);
            }
        });
    }

    public static void exposureReport(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5, String str6) {
        exposureReport(miniAppConfig, str, str2, str3, str4, str5, str6, null, null, null, null, null);
    }

    public static void reportAsync(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4) {
        reportAsync(miniAppConfig, str, str2, str3, str4, (String) null);
    }

    public static void reportByDropGuideDialog(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5) {
        String str6;
        LaunchParam launchParam;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newModeAndLocation(str4, str5));
        if (miniAppConfig != null && miniAppConfig.config != null) {
            str6 = getAppType(miniAppConfig);
        } else {
            str6 = "0";
        }
        arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppConfig, null, (miniAppConfig == null || (launchParam = miniAppConfig.launchParam) == null) ? null : String.valueOf(launchParam.scene), str, str2, str3, null, null, null, null, null, null, null, str6, ""));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    public static void reportPageView(List<MiniAppExposureManager.MiniAppExposureData> list, String str) {
        reportPageView(list, null, str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportWithIcon(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9;
        LaunchParam launchParam;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        if (miniAppConfig != null && miniAppConfig.config != null) {
            str9 = getAppType(miniAppConfig);
        } else {
            str9 = "0";
        }
        arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppConfig, null, (miniAppConfig == null || (launchParam = miniAppConfig.launchParam) == null) ? null : String.valueOf(launchParam.scene), str, str2, str3, str4, str5, null, null, str6, str7, str8, str9, ""));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    public static void exposureReport(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        exposureReport(miniAppConfig, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, null);
    }

    public static void reportAsync(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final String str4, final String str5) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.11
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramLpReportDC04239.report(MiniAppConfig.this, str, str2, str3, str4, str5, (String) null);
            }
        });
    }

    public static void reportPageView(List<MiniAppExposureManager.MiniAppExposureData> list, String str, boolean z16) {
        reportPageView(list, null, str, z16);
    }

    public static void exposureReport(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        MiniAppInfo miniAppInfo;
        MiniAppInfo miniAppInfo2;
        MiniAppInfo miniAppInfo3;
        MiniAppInfo miniAppInfo4;
        LaunchParam launchParam;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppConfig, AppBrandUtil.getUrlWithoutParams(str2), (miniAppConfig == null || (launchParam = miniAppConfig.launchParam) == null) ? null : String.valueOf(launchParam.scene), str3, str4, str5, str6, null, str7, str8, str9, str10, str11, str, "", str12));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (miniAppConfig != null && (miniAppInfo4 = miniAppConfig.config) != null && !TextUtils.isEmpty(miniAppInfo4.reportData)) {
            arrayList.addAll(MiniProgramReportHelper.newReportEntries(miniAppConfig.config.reportData));
        }
        if (miniAppConfig != null && (miniAppInfo3 = miniAppConfig.config) != null && !TextUtils.isEmpty(miniAppInfo3.via)) {
            arrayList.add(MiniProgramReportHelper.newEntry("via", miniAppConfig.config.via));
        }
        if (miniAppConfig != null && (miniAppInfo2 = miniAppConfig.config) != null && !TextUtils.isEmpty(miniAppInfo2.hostScene)) {
            arrayList.add(MiniProgramReportHelper.newEntry("host_scene", miniAppConfig.config.hostScene));
        }
        if (miniAppConfig != null && (miniAppInfo = miniAppConfig.config) != null) {
            arrayList.add(MiniProgramReportHelper.newEntry(com.tencent.qqmini.sdk.report.MiniAppReportManager2.KEY_SLOT_ID, String.valueOf(miniAppInfo.position)));
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
    }

    public static void reportAsync(final MiniAppInfo miniAppInfo, final String str, final int i3, final String str2, final String str3, final String str4, final String str5) {
        if (miniAppInfo == null) {
            return;
        }
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.12
            @Override // java.lang.Runnable
            public void run() {
                MiniAppConfig miniAppConfig = new MiniAppConfig(MiniAppInfo.this);
                int i16 = i3;
                if (i16 != -1) {
                    miniAppConfig.launchParam.scene = i16;
                }
                MiniProgramLpReportDC04239.report(miniAppConfig, str, str2, str3, str4, str5, (String) null);
            }
        });
    }

    private static void reportPageView(final List<MiniAppExposureManager.MiniAppExposureData> list, final String str, final String str2, final boolean z16) {
        if (list == null || list.size() <= 0) {
            return;
        }
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.19
            @Override // java.lang.Runnable
            public void run() {
                MiniAppConfig miniAppConfig;
                LaunchParam launchParam;
                int i3;
                for (MiniAppExposureManager.MiniAppExposureData miniAppExposureData : list) {
                    if (miniAppExposureData != null && miniAppExposureData.getMiniAppConfig() != null && ((launchParam = (miniAppConfig = miniAppExposureData.getMiniAppConfig()).launchParam) == null || !z16 || ((i3 = launchParam.scene) != 3009 && i3 != 3010))) {
                        MiniProgramLpReportDC04239.exposureReport(miniAppConfig, MiniProgramLpReportDC04239.getAppType(miniAppConfig), str, "page_view", str2, String.valueOf(miniAppExposureData.getPosition()), z16 ? miniAppExposureData.getReserves2() : null);
                    }
                }
                MiniProgramReporter.getInstance().flush();
            }
        });
    }

    public static void reportAsync(final List<COMM.Entry> list) {
        if (list == null) {
            return;
        }
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.13
            @Override // java.lang.Runnable
            public void run() {
                list.addAll(MiniProgramReportHelper.newUserInfoEntries());
                list.addAll(MiniProgramReportHelper.newGenericEntries());
                MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, list, null));
                MiniProgramReporter.getInstance().flush();
            }
        });
    }

    public static void reportByQQqunInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        reportWithGroupId(null, str, str2, str3, str4, str5, str6, str7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void exposureReport(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBaseBusinessEntries(str, str2, str3, null, null, null, null));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(String str, String str2, String str3, String str4, String str5, String str6, ArrayList<COMM.Entry> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList2.addAll(MiniProgramReportHelper.newBaseBusinessEntries(str, str2, str3, str4, str5, str6, null));
        arrayList2.addAll(MiniProgramReportHelper.newGenericEntries());
        arrayList2.addAll(arrayList);
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList2, null));
        MiniProgramReporter.getInstance().flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(String str, String str2, String str3, String str4, String str5, String str6) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBaseBusinessEntries(str, str2, str3, str4, str5, str6, null));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    public static void report(String str, String str2, String str3, String str4, String str5, String str6, boolean z16) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBaseBusinessEntries(str, str2, str3, str4, str5, str6, null));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        if (z16) {
            MiniProgramReporter.getInstance().flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5, String str6) {
        MiniAppInfo miniAppInfo;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        String appType = (miniAppConfig == null || miniAppConfig.config == null) ? "0" : getAppType(miniAppConfig);
        String str7 = "";
        if ((miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null || !miniAppInfo.isWxMiniApp()) && miniAppConfig != null) {
            LaunchParam launchParam = miniAppConfig.launchParam;
            str7 = launchParam != null ? String.valueOf(launchParam.scene) : null;
        }
        arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppConfig, null, str7, str, str2, str3, str4, str5, str6, null, null, null, null, appType, ""));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }
}
