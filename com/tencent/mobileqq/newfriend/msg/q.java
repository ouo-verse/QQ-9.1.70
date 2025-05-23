package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class q extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public QIMFollwerAdd f254043d;

    public q(QIMFollwerAdd qIMFollwerAdd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qIMFollwerAdd);
        } else {
            this.f254043d = qIMFollwerAdd;
            this.f254036b = qIMFollwerAdd.upTime;
        }
    }

    @Override // com.tencent.mobileqq.newfriend.msg.i
    public String a(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        }
        return "getMessage";
    }

    @Override // com.tencent.mobileqq.newfriend.msg.i
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f254043d.isRead;
    }
}
