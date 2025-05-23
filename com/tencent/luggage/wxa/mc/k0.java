package com.tencent.luggage.wxa.mc;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.wxa.mc.m;
import com.tencent.luggage.wxa.mc.n;
import com.tencent.luggage.wxa.mc.t0;
import com.tencent.luggage.wxa.tn.w0;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k0 implements n, t0.c {

    /* renamed from: f, reason: collision with root package name */
    public static final Map f134318f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final m f134319a;

    /* renamed from: b, reason: collision with root package name */
    public final String f134320b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f134321c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedList f134322d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f134323e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements c {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.mc.k0.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] a(String str, InputStream inputStream) {
            return com.tencent.luggage.wxa.tk.c.a(inputStream);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final Map f134324a;

            static {
                HashMap hashMap = new HashMap();
                f134324a = hashMap;
                hashMap.put(InputStream.class, new d());
                hashMap.put(WebResourceResponse.class, new f());
                hashMap.put(String.class, new e());
                hashMap.put(byte[].class, new b());
            }
        }

        Object a(String str, InputStream inputStream);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements c {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.mc.k0.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(String str, InputStream inputStream) {
            return com.tencent.luggage.wxa.tk.c.b(inputStream);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements c {
        public f() {
        }

        @Override // com.tencent.luggage.wxa.mc.k0.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WebResourceResponse a(String str, InputStream inputStream) {
            return new WebResourceResponse(com.tencent.luggage.wxa.bo.e.d(str), "UTF-8", inputStream);
        }
    }

    public k0(com.tencent.luggage.wxa.ic.g gVar) {
        this.f134323e = false;
        String appId = gVar.getAppId();
        this.f134320b = appId;
        this.f134321c = gVar;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.WxaPkgRuntimeReader", "<init> appId[%s] sysConfig.class[%s], stacktrace=%s", appId, gVar.j0().getClass().getName(), Log.getStackTraceString(new Throwable()));
        this.f134322d = new LinkedList();
        m a16 = u0.a(gVar, this);
        this.f134319a = a16;
        a16.b();
        this.f134323e = true;
    }

    public static boolean a(com.tencent.luggage.wxa.ic.g gVar, String str) {
        return b(gVar).d(str);
    }

    public static String b(com.tencent.luggage.wxa.ic.g gVar, String str) {
        m.a openReadPartialInfo;
        if (f(str) || (openReadPartialInfo = b(gVar).openReadPartialInfo(str)) == null) {
            return null;
        }
        return q.a(openReadPartialInfo.f134338d, openReadPartialInfo.f134340f);
    }

    public static void c(com.tencent.luggage.wxa.ic.g gVar) {
        b(gVar).b();
    }

    public static InputStream d(com.tencent.luggage.wxa.ic.g gVar, String str) {
        return (InputStream) b(gVar).a(str, InputStream.class);
    }

    public static WebResourceResponse e(com.tencent.luggage.wxa.ic.g gVar, String str) {
        return (WebResourceResponse) b(gVar).a(str, WebResourceResponse.class);
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public void close() {
        this.f134319a.close();
    }

    public final m f() {
        return this.f134319a;
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public m.a openReadPartialInfo(String str) {
        try {
            return this.f134319a.openReadPartialInfo(c(str));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static n a(com.tencent.luggage.wxa.ic.g gVar, boolean z16) {
        n nVar;
        if (gVar != null && !gVar.t0()) {
            if (gVar.j0() == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkgRuntimeReader", "obtainReader with runtime(%s) sysConfig(NULL), stack=%s", gVar.getAppId(), Log.getStackTraceString(new Throwable()));
                return n.a.f134344a;
            }
            Map map = f134318f;
            synchronized (map) {
                nVar = (n) map.get(gVar);
                if (nVar == null || z16) {
                    if (z16) {
                        a(gVar);
                    }
                    nVar = new k0(gVar);
                    map.put(gVar, nVar);
                }
            }
            return nVar;
        }
        return n.a.f134344a;
    }

    public static String c(com.tencent.luggage.wxa.ic.g gVar, String str) {
        return w0.d((String) b(gVar).a(str, String.class));
    }

    public static boolean f(String str) {
        return w0.c(str) || URLUtil.isAboutUrl(str) || com.tencent.luggage.wxa.tk.c.c(str) || URLUtil.isFileUrl(str);
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public boolean d(String str) {
        return a(str, false);
    }

    public final String e() {
        return this.f134320b;
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public List c() {
        return this.f134319a.c();
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public List d() {
        return this.f134319a.d();
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public a0 e(String str) {
        try {
            return this.f134319a.e(c(str));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.mc.n
    public String c(String str) {
        Iterator it = this.f134322d.iterator();
        while (it.hasNext()) {
            if (str.startsWith((String) it.next())) {
                return str;
            }
        }
        if (!f(str)) {
            String a16 = com.tencent.luggage.wxa.rc.m.a(str);
            return a16.startsWith("/__APP__") ? com.tencent.luggage.wxa.rc.m.a(a16.substring(8)) : a16;
        }
        throw new IllegalArgumentException("Invalid URL");
    }

    public static n b(com.tencent.luggage.wxa.ic.g gVar) {
        return a(gVar, false);
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public final InputStream b(String str) {
        try {
            return this.f134319a.b(c(str));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public void b() {
        this.f134319a.b();
    }

    public static boolean a(com.tencent.luggage.wxa.ic.g gVar) {
        n nVar;
        Map map = f134318f;
        synchronized (map) {
            nVar = (n) map.remove(gVar);
        }
        if (nVar == null) {
            return false;
        }
        nVar.close();
        return true;
    }

    @Override // com.tencent.luggage.wxa.mc.t0.c
    public void a(String str, a0 a0Var) {
        this.f134321c.a(!this.f134323e, str, a0Var);
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public final boolean a(String str, boolean z16) {
        try {
            return this.f134319a.a(c(str), z16);
        } catch (IllegalArgumentException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkgRuntimeReader", "canAccessFile, appId:%s, url:%s, checkCorrectReqURL get exception:%s", e(), str, e16);
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public List a() {
        return this.f134319a.a();
    }

    @Override // com.tencent.luggage.wxa.mc.n
    public Object a(String str, Class cls) {
        Object obj = null;
        try {
            String c16 = c(str);
            long currentTimeMillis = System.currentTimeMillis();
            InputStream b16 = b(c16);
            int i3 = -1;
            if (b16 != null) {
                try {
                    i3 = b16.available();
                } catch (IOException e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkgRuntimeReader", "openRead, appId = %s, reqURL = %s, access stream.available e = %s", this.f134320b, c16, e16);
                }
                obj = ((c) c.a.f134324a.get(cls)).a(c16, b16);
            }
            Object[] objArr = new Object[6];
            objArr[0] = this.f134320b;
            objArr[1] = c16;
            objArr[2] = Boolean.valueOf(obj == null);
            objArr[3] = cls.getName();
            objArr[4] = Integer.valueOf(i3);
            objArr[5] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.WxaPkgRuntimeReader", "openRead, appId = %s, reqURL = %s, null(%B), type = %s, length = %d, cost = %dms", objArr);
        } catch (IllegalArgumentException unused) {
        }
        return obj;
    }

    @Override // com.tencent.luggage.wxa.mc.n
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f134322d.add(str);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements c {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.mc.k0.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InputStream a(String str, InputStream inputStream) {
            return inputStream;
        }
    }
}
