package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final AppRuntime f305575a;

    /* renamed from: b, reason: collision with root package name */
    protected final long f305576b;

    /* renamed from: c, reason: collision with root package name */
    protected final String f305577c;

    /* renamed from: d, reason: collision with root package name */
    protected final long f305578d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f305579e;

    /* renamed from: f, reason: collision with root package name */
    public String f305580f;

    /* renamed from: g, reason: collision with root package name */
    public String f305581g;

    /* renamed from: h, reason: collision with root package name */
    public String f305582h;

    /* renamed from: i, reason: collision with root package name */
    public long f305583i;

    /* renamed from: j, reason: collision with root package name */
    public long f305584j;

    /* renamed from: k, reason: collision with root package name */
    public int f305585k;

    /* renamed from: l, reason: collision with root package name */
    public String f305586l;

    /* renamed from: m, reason: collision with root package name */
    public long f305587m;

    /* renamed from: n, reason: collision with root package name */
    public long f305588n;

    /* renamed from: o, reason: collision with root package name */
    public long f305589o;

    /* renamed from: p, reason: collision with root package name */
    public int f305590p;

    /* renamed from: q, reason: collision with root package name */
    public int f305591q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f305592r;

    /* renamed from: s, reason: collision with root package name */
    public long f305593s;

    /* renamed from: t, reason: collision with root package name */
    public String f305594t;

    /* renamed from: u, reason: collision with root package name */
    public String f305595u;

    /* renamed from: v, reason: collision with root package name */
    public String f305596v;

    /* renamed from: w, reason: collision with root package name */
    public String f305597w;

    public o(AppRuntime appRuntime, long j3, String str, long j16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, Long.valueOf(j3), str, Long.valueOf(j16), Integer.valueOf(i3));
            return;
        }
        this.f305583i = 1L;
        this.f305584j = 0L;
        this.f305585k = 0;
        this.f305587m = 0L;
        this.f305588n = 0L;
        this.f305589o = 0L;
        this.f305590p = 0;
        this.f305591q = 0;
        this.f305592r = false;
        this.f305593s = 0L;
        this.f305575a = appRuntime;
        this.f305576b = j3;
        this.f305577c = str;
        this.f305578d = j16;
        this.f305579e = i3;
    }

    private void b(String str) {
        long j3;
        String str2;
        boolean z16;
        if (this.f305587m == 0) {
            this.f305587m = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() > this.f305587m) {
            j3 = System.currentTimeMillis() - this.f305587m;
        } else {
            j3 = 10;
        }
        long j16 = j3;
        try {
            String str3 = this.f305582h;
            if (str3 != null && str3.length() > 0) {
                String str4 = this.f305582h;
                str2 = str4.substring(str4.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER) + 3, this.f305582h.lastIndexOf(":"));
            } else {
                str2 = "";
            }
        } catch (Exception unused) {
            str2 = this.f305582h;
        }
        String str5 = this.f305595u;
        if (str5 != null && str5.length() > 0 && (this.f305595u.indexOf("Network is unreachable") > 0 || this.f305595u.indexOf("No route to host") > 0 || this.f305595u.indexOf("MalformedURLException") > 0)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!com.tencent.mobileqq.uftransfer.depend.a.A() || z16) {
            this.f305593s = 9004L;
            this.f305595u = "NotNetWork_" + this.f305595u;
        }
        if (!this.f305575a.isLogin()) {
            this.f305593s = 9004L;
            this.f305595u = "NotLogin_" + this.f305595u;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverip", str2);
        hashMap.put(ReportConstant.KEY_OLD_SERVER_IP, str2);
        hashMap.put("param_ftnIP", str2);
        hashMap.put("param_PeerUin", String.valueOf(this.f305577c));
        hashMap.put(ReportConstant.KEY_UUID, String.valueOf(this.f305580f));
        hashMap.put("param_MD5", this.f305581g);
        hashMap.put("param_FailCode", Long.toString(this.f305593s));
        hashMap.put(ReportConstant.KEY_ERR_DESC, String.valueOf(this.f305594t));
        hashMap.put("param_fsized", String.valueOf(this.f305584j));
        hashMap.put("param_fsizeo", String.valueOf(this.f305578d));
        hashMap.put("param_url", String.valueOf(this.f305597w));
        hashMap.put("param_rspHeader", String.valueOf(this.f305596v));
        hashMap.put("param_retry", String.valueOf(this.f305585k));
        hashMap.put("param_errMsg", this.f305595u + "uin[" + this.f305575a.getCurrentAccountUin() + "]");
        hashMap.put("param_nSessionId", String.valueOf(this.f305576b));
        hashMap.put("param_ipStackType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.n()));
        hashMap.put("param_realTransferType", String.valueOf(0));
        hashMap.put("param_transferdsize", String.valueOf(this.f305583i));
        hashMap.put("param_transferTime", String.valueOf(this.f305588n));
        hashMap.put("param_speed", String.valueOf(this.f305589o));
        int u16 = com.tencent.mobileqq.uftransfer.depend.a.u();
        int v3 = com.tencent.mobileqq.uftransfer.depend.a.v();
        hashMap.put("param_fromType", String.valueOf(this.f305579e));
        hashMap.put("param_V6SelectType", String.valueOf(this.f305590p));
        hashMap.put("param_ipAddrType", String.valueOf(this.f305591q));
        hashMap.put("param_stackType", String.valueOf(u16));
        hashMap.put("param_loginType", String.valueOf(v3));
        hashMap.put("param_ishttps", String.valueOf(this.f305592r));
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CReportData", 1, "Id[" + this.f305576b + "] >>> C2C_Fail_DR:actType[" + str + "] " + hashMap.toString());
        com.tencent.mobileqq.uftransfer.depend.a.b(this.f305575a.getCurrentAccountUin(), str, false, j16, this.f305583i, hashMap, this.f305586l);
    }

    private void e(String str) {
        long j3;
        String str2;
        if (this.f305587m == 0) {
            this.f305587m = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() > this.f305587m) {
            j3 = System.currentTimeMillis() - this.f305587m;
        } else {
            j3 = 10;
        }
        long j16 = j3;
        try {
            String str3 = this.f305582h;
            if (str3 != null && str3.length() > 0) {
                String str4 = this.f305582h;
                str2 = str4.substring(str4.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER) + 3, this.f305582h.lastIndexOf(":"));
            } else {
                str2 = "";
            }
        } catch (Exception unused) {
            str2 = this.f305582h;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverip", str2);
        hashMap.put(ReportConstant.KEY_OLD_SERVER_IP, str2);
        hashMap.put("param_ftnIP", str2);
        hashMap.put("param_PeerUin", this.f305577c);
        hashMap.put(ReportConstant.KEY_UUID, this.f305580f);
        hashMap.put("param_MD5", this.f305581g);
        hashMap.put("param_fsized", String.valueOf(this.f305584j));
        hashMap.put("param_fsizeo", String.valueOf(this.f305578d));
        hashMap.put("param_retry", String.valueOf(this.f305585k));
        hashMap.put("param_nSessionId", String.valueOf(this.f305576b));
        hashMap.put("param_errMsg", String.valueOf(this.f305586l));
        hashMap.put("param_ipStackType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.n()));
        hashMap.put("param_realTransferType", String.valueOf(0));
        hashMap.put("param_transferdsize", String.valueOf(this.f305583i));
        hashMap.put("param_httpTime", String.valueOf(this.f305588n));
        hashMap.put("param_speed", String.valueOf(this.f305589o));
        int u16 = com.tencent.mobileqq.uftransfer.depend.a.u();
        int v3 = com.tencent.mobileqq.uftransfer.depend.a.v();
        hashMap.put("param_fromType", String.valueOf(this.f305579e));
        hashMap.put("param_V6SelectType", String.valueOf(this.f305590p));
        hashMap.put("param_ipAddrType", String.valueOf(this.f305591q));
        hashMap.put("param_stackType", String.valueOf(u16));
        hashMap.put("param_loginType", String.valueOf(v3));
        hashMap.put("param_ishttps", String.valueOf(this.f305592r));
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CReportData", 1, "Id[" + this.f305576b + "] >>> C2C_Suc_DR:actType[" + str + "]" + hashMap.toString());
        com.tencent.mobileqq.uftransfer.depend.a.b(this.f305575a.getCurrentAccountUin(), str, true, j16, this.f305583i, hashMap, this.f305586l);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            b("actFileUp");
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            b("actFileUpDetail");
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            e("actFileUp");
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            e("actFileUpDetail");
        }
    }
}
