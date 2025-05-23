package com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes24.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private a f356632a;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        List<String> f356633a;

        /* renamed from: b, reason: collision with root package name */
        String f356634b;

        /* renamed from: c, reason: collision with root package name */
        int f356635c;

        /* renamed from: d, reason: collision with root package name */
        String f356636d;

        /* renamed from: e, reason: collision with root package name */
        String f356637e;

        /* renamed from: f, reason: collision with root package name */
        String f356638f;

        /* renamed from: g, reason: collision with root package name */
        Date f356639g;

        /* renamed from: h, reason: collision with root package name */
        Date f356640h;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public c(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f356632a = aVar;
        }
    }

    public List<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        a aVar = this.f356632a;
        if (aVar == null) {
            return null;
        }
        return aVar.f356633a;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        a aVar = this.f356632a;
        if (aVar == null) {
            return "";
        }
        return aVar.f356637e;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        a aVar = this.f356632a;
        if (aVar == null) {
            return "";
        }
        return aVar.f356634b;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        a aVar = this.f356632a;
        if (aVar == null) {
            return "";
        }
        return aVar.f356638f;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        a aVar = this.f356632a;
        if (aVar == null) {
            return "";
        }
        return aVar.f356636d;
    }

    public void f(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
        }
    }
}
