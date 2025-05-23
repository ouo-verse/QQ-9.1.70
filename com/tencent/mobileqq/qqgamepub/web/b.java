package com.tencent.mobileqq.qqgamepub.web;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        } else {
            GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("769").setBussinessId("1").setPageId("160").setModuleType("76901").setOperId("205037").setExt(2, str2).setExt(3, "1").setExt(4, "20").setGameAppId(str).report();
        }
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("769").setBussinessId("1").setPageId("160").setModuleType("76901").setOperId("205031").setExt(2, str).setExt(4, "20").report();
        }
    }

    public void c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        } else {
            GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("769").setBussinessId("1").setPageId("160").setModuleType("76901").setOperId("205037").setExt(2, str2).setExt(3, "2").setExt(4, "20").setGameAppId(str).report();
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("769").setBussinessId("1").setPageId("160").setModuleType("76901").setOperId("205036").setExt(4, "20").report();
        }
    }

    public void e(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16));
            return;
        }
        WadlReportBuilder z17 = GamePubAccountHelper.z(GamePubAccountHelper.s());
        z17.setOperModule("770").setBussinessId("1").setPageId("160").setModuleType("77002").setOperId("207021").setExt(4, "8").setExt(24, "1").report();
        if (!z16) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            z17.setExt(2, str).setExt(3, "3");
        } else if (!TextUtils.isEmpty(str)) {
            z17.setExt(2, str);
            z17.setExt(3, "1");
        } else {
            z17.setExt(3, "2");
        }
        z17.report();
    }

    public void f(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("769").setBussinessId("1").setPageId("160").setModuleType("76901").setGameAppId(str).setOperId("205030").setExt(2, str2).setExt(4, "8").report();
        }
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("769").setBussinessId("1").setPageId("160").setModuleType("76902").setOperId("205838").setExt(4, "8").setRetId(i3).report();
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("769").setBussinessId("1").setPageId("160").setModuleType("76925").setOperId("207552").setExt(4, "8").report();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("769").setBussinessId("1").setPageId("160").setModuleType("76925").setOperId("207553").setExt(4, "20").report();
        }
    }
}
