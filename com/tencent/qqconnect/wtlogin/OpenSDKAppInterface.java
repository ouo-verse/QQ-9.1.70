package com.tencent.qqconnect.wtlogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.utils.ProAvatarComponentUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.open.agent.util.t;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.ticket.NtTicketInvalidFixUtils;
import com.tencent.open.ticket.OpenTicketHelper;
import com.tencent.open.util.OpenSdkProcessSwitchAccountHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import hp3.f;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenSDKAppInterface extends AbstractOpenSdkAppInterface {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f344965f;

    /* renamed from: h, reason: collision with root package name */
    private final IErrorHandler f344966h;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements IErrorHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OpenSDKAppInterface.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onGrayError(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, toServiceMsg, fromServiceMsg, Boolean.valueOf(z16));
            } else {
                t.f("OpenSDKAppInterface", "onGrayError");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onInvalidSign(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                t.f("OpenSDKAppInterface", "onInvalidSign");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onKicked(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, Boolean.valueOf(z16));
            } else {
                t.f("OpenSDKAppInterface", "onKicked");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onKickedAndClearToken(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, Boolean.valueOf(z16));
            } else {
                t.f("OpenSDKAppInterface", "onKickedAndClearToken");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onRecvServerTip(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, Boolean.valueOf(z16));
            } else {
                t.f("OpenSDKAppInterface", "onRecvServerTip");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onServerSuspended(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, Boolean.valueOf(z16));
            } else {
                t.f("OpenSDKAppInterface", "onServerSuspended");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onUserTokenExpired(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, Boolean.valueOf(z16));
                return;
            }
            t.e("OpenSDKAppInterface", "onUserTokenExpired. fromServiceMsg: " + fromServiceMsg);
            if (fromServiceMsg != null) {
                String uin = fromServiceMsg.getUin();
                if (uin != null && !uin.equals(OpenSDKAppInterface.this.getAccount())) {
                    if (fromServiceMsg.getUinType() == 0) {
                        OpenTicketHelper.e(fromServiceMsg.getUin(), true);
                    } else if (fromServiceMsg.getUinType() == 6) {
                        OpenTicketHelper.e(fromServiceMsg.getUin(), false);
                    }
                }
                if (OpensdkServlet.a(fromServiceMsg.getServiceCmd())) {
                    OpenSDKAppInterface.this.getServletContainer().notifyMSFServlet(OpensdkServlet.class, fromServiceMsg);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OpenSDKAppInterface.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            t.b("OpenSDKAppInterface", "onReceive action : " + action);
            if (NewIntent.ACTION_ACCOUNT_KICKED.equals(action)) {
                OpenSDKAppInterface.super.exitToolProc();
                return;
            }
            if (NewIntent.ACTION_ACCOUNT_CHANGED.equals(action) && OpenSdkProcessSwitchAccountHelper.b()) {
                t.f("OpenSDKAppInterface", "onReceive ACTION_ACCOUNT_CHANGED");
                String stringExtra = intent.getStringExtra("account");
                if (!TextUtils.isEmpty(stringExtra)) {
                    SimpleAccount simpleAccount = new SimpleAccount();
                    simpleAccount.setUin(stringExtra);
                    simpleAccount.setAttribute(SimpleAccount._ISLOGINED, "true");
                    t.f("OpenSDKAppInterface", "switching account: " + MsfSdkUtils.getShortUin(stringExtra));
                    OpenSDKAppInterface.this.switchAccount(simpleAccount, null);
                    return;
                }
                t.e("OpenSDKAppInterface", "onReceive ACTION_ACCOUNT_CHANGED but account is null or empty");
            }
        }
    }

    public OpenSDKAppInterface(BaseApplicationImpl baseApplicationImpl, String str) {
        super(baseApplicationImpl, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl, (Object) str);
        } else {
            this.f344966h = new a();
        }
    }

    @Override // com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface
    public Object fetchQQLiteStatus(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) fVar);
        }
        return d.c(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        t.f("OpenSDKAppInterface", "onCreate: invoked.  savedInstanceState: " + bundle);
        com.tencent.open.agent.util.d.A(new com.tencent.open.agent.util.a());
        this.f344965f = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        if (OpenSdkProcessSwitchAccountHelper.b()) {
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        }
        this.app.registerReceiver(this.f344965f, intentFilter);
        if (NtTicketInvalidFixUtils.a()) {
            MainService service = getService();
            if (service != null) {
                service.setCustomErrorHandler(this.f344966h);
            } else {
                t.f("OpenSDKAppInterface", "onCreate: service is null");
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqconnect.wtlogin.OpenSDKAppInterface.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OpenSDKAppInterface.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ProAvatarComponentUtils.g();
                }
            }
        }, 240, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        QLog.i("OpenSDKAppInterface", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        MobileQQ mobileQQ = this.app;
        if (mobileQQ != null) {
            mobileQQ.unregisterReceiver(this.f344965f);
        }
    }
}
