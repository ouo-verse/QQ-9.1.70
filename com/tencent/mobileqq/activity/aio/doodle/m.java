package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.mobileqq.activity.aio.doodle.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    private int f178561b;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<a> f178560a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private int f178562c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f178563d = -1;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a implements k {

        /* renamed from: e, reason: collision with root package name */
        public static final k.a<a> f178564e = new C7124a();

        /* renamed from: a, reason: collision with root package name */
        private float f178565a;

        /* renamed from: b, reason: collision with root package name */
        private float f178566b;

        /* renamed from: c, reason: collision with root package name */
        private float f178567c;

        /* renamed from: d, reason: collision with root package name */
        private long f178568d;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.aio.doodle.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class C7124a implements k.a<a> {
            C7124a() {
            }

            @Override // com.tencent.mobileqq.activity.aio.doodle.k.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public a a(j jVar) {
                return new a(jVar);
            }
        }

        public a() {
        }

        @Override // com.tencent.mobileqq.activity.aio.doodle.k
        public void a(j jVar, int i3) {
            jVar.l(1);
            jVar.k(this.f178565a);
            jVar.k(this.f178566b);
            jVar.k(this.f178567c);
            jVar.n(this.f178568d);
        }

        public long b() {
            return this.f178568d;
        }

        public float c() {
            return this.f178567c;
        }

        public float d() {
            return this.f178565a;
        }

        public float e() {
            return this.f178566b;
        }

        public void f(float f16) {
            this.f178565a *= f16;
            this.f178566b *= f16;
            this.f178567c *= f16;
        }

        public void g(float f16, float f17, float f18, long j3) {
            this.f178567c = f18;
            this.f178565a = f16;
            this.f178566b = f17;
            this.f178568d = j3;
        }

        public void h(long j3) {
            this.f178568d = j3;
        }

        public void i(float f16) {
            this.f178567c = f16;
        }

        public void j(float f16) {
            this.f178565a = f16;
        }

        public void k(float f16) {
            this.f178566b = f16;
        }

        public a(a aVar) {
            if (aVar != null) {
                g(aVar.d(), aVar.e(), aVar.c(), 0L);
            }
        }

        public a(float f16, float f17, float f18, long j3) {
            g(f16, f17, f18, j3);
        }

        public a(j jVar) {
            jVar.d();
            this.f178565a = jVar.c();
            this.f178566b = jVar.c();
            this.f178567c = jVar.c();
            this.f178568d = jVar.f();
        }
    }

    public void a(float f16, float f17, float f18, long j3) {
        a aVar = new a();
        aVar.j(f16);
        aVar.k(f17);
        aVar.i(f18);
        aVar.h(j3);
        this.f178560a.add(aVar);
    }

    public void b(List<a> list) {
        if (list != null) {
            this.f178560a.addAll(list);
        }
    }

    public void c() {
        this.f178560a.clear();
    }

    public int d() {
        return this.f178561b;
    }

    public a e() {
        if (this.f178560a.size() > 0) {
            return this.f178560a.get(0);
        }
        return null;
    }

    public a f() {
        if (this.f178560a.size() > 0) {
            return this.f178560a.get(r0.size() - 1);
        }
        return null;
    }

    public int g() {
        return this.f178560a.size();
    }

    public ArrayList<a> h() {
        return this.f178560a;
    }

    public int i() {
        return this.f178562c;
    }

    public long j() {
        if (this.f178560a.size() > 0) {
            return this.f178560a.get(r0.size() - 1).b();
        }
        return 0L;
    }

    public void k(int i3) {
        this.f178561b = i3;
    }

    public void l(int i3) {
        this.f178562c = i3;
    }
}
