package com.tencent.mobileqq.accountbinding.component;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.accountbinding.f;
import com.tencent.mobileqq.accountbinding.net.AccountBindingHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import mqq.app.BuiltInServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Activity> f174564a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Dialog> f174565b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f174566c;

    /* renamed from: d, reason: collision with root package name */
    private final BroadcastReceiver f174567d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements f.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.accountbinding.data.a f174568a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f174569b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.accountbinding.data.b f174570c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AccountBindingHandler.b f174571d;

        a(com.tencent.mobileqq.accountbinding.data.a aVar, int i3, com.tencent.mobileqq.accountbinding.data.b bVar, AccountBindingHandler.b bVar2) {
            this.f174568a = aVar;
            this.f174569b = i3;
            this.f174570c = bVar;
            this.f174571d = bVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, aVar, Integer.valueOf(i3), bVar, bVar2);
            }
        }

        @Override // com.tencent.mobileqq.accountbinding.f.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f174571d.onFail(-1);
            }
        }

        @Override // com.tencent.mobileqq.accountbinding.f.b
        public void b(Bundle bundle) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            try {
                str = new JSONObject(bundle.getString("authentication")).optString(BuiltInServlet.MSF_KEY_SIG_INFO);
            } catch (JSONException e16) {
                QLog.d("AccountBindingComponent", 1, e16.toString());
                str = "";
            }
            f.this.p(this.f174568a.c(), this.f174569b, this.f174570c, str, this.f174571d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            QLog.d("AccountBindingComponent", 2, "mBroadcastReceiver onReceive");
            String action = intent.getAction();
            if (action != null && action.equals(NewIntent.ACTION_ACCOUNT_EXPIRED)) {
                f.this.h();
                f.this.q();
            }
        }
    }

    public f(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.f174566c = false;
        this.f174567d = new b();
        this.f174564a = new WeakReference<>(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.component.c
            @Override // java.lang.Runnable
            public final void run() {
                f.this.i();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        WeakReference<Dialog> weakReference;
        try {
            if (!this.f174564a.get().isFinishing() && (weakReference = this.f174565b) != null) {
                Dialog dialog = weakReference.get();
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                this.f174565b = null;
            }
        } catch (Exception e16) {
            QLog.e("AccountBindingComponent", 1, "exception : " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        Dialog dialog;
        try {
            Activity activity = this.f174564a.get();
            if (activity.isFinishing()) {
                return;
            }
            WeakReference<Dialog> weakReference = this.f174565b;
            if (weakReference == null) {
                dialog = null;
            } else {
                dialog = weakReference.get();
            }
            if (dialog == null) {
                dialog = LoadingUtil.showLoadingDialog(activity, HardCodeUtil.qqStr(R.string.f211365km), false);
                this.f174565b = new WeakReference<>(dialog);
            }
            if (dialog != null && !dialog.isShowing()) {
                dialog.show();
            }
        } catch (Exception e16) {
            QLog.e("AccountBindingComponent", 1, "exception : " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(com.tencent.mobileqq.accountbinding.data.a aVar, int i3, com.tencent.mobileqq.accountbinding.data.b bVar, AccountBindingHandler.b bVar2) {
        new com.tencent.mobileqq.accountbinding.f().b(aVar.d(), new a(aVar, i3, bVar, bVar2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(AccountBindingHandler accountBindingHandler, final AccountBindingHandler.b bVar, final int i3, final com.tencent.mobileqq.accountbinding.data.b bVar2, FromServiceMsg fromServiceMsg, Object obj) {
        q();
        h();
        final com.tencent.mobileqq.accountbinding.data.a G2 = accountBindingHandler.G2(fromServiceMsg, obj);
        int b16 = G2.b();
        QLog.d("AccountBindingComponent", 1, "bindResultType |" + b16);
        if (b16 != 0 && b16 != 1) {
            if (b16 != 2) {
                if (b16 == 3) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.component.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            QQToastUtil.showQQToast(2, R.string.f200124r_);
                        }
                    });
                    bVar.a(G2.a());
                    return;
                }
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.component.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.k(G2, i3, bVar2, bVar);
                }
            });
            return;
        }
        bVar.onFail(b16);
    }

    private void n() {
        BaseApplication.getContext().registerReceiver(this.f174567d, new IntentFilter(NewIntent.ACTION_ACCOUNT_EXPIRED));
        this.f174566c = true;
    }

    private void o() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.component.b
            @Override // java.lang.Runnable
            public final void run() {
                f.this.j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            if (this.f174566c) {
                BaseApplication.getContext().unregisterReceiver(this.f174567d);
                this.f174566c = false;
            }
        } catch (Exception e16) {
            QLog.e("AccountBindingComponent", 1, "exception : " + e16);
        }
    }

    public void p(String str, final int i3, final com.tencent.mobileqq.accountbinding.data.b bVar, String str2, final AccountBindingHandler.b bVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), bVar, str2, bVar2);
            return;
        }
        o();
        n();
        final AccountBindingHandler accountBindingHandler = (AccountBindingHandler) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(AccountBindingHandler.class.getName());
        accountBindingHandler.K2(str, i3, bVar, str2, new AccountBindingHandler.d() { // from class: com.tencent.mobileqq.accountbinding.component.a
            @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.d
            public final void a(FromServiceMsg fromServiceMsg, Object obj) {
                f.this.m(accountBindingHandler, bVar2, i3, bVar, fromServiceMsg, obj);
            }
        });
    }
}
