package com.tencent.luggage.wxa.n;

import android.media.AudioAttributes;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f134901e = new C6489b().a();

    /* renamed from: a, reason: collision with root package name */
    public final int f134902a;

    /* renamed from: b, reason: collision with root package name */
    public final int f134903b;

    /* renamed from: c, reason: collision with root package name */
    public final int f134904c;

    /* renamed from: d, reason: collision with root package name */
    public AudioAttributes f134905d;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.n.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6489b {

        /* renamed from: a, reason: collision with root package name */
        public int f134906a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f134907b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f134908c = 1;

        public b a() {
            return new b(this.f134906a, this.f134907b, this.f134908c);
        }
    }

    public AudioAttributes a() {
        if (this.f134905d == null) {
            this.f134905d = new AudioAttributes.Builder().setContentType(this.f134902a).setFlags(this.f134903b).setUsage(this.f134904c).build();
        }
        return this.f134905d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f134902a == bVar.f134902a && this.f134903b == bVar.f134903b && this.f134904c == bVar.f134904c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f134902a + 527) * 31) + this.f134903b) * 31) + this.f134904c;
    }

    public b(int i3, int i16, int i17) {
        this.f134902a = i3;
        this.f134903b = i16;
        this.f134904c = i17;
    }
}
