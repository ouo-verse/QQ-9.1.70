package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final AppRuntime f305538a;

    /* renamed from: b, reason: collision with root package name */
    long f305539b;

    /* renamed from: c, reason: collision with root package name */
    int f305540c;

    /* renamed from: d, reason: collision with root package name */
    long f305541d;

    /* renamed from: e, reason: collision with root package name */
    long f305542e;

    /* renamed from: f, reason: collision with root package name */
    String f305543f;

    /* renamed from: g, reason: collision with root package name */
    String f305544g;

    /* renamed from: h, reason: collision with root package name */
    long f305545h;

    /* renamed from: i, reason: collision with root package name */
    ExcitingTransferUploaderRp f305546i;

    /* renamed from: j, reason: collision with root package name */
    int f305547j;

    /* renamed from: k, reason: collision with root package name */
    int f305548k;

    /* renamed from: l, reason: collision with root package name */
    int f305549l;

    public h(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
            return;
        }
        this.f305539b = 0L;
        this.f305540c = 0;
        this.f305541d = 0L;
        this.f305542e = 0L;
        this.f305545h = 0L;
        this.f305547j = 0;
        this.f305548k = 0;
        this.f305549l = 0;
        this.f305538a = appRuntime;
    }

    protected HashMap<String, String> a() {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashMap) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_TransferType", String.valueOf(0));
        hashMap.put("param_Platform", String.valueOf(2));
        hashMap.put("param_AppType", String.valueOf(0));
        hashMap.put("param_Result", String.valueOf(this.f305540c));
        hashMap.put("param_FileName", String.valueOf(this.f305543f));
        hashMap.put("param_Suffix", String.valueOf(this.f305544g));
        hashMap.put("param_TargetUin", String.valueOf(this.f305541d));
        hashMap.put("param_GroupCode", String.valueOf(this.f305542e));
        hashMap.put("param_FileSize", String.valueOf(this.f305545h));
        ExcitingTransferUploaderRp excitingTransferUploaderRp = this.f305546i;
        if (excitingTransferUploaderRp != null) {
            hashMap.put("param_Result", String.valueOf(excitingTransferUploaderRp.mnResult));
            hashMap.put("param_IsBigData", String.valueOf(this.f305546i.mbIsBigData));
            hashMap.put("param_HttpTime", String.valueOf(this.f305546i.mu64HttpTime));
            hashMap.put("param_SrvReturCode", String.valueOf(this.f305546i.mnSrvReturCode));
            hashMap.put("param_TransferSpeed", String.valueOf(this.f305546i.mu64TransferSpeed));
            hashMap.put("param_TransferSize", String.valueOf(this.f305546i.mu64TransferSize));
            hashMap.put("param_ServerIp", String.valueOf(this.f305546i.mstrServerIp));
            hashMap.put("param_ServerPort", String.valueOf((int) this.f305546i.mwServerPort));
            hashMap.put("param_FileUrl", String.valueOf(this.f305546i.mstrFileUrl));
        } else {
            hashMap.put("param_IsBigData", String.valueOf(false));
            hashMap.put("param_HttpTime", String.valueOf(0));
            hashMap.put("param_SrvReturCode", String.valueOf(0));
            hashMap.put("param_TransferSpeed", String.valueOf(0));
            hashMap.put("param_TransferSize", String.valueOf(0));
            hashMap.put("param_ServerIp", String.valueOf(0));
            hashMap.put("param_ServerPort", String.valueOf(0));
            hashMap.put("param_FileUrl", "");
        }
        hashMap.put("param_V6SelectType", String.valueOf(this.f305547j));
        hashMap.put("param_ipAddrType", String.valueOf(this.f305548k));
        hashMap.put("param_stackType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.u()));
        hashMap.put("param_loginType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.v()));
        hashMap.put("param_ishttps", String.valueOf(this.f305549l));
        if (!com.tencent.mobileqq.uftransfer.depend.a.A() || ((appRuntime = this.f305538a) != null && !appRuntime.isLogin())) {
            hashMap.put("param_Result", String.valueOf(2));
        }
        return hashMap;
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        HashMap<String, String> a16 = a();
        String str = "null";
        if (z16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Id[");
            sb5.append(this.f305539b);
            sb5.append("] >>> Extf_C2CUper_Suc_DR:act[");
            sb5.append("actC2CXTFUploadSender");
            sb5.append("]");
            if (a16 != null) {
                str = a16.toString();
            }
            sb5.append(str);
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CExtfReportData", 1, sb5.toString());
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Id[");
            sb6.append(this.f305539b);
            sb6.append("] >>> Extf_C2CUper_Fail_DR:act[");
            sb6.append("actC2CXTFUploadSender");
            sb6.append("]");
            if (a16 != null) {
                str = a16.toString();
            }
            sb6.append(str);
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CExtfReportData", 1, sb6.toString());
        }
        com.tencent.mobileqq.uftransfer.depend.a.b(this.f305538a.getCurrentAccountUin(), "actC2CXTFUploadSender", z16, 0L, 0L, a16, "");
    }

    public void c(ExcitingTransferUploaderRp excitingTransferUploaderRp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) excitingTransferUploaderRp);
        } else {
            this.f305546i = excitingTransferUploaderRp;
        }
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f305548k = i3;
        }
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.f305549l = z16 ? 1 : 0;
        }
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f305540c = i3;
        }
    }

    public void g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        } else {
            this.f305539b = j3;
        }
    }

    public void h(long j3, long j16, String str, String str2, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), str, str2, Long.valueOf(j17));
            return;
        }
        this.f305541d = j3;
        this.f305542e = j16;
        this.f305543f = str;
        this.f305544g = str2;
        this.f305545h = j17;
    }

    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f305547j = i3;
        }
    }
}
