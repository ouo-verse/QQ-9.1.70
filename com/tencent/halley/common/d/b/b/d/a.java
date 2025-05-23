package com.tencent.halley.common.d.b.b.d;

import android.text.TextUtils;
import com.tencent.halley.common.a.h;
import com.tencent.halley.common.d.b.b.b;
import com.tencent.halley.common.d.b.b.c;
import com.tencent.halley.common.utils.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final h.a f113515a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113515a = new h.a();
            com.tencent.halley.common.a.h().post(new Runnable() { // from class: com.tencent.halley.common.d.b.b.d.a.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String string = com.tencent.halley.common.a.a().getSharedPreferences(a.d(), 0).getString("halley_cloud_param_content", "");
                    d.c("halley-cloud-HttpRspSetting", "loadLocal jsonData:".concat(String.valueOf(string)));
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            a.this.f113515a.a(string);
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            a.a("");
                        }
                    }
                }
            });
        }
    }

    static String d() {
        String str;
        StringBuilder sb5 = new StringBuilder("Halley_Cloud_Param_Content_");
        sb5.append(com.tencent.halley.common.a.c());
        sb5.append("_for_SettingsHandler");
        if (com.tencent.halley.common.a.b()) {
            str = "_test";
        } else {
            str = "";
        }
        sb5.append(str);
        return sb5.toString();
    }

    private void e() {
        com.tencent.halley.common.a.h().post(new Runnable() { // from class: com.tencent.halley.common.d.b.b.d.a.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    c.c().f113494a.a(a.this.f113515a.a(), com.tencent.halley.common.d.b.a.b.a().b());
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        });
    }

    @Override // com.tencent.halley.common.d.b.b.b
    public final void a(com.tencent.halley.common.d.b.b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            aVar.a("confVersion", this.f113515a.c());
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.halley.common.d.b.b.b, com.tencent.halley.common.d.a
    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            e();
        }
    }

    @Override // com.tencent.halley.common.d.b.b.b
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return QCircleDaTongConstant.ElementParamValue.SETTINGS;
    }

    static void a(String str) {
        com.tencent.halley.common.a.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", str).commit();
    }

    @Override // com.tencent.halley.common.d.b.b.b
    public final void a(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jSONObject);
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("Setting");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("data");
                if (!TextUtils.isEmpty(optString)) {
                    this.f113515a.a(optString);
                    a(this.f113515a.a());
                }
            }
        } catch (Throwable th5) {
            try {
                th5.printStackTrace();
            } finally {
                e();
            }
        }
    }
}
