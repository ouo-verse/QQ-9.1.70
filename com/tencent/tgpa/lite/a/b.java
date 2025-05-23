package com.tencent.tgpa.lite.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.tgpa.lite.g.e;
import com.tencent.tgpa.lite.g.h;
import com.tencent.tgpa.lite.g.j;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f375867d;

    /* renamed from: a, reason: collision with root package name */
    public c f375868a;

    /* renamed from: b, reason: collision with root package name */
    public a f375869b;

    /* renamed from: c, reason: collision with root package name */
    public C9905b f375870c;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f375871a;

        /* renamed from: b, reason: collision with root package name */
        public String f375872b;

        public a(b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tgpa.lite.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C9905b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f375873a;

        public C9905b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f375874a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f375875b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f375876c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f375877d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f375878e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f375879f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f375880g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f375881h;

        public c(b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
                return;
            }
            this.f375876c = false;
            this.f375877d = false;
            this.f375878e = true;
            this.f375879f = true;
            this.f375880g = true;
            this.f375881h = false;
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f375868a = new c(this);
        this.f375869b = new a(this);
        this.f375870c = new C9905b();
        if (com.tencent.tgpa.lite.f.a.d()) {
            c cVar = this.f375868a;
            cVar.f375878e = false;
            cVar.f375879f = false;
            cVar.f375880g = false;
        }
    }

    public static b a() {
        if (f375867d == null) {
            synchronized (b.class) {
                if (f375867d == null) {
                    f375867d = new b();
                }
            }
        }
        return f375867d;
    }

    public int b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).intValue();
        }
        if (str == null) {
            return 1;
        }
        try {
            if (str.equals("")) {
                return 2;
            }
            String[] split = new String(e.a(str.getBytes())).split(",");
            if (split.length != 2) {
                return 3;
            }
            a aVar = this.f375869b;
            String str2 = split[0];
            aVar.f375871a = str2;
            aVar.f375872b = split[1];
            j.b("SecretKey", str2);
            j.b("IvParameter", this.f375869b.f375872b);
            return 0;
        } catch (IllegalArgumentException e16) {
            e16.printStackTrace();
            return 4;
        } catch (Exception e17) {
            e17.printStackTrace();
            return 5;
        }
    }

    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
            if (optJSONObject != null) {
                this.f375868a.f375874a = optJSONObject.optBoolean("globalSwitch");
                this.f375868a.f375875b = optJSONObject.optBoolean("debugMode");
                this.f375868a.f375876c = optJSONObject.optBoolean("reportAll");
                this.f375868a.f375878e = optJSONObject.optBoolean("uniqueIdReport");
                this.f375868a.f375879f = optJSONObject.optBoolean("safeUniqueIdReport");
                this.f375868a.f375880g = optJSONObject.optBoolean("vendorOAIDReport");
                this.f375868a.f375877d = optJSONObject.optBoolean("debugIdReport");
                this.f375868a.f375881h = optJSONObject.optBoolean("deviceIdentify");
                if (!this.f375868a.f375880g) {
                    h.d("Cloud Config closed the oaid func, ple call tgpa team!", new Object[0]);
                }
                if (!this.f375868a.f375879f) {
                    h.d("Cloud Config closed the xid func, ple call tgpa team!", new Object[0]);
                }
                if (optJSONObject2 == null) {
                    return true;
                }
                this.f375870c.f375873a = optJSONObject2.optInt("deviceType", 0);
                return true;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return false;
    }
}
