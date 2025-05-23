package com.tencent.mobileqq.app.proxy;

import android.util.SparseArray;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements IProxyService {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.IProxyService
    public SparseArray<BaseProxy> getBusinessProxy(AppRuntime appRuntime, BaseProxyManager baseProxyManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SparseArray) iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime, (Object) baseProxyManager);
        }
        return new c(appRuntime, baseProxyManager).get();
    }

    @Override // com.tencent.mobileqq.app.proxy.IProxyService
    public boolean getSQLiteSwitchBySample() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return StatisticCollector.getSqliteSwitchBySample(0);
    }

    @Override // com.tencent.mobileqq.app.proxy.IProxyService
    public boolean isMessageRecord(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        return obj instanceof MessageRecord;
    }

    @Override // com.tencent.mobileqq.app.proxy.IProxyService
    public boolean isSQLiteReportVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return StatisticCollector.sqlite3Optimizereport();
    }
}
