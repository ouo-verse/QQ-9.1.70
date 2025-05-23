package com.tencent.mobileqq.subaccount;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.loginregister.v;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.open.OpenProxy;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static void b(AppRuntime appRuntime) {
        if (!(appRuntime instanceof AppInterface)) {
            QLog.e("qqBaseActivity", 1, "closeSubAccountBindActivity, appruntime is not QQAppInterface");
            return;
        }
        MqqHandler handler = ((AppInterface) appRuntime).getHandler(SubAccountBindActivity.class);
        if (handler != null) {
            handler.sendEmptyMessage(SubAccountBindActivity.SUBACCOUNTBINDACTIVITY_FINISH);
        }
    }

    public static void c(AppRuntime appRuntime, long j3) {
        if (!(appRuntime instanceof AppInterface)) {
            QLog.e("qqBaseActivity", 1, "closeSubAccountBindDailog, appruntime is not QQAppInterface");
            return;
        }
        MqqHandler handler = ((AppInterface) appRuntime).getHandler(SubAccountBindActivity.class);
        if (handler != null) {
            handler.sendEmptyMessageDelayed(SubAccountBindActivity.SUBACCOUNTBINDACTIVITY_CLOSE_DIALOG, j3);
        }
    }

    public static void d(AppRuntime appRuntime) {
        if (!(appRuntime instanceof AppInterface)) {
            QLog.e("qqBaseActivity", 1, "closeSubAccountUgActivity, appruntime is not QQAppInterface");
            return;
        }
        MqqHandler handler = ((AppInterface) appRuntime).getHandler(SubAccountUgActivity.class);
        if (handler != null) {
            handler.sendEmptyMessage(SubAccountUgActivity.SUBACCOUNTUGACTIVITY_FINISH);
        }
    }

    public static void e(AppRuntime appRuntime) {
        if (!(appRuntime instanceof AppInterface)) {
            QLog.e("qqBaseActivity", 1, "closeSubLoginActivity, appruntime is not QQAppInterface");
            return;
        }
        MqqHandler handler = ((AppInterface) appRuntime).getHandler(v.class);
        if (handler != null) {
            handler.sendEmptyMessage(2004);
        }
    }

    public static void f(AppRuntime appRuntime, Context context) {
        if (appRuntime != null && context != null && appRuntime.isRunning() && context.getApplicationContext() != null) {
            Context applicationContext = context.getApplicationContext();
            if (QQPlayerService.s0()) {
                Intent intent = new Intent();
                intent.setAction("qqplayer_exit_action");
                applicationContext.sendBroadcast(intent);
            }
            PatternLockUtils.setFirstEnterAfterLoginState(applicationContext, appRuntime.getAccount(), true);
        }
    }

    public static void g(final AppInterface appInterface, Context context) {
        if (appInterface != null && context != null && appInterface.isRunning() && context.getApplicationContext() != null) {
            context.getApplicationContext();
            ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).loginSuccessInit(appInterface, appInterface.getCurrentAccountUin());
            ((com.tencent.mobileqq.troop.api.handler.c) appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName())).t0();
            com.tencent.mobileqq.activity.specialcare.e.u(true);
            OpenProxy.c().a(appInterface.getCurrentAccountUin());
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.subaccount.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.j(AppInterface.this);
                }
            }, 16, null, false);
        }
    }

    public static void h(AppInterface appInterface, Context context) {
        if (appInterface != null && context != null && appInterface.isRunning() && context.getApplicationContext() != null) {
            Context applicationContext = context.getApplicationContext();
            if (((IQQPlayer) QRoute.api(IQQPlayer.class)).isPlaying()) {
                Intent intent = new Intent();
                intent.setAction("qqplayer_exit_action");
                applicationContext.sendBroadcast(intent);
            }
        }
    }

    public static void i(AppInterface appInterface, Context context, String str) {
        if (appInterface == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) AssociatedAccountActivity.class);
        intent.addFlags(335544320);
        intent.putExtra("subAccount", str);
        intent.putExtra("fromWhereExactly", 1);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(AppInterface appInterface) {
        PatternLockUtils.setFirstEnterAfterLoginState(MobileQQ.sMobileQQ.getApplicationContext(), appInterface.getCurrentAccountUin(), true);
        SharedPreferences.Editor edit = MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences(((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getQRCodeKey(), 0).edit();
        edit.clear();
        edit.commit();
    }
}
