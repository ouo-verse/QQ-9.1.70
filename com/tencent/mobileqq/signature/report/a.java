package com.tencent.mobileqq.signature.report;

import android.util.Base64;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantItem;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    private static a f288432l;

    /* renamed from: a, reason: collision with root package name */
    private String f288433a;

    /* renamed from: b, reason: collision with root package name */
    private String f288434b;

    /* renamed from: c, reason: collision with root package name */
    private String f288435c;

    /* renamed from: d, reason: collision with root package name */
    private String f288436d;

    /* renamed from: e, reason: collision with root package name */
    private String f288437e;

    /* renamed from: f, reason: collision with root package name */
    private int f288438f;

    /* renamed from: g, reason: collision with root package name */
    private int f288439g;

    /* renamed from: h, reason: collision with root package name */
    private int f288440h;

    /* renamed from: i, reason: collision with root package name */
    private String f288441i;

    /* renamed from: j, reason: collision with root package name */
    private String f288442j;

    /* renamed from: k, reason: collision with root package name */
    public String f288443k;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50514);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            f288432l = new a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f288433a = "";
        this.f288434b = "";
        this.f288435c = "";
        this.f288436d = "";
        this.f288437e = "";
        this.f288441i = "";
        this.f288442j = "";
        this.f288443k = "";
    }

    private void a() {
        this.f288433a = "";
        this.f288434b = "";
        this.f288435c = "";
        this.f288436d = "";
        this.f288437e = "";
        this.f288438f = 0;
        this.f288439g = 0;
        this.f288440h = 0;
        this.f288441i = "";
        this.f288442j = "";
    }

    private String b(int i3) {
        String str;
        if (i3 != 2 && i3 != 14) {
            str = "mvip.g.gq.gq_editenter";
        } else {
            str = "mvip.u.a.h5";
        }
        return "{\"aid\":\"" + str + "\"}";
    }

    public static a c() {
        return f288432l;
    }

    private void t() {
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction("DressVip", "3001007", this.f288433a, this.f288434b, this.f288435c, this.f288436d, this.f288437e, this.f288438f, this.f288439g, this.f288440h, this.f288441i, this.f288442j, this.f288443k);
    }

    public String d(int i3, int i16, int i17, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, str2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", "DressVip");
            jSONObject.put("page_id", "3001007");
            jSONObject.put("sub_module_id", i16);
            jSONObject.put("item_id", i3);
            jSONObject.put("action_id", 109);
            jSONObject.put("str_ruleid", str);
            jSONObject.put("item_type", str2);
            jSONObject.put("module_id", "4");
            String b16 = b(i17);
            this.f288442j = b16;
            jSONObject.put("busi_info", b16);
            return Base64.encodeToString(jSONObject.toString().getBytes(), 0).trim().replaceAll("\n", "").replaceAll(" ", "");
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        } catch (Exception e17) {
            e17.printStackTrace();
            return "";
        }
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        a();
        this.f288433a = "1";
        this.f288435c = "history";
        this.f288438f = i3;
        this.f288437e = "4";
        t();
    }

    public void f(int i3, int i16, AvatarPendantItem avatarPendantItem, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), avatarPendantItem, str);
            return;
        }
        a();
        this.f288433a = "4";
        this.f288436d = "" + i16;
        this.f288435c = "" + avatarPendantItem.itemId;
        this.f288437e = str;
        this.f288438f = i3;
        this.f288442j = b(avatarPendantItem.feeType);
        this.f288441i = avatarPendantItem.strRuleid;
        t();
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        a();
        this.f288433a = "1";
        this.f288435c = "location";
        this.f288438f = i3;
        this.f288437e = "4";
        t();
    }

    public void h(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) str);
            return;
        }
        a();
        this.f288433a = "2";
        this.f288435c = str;
        this.f288438f = i3;
        this.f288437e = "4";
        t();
    }

    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        a();
        this.f288433a = "2";
        this.f288435c = OpenConstants.ApiName.PAY;
        this.f288438f = i3;
        this.f288437e = "4";
        t();
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        a();
        this.f288433a = "1";
        this.f288435c = "qzone";
        this.f288438f = i3;
        this.f288437e = "4";
        t();
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        a();
        this.f288433a = "1";
        this.f288438f = i3;
        this.f288437e = "4";
        this.f288435c = "back";
        t();
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        a();
        this.f288438f = 100;
        t();
    }

    public void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        a();
        this.f288433a = "1";
        this.f288438f = i3;
        this.f288435c = "preview";
        this.f288437e = "4";
        t();
    }

    public void n(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) str);
            return;
        }
        a();
        this.f288433a = "3";
        this.f288435c = str;
        this.f288438f = i3;
        this.f288437e = "4";
        t();
    }

    public void o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        a();
        this.f288433a = "4";
        this.f288435c = str;
        this.f288438f = 112;
        t();
    }

    public void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        a();
        this.f288433a = "1";
        this.f288435c = "topic";
        this.f288438f = i3;
        this.f288437e = "4";
        t();
    }

    public void q(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        a();
        this.f288433a = "5";
        this.f288437e = "4";
        this.f288435c = "" + i16;
        this.f288438f = i3;
        t();
    }

    public void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        a();
        this.f288433a = "5";
        this.f288437e = "55";
        this.f288435c = "search";
        this.f288438f = i3;
        t();
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        a();
        this.f288433a = "5";
        this.f288438f = 111;
        t();
    }
}
