package com.tencent.mobileqq.msf;

import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.msf.sdk.MSFCrashHandleReportHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import com.tencent.qqperf.monitor.crash.b;
import com.tencent.qqperf.monitor.crash.catchedexception.a;
import com.tencent.qqperf.monitor.crash.f;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFCrashHandleListener implements CrashHandleListener, f {
    static IPatchRedirector $redirector_;

    public MSFCrashHandleListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            initCatchedExceptionEnv();
        }
    }

    private void initCatchedExceptionEnv() {
        b bVar = new b();
        bVar.i();
        a.g(bVar);
    }

    @Override // com.tencent.feedback.eup.CrashHandleListener
    public byte[] getCrashExtraData(boolean z16, String str, String str2, String str3, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return MSFCrashHandleReportHelper.instance().getCrashExtraData(z16, str, str2, str3, i3, j3);
    }

    @Override // com.tencent.feedback.eup.CrashHandleListener
    public String getCrashExtraMessage(boolean z16, String str, String str2, String str3, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3));
        }
        com.tencent.mobileqq.hodor.a.b(BaseApplication.getContext(), str, str3, j3, "com.tencent.mobileqq:MSF");
        return MSFCrashHandleReportHelper.instance().getCrashExtraMessage(z16, str, str2, str3, i3, j3);
    }

    @Override // com.tencent.qqperf.monitor.crash.f
    public CrashHandleListener getCrashHandleListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CrashHandleListener) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.qqperf.monitor.crash.f
    public void initCrashReport(String str, QQCrashReportManager qQCrashReportManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) qQCrashReportManager);
        } else {
            MSFCrashHandleReportHelper.instance().initCrashReport();
        }
    }

    @Override // com.tencent.feedback.eup.CrashHandleListener
    public boolean onCrashHandleEnd(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, z16)).booleanValue();
        }
        return MSFCrashHandleReportHelper.instance().onCrashHandleEnd(z16);
    }

    @Override // com.tencent.feedback.eup.CrashHandleListener
    public void onCrashHandleStart(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            MSFCrashHandleReportHelper.instance().onCrashHandleStart(z16);
        }
    }

    @Override // com.tencent.feedback.eup.CrashHandleListener
    public boolean onCrashSaving(boolean z16, String str, String str2, String str3, String str4, int i3, long j3, String str5, String str6, String str7, String str8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, str2, str3, str4, Integer.valueOf(i3), Long.valueOf(j3), str5, str6, str7, str8)).booleanValue();
        }
        return MSFCrashHandleReportHelper.instance().onCrashSaving(z16, str, str3, str4, i3, j3, str5, str6, str7, str8);
    }
}
