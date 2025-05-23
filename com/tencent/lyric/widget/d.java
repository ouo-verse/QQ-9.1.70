package com.tencent.lyric.widget;

import android.content.res.TypedArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d {
    static IPatchRedirector $redirector_;
    protected int A;
    protected int B;
    protected int C;
    protected int D;
    protected int E;
    protected boolean F;
    protected boolean G;
    protected boolean H;
    protected int I;

    /* renamed from: a, reason: collision with root package name */
    public int f147265a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f147266b;

    /* renamed from: c, reason: collision with root package name */
    public int f147267c;

    /* renamed from: d, reason: collision with root package name */
    public int f147268d;

    /* renamed from: e, reason: collision with root package name */
    public int f147269e;

    /* renamed from: f, reason: collision with root package name */
    public int f147270f;

    /* renamed from: g, reason: collision with root package name */
    public int f147271g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f147272h;

    /* renamed from: i, reason: collision with root package name */
    public int f147273i;

    /* renamed from: j, reason: collision with root package name */
    public int f147274j;

    /* renamed from: k, reason: collision with root package name */
    public int f147275k;

    /* renamed from: l, reason: collision with root package name */
    public int f147276l;

    /* renamed from: m, reason: collision with root package name */
    public int f147277m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f147278n;

    /* renamed from: o, reason: collision with root package name */
    public int f147279o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f147280p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f147281q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f147282r;

    /* renamed from: s, reason: collision with root package name */
    public int f147283s;

    /* renamed from: t, reason: collision with root package name */
    public int f147284t;

    /* renamed from: u, reason: collision with root package name */
    public int f147285u;

    /* renamed from: v, reason: collision with root package name */
    public int f147286v;

    /* renamed from: w, reason: collision with root package name */
    protected int f147287w;

    /* renamed from: x, reason: collision with root package name */
    protected int f147288x;

    /* renamed from: y, reason: collision with root package name */
    protected int f147289y;

    /* renamed from: z, reason: collision with root package name */
    protected int f147290z;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f147290z = 1;
        }
    }

    public void a(TypedArray typedArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) typedArray);
            return;
        }
        this.f147265a = typedArray.getDimensionPixelSize(b51.a.I, 16);
        this.f147266b = typedArray.getBoolean(b51.a.H, false);
        this.f147267c = typedArray.getInt(b51.a.G, 255);
        this.f147268d = typedArray.getInt(b51.a.J, 255);
        this.f147269e = typedArray.getDimensionPixelSize(b51.a.f27939q, 20);
        this.f147275k = typedArray.getDimensionPixelSize(b51.a.f27940r, 20);
        this.f147276l = typedArray.getDimensionPixelSize(b51.a.f27927e, 15);
        this.f147270f = typedArray.getDimensionPixelSize(b51.a.f27933k, 20);
        this.f147271g = typedArray.getInt(b51.a.f27929g, 255);
        this.f147273i = typedArray.getInt(b51.a.f27934l, 255);
        this.f147272h = typedArray.getBoolean(b51.a.f27935m, false);
        this.f147274j = typedArray.getDimensionPixelSize(b51.a.f27931i, 20);
        this.f147277m = typedArray.getDimensionPixelSize(b51.a.A, 40);
        this.f147278n = typedArray.getBoolean(b51.a.f27941s, false);
        this.f147279o = typedArray.getDimensionPixelSize(b51.a.f27937o, 10);
        this.f147280p = typedArray.getBoolean(b51.a.f27936n, false);
        this.f147282r = typedArray.getBoolean(b51.a.f27930h, true);
        this.f147281q = typedArray.getBoolean(b51.a.f27925c, false);
        this.f147283s = typedArray.getInt(b51.a.f27943u, 255);
        this.f147284t = typedArray.getDimensionPixelSize(b51.a.f27944v, 20);
        this.f147285u = typedArray.getInt(b51.a.f27942t, 255);
        this.f147286v = typedArray.getDimensionPixelSize(b51.a.K, 0);
        this.f147288x = typedArray.getDimensionPixelSize(b51.a.f27932j, 0);
        this.f147287w = typedArray.getDimensionPixelSize(b51.a.f27947y, 0);
        this.f147289y = typedArray.getInt(b51.a.f27948z, 0);
        this.f147290z = typedArray.getInt(b51.a.f27946x, 1);
        this.A = typedArray.getInt(b51.a.f27926d, com.tencent.lyric.util.d.f147092b);
        this.B = typedArray.getDimensionPixelSize(b51.a.D, 3);
        this.C = typedArray.getDimensionPixelSize(b51.a.E, 1);
        this.D = typedArray.getDimensionPixelSize(b51.a.F, 1);
        this.E = typedArray.getInt(b51.a.C, 128);
        this.F = typedArray.getBoolean(b51.a.f27938p, false);
        this.G = typedArray.getBoolean(b51.a.f27924b, false);
        this.H = typedArray.getBoolean(b51.a.f27945w, false);
        this.I = typedArray.getDimensionPixelSize(b51.a.f27928f, 0);
    }
}
