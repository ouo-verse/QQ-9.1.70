package com.tencent.mobileqq.bubble;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f200618a;

    /* renamed from: b, reason: collision with root package name */
    public String f200619b;

    /* renamed from: c, reason: collision with root package name */
    public String f200620c;

    /* renamed from: d, reason: collision with root package name */
    public int f200621d;

    /* renamed from: e, reason: collision with root package name */
    public int f200622e;

    /* renamed from: f, reason: collision with root package name */
    public int f200623f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f200624g;

    /* renamed from: h, reason: collision with root package name */
    public int f200625h;

    /* renamed from: i, reason: collision with root package name */
    public String[] f200626i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f200627j;

    /* renamed from: k, reason: collision with root package name */
    public String f200628k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f200629l;

    /* renamed from: m, reason: collision with root package name */
    public int f200630m;

    /* renamed from: n, reason: collision with root package name */
    public int f200631n;

    /* renamed from: o, reason: collision with root package name */
    public int f200632o;

    /* renamed from: p, reason: collision with root package name */
    public int f200633p;

    /* renamed from: q, reason: collision with root package name */
    public int f200634q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f200635r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f200636s;

    /* renamed from: t, reason: collision with root package name */
    public int f200637t;

    /* renamed from: u, reason: collision with root package name */
    public SparseArray<C7439a> f200638u;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList<d> f200639v;

    /* renamed from: w, reason: collision with root package name */
    public int f200640w;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.bubble.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C7439a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f200641a;

        /* renamed from: b, reason: collision with root package name */
        public int f200642b;

        /* renamed from: c, reason: collision with root package name */
        public String f200643c;

        public C7439a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f200641a = 0;
                this.f200642b = 0;
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f200618a = "";
        this.f200619b = "";
        this.f200620c = "";
        this.f200630m = -1;
        this.f200635r = true;
        this.f200636s = true;
        this.f200637t = 0;
        this.f200638u = null;
        this.f200639v = new ArrayList<>();
    }
}
