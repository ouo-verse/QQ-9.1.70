package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.EmojiHomeUiPluginConstant;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes20.dex */
public class EmojiHomeUiPlugin extends EmojiUiPlugin {
    public static final String ACTION_OPEN_HOMEPAGE = "actOpenHomePage";
    public static final int HOMEPAGE_RDM_EVENT_AUTHENTICATION = 11201;
    public static final int HOMEPAGE_RDM_EVENT_BAD_URL = 11202;
    public static final int HOMEPAGE_RDM_EVENT_CONNECT = 11203;
    public static final int HOMEPAGE_RDM_EVENT_FAIL_GENERAL = 11200;
    public static final int HOMEPAGE_RDM_EVENT_FILE = 11205;
    public static final int HOMEPAGE_RDM_EVENT_FILE_NOT_FOUND = 11206;
    public static final int HOMEPAGE_RDM_EVENT_FINISH = 1001;
    public static final int HOMEPAGE_RDM_EVENT_HOST_LOOKUP = 11207;
    public static final int HOMEPAGE_RDM_EVENT_IO = 11208;
    public static final int HOMEPAGE_RDM_EVENT_MANY_REQUESTS = 11212;
    public static final int HOMEPAGE_RDM_EVENT_OPENNING = 1002;
    public static final int HOMEPAGE_RDM_EVENT_PROXY_AUTH = 11209;
    public static final int HOMEPAGE_RDM_EVENT_REDIRECT_LOOP = 11210;
    public static final int HOMEPAGE_RDM_EVENT_SSL_HANDSHAKE = 11204;
    public static final int HOMEPAGE_RDM_EVENT_TIMEOUT = 11211;
    public static final int HOMEPAGE_RDM_EVENT_UNKNOWN = 11213;
    public static final int HOMEPAGE_RDM_EVENT_UNSUP_AUTH = 11214;
    public static final int HOMEPAGE_RDM_EVENT_UNSUP_SCHEME = 11215;
    public static final String TAG = "Q.emoji.web.EmojiUiPlugin.EmojiHomeUiPlugin";

