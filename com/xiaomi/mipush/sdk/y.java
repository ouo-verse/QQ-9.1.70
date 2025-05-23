package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ci;
import com.xiaomi.push.gf;
import com.xiaomi.push.gs;
import com.xiaomi.push.he;

/* compiled from: P */
/* loaded from: classes28.dex */
public class y implements ci {

    /* renamed from: a, reason: collision with root package name */
    private Context f388119a;

    public y(Context context) {
        this.f388119a = context;
    }

    @Override // com.xiaomi.push.ci
    public String a() {
        return s.c(this.f388119a).t();
    }

    @Override // com.xiaomi.push.ci
    public void a(he heVar, gf gfVar, gs gsVar) {
        ag.h(this.f388119a).w(heVar, gfVar, gsVar);
    }
}
