package com.xiaomi.push;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fq extends fc {

    /* renamed from: p, reason: collision with root package name */
    private b f388910p;

    /* renamed from: q, reason: collision with root package name */
    private String f388911q;

    /* renamed from: r, reason: collision with root package name */
    private int f388912r;

    /* renamed from: s, reason: collision with root package name */
    private a f388913s;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public fq(b bVar) {
        this.f388910p = b.available;
        this.f388911q = null;
        this.f388912r = Integer.MIN_VALUE;
        this.f388913s = null;
        A(bVar);
    }

    public void A(b bVar) {
        if (bVar != null) {
            this.f388910p = bVar;
            return;
        }
        throw new NullPointerException("Type cannot be null");
    }

    public void B(String str) {
        this.f388911q = str;
    }

    @Override // com.xiaomi.push.fc
    public Bundle a() {
        Bundle a16 = super.a();
        b bVar = this.f388910p;
        if (bVar != null) {
            a16.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f388911q;
        if (str != null) {
            a16.putString("ext_pres_status", str);
        }
        int i3 = this.f388912r;
        if (i3 != Integer.MIN_VALUE) {
            a16.putInt("ext_pres_prio", i3);
        }
        a aVar = this.f388913s;
        if (aVar != null && aVar != a.available) {
            a16.putString("ext_pres_mode", aVar.toString());
        }
        return a16;
    }

    @Override // com.xiaomi.push.fc
    public String f() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("<presence");
        if (w() != null) {
            sb5.append(" xmlns=\"");
            sb5.append(w());
            sb5.append("\"");
        }
        if (l() != null) {
            sb5.append(" id=\"");
            sb5.append(l());
            sb5.append("\"");
        }
        if (o() != null) {
            sb5.append(" to=\"");
            sb5.append(fm.b(o()));
            sb5.append("\"");
        }
        if (q() != null) {
            sb5.append(" from=\"");
            sb5.append(fm.b(q()));
            sb5.append("\"");
        }
        if (m() != null) {
            sb5.append(" chid=\"");
            sb5.append(fm.b(m()));
            sb5.append("\"");
        }
        if (this.f388910p != null) {
            sb5.append(" type=\"");
            sb5.append(this.f388910p);
            sb5.append("\"");
        }
        sb5.append(">");
        if (this.f388911q != null) {
            sb5.append("<status>");
            sb5.append(fm.b(this.f388911q));
            sb5.append("</status>");
        }
        if (this.f388912r != Integer.MIN_VALUE) {
            sb5.append("<priority>");
            sb5.append(this.f388912r);
            sb5.append("</priority>");
        }
        a aVar = this.f388913s;
        if (aVar != null && aVar != a.available) {
            sb5.append("<show>");
            sb5.append(this.f388913s);
            sb5.append("</show>");
        }
        sb5.append(u());
        ff d16 = d();
        if (d16 != null) {
            sb5.append(d16.b());
        }
        sb5.append("</presence>");
        return sb5.toString();
    }

    public void y(int i3) {
        if (i3 >= -128 && i3 <= 128) {
            this.f388912r = i3;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i3 + " is not valid. Valid range is -128 through 128.");
    }

    public void z(a aVar) {
        this.f388913s = aVar;
    }

    public fq(Bundle bundle) {
        super(bundle);
        this.f388910p = b.available;
        this.f388911q = null;
        this.f388912r = Integer.MIN_VALUE;
        this.f388913s = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f388910p = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f388911q = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f388912r = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f388913s = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }
}
