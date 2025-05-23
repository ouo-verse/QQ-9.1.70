package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class w extends u {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    ExcitingTransferUploaderRp f305640i;

    /* renamed from: j, reason: collision with root package name */
    int f305641j;

    /* renamed from: k, reason: collision with root package name */
    int f305642k;

    /* renamed from: l, reason: collision with root package name */
    int f305643l;

    public w(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f305641j = 0;
        this.f305642k = 0;
        this.f305643l = 0;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.u
    protected String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "actGroupXTFUploadSender";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.u
    public HashMap<String, String> b(boolean z16) {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
        HashMap<String, String> b16 = super.b(z16);
        ExcitingTransferUploaderRp excitingTransferUploaderRp = this.f305640i;
        if (excitingTransferUploaderRp != null) {
            b16.put("param_Result", String.valueOf(excitingTransferUploaderRp.mnResult));
            b16.put("param_IsBigData", String.valueOf(this.f305640i.mbIsBigData));
            b16.put("param_HttpTime", String.valueOf(this.f305640i.mu64HttpTime));
            b16.put("param_SrvReturCode", String.valueOf(this.f305640i.mnSrvReturCode));
            b16.put("param_TransferSpeed", String.valueOf(this.f305640i.mu64TransferSpeed));
            b16.put("param_TransferSize", String.valueOf(this.f305640i.mu64TransferSize));
            b16.put("param_ServerIp", String.valueOf(this.f305640i.mstrServerIp));
            b16.put("param_ServerPort", String.valueOf((int) this.f305640i.mwServerPort));
            b16.put("param_FileUrl", String.valueOf(this.f305640i.mstrFileUrl));
        } else {
            b16.put("param_IsBigData", String.valueOf(false));
            b16.put("param_HttpTime", String.valueOf(0));
            b16.put("param_SrvReturCode", String.valueOf(0));
            b16.put("param_TransferSpeed", String.valueOf(0));
            b16.put("param_TransferSize", String.valueOf(0));
            b16.put("param_ServerIp", String.valueOf(0));
            b16.put("param_ServerPort", String.valueOf(0));
            b16.put("param_FileUrl", "");
        }
        b16.put("param_V6SelectType", String.valueOf(this.f305641j));
        b16.put("param_ipAddrType", String.valueOf(this.f305642k));
        b16.put("param_stackType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.u()));
        b16.put("param_loginType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.v()));
        b16.put("param_ishttps", String.valueOf(this.f305643l));
        if (!com.tencent.mobileqq.uftransfer.depend.a.A() || ((appRuntime = this.f305624a) != null && !appRuntime.isLogin())) {
            b16.put("param_Result", String.valueOf(2));
        }
        if (z16) {
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTToopExtfReportData", 1, ">>> Extf_Troop_Suc_DR:actType[" + a() + "] params:" + b16.toString());
        } else {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTToopExtfReportData", 1, ">>> ExtfTroop_Fail_DR:actType[" + a() + "] params:" + b16.toString());
        }
        return b16;
    }

    public void g(ExcitingTransferUploaderRp excitingTransferUploaderRp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) excitingTransferUploaderRp);
        } else {
            this.f305640i = excitingTransferUploaderRp;
        }
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f305642k = i3;
        }
    }

    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.f305643l = z16 ? 1 : 0;
        }
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f305641j = i3;
        }
    }
}
