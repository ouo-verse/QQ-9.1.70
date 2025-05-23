package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final AppRuntime f305522a;

    /* renamed from: b, reason: collision with root package name */
    long f305523b;

    /* renamed from: c, reason: collision with root package name */
    int f305524c;

    /* renamed from: d, reason: collision with root package name */
    long f305525d;

    /* renamed from: e, reason: collision with root package name */
    long f305526e;

    /* renamed from: f, reason: collision with root package name */
    String f305527f;

    /* renamed from: g, reason: collision with root package name */
    String f305528g;

    /* renamed from: h, reason: collision with root package name */
    long f305529h;

    /* renamed from: i, reason: collision with root package name */
    boolean f305530i;

    /* renamed from: j, reason: collision with root package name */
    long f305531j;

    /* renamed from: k, reason: collision with root package name */
    long f305532k;

    /* renamed from: l, reason: collision with root package name */
    long f305533l;

    /* renamed from: m, reason: collision with root package name */
    int f305534m;

    /* renamed from: n, reason: collision with root package name */
    int f305535n;

    /* renamed from: o, reason: collision with root package name */
    int f305536o;

    /* renamed from: p, reason: collision with root package name */
    ExcitingTransferUploadResultRp f305537p;

    public g(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f305523b = 0L;
        this.f305524c = 0;
        this.f305525d = 0L;
        this.f305526e = 0L;
        this.f305529h = 0L;
        this.f305530i = false;
        this.f305531j = 0L;
        this.f305532k = 0L;
        this.f305534m = 0;
        this.f305535n = 0;
        this.f305536o = 0;
        this.f305522a = appRuntime;
    }

    protected HashMap<String, String> a() {
        String str;
        AppRuntime appRuntime;
        g gVar = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (HashMap) iPatchRedirector.redirect((short) 14, (Object) gVar);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_ReportVer", String.valueOf(1));
        hashMap.put("param_TransferType", String.valueOf(0));
        hashMap.put("param_Platform", String.valueOf(2));
        hashMap.put("param_AppType", String.valueOf(0));
        hashMap.put("param_Result", String.valueOf(gVar.f305524c));
        hashMap.put("param_FileName", String.valueOf(gVar.f305527f));
        hashMap.put("param_Suffix", String.valueOf(gVar.f305528g));
        hashMap.put("param_TargetUin", String.valueOf(gVar.f305525d));
        hashMap.put("param_GroupCode", String.valueOf(gVar.f305526e));
        hashMap.put("param_FileSize", String.valueOf(gVar.f305529h));
        hashMap.put("param_IsFlashFile", String.valueOf(gVar.f305530i));
        hashMap.put("param_TotalCostTime", String.valueOf(gVar.f305533l));
        hashMap.put("param_CalcShaCostTime", String.valueOf(gVar.f305531j));
        hashMap.put("param_CalcHashCostTime", String.valueOf(gVar.f305532k));
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = gVar.f305537p;
        if (excitingTransferUploadResultRp == null) {
            str = "param_Result";
            hashMap.put("param_IsXTFValid", String.valueOf(false));
            hashMap.put("param_HttpTime", String.valueOf(0));
            hashMap.put("param_SrvReturCode", String.valueOf(0));
            hashMap.put("param_TransferSpeed", String.valueOf(0));
            hashMap.put("param_TransferSize", String.valueOf(0));
            hashMap.put("param_StartSize", String.valueOf(0));
            hashMap.put("param_ServerIp", "");
            hashMap.put("param_ServerPort", String.valueOf(0));
            hashMap.put("param_FileUrl", "");
            hashMap.put("param_MaxUploadingFtnNum", String.valueOf(0));
            hashMap.put("param_RetryCount", String.valueOf(0));
            hashMap.put("param_IpChangeCount", String.valueOf(0));
            hashMap.put("param_RollBackCount", String.valueOf(0));
            hashMap.put("param_QueryHoleCount", String.valueOf(0));
            hashMap.put("param_RangDiffCount", String.valueOf(0));
            hashMap.put("param_DelayTotoalCount", String.valueOf(0));
            hashMap.put("param_TcpCnnCode", String.valueOf(0));
            hashMap.put("param_TcpSocketCode", String.valueOf(0));
            hashMap.put("param_HttpsSupport", String.valueOf(0));
            gVar = this;
        } else {
            hashMap.put("param_Result", String.valueOf(excitingTransferUploadResultRp.mnResult));
            hashMap.put("param_IsXTFValid", String.valueOf(gVar.f305537p.mbIsXTFValid));
            hashMap.put("param_HttpTime", String.valueOf(gVar.f305537p.mu64HttpTime));
            hashMap.put("param_SrvReturCode", String.valueOf(gVar.f305537p.mnSrvReturCode));
            hashMap.put("param_TransferSpeed", String.valueOf(gVar.f305537p.mu64TransferSpeed));
            hashMap.put("param_TransferSize", String.valueOf(gVar.f305537p.mu64TransferSize));
            hashMap.put("param_StartSize", String.valueOf(gVar.f305537p.mu64StartSize));
            hashMap.put("param_ServerIp", String.valueOf(gVar.f305537p.mstrServerIp));
            hashMap.put("param_ServerPort", String.valueOf((int) gVar.f305537p.mwServerPort));
            hashMap.put("param_FileUrl", String.valueOf(gVar.f305537p.mstrFileUrl));
            hashMap.put("param_MaxUploadingFtnNum", String.valueOf(gVar.f305537p.muMaxUploadingFtnNum));
            hashMap.put("param_RetryCount", String.valueOf(gVar.f305537p.muRetryCount));
            hashMap.put("param_IpChangeCount", String.valueOf(gVar.f305537p.muIpChangeCount));
            hashMap.put("param_RollBackCount", String.valueOf(gVar.f305537p.muRollBackCount));
            hashMap.put("param_QueryHoleCount", String.valueOf(gVar.f305537p.muQueryHoleCount));
            hashMap.put("param_RangDiffCount", String.valueOf(gVar.f305537p.muRangDiffCount));
            hashMap.put("param_DelayTotoalCount", String.valueOf(gVar.f305537p.muDelayTotoalCount));
            hashMap.put("param_TcpCnnCode", String.valueOf(gVar.f305537p.mnTcpCnnCode));
            hashMap.put("param_TcpSocketCode", String.valueOf(gVar.f305537p.mnTcpSocketCode));
            hashMap.put("param_HttpsSupport", String.valueOf((int) gVar.f305537p.mwHttpsSupport));
            str = "param_Result";
        }
        hashMap.put("param_V6SelectType", String.valueOf(gVar.f305534m));
        hashMap.put("param_ipAddrType", String.valueOf(gVar.f305535n));
        hashMap.put("param_stackType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.u()));
        hashMap.put("param_loginType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.v()));
        hashMap.put("param_ishttps", String.valueOf(gVar.f305536o));
        if (!com.tencent.mobileqq.uftransfer.depend.a.A() || ((appRuntime = gVar.f305522a) != null && !appRuntime.isLogin())) {
            hashMap.put(str, String.valueOf(2));
        }
        return hashMap;
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        HashMap<String, String> a16 = a();
        String str = "null";
        if (z16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Id[");
            sb5.append(this.f305523b);
            sb5.append("] >>> Extf_C2C_Suc_DR:act[");
            sb5.append("actC2CXTFUpload");
            sb5.append("] ");
            if (a16 != null) {
                str = a16.toString();
            }
            sb5.append(str);
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CExtfReportData", 1, sb5.toString());
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Id[");
            sb6.append(this.f305523b);
            sb6.append("] >>> Extf_C2C_Fail_DR:act[");
            sb6.append("actC2CXTFUpload");
            sb6.append("] ");
            if (a16 != null) {
                str = a16.toString();
            }
            sb6.append(str);
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CExtfReportData", 1, sb6.toString());
        }
        com.tencent.mobileqq.uftransfer.depend.a.b(this.f305522a.getCurrentAccountUin(), "actC2CXTFUpload", z16, 0L, 0L, a16, "");
    }

    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.f305531j = j3;
        }
    }

    public void d(ExcitingTransferUploadResultRp excitingTransferUploadResultRp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) excitingTransferUploadResultRp);
        } else {
            this.f305537p = excitingTransferUploadResultRp;
        }
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f305535n = i3;
        }
    }

    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f305530i = z16;
        }
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.f305536o = z16 ? 1 : 0;
        }
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f305524c = i3;
        }
    }

    public void i(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.f305523b = j3;
        }
    }

    public void j(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            this.f305533l = j3;
        }
    }

    public void k(long j3, long j16, String str, String str2, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16), str, str2, Long.valueOf(j17));
            return;
        }
        this.f305525d = j3;
        this.f305526e = j16;
        this.f305527f = str;
        this.f305528g = str2;
        this.f305529h = j17;
    }

    public void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f305534m = i3;
        }
    }
}
