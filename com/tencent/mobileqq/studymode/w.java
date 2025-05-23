package com.tencent.mobileqq.studymode;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ea;

/* compiled from: P */
/* loaded from: classes18.dex */
public class w {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f291045a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f291046b;

    public w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f291046b = StudyModeMMKVManager.d().h();
        com.tencent.xaction.log.b.a("StudyModeReadWrapper", 1, "create StudyModeReadWrapper\uff0cisUseMMKV:" + this.f291046b);
        if (this.f291046b) {
            this.f291045a = StudyModeMMKVManager.d().c();
        }
    }

    public boolean a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        if (this.f291046b) {
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            return this.f291045a.getBoolean(str + account, z16);
        }
        return ((Boolean) ea.j(str, Boolean.valueOf(z16))).booleanValue();
    }

    public int b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3)).intValue();
        }
        if (this.f291046b) {
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            return this.f291045a.getInt(str + account, i3);
        }
        return ((Integer) ea.j(str, Integer.valueOf(i3))).intValue();
    }

    public String c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        if (this.f291046b) {
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            return this.f291045a.getString(str + account, str2);
        }
        return (String) ea.j(str, str2);
    }
}
