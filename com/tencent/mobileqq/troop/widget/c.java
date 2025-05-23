package com.tencent.mobileqq.troop.widget;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c implements UsingTimeReportManager.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f302508a;

    /* renamed from: b, reason: collision with root package name */
    public String f302509b;

    /* renamed from: c, reason: collision with root package name */
    public String f302510c;

    /* renamed from: d, reason: collision with root package name */
    private long f302511d;

    /* renamed from: e, reason: collision with root package name */
    private long f302512e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f302513f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f302514g;

    /* renamed from: h, reason: collision with root package name */
    private UsingTimeReportManager f302515h;

    public c(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            return;
        }
        this.f302511d = 0L;
        this.f302512e = 0L;
        this.f302513f = false;
        this.f302514g = false;
        this.f302508a = str;
        this.f302509b = str2;
        this.f302510c = str3;
    }

    private void e() {
        UsingTimeReportManager d16 = d();
        this.f302515h = d16;
        if (d16 != null && !this.f302514g) {
            d16.d(this);
            this.f302514g = true;
        }
    }

    private void i() {
        if (this.f302514g && this.f302513f) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f302512e = uptimeMillis;
            long j3 = uptimeMillis - this.f302511d;
            if (QLog.isColorLevel()) {
                QLog.i("BaseUsingTimeReport", 2, "stop,usingTime=" + j3);
            }
            if (j3 > 0 && this.f302514g) {
                f(j3);
            }
            this.f302513f = false;
        }
    }

    private void j() {
        UsingTimeReportManager usingTimeReportManager = this.f302515h;
        if (usingTimeReportManager != null && this.f302514g) {
            usingTimeReportManager.e(this);
            this.f302514g = false;
        }
    }

    @Override // com.tencent.mobileqq.troop.widget.UsingTimeReportManager.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            i();
        }
    }

    @Override // com.tencent.mobileqq.troop.widget.UsingTimeReportManager.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            g();
        }
    }

    @Override // com.tencent.mobileqq.troop.widget.UsingTimeReportManager.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            h();
        }
    }

    public UsingTimeReportManager d() {
        throw null;
    }

    public void f(long j3) {
        throw null;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        e();
        if (this.f302514g && !this.f302513f) {
            this.f302511d = SystemClock.uptimeMillis();
            this.f302513f = true;
            if (QLog.isColorLevel()) {
                QLog.i("BaseUsingTimeReport", 2, "start(), mStartTime=" + this.f302511d);
            }
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            i();
            j();
        }
    }
}
