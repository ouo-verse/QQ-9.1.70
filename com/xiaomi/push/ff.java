package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ff {

    /* renamed from: a, reason: collision with root package name */
    private int f388832a;

    /* renamed from: b, reason: collision with root package name */
    private String f388833b;

    /* renamed from: c, reason: collision with root package name */
    private String f388834c;

    /* renamed from: d, reason: collision with root package name */
    private String f388835d;

    /* renamed from: e, reason: collision with root package name */
    private String f388836e;

    /* renamed from: f, reason: collision with root package name */
    private List<ez> f388837f;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f388838b = new a("internal-server-error");

        /* renamed from: c, reason: collision with root package name */
        public static final a f388839c = new a("forbidden");

        /* renamed from: d, reason: collision with root package name */
        public static final a f388840d = new a("bad-request");

        /* renamed from: e, reason: collision with root package name */
        public static final a f388841e = new a("conflict");

        /* renamed from: f, reason: collision with root package name */
        public static final a f388842f = new a("feature-not-implemented");

        /* renamed from: g, reason: collision with root package name */
        public static final a f388843g = new a("gone");

        /* renamed from: h, reason: collision with root package name */
        public static final a f388844h = new a("item-not-found");

        /* renamed from: i, reason: collision with root package name */
        public static final a f388845i = new a("jid-malformed");

        /* renamed from: j, reason: collision with root package name */
        public static final a f388846j = new a("not-acceptable");

        /* renamed from: k, reason: collision with root package name */
        public static final a f388847k = new a("not-allowed");

        /* renamed from: l, reason: collision with root package name */
        public static final a f388848l = new a("not-authorized");

        /* renamed from: m, reason: collision with root package name */
        public static final a f388849m = new a("payment-required");

        /* renamed from: n, reason: collision with root package name */
        public static final a f388850n = new a("recipient-unavailable");

        /* renamed from: o, reason: collision with root package name */
        public static final a f388851o = new a("redirect");

        /* renamed from: p, reason: collision with root package name */
        public static final a f388852p = new a("registration-required");

        /* renamed from: q, reason: collision with root package name */
        public static final a f388853q = new a("remote-server-error");

        /* renamed from: r, reason: collision with root package name */
        public static final a f388854r = new a("remote-server-not-found");

        /* renamed from: s, reason: collision with root package name */
        public static final a f388855s = new a("remote-server-timeout");

        /* renamed from: t, reason: collision with root package name */
        public static final a f388856t = new a("resource-constraint");

        /* renamed from: u, reason: collision with root package name */
        public static final a f388857u = new a("service-unavailable");

        /* renamed from: v, reason: collision with root package name */
        public static final a f388858v = new a("subscription-required");

        /* renamed from: w, reason: collision with root package name */
        public static final a f388859w = new a("undefined-condition");

        /* renamed from: x, reason: collision with root package name */
        public static final a f388860x = new a("unexpected-request");

        /* renamed from: y, reason: collision with root package name */
        public static final a f388861y = new a("request-timeout");

        /* renamed from: a, reason: collision with root package name */
        private String f388862a;

        public a(String str) {
            this.f388862a = str;
        }

        public String toString() {
            return this.f388862a;
        }
    }

    public ff(a aVar) {
        this.f388837f = null;
        d(aVar);
        this.f388836e = null;
    }

    private void d(a aVar) {
        this.f388834c = aVar.f388862a;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f388833b;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f388832a);
        String str2 = this.f388835d;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f388834c;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f388836e;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<ez> list = this.f388837f;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            Iterator<ez> it = this.f388837f.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                Bundle a16 = it.next().a();
                if (a16 != null) {
                    bundleArr[i3] = a16;
                    i3++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public String b() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("<error code=\"");
        sb5.append(this.f388832a);
        sb5.append("\"");
        if (this.f388833b != null) {
            sb5.append(" type=\"");
            sb5.append(this.f388833b);
            sb5.append("\"");
        }
        if (this.f388835d != null) {
            sb5.append(" reason=\"");
            sb5.append(this.f388835d);
            sb5.append("\"");
        }
        sb5.append(">");
        if (this.f388834c != null) {
            sb5.append("<");
            sb5.append(this.f388834c);
            sb5.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f388836e != null) {
            sb5.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb5.append(this.f388836e);
            sb5.append("</text>");
        }
        Iterator<ez> it = c().iterator();
        while (it.hasNext()) {
            sb5.append(it.next().d());
        }
        sb5.append("</error>");
        return sb5.toString();
    }

    public synchronized List<ez> c() {
        List<ez> list = this.f388837f;
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        String str = this.f388834c;
        if (str != null) {
            sb5.append(str);
        }
        sb5.append("(");
        sb5.append(this.f388832a);
        sb5.append(")");
        if (this.f388836e != null) {
            sb5.append(" ");
            sb5.append(this.f388836e);
        }
        return sb5.toString();
    }

    public ff(int i3, String str, String str2, String str3, String str4, List<ez> list) {
        this.f388832a = i3;
        this.f388833b = str;
        this.f388835d = str2;
        this.f388834c = str3;
        this.f388836e = str4;
        this.f388837f = list;
    }

    public ff(Bundle bundle) {
        this.f388837f = null;
        this.f388832a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f388833b = bundle.getString("ext_err_type");
        }
        this.f388834c = bundle.getString("ext_err_cond");
        this.f388835d = bundle.getString("ext_err_reason");
        this.f388836e = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f388837f = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                ez c16 = ez.c((Bundle) parcelable);
                if (c16 != null) {
                    this.f388837f.add(c16);
                }
            }
        }
    }
}
