package com.qq.e.comm.plugin.e.a;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public a f39349a;

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        a aVar2 = this.f39349a;
        if (aVar2 == null) {
            this.f39349a = aVar;
            return;
        }
        while (aVar2.a() != null) {
            aVar2 = aVar2.a();
        }
        aVar2.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object b(int i3, boolean z16) {
        a aVar = this.f39349a;
        if (aVar == null) {
            return Boolean.FALSE;
        }
        return aVar.b(i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i3, boolean z16) {
        a aVar = this.f39349a;
        if (aVar == null) {
            return true;
        }
        return aVar.a(i3, z16);
    }
}
