package com.tencent.mobileqq.login.servlet;

import android.content.Context;
import android.os.Bundle;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.login.verify.PuzzleVerifyInfo;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static void a(int i3, String str, String str2, Bundle bundle, d dVar) {
        NewIntent newIntent = new NewIntent(c(), c.class);
        newIntent.putExtra("action", 2304);
        newIntent.putExtra(TangramHippyConstants.LOGIN_TYPE, i3);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("code", str2);
        newIntent.putExtra("passThroughParams", bundle);
        newIntent.withouLogin = true;
        newIntent.setObserver(dVar);
        b().startServlet(newIntent);
    }

    private static AppRuntime b() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private static Context c() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    public static void d(String str, Bundle bundle, d dVar) {
        NewIntent newIntent = new NewIntent(c(), c.class);
        newIntent.putExtra("action", 2303);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("passThroughParams", bundle);
        newIntent.withouLogin = true;
        newIntent.setObserver(dVar);
        b().startServlet(newIntent);
    }

    public static void e(String str, byte[] bArr, byte[] bArr2, Bundle bundle, a aVar) {
        NewIntent newIntent = new NewIntent(c(), c.class);
        newIntent.putExtra("action", 1001);
        newIntent.putExtra("account", str);
        newIntent.putExtra(NotificationActivity.PASSWORD, bArr);
        if (bArr2 != null) {
            newIntent.putExtra(MsfConstants.ATTRIBUTE_LOGIN_UIN_ENCRYPT, bArr2);
        }
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }
        newIntent.setObserver(aVar);
        newIntent.withouLogin = true;
        b().startServlet(newIntent);
    }

    public static void f(String str, String str2, byte[] bArr, int i3, Bundle bundle, Bundle bundle2, a aVar) {
        NewIntent newIntent = new NewIntent(c(), c.class);
        newIntent.putExtra("action", 1100);
        newIntent.putExtra("ssoAccount", str);
        newIntent.putExtra("ssoPassword", str2);
        newIntent.putExtra("targetTicket", i3);
        if (bArr != null) {
            newIntent.putExtra(MsfConstants.ATTRIBUTE_LOGIN_UIN_ENCRYPT, bArr);
        }
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }
        if (bundle2 != null) {
            newIntent.putExtra("extra", bundle2);
        }
        newIntent.setObserver(aVar);
        newIntent.withouLogin = true;
        b().startServlet(newIntent);
    }

    public static void g(String str, String str2, String str3, byte[] bArr, Bundle bundle, a aVar) {
        NewIntent newIntent = new NewIntent(c(), c.class);
        newIntent.putExtra("action", 1035);
        newIntent.putExtra("mainaccount", str);
        newIntent.putExtra("subaccount", str2);
        newIntent.putExtra("subpassword", str3);
        if (bArr != null) {
            newIntent.putExtra(MsfConstants.ATTRIBUTE_LOGIN_UIN_ENCRYPT, bArr);
        }
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }
        newIntent.setObserver(aVar);
        newIntent.withouLogin = true;
        b().startServlet(newIntent);
    }

    public static void h(int i3, String str, PuzzleVerifyInfo puzzleVerifyInfo, Bundle bundle, d dVar) {
        NewIntent newIntent = new NewIntent(c(), c.class);
        newIntent.putExtra("action", 2300);
        newIntent.putExtra(TangramHippyConstants.LOGIN_TYPE, i3);
        newIntent.putExtra("ticket", str);
        newIntent.putExtra("verifyInfo", puzzleVerifyInfo);
        newIntent.putExtra("passThroughParams", bundle);
        newIntent.withouLogin = true;
        newIntent.setObserver(dVar);
        b().startServlet(newIntent);
    }
}
