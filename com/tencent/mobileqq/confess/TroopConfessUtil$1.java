package com.tencent.mobileqq.confess;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes5.dex */
class TroopConfessUtil$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ QQAppInterface f202163d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f202164e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f202165f;

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.f202163d;
        if (qQAppInterface != null) {
            if (qQAppInterface.getCurrentUin().equals(this.f202164e)) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(this.f202163d, "dc00898", "", "", "0X800956F", "0X800956F", i3, 0, "", "", "", "");
        }
        if (this.f202165f == 1) {
            str = "0X8009302";
        } else {
            str = "0X8009303";
        }
        String str2 = str;
        ReportController.o(this.f202163d, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
    }
}
