package com.tencent.qav.controller.multi;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qav.QavDef$MultiUserInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends com.tencent.qav.observer.a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qav.observer.a
    public void a(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) objArr);
            return;
        }
        switch (i3) {
            case 0:
                e();
                return;
            case 1:
                f();
                return;
            case 2:
                g(((Integer) objArr[0]).intValue());
                return;
            case 3:
                r((QavDef$MultiUserInfo) objArr[0]);
                return;
            case 4:
                s((QavDef$MultiUserInfo) objArr[0]);
                return;
            case 5:
                q((QavDef$MultiUserInfo) objArr[0], ((Boolean) objArr[1]).booleanValue());
                return;
            case 6:
                QavDef$MultiUserInfo qavDef$MultiUserInfo = (QavDef$MultiUserInfo) objArr[0];
                boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                v(qavDef$MultiUserInfo, booleanValue, ((Integer) objArr[2]).intValue());
                u(qavDef$MultiUserInfo, booleanValue);
                return;
            case 7:
                w((List) objArr[0]);
                return;
            case 8:
                n(((Integer) objArr[0]).intValue());
                return;
            case 9:
                k(true, ((Long) objArr[0]).longValue(), ((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), ((Integer) objArr[4]).intValue());
                return;
            case 10:
                k(false, ((Long) objArr[0]).longValue(), ((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), ((Integer) objArr[4]).intValue());
                return;
            case 11:
                j(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue());
                return;
            case 12:
                i(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue());
                return;
            case 13:
                t(((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue());
                return;
            case 14:
                x(((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                return;
            case 15:
                o(((Integer) objArr[0]).intValue());
                return;
            case 16:
                p(((Boolean) objArr[0]).booleanValue());
                return;
            case 17:
                y(((Boolean) objArr[0]).booleanValue());
                return;
            case 18:
                h(((Long) objArr[0]).longValue(), (String) objArr[1], (String) objArr[2]);
                return;
            case 19:
                c();
                return;
            case 20:
                m();
                return;
            case 21:
                d((Long) objArr[0]);
                return;
            case 22:
                l(((Long) objArr[0]).longValue(), (String[]) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Long) objArr[4]).longValue(), ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue());
                return;
            case 23:
                b(((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), (byte[]) objArr[4]);
                return;
            default:
                return;
        }
    }

    public void b(long j3, int i3, int i16, long j16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), bArr);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    public void d(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) l3);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    public void h(long j3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(j3), str, str2);
        }
    }

    public void i(boolean z16, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    public void j(boolean z16, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    public void k(boolean z16, long j3, long j16, int i3, long j17, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Long.valueOf(j17), Integer.valueOf(i16));
        }
    }

    public void l(long j3, String[] strArr, int i3, int i16, long j16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Long.valueOf(j3), strArr, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        }
    }

    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
    }

    public void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
    }

    public void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        }
    }

    public void q(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, qavDef$MultiUserInfo, Boolean.valueOf(z16));
        }
    }

    public void r(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qavDef$MultiUserInfo);
        }
    }

    public void s(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) qavDef$MultiUserInfo);
        }
    }

    public void t(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    public void u(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, qavDef$MultiUserInfo, Boolean.valueOf(z16));
        }
    }

    public void v(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, qavDef$MultiUserInfo, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    public void w(List<QavDef$MultiUserInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) list);
        }
    }

    public void x(long j3, int i3, long j16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), Integer.valueOf(i16));
        }
    }

    public void y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        }
    }
}
