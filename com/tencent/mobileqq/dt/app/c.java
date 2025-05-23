package com.tencent.mobileqq.dt.app;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dt.tip.O3AIONotifyBannerManager;
import com.tencent.mobileqq.dt.web.O3BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private MMKVOptionEntity f203744a;

    /* renamed from: b, reason: collision with root package name */
    private IAccountCallback f203745b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f203746c;

    /* renamed from: d, reason: collision with root package name */
    private final String f203747d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements IAccountCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
                return;
            }
            if (appRuntime != null) {
                String currentAccountUin = appRuntime.getCurrentAccountUin();
                QLog.i("FEKitMain_UinManager", 1, "onAccountChanged " + c.this.f(currentAccountUin));
                c.this.k(currentAccountUin);
                c.this.h(currentAccountUin);
                O3AIONotifyBannerManager.f203873a.d();
                return;
            }
            QLog.e("FEKitMain_UinManager", 1, "onAccountChanged but runtime is null");
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason logoutReason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) logoutReason);
                return;
            }
            QLog.i("FEKitMain_UinManager", 1, "onLogout");
            c.this.k("0");
            c.this.h("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends com.tencent.mobileqq.dt.web.a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f203749f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f203750h;

        b(int i3, String str) {
            this.f203749f = i3;
            this.f203750h = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, Integer.valueOf(i3), str);
            }
        }

        @Override // com.tencent.mobileqq.dt.web.a
        public void b(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                return;
            }
            QLog.i("FEKitMain_UinManager", 1, "onResult taskSeq is " + this.f203749f + " curSeq is " + c.this.f203746c + " code " + i3);
            if (this.f203749f == c.this.f203746c && i3 != 0) {
                c.this.i(this.f203749f, this.f203750h);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f203744a = null;
        this.f203745b = null;
        this.f203746c = 0;
        this.f203747d = Process.myPid() + "_" + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 4) {
            return "*" + str.substring(str.length() - 4);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        this.f203746c++;
        int i3 = this.f203746c;
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("account", str);
            jSONObject.put("seq", i3);
            jSONObject.put("process", this.f203747d);
        } catch (JSONException e16) {
            QLog.e("FEKitMain_UinManager", 1, "json parse error", e16);
        }
        i(i3, jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3, String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            O3BusinessHandler o3BusinessHandler = (O3BusinessHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(O3BusinessHandler.class.getName());
            QLog.i("FEKitMain_UinManager", 1, "start taskSeq is " + i3);
            o3BusinessHandler.E2("onAccountChanged", str, new b(i3, str), 10000L);
            return;
        }
        QLog.e("FEKitMain_UinManager", 1, "notifyOnAccountChange but rumtime is null");
    }

    private void j() {
        if (this.f203745b == null) {
            QLog.i("FEKitMain_UinManager", 1, "registerLogoutCallback");
            a aVar = new a();
            this.f203745b = aVar;
            MobileQQ.sMobileQQ.registerAccountCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str) {
        if (this.f203744a == null) {
            this.f203744a = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        }
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.f203744a.encodeString("mainAccount", str);
    }

    public void g() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            if (peekAppRuntime.isLogin()) {
                str = peekAppRuntime.getCurrentAccountUin();
                QLog.i("FEKitMain_UinManager", 1, "init uin is " + f(str));
                k(str);
                j();
                h(str);
            }
        } else {
            QLog.e("FEKitMain_UinManager", 1, "init but runtime is null");
        }
        str = "0";
        QLog.i("FEKitMain_UinManager", 1, "init uin is " + f(str));
        k(str);
        j();
        h(str);
    }
}
