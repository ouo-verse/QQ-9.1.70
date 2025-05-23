package com.tencent.mobileqq.activity.recent.config.optpopbar;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements IConfigData {
    static IPatchRedirector $redirector_;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private boolean f185363d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f185364e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f185365f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f185366h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f185367i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f185368m;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a() {
        a aVar = new a();
        aVar.q(true);
        aVar.p(true);
        aVar.y(true);
        aVar.s(true);
        return aVar;
    }

    public static boolean c(a aVar) {
        if (!aVar.d() && !aVar.b() && !aVar.h() && !aVar.g() && !aVar.l() && !aVar.f() && !aVar.m() && !aVar.i() && !aVar.k() && !aVar.j()) {
            return true;
        }
        return false;
    }

    private static boolean n(JSONObject jSONObject, String str) {
        Object opt = jSONObject.opt(str);
        if ((opt instanceof Integer) && ((Integer) opt).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static a o(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("RecentOptPopBarSwitchBean", 2, str);
        }
        a aVar = new a();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
            aVar.q(n(optJSONObject, "create_groupchat"));
            aVar.p(n(optJSONObject, "add_friends_group"));
            aVar.u(n(optJSONObject, "match_chat"));
            aVar.t(n(optJSONObject, "letsparty"));
            aVar.y(n(optJSONObject, "scan"));
            aVar.s(n(optJSONObject, "fastpass"));
            aVar.z(n(optJSONObject, "send_receive_money"));
            aVar.v(n(optJSONObject, "add_miniprogram"));
            aVar.x(n(optJSONObject, "face_to_face_redpacket"));
            aVar.w(n(optJSONObject, "tencent_shopping_live"));
            aVar.r(n(optJSONObject, "create_qqgpro"));
            return aVar;
        } catch (Exception e16) {
            QLog.e("RecentOptPopBarSwitchBean", 1, "RecentOptPopBarSwitchBean#parce exception: ", e16);
            return a();
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f185364e;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f185363d;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.G;
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f185368m;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f185366h;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f185365f;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.D;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.F;
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.E;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f185367i;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.C;
    }

    public void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f185364e = z16;
        }
    }

    public void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f185363d = z16;
        }
    }

    public void r(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.G = z16;
        }
    }

    public void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.f185368m = z16;
        }
    }

    public void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.f185366h = z16;
        }
    }

    public void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.f185365f = z16;
        }
    }

    public void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.D = z16;
        }
    }

    public void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.F = z16;
        }
    }

    public void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.E = z16;
        }
    }

    public void y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.f185367i = z16;
        }
    }

    public void z(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.C = z16;
        }
    }
}
