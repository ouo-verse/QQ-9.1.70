package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cx implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public cx() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) str);
        }
    }

    protected void b(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) bundle);
        }
    }

    protected void c(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void d(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
        }
    }

    protected void e(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void f(boolean z16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
        }
    }

    protected void g(boolean z16, int i3, byte[] bArr, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), bArr, str);
        }
    }

    protected void h(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) str);
        }
    }

    protected void j(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        String str;
        Bundle bundle;
        String str2;
        Bundle bundle2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        byte[] bArr = null;
        String str3 = null;
        String str4 = null;
        int i17 = -1;
        switch (i3) {
            case 1:
                b(i3, (Bundle) obj);
                return;
            case 2:
                j(i3, (Bundle) obj);
                return;
            case 3:
                if (z16 && (bundle = (Bundle) obj) != null) {
                    i16 = bundle.getInt("status");
                    str = bundle.getString("wording");
                } else {
                    str = "";
                }
                f(z16, i16, str);
                return;
            case 4:
                if (z16 && (bundle2 = (Bundle) obj) != null) {
                    i17 = bundle2.getInt("index");
                    bArr = bundle2.getByteArray("target_desc");
                    str2 = bundle2.getString("target_name");
                } else {
                    str2 = null;
                }
                g(z16, i17, bArr, str2);
                return;
            case 5:
                c(z16, (Bundle) obj);
                return;
            case 6:
                h(z16, (Bundle) obj);
                return;
            case 7:
                Bundle bundle3 = (Bundle) obj;
                if (bundle3 != null) {
                    i17 = bundle3.getInt("ret_code", -1);
                    str4 = bundle3.getString("err_msg");
                }
                a(i17, str4);
                return;
            case 8:
                Bundle bundle4 = (Bundle) obj;
                if (bundle4 != null) {
                    i17 = bundle4.getInt("ret_code", -1);
                    str3 = bundle4.getString("err_msg");
                }
                i(i17, str3);
                return;
            case 9:
                d(obj);
                return;
            case 10:
                e(z16, ((Boolean) obj).booleanValue());
                return;
            default:
                return;
        }
    }
}
