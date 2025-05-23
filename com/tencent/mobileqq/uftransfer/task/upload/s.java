package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final AppRuntime f305602a;

    /* renamed from: b, reason: collision with root package name */
    private final String f305603b;

    /* renamed from: c, reason: collision with root package name */
    private final String f305604c;

    /* renamed from: d, reason: collision with root package name */
    private final String f305605d;

    /* renamed from: e, reason: collision with root package name */
    public long f305606e;

    /* renamed from: f, reason: collision with root package name */
    public String f305607f;

    /* renamed from: g, reason: collision with root package name */
    public long f305608g;

    /* renamed from: h, reason: collision with root package name */
    public long f305609h;

    /* renamed from: i, reason: collision with root package name */
    public long f305610i;

    /* renamed from: j, reason: collision with root package name */
    public long f305611j;

    /* renamed from: k, reason: collision with root package name */
    public long f305612k;

    /* renamed from: l, reason: collision with root package name */
    public long f305613l;

    /* renamed from: m, reason: collision with root package name */
    public String f305614m;

    /* renamed from: n, reason: collision with root package name */
    public String f305615n;

    /* renamed from: o, reason: collision with root package name */
    public int f305616o;

    /* renamed from: p, reason: collision with root package name */
    public String f305617p;

    /* renamed from: q, reason: collision with root package name */
    public long f305618q;

    /* renamed from: r, reason: collision with root package name */
    public long f305619r;

    /* renamed from: s, reason: collision with root package name */
    public long f305620s;

    /* renamed from: t, reason: collision with root package name */
    public int f305621t;

    /* renamed from: u, reason: collision with root package name */
    public String f305622u;

    /* renamed from: v, reason: collision with root package name */
    public String f305623v;

    public s(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) str);
            return;
        }
        this.f305602a = appRuntime;
        this.f305605d = str;
        this.f305603b = "actDiscussFileUp";
        this.f305604c = "actDiscussFileUpDetail";
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (r6.f305607f.indexOf("MalformedURLException") > 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HashMap<String, String> a() {
        String str;
        boolean z16;
        AppRuntime appRuntime;
        try {
            String str2 = this.f305614m;
            if (str2 != null && str2.length() > 0) {
                String str3 = this.f305614m;
                str = str3.substring(str3.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER) + 3, this.f305614m.lastIndexOf(":"));
            } else {
                str = null;
            }
        } catch (Exception unused) {
            str = this.f305614m;
        }
        if (this.f305606e != 0) {
            if (TextUtils.isEmpty(this.f305607f)) {
                z16 = true;
                if (this.f305607f.indexOf("Network is unreachable") <= 0) {
                    if (this.f305607f.indexOf("No route to host") <= 0) {
                    }
                }
                if (com.tencent.mobileqq.uftransfer.depend.a.A() || z16) {
                    this.f305606e = 9004L;
                    this.f305607f = "NotNetWork_" + this.f305607f;
                }
                appRuntime = this.f305602a;
                if (appRuntime != null && !appRuntime.isLogin()) {
                    this.f305606e = 9004L;
                    this.f305607f = "NotLogin_" + this.f305607f;
                }
            }
            z16 = false;
            if (com.tencent.mobileqq.uftransfer.depend.a.A()) {
            }
            this.f305606e = 9004L;
            this.f305607f = "NotNetWork_" + this.f305607f;
            appRuntime = this.f305602a;
            if (appRuntime != null) {
                this.f305606e = 9004L;
                this.f305607f = "NotLogin_" + this.f305607f;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_serverip", String.valueOf(str));
        hashMap.put(ReportConstant.KEY_OLD_SERVER_IP, String.valueOf(str));
        hashMap.put("param_PeerUin", String.valueOf(this.f305615n));
        hashMap.put("param_PeerType", String.valueOf(this.f305616o));
        hashMap.put(ReportConstant.KEY_UUID, String.valueOf(this.f305617p));
        hashMap.put("param_FailCode", Long.toString(this.f305606e));
        hashMap.put("param_fsized", String.valueOf(this.f305618q));
        hashMap.put("param_fsizeo", String.valueOf(this.f305620s));
        hashMap.put("param_url", String.valueOf(this.f305614m));
        hashMap.put("param_rspHeader", String.valueOf(this.f305622u));
        hashMap.put("param_retry", String.valueOf(this.f305621t));
        hashMap.put("param_errMsg", String.valueOf(this.f305607f));
        hashMap.put("param_nSessionId", String.valueOf(this.f305608g));
        hashMap.put("param_CSDuration", String.valueOf(this.f305610i - this.f305609h));
        hashMap.put("param_HttpDuration", String.valueOf(this.f305612k - this.f305611j));
        hashMap.put("param_AllDuration", String.valueOf(this.f305613l - this.f305609h));
        return hashMap;
    }

    public void b() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f305612k;
        if (currentTimeMillis < 0) {
            j3 = 0;
        } else {
            j3 = currentTimeMillis;
        }
        this.f305613l = System.currentTimeMillis();
        HashMap<String, String> a16 = a();
        String str = "null";
        boolean z16 = true;
        if (this.f305606e == 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Id[");
            sb5.append(this.f305608g);
            sb5.append("] >>> Disc_Suc_DR:actType[");
            sb5.append(this.f305603b);
            sb5.append("]");
            if (a16 != null) {
                str = a16.toString();
            }
            sb5.append(str);
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscReportData", 1, sb5.toString());
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Id[");
            sb6.append(this.f305608g);
            sb6.append("] >>> Disc_Fail_DR:actType[");
            sb6.append(this.f305603b);
            sb6.append("]");
            if (a16 != null) {
                str = a16.toString();
            }
            sb6.append(str);
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscReportData", 1, sb6.toString());
        }
        String str2 = this.f305605d;
        String str3 = this.f305603b;
        if (this.f305606e != 0) {
            z16 = false;
        }
        com.tencent.mobileqq.uftransfer.depend.a.b(str2, str3, z16, j3, this.f305619r, a16, this.f305623v);
    }

    public void c() {
        long j3;
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f305612k;
        if (currentTimeMillis < 0) {
            j3 = 0;
        } else {
            j3 = currentTimeMillis;
        }
        this.f305613l = System.currentTimeMillis();
        HashMap<String, String> a16 = a();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Id[");
        sb5.append(this.f305608g);
        sb5.append("] >>> Disc_Fail_DR:actType[");
        sb5.append(this.f305604c);
        sb5.append("]");
        if (a16 != null) {
            str = a16.toString();
        } else {
            str = "null";
        }
        sb5.append(str);
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscReportData", 1, sb5.toString());
        String str2 = this.f305605d;
        String str3 = this.f305604c;
        if (this.f305606e == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.uftransfer.depend.a.b(str2, str3, z16, j3, this.f305619r, a16, this.f305623v);
    }
}
