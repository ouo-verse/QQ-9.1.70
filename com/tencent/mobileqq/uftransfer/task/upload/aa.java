package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes19.dex */
public class aa extends com.tencent.mobileqq.uftransfer.task.utils.c {
    static IPatchRedirector $redirector_;
    protected final AppRuntime E;

    public aa(AppRuntime appRuntime, String str, String str2) {
        super(str, str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, str, str2);
        } else {
            this.E = appRuntime;
        }
    }

    public static int b(int i3, int i16) {
        if (i16 == 404) {
            return 303;
        }
        int i17 = i16 + LightConstants.ErrorCode.TEMPLATE_JSON_EMPTY;
        if (i17 >= 0 && i17 < 100) {
            return 304;
        }
        int i18 = i16 + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT;
        if (i18 >= 0 && i18 < 100) {
            return 305;
        }
        if (i3 == 9024) {
            return 303;
        }
        if (i3 == 9060) {
            return 304;
        }
        if (i3 == 9061) {
            return 305;
        }
        if (i3 != 9052 && i3 != 9055 && i3 != 9053 && i3 != 9054) {
            return i3;
        }
        return 307;
    }

    private void d(String str) {
        boolean z16;
        long j3;
        long j16;
        String str2 = this.f305687q;
        if (str2 != null && str2.length() > 0 && (this.f305687q.indexOf("Network is unreachable") > 0 || this.f305687q.indexOf("No route to host") > 0 || this.f305687q.indexOf("MalformedURLException") > 0)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!com.tencent.mobileqq.uftransfer.depend.a.A() || z16) {
            this.f305681k = 9;
            this.f305682l = 901;
            this.f305687q = "NotNetWork_" + this.f305687q;
        }
        if (!this.E.isLogin()) {
            this.f305681k = 9;
            this.f305682l = 901;
            this.f305687q = "NotLogin_" + this.f305687q;
        }
        String s16 = com.tencent.mobileqq.uftransfer.depend.a.s();
        HashMap hashMap = new HashMap();
        hashMap.put("param_group_code", this.f305695y);
        hashMap.put("param_self_uin", this.f305696z);
        hashMap.put("param_file_name", this.A);
        hashMap.put("param_suffix", com.tencent.mobileqq.uftransfer.depend.a.g(this.A));
        hashMap.put("param_file_size", String.valueOf(this.B));
        hashMap.put(ReportConstant.KEY_UUID, this.D);
        hashMap.put("param_store_type", String.valueOf(this.C));
        hashMap.put("param_result", String.valueOf(this.f305681k));
        hashMap.put("param_sub_reason", String.valueOf(this.f305682l));
        hashMap.put("param_http_status_code", String.valueOf(this.f305683m));
        hashMap.put("param_server_return_code", String.valueOf(this.f305684n));
        hashMap.put("param_err_msg", this.f305687q);
        hashMap.put("param_retry_count", String.valueOf(this.f305694x));
        hashMap.put("param_proxy_type", String.valueOf(this.f305674d));
        hashMap.put("param_net_type", s16);
        hashMap.put("param_security_time", String.valueOf(this.f305685o));
        hashMap.put("param_check_time", String.valueOf(this.f305686p));
        hashMap.put("param_server_ip", String.valueOf(this.f305672b));
        hashMap.put("param_server_port", String.valueOf(this.f305673c));
        hashMap.put("param_file_url", this.f305671a);
        hashMap.put("param_start_size", String.valueOf(this.f305675e));
        hashMap.put("param_transfer_size", String.valueOf(this.f305676f));
        hashMap.put("param_transfer_time", String.valueOf(this.f305677g));
        hashMap.put("param_transfer_speed", String.valueOf(this.f305679i));
        hashMap.put("param_fromType", String.valueOf(this.f305690t));
        hashMap.put("param_V6SelectType", String.valueOf(this.f305691u));
        hashMap.put("param_ipAddrType", String.valueOf(this.f305692v));
        hashMap.put("param_stackType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.u()));
        hashMap.put("param_loginType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.v()));
        hashMap.put("param_ishttps", String.valueOf(this.f305693w));
        long j17 = this.f305678h;
        long currentTimeMillis = System.currentTimeMillis();
        if (j17 == 0) {
            j17 = currentTimeMillis;
        }
        if (j17 < 1) {
            j3 = 0;
        } else {
            j3 = currentTimeMillis - j17;
        }
        if (j3 < 0) {
            j16 = 0;
        } else {
            j16 = j3;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTToopReportData", 1, ">>> Troop_Fail_DR:actType[" + str + "] " + hashMap.toString());
        com.tencent.mobileqq.uftransfer.depend.a.b(this.f305696z, str, false, j16, (long) 1, hashMap, "");
    }

    private void g(String str) {
        long j3;
        String s16 = com.tencent.mobileqq.uftransfer.depend.a.s();
        HashMap hashMap = new HashMap();
        hashMap.put("param_group_code", this.f305695y);
        hashMap.put("param_self_uin", this.f305696z);
        hashMap.put("param_file_name", this.A);
        hashMap.put("param_suffix", com.tencent.mobileqq.uftransfer.depend.a.g(this.A));
        hashMap.put("param_file_size", String.valueOf(this.B));
        hashMap.put(ReportConstant.KEY_UUID, this.D);
        hashMap.put("param_store_type", String.valueOf(this.C));
        hashMap.put("param_result", String.valueOf(0));
        hashMap.put("param_sub_reason", String.valueOf(0));
        hashMap.put("param_http_status_code", String.valueOf(this.f305683m));
        hashMap.put("param_err_msg", "");
        hashMap.put("param_flash_transfer", String.valueOf(this.f305680j));
        hashMap.put("param_retry_count", String.valueOf(this.f305694x));
        hashMap.put("param_proxy_type", String.valueOf(this.f305674d));
        hashMap.put("param_net_type", s16);
        hashMap.put("param_security_time", String.valueOf(this.f305685o));
        hashMap.put("param_check_time", String.valueOf(this.f305686p));
        hashMap.put("param_server_ip", String.valueOf(this.f305672b));
        hashMap.put("param_server_port", String.valueOf(this.f305673c));
        hashMap.put("param_file_url", this.f305671a);
        hashMap.put("param_start_size", String.valueOf(this.f305675e));
        hashMap.put("param_transfer_size", String.valueOf(this.f305676f));
        hashMap.put("param_transfer_time", String.valueOf(this.f305677g));
        hashMap.put("param_transfer_speed", String.valueOf(this.f305679i));
        hashMap.put("param_fromType", String.valueOf(this.f305690t));
        hashMap.put("param_V6SelectType", String.valueOf(this.f305691u));
        hashMap.put("param_ipAddrType", String.valueOf(this.f305692v));
        hashMap.put("param_stackType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.u()));
        hashMap.put("param_loginType", String.valueOf(com.tencent.mobileqq.uftransfer.depend.a.v()));
        hashMap.put("param_ishttps", String.valueOf(this.f305693w));
        long j16 = this.f305678h;
        long currentTimeMillis = System.currentTimeMillis();
        long j17 = 0;
        if (j16 == 0) {
            j16 = currentTimeMillis;
        }
        if (j16 < 1) {
            j3 = 0;
        } else {
            j3 = currentTimeMillis - j16;
        }
        if (j3 >= 0) {
            j17 = j3;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTToopReportData", 1, ">>> Troop_Suc_DR:actType[" + str + "] " + hashMap.toString());
        com.tencent.mobileqq.uftransfer.depend.a.b(this.f305696z, str, true, j17, (long) 1, hashMap, "");
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            d("actGroupFileUp");
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            d("actGroupFileUpDetail");
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            g("actGroupFileUp");
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            g("actGroupFileUpDetail");
        }
    }
}
