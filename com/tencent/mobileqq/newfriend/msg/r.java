package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class r extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public QIMNotifyAddFriend f254044d;

    public r(QIMNotifyAddFriend qIMNotifyAddFriend) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qIMNotifyAddFriend);
        } else {
            this.f254044d = qIMNotifyAddFriend;
            this.f254036b = qIMNotifyAddFriend.pushTime;
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
        return this.f254044d.hasRead;
    }
}
