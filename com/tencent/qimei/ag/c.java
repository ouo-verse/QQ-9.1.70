package com.tencent.qimei.ag;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.foundation.net.protocol.CMD;
import com.tencent.qimei.uin.U;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final Integer f342971c;

    /* renamed from: a, reason: collision with root package name */
    public String f342972a;

    /* renamed from: b, reason: collision with root package name */
    public String f342973b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19493);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342971c = 2;
        }
    }

    public c(String str, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16));
            return;
        }
        this.f342973b = "";
        this.f342972a = str;
        if (z16) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        this.f342973b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("1", "1.0");
            jSONObject.put("3", this.f342973b);
            str = jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str2 = this.f342972a;
        CMD cmd = CMD.GET_OID;
        com.tencent.qimei.x.c cVar = new com.tencent.qimei.x.c(U.a(str2, cmd.b(), str, cmd.a()));
        if (cVar.c()) {
            cVar.a();
            com.tencent.qimei.ad.c.b("IsolateRequest", "report oid success", new Object[0]);
        } else {
            com.tencent.qimei.ad.c.a("IsolateRequest", "report oid failed, response err code is %s", cVar.b());
        }
    }
}
