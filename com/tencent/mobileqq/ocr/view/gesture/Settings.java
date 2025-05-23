package com.tencent.mobileqq.ocr.view.gesture;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import jj2.b;

/* compiled from: P */
/* loaded from: classes16.dex */
public class Settings {
    static IPatchRedirector $redirector_;
    private long A;

    /* renamed from: a, reason: collision with root package name */
    private int f254979a;

    /* renamed from: b, reason: collision with root package name */
    private int f254980b;

    /* renamed from: c, reason: collision with root package name */
    private int f254981c;

    /* renamed from: d, reason: collision with root package name */
    private int f254982d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f254983e;

    /* renamed from: f, reason: collision with root package name */
    private int f254984f;

    /* renamed from: g, reason: collision with root package name */
    private int f254985g;

    /* renamed from: h, reason: collision with root package name */
    private float f254986h;

    /* renamed from: i, reason: collision with root package name */
    private float f254987i;

    /* renamed from: j, reason: collision with root package name */
    private float f254988j;

    /* renamed from: k, reason: collision with root package name */
    private float f254989k;

    /* renamed from: l, reason: collision with root package name */
    private float f254990l;

    /* renamed from: m, reason: collision with root package name */
    private float f254991m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f254992n;

    /* renamed from: o, reason: collision with root package name */
    private int f254993o;

    /* renamed from: p, reason: collision with root package name */
    private int f254994p;

    /* renamed from: q, reason: collision with root package name */
    private int f254995q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f254996r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f254997s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f254998t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f254999u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f255000v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f255001w;

    /* renamed from: x, reason: collision with root package name */
    private int f255002x;

    /* renamed from: y, reason: collision with root package name */
    private int f255003y;

    /* renamed from: z, reason: collision with root package name */
    private int f255004z;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes16.dex */
    public @interface Bounds {
        public static final int INSIDE = 1;
        public static final int NONE = 4;
        public static final int NORMAL = 0;
        public static final int OUTSIDE = 2;
        public static final int PIVOT = 3;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes16.dex */
    public @interface ExitType {
        public static final int ALL = 0;
        public static final int NONE = 3;
        public static final int SCROLL = 1;
        public static final int ZOOM = 2;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes16.dex */
    public @interface Fit {
        public static final int HORIZONTAL = 0;
        public static final int INSIDE = 2;
        public static final int NONE = 4;
        public static final int OUTSIDE = 3;
        public static final int VERTICAL = 1;
    }

