package com.tencent.mobileqq.equipmentlock;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.loginregister.servlet.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static byte[] f205368e;

    /* renamed from: f, reason: collision with root package name */
    private static c f205369f;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QQAppInterface> f205370a;

    /* renamed from: b, reason: collision with root package name */
    private Messenger f205371b;

    /* renamed from: c, reason: collision with root package name */
    private ar f205372c;

    /* renamed from: d, reason: collision with root package name */
    h f205373d;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends ar {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onGetRecommendDeviceList(boolean z16, ArrayList<com.tencent.mobileqq.antiphing.b> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), arrayList);
                return;
            }
            if (z16) {
                EquipmentLockImpl.o().A(arrayList);
            } else if (QLog.isColorLevel()) {
                QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
            }
            c.this.l(false);
            c.this.e(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends h {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void b(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, wUserSigInfo, Integer.valueOf(i3), errMsg);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("EquipLockWebImpl", 2, "OnCheckDevLockSms ret=" + i3);
            }
            if (i3 == 0) {
                c.this.k(true);
                if (c.this.f205370a == null || (qQAppInterface = (QQAppInterface) c.this.f205370a.get()) == null || !EquipmentLockImpl.o().s(qQAppInterface)) {
                    c.this.l(false);
                    c.this.e(false);
                    return;
                }
                return;
            }
            c.this.l(false);
            c.this.k(false);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71767);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f205368e = new byte[0];
            f205369f = null;
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f205370a = null;
        this.f205371b = null;
        this.f205372c = new a();
        this.f205373d = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isBack", z16);
        Bundle bundle2 = new Bundle();
        bundle2.putString("cmd", "closeWeb");
        bundle2.putInt("respkey", -1);
        bundle2.putBundle("response", bundle);
        h(bundle2);
    }

    public static c f() {
        if (f205369f == null) {
            synchronized (f205368e) {
                if (f205369f == null) {
                    f205369f = new c();
                }
            }
        }
        return f205369f;
    }

    private void h(Bundle bundle) {
        if (this.f205371b != null) {
            try {
                Message obtain = Message.obtain((Handler) null, 4);
                obtain.setData(bundle);
                this.f205371b.send(obtain);
                if (QLog.isColorLevel()) {
                    QLog.i("EquipLockWebImpl", 2, "resp to sever: ");
                }
            } catch (RemoteException e16) {
                e16.printStackTrace();
            }
        }
    }

    private void j(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("checkDevLockSms_ret", i3);
        Bundle bundle2 = new Bundle();
        bundle2.putString("cmd", "openEquipmentLock");
        bundle2.putInt("respkey", -1);
        bundle2.putBundle("response", bundle);
        h(bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("setMobileResult", z16);
        Bundle bundle2 = new Bundle();
        bundle2.putString("cmd", "setMobileResult");
        bundle2.putInt("respkey", -1);
        bundle2.putBundle("response", bundle);
        h(bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isWaiting", z16);
        Bundle bundle2 = new Bundle();
        bundle2.putString("cmd", "setWaitingResponse");
        bundle2.putInt("respkey", -1);
        bundle2.putBundle("response", bundle);
        h(bundle2);
    }

    public static void m() {
        WeakReference<QQAppInterface> weakReference;
        if (f205369f != null) {
            synchronized (f205368e) {
                c cVar = f205369f;
                if (cVar != null && (weakReference = cVar.f205370a) != null) {
                    QQAppInterface qQAppInterface = weakReference.get();
                    if (qQAppInterface != null) {
                        qQAppInterface.removeObserver(f205369f.f205372c);
                    }
                    f205369f = null;
                }
            }
        }
    }

    public void g(QQAppInterface qQAppInterface, Messenger messenger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) messenger);
            return;
        }
        this.f205370a = new WeakReference<>(qQAppInterface);
        this.f205371b = messenger;
        qQAppInterface.addObserver(this.f205372c);
    }

    public void i(byte[] bArr) {
        int i3;
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
            return;
        }
        WeakReference<QQAppInterface> weakReference = this.f205370a;
        if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
            i3 = EquipmentLockImpl.o().e(qQAppInterface, qQAppInterface.getCurrentAccountUin(), null, bArr, this.f205373d);
        } else {
            i3 = -1;
        }
        j(i3);
    }
}
