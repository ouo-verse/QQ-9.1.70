package com.tencent.mobileqq.tianjige.metric;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f292974a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f292975b;

    /* renamed from: c, reason: collision with root package name */
    private double f292976c;

    /* renamed from: d, reason: collision with root package name */
    private Attributes f292977d;

    public c(String str, double d16, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Double.valueOf(d16), map);
            return;
        }
        this.f292974a = str;
        d(d16);
        e(map);
    }

    public Attributes a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Attributes) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f292977d;
    }

    public double b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Double) iPatchRedirector.redirect((short) 6, (Object) this)).doubleValue();
        }
        this.f292975b = false;
        return this.f292976c;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f292975b;
    }

    public void d(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Double.valueOf(d16));
        } else {
            this.f292976c = d16;
            this.f292975b = true;
        }
    }

    public void e(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) map);
            return;
        }
        AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
        a16.put("platform", "android").put("app_env", "public_ver");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a16.put(entry.getKey(), entry.getValue());
            }
        }
        this.f292977d = a16.build();
    }
}
