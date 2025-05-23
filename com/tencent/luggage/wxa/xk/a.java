package com.tencent.luggage.wxa.xk;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface a extends com.tencent.luggage.wxa.h1.b {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xk.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C6919a {

        /* renamed from: a, reason: collision with root package name */
        public double f145141a;

        /* renamed from: b, reason: collision with root package name */
        public double f145142b;

        /* renamed from: c, reason: collision with root package name */
        public String f145143c;

        /* renamed from: d, reason: collision with root package name */
        public double f145144d;

        /* renamed from: e, reason: collision with root package name */
        public double f145145e;

        /* renamed from: f, reason: collision with root package name */
        public double f145146f;

        /* renamed from: g, reason: collision with root package name */
        public String f145147g;

        /* renamed from: h, reason: collision with root package name */
        public String f145148h;

        /* renamed from: i, reason: collision with root package name */
        public Object f145149i;

        /* renamed from: j, reason: collision with root package name */
        public int f145150j;

        /* renamed from: k, reason: collision with root package name */
        public float f145151k;

        /* renamed from: l, reason: collision with root package name */
        public double f145152l = 0.0d;

        /* renamed from: m, reason: collision with root package name */
        public String f145153m;

        public String toString() {
            return "Location{latitude=" + this.f145141a + ", longitude=" + this.f145142b + ", provider='" + this.f145143c + "', speed=" + this.f145144d + ", accuracy=" + this.f145145e + ", altitude=" + this.f145146f + ", buildingId='" + this.f145147g + "', floorName='" + this.f145148h + "', extra=" + this.f145149i + ", indoorLocationType=" + this.f145150j + ", direction=" + this.f145151k + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(int i3, String str, C6919a c6919a);
    }

    void getLocation(String str, b bVar, Bundle bundle);

    C6919a getLocationCache(String str, int i3);

    boolean registerLocation(String str, b bVar, Bundle bundle);

    boolean unregisterLocation(String str, b bVar, Bundle bundle);
}
