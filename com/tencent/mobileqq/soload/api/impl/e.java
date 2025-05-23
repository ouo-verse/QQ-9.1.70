package com.tencent.mobileqq.soload.api.impl;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends a {
    static IPatchRedirector $redirector_;

    public e(LoadParam loadParam, LoadParam.LoadItem loadItem) {
        super(loadParam, loadItem);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) loadParam, (Object) loadItem);
        }
    }

    private SoLoadInfo j() {
        SoInfo e16 = com.tencent.mobileqq.soload.config.a.b().e(this.f288549b.name, null, true);
        LoadParam loadParam = this.f288548a;
        com.tencent.mobileqq.soload.util.h.a(loadParam, loadParam.mReportSeq, null, "load.item.getconfig.end", "is64bit=" + (com.tencent.mobileqq.soload.util.e.d() ? 1 : 0) + "&v=" + a.d() + "&f=" + this.f288548a.mCallType, SoInfo.getReportCode(e16), null);
        boolean e17 = e(e16);
        String m3 = m();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("is config valid: ");
        sb5.append(e17);
        QLog.i(m3, 2, sb5.toString());
        if (e17) {
            return null;
        }
        return n(2);
    }

    protected void h(com.tencent.mobileqq.soload.entity.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            com.tencent.mobileqq.soload.config.a.b().c(this.f288549b.name, aVar, null);
        }
    }

    @NonNull
    public SoLoadInfo i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SoLoadInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        SoLoadInfo j3 = j();
        if (j3 != null) {
            return j3;
        }
        SoLoadInfo k3 = k(com.tencent.mobileqq.soload.util.f.i(this.f288549b.name, this.f288555h.ver));
        if (k3 != null) {
            return k3;
        }
        return l(com.tencent.mobileqq.soload.util.f.o(this.f288549b, this.f288555h));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SoLoadInfo k(com.tencent.mobileqq.soload.entity.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SoLoadInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        if (aVar != null) {
            if (aVar.d()) {
                if (QLog.isColorLevel()) {
                    QLog.i(m(), 2, "[handleConfig] InLoadCrashProtectMode, crashInfo=" + aVar);
                }
                this.f288556i = "loadcrash";
                return n(8);
            }
            if (aVar.f()) {
                if (aVar.g()) {
                    if (QLog.isColorLevel()) {
                        QLog.i(m(), 2, "[handleConfig] InRunCrashProtectMode, crashInfo=" + aVar);
                    }
                    this.f288556i = "runcrash";
                    return n(8);
                }
                com.tencent.mobileqq.soload.util.f.d(this.f288549b.name);
                return null;
            }
            if (aVar.i()) {
                h(aVar);
                return null;
            }
            return null;
        }
        return null;
    }

    protected SoLoadInfo l(SoLocalInfo soLocalInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SoLoadInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) soLocalInfo);
        }
        boolean g16 = g(soLocalInfo);
        boolean f16 = a.f(soLocalInfo, this.f288555h);
        if ((this.f288549b.lops.flag & 4) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(m(), 2, "[handleConfigSync] isSoExist=" + g16 + ",isRFReady=" + f16 + ",isWeak:" + z16);
        }
        if (!g16) {
            return n(3);
        }
        if (!f16 && !z16) {
            return n(11);
        }
        this.f288552e = false;
        String str = soLocalInfo.mSoPath;
        if (!a.b(str, soLocalInfo.mSoCRC, this.f288549b, this.f288555h, 1)) {
            return n(10);
        }
        ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(MobileQQ.sMobileQQ, str);
        this.f288553f = str;
        if (f16) {
            this.f288554g = soLocalInfo.mRFileFolder;
        }
        return n(0);
    }

    protected String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "SoLoadWidget.GetSoTaskSync";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SoLoadInfo n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SoLoadInfo) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return c(i3);
    }
}
