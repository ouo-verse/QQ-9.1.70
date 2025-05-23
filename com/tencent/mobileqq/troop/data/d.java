package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static a f294894e;

    /* renamed from: a, reason: collision with root package name */
    public int f294895a;

    /* renamed from: b, reason: collision with root package name */
    public long f294896b;

    /* renamed from: c, reason: collision with root package name */
    public long f294897c;

    /* renamed from: d, reason: collision with root package name */
    public long f294898d;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42149);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f294894e = new e();
            com.tencent.imcore.message.s.a();
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            a();
        }
    }

    public static boolean d(int i3) {
        if (i3 != 14 && i3 != 25 && i3 != 13 && i3 != 21 && i3 != 23) {
            return false;
        }
        return true;
    }

    public static boolean f(int i3, long j3, int i16, long j16) {
        if (j16 != -1 && (j3 == -1 || ((i3 == i16 && j3 > j16) || (i3 != i16 && c.a(i16, i3))))) {
            return true;
        }
        return false;
    }

    public static void g(a aVar) {
        f294894e = aVar;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.f294895a = 0;
        this.f294896b = -1L;
        this.f294897c = -1L;
        this.f294898d = 0L;
    }

    public void b(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
        } else if (dVar != null) {
            this.f294895a = dVar.f294895a;
            this.f294896b = dVar.f294896b;
            this.f294897c = dVar.f294897c;
            this.f294898d = dVar.f294898d;
        }
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f294896b != -1) {
            return true;
        }
        return false;
    }

    public boolean e(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        return f(this.f294895a, this.f294896b, i3, j3);
    }

    public boolean h(int i3, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17))).booleanValue();
        }
        boolean e16 = e(i3, j3);
        if (QLog.isColorLevel()) {
            QLog.d("Navigate.MessageNavInfo", 2, "update, preBizType = " + this.f294895a + ", newBizType = " + i3 + ", needUpdate = " + e16 + ", shmsgseq = " + j3 + ", uniseq = " + j16);
        }
        if (e16) {
            this.f294895a = i3;
            this.f294896b = j3;
            this.f294897c = j16;
            this.f294898d = j17;
            return true;
        }
        if (this.f294895a == i3 && this.f294896b < j3) {
            this.f294898d = j17;
        }
        return false;
    }

    public boolean i(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar)).booleanValue();
        }
        if (dVar == null) {
            return false;
        }
        return h(dVar.f294895a, dVar.f294896b, dVar.f294897c, dVar.f294898d);
    }

    public void j(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (this.f294895a == i3 && this.f294896b != -1) {
            this.f294897c = j3;
            if (QLog.isColorLevel()) {
                QLog.d("Navigate.MessageNavInfo", 2, "updateMsgSeq, preBizType = " + this.f294895a + ", newBizType = " + i3 + ", msgSeq = " + j3);
            }
        }
    }

    public void k(int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Navigate.MessageNavInfo", 2, "updateShMsgSeq, preBizType = " + this.f294895a + ", newBizType = " + i3 + ", newShMsgSeq = " + j3);
        }
        int i16 = this.f294895a;
        if (i16 != 0 && i16 != i3) {
            return;
        }
        this.f294895a = i3;
        this.f294896b = j3;
        this.f294898d = j16;
    }
}
