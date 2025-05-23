package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    p f178593a = new p();

    /* renamed from: b, reason: collision with root package name */
    p f178594b = new p();

    /* renamed from: c, reason: collision with root package name */
    p f178595c = new p();

    /* renamed from: d, reason: collision with root package name */
    p f178596d = new p();

    public void a() {
        this.f178593a.b(this.f178594b);
        this.f178595c.b(this.f178596d);
        this.f178594b.b(this.f178596d);
    }

    public void b(float f16, float f17, float f18, long j3) {
        this.f178593a.a(f16, f17, f18, j3);
        this.f178594b.a(f16, f17, f18, j3);
        this.f178595c.a(f16, f17, f18, j3);
        this.f178596d.a(f16, f17, f18, j3);
    }

    public void c(q qVar) {
        p pVar = qVar.f178596d;
        if (pVar == this.f178595c) {
            this.f178593a = qVar.f178593a;
            p pVar2 = qVar.f178595c;
            this.f178595c = pVar2;
            p pVar3 = this.f178594b;
            p pVar4 = this.f178596d;
            pVar3.a((pVar4.f178589a + pVar2.f178589a) / 2.0f, (pVar4.f178590b + pVar2.f178590b) / 2.0f, (pVar4.f178591c + pVar2.f178591c) / 2.0f, (pVar4.f178592d + pVar2.f178592d) / 2);
            return;
        }
        p pVar5 = this.f178596d;
        if (pVar5 == qVar.f178595c) {
            pVar5.b(pVar);
            p pVar6 = this.f178594b;
            p pVar7 = this.f178596d;
            float f16 = pVar7.f178589a;
            p pVar8 = this.f178595c;
            pVar6.a((f16 + pVar8.f178589a) / 2.0f, (pVar7.f178590b + pVar8.f178590b) / 2.0f, (pVar7.f178591c + pVar8.f178591c) / 2.0f, (pVar7.f178592d + pVar8.f178592d) / 2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("TransPathJob", 2, "TransPathJob merge point error");
        }
    }

    public void d(float f16, float f17, float f18, long j3, boolean z16) {
        if (z16) {
            this.f178593a.b(this.f178594b);
            this.f178595c.b(this.f178596d);
            p pVar = this.f178594b;
            p pVar2 = this.f178595c;
            pVar.a((pVar2.f178589a + f16) / 2.0f, (pVar2.f178590b + f17) / 2.0f, (pVar2.f178591c + f18) / 2.0f, (pVar2.f178592d + j3) / 2);
            this.f178596d.a(f16, f17, f18, j3);
            return;
        }
        p pVar3 = this.f178594b;
        p pVar4 = this.f178595c;
        pVar3.a((pVar4.f178589a + f16) / 2.0f, (pVar4.f178590b + f17) / 2.0f, (pVar4.f178591c + f18) / 2.0f, (pVar4.f178592d + j3) / 2);
        this.f178596d.a(f16, f17, f18, j3);
    }

    public void e(q qVar) {
        this.f178593a.b(qVar.f178593a);
        this.f178594b.b(qVar.f178594b);
        this.f178595c.b(qVar.f178595c);
        this.f178596d.b(qVar.f178596d);
    }
}
