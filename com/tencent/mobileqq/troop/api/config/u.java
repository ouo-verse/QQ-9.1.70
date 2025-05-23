package com.tencent.mobileqq.troop.api.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<a> f293985a;

    /* renamed from: b, reason: collision with root package name */
    private static u f293986b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63863);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f293985a = new ArrayList<>();
        }
    }

    u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            e();
        }
    }

    public static u c() {
        if (f293986b == null) {
            synchronized (u.class) {
                if (f293986b == null) {
                    f293986b = new u();
                }
            }
        }
        return f293986b;
    }

    public void a(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
            return;
        }
        Iterator<a> it = f293985a.iterator();
        while (it.hasNext()) {
            it.next().a(arrayList);
        }
    }

    public int b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).intValue();
        }
        Iterator<a> it = f293985a.iterator();
        while (it.hasNext()) {
            int b16 = it.next().b(str);
            if (b16 != -1) {
                return b16;
            }
        }
        return -1;
    }

    public String d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        Iterator<a> it = f293985a.iterator();
        while (it.hasNext()) {
            String c16 = it.next().c(i3);
            if (c16 != null) {
                return c16;
            }
        }
        return "0";
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ArrayList<Class<? extends a>> arrayList = com.tencent.mobileqq.troop.api.config.extension.a.f293977a;
        if (arrayList != null) {
            Iterator<Class<? extends a>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f293985a.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("RoamSettingProcessorConfig", 1, "Init Fail", th5);
                }
            }
        }
    }

    public void f(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        Iterator<a> it = f293985a.iterator();
        while (it.hasNext()) {
            it.next().d(str, str2);
        }
    }
}
