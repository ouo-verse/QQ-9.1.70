package com.tencent.mobileqq.msf.core.stepcount;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: d, reason: collision with root package name */
    private static final String f250006d = "HealthStepCounter";

    /* renamed from: a, reason: collision with root package name */
    private final c f250007a;

    /* renamed from: b, reason: collision with root package name */
    private final d f250008b;

    /* renamed from: c, reason: collision with root package name */
    private MsfCore f250009c;

    public a(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        com.tencent.mobileqq.msf.core.stepcount.g.a aVar = new com.tencent.mobileqq.msf.core.stepcount.g.a();
        this.f250007a = aVar;
        this.f250008b = new com.tencent.mobileqq.msf.core.stepcount.g.b(context, aVar);
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.b
    public void a(String str, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.i(f250006d, 2, "toServiceMsg is null");
                return;
            }
            return;
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (serviceCmd.equals(StepCounterConstants.CMD_HEALTH_SWITCH)) {
            boolean booleanValue = ((Boolean) toServiceMsg.getAttribute(h.f248218g, Boolean.FALSE)).booleanValue();
            e.a().a(booleanValue);
            if (booleanValue) {
                this.f250008b.a();
                return;
            } else {
                this.f250007a.d();
                this.f250008b.c();
                return;
            }
        }
        if (serviceCmd.equals(StepCounterConstants.CMD_RESET_STEP)) {
            Object attribute = toServiceMsg.getAttribute("server_step");
            if (attribute instanceof Integer) {
                this.f250007a.c(((Integer) attribute).intValue(), NetConnInfoCenter.getServerTime());
                return;
            }
            return;
        }
        if (serviceCmd.equals(StepCounterConstants.CMD_REFRESH_STEPS)) {
            this.f250007a.d();
            this.f250008b.a(str, toServiceMsg);
        } else if (serviceCmd.equals(StepCounterConstants.CMD_UPDATE_LAST_REPORT_TIME)) {
            this.f250008b.b();
        }
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.d(f250006d, 2, "msf service onServiceDestroyed");
        this.f250007a.d();
        this.f250008b.c();
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.b
    public synchronized void a(MsfCore msfCore, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, msfCore, Boolean.valueOf(z16));
            return;
        }
        QLog.d(f250006d, 1, "msf service onServiceCreated, autoBoot:" + z16);
        this.f250007a.a(z16);
        this.f250008b.a();
        this.f250009c = msfCore;
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f250008b.a(null, null);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
