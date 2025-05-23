package com.tencent.mobileqq.applets;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c extends com.tencent.mobileqq.applets.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private a f196752d;

    /* renamed from: e, reason: collision with root package name */
    protected QQAppInterface f196753e;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public abstract void a(boolean z16, Object obj);

        public abstract void b(boolean z16, Object obj);

        public abstract void c(Object obj);

        public abstract void d(Object obj);

        public abstract int e();
    }

    public c(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f196752d = aVar;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    private void a(boolean z16, Object obj) {
        a aVar = this.f196752d;
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.applets.a.TAG, 2, "No Set ResponseResultListener, ignore Response!");
                return;
            }
            return;
        }
        if (4 != aVar.e()) {
            return;
        }
        this.f196752d.b(z16, obj);
        if (QLog.isColorLevel()) {
            QLog.d(com.tencent.mobileqq.applets.a.TAG, 2, this + "      Follow isSuccess:" + z16);
        }
        if (z16) {
            oidb_cmd0xc96$RspBody oidb_cmd0xc96_rspbody = new oidb_cmd0xc96$RspBody();
            if (obj instanceof byte[]) {
                try {
                    oidb_cmd0xc96_rspbody.mergeFrom((byte[]) obj);
                    this.f196752d.d(oidb_cmd0xc96_rspbody);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.w(com.tencent.mobileqq.applets.a.TAG, 4, e16.getMessage(), e16);
                    this.f196752d.c(obj);
                } catch (Exception e17) {
                    QLog.w(com.tencent.mobileqq.applets.a.TAG, 4, e17.getMessage(), e17);
                    this.f196752d.c(obj);
                }
            } else {
                this.f196752d.c(obj);
            }
        } else {
            this.f196752d.c(obj);
        }
        this.f196752d.a(z16, obj);
        d();
    }

    private void b(boolean z16, Object obj) {
        a aVar = this.f196752d;
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.applets.a.TAG, 2, "No Set ResponseResultListener, ignore Response!");
            }
        } else {
            if (7 != aVar.e()) {
                return;
            }
            this.f196752d.b(z16, obj);
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.applets.a.TAG, 2, "PublicAccountNotifySetting isSuccess:" + z16);
            }
            if (z16) {
                this.f196752d.d(obj);
            } else {
                this.f196752d.c(obj);
            }
            this.f196752d.a(z16, obj);
            d();
        }
    }

    private void c(boolean z16, Object obj) {
        a aVar = this.f196752d;
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.applets.a.TAG, 2, "No Set ResponseResultListener, ignore Response!");
                return;
            }
            return;
        }
        if (5 != aVar.e()) {
            return;
        }
        this.f196752d.b(z16, obj);
        if (QLog.isColorLevel()) {
            QLog.d(com.tencent.mobileqq.applets.a.TAG, 2, this + "      unFollow isSuccess:" + z16);
        }
        if (z16) {
            oidb_cmd0xc96$RspBody oidb_cmd0xc96_rspbody = new oidb_cmd0xc96$RspBody();
            if (obj instanceof byte[]) {
                try {
                    oidb_cmd0xc96_rspbody.mergeFrom((byte[]) obj);
                    this.f196752d.d(oidb_cmd0xc96_rspbody);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.w(com.tencent.mobileqq.applets.a.TAG, 4, e16.getMessage(), e16);
                    this.f196752d.c(obj);
                } catch (Exception e17) {
                    QLog.w(com.tencent.mobileqq.applets.a.TAG, 4, e17.getMessage(), e17);
                    this.f196752d.c(obj);
                }
            } else {
                this.f196752d.c(obj);
            }
        } else {
            this.f196752d.c(obj);
        }
        this.f196752d.a(z16, obj);
        d();
    }

    private void d() {
        if (this.f196753e != null) {
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.applets.a.TAG, 2, "removeObserver  " + this);
            }
            this.f196753e.removeObserver(this);
        }
    }

    public void e(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface);
        } else {
            this.f196753e = qQAppInterface;
        }
    }

    @Override // com.tencent.mobileqq.applets.a, com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 != 6) {
                    if (i3 != 7) {
                        super.onUpdate(i3, z16, obj);
                        return;
                    } else {
                        b(z16, obj);
                        return;
                    }
                }
                return;
            }
            c(z16, obj);
            return;
        }
        a(z16, obj);
    }

    public c(a aVar, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) qQAppInterface);
        } else {
            this.f196752d = aVar;
            this.f196753e = qQAppInterface;
        }
    }
}
