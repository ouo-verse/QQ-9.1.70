package com.tencent.mobileqq.activity.aio.doodle;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
class t {

    /* renamed from: a, reason: collision with root package name */
    List<q> f178601a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    int f178602b = 2;

    /* renamed from: c, reason: collision with root package name */
    boolean f178603c = false;

    public void a() {
        if (this.f178601a.size() == 0) {
            return;
        }
        q qVar = this.f178601a.get(r0.size() - 1);
        qVar.f178593a.b(qVar.f178594b);
        qVar.f178595c.b(qVar.f178596d);
        qVar.f178594b.b(qVar.f178596d);
        this.f178601a.add(qVar);
    }

    public void b(float f16, float f17, float f18, long j3) {
        q qVar = new q();
        qVar.b(f16, f17, f18, j3);
        this.f178601a.add(qVar);
    }

    public boolean c(float f16, float f17, float f18, long j3) {
        q qVar = new q();
        if (this.f178601a.size() == 0) {
            b(f16, f17, f18, j3);
            return false;
        }
        List<q> list = this.f178601a;
        q qVar2 = list.get(list.size() - 1);
        qVar.f178593a.b(qVar2.f178594b);
        qVar.f178595c.b(qVar2.f178596d);
        p pVar = qVar.f178594b;
        p pVar2 = qVar.f178595c;
        pVar.a((pVar2.f178589a + f16) / 2.0f, (pVar2.f178590b + f17) / 2.0f, (pVar2.f178591c + f18) / 2.0f, (pVar2.f178592d + j3) / 2);
        qVar.f178596d.a(f16, f17, f18, j3);
        this.f178601a.add(qVar);
        if (this.f178603c) {
            this.f178603c = false;
            this.f178601a.remove(0);
        }
        if (this.f178601a.size() <= this.f178602b) {
            return false;
        }
        return true;
    }

    public void d(int i3) {
        this.f178602b = i3;
    }

    public List<q> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f178601a);
        this.f178601a.clear();
        q qVar = new q();
        qVar.e((q) arrayList.get(arrayList.size() - 1));
        this.f178601a.add(qVar);
        this.f178603c = true;
        return arrayList;
    }
}