    public static QQAppInterface getApp() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof QQAppInterface)) {
            return null;
        }
        return (QQAppInterface) waitAppRuntime;
    }

    public static void openEmojiAuthorPage(Activity activity, String str, int i3, String str2) {
        if (activity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int i16 = activity.getSharedPreferences(str, 0).getInt("emosm_sp_mall_new_timestamp", -1);
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("selfuin", str);
            intent.putExtra("reqType", 6);
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
            intent.putExtra("emojimall_src", i3);
            intent.putExtra("emojimall_detail_id", str2);
            intent.putExtra(VasWebviewConstants.KEY_MALL_NEW_TIMESTAMP, i16);
            intent.putExtra("hide_more_button", true);
            VasWebviewUtil.openQQBrowserWithoutAD(activity, null, 4L, intent, false, -1);
            if (i3 == 3) {
                activity.overridePendingTransition(R.anim.activity_new, 0);
            } else {
                activity.overridePendingTransition(R.anim.f154424l, 0);
            }
        }
    }

    public static void openEmojiDetailPage(Activity activity, String str, int i3, String str2) {
        if ((i3 != 8 && i3 != 4) || activity == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        int i16 = activity.getSharedPreferences(str, 0).getInt("emosm_sp_mall_new_timestamp", -1);
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("selfuin", str);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
        intent.putExtra("reqType", 6);
        intent.putExtra("emojimall_src", i3);
        intent.putExtra("emojimall_detail_id", str2);
        intent.putExtra(VasWebviewConstants.KEY_MALL_NEW_TIMESTAMP, i16);
        intent.putExtra("hide_more_button", true);
        VasWebviewUtil.openQQBrowserWithoutAD(activity, null, 4L, intent, false, -1);
    }

    public static void openEmojiDetailPage2(Activity activity, String str, int i3, String str2, boolean z16, int i16, String str3) {
        if (z16) {
            return;
        }
        if ((i3 == 8 || i3 == 4) && activity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int i17 = activity.getSharedPreferences(str, 0).getInt("emosm_sp_mall_new_timestamp", -1);
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            if (str3 == null) {
                str3 = activity.getIntent().getStringExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN);
                i16 = activity.getIntent().getIntExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, -1);
            }
            intent.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, i16);
            intent.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN, str3);
            intent.putExtra("selfuin", str);
            intent.putExtra("reqType", 6);
            intent.putExtra("show_right_close_button", true);
            intent.putExtra("emojimall_src", i3);
            intent.putExtra("emojimall_detail_id", str2);
            intent.putExtra("emojimall_qFace", z16);
            intent.putExtra(VasWebviewConstants.KEY_MALL_NEW_TIMESTAMP, i17);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("individuation_url_type", reportSourceTypeOfEmoji(i3));
            VasWebviewUtil.openQQBrowserWithoutAD(activity, null, 4L, intent, false, -1);
        }
    }

    public static void openEmojiHomePage(Activity activity, String str, int i3, boolean z16, String str2) {
        openEmojiHomePage(activity, str, i3, z16, str2, false);
    }

    public static void openEmojiHomePage2(Activity activity, String str, int i3, String str2, int i16) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            int i17 = activity.getSharedPreferences(str, 0).getInt("emosm_sp_mall_new_timestamp", -1);
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("selfuin", str);
            intent.putExtra("emojimall_src", i3);
            intent.putExtra(VasWebviewConstants.KEY_MALL_NEW_TIMESTAMP, i17);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("webStyle", "noBottomBar");
            intent.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, i16);
            intent.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN, str2);
            intent.putExtra("portraitOnly", true);
            if (i3 != 7 && i3 != 3) {
                intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
            }
            if (i3 == 1 || i3 == 13) {
                intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
            }
            intent.putExtra("individuation_url_type", reportSourceTypeOfEmoji(i3));
            if (i3 != 1 && i3 != 3) {
                VasWebviewUtil.openQQBrowserWithoutAD(activity, null, 2L, intent, false, -1);
            } else {
                intent.putExtra(VasWebviewConstants.KEY_UPDATE_FLAG, false);
                VasWebviewUtil.openQQBrowserWithoutAD(activity, null, 2L, intent, true, 4001);
            }
        }
    }

    private static void openEmojiPage(Context context, String str, int i3, boolean z16, String str2, int i16, int i17, String str3, boolean z17) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("selfuin", str);
        intent.putExtra("emojimall_src", i3);
        intent.putExtra(VasWebviewConstants.KEY_MALL_NEW_TIMESTAMP, i16);
        intent.putExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, z16);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("rec_id", str2);
        intent.putExtra("webStyle", "noBottomBar");
        intent.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, i17);
        intent.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN, str3);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("individuation_url_type", reportSourceTypeOfEmoji(i3));
        if (z17) {
            intent.putExtra("fragmentStyle", 4);
        }
        if (i3 != 7 && i3 != 3) {
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
        }
        if (i3 == 1 || i3 == 13) {
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
        }
        if (i3 == 9) {
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
        }
        if (i3 != 1 && i3 != 3) {
            VasWebviewUtil.openQQBrowserWithoutAD(context, null, 2L, intent, false, -1);
        } else {
            intent.putExtra(VasWebviewConstants.KEY_UPDATE_FLAG, z16);
            VasWebviewUtil.openQQBrowserWithoutAD(context, null, 2L, intent, true, 4001);
        }
        if ((i3 == 1 || i3 == 13) && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(R.anim.f154454a3, R.anim.f154550b4);
        }
    }

    public static void openEmosmActivity(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, String str, int i3, boolean z16, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            int currChatType = iEmoticonMainPanelApp.getMessageFacade().getCurrChatType();
            String currChatUin = iEmoticonMainPanelApp.getMessageFacade().getCurrChatUin();
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_EMOSM_ACTIVITY);
            activityURIRequest.extra().putInt(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, currChatType);
            activityURIRequest.extra().putString(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN, currChatUin);
            activityURIRequest.extra().putInt("emojimall_src", i3);
            QRoute.startUri(activityURIRequest);
            return;
        }
        QLog.e(TAG, 1, "open EmosmActivity failed because selfUin is empty.srcFromType=" + i3 + " ,hasRedDot=" + z16 + " ,currentId=" + str2);
    }

    public static void openSmallEmojiListPage(Activity activity, String str, int i3, String str2) {
        QQAppInterface app;
        if (activity == null || TextUtils.isEmpty(str) || (app = getApp()) == null) {
            return;
        }
        int i16 = activity.getSharedPreferences(str, 0).getInt("emosm_sp_mall_new_timestamp", -1);
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        int r16 = app.getMessageFacade().r1();
        String s16 = app.getMessageFacade().s1();
        if (s16 == null) {
            s16 = activity.getIntent().getStringExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN);
            r16 = activity.getIntent().getIntExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, -1);
        }
        intent.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, r16);
        intent.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN, s16);
        intent.putExtra("selfuin", str);
        intent.putExtra("reqType", 6);
        intent.putExtra("show_right_close_button", false);
        intent.putExtra("emojimall_src", i3);
        intent.putExtra(VasWebviewConstants.KEY_MALL_NEW_TIMESTAMP, i16);
        intent.putExtra("hide_more_button", false);
        intent.putExtra("emoji_ids", str2);
        VasWebviewUtil.openQQBrowserWithoutAD(activity, null, 4L, intent, false, -1);
    }

    private static void realOpenEmojiDetailPage(Activity activity, String str, int i3, String str2, boolean z16, Intent intent, boolean z17, int i16, Intent intent2, int i17, String str3) {
        int i18;
        String str4;
        int i19;
        if (str3 == null) {
            str4 = activity.getIntent().getStringExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN);
            i18 = activity.getIntent().getIntExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, -1);
        } else {
            i18 = i17;
            str4 = str3;
        }
        intent2.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, i18);
        intent2.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN, str4);
        intent2.putExtra("selfuin", str);
        intent2.putExtra("reqType", 6);
        intent2.putExtra("show_right_close_button", false);
        intent2.putExtra("emojimall_src", i3);
        intent2.putExtra("emojimall_detail_id", str2);
        intent2.putExtra("emojimall_qFace", z16);
        intent2.putExtra(VasWebviewConstants.KEY_MALL_NEW_TIMESTAMP, i16);
        intent2.putExtra("hide_more_button", false);
        intent2.putExtra("is_small_emoji", z17);
        if (intent != null) {
            intent2.putExtras(intent);
            intent2.putExtra(EmojiHomeUiPluginConstant.EXTRA_KEY_IS_KANDIAN_EMOTICON, intent.getBooleanExtra(EmojiHomeUiPluginConstant.EXTRA_KEY_IS_KANDIAN_EMOTICON, false));
        }
        if (i3 == 8) {
            i19 = VasWebviewConstants.REPORT_FROM_AIO_EMOTICON_PANEL_AD;
        } else {
            i19 = 40313;
        }
        intent2.putExtra("individuation_url_type", i19);
        VasWebviewUtil.openQQBrowserWithoutAD(activity, null, 4L, intent2, false, -1);
    }

    public static int reportSourceTypeOfEmoji(int i3) {
        if (i3 != 1) {
            if (i3 != 6) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        switch (i3) {
                            case 8:
                                return VasWebviewConstants.REPORT_FROM_AIO_EMOTICON_PANEL_AD;
                            case 9:
                                break;
                            case 10:
                                return VasWebviewConstants.REPORT_FROM_AIO_RENEWAL_GRAY_TIPS;
                            default:
                                return 40300;
                        }
                    } else {
                        return 40313;
                    }
                } else {
                    return VasWebviewConstants.REPORT_FROM_INDIVIDUATION_SET;
                }
            }
            return VasWebviewConstants.REPORT_FROM_AIO_EMOTICON_PANEL_MAGIC;
        }
        return VasWebviewConstants.REPORT_FROM_AIO_EMOTICON_PANEL;
    }

    public static void statisticEmojiHomePageInfo(Context context, String str, Intent intent) {
        String str2;
        int i3;
        int i16;
        if (context != null && !TextUtils.isEmpty(str) && intent != null && intent.getExtras() != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            long j3 = intent.getExtras().getLong("openToOncreateGap", -1L);
            long j16 = intent.getExtras().getLong("openTogetKeyTimeGap", -1L);
            long j17 = intent.getExtras().getLong("openToFinishOrErrorGap", -1L);
            boolean z16 = false;
            boolean z17 = intent.getExtras().getBoolean("bNeedGetKey", false);
            int i17 = intent.getExtras().getInt("processStep", 1);
            StringBuilder sb5 = new StringBuilder();
            String str3 = "";
            sb5.append("");
            sb5.append(j3);
            hashMap.put("openToOncreateGap", sb5.toString());
            hashMap.put("bNeedGetKey", "" + z17);
            hashMap.put("openTogetKeyTimeGap", "" + j16);
            hashMap.put("openToFinishOrErrorGap", "" + j17);
            if (i17 != 3) {
                str2 = "";
                i3 = HOMEPAGE_RDM_EVENT_FAIL_GENERAL;
                z16 = true;
            } else {
                int i18 = intent.getExtras().getInt("failcode", 0);
                String string = intent.getExtras().getString("errordescription");
                String string2 = intent.getExtras().getString(OpenHippyInfo.EXTRA_KEY_ERROR_URL);
                if (string == null) {
                    string = "";
                }
                if (string2 != null) {
                    str3 = string2;
                }
                hashMap.put("errordescription", string);
                hashMap.put(OpenHippyInfo.EXTRA_KEY_ERROR_URL, str3);
                if (i18 == -4) {
                    i16 = HOMEPAGE_RDM_EVENT_AUTHENTICATION;
                } else if (i18 == -12) {
                    i16 = 11202;
                } else if (i18 == -6) {
                    i16 = 11203;
                } else if (i18 == -11) {
                    i16 = HOMEPAGE_RDM_EVENT_SSL_HANDSHAKE;
                } else if (i18 == -13) {
                    i16 = HOMEPAGE_RDM_EVENT_FILE;
                } else if (i18 == -14) {
                    i16 = HOMEPAGE_RDM_EVENT_FILE_NOT_FOUND;
                } else if (i18 == -2) {
                    i16 = HOMEPAGE_RDM_EVENT_HOST_LOOKUP;
                } else if (i18 == -7) {
                    i16 = HOMEPAGE_RDM_EVENT_IO;
                } else if (i18 == -5) {
                    i16 = HOMEPAGE_RDM_EVENT_PROXY_AUTH;
                } else if (i18 == -9) {
                    i16 = HOMEPAGE_RDM_EVENT_REDIRECT_LOOP;
                } else if (i18 == -8) {
                    i16 = HOMEPAGE_RDM_EVENT_TIMEOUT;
                } else if (i18 == -15) {
                    i16 = HOMEPAGE_RDM_EVENT_MANY_REQUESTS;
                } else if (i18 == -1) {
                    i16 = HOMEPAGE_RDM_EVENT_UNKNOWN;
                } else if (i18 == -3) {
                    i16 = HOMEPAGE_RDM_EVENT_UNSUP_AUTH;
                } else if (i18 == -10) {
                    i16 = HOMEPAGE_RDM_EVENT_UNSUP_SCHEME;
                } else {
                    i3 = HOMEPAGE_RDM_EVENT_FAIL_GENERAL;
                    hashMap.put("param_FailCode", Integer.toString(i3));
                    str2 = str3;
                    str3 = string;
                }
                i3 = i16;
                hashMap.put("param_FailCode", Integer.toString(i3));
                str2 = str3;
                str3 = string;
            }
            if (QLog.isColorLevel()) {
                QLog.i(EmojiUiPlugin.tag, 2, "statistic:openToOncreateGap:" + j3 + "openTogetKeyTimeGap:" + j16 + "bNeedGetKey:" + z17 + "openToFinishOrErrorGap:" + j17 + "processStep:" + i17 + "isSuccess:" + z16 + "errordescription:" + str3 + "errorUrl:" + str2 + "resultCode:" + i3);
            }
            StatisticCollector.getInstance(context).collectPerformance(str, ACTION_OPEN_HOMEPAGE, z16, 0L, 0L, hashMap, "");
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin, com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityCreate() {
        this.mActivityType = 1;
        super.OnActivityCreate();
        if (!checkOncreateParam(getInfoIntent())) {
            this.activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void doAfterFinish() {
        if (this.mSrcFromType == 3) {
            this.activity.overridePendingTransition(0, R.anim.activity_finish);
        } else {
            this.activity.overridePendingTransition(0, R.anim.f154423k);
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin, com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void doBeforeFinish() {
        int i3 = this.mSrcFromType;
        if (i3 == 1 || i3 == 3 || i3 == 6 || i3 == 9) {
            Intent intent = new Intent();
            intent.putExtra("openToOncreateGap", this.openToOncreateGap);
            intent.putExtra("openTogetKeyTimeGap", this.openTogetKeyTimeGap);
            intent.putExtra("openToFinishOrErrorGap", this.openToFinishOrErrorGap);
            intent.putExtra("bNeedGetKey", this.bNeedGetKey);
            intent.putExtra("processStep", this.processStep);
            intent.putExtra("failcode", this.failcode);
            intent.putExtra("errordescription", this.errordescription);
            intent.putExtra(OpenHippyInfo.EXTRA_KEY_ERROR_URL, this.errorUrl);
            this.activity.setResult(-1, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 2L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 3L;
    }

    public static void openEmojiHomePage(Activity activity, String str, int i3, boolean z16, String str2, boolean z17) {
        QQAppInterface app;
        if (activity == null || TextUtils.isEmpty(str) || (app = getApp()) == null) {
            return;
        }
        openEmojiPage(activity, str, i3, z16, str2, activity.getSharedPreferences(str, 0).getInt("emosm_sp_mall_new_timestamp", -1), app.getMessageFacade().r1(), app.getMessageFacade().s1(), z17);
    }

    public static void openEmojiHomePage(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, String str, int i3, boolean z16, String str2) {
        openEmojiHomePage(context, iEmoticonMainPanelApp, str, i3, z16, str2, false);
    }

    public static void openEmojiHomePage(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, String str, int i3, boolean z16, String str2, boolean z17) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        openEmojiPage(context, str, i3, z16, str2, context.getSharedPreferences(str, 0).getInt("emosm_sp_mall_new_timestamp", -1), iEmoticonMainPanelApp.getMessageFacade().getCurrChatType(), iEmoticonMainPanelApp.getMessageFacade().getCurrChatUin(), z17);
    }

    public static void openEmojiDetailPage(Activity activity, String str, int i3, String str2, boolean z16, boolean z17) {
        openEmojiDetailPage(activity, str, i3, str2, z16, null, z17);
    }

    public static void openEmojiDetailPage(Activity activity, String str, int i3, String str2, boolean z16, Intent intent, boolean z17) {
        QQAppInterface app;
        if (z16) {
            return;
        }
        if ((i3 != 8 && i3 != 4 && i3 != 12) || activity == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (app = getApp()) == null) {
            return;
        }
        realOpenEmojiDetailPage(activity, str, i3, str2, z16, intent, z17, activity.getSharedPreferences(str, 0).getInt("emosm_sp_mall_new_timestamp", -1), new Intent(activity, (Class<?>) QQBrowserActivity.class), app.getMessageFacade().r1(), app.getMessageFacade().s1());
    }

    public static void openEmojiHomePage(Activity activity, String str, int i3) {
        openEmojiHomePage(activity, str, i3, false, "");
    }

    public static void openEmojiDetailPage(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, String str, int i3, String str2, boolean z16, Intent intent, boolean z17) {
        if (z16) {
            return;
        }
        if ((i3 == 8 || i3 == 4 || i3 == 12) && (context instanceof Activity) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            realOpenEmojiDetailPage((Activity) context, str, i3, str2, z16, intent, z17, context.getSharedPreferences(str, 0).getInt("emosm_sp_mall_new_timestamp", -1), new Intent(context, (Class<?>) QQBrowserActivity.class), iEmoticonMainPanelApp.getMessageFacade().getCurrChatType(), iEmoticonMainPanelApp.getMessageFacade().getCurrChatUin());
        }
    }
}
