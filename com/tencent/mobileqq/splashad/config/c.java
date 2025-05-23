package com.tencent.mobileqq.splashad.config;

import android.text.TextUtils;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.util.CommonMMKVUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private volatile String f288768a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final c f288769a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75191);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f288769a = new c();
            }
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static c a() {
        return a.f288769a;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f288768a == null) {
            try {
                this.f288768a = CommonMMKVUtils.getString("tsm_curmode", "", false);
            } catch (Throwable unused) {
                this.f288768a = "";
            }
        }
        return this.f288768a;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String d16 = d();
        if (TextUtils.isEmpty(d16)) {
            return "";
        }
        return "tsm_" + d16;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (QQTheme.isNowThemeIsNight()) {
            return "night";
        }
        return "normal";
    }

    public String e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "tsm_" + str;
    }

    public String f() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (QQTheme.isDefaultTheme()) {
            str = "normal";
        } else if (QQTheme.isNowSimpleUI()) {
            str = "simple";
        } else {
            str = "";
        }
        if (ElderModeManager.j()) {
            str = "elder";
        } else if (StudyModeManager.t()) {
            str = "study";
        }
        CommonMMKVUtils.putString("tsm_curmode", str, false);
        this.f288768a = str;
        return str;
    }
}
