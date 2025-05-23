package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.icgame.api.cookie.IQQLiveCookiePlanterApi;
import com.tencent.icgame.api.cookie.IQQLiveCookieStrategyApi;
import com.tencent.icgame.api.cookie.QQLiveCookieStrategyType;
import com.tencent.mobileqq.icgame.api.IQQLiveUtil;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.CookieDataCallback;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class ICGameJsPlugin extends VasWebviewJsPluginV2 {
    public static final String BUSINESS_NAME = "icgame";
    private static final int RET_CODE_GET_COOKIE_FAILED = 1;
    private static final int RET_CODE_GET_COOKIE_SUCCESS = 0;
    private static final String TAG = "ICGameJsPlugin";

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "getUserInfo")
    public void getUserInfo(String str) {
        QLog.i(TAG, 1, "getUserInfo");
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e(TAG, 1, "appInterface is null");
                callJsOnError(str, "appInterface is null");
                return;
            }
            if (!peekAppRuntime.isLogin()) {
                QLog.e(TAG, 1, "not login");
                callJsOnError(str, "not login");
                return;
            }
            String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
            HashMap hashMap = new HashMap();
            hashMap.put("uin", currentAccountUin);
            hashMap.put("nick", (String) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(currentAccountUin, INearbySPUtil.SP_KEY_SELF_NICK, ""));
            hashMap.put("gender", String.valueOf(((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(currentAccountUin, INearbySPUtil.SP_KEY_SELF_GENDER, (Object) (-1))).intValue() - 1));
            hashMap.put("age", String.valueOf(((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(currentAccountUin, INearbySPUtil.SP_KEY_SELF_AGE, (Object) (-1))).intValue()));
            addCookies(hashMap, str, false);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            callJsOnError(str, "exception:" + th5.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(method = "preloadICGameRoom")
    public void preloadICGameRoom() {
        ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).preloadICGameRoom();
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "updateLoginInfo")
    public void updateLoginInfo(String str) {
        QLog.i(TAG, 1, "updateLoginInfo");
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e(TAG, 1, "appInterface is null");
                callJsOnError(str, "appInterface is null");
            } else if (!peekAppRuntime.isLogin()) {
                QLog.e(TAG, 1, "not login");
                callJsOnError(str, "not login");
            } else {
                addCookies(new HashMap(), str, true);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            callJsOnError(str, "exception:" + th5.getMessage());
        }
    }

    private void addCookies(final Map<String, String> map, final String str, boolean z16) {
        QQLiveCookieStrategyType qQLiveCookieStrategyType;
        if (z16) {
            qQLiveCookieStrategyType = QQLiveCookieStrategyType.FULL_NO_CACHE;
        } else {
            qQLiveCookieStrategyType = QQLiveCookieStrategyType.FULL;
        }
        ((IQQLiveCookieStrategyApi) QRoute.api(IQQLiveCookieStrategyApi.class)).getCookieStrategy(qQLiveCookieStrategyType).buildAsync(new CookieDataCallback() { // from class: com.tencent.mobileqq.vaswebviewplugin.ICGameJsPlugin.1
            private void callJsWithResult(int i3, Map<String, String> map2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    map.putAll(map2);
                    jSONObject.put("retCode", i3);
                    jSONObject.put("data", new JSONObject(map));
                    ICGameJsPlugin.this.callJs(str, jSONObject.toString());
                    if (QLog.isColorLevel()) {
                        QLog.d(ICGameJsPlugin.TAG, 2, "addCookies, rsp: " + jSONObject.toString());
                    }
                    QLog.i(ICGameJsPlugin.TAG, 1, "addCookies retCode=" + i3);
                } catch (JSONException e16) {
                    QLog.e(ICGameJsPlugin.TAG, 1, e16, new Object[0]);
                    ICGameJsPlugin.this.callJs(str, jSONObject.toString());
                }
            }

            @Override // com.tencent.timi.game.api.cookie.CookieDataCallback
            public void onFailed(int i3, String str2) {
                callJsWithResult(1, new HashMap());
            }

            @Override // com.tencent.timi.game.api.cookie.CookieDataCallback
            public void onSuccess(Map<String, String> map2) {
                ((IQQLiveCookiePlanterApi) QRoute.api(IQQLiveCookiePlanterApi.class)).plantCookies(map2);
                callJsWithResult(0, map2);
            }
        });
    }
}
