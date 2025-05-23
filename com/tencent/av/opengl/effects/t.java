package com.tencent.av.opengl.effects;

/* compiled from: P */
/* loaded from: classes3.dex */
public class t {

    /* renamed from: d, reason: collision with root package name */
    private static final Object f74042d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static t f74043e;

    /* renamed from: f, reason: collision with root package name */
    private static int f74044f;

    /* renamed from: a, reason: collision with root package name */
    public int f74045a;

    /* renamed from: b, reason: collision with root package name */
    public int f74046b;

    /* renamed from: c, reason: collision with root package name */
    private t f74047c;

    t(int i3, int i16) {
        this.f74045a = i3;
        this.f74046b = i16;
    }

    public static t a(int i3, int i16) {
        synchronized (f74042d) {
            t tVar = f74043e;
            if (tVar != null) {
                f74043e = tVar.f74047c;
                tVar.f74047c = null;
                tVar.f74045a = i3;
                tVar.f74046b = i16;
                f74044f--;
                return tVar;
            }
            return new t(i3, i16);
        }
    }

    public void b() {
        this.f74045a = -1;
        this.f74046b = -1;
        synchronized (f74042d) {
            int i3 = f74044f;
            if (i3 < 4) {
                this.f74047c = f74043e;
                f74043e = this;
                f74044f = i3 + 1;
            }
        }
    }
}
