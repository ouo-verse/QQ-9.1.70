package com.tencent.mobileqq.login.servlet;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.login.remind.n;
import com.tencent.mobileqq.loginregister.servlet.i;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.login.GatewayVerify$ReqBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    private static AppRuntime a() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private static Context b() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    public static void c(String str, String str2, String str3, String str4, boolean z16, String str5, e eVar) {
        NewIntent newIntent = new NewIntent(b(), i.class);
        newIntent.putExtra("action", 2307);
        newIntent.putExtra("appid", 16);
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        gatewayVerify$ReqBody.msg_req_third_login.msg_req_wechat.str_code.set(z.g(str));
        gatewayVerify$ReqBody.msg_req_third_login.msg_req_wechat.str_appid.set(z.g(str2));
        gatewayVerify$ReqBody.msg_req_third_login.msg_req_wechat.str_profile_sig.set(z.g(str3));
        gatewayVerify$ReqBody.msg_req_third_login.msg_req_wechat.setHasFlag(true);
        gatewayVerify$ReqBody.msg_req_third_login.uint32_service_type.set(5);
        gatewayVerify$ReqBody.msg_req_third_login.setHasFlag(true);
        if (!TextUtils.isEmpty(str4)) {
            gatewayVerify$ReqBody.msg_req_common_info.str_verify_sig.set(str4);
        }
        gatewayVerify$ReqBody.msg_req_common_info.setHasFlag(true);
        gatewayVerify$ReqBody.msg_req_common_info.bool_not_realname_forbid_login_low_version.set(true);
        gatewayVerify$ReqBody.msg_req_common_info.bool_need_remind_in_cancel_status.set(n.f242580a.c(str5));
        gatewayVerify$ReqBody.setHasFlag(true);
        newIntent.putExtra("wxLoginData", gatewayVerify$ReqBody.toByteArray());
        if (z16) {
            newIntent.putExtra("from_where", "subaccount");
            newIntent.putExtra("mainaccount", a().getCurrentAccountUin());
        }
        newIntent.setObserver(eVar);
        newIntent.withouLogin = true;
        a().startServlet(newIntent);
    }

    public static void d(String str, String str2, e eVar) {
        NewIntent newIntent = new NewIntent(b(), com.tencent.mobileqq.loginregister.servlet.c.class);
        newIntent.putExtra("action", 2308);
        newIntent.putExtra("wxCode", z.g(str));
        newIntent.putExtra("wxAppId", z.g(str2));
        newIntent.setObserver(eVar);
        newIntent.withouLogin = true;
        a().startServlet(newIntent);
    }

    public static void e(String str, String str2, String str3, e eVar) {
        NewIntent newIntent = new NewIntent(b(), i.class);
        newIntent.putExtra("action", 2306);
        newIntent.putExtra("appid", 16);
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        gatewayVerify$ReqBody.msg_req_third_login.msg_req_wechat.str_code.set(z.g(str));
        gatewayVerify$ReqBody.msg_req_third_login.msg_req_wechat.str_appid.set(z.g(str2));
        gatewayVerify$ReqBody.msg_req_third_login.msg_req_wechat.str_profile_sig.set(z.g(str3));
        gatewayVerify$ReqBody.msg_req_third_login.msg_req_wechat.setHasFlag(true);
        gatewayVerify$ReqBody.msg_req_third_login.uint32_service_type.set(5);
        gatewayVerify$ReqBody.msg_req_third_login.setHasFlag(true);
        gatewayVerify$ReqBody.msg_req_common_info.bool_not_realname_forbid_login_low_version.set(true);
        gatewayVerify$ReqBody.msg_req_common_info.setHasFlag(true);
        gatewayVerify$ReqBody.msg_req_common_info.bool_need_remind_in_cancel_status.set(false);
        gatewayVerify$ReqBody.setHasFlag(true);
        newIntent.putExtra("wxLoginData", gatewayVerify$ReqBody.toByteArray());
        newIntent.setObserver(eVar);
        newIntent.withouLogin = true;
        a().startServlet(newIntent);
    }
}
