package com.tencent.mobileqq.studymode;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ea;

/* compiled from: P */
/* loaded from: classes18.dex */
public class aa {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences.Editor f290979a;

    public aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f290979a = StudyModeMMKVManager.d().c().edit();
        }
    }

    public aa a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (aa) iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
        }
        if (StudyModeMMKVManager.d().h()) {
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            this.f290979a.putBoolean(str + account, z16).commit();
        }
        ea.y2(str, Boolean.valueOf(z16));
        return this;
    }

    public aa b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (aa) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
        }
        if (StudyModeMMKVManager.d().h()) {
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            this.f290979a.putInt(str + account, i3).commit();
        }
        ea.y2(str, Integer.valueOf(i3));
        return this;
    }

    public aa c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (aa) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        if (StudyModeMMKVManager.d().h()) {
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            this.f290979a.putString(str + account, str2).commit();
        }
        ea.y2(str, str2);
        return this;
    }
}
