package com.tencent.biz.qqcircle.immersive.personal.data;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private a f88533a;

    public abstract String a();

    public abstract String b();

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(a aVar) {
        this.f88533a = aVar;
    }

    public void d(a aVar, long j3) {
        if (e(this.f88533a, aVar)) {
            QLog.i(a(), 1, "[update] -> update newVersion = " + j3);
            this.f88533a.f(b(), j3);
        }
    }

    public abstract boolean e(a aVar, a aVar2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        this.f88533a.j(b());
    }
}
