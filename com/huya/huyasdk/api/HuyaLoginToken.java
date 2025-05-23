package com.huya.huyasdk.api;

import android.text.TextUtils;
import com.huya.huyasdk.service.api.ILoginService;
import hynb.i.a;
import hynb.j.d;
import hynb.p.g;
import hynb.v.b;
import hynb.v.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuyaLoginToken {
    public static final String LOGIN_REQUEST_EVENT_ID = "state/login_request";
    public static final String LOGIN_RESULT_EVENT_ID = "state/login_result";
    public static final String LOGOUT_EVENT_ID = "state/logout";
    public static final String TAG = "HuyaLoginToken";

    public static boolean hasLogin() {
        return ((ILoginService) d.a(ILoginService.class)).isLogin();
    }

    public static void loginWithOpenIdAndAccessToken(String str, String str2, final LoginResultCallback loginResultCallback) {
        a.a().a(LOGIN_REQUEST_EVENT_ID, new HashMap());
        if (TextUtils.isEmpty(str)) {
            g.f406799a.info(TAG, "loginWithOpenIdAndAccessToken: openId is empty");
            HuyaLoginResult failWithResCode = HuyaLoginResult.failWithResCode(-5);
            a.a().a(LOGIN_RESULT_EVENT_ID, result2ReportMap(failWithResCode));
            if (loginResultCallback != null) {
                loginResultCallback.onLoginResult(failWithResCode);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            g.f406799a.info(TAG, "loginWithOpenIdAndAccessToken: accessToken is empty");
            HuyaLoginResult failWithResCode2 = HuyaLoginResult.failWithResCode(-6);
            a.a().a(LOGIN_RESULT_EVENT_ID, result2ReportMap(failWithResCode2));
            if (loginResultCallback != null) {
                loginResultCallback.onLoginResult(failWithResCode2);
                return;
            }
            return;
        }
        hynb.v.g gVar = new hynb.v.g();
        gVar.f406907f = "1";
        gVar.f406903b = str;
        hynb.f.a.f406701h.a(hynb.n.a.a().f406767a, str2, gVar, "", new f<b>() { // from class: com.huya.huyasdk.api.HuyaLoginToken.1
            @Override // hynb.v.f
            public void onResponse(b bVar) {
                HuyaLoginResult b16 = hynb.f.a.b(bVar);
                g.f406799a.a(HuyaLoginToken.TAG, "loginWithConfig: " + b16);
                a.a().a(HuyaLoginToken.LOGIN_RESULT_EVENT_ID, HuyaLoginToken.result2ReportMap(b16));
                LoginResultCallback loginResultCallback2 = LoginResultCallback.this;
                if (loginResultCallback2 != null) {
                    loginResultCallback2.onLoginResult(b16);
                }
            }
        });
    }

    public static void logout() {
        g.f406799a.info(TAG, "logout");
        a.a().a(LOGOUT_EVENT_ID, new HashMap());
        hynb.f.a.f406701h.f();
    }

    public static Map<String, String> result2ReportMap(HuyaLoginResult huyaLoginResult) {
        String str;
        HashMap hashMap = new HashMap();
        if (huyaLoginResult != null) {
            if (huyaLoginResult.isSucceed()) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("result", str);
            hashMap.put("errorcode", String.valueOf(huyaLoginResult.getResCode()));
        }
        return hashMap;
    }
}
