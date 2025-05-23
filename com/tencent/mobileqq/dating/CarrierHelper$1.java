package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes10.dex */
class CarrierHelper$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ LinkedList f203355d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        QQAppInterface qQAppInterface;
        int i3;
        int i16;
        QQAppInterface qQAppInterface2;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            z16 = this.this$0.f203402i;
            if (!z16 && !this.f203355d.isEmpty()) {
                Iterator it = this.f203355d.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    if (5 == num.intValue()) {
                        qQAppInterface = this.this$0.f203399e;
                        i3 = this.this$0.f203398d;
                        ReportController.o(qQAppInterface, "CliOper", "", "", "0X80052A4", "0X80052A4", i3, 0, "", "", "", "");
                    } else {
                        i16 = this.this$0.f203398d;
                        if (i16 != 2) {
                            i18 = this.this$0.f203398d;
                            if (i18 == 1) {
                            }
                        }
                        qQAppInterface2 = this.this$0.f203399e;
                        i17 = this.this$0.f203398d;
                        ReportController.o(qQAppInterface2, "CliOper", "", "", "0X80050D0", "0X80050D0", i17, 0, String.valueOf(num), "", "", "");
                    }
                }
                this.this$0.f203402i = true;
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
