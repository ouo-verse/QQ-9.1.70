package com.tencent.mobileqq.msgbackup.authentication;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f251006d;

    /* renamed from: e, reason: collision with root package name */
    private static a f251007e;

    /* renamed from: a, reason: collision with root package name */
    private int f251008a;

    /* renamed from: b, reason: collision with root package name */
    private String f251009b;

    /* renamed from: c, reason: collision with root package name */
    private String f251010c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21967);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f251006d = MsgBackupAuthHandler.class.getName();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String[] c(Context context) {
        return new String[2];
    }

    public static a d() {
        if (f251007e == null) {
            synchronized (a.class) {
                if (f251007e == null) {
                    f251007e = new a();
                }
            }
        }
        return f251007e;
    }

    private MsgBackupAuthHandler e(BaseQQAppInterface baseQQAppInterface) {
        return (MsgBackupAuthHandler) baseQQAppInterface.getBusinessHandler(f251006d);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        String[] c16 = c(BaseApplication.getContext());
        MsgBackupUserData.b bVar = new MsgBackupUserData.b();
        bVar.b(c16[1]);
        bVar.g(c16[0]);
        ArrayList arrayList = new ArrayList(2);
        int i3 = this.f251008a;
        if (i3 == 1) {
            bVar.c(MsgBackupTransportProcessor.u().y());
            arrayList.add(Integer.valueOf(MsgBackupTransportProcessor.u().z()));
            arrayList.add(Integer.valueOf(MsgBackupTransportProcessor.u().A()));
        } else if (i3 == 2) {
            bVar.c(MsgBackupTransportProcessor.u().p());
            arrayList.add(Integer.valueOf(MsgBackupTransportProcessor.u().q()));
            arrayList.add(Integer.valueOf(MsgBackupTransportProcessor.u().r()));
        } else {
            bVar.c(MsgBackupTransportProcessor.u().p());
            arrayList.add(Integer.valueOf(MsgBackupTransportProcessor.u().q()));
            arrayList.add(Integer.valueOf(MsgBackupTransportProcessor.u().r()));
        }
        bVar.e(4);
        bVar.f(arrayList);
        MsgBackupUserData a16 = bVar.a();
        e((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).D2(a16, this.f251009b, this.f251008a);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, "confirmQrReq, userData: " + a16 + ", biztype = " + this.f251008a + ", qr_sig = " + this.f251009b);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f251008a;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f251009b;
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        String[] c16 = c(BaseApplication.getContext());
        MsgBackupUserData.b bVar = new MsgBackupUserData.b();
        bVar.b(c16[1]);
        bVar.g(c16[0]);
        ArrayList arrayList = new ArrayList(2);
        bVar.c(MsgBackupTransportProcessor.u().y());
        arrayList.add(Integer.valueOf(MsgBackupTransportProcessor.u().z()));
        arrayList.add(Integer.valueOf(MsgBackupTransportProcessor.u().A()));
        bVar.e(4);
        bVar.f(arrayList);
        MsgBackupUserData a16 = bVar.a();
        e((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).F2(a16, this.f251008a, z16);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, "requestQR, userData: " + a16 + ", biztype = " + this.f251008a + ", ispush = " + z16);
        }
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        d.b();
        d.f251402a.f251371a = i3;
        this.f251008a = i3;
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f251009b = str;
        }
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.f251010c = str;
        }
    }
}
