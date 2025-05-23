package com.tencent.qimei.ac;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements IAsyncQimeiListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f342936a;

    public c(d dVar) {
        this.f342936a = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        }
    }

    @Override // com.tencent.qimei.sdk.IAsyncQimeiListener
    public void onQimeiDispatch(Qimei qimei) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qimei);
            return;
        }
        if (!qimei.isEmpty()) {
            String str2 = a.f342930a;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("q16", qimei.getQimei16());
                jSONObject.put("q36", qimei.getQimei36());
                str = jSONObject.toString();
            } catch (Exception unused) {
                com.tencent.qimei.ad.c.a(a.f342930a, "jsbridge build JsInputParams Error", new Object[0]);
                str = "{}";
            }
            this.f342936a.b(str);
        }
    }
}
