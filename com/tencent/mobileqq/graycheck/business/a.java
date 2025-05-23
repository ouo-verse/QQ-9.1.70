package com.tencent.mobileqq.graycheck.business;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import protocol.GrayVersion.ApplyResp;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(boolean z16, Object obj) {
        if (!(obj instanceof ApplyResp)) {
            QLog.d("GrayCheck.tag", 1, "[handleApplyGrayVersionExpired], data is not instanceof ApplyResp");
        } else {
            ApplyResp applyResp = (ApplyResp) obj;
            d(String.valueOf(applyResp.uin), applyResp.error_msg, applyResp.ret, applyResp.total_gray_uin);
        }
    }

    private void b(boolean z16, Object obj) {
        if (!(obj instanceof ApplyResp)) {
            QLog.d("GrayCheck.tag", 1, "[handleApplyGrayVersionFailed], data is not instanceof ApplyResp");
        } else {
            ApplyResp applyResp = (ApplyResp) obj;
            e(String.valueOf(applyResp.uin), applyResp.error_msg, applyResp.ret, applyResp.total_gray_uin);
        }
    }

    private void c(boolean z16, Object obj) {
        if (!(obj instanceof ApplyResp)) {
            QLog.d("GrayCheck.tag", 1, "[handleApplyGrayVersionSuccess], data is not instanceof ApplyResp");
        } else {
            ApplyResp applyResp = (ApplyResp) obj;
            f(String.valueOf(applyResp.uin), applyResp.total_gray_uin);
        }
    }

    public void d(String str, String str2, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    public void e(String str, String str2, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    public void f(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3));
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        switch (i3) {
            case 2001:
                c(z16, obj);
                return;
            case 2002:
                g();
                return;
            case 2003:
                a(z16, obj);
                return;
            case 2004:
                b(z16, obj);
                return;
            default:
                return;
        }
    }
}