    public Settings() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f254986h = 0.0f;
        this.f254987i = 2.0f;
        this.f254988j = -1.0f;
        this.f254989k = 2.0f;
        this.f254992n = false;
        this.f254993o = 17;
        this.f254994p = 2;
        this.f254995q = 0;
        this.f254996r = true;
        this.f254997s = true;
        this.f254998t = true;
        this.f254999u = false;
        this.f255000v = false;
        this.f255001w = true;
        this.f255002x = 0;
        this.A = 300L;
    }

    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        if (z() && this.f254996r) {
            return true;
        }
        return false;
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this)).booleanValue();
        }
        if (this.f255004z <= 0) {
            return true;
        }
        return false;
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        return this.f255000v;
    }

    public boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this)).booleanValue();
        }
        if (z() && this.f254999u) {
            return true;
        }
        return false;
    }

    public boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this)).booleanValue();
        }
        if (z() && this.f254998t) {
            return true;
        }
        return false;
    }

    public Settings F(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Settings) iPatchRedirector.redirect((short) 17, (Object) this, z16);
        }
        this.f254997s = z16;
        return this;
    }

    public Settings G(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Settings) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        this.f254984f = i3;
        this.f254985g = i16;
        return this;
    }

    public Settings H(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Settings) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        this.f254979a = i3;
        this.f254980b = i16;
        return this;
    }

    public Settings a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Settings) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        this.f255004z++;
        return this;
    }

    public Settings b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Settings) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        this.f255003y++;
        return this;
    }

    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Long) iPatchRedirector.redirect((short) 56, (Object) this)).longValue();
        }
        return this.A;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        return this.f254995q;
    }

    public float e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Float) iPatchRedirector.redirect((short) 38, (Object) this)).floatValue();
        }
        return this.f254988j;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, (Object) this)).intValue();
        }
        return this.f254994p;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this)).intValue();
        }
        return this.f254993o;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return this.f254985g;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        return this.f254984f;
    }

    public float j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Float) iPatchRedirector.redirect((short) 37, (Object) this)).floatValue();
        }
        return this.f254987i;
    }

    public float k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Float) iPatchRedirector.redirect((short) 36, (Object) this)).floatValue();
        }
        return this.f254986h;
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        if (this.f254983e) {
            return this.f254982d;
        }
        return this.f254980b;
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        if (this.f254983e) {
            return this.f254981c;
        }
        return this.f254979a;
    }

    public float n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Float) iPatchRedirector.redirect((short) 40, (Object) this)).floatValue();
        }
        return this.f254990l;
    }

    public float o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Float) iPatchRedirector.redirect((short) 41, (Object) this)).floatValue();
        }
        return this.f254991m;
    }

    public float p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Float) iPatchRedirector.redirect((short) 39, (Object) this)).floatValue();
        }
        return this.f254989k;
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return this.f254980b;
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return this.f254979a;
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Boolean) iPatchRedirector.redirect((short) 58, (Object) this)).booleanValue();
        }
        if (this.f254984f != 0 && this.f254985g != 0) {
            return true;
        }
        return false;
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this)).booleanValue();
        }
        if (this.f254979a != 0 && this.f254980b != 0) {
            return true;
        }
        return false;
    }

    public void u(Context context, AttributeSet attributeSet) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.K2);
        this.f254981c = obtainStyledAttributes.getDimensionPixelSize(b.X2, this.f254981c);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(b.W2, this.f254982d);
        this.f254982d = dimensionPixelSize;
        if (this.f254981c > 0 && dimensionPixelSize > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f254983e = z16;
        this.f254986h = obtainStyledAttributes.getFloat(b.V2, this.f254986h);
        this.f254987i = obtainStyledAttributes.getFloat(b.U2, this.f254987i);
        this.f254988j = obtainStyledAttributes.getFloat(b.P2, this.f254988j);
        this.f254989k = obtainStyledAttributes.getFloat(b.f409986a3, this.f254989k);
        this.f254990l = obtainStyledAttributes.getDimension(b.Y2, this.f254990l);
        this.f254991m = obtainStyledAttributes.getDimension(b.Z2, this.f254991m);
        this.f254992n = obtainStyledAttributes.getBoolean(b.R2, this.f254992n);
        this.f254993o = obtainStyledAttributes.getInt(b.T2, this.f254993o);
        this.f254996r = obtainStyledAttributes.getBoolean(b.f409998b3, this.f254996r);
        this.f254997s = obtainStyledAttributes.getBoolean(b.S2, this.f254997s);
        this.f254998t = obtainStyledAttributes.getBoolean(b.f410034e3, this.f254998t);
        this.f254999u = obtainStyledAttributes.getBoolean(b.f410022d3, this.f254999u);
        this.f255000v = obtainStyledAttributes.getBoolean(b.f410010c3, this.f255000v);
        this.f255001w = obtainStyledAttributes.getBoolean(b.O2, this.f255001w);
        if (obtainStyledAttributes.getBoolean(b.Q2, true)) {
            i3 = this.f255002x;
        } else {
            i3 = 3;
        }
        this.f255002x = i3;
        this.A = obtainStyledAttributes.getInt(b.L2, (int) this.A);
        if (obtainStyledAttributes.getBoolean(b.N2, false)) {
            b();
        }
        if (obtainStyledAttributes.getBoolean(b.M2, false)) {
            a();
        }
        obtainStyledAttributes.recycle();
    }

    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this)).booleanValue();
        }
        if (z() && this.f255001w) {
            return true;
        }
        return false;
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        if (z() && (this.f254996r || this.f254998t || this.f254999u || this.f255001w)) {
            return true;
        }
        return false;
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        return this.f254992n;
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this)).booleanValue();
        }
        if (z() && this.f254997s) {
            return true;
        }
        return false;
    }

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this)).booleanValue();
        }
        if (this.f255003y <= 0) {
            return true;
        }
        return false;
    }
}
