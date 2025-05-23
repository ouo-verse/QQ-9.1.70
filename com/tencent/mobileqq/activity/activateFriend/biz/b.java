package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.mobileqq.reminder.db.b f177962a;

    /* renamed from: b, reason: collision with root package name */
    public AcsMsg f177963b;

    /* renamed from: c, reason: collision with root package name */
    public long f177964c;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQReminderOrderModel{messageRecord=" + this.f177962a + ", acsMsg=" + this.f177963b + ", orderTime=" + this.f177964c + '}';
    }
}
