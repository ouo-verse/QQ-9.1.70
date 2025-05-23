package com.tencent.mobileqq.mini.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.g;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.cookie.b;
import com.tencent.mobileqq.webview.webso.c;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sd2.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public class TroopApplicationListUtil {
    public static final String ACTION_ADD_GROUP_SUCCESS = "com.tencent.mobileqq.addgroupapplication";
    public static final String ADD_TROOP_APPLICATION_API = "app.qun.qq.com/cgi-bin/api/inner_setunifiedapp";
    public static final String CHECK_MINIAPP_IN_TROOP_APPLICATION_LIST = "app.qun.qq.com/cgi-bin/api/inner_checkunifiedapp";
    private static final String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";
    private static final int PSKEY_HEAD_NUM = 10;
    public static final int START_TROOP_ACTIVITY_REQUEST_CODE = 107;
    public static final int STATUS_CODE_ADDED_TROOP = 44012;
    public static final int STATUS_CODE_EXCEED_MAX_SIZE = 41005;
    public static final int STATUS_CODE_HAS_ADDED = 41012;
    public static final int STATUS_CODE_NOT_GROUP_ADMINISTRATOR = 44004;
    public static final int STATUS_CODE_NOT_GROUP_MANAGER = 41004;
    private static final String TAG = "TroopApplicationListUtil";
    public static final int TYPE_ADD = 1001;
    public static final int TYPE_CHECK = 1000;
    public static final String WNS_CGI_PROXY_URL = "https://h5.qzone.qq.com/miniapp/proxy/wnscgi/{api}";

    TroopApplicationListUtil() {
    }

    public static void addMiniAppToTroopApplicationList(final String str, final String str2, String str3) {
        if (!g.b(BaseApplication.getContext())) {
            showToast(1000);
            QLog.e(TAG, 1, "addMiniAppToTroopApplicationList, network is not available");
        } else {
            final c.a buildRequest = buildRequest(str, str2, str3, 1001);
            final String j06 = AuthorizeConfig.y().j0(b.f(buildRequest.f315003a));
            ((IPskeyManager) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{j06}, new a() { // from class: com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.3
                @Override // sd2.a
                public void onFail(String str4) {
                    QLog.e(TroopApplicationListUtil.TAG, 1, "addMiniAppToTroopApplicationList getPskey onFail!", str4);
                }

                @Override // sd2.a
                public void onSuccess(Map<String, String> map) {
                    QLog.i(TroopApplicationListUtil.TAG, 1, "addMiniAppToTroopApplicationList getPskey onSuccess111!");
                    String str4 = map.get(j06);
                    TroopApplicationListUtil.setReqInfoUrlBkn(buildRequest, str4);
                    c.c().i(buildRequest, TroopApplicationListUtil.addMiniAppToTroopApplicationListHandler(str, str2), TroopApplicationListUtil.getCookie(str4));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Handler addMiniAppToTroopApplicationListHandler(final String str, final String str2) {
        return new Handler(ThreadManagerV2.getQQCommonThreadLooper()) { // from class: com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Object obj = message.obj;
                if (obj instanceof c.b) {
                    c.b bVar = (c.b) obj;
                    int i3 = bVar.f315020i;
                    if (i3 == 0) {
                        try {
                            QLog.d(TroopApplicationListUtil.TAG, 1, "handleMessage cgiState.htmlBody: ", bVar.f315015d);
                            int optInt = new JSONObject(bVar.f315015d).optInt("ec", -1);
                            TroopApplicationListUtil.showToast(optInt);
                            TroopApplicationListUtil.sendMsgToTroopApplication(optInt, str, str2);
                            return;
                        } catch (Exception e16) {
                            QLog.e(TroopApplicationListUtil.TAG, 1, "handleMessage addMiniAppToTroopApplicationList exception ", e16);
                            return;
                        }
                    }
                    QLog.d(TroopApplicationListUtil.TAG, 1, "handleMessage cgiState.resultCode: ", Integer.valueOf(i3));
                    return;
                }
                QLog.e(TroopApplicationListUtil.TAG, 1, "handleMessage addMiniAppToTroopApplicationList ", " invalid msg.obj");
            }
        };
    }

    private static c.a buildRequest(String str, String str2, String str3, int i3) {
        c.a aVar = new c.a();
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 1000) {
            sb5.append("gc=");
            sb5.append(str);
            sb5.append("&appid=");
            sb5.append(str2);
            aVar.f315003a = WNS_CGI_PROXY_URL.replace("{api}", CHECK_MINIAPP_IN_TROOP_APPLICATION_LIST);
        } else {
            sb5.append("gc=");
            sb5.append(str);
            sb5.append("&append_appid=");
            sb5.append(str2);
            sb5.append("&add_type=1");
            sb5.append("&append_source=1");
            aVar.f315003a = WNS_CGI_PROXY_URL.replace("{api}", ADD_TROOP_APPLICATION_API);
        }
        sb5.append("&sourcekey=qzone");
        sb5.append("&qqver=");
        sb5.append(AppSetting.f99551k);
        sb5.append(".");
        sb5.append(AppSetting.f99542b);
        sb5.append("&platform=2");
        aVar.f315005c = "{}";
        aVar.f315010h = 60000;
        aVar.f315007e = "application/x-www-form-urlencoded";
        if (TextUtils.isEmpty(str3)) {
            str3 = "POST";
        }
        aVar.f315004b = str3;
        aVar.f315009g = false;
        aVar.f315006d = sb5.toString();
        return aVar;
    }

    public static String getCookie(String str) {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        return "uin=o" + account + ";skey=" + takeString(str, 10) + ";p_uin=o" + account + ";p_skey=" + str;
    }

    public static int getGTK(String str) {
        return MiniAppUtils.getGTK(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Handler getGroupAppStatusHandler(final AsyncResult asyncResult) {
        return new Handler(ThreadManagerV2.getQQCommonThreadLooper()) { // from class: com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Object obj = message.obj;
                if (obj instanceof c.b) {
                    c.b bVar = (c.b) obj;
                    if (bVar.f315020i == 0) {
                        try {
                            if (bVar.f315015d != null) {
                                QLog.d(TroopApplicationListUtil.TAG, 1, "handleMessage cgiState.htmlBody: ", bVar.f315015d);
                                int optInt = new JSONObject(bVar.f315015d).optInt("ec", -1);
                                JSONObject jSONObject = new JSONObject();
                                if (optInt == 44012) {
                                    jSONObject.put("isExisted", true);
                                    jSONObject.put("errorCode", optInt);
                                    asyncResult.onReceiveResult(true, jSONObject);
                                    return;
                                } else if (optInt == 0) {
                                    jSONObject.put("isExisted", false);
                                    jSONObject.put("errorCode", optInt);
                                    asyncResult.onReceiveResult(true, jSONObject);
                                    return;
                                } else {
                                    jSONObject.put("errorCode", optInt);
                                    if (optInt == 44004) {
                                        jSONObject.put("errMsg", "not group manager");
                                    }
                                    asyncResult.onReceiveResult(false, jSONObject);
                                    return;
                                }
                            }
                            QLog.e(TroopApplicationListUtil.TAG, 1, "native error, htmlBody is null");
                            asyncResult.onReceiveResult(false, null);
                            return;
                        } catch (JSONException e16) {
                            QLog.e(TroopApplicationListUtil.TAG, 1, "handleMessage addMiniAppToTroopApplicationList exception ", e16);
                            asyncResult.onReceiveResult(false, null);
                            return;
                        }
                    }
                    QLog.e(TroopApplicationListUtil.TAG, 1, "handleMessage addMiniAppToTroopApplicationList ,resultCode : " + bVar.f315020i);
                    asyncResult.onReceiveResult(false, null);
                    return;
                }
                QLog.e(TroopApplicationListUtil.TAG, 1, "handleMessage addMiniAppToTroopApplicationList ", " invalid msg.obj");
                asyncResult.onReceiveResult(false, null);
            }
        };
    }

    public static boolean isAdminOrCreated() {
        boolean m3 = TroopUtils.m();
        QLog.d(TAG, 1, "isAdminOrCreated: " + m3);
        return m3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setReqInfoUrlBkn(c.a aVar, String str) {
        int gtk;
        if (TextUtils.isEmpty(str)) {
            String r16 = SwiftBrowserCookieMonster.r(aVar.f315003a);
            if (TextUtils.isEmpty(r16) || !r16.contains("p_skey")) {
                gtk = -1;
            } else {
                gtk = -1;
                for (String str2 : r16.split(";")) {
                    if (!TextUtils.isEmpty(str2) && str2.contains("p_skey")) {
                        String substring = str2.substring(str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1, str2.length());
                        if (!TextUtils.isEmpty(substring)) {
                            gtk = getGTK(substring);
                        }
                    }
                }
            }
        } else {
            gtk = getGTK(takeString(str, 10));
        }
        if (gtk != -1) {
            if (aVar.f315003a.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                aVar.f315003a += "&bkn=" + gtk;
                return;
            }
            aVar.f315003a += "?bkn=" + gtk;
        }
    }

    public static void startTroopActivityAndAddTroopApplication(Activity activity, final String str, final AsyncResult asyncResult) {
        QLog.d(TAG, 1, "setMiniAppToTroopApplicationList");
        final IActivityResultManager activityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
        activityResultManager.addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.8
            @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
            public boolean doOnActivityResult(int i3, int i16, Intent intent) {
                if (i3 == 107 && i16 == -1) {
                    IActivityResultManager.this.removeActivityResultListener(this);
                    String stringExtra = intent.getStringExtra("uin");
                    String stringExtra2 = intent.getStringExtra("uinname");
                    TroopApplicationListUtil.addMiniAppToTroopApplicationList(stringExtra, str, null, asyncResult);
                    QLog.d(TroopApplicationListUtil.TAG, 1, "group uin: " + stringExtra + ", group name: " + stringExtra2);
                }
                return true;
            }
        });
        Intent intent = new Intent(activity, (Class<?>) TroopActivity.class);
        intent.putExtra("onlyOneSegement", true);
        intent.putExtra("_key_mode", 0);
        intent.putExtra(AppConstants.Key.IS_SELECT_TROOP, true);
        intent.putExtra("key_from", 3);
        activity.startActivityForResult(intent, 107);
    }

    private static String takeString(String str, int i3) {
        if (i3 > 0 && !TextUtils.isEmpty(str) && str.length() >= i3) {
            return str.substring(0, i3);
        }
        return "";
    }

    public static void getGroupAppStatus(String str, String str2, final AsyncResult asyncResult) {
        final c.a buildRequest = buildRequest(str, str2, null, 1000);
        final String j06 = AuthorizeConfig.y().j0(b.f(buildRequest.f315003a));
        ((IPskeyManager) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{j06}, new a() { // from class: com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.1
            @Override // sd2.a
            public void onFail(String str3) {
                QLog.e(TroopApplicationListUtil.TAG, 1, "getGroupAppStatus getPskey onFail!", str3);
            }

            @Override // sd2.a
            public void onSuccess(Map<String, String> map) {
                QLog.i(TroopApplicationListUtil.TAG, 1, "getGroupAppStatus getPskey onSuccess!");
                String str3 = map.get(j06);
                TroopApplicationListUtil.setReqInfoUrlBkn(buildRequest, str3);
                c.c().i(buildRequest, TroopApplicationListUtil.getGroupAppStatusHandler(asyncResult), TroopApplicationListUtil.getCookie(str3));
            }
        });
    }

    public static void addMiniAppToTroopApplicationList(final String str, final String str2, String str3, final AsyncResult asyncResult) {
        if (!g.b(BaseApplication.getContext())) {
            showToast(1000);
            asyncResult.onReceiveResult(false, null);
            QLog.e(TAG, 1, "addMiniAppToTroopApplicationList, network is not available");
        } else {
            final c.a buildRequest = buildRequest(str, str2, null, 1001);
            final String j06 = AuthorizeConfig.y().j0(b.f(buildRequest.f315003a));
            ((IPskeyManager) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{j06}, new a() { // from class: com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.5
                @Override // sd2.a
                public void onFail(String str4) {
                    QLog.e(TroopApplicationListUtil.TAG, 1, "addMiniAppToTroopApplicationList getPskey onFail!", str4);
                }

                @Override // sd2.a
                public void onSuccess(Map<String, String> map) {
                    QLog.i(TroopApplicationListUtil.TAG, 1, "addMiniAppToTroopApplicationList getPskey onSuccess222!");
                    String str4 = map.get(j06);
                    TroopApplicationListUtil.setReqInfoUrlBkn(buildRequest, str4);
                    c.c().i(buildRequest, TroopApplicationListUtil.addMiniAppToTroopApplicationList(str, str2, asyncResult), TroopApplicationListUtil.getCookie(str4));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendMsgToTroopApplication(int i3, String str, String str2) {
        if (i3 == 0 || i3 == 41012) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mobileqq.addgroupapplication");
            intent.putExtra("groupUin", str);
            intent.putExtra("appId", str2);
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
        }
    }

    public static void showToast(int i3) {
        final String string;
        final int i16;
        if (i3 == 0 || i3 == 41012) {
            string = BaseApplicationImpl.getApplication().getResources().getString(R.string.f166992bq);
            i16 = 5;
        } else {
            i16 = 0;
            if (i3 == 41005) {
                string = BaseApplicationImpl.getApplication().getResources().getString(R.string.f167062bx);
            } else if (i3 == 41004) {
                string = BaseApplicationImpl.getApplication().getResources().getString(R.string.f167132c4);
            } else {
                string = BaseApplicationImpl.getApplication().getResources().getString(R.string.f166982bp);
            }
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.7
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplicationImpl.getApplication(), i16, string, 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Handler addMiniAppToTroopApplicationList(final String str, final String str2, final AsyncResult asyncResult) {
        return new Handler(ThreadManagerV2.getQQCommonThreadLooper()) { // from class: com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.6
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Object obj = message.obj;
                if (obj instanceof c.b) {
                    c.b bVar = (c.b) obj;
                    if (bVar.f315020i == 0) {
                        try {
                            if (bVar.f315015d != null) {
                                QLog.d(TroopApplicationListUtil.TAG, 1, "handleMessage cgiState.htmlBody: ", bVar.f315015d);
                                int optInt = new JSONObject(bVar.f315015d).optInt("ec", -1);
                                TroopApplicationListUtil.showToast(optInt);
                                JSONObject jSONObject = new JSONObject();
                                if (optInt != 0 && optInt != 41012) {
                                    jSONObject.put("errorCode", optInt);
                                    asyncResult.onReceiveResult(false, jSONObject);
                                } else {
                                    jSONObject.put("errorCode", optInt);
                                    asyncResult.onReceiveResult(true, jSONObject);
                                }
                                TroopApplicationListUtil.sendMsgToTroopApplication(optInt, str, str2);
                                return;
                            }
                            new JSONObject().put("errMsg", "htmlBody is null");
                            asyncResult.onReceiveResult(false, null);
                            return;
                        } catch (JSONException e16) {
                            QLog.e(TroopApplicationListUtil.TAG, 1, "handleMessage addMiniAppToTroopApplicationList exception ", e16);
                            asyncResult.onReceiveResult(false, null);
                            return;
                        }
                    }
                    QLog.e(TroopApplicationListUtil.TAG, 1, "handleMessage addMiniAppToTroopApplicationList ,resultCode : " + bVar.f315020i);
                    asyncResult.onReceiveResult(false, null);
                    return;
                }
                QLog.e(TroopApplicationListUtil.TAG, 1, "handleMessage addMiniAppToTroopApplicationList ", " invalid msg.obj");
                asyncResult.onReceiveResult(false, null);
            }
        };
    }
}
