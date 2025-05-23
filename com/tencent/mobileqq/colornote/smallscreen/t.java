package com.tencent.mobileqq.colornote.smallscreen;

/* compiled from: P */
/* loaded from: classes5.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private int f201705a = 1;

    /* renamed from: b, reason: collision with root package name */
    private a f201706b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(int i3);

        void b();

        void c();
    }

    public t(a aVar) {
        this.f201706b = aVar;
    }

    public int a() {
        return this.f201705a;
    }

    public void b() {
        a aVar;
        int i3 = this.f201705a;
        if (i3 == 1) {
            a aVar2 = this.f201706b;
            if (aVar2 != null) {
                aVar2.a(1);
                this.f201705a = 2;
                return;
            }
            return;
        }
        if (i3 == 2 && (aVar = this.f201706b) != null) {
            aVar.a(2);
        }
    }

    public void c() {
        a aVar;
        if (this.f201705a == 3 && (aVar = this.f201706b) != null) {
            aVar.b();
            this.f201705a = 1;
        }
    }

    public void d() {
        a aVar;
        if (this.f201705a == 2 && (aVar = this.f201706b) != null) {
            aVar.c();
            this.f201705a = 3;
        }
    }
}
