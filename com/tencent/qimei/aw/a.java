package com.tencent.qimei.aw;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.av.f;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public AtomicInteger f343190a;

    /* renamed from: b, reason: collision with root package name */
    public Context f343191b;

    /* renamed from: c, reason: collision with root package name */
    public String f343192c;

    /* renamed from: d, reason: collision with root package name */
    public String f343193d;

    /* renamed from: e, reason: collision with root package name */
    public d f343194e;

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.aw.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C9311a extends c {
        static IPatchRedirector $redirector_;

        public C9311a(String str, String str2) {
            super(str, str2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, str, str2);
            }
        }

        @Override // com.tencent.qimei.aw.a.c
        public String a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            String replace = str.replace("https://tun-cos-1258344701.file.myqcloud.com/fp.js", "tun-cos-1258344701.js");
            com.tencent.qimei.ab.c.a(a.this.f343193d, replace, "tun-cos-1258344701.html");
            return replace;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b extends c {
        static IPatchRedirector $redirector_;

        public b(String str, String str2) {
            super(str, str2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, str, str2);
            }
        }

        @Override // com.tencent.qimei.aw.a.c
        public String a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            com.tencent.qimei.ab.c.a(a.this.f343193d, str, "tun-cos-1258344701.js");
            return str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public abstract class c implements com.tencent.qimei.w.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f343197a;

        /* renamed from: b, reason: collision with root package name */
        public final String f343198b;

        public c(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, str, str2);
            } else {
                this.f343197a = str;
                this.f343198b = str2;
            }
        }

        public abstract String a(String str);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface d {
    }

    public a(Context context, String str, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, dVar);
            return;
        }
        this.f343191b = context;
        this.f343192c = str;
        this.f343190a = new AtomicInteger();
        this.f343194e = dVar;
        this.f343193d = this.f343191b.getFilesDir().getAbsolutePath() + "/jsfile/";
    }

    public static void a(a aVar, String str, String str2) {
        if (aVar.f343190a.incrementAndGet() == 2) {
            ((f) aVar.f343194e).a();
        }
        com.tencent.qimei.aa.f.b(aVar.f343192c).a("lc_fe_tm", System.currentTimeMillis());
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.tencent.qimei.aa.f.b(aVar.f343192c).a(str, com.tencent.qimei.ab.a.a(str2));
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        String d16 = com.tencent.qimei.aa.f.b(this.f343192c).d("js_md_tm");
        if (z16) {
            d16 = "";
        }
        com.tencent.qimei.t.a.a().a(new com.tencent.qimei.w.a(com.tencent.qimei.av.a.f343151a, d16, new b("js_md_tm", "lc_fe_st_js")));
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        String d16 = com.tencent.qimei.aa.f.b(this.f343192c).d("hm_md_tm");
        if (z16) {
            d16 = "";
        }
        com.tencent.qimei.t.a.a().a(new com.tencent.qimei.w.a("https://tun-cos-1258344701.file.myqcloud.com/my.html", d16, new C9311a("hm_md_tm", "lc_fe_st_hm")));
    }
}
