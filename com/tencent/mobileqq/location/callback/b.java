package com.tencent.mobileqq.location.callback;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements e {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(QQAppInterface qQAppInterface) {
        MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
        if (handler != null) {
            handler.sendEmptyMessage(1009);
        }
    }

    @Override // com.tencent.mobileqq.location.callback.e
    public void a(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            d((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
        }
    }

    @Override // com.tencent.mobileqq.location.callback.e
    public void b(int i3, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.location.callback.e
    public void c(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            d((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
        }
    }
}
