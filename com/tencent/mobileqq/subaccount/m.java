package com.tencent.mobileqq.subaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.dc;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.loginregister.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.m;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.AutoLoginUtil;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m extends com.tencent.mobileqq.loginregister.g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f291140a;

    /* renamed from: b, reason: collision with root package name */
    private String f291141b;

    /* renamed from: c, reason: collision with root package name */
    private AppRuntime f291142c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Activity> f291143d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends com.tencent.mobileqq.loginregister.servlet.g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ x f291144d;

        a(x xVar) {
            this.f291144d = xVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this, (Object) xVar);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.loginregister.servlet.g
        protected void a(String str, String str2, String str3) {
            String str4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onGetKeyBack subUin=");
            sb5.append(StringUtil.getSimpleUinForPrint(str2));
            sb5.append(" key is ");
            Activity activity = null;
            if (str3 == null) {
                str4 = null;
            } else {
                str4 = "no null";
            }
            sb5.append(str4);
            QLog.d("SubAccountLoginActionResult", 1, sb5.toString());
            if (TextUtils.isEmpty(str3)) {
                m.this.B("actSBGeykey", false, "12005", "getKeyEmpty");
                m.this.D(R.string.hti, 1);
                m.this.w(this.f291144d);
                return;
            }
            m.this.B("actSBGeykey", true, "12006", "getKeyNotEmpty");
            if (m.this.f291140a) {
                QLog.i("SubAccountLoginActionResult", 1, "start bind sub account");
                if (m.this.f291142c instanceof AppInterface) {
                    ((AppInterface) m.this.f291142c).addObserver(new b(this.f291144d));
                }
                ((ISubAccountProtocService) m.this.f291142c.getRuntimeService(ISubAccountProtocService.class, "")).bindAccount(str2, str3, m.this.f291141b);
                return;
            }
            QLog.i("SubAccountLoginActionResult", 1, "verify sub account success");
            ((ISubAccountService) m.this.f291142c.getRuntimeService(ISubAccountService.class, "")).updateA2(str2, str3, true);
            h.J((AppInterface) m.this.f291142c, (byte) 1, str2);
            h.b((AppInterface) m.this.f291142c, str2, 7);
            f.b(m.this.f291142c);
            f.d(m.this.f291142c);
            if (m.this.f291143d != null) {
                activity = (Activity) m.this.f291143d.get();
            }
            if (activity != null) {
                f.i((AppInterface) m.this.f291142c, activity, str2);
            }
            m.this.w(this.f291144d);
            m.this.t(this.f291144d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends dc {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final x f291146d;

        b(x xVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this, (Object) xVar);
            } else {
                this.f291146d = xVar;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (m.this.f291142c instanceof AppInterface) {
                ((AppInterface) m.this.f291142c).removeObserver(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.app.dc
        protected void a(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            Activity activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), aVar);
                return;
            }
            QLog.i("SubAccountLoginActionResult", 1, "onBindSubAccount isSuccess=" + z16);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.subaccount.n
                @Override // java.lang.Runnable
                public final void run() {
                    m.b.this.e();
                }
            });
            m.this.w(this.f291146d);
            if (z16) {
                m.this.D(R.string.hry, 2);
                f.b(m.this.f291142c);
                f.d(m.this.f291142c);
                m.this.t(this.f291146d);
                return;
            }
            if (aVar == null) {
                return;
            }
            QLog.i("SubAccountLoginActionResult", 1, "onBindSubAccount errorType=" + aVar.f291121a);
            switch (aVar.f291121a) {
                case 1002:
                    if (m.this.f291143d != null) {
                        activity = (Activity) m.this.f291143d.get();
                    } else {
                        activity = null;
                    }
                    if ((activity instanceof QBaseActivity) && !activity.isFinishing()) {
                        h.O(m.this.f291142c, (QBaseActivity) activity);
                        return;
                    }
                    return;
                case 1003:
                    m.this.D(R.string.hro, 1);
                    return;
                case 1004:
                    String str = aVar.f291122b;
                    if (TextUtils.isEmpty(str)) {
                        str = BaseApplication.getContext().getString(R.string.hrp);
                    }
                    m.this.E(str, 1);
                    f.c(m.this.f291142c, 300L);
                    return;
                default:
                    m.this.D(R.string.hrn, 1);
                    return;
            }
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(int i3, String str) {
        QQToast.makeText(BaseApplication.getContext(), i3, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, boolean z16, String str2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", str2);
        hashMap.put(ISubAccountControlService.FAIL_STEP, str3);
        hashMap.put(ISubAccountControlService.FAIL_LOCATION, "subLogin");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f291142c.getCurrentAccountUin(), str, z16, 0L, 0L, hashMap, "");
    }

    private void C(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i3, int i16) {
        E(BaseApplication.getContext().getString(i3), i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(final String str, final int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C(new Runnable() { // from class: com.tencent.mobileqq.subaccount.l
            @Override // java.lang.Runnable
            public final void run() {
                m.A(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final x xVar) {
        C(new Runnable() { // from class: com.tencent.mobileqq.subaccount.k
            @Override // java.lang.Runnable
            public final void run() {
                m.this.x(xVar);
            }
        });
    }

    private void u(String str, x xVar) {
        QLog.i("SubAccountLoginActionResult", 1, "getSubAccountKey subUin=" + StringUtil.getSimpleUinForPrint(str));
        ((ILoginServletService) this.f291142c.getRuntimeService(ILoginServletService.class, "all")).getSubAccountKey(this.f291142c.getAccount(), str, new a(xVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void z(String str, x xVar) {
        ISubAccountService iSubAccountService = (ISubAccountService) this.f291142c.getRuntimeService(ISubAccountService.class, "");
        boolean isSubAccountUin = iSubAccountService.isSubAccountUin(str);
        if (this.f291140a) {
            if (TextUtils.equals(str, this.f291142c.getCurrentAccountUin())) {
                QLog.i("SubAccountLoginActionResult", 1, "bind fail, subUin equals mainUin");
                D(R.string.hsm, 1);
                w(xVar);
                return;
            } else if (isSubAccountUin) {
                QLog.i("SubAccountLoginActionResult", 1, "bind fail, duplicate bind");
                D(R.string.hsn, 1);
                w(xVar);
                return;
            }
        } else if (!isSubAccountUin) {
            QLog.i("SubAccountLoginActionResult", 1, "verify fail, not sub account");
            w(xVar);
            t(xVar);
            return;
        }
        B("actSBLogin", true, "12001", "loginsucc");
        if (!TextUtils.isEmpty(str)) {
            AutoLoginUtil.setAutoLogin(str, true);
        }
        u(str, xVar);
        iSubAccountService.updateServerError(str, 0, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final x xVar) {
        C(new Runnable() { // from class: com.tencent.mobileqq.subaccount.j
            @Override // java.lang.Runnable
            public final void run() {
                m.y(x.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(x xVar) {
        Activity activity;
        WeakReference<Activity> weakReference = this.f291143d;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.setResult(-1);
        }
        if (xVar != null) {
            xVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(x xVar) {
        if (xVar != null) {
            xVar.hideLoading();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.g, com.tencent.mobileqq.loginregister.t
    public boolean d(Activity activity, final String str, final x xVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, activity, str, xVar)).booleanValue();
        }
        if (activity != null && !activity.isFinishing()) {
            this.f291142c = ((QBaseActivity) activity).getAppRuntime();
            this.f291143d = new WeakReference<>(activity);
            if (this.f291142c != null && !TextUtils.isEmpty(str)) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    this.f291141b = intent.getStringExtra("sub_login_from_where");
                    this.f291140a = intent.getBooleanExtra("sub_login_bind", false);
                }
                QLog.i("SubAccountLoginActionResult", 1, "onSubAccountLoginSuccess mFromWhere=" + this.f291141b + " mSubLoginBind=" + this.f291140a);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.subaccount.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.this.z(str, xVar);
                    }
                }, 16, null, true);
                return true;
            }
            QLog.i("SubAccountLoginActionResult", 1, "onSubAccountLoginSuccess params invalid");
            w(xVar);
            return true;
        }
        QLog.w("SubAccountLoginActionResult", 1, "onSubAccountLoginSuccess activity is null or finishing");
        return true;
    }
}
