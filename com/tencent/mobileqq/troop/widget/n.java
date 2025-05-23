package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.q;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class n extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<QQAppInterface> f302616i;

    /* renamed from: j, reason: collision with root package name */
    private String f302617j;

    public n(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4) {
        super(str2, str3, str4);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, str, str2, str3, str4);
        } else {
            this.f302616i = new WeakReference<>(qQAppInterface);
            this.f302617j = str;
        }
    }

    @Override // com.tencent.mobileqq.troop.widget.c
    public UsingTimeReportManager d() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UsingTimeReportManager) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        WeakReference<QQAppInterface> weakReference = this.f302616i;
        if (weakReference == null || (qQAppInterface = weakReference.get()) == null) {
            return null;
        }
        return (UsingTimeReportManager) qQAppInterface.getManager(QQManagerFactory.USING_TIME_REPORT_MANAGER);
    }

    @Override // com.tencent.mobileqq.troop.widget.c
    public void f(long j3) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
            return;
        }
        WeakReference<QQAppInterface> weakReference = this.f302616i;
        if (weakReference == null || (qQAppInterface = weakReference.get()) == null) {
            return;
        }
        q d16 = new q(qQAppInterface).i("dc00899").a(this.f302508a).f(this.f302509b).d(this.f302510c);
        String[] strArr = new String[2];
        String str = this.f302617j;
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        strArr[1] = String.valueOf(j3);
        d16.b(strArr).g();
    }
}
