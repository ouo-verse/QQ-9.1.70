package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f264910a;

    /* renamed from: b, reason: collision with root package name */
    public int f264911b;

    /* renamed from: c, reason: collision with root package name */
    public long f264912c;

    /* renamed from: d, reason: collision with root package name */
    public String f264913d;

    /* renamed from: e, reason: collision with root package name */
    public int f264914e;

    /* renamed from: f, reason: collision with root package name */
    public int f264915f;

    /* renamed from: g, reason: collision with root package name */
    public int f264916g;

    /* renamed from: h, reason: collision with root package name */
    public long f264917h;

    /* renamed from: i, reason: collision with root package name */
    public long f264918i;

    /* renamed from: j, reason: collision with root package name */
    public String f264919j;

    /* renamed from: k, reason: collision with root package name */
    public long f264920k;

    /* renamed from: l, reason: collision with root package name */
    public String f264921l;

    /* renamed from: m, reason: collision with root package name */
    public String f264922m;

    /* renamed from: n, reason: collision with root package name */
    public String f264923n;

    /* renamed from: o, reason: collision with root package name */
    public int f264924o;

    /* renamed from: p, reason: collision with root package name */
    public long f264925p;

    /* renamed from: q, reason: collision with root package name */
    public int f264926q;

    /* renamed from: r, reason: collision with root package name */
    public int f264927r;

    /* renamed from: s, reason: collision with root package name */
    public int f264928s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f264929t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f264930u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f264931v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f264932w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f264933x;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f264913d = "";
        this.f264916g = 0;
        this.f264919j = "";
        this.f264921l = "";
        this.f264922m = "";
        this.f264923n = "";
        this.f264928s = 1;
        this.f264929t = false;
        this.f264930u = false;
        this.f264931v = false;
        this.f264932w = false;
        this.f264933x = false;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!this.f264932w && !this.f264933x) {
            return false;
        }
        return true;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getClass().getName());
        sb5.append('{');
        sb5.append("giftId=");
        sb5.append(this.f264910a);
        sb5.append(",giftType=");
        sb5.append(this.f264911b);
        sb5.append(",num=");
        sb5.append(this.f264915f);
        sb5.append(",priority=");
        sb5.append(this.f264916g);
        sb5.append(",materialId=");
        sb5.append(this.f264914e);
        sb5.append(",sender=");
        sb5.append(this.f264918i);
        sb5.append(",giftLevel=");
        sb5.append(this.f264924o);
        sb5.append(",hitSequence=");
        sb5.append(this.f264925p);
        sb5.append(",allHitNum=");
        sb5.append(this.f264926q);
        sb5.append(",receiver=");
        sb5.append(this.f264920k);
        sb5.append(",originalHitNum=");
        sb5.append(this.f264928s);
        sb5.append(",isGuildGiftData=");
        sb5.append(this.f264929t);
        if (!TextUtils.isEmpty(this.f264913d)) {
            sb5.append(",giftName=");
            sb5.append(this.f264913d);
        }
        if (!TextUtils.isEmpty(this.f264919j)) {
            sb5.append(",senderNick=");
            sb5.append(this.f264919j);
        }
        if (!TextUtils.isEmpty(this.f264921l)) {
            sb5.append(",recNick=");
            sb5.append(this.f264921l);
        }
        if (!TextUtils.isEmpty(this.f264922m)) {
            sb5.append(",senderHead=");
            sb5.append(this.f264922m);
        }
        if (!TextUtils.isEmpty(this.f264923n)) {
            sb5.append(",recHead=");
            sb5.append(this.f264923n);
        }
        sb5.append(",isBySelf=");
        sb5.append(this.f264932w);
        sb5.append(",isAnchor=");
        sb5.append(this.f264933x);
        sb5.append("}");
        return sb5.toString();
    }
}
