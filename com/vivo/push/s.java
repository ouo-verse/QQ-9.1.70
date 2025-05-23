package com.vivo.push;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected Context f387838a;

    /* renamed from: b, reason: collision with root package name */
    private int f387839b;

    /* renamed from: c, reason: collision with root package name */
    private v f387840c;

    public s(v vVar) {
        this.f387839b = -1;
        this.f387840c = vVar;
        int b16 = vVar.b();
        this.f387839b = b16;
        if (b16 >= 0) {
            this.f387838a = m.a().h();
            return;
        }
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }

    public final int a() {
        return this.f387839b;
    }

    protected abstract void a(v vVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f387838a;
        if (context != null && !(this.f387840c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.u.a(context, "[\u6267\u884c\u6307\u4ee4]" + this.f387840c);
        }
        a(this.f387840c);
    }

    public String toString() {
        String vVar;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getClass().getSimpleName());
        sb5.append("{");
        v vVar2 = this.f387840c;
        if (vVar2 == null) {
            vVar = "[null]";
        } else {
            vVar = vVar2.toString();
        }
        sb5.append(vVar);
        sb5.append("}");
        return sb5.toString();
    }
}
