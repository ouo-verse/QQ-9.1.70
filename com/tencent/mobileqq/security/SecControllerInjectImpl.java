package com.tencent.mobileqq.security;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qqsec.api.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.ReportLog;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SecControllerInjectImpl implements c {
    static IPatchRedirector $redirector_;

    public SecControllerInjectImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.c
    public void a(Context context, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            if (z16) {
                if (QQPlayerService.s0()) {
                    context.sendBroadcast(new Intent("qqplayer_exit_action"));
                    return;
                }
                return;
            }
            context.sendBroadcast(new Intent("qqplayer_exit_action"));
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.c
    public void b(QBaseActivity qBaseActivity, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qBaseActivity, Boolean.valueOf(z16), str);
            return;
        }
        Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        qBaseActivity.startActivity(intent);
        if (z16 && ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).isBlockNotifyActivity(qBaseActivity) && !qBaseActivity.isFinishing()) {
            ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).enableJumpLoginFromFund(qBaseActivity);
        } else {
            qBaseActivity.finish();
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.c
    public void c(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) str);
        } else {
            PatternLockUtils.setFirstEnterAfterLoginState(context, str, true);
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.c
    public void d(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) str);
        } else {
            MyAppApi.z().o0(str, new DialogInterface.OnClickListener(activity) { // from class: com.tencent.mobileqq.security.SecControllerInjectImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f285273d;

                {
                    this.f285273d = activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SecControllerInjectImpl.this, (Object) activity);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.security.SecControllerInjectImpl.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                try {
                                    LockMethodProxy.sleep(1500L);
                                } catch (InterruptedException e16) {
                                    e16.printStackTrace();
                                }
                                ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).exitApp(AnonymousClass1.this.f285273d);
                            }
                        });
                    }
                }
            }, activity);
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.c
    public void e(BaseQQAppInterface baseQQAppInterface, ProgressDialog progressDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) baseQQAppInterface, (Object) progressDialog);
            return;
        }
        ReportLog.e(baseQQAppInterface.getAccount());
        ((QQAppInterface) baseQQAppInterface).getServerConfigValue(ServerConfigManager.ConfigType.app, "log_upload");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            String account = waitAppRuntime.getAccount();
            if (QLog.isColorLevel()) {
                QLog.d("SecControllerInjectImpl", 2, " NotificationActivity crash uin=", account);
            }
            ReportLog.f(progressDialog, account);
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.c
    public void f(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) qBaseActivity);
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.c
    public void g(Activity activity, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity, (Object) jSONObject);
            return;
        }
        Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(activity);
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
        bundle.putString("callbackSn", "lhPaySn");
        payBridgeIntent.putExtras(bundle);
        payBridgeIntent.putExtra("payparmas_from_is_login_state", false);
        payBridgeIntent.putExtra("pay_requestcode", 4);
        activity.startActivityForResult(payBridgeIntent, 1);
    }

    @Override // com.tencent.mobileqq.qqsec.api.c
    public ArrayList<String> h(BaseQQAppInterface baseQQAppInterface) {
        ISubAccountService iSubAccountService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseQQAppInterface);
        }
        if (TextUtils.isEmpty(baseQQAppInterface.getAccount()) || (iSubAccountService = (ISubAccountService) baseQQAppInterface.getRuntimeService(ISubAccountService.class, "")) == null) {
            return null;
        }
        return iSubAccountService.getAllSubUin();
    }

    @Override // com.tencent.mobileqq.qqsec.api.c
    public void i(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        ConfigHandler configHandler = (ConfigHandler) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
        if (configHandler != null) {
            configHandler.close();
        }
    }
}
