package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class v extends u {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    boolean f305632i;

    /* renamed from: j, reason: collision with root package name */
    long f305633j;

    /* renamed from: k, reason: collision with root package name */
    long f305634k;

    /* renamed from: l, reason: collision with root package name */
    long f305635l;

    /* renamed from: m, reason: collision with root package name */
    ExcitingTransferUploadResultRp f305636m;

    /* renamed from: n, reason: collision with root package name */
    int f305637n;

    /* renamed from: o, reason: collision with root package name */
    int f305638o;

    /* renamed from: p, reason: collision with root package name */
    int f305639p;

    public v(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f305632i = false;
        this.f305633j = 0L;
        this.f305634k = 0L;
        this.f305637n = 0;
        this.f305638o = 0;
        this.f305639p = 0;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.u
    protected String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "actGroupXTFUpload";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.u
    public HashMap<String, String> b(boolean z16) {
        AppRuntime appRuntime;
        v vVar = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) vVar, z16);
        }
        HashMap<String, String> b16 = super.b(z16);
        b16.put("param_IsFlashFile", String.valueOf(vVar.f305632i));
        b16.put("param_TotalCostTime", String.valueOf(vVar.f305635l));
        b16.put("param_CalcShaCostTime", String.valueOf(vVar.f305633j));
        b16.put("param_CalcHashCostTime", String.valueOf(vVar.f305634k));
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = vVar.f305636m;
        if (excitingTransferUploadResultRp != null) {
            b16.put("param_Result", String.valueOf(excitingTransferUploadResultRp.mnResult));
            b16.put("param_IsXTFValid", String.valueOf(vVar.f305636m.mbIsXTFValid));
            b16.put("param_HttpTime", String.valueOf(vVar.f305636m.mu64HttpTime));
            b16.put("param_SrvReturCode", String.valueOf(vVar.f305636m.mnSrvReturCode));
            b16.put("param_TransferSpeed", String.valueOf(vVar.f305636m.mu64TransferSpeed));
            b16.put("param_TransferSize", String.valueOf(vVar.f305636m.mu64TransferSize));
            b16.put("param_StartSize", String.valueOf(vVar.f305636m.mu64StartSize));
            b16.put("param_ServerIp", String.valueOf(vVar.f305636m.mstrServerIp));
            b16.put("param_ServerPort", String.valueOf((int) vVar.f305636m.mwServerPort));
            b16.put("param_FileUrl", String.valueOf(vVar.f305636m.mstrFileUrl));
            b16.put("param_MaxUploadingFtnNum", String.valueOf(vVar.f305636m.muMaxUploadingFtnNum));
            b16.put("param_RetryCount", String.valueOf(vVar.f305636m.muRetryCount));
            b16.put("param_IpChangeCount", String.valueOf(vVar.f305636m.muIpChangeCount));
            b16.put("param_RollBackCount", String.valueOf(vVar.f305636m.muRollBackCount));
            b16.put("param_QueryHoleCount", String.valueOf(vVar.f305636m.muQueryHoleCount));
            b16.put("param_RangDiffCount", String.valueOf(vVar.f305636m.muRangDiffCount));
            b16.put("param_DelayTotoalCount", String.valueOf(vVar.f305636m.muDelayTotoalCount));
            b16.put("param_TcpCnnCode", String.valueOf(vVar.f305636m.mnTcpCnnCode));
            b16.put("param_TcpSocketCode", String.valueOf(vVar.f305636m.mnTcpSocketCode));
            b16.put("param_HttpsSupport", String.valueOf((int) vVar.f305636m.mwHttpsSupport));
        } else {
            b16.put("param_IsXTFValid", String.valueOf(false));
            b16.put("param_HttpTime", String.valueOf(0));
            b16.put("param_SrvReturCode", String.valueOf(0));
            b16.put("param_TransferSpeed", String.valueOf(0));
            b16.put("param_TransferSize", String.valueOf(0));
            b16.put("param_StartSize", String.valueOf(0));
            b16.put("param_ServerIp", "");
            b16.put("param_ServerPort", String.valueOf(0));
            b16.put("param_FileUrl", "");
            b16.put("param_MaxUploadingFtnNum", String.valueOf(0));
            b16.put("param_RetryCount", String.valueOf(0));
            b16.put("param_IpChangeCount", String.valueOf(0));
            b16.put("param_RollBackCount", String.valueOf(0));
            b16.put("param_QueryHoleCount", String.valueOf(0));
            b16.put("param_RangDiffCount", String.valueOf(0));
            b16.put("param_DelayTotoalCount", String.valueOf(0));
            b16.put("param_TcpCnnCode", String.valueOf(0));
            b16.put("param_TcpSocketCode", String.valueOf(0));
            b16.put("param_HttpsSupport", String.valueOf(0));
            vVar = this;
        }
        b16.put("param_V6SelectType", String.valueOf(vVar.f305637n));
        b16.put("param_ipAddrType", String.valueOf(vVar.f305638o));
        b16.put("param_stackType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.u()));
        b16.put("param_loginType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.v()));
        b16.put("param_ishttps", String.valueOf(vVar.f305639p));
        if (!com.tencent.mobileqq.uftransfer.depend.a.A() || ((appRuntime = vVar.f305624a) != null && !appRuntime.isLogin())) {
            b16.put("param_Result", String.valueOf(2));
        }
        if (z16) {
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTToopExtfReportData", 1, ">>> Extf_Troop_Suc_DR:actType[" + a() + "] params:" + b16.toString());
        } else {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTToopExtfReportData", 1, ">>> ExtfTroop_Fail_DR:actType[" + a() + "] params:" + b16.toString());
        }
        return b16;
    }

    public void g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.f305633j = j3;
        }
    }

    public void h(ExcitingTransferUploadResultRp excitingTransferUploadResultRp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) excitingTransferUploadResultRp);
        } else {
            this.f305636m = excitingTransferUploadResultRp;
        }
    }

    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f305638o = i3;
        }
    }

    public void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f305632i = z16;
        }
    }

    public void k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.f305639p = z16 ? 1 : 0;
        }
    }

    public void l(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.f305635l = j3;
        }
    }

    public void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f305637n = i3;
        }
    }
}
