package com.tencent.gdtad.wechat.mini;

import android.net.Uri;
import android.text.TextUtils;
import bn0.b;
import bn0.c;
import bn0.d;
import bn0.e;
import com.google.gson.GsonBuilder;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
final class a {

    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.wechat.mini.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1173a {

        /* renamed from: a, reason: collision with root package name */
        public c f109797a;

        /* renamed from: b, reason: collision with root package name */
        public int f109798b = 1;

        /* renamed from: c, reason: collision with root package name */
        public int f109799c = Integer.MIN_VALUE;

        public boolean a() {
            c cVar = this.f109797a;
            if (cVar != null && cVar.a()) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (a() && this.f109797a.b() && this.f109798b == 0) {
                return true;
            }
            return false;
        }

        public boolean c() {
            if (a() && this.f109797a.c() && this.f109798b == 0) {
                return true;
            }
            return false;
        }
    }

    private static <T> T a(String str, Class<T> cls, T t16) {
        if (TextUtils.isEmpty(str)) {
            return t16;
        }
        try {
            return (T) new GsonBuilder().disableHtmlEscaping().create().fromJson(str, (Class) cls);
        } catch (Throwable th5) {
            QLog.e("GdtWXMINIProgramOpenUrlInfoParser", 1, "[fromJson]", th5);
            return t16;
        }
    }

    public static C1173a b(String str) {
        C1173a c1173a;
        if (TextUtils.isEmpty(str)) {
            QLog.e("GdtWXMINIProgramOpenUrlInfoParser", 1, "[parse] error, url is null");
            C1173a c1173a2 = new C1173a();
            c1173a2.f109798b = 4;
            c1173a2.f109799c = 1;
            return c1173a2;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                QLog.e("GdtWXMINIProgramOpenUrlInfoParser", 1, "[parse] error, uri is null, url:" + str);
                C1173a c1173a3 = new C1173a();
                c1173a3.f109798b = 4;
                c1173a3.f109799c = 3;
                return c1173a3;
            }
            String scheme = parse.getScheme();
            String authority = parse.getAuthority();
            if (!TextUtils.equals(scheme, "qqadapi")) {
                QLog.e("GdtWXMINIProgramOpenUrlInfoParser", 1, "[parse] error, scheme not valid, url:" + str);
                C1173a c1173a4 = new C1173a();
                c cVar = new c();
                c1173a4.f109797a = cVar;
                cVar.f28680a = scheme;
                cVar.f28681b = authority;
                c1173a4.f109798b = 4;
                c1173a4.f109799c = 4;
                return c1173a4;
            }
            if (TextUtils.isEmpty(authority)) {
                QLog.e("GdtWXMINIProgramOpenUrlInfoParser", 1, "[parse] error, authority not valid, url:" + str);
                C1173a c1173a5 = new C1173a();
                c cVar2 = new c();
                c1173a5.f109797a = cVar2;
                cVar2.f28680a = scheme;
                cVar2.f28681b = authority;
                c1173a5.f109798b = 4;
                c1173a5.f109799c = 5;
                return c1173a5;
            }
            if (TextUtils.equals(authority, "handle_click")) {
                c1173a = c(parse);
            } else if (TextUtils.equals(authority, "open_web_page")) {
                c1173a = d(parse);
            } else {
                c1173a = null;
            }
            if (c1173a == null) {
                c1173a = new C1173a();
            }
            if (c1173a.f109797a == null) {
                c1173a.f109797a = new c();
            }
            c cVar3 = c1173a.f109797a;
            cVar3.f28680a = scheme;
            cVar3.f28681b = authority;
            return c1173a;
        } catch (Throwable th5) {
            QLog.e("GdtWXMINIProgramOpenUrlInfoParser", 1, "[parse] url:" + str, th5);
            C1173a c1173a6 = new C1173a();
            c1173a6.f109798b = 4;
            c1173a6.f109799c = 2;
            return c1173a6;
        }
    }

    private static C1173a c(Uri uri) {
        int i3;
        if (uri == null) {
            QLog.e("GdtWXMINIProgramOpenUrlInfoParser", 1, "[parseForClick] error, uri is null");
            C1173a c1173a = new C1173a();
            c1173a.f109798b = 1;
            c1173a.f109799c = 3;
            return c1173a;
        }
        String queryParameter = uri.getQueryParameter("weapp_context");
        String queryParameter2 = uri.getQueryParameter("mqq_openurl");
        c cVar = new c();
        cVar.f28682c = (b) a(queryParameter, b.class, null);
        e eVar = (e) a(queryParameter2, e.class, null);
        cVar.f28684e = eVar;
        if (eVar == null) {
            QLog.e("GdtWXMINIProgramOpenUrlInfoParser", 1, "[parseForClick] error, passthroughInfo is null");
            C1173a c1173a2 = new C1173a();
            c1173a2.f109798b = 4;
            if (TextUtils.isEmpty(queryParameter2)) {
                i3 = 6;
            } else {
                i3 = 7;
            }
            c1173a2.f109799c = i3;
            return c1173a2;
        }
        QLog.i("GdtWXMINIProgramOpenUrlInfoParser", 1, "[parseForClick] success");
        C1173a c1173a3 = new C1173a();
        c1173a3.f109797a = cVar;
        c1173a3.f109798b = 0;
        return c1173a3;
    }

    private static C1173a d(Uri uri) {
        int i3;
        if (uri == null) {
            QLog.e("GdtWXMINIProgramOpenUrlInfoParser", 1, "[parseForOpenWebPage] error, uri is null");
            C1173a c1173a = new C1173a();
            c1173a.f109798b = 1;
            c1173a.f109799c = 3;
            return c1173a;
        }
        String queryParameter = uri.getQueryParameter("weapp_context");
        String queryParameter2 = uri.getQueryParameter("mqq_openurl");
        String queryParameter3 = uri.getQueryParameter("mqq_web_page_info");
        c cVar = new c();
        cVar.f28682c = (b) a(queryParameter, b.class, null);
        cVar.f28684e = (e) a(queryParameter2, e.class, null);
        d dVar = (d) a(queryParameter3, d.class, null);
        cVar.f28683d = dVar;
        if (dVar == null) {
            QLog.e("GdtWXMINIProgramOpenUrlInfoParser", 1, "[parseForOpenWebPage] error, webPageInfo is null");
            C1173a c1173a2 = new C1173a();
            c1173a2.f109798b = 4;
            if (TextUtils.isEmpty(queryParameter3)) {
                i3 = 8;
            } else {
                i3 = 9;
            }
            c1173a2.f109799c = i3;
            return c1173a2;
        }
        QLog.i("GdtWXMINIProgramOpenUrlInfoParser", 1, "[parseForOpenWebPage] success");
        C1173a c1173a3 = new C1173a();
        c1173a3.f109797a = cVar;
        c1173a3.f109798b = 0;
        return c1173a3;
    }
}
