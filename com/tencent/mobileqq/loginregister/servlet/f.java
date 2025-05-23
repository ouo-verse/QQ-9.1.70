package com.tencent.mobileqq.loginregister.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.observer.SSOAccountObserver;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(String str, int i3, int i16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Integer.valueOf(i16), bundle);
        }
    }

    public void b(String str, int i3, byte[] bArr, int i16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), bArr, Integer.valueOf(i16), bundle);
        }
    }

    public void c(String str, byte[] bArr, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, bArr, Integer.valueOf(i3), bundle);
        }
    }

    public void d(String str, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), bundle);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        int i16 = bundle.getInt("code");
        String string = bundle.getString("ssoAccount");
        int i17 = bundle.getInt("targetTicket", 4096);
        int i18 = bundle.getInt("ret");
        byte[] byteArray = bundle.getByteArray("wtTicket");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("account:");
            sb5.append(string);
            sb5.append(" action:");
            sb5.append(i3);
            sb5.append(" code:");
            sb5.append(i16);
            sb5.append(" isSuccess:");
            sb5.append(z16);
            sb5.append(" ret:");
            sb5.append(i18);
            sb5.append(" wtTicketArr:");
            if (byteArray == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(byteArray.length);
            }
            sb5.append(valueOf);
            QLog.d(SSOAccountObserver.TAG, 2, sb5.toString());
        }
        if (i18 != 0) {
            z17 = false;
        }
        if (i3 != 1101) {
            if (i3 == 1102) {
                if (byteArray != null && byteArray.length != 0) {
                    z18 = z17;
                }
                if (z18) {
                    b(string, i18, byteArray, i17, bundle);
                    return;
                } else if (i16 == 2006) {
                    d(string, i3, bundle);
                    return;
                } else {
                    a(string, i3, i18, bundle);
                    return;
                }
            }
            return;
        }
        if (byteArray != null && byteArray.length != 0) {
            z18 = z17;
        }
        if (z18) {
            c(string, byteArray, i17, bundle);
        } else if (i16 == 2006) {
            d(string, i3, bundle);
        } else {
            a(string, i3, i18, bundle);
        }
    }
}
