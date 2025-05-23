package com.tencent.mobileqq.app.friendlist.receiver;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected QQAppInterface f195646a;

    /* renamed from: b, reason: collision with root package name */
    protected FriendListHandler f195647b;

    public a(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        } else {
            this.f195646a = qQAppInterface;
            this.f195647b = friendListHandler;
        }
    }

    public abstract boolean a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            this.f195647b.notifyUI(i3, z16, obj);
        }
    }

    protected abstract void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj);

    public void d(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        } else if (a(fromServiceMsg.getServiceCmd())) {
            c(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
