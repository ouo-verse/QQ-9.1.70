package com.tencent.mobileqq.app;

import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class k implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Long.valueOf(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(long j3, String str, int i3, boolean z16, boolean z17, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(long j3, String str, int i3, boolean z16, boolean z17, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j16));
        }
    }

    protected void d(Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, obj, Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
    }

    protected void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    protected void g(boolean z16, Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), l3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(long j3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Float.valueOf(f16));
        }
    }

    protected void i(int i3, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), str, Long.valueOf(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(boolean z16, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Long.valueOf(j3), str);
        }
    }

    protected void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(boolean z16, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(boolean z16, Long l3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), l3, str);
        }
    }

    protected void n(Session session, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, session, Boolean.valueOf(z16));
        }
    }

    protected void o(Session session) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) session);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        switch (i3) {
            case 1:
                Object[] objArr = (Object[]) obj;
                m(z16, (Long) objArr[0], (String) objArr[1]);
                return;
            case 2:
                Object[] objArr2 = (Object[]) obj;
                l(z16, ((Long) objArr2[1]).longValue(), (String) objArr2[2]);
                return;
            case 3:
                Object[] objArr3 = (Object[]) obj;
                j(z16, ((Long) objArr3[1]).longValue(), (String) objArr3[2]);
                return;
            case 4:
                Object[] objArr4 = (Object[]) obj;
                ((Long) objArr4[0]).longValue();
                h(((Long) objArr4[1]).longValue(), ((Float) objArr4[2]).floatValue());
                return;
            case 5:
                Object[] objArr5 = (Object[]) obj;
                a(z16, ((Long) objArr5[1]).longValue());
                return;
            case 6:
                Object[] objArr6 = (Object[]) obj;
                b(((Long) objArr6[1]).longValue(), (String) objArr6[2], ((Byte) objArr6[3]).byteValue(), ((Boolean) objArr6[4]).booleanValue(), ((Boolean) objArr6[5]).booleanValue(), ((Long) objArr6[6]).longValue());
                return;
            case 7:
                Object[] objArr7 = (Object[]) obj;
                c(((Long) objArr7[1]).longValue(), (String) objArr7[2], ((Byte) objArr7[3]).byteValue(), ((Boolean) objArr7[4]).booleanValue(), ((Boolean) objArr7[5]).booleanValue(), ((Long) objArr7[6]).longValue());
                return;
            case 8:
                Object[] objArr8 = (Object[]) obj;
                i(((Integer) objArr8[0]).intValue(), (String) objArr8[1], ((Long) objArr8[2]).longValue());
                return;
            case 9:
                e((String) ((Object[]) obj)[0]);
                return;
            case 10:
                r(((Long) ((Object[]) obj)[0]).longValue());
                return;
            case 11:
                k();
                return;
            case 12:
                f();
                return;
            case 13:
            default:
                return;
            case 14:
                q((Session) obj);
                return;
            case 15:
                Object[] objArr9 = (Object[]) obj;
                p((Session) objArr9[0], ((Float) objArr9[1]).floatValue());
                return;
            case 16:
                n((Session) obj, z16);
                return;
            case 17:
                o((Session) obj);
                return;
            case 18:
                g(z16, (Long) obj);
                return;
            case 19:
                d(obj, z16);
                return;
            case 20:
                Object[] objArr10 = (Object[]) obj;
                s(((Long) objArr10[0]).longValue(), ((Integer) objArr10[1]).intValue(), ((Integer) objArr10[2]).intValue());
                return;
            case 21:
                t(((Long) ((Object[]) obj)[0]).longValue());
                return;
        }
    }

    protected void p(Session session, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, session, Float.valueOf(f16));
        }
    }

    protected void q(Session session) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) session);
        }
    }

    protected void r(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
        }
    }

    protected void s(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void t(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, j3);
        }
    }
}
