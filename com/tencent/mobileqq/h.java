package com.tencent.mobileqq;

import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h implements u {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.u
    public void a(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, this, appRuntime, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str6, str7, str8, str9);
    }

    @Override // com.tencent.mobileqq.u
    public void b(int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    @Override // com.tencent.mobileqq.u
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.u
    public void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3);
        }
    }

    @Override // com.tencent.mobileqq.u
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.u
    public String[] e(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String[]) iPatchRedirector.redirect((short) 3, this, str, str2, str3);
        }
        return new String[0];
    }

    @Override // com.tencent.mobileqq.u
    public void exitProcess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.u
    public Looper f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Looper) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return Looper.getMainLooper();
    }

    @Override // com.tencent.mobileqq.u
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.u
    public void h(AppRuntime appRuntime, String str, String str2, String str3, String str4, int i3, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, appRuntime, str, str2, str3, str4, Integer.valueOf(i3), str5);
        }
    }
}
