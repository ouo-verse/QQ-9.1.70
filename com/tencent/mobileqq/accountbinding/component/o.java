package com.tencent.mobileqq.accountbinding.component;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.accountbinding.f;
import com.tencent.mobileqq.accountbinding.net.AccountBindingHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import mqq.app.BuiltInServlet;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Activity> f174601a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Dialog> f174602b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements f.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f174603a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.accountbinding.data.b f174604b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f174605c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f174606d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AccountBindingHandler.e f174607e;

        a(long j3, com.tencent.mobileqq.accountbinding.data.b bVar, int i3, String str, AccountBindingHandler.e eVar) {
            this.f174603a = j3;
            this.f174604b = bVar;
            this.f174605c = i3;
            this.f174606d = str;
            this.f174607e = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, o.this, Long.valueOf(j3), bVar, Integer.valueOf(i3), str, eVar);
            }
        }

        @Override // com.tencent.mobileqq.accountbinding.f.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f174607e.onFail(-1);
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
                str = new JSONObject(bundle.getString("authentication")).getString(BuiltInServlet.MSF_KEY_SIG_INFO);
            } catch (JSONException e16) {
                e16.printStackTrace();
                str = "";
            }
            o.this.t(this.f174603a, this.f174604b, false, this.f174605c, this.f174606d, str, this.f174607e);
        }
    }

    public o(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            this.f174601a = new WeakReference<>(activity);
        }
    }

    private void i(final long j3, final com.tencent.mobileqq.accountbinding.data.b bVar, final String str, final String str2, final AccountBindingHandler.e eVar) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.component.k
            @Override // java.lang.Runnable
            public final void run() {
                o.this.m(j3, bVar, str, str2, eVar);
            }
        });
    }

    private void j() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.component.l
            @Override // java.lang.Runnable
            public final void run() {
                o.this.n();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(long j3, com.tencent.mobileqq.accountbinding.data.b bVar, String str, String str2, AccountBindingHandler.e eVar, DialogInterface dialogInterface, int i3) {
        t(j3, bVar, true, 1, str, str2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(final long j3, final com.tencent.mobileqq.accountbinding.data.b bVar, final String str, final String str2, final AccountBindingHandler.e eVar) {
        Activity activity = this.f174601a.get();
        if (activity.isFinishing()) {
            return;
        }
        DialogUtil.createCustomDialog(activity, HardCodeUtil.qqStr(R.string.f200824t6), HardCodeUtil.qqStr(R.string.f200814t5), HardCodeUtil.qqStr(R.string.nvd), HardCodeUtil.qqStr(R.string.f200834t7), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.accountbinding.component.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                o.this.k(j3, bVar, str, str2, eVar, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.accountbinding.component.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.cancel();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        WeakReference<Dialog> weakReference;
        try {
            if (!this.f174601a.get().isFinishing() && (weakReference = this.f174602b) != null) {
                Dialog dialog = weakReference.get();
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                this.f174602b = null;
            }
        } catch (Exception e16) {
            QLog.e("AccountUnBindingComponent", 1, "exception : " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        Dialog dialog;
        try {
            Activity activity = this.f174601a.get();
            if (activity.isFinishing()) {
                return;
            }
            WeakReference<Dialog> weakReference = this.f174602b;
            if (weakReference == null) {
                dialog = null;
            } else {
                dialog = weakReference.get();
            }
            if (dialog == null) {
                dialog = LoadingUtil.showLoadingDialog(activity, HardCodeUtil.qqStr(R.string.f211365km), false);
                this.f174602b = new WeakReference<>(dialog);
            }
            if (dialog != null && !dialog.isShowing()) {
                dialog.show();
            }
        } catch (Exception e16) {
            QLog.e("AccountUnBindingComponent", 1, "exception : " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(com.tencent.mobileqq.accountbinding.data.c cVar, long j3, com.tencent.mobileqq.accountbinding.data.b bVar, int i3, String str, AccountBindingHandler.e eVar) {
        new com.tencent.mobileqq.accountbinding.f().b(cVar.b(), new a(j3, bVar, i3, str, eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(AccountBindingHandler accountBindingHandler, final int i3, final long j3, final com.tencent.mobileqq.accountbinding.data.b bVar, String str, final AccountBindingHandler.e eVar, FromServiceMsg fromServiceMsg, Object obj) {
        j();
        final com.tencent.mobileqq.accountbinding.data.c H2 = accountBindingHandler.H2(fromServiceMsg, obj);
        int c16 = H2.c();
        final String a16 = H2.a();
        QLog.d("AccountUnBindingComponent", 1, "unbindType" + c16);
        if (c16 != 2) {
            if (c16 != 3) {
                if (c16 != 4) {
                    eVar.onFail(c16);
                    return;
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.component.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            QQToastUtil.showQQToast(2, R.string.f200894tc);
                        }
                    });
                    eVar.onSuccess();
                    return;
                }
            }
            if (i3 == 1) {
                i(j3, bVar, a16, str, eVar);
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.component.h
            @Override // java.lang.Runnable
            public final void run() {
                o.this.p(H2, j3, bVar, i3, a16, eVar);
            }
        });
    }

    private void s() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.component.j
            @Override // java.lang.Runnable
            public final void run() {
                o.this.o();
            }
        });
    }

    public void t(final long j3, final com.tencent.mobileqq.accountbinding.data.b bVar, boolean z16, final int i3, String str, final String str2, final AccountBindingHandler.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), bVar, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, eVar);
            return;
        }
        s();
        final AccountBindingHandler accountBindingHandler = (AccountBindingHandler) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(AccountBindingHandler.class.getName());
        accountBindingHandler.L2(j3, bVar, z16, i3, str, str2, new AccountBindingHandler.d() { // from class: com.tencent.mobileqq.accountbinding.component.g
            @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.d
            public final void a(FromServiceMsg fromServiceMsg, Object obj) {
                o.this.r(accountBindingHandler, i3, j3, bVar, str2, eVar, fromServiceMsg, obj);
            }
        });
    }
}
