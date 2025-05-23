package oicq.wlogin_sdk.report;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<C10917a> f422841a = new ArrayList<>(10);

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<C10917a> f422842b = new ArrayList<>(10);

    /* compiled from: P */
    /* renamed from: oicq.wlogin_sdk.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static class C10917a {

        /* renamed from: a, reason: collision with root package name */
        public int f422843a;

        /* renamed from: b, reason: collision with root package name */
        public long f422844b;

        /* renamed from: c, reason: collision with root package name */
        public long f422845c;

        /* renamed from: d, reason: collision with root package name */
        public long f422846d;

        /* renamed from: e, reason: collision with root package name */
        public long f422847e;

        /* renamed from: f, reason: collision with root package name */
        public String f422848f;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f422849a = new a();
    }

    public void a(int i3, long j3, long j16, long j17) {
        C10917a c10917a = new C10917a();
        c10917a.f422844b = System.currentTimeMillis();
        c10917a.f422843a = i3;
        c10917a.f422845c = j3;
        c10917a.f422846d = j16;
        c10917a.f422847e = j17;
        this.f422841a.add(c10917a);
    }
}
