package com.tencent.ams.dsdk.monitor.metric.core.inner;

import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.monitor.metric.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class MetricLogAdapter implements j {
    static IPatchRedirector $redirector_;

    public MetricLogAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.monitor.metric.j
    public void d(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, th5);
        } else {
            DLog.d(str, str2, th5);
        }
    }

    @Override // com.tencent.ams.monitor.metric.j
    public void e(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, th5);
        } else {
            DLog.e(str, str2, th5);
        }
    }

    @Override // com.tencent.ams.monitor.metric.j
    public void i(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, th5);
        } else {
            DLog.d(str, str2, th5);
        }
    }

    public void w(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, th5);
        } else {
            DLog.w(str, str2, th5);
        }
    }
}
