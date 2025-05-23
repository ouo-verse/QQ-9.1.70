package com.tencent.replacemonitor.replace.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.MonitorType;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.tmassistantbase.util.r;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e implements f {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.replacemonitor.replace.c.f
    public MonitorResult a(MonitorTask monitorTask, MonitorStep monitorStep) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MonitorResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) monitorTask, (Object) monitorStep);
        }
        r.b(ReplaceMonitor.WASH_TAG, "ModifyTimeMonitorAction>>" + monitorTask.appName + "\u5f00\u59cb\u901a\u8fc7ModifyTime\u6bd4\u8f83\u68c0\u6d4b\u6d17\u5305,\u6682\u65f6\u4e0d\u652f\u6301\uff0c\u76f4\u63a5\u653e\u8fc7 step = " + monitorStep);
        return new MonitorResult(monitorStep, 0, "\u6682\u4e0d\u6267\u884cModifyTimeMonitorAction", b());
    }

    public MonitorType b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MonitorType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return MonitorType.BY_MODIFY_TIME;
    }
}
