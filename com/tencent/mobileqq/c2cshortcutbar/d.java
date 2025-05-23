package com.tencent.mobileqq.c2cshortcutbar;

import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Alias("isShowAssistantEntrance")
    public int f200960a;

    /* renamed from: b, reason: collision with root package name */
    @Alias("kuolieAIOEnable")
    public int f200961b;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f200960a = 0;
            this.f200961b = 0;
        }
    }

    public static d a(String str) {
        String str2;
        d dVar = (d) com.tencent.mobileqq.jsonconverter.a.e(str, d.class);
        if (QLog.isColorLevel()) {
            if (("parse: " + dVar) != null) {
                str2 = dVar.toString();
            } else {
                str2 = " C2CShortcutBarConfBean is null";
            }
            QLog.d("C2CShortcutBarConfBean", 2, str2);
        }
        return dVar;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f200961b == 1) {
            return true;
        }
        return false;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f200960a == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "C2CShortcutBarConfBean{isShowAssistantEntrance = " + this.f200960a + "kuolieAIOEnable = " + this.f200961b + '}';
    }
}
