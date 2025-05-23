package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fa extends fc {

    /* renamed from: p, reason: collision with root package name */
    private a f388797p;

    /* renamed from: q, reason: collision with root package name */
    private final Map<String, String> f388798q;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f388799b = new a("get");

        /* renamed from: c, reason: collision with root package name */
        public static final a f388800c = new a("set");

        /* renamed from: d, reason: collision with root package name */
        public static final a f388801d = new a("result");

        /* renamed from: e, reason: collision with root package name */
        public static final a f388802e = new a("error");

        /* renamed from: f, reason: collision with root package name */
        public static final a f388803f = new a("command");

        /* renamed from: a, reason: collision with root package name */
        private String f388804a;

        a(String str) {
            this.f388804a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = f388799b;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = f388800c;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = f388802e;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = f388801d;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = f388803f;
            if (!aVar5.toString().equals(lowerCase)) {
                return null;
            }
            return aVar5;
        }

        public String toString() {
            return this.f388804a;
        }
    }

    public fa() {
        this.f388797p = a.f388799b;
        this.f388798q = new HashMap();
    }

    public synchronized void A(Map<String, String> map) {
        this.f388798q.putAll(map);
    }

    public String B() {
        return null;
    }

    @Override // com.xiaomi.push.fc
    public Bundle a() {
        Bundle a16 = super.a();
        a aVar = this.f388797p;
        if (aVar != null) {
            a16.putString("ext_iq_type", aVar.toString());
        }
        return a16;
    }

    @Override // com.xiaomi.push.fc
    public String f() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("<iq ");
        if (l() != null) {
            sb5.append("id=\"" + l() + "\" ");
        }
        if (o() != null) {
            sb5.append("to=\"");
            sb5.append(fm.b(o()));
            sb5.append("\" ");
        }
        if (q() != null) {
            sb5.append("from=\"");
            sb5.append(fm.b(q()));
            sb5.append("\" ");
        }
        if (m() != null) {
            sb5.append("chid=\"");
            sb5.append(fm.b(m()));
            sb5.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f388798q.entrySet()) {
            sb5.append(fm.b(entry.getKey()));
            sb5.append("=\"");
            sb5.append(fm.b(entry.getValue()));
            sb5.append("\" ");
        }
        if (this.f388797p == null) {
            sb5.append("type=\"get\">");
        } else {
            sb5.append("type=\"");
            sb5.append(y());
            sb5.append("\">");
        }
        String B = B();
        if (B != null) {
            sb5.append(B);
        }
        sb5.append(u());
        ff d16 = d();
        if (d16 != null) {
            sb5.append(d16.b());
        }
        sb5.append("</iq>");
        return sb5.toString();
    }

    public a y() {
        return this.f388797p;
    }

    public void z(a aVar) {
        if (aVar == null) {
            this.f388797p = a.f388799b;
        } else {
            this.f388797p = aVar;
        }
    }

    public fa(Bundle bundle) {
        super(bundle);
        this.f388797p = a.f388799b;
        this.f388798q = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f388797p = a.a(bundle.getString("ext_iq_type"));
        }
    }
}
