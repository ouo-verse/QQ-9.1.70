package hynb.v;

import android.content.Context;
import com.huya.udb.loginsdk.wup.AppLoginData;
import com.huya.udb.loginsdk.wup.ResponseHeader;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.CloudStorageServlet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static volatile e f406893a;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements hynb.x.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppLoginData f406894a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f406895b;

        public a(AppLoginData appLoginData, f fVar) {
            this.f406894a = appLoginData;
            this.f406895b = fVar;
        }

        @Override // hynb.x.a
        public void a(int i3, ResponseHeader responseHeader, AppLoginData appLoginData) {
            if (i3 != 0 || responseHeader == null || responseHeader.returnCode == 0) {
                e.this.a(this.f406895b, i3, responseHeader, appLoginData, "", true);
            } else {
                hynb.w.a.c().a(this.f406894a.uid);
                e.this.b(this.f406895b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements hynb.x.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f406897a;

        public b(f fVar) {
            this.f406897a = fVar;
        }

        @Override // hynb.x.a
        public void a(int i3, ResponseHeader responseHeader, AppLoginData appLoginData) {
            e.this.a(this.f406897a, i3, responseHeader, appLoginData, "", true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements hynb.x.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f406899a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f406900b;

        public c(f fVar, String str) {
            this.f406899a = fVar;
            this.f406900b = str;
        }

        @Override // hynb.x.a
        public void a(int i3, ResponseHeader responseHeader, AppLoginData appLoginData) {
            e.this.a(this.f406899a, i3, responseHeader, appLoginData, this.f406900b, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class d implements hynb.x.a {
        public d(e eVar) {
        }

        @Override // hynb.x.a
        public void a(int i3, ResponseHeader responseHeader, AppLoginData appLoginData) {
            new AppLoginData().uid = hynb.z.b.f406930i;
            hynb.z.b.f406930i = 0L;
        }
    }

    public final void b(f<hynb.v.b> fVar) {
        Map<String, Object> a16 = hynb.z.b.a("");
        a16.put("bizAppids", hynb.z.b.a());
        a16.put("needCookie", Boolean.FALSE);
        hynb.w.b.a(a16, hynb.z.b.d(), "huyaudbwebui", "hyanonymousLoginAlias", new b(fVar));
    }

    public static e a() {
        if (f406893a == null) {
            synchronized (e.class) {
                if (f406893a == null) {
                    f406893a = new e();
                }
            }
        }
        return f406893a;
    }

    public void b() {
        if (hynb.z.b.f406930i == 0) {
            return;
        }
        Map<String, Object> a16 = hynb.z.b.a("");
        a16.put("uid", Long.valueOf(hynb.z.b.f406930i));
        a16.put("logoffType", 1);
        hynb.w.b.a(a16, hynb.z.b.d(), "huyaudbwebui", "hylogoutAlias", new d(this));
    }

    public void a(String str) {
        hynb.z.b.f406926e = str;
    }

    public void a(boolean z16) {
        hynb.z.b.f406925d = z16;
    }

    public void a(Context context, String str, String str2) {
        hynb.z.b.f406924c = context;
        hynb.z.b.f406922a = str;
        hynb.z.b.f406923b = str2;
        hynb.w.a.c().d();
    }

    public void a(f<hynb.v.b> fVar) {
        hynb.p.g.f406799a.info("hyudb", "loginHyAnonymouse");
        AppLoginData b16 = hynb.w.a.c().b();
        if (b16 != null) {
            a(b16, fVar);
        } else {
            b(fVar);
        }
    }

    public final void a(AppLoginData appLoginData, f<hynb.v.b> fVar) {
        Map<String, Object> a16 = hynb.z.b.a("");
        a16.put("bizAppids", hynb.z.b.a());
        a16.put("needCookie", Boolean.FALSE);
        a16.put("uid", Long.valueOf(appLoginData.uid));
        a16.put("credential", appLoginData.cred);
        hynb.w.b.a(a16, hynb.z.b.d(), "huyaudbwebui", "hyanonymousCredloginAlias", new a(appLoginData, fVar));
    }

    public void a(int i3, String str, g gVar, String str2, f<hynb.v.b> fVar) {
        Map<String, Object> a16 = hynb.z.b.a(str2);
        a16.put("bizAppids", hynb.z.b.a());
        a16.put("needCookie", Boolean.FALSE);
        a16.put("openType", Integer.valueOf(i3));
        a16.put("token", str);
        if (gVar != null) {
            String str3 = gVar.f406903b;
            if (str3 == null) {
                str3 = "";
            }
            a16.put("openId", str3);
            HashMap hashMap = new HashMap();
            String str4 = gVar.f406904c;
            if (str4 == null) {
                str4 = "";
            }
            hashMap.put("tokenSecret", str4);
            String str5 = gVar.f406906e;
            if (str5 == null) {
                str5 = "";
            }
            hashMap.put(WadlProxyConsts.CHANNEL, str5);
            String str6 = gVar.f406907f;
            if (str6 == null) {
                str6 = "";
            }
            hashMap.put("oauth_type", str6);
            String str7 = gVar.f406907f;
            if (str7 != null && str7.equals("1")) {
                a16.put("tokenType", 1);
            } else {
                a16.put("tokenType", 0);
            }
            String str8 = gVar.f406905d;
            if (str8 == null) {
                str8 = "";
            }
            hashMap.put("oauthUrl", str8);
            String str9 = gVar.f406902a;
            if (str9 == null) {
                str9 = "";
            }
            hashMap.put("third_appkey", str9);
            String str10 = gVar.f406903b;
            if (str10 == null) {
                str10 = "";
            }
            hashMap.put("partner_uid", str10);
            hashMap.put(CloudStorageServlet.REQUEST_TYPE, "Oauth");
            hashMap.put("version", "2");
            String str11 = gVar.f406908g;
            hashMap.put("authorization_code", str11 != null ? str11 : "");
            a16.put("thirdParams", hashMap);
        }
        hynb.w.b.a(a16, hynb.z.b.d(), "huyaudbwebui", "hythirdLoginAlias", new c(fVar, str2));
    }

    public final void a(f<hynb.v.b> fVar, int i3, ResponseHeader responseHeader, AppLoginData appLoginData, String str, boolean z16) {
        if (fVar == null) {
            return;
        }
        if (i3 == 0) {
            fVar.onResponse(hynb.w.a.c().a(responseHeader, appLoginData, z16));
            return;
        }
        if (i3 == 2) {
            fVar.onResponse(hynb.w.a.c().a(str));
            return;
        }
        if (z16) {
            hynb.v.a aVar = new hynb.v.a();
            aVar.f406886d = 1;
            aVar.f406884b = "\u5185\u90e8\u5f02\u5e38";
            fVar.onResponse(aVar);
            return;
        }
        hynb.v.c cVar = new hynb.v.c();
        cVar.f406888b = -1;
        cVar.f406891e = 1;
        cVar.f406889c = "\u5185\u90e8\u5f02\u5e38";
        fVar.onResponse(cVar);
    }

    public String a(long j3) {
        return hynb.w.a.c().b(j3);
    }
}
