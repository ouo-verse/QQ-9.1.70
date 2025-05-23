package com.xiaomi.push;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bv implements es {

    /* renamed from: d, reason: collision with root package name */
    private Context f388324d;

    public bv(Context context) {
        this.f388324d = context;
    }

    @Override // com.xiaomi.push.es
    public void a(ep epVar) {
    }

    @Override // com.xiaomi.push.es
    public void b(ep epVar) {
        bm.c(this.f388324d);
    }

    @Override // com.xiaomi.push.es
    public void a(ep epVar, Exception exc) {
    }

    @Override // com.xiaomi.push.es
    public void a(ep epVar, int i3, Exception exc) {
        bm.f(this.f388324d, epVar.d(), i3);
    }
}
