package com.tencent.mobileqq.login;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.ErrMsg;
import tencent.im.login.GatewayVerify$RspBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ai {
    static IPatchRedirector $redirector_;

    private static void A(final Activity activity, final String str, final String str2) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (TextUtils.isEmpty(str)) {
                str = HardCodeUtil.qqStr(R.string.f172151nv4);
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ad
                @Override // java.lang.Runnable
                public final void run() {
                    ai.y(activity, str, str2);
                }
            });
        }
    }

    private static int h(byte[] bArr) {
        if (bArr == null) {
            QLog.d("LoginFailedHelper", 1, "getTipsScenesId tlvData is null");
            return 0;
        }
        try {
            GatewayVerify$RspBody gatewayVerify$RspBody = new GatewayVerify$RspBody();
            gatewayVerify$RspBody.mergeFrom(bArr);
            if (gatewayVerify$RspBody.msg_rsp_lft_info.uint32_lft_forbid_area.get() != 1) {
                QLog.d("LoginFailedHelper", 1, "getTipsScenesId not area im");
                return 0;
            }
            QLog.d("LoginFailedHelper", 1, "getTipsScenesId scene_id=" + gatewayVerify$RspBody.msg_rsp_tips_info.uint32_scene_id.get());
            return gatewayVerify$RspBody.msg_rsp_tips_info.uint32_scene_id.get();
        } catch (Exception e16) {
            QLog.e("LoginFailedHelper", 1, "getTipsScenesId error: ", e16);
            return 0;
        }
    }

    private static void i(QBaseActivity qBaseActivity, int i3, String str, String str2, boolean z16, aj ajVar) {
        Intent intent;
        boolean z17;
        String str3;
        Intent intent2;
        int i16;
        String str4;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            Intent intent3 = new Intent();
            intent3.putExtra("type", 8);
            if (ajVar.f241864a == 40) {
                if (!TextUtils.isEmpty(str)) {
                    str3 = "msg";
                    intent2 = intent3;
                    ReportController.r(peekAppRuntime, "dc00898", "", "", "0X800AC0B", "0X800AC0B", 0, 0, "", "", "", "");
                    if (((ILoginApi) QRoute.api(ILoginApi.class)).handleLoginFailedByThirdPartyLogin(qBaseActivity, ajVar.f241869f, str, str2)) {
                        QLog.i("LoginFailedHelper", 1, "handleLoginFailedByThirdPartyLogin true");
                        return;
                    }
                    z17 = true;
                } else {
                    str3 = "msg";
                    intent2 = intent3;
                    z17 = true;
                }
                intent = intent2;
                intent.putExtra(str3, ajVar.f241866c);
                ErrMsg errMsg = ajVar.f241867d;
                boolean z18 = false;
                if (errMsg != null) {
                    i16 = errMsg.getVersion();
                } else {
                    i16 = 0;
                }
                intent.putExtra("errorver", i16);
                intent.putExtra("tlverror", ajVar.f241869f);
                ErrMsg errMsg2 = ajVar.f241867d;
                String str5 = null;
                if (errMsg2 != null) {
                    str4 = errMsg2.getTitle();
                } else {
                    str4 = null;
                }
                intent.putExtra("errortitle", str4);
                ErrMsg errMsg3 = ajVar.f241867d;
                if (errMsg3 != null) {
                    str5 = errMsg3.getTitle();
                }
                intent.putExtra("title", str5);
                intent.putExtra("is_need_login_with_mask", z16);
                if (h(ajVar.f241869f) == z17) {
                    intent.putExtra("uin", str);
                    intent.putExtra("passwd", str2);
                    if (i3 == z17) {
                        z18 = z17 ? 1 : 0;
                    }
                    intent.putExtra("is_from_login", z18);
                    intent.putExtra("keyTipsScenesId", z17 ? 1 : 0);
                }
            } else {
                intent = intent3;
                z17 = true;
                intent.putExtra("msg", ajVar.f241866c + " " + ajVar.f241868e);
            }
            intent.putExtra("loginalias", str);
            intent.putExtra("loginret", ajVar.f241864a);
            intent.putExtra(OpenHippyInfo.EXTRA_KEY_ERROR_URL, ajVar.f241868e);
            intent.putExtra("expiredSig", ajVar.f241870g);
            if (!TextUtils.isEmpty(str)) {
                if (z17 == i3) {
                    intent.putExtra("keyFromLoginView", z17);
                } else if (2 == i3) {
                    intent.putExtra("keyFromBindAccount", z17);
                } else if (3 == i3) {
                    intent.putExtra("keyFromAddAccount", z17);
                }
            }
            RouteUtils.startActivity(qBaseActivity, intent, RouterConstants.UI_ROUTER_NOTIFICATION);
            return;
        }
        QLog.w("LoginFailedHelper", 1, "handleAccountFrozen appRuntime is null or activity is finishing");
    }

    public static void j(QBaseActivity qBaseActivity, c cVar, aj ajVar) {
        String str;
        QLog.i("LoginFailedHelper", 1, "[AccountLogin] handleLoginFail ret=" + ajVar.f241864a + " scene=" + cVar.f242201b);
        z(cVar.f242042f, cVar.f242201b, ajVar.f241864a, ajVar.f241866c);
        int i3 = ajVar.f241864a;
        if (-1000 == i3) {
            QLog.i("LoginFailedHelper", 1, "[AccountLogin] show network error toast");
            final String string = BaseApplication.getContext().getResources().getString(R.string.f171137ci2);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ae
                @Override // java.lang.Runnable
                public final void run() {
                    ai.s(string);
                }
            });
            ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C199", "0X800C199", cVar.f242201b, 0, "", "", "", string);
            return;
        }
        if (-999 == i3) {
            o(ajVar);
            return;
        }
        if (q(i3)) {
            QLog.i("LoginFailedHelper", 1, "[AccountLogin] handleLHExpired");
            k(qBaseActivity, ajVar);
            return;
        }
        if (ajVar.f241864a == 40) {
            QLog.i("LoginFailedHelper", 1, "[AccountLogin] handleAccountFrozen");
            i(qBaseActivity, cVar.f242201b, cVar.f242042f, cVar.f242043g, cVar.f242046j, ajVar);
            return;
        }
        if (((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).handleLoginErrorInfo(qBaseActivity, ajVar.f241869f, new com.tencent.mobileqq.loginregister.h(Integer.valueOf(cVar.f242201b), cVar.f242042f, cVar.f242201b, ajVar.f241864a))) {
            QLog.i("LoginFailedHelper", 1, "[AccountLogin] ILoginFailedCommonSceneHandlerApi handleLoginErrorInfo");
            return;
        }
        ErrMsg errMsg = ajVar.f241867d;
        if (errMsg != null) {
            str = errMsg.getTitle();
        } else {
            str = null;
        }
        A(qBaseActivity, str, ajVar.f241866c);
    }

    private static void k(QBaseActivity qBaseActivity, aj ajVar) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null && qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("LoginFailedHelper", 4, "handleLHExpired lhUin=" + ajVar.f241871h);
            }
            Intent intent = new Intent();
            intent.putExtra("type", 8);
            intent.putExtra("msg", ajVar.f241866c + " " + ajVar.f241868e);
            intent.putExtra("loginret", ajVar.f241864a);
            intent.putExtra(OpenHippyInfo.EXTRA_KEY_ERROR_URL, ajVar.f241868e);
            intent.putExtra("expiredSig", ajVar.f241870g);
            intent.putExtra("loginalias", ajVar.f241871h);
            RouteUtils.startActivity(qBaseActivity, intent, RouterConstants.UI_ROUTER_NOTIFICATION);
            return;
        }
        QLog.w("LoginFailedHelper", 1, "handleLHExpired appRuntime is null or activity is finishing");
    }

    public static boolean l(final QBaseActivity qBaseActivity, int i3, aj ajVar, boolean z16) {
        String str;
        QLog.i("LoginFailedHelper", 1, "[PhoneGatewayLogin] handlePhoneSmsLoginFail ret=" + ajVar.f241864a + " scene=" + i3);
        int i16 = ajVar.f241864a;
        if (i16 == 219) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ab
                @Override // java.lang.Runnable
                public final void run() {
                    ai.t(QBaseActivity.this);
                }
            });
            return true;
        }
        if (-999 == i16) {
            o(ajVar);
            return true;
        }
        if (q(i16)) {
            QLog.i("LoginFailedHelper", 1, "[PhoneGatewayLogin] handleLHExpired");
            k(qBaseActivity, ajVar);
            return true;
        }
        if (ajVar.f241864a == 40) {
            QLog.i("LoginFailedHelper", 1, "[PhoneGatewayLogin] handleAccountFrozen");
            i(qBaseActivity, i3, null, null, false, ajVar);
            return true;
        }
        if (((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).handleLoginErrorInfo(qBaseActivity, ajVar.f241869f, new com.tencent.mobileqq.loginregister.h(Integer.valueOf(i3), "", i3, ajVar.f241864a))) {
            QLog.i("LoginFailedHelper", 1, "[PhoneGatewayLogin] ILoginFailedCommonSceneHandlerApi handleLoginErrorInfo");
            return false;
        }
        if (!z16) {
            return false;
        }
        ErrMsg errMsg = ajVar.f241867d;
        String str2 = null;
        if (errMsg != null) {
            str = errMsg.getTitle();
        } else {
            str = null;
        }
        ErrMsg errMsg2 = ajVar.f241867d;
        if (errMsg2 != null) {
            str2 = errMsg2.getMessage();
        }
        A(qBaseActivity, str, str2);
        return true;
    }

    public static boolean m(final QBaseActivity qBaseActivity, ay ayVar, aj ajVar) {
        String str;
        QLog.i("LoginFailedHelper", 1, "[PhonePwdLogin] handlePhonePwdLoginFail ret=" + ajVar.f241864a + " scene=" + ayVar.f242201b);
        int i3 = ajVar.f241864a;
        if (i3 == 219) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ag
                @Override // java.lang.Runnable
                public final void run() {
                    ai.u(QBaseActivity.this);
                }
            });
            return false;
        }
        if (-999 == i3) {
            o(ajVar);
            return false;
        }
        if (q(i3)) {
            QLog.i("LoginFailedHelper", 1, "[PhonePwdLogin] handleLHExpired");
            k(qBaseActivity, ajVar);
            return true;
        }
        if (ajVar.f241864a == 40) {
            QLog.i("LoginFailedHelper", 1, "[PhonePwdLogin] handleAccountFrozen");
            i(qBaseActivity, ayVar.f242201b, null, null, false, ajVar);
            return true;
        }
        if (((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).handleLoginErrorInfo(qBaseActivity, ajVar.f241869f, new com.tencent.mobileqq.loginregister.h(Integer.valueOf(ayVar.f242201b), ayVar.f241929f, ayVar.f242201b, ajVar.f241864a))) {
            QLog.i("LoginFailedHelper", 1, "[PhonePwdLogin] ILoginFailedCommonSceneHandlerApi handleLoginErrorInfo");
            return true;
        }
        QLog.i("LoginFailedHelper", 1, "[PhonePwdLogin] show phone login fail dialog");
        ErrMsg errMsg = ajVar.f241867d;
        String str2 = null;
        if (errMsg != null) {
            str = errMsg.getTitle();
        } else {
            str = null;
        }
        String str3 = ajVar.f241866c;
        if (TextUtils.isEmpty(str3)) {
            ErrMsg errMsg2 = ajVar.f241867d;
            if (errMsg2 != null) {
                str2 = errMsg2.getMessage();
            }
            str3 = str2;
        }
        A(qBaseActivity, str, str3);
        return true;
    }

    public static void n(final QBaseActivity qBaseActivity, int i3, aj ajVar) {
        String str;
        QLog.i("LoginFailedHelper", 1, "[PhoneLogin] handlePhoneSmsLoginFail ret=" + ajVar.f241864a + " scene=" + i3);
        int i16 = ajVar.f241864a;
        if (i16 == 219) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ah
                @Override // java.lang.Runnable
                public final void run() {
                    ai.v(QBaseActivity.this);
                }
            });
            return;
        }
        if (-999 == i16) {
            o(ajVar);
            return;
        }
        if (q(i16)) {
            QLog.i("LoginFailedHelper", 1, "[PhoneLogin] handleLHExpired");
            k(qBaseActivity, ajVar);
            return;
        }
        if (ajVar.f241864a == 40) {
            QLog.i("LoginFailedHelper", 1, "[PhoneLogin] handleAccountFrozen");
            i(qBaseActivity, i3, null, null, false, ajVar);
            return;
        }
        if (((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).handleLoginErrorInfo(qBaseActivity, ajVar.f241869f, new com.tencent.mobileqq.loginregister.h(Integer.valueOf(i3), "", i3, ajVar.f241864a))) {
            QLog.i("LoginFailedHelper", 1, "[PhoneLogin] ILoginFailedCommonSceneHandlerApi handleLoginErrorInfo");
            return;
        }
        QLog.i("LoginFailedHelper", 1, "[PhoneLogin] show phone login fail dialog");
        ErrMsg errMsg = ajVar.f241867d;
        String str2 = null;
        if (errMsg != null) {
            str = errMsg.getTitle();
        } else {
            str = null;
        }
        String str3 = ajVar.f241866c;
        if (TextUtils.isEmpty(str3)) {
            ErrMsg errMsg2 = ajVar.f241867d;
            if (errMsg2 != null) {
                str2 = errMsg2.getMessage();
            }
            str3 = str2;
        }
        A(qBaseActivity, str, str3);
    }

    private static void o(final aj ajVar) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ac
            @Override // java.lang.Runnable
            public final void run() {
                ai.w(aj.this);
            }
        });
    }

    public static void p(QBaseActivity qBaseActivity, int i3, aj ajVar) {
        String str;
        int i16 = ajVar.f241864a;
        if (-999 == i16) {
            o(ajVar);
            return;
        }
        if (q(i16)) {
            QLog.i("LoginFailedHelper", 1, "[WeChatLogin] handleLHExpired");
            k(qBaseActivity, ajVar);
            return;
        }
        if (ajVar.f241864a == 40) {
            QLog.i("LoginFailedHelper", 1, "[WeChatLogin] handleAccountFrozen");
            i(qBaseActivity, i3, null, null, false, ajVar);
            return;
        }
        if (((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).handleLoginErrorInfo(qBaseActivity, ajVar.f241869f, new com.tencent.mobileqq.loginregister.h(Integer.valueOf(i3), "", i3, ajVar.f241864a))) {
            QLog.i("LoginFailedHelper", 1, "[WeChatLogin] ILoginFailedCommonSceneHandlerApi handleLoginErrorInfo");
            return;
        }
        QLog.i("LoginFailedHelper", 1, "[WeChatLogin] show login fail dialog");
        ErrMsg errMsg = ajVar.f241867d;
        if (errMsg != null) {
            str = errMsg.getTitle();
        } else {
            str = null;
        }
        A(qBaseActivity, str, ajVar.f241866c);
    }

    private static boolean q(int i3) {
        if (41 != i3 && 116 != i3) {
            return false;
        }
        return true;
    }

    public static boolean r(String str) {
        if (TextUtils.isEmpty(str) || str.charAt(0) == '0' || str.length() < 5 || str.length() > 12) {
            return false;
        }
        for (char c16 : str.toCharArray()) {
            if (!Character.isDigit(c16)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(String str) {
        QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(QBaseActivity qBaseActivity) {
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            com.tencent.mobileqq.util.bk.g(qBaseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(QBaseActivity qBaseActivity) {
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            com.tencent.mobileqq.util.bk.g(qBaseActivity);
            com.tencent.mobileqq.util.bk.k("0X800B8D6");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(QBaseActivity qBaseActivity) {
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            com.tencent.mobileqq.util.bk.g(qBaseActivity);
            com.tencent.mobileqq.util.bk.k("0X800B8D6");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(aj ajVar) {
        String str;
        if (ajVar != null) {
            str = ajVar.f241866c;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = BaseApplication.getContext().getString(R.string.f200704su);
        }
        QQToast.makeText(BaseApplication.getContext(), 1, str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(Activity activity, String str, String str2) {
        DialogUtil.createCustomDialog(activity, 230, str, str2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.af
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }, null).show();
    }

    private static void z(String str, int i3, int i16, String str2) {
        String str3;
        String str4;
        if (i16 != 1) {
            if (i16 != 40) {
                str3 = "3";
            } else {
                str3 = "2";
            }
        } else {
            str3 = "1";
        }
        String str5 = str3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (r(str)) {
            str4 = str;
        } else {
            str4 = "";
        }
        ReportController.r(peekAppRuntime, "dc00898", "", str4, "0X800BAB6", "0X800BAB6", i3, 0, String.valueOf(i16), str5, str2, str);
    }
}
