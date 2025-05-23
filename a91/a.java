package a91;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.ark.open.security.ArkBaseUrlChecker;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.ark.d;
import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.ark.g;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.troop.utils.k;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    public static QQAppInterface a() {
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    public static String b() {
        if (MobileQQ.sProcessId != 1) {
            return "";
        }
        return ((IPhoneContactService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo().nationCode;
    }

    public static String c(boolean z16) {
        if (MobileQQ.sProcessId != 1) {
            return "";
        }
        RespondQueryQQBindingStat selfBindInfo = ((IPhoneContactService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
        String str = selfBindInfo.mobileNo;
        if (!z16) {
            return selfBindInfo.nationCode + " " + str;
        }
        return str;
    }

    public static boolean d(String str, int i3, String str2, String str3) {
        boolean z16;
        String str4;
        String str5;
        boolean z17;
        String str6;
        String str7;
        boolean z18;
        int i16;
        char c16;
        int i17;
        String str8;
        boolean z19;
        boolean z26;
        boolean z27;
        int i18;
        int i19;
        String str9 = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if ((baseActivity instanceof BaseActivity) && !TextUtils.isEmpty(str)) {
            AIOContact a16 = com.tencent.qqnt.aio.utils.a.f352276a.a(baseActivity);
            if (a16 != null && a16.e() == 2 && k.k(str2, str9)) {
                str9 = k.h(a16.j(), str9);
            }
            String str10 = str9;
            if (((IArkAPIService) QRoute.api(IArkAPIService.class)).dispatchOpenURL(str10, "", new JSONObject(), i3, str2, str3)) {
                str4 = "ArkApp.ArkCommonUtil";
                g.b(null, str2, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                str7 = str10;
            } else {
                str4 = "ArkApp.ArkCommonUtil";
                if (!str10.startsWith("http://") && !str10.startsWith("https://")) {
                    if (i3 == 0) {
                        ax c17 = bi.c(a(), baseActivity, str10);
                        if (c17 != null) {
                            ArkAppUrlChecker urlChecker = ArkAppConfigMgr.getInstance().getUrlChecker(str2, str3);
                            if (urlChecker != null) {
                                int checkUrlIsValidByAppNavigationList = urlChecker.checkUrlIsValidByAppNavigationList(str10);
                                if (checkUrlIsValidByAppNavigationList == 0) {
                                    z26 = true;
                                } else {
                                    z26 = false;
                                }
                                boolean isUrlCheckEnable = ArkAppConfigMgr.getInstance().isUrlCheckEnable(str2);
                                boolean e16 = f.e();
                                if (isUrlCheckEnable && !e16) {
                                    z27 = true;
                                } else {
                                    z27 = false;
                                }
                                if (QLog.isColorLevel()) {
                                    Boolean valueOf = Boolean.valueOf(isUrlCheckEnable);
                                    i18 = 5;
                                    Object[] objArr = {"ArkSafe.UrlCheck.OpenUrl.http.JumpAction=", str2, ", enableCheck=", Boolean.valueOf(z27), ", appEnableCheck=", valueOf, ", isPublicAccount=", Boolean.valueOf(e16)};
                                    str8 = str4;
                                    QLog.e(str8, 2, objArr);
                                } else {
                                    str8 = str4;
                                    i18 = 5;
                                }
                                if (!z26) {
                                    if (!z27) {
                                        Object[] objArr2 = new Object[i18];
                                        objArr2[0] = "ArkSafe.UrlCheck.setDisable.OpenUrl.jump appName=";
                                        objArr2[1] = str2;
                                        objArr2[2] = JefsClass.INDEX_URL;
                                        objArr2[3] = com.tencent.biz.common.util.k.f(str10, new String[0]);
                                        objArr2[4] = ", isValid set=true";
                                        QLog.e(str8, 1, objArr2);
                                        i19 = 2;
                                        z19 = true;
                                    } else {
                                        z19 = z26;
                                        i19 = 1;
                                    }
                                } else {
                                    z19 = z26;
                                    i19 = 0;
                                }
                                ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportOpenURLAccess(str2, str10, checkUrlIsValidByAppNavigationList, i19, ArkAppContainer.f179262j);
                            } else {
                                str8 = str4;
                                z19 = true;
                            }
                            if (z19) {
                                c17.b();
                                str6 = str8;
                                str7 = str10;
                            } else {
                                QLog.e(str8, 1, "ArkSafe.OpenUrl check url invalid, url=", com.tencent.biz.common.util.k.f(str10, new String[0]), ", app=", str2);
                            }
                        }
                        return false;
                    }
                    str7 = str10;
                } else {
                    ArkAppUrlChecker urlChecker2 = ArkAppConfigMgr.getInstance().getUrlChecker(str2, str3);
                    if (urlChecker2 != null) {
                        int checkUrlIsValidByAppNavigationList2 = urlChecker2.checkUrlIsValidByAppNavigationList(str10);
                        if (checkUrlIsValidByAppNavigationList2 == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        boolean isUrlCheckEnable2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(str2);
                        boolean e17 = f.e();
                        if (isUrlCheckEnable2 && !e17) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (QLog.isColorLevel()) {
                            c16 = 2;
                            i16 = 5;
                            QLog.e(str4, 2, "ArkSafe.UrlCheck.OpenUrl.http.appname=", str2, ", enableCheck=", Boolean.valueOf(z18), ", appEnableCheck=", Boolean.valueOf(isUrlCheckEnable2), ", isPublicAccount=", Boolean.valueOf(e17));
                        } else {
                            i16 = 5;
                            c16 = 2;
                        }
                        if (!z17) {
                            if (!z18) {
                                Object[] objArr3 = new Object[i16];
                                objArr3[0] = "ArkSafe.UrlCheck.setDisable.OpenUrl.http appName=";
                                objArr3[1] = str2;
                                objArr3[c16] = JefsClass.INDEX_URL;
                                objArr3[3] = com.tencent.biz.common.util.k.f(str10, new String[0]);
                                objArr3[4] = ", isValid set=true";
                                QLog.e(str4, 1, objArr3);
                                i17 = 2;
                                z17 = true;
                            } else {
                                i17 = 1;
                            }
                        } else {
                            i17 = 0;
                        }
                        str5 = str4;
                        ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportOpenURLAccess(str2, str10, checkUrlIsValidByAppNavigationList2, i17, ArkAppContainer.f179262j);
                    } else {
                        str5 = str4;
                        z17 = true;
                    }
                    if (!z17) {
                        QLog.d(str5, 1, "ArkSafe.OpenUrl check url invalid!, url=", com.tencent.biz.common.util.k.f(str10, new String[0]), ", app=", str2);
                        return false;
                    }
                    if (a16 != null && a16.e() == 103) {
                        str6 = str5;
                        str7 = str10;
                    } else {
                        str6 = str5;
                        str7 = str10;
                        g.b(null, str2, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                    }
                    e(baseActivity, str7, true, 0L, null, "biz_src_jc_ark", 0, str2, null, str3);
                }
                z16 = true;
                QLog.d(str6, 1, "ark.OpenUrl=" + str7);
            }
            str6 = str4;
            z16 = true;
            QLog.d(str6, 1, "ark.OpenUrl=" + str7);
        } else {
            z16 = true;
        }
        g.b(null, str2, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
        return z16;
    }

    public static Intent e(Context context, String str, boolean z16, long j3, MsgRecord msgRecord, String str2, int i3, String str3, String str4, String str5) {
        int i16;
        ArkBaseUrlChecker appNavigationChecker;
        boolean z17;
        String str6;
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
        intent.putExtra("param_force_internal_browser", z16);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("url", str);
        boolean z18 = false;
        intent.putExtra("injectrecommend", false);
        intent.putExtra("browserType", i3);
        d.b(intent, str2);
        if (!TextUtils.isEmpty(str4)) {
            intent.putExtra(LaunchParam.KEY_REF_ID, str4);
        }
        com.tencent.qqnt.msg.data.a parseArkMsgModelFromMsgRecord = ArkMsgUtils.parseArkMsgModelFromMsgRecord(msgRecord);
        if (!TextUtils.isEmpty(str3)) {
            if (parseArkMsgModelFromMsgRecord != null) {
                parseArkMsgModelFromMsgRecord.e();
            }
            String appPathFromLocal = ArkAppMgr.getInstance().getAppPathFromLocal(str3, str5);
            if (!TextUtils.isEmpty(appPathFromLocal)) {
                intent.putExtra(AppConstants.Key.H5_ARK_APP_PATH, appPathFromLocal);
                String applicationDesc = ArkAppCacheMgr.getApplicationDesc(str3);
                if (!TextUtils.isEmpty(applicationDesc)) {
                    intent.putExtra(AppConstants.Key.H5_ARK_APP_DESCRIPTION, applicationDesc);
                }
            }
            if (ArkMsgUtils.isFromSdkShare(parseArkMsgModelFromMsgRecord)) {
                intent.putExtra(AppConstants.Key.H5_ARK_IS_FROM_SHARE, true);
            }
            intent.putExtra(AppConstants.Key.H5_ARK_APP_NAME, str3);
            ArkAppUrlChecker urlChecker = ArkAppConfigMgr.getInstance().getUrlChecker(str3, str5);
            if (urlChecker != null && (appNavigationChecker = urlChecker.getAppNavigationChecker()) != null) {
                intent.putExtra(AppConstants.Key.H5_ARK_URL_WEB_CHECKER, appNavigationChecker);
                boolean isUrlCheckEnable = ArkAppConfigMgr.getInstance().isUrlCheckEnable(str3);
                boolean e16 = f.e();
                if (isUrlCheckEnable && !e16) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                intent.putExtra(AppConstants.Key.H5_ARK_URL_WEB_CHECKER_ENABLE, z17);
                if (msgRecord != null) {
                    str6 = msgRecord.getSenderUid();
                } else {
                    str6 = "";
                }
                intent.putExtra(AppConstants.Key.H5_ARK_URL_WEB_SENDER_UIN, str6);
                if (e16) {
                    intent.putExtra(IPublicAccountBrowser.KEY_PUB_UIN, str6);
                }
                QLog.d("ArkApp.ArkCommonUtil", 1, "ArkSafe.UrlCheck.launchQQBrowser,appname=", str3, ", enableCheck=", Boolean.valueOf(z17), ", appEnableCheck=", Boolean.valueOf(isUrlCheckEnable), ", isPublicAccount=", Boolean.valueOf(e16), ", senderUin=", str6, ", mUrlChecker=", appNavigationChecker.toString());
            }
        }
        String b16 = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkAIKeyWordConfig().b();
        if (!TextUtils.isEmpty(b16)) {
            intent.putExtra(AppConstants.Key.H5_ARK_CHECK_CONFIG, b16);
        }
        String b17 = b();
        String c16 = c(true);
        if (!TextUtils.isEmpty(b17)) {
            intent.putExtra(AppConstants.Key.H5_ARK_NATION_CODE, b17);
        }
        if (!TextUtils.isEmpty(c16)) {
            intent.putExtra(AppConstants.Key.H5_ARK_PHONE_NUMBER, c16);
        }
        if (parseArkMsgModelFromMsgRecord != null && msgRecord != null) {
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DIRECT, false);
            intent.putExtra("forward_ark_app_name", parseArkMsgModelFromMsgRecord.d());
            intent.putExtra("forward_ark_app_view", parseArkMsgModelFromMsgRecord.e());
            intent.putExtra("forward_ark_biz_src", parseArkMsgModelFromMsgRecord.f());
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, parseArkMsgModelFromMsgRecord.a());
            intent.putExtra("forward_ark_app_prompt", parseArkMsgModelFromMsgRecord.n());
            String m3 = parseArkMsgModelFromMsgRecord.m();
            if (TextUtils.isEmpty(m3)) {
                m3 = "{}";
            }
            intent.putExtra("forward_ark_app_meta", m3);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, parseArkMsgModelFromMsgRecord.g());
            intent.putExtra(AppConstants.Key.FORWARD_ARK_FROM_H5, true);
            if (!TextUtils.isEmpty(parseArkMsgModelFromMsgRecord.b())) {
                intent.putExtra(AppConstants.Key.FORWARD_APPID_ARK_FROM_SDK, parseArkMsgModelFromMsgRecord.b());
                intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, parseArkMsgModelFromMsgRecord.j());
                intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA, parseArkMsgModelFromMsgRecord.i());
                intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, parseArkMsgModelFromMsgRecord.l());
                intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, parseArkMsgModelFromMsgRecord.k());
                g.b(null, parseArkMsgModelFromMsgRecord.d(), "AIOArkSdkCardClick", 1, 0, 0L, 0L, 0L, parseArkMsgModelFromMsgRecord.e(), "");
            } else if (parseArkMsgModelFromMsgRecord.h() == 1) {
                g.b(null, parseArkMsgModelFromMsgRecord.d(), "AIOArkMapCardClick ", 1, 0, 0L, 0L, 0L, parseArkMsgModelFromMsgRecord.e(), "");
            }
            if (msgRecord.getChatType() == 1) {
                intent.putExtra("friend_uin", msgRecord.getPeerUin());
            }
            if (msgRecord.getChatType() == 2) {
                intent.putExtra("groupUin", msgRecord.getPeerUin());
                i16 = 1;
            } else {
                i16 = 0;
            }
            if (msgRecord.getChatType() == 3) {
                intent.putExtra("dicussgroup_uin", msgRecord.getPeerUin());
                i16 = 3000;
            }
            if (msgRecord.getChatType() == 4) {
                intent.putExtra("friendUin", msgRecord.getSenderUid());
                intent.putExtra("friend_uin", msgRecord.getChannelId());
                intent.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, msgRecord.getGuildId());
                i16 = 10014;
            }
            intent.putExtra("uinType", i16);
            QQAppInterface a16 = a();
            if (a16 != null) {
                z18 = TextUtils.equals(msgRecord.getSenderUid(), a16.getCurrentUin());
            }
            intent.putExtra(QQBrowserActivity.KEY_IS_SEND, z18);
            intent.putExtra("fromAio", true);
        }
        intent.putExtra(AppConstants.Key.SHARE_REQ_APP_ID, j3);
        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DIRECT, true);
        if (context != null) {
            context.startActivity(intent);
        }
        return intent;
    }

    public static void f(Context context, String str) {
        if (context == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("file_send_path", str);
        bundle.putInt(ShortVideoConstants.VIDEO_PLAY_CALLER, 1);
        bundle.putBoolean(ShortVideoConstants.VIDEO_TITLE_BAR_HIDE, true);
        Intent intent = new Intent(context, (Class<?>) ShortVideoPlayActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
