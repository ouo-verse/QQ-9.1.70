package com.tencent.luggage.wxa.ih;

import com.tencent.luggage.wxa.ih.d;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends c {

    /* renamed from: g, reason: collision with root package name */
    public b f130407g = b.IDLE;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f130408a;

        static {
            int[] iArr = new int[b.values().length];
            f130408a = iArr;
            try {
                iArr[b.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f130408a[b.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f130408a[b.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f130408a[b.STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f130408a[b.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        IDLE,
        START,
        PAUSE,
        STOP,
        ERROR
    }

    public final synchronized void a(b bVar) {
        this.f130407g = bVar;
    }

    @Override // com.tencent.luggage.wxa.ih.a
    public void b() {
        super.b();
        a(b.START);
    }

    public final boolean e() {
        if (a.f130408a[this.f130407g.ordinal()] == 1) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        int i3 = a.f130408a[this.f130407g.ordinal()];
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.ih.c, com.tencent.luggage.wxa.ih.d
    public synchronized com.tencent.luggage.wxa.hh.g j() {
        if (!f()) {
            return new com.tencent.luggage.wxa.hh.g("can not stop", new Object[0]);
        }
        return super.j();
    }

    @Override // com.tencent.luggage.wxa.ih.c
    public synchronized void release() {
        super.release();
        a(b.IDLE);
    }

    @Override // com.tencent.luggage.wxa.ih.c, com.tencent.luggage.wxa.ih.d
    public synchronized com.tencent.luggage.wxa.hh.g a(d.C6305d c6305d) {
        if (!e()) {
            return new com.tencent.luggage.wxa.hh.g("can not start", new Object[0]);
        }
        return super.a(c6305d);
    }

    @Override // com.tencent.luggage.wxa.ih.a
    public void a(String str, int i3, int i16) {
        super.a(str, i3, i16);
        a(b.STOP);
    }
}
