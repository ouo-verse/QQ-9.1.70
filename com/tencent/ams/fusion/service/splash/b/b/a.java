package com.tencent.ams.fusion.service.splash.b.b;

import com.tencent.ams.fusion.service.splash.b.b.a.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements kt.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private nt.f f70318a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.ams.fusion.service.splash.data.b f70319b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.ams.fusion.service.splash.data.a f70320c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f70319b = com.tencent.ams.fusion.service.b.b().m();
        }
    }

    private b.d a(rt.c cVar, int i3, long j3) {
        int i16;
        b.d dVar = new b.d();
        dVar.c(cVar);
        if (cVar != null && this.f70320c != null && this.f70318a != null) {
            com.tencent.ams.fusion.a.f.j("PreloadParseDataTask", " parsePreloadResponse success.");
            this.f70320c.b(b(false), cVar);
        } else {
            com.tencent.ams.fusion.a.f.h("PreloadParseDataTask", " parsePreloadResponse failed failReason:" + i3);
        }
        dVar.a(i3);
        dVar.b(System.currentTimeMillis() - j3);
        if (i3 != Integer.MIN_VALUE) {
            i16 = 411;
        } else {
            i16 = 412;
        }
        g(i16, i3, j3);
        return dVar;
    }

    private void g(int i3, long j3, long j16) {
        nt.d.b(this.f70318a, i3, j3, System.currentTimeMillis() - j16, Integer.MIN_VALUE);
    }

    @Override // kt.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? "PreloadParseDataTask" : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // kt.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public nt.c c() {
        com.tencent.ams.fusion.service.splash.data.a aVar;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (nt.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        g(410, 0L, currentTimeMillis);
        if (this.f70318a != null && this.f70319b != null && (aVar = this.f70320c) != null) {
            Object a16 = aVar.a(b(true));
            if (a16 instanceof String) {
                str = (String) a16;
            } else {
                str = null;
            }
            if (str == null) {
                return a(null, 512, currentTimeMillis);
            }
            try {
                rt.c a17 = this.f70319b.a(new JSONObject(str));
                if (a17 != null) {
                    return a(a17, Integer.MIN_VALUE, currentTimeMillis);
                }
                return a(null, 2048, currentTimeMillis);
            } catch (JSONException e16) {
                com.tencent.ams.fusion.a.f.c("PreloadParseDataTask", ",execute error :", e16);
                return a(null, 1024, currentTimeMillis);
            }
        }
        return a(null, 256, currentTimeMillis);
    }

    public void h(com.tencent.ams.fusion.service.splash.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f70320c = aVar;
        }
    }

    public void i(nt.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fVar);
        } else {
            this.f70318a = fVar;
        }
    }

    private String b(boolean z16) {
        StringBuilder sb5;
        String str;
        nt.f fVar = this.f70318a;
        if (fVar == null) {
            return "";
        }
        String b16 = fVar.b();
        if (this.f70318a.a()) {
            sb5 = new StringBuilder();
            sb5.append(b16);
            str = z16 ? "key_preload_request_hot" : "key_preload_parse_data_hot";
        } else {
            sb5 = new StringBuilder();
            sb5.append(b16);
            str = z16 ? "key_preload_request_cold" : "key_preload_parse_data_cold";
        }
        sb5.append(str);
        return sb5.toString();
    }
}
