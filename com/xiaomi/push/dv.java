package com.xiaomi.push;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class dv implements dt {

    /* renamed from: a, reason: collision with root package name */
    private dt f388625a;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static dv f388626a = new dv();
    }

    public static dv b() {
        return b.f388626a;
    }

    @Override // com.xiaomi.push.dt
    public void a(ds dsVar) {
        dt dtVar = this.f388625a;
        if (dtVar != null) {
            dtVar.a(dsVar);
        }
    }

    dv() {
    }

    @Override // com.xiaomi.push.dt
    public void a(String str, Map<String, Object> map) {
        dt dtVar = this.f388625a;
        if (dtVar != null) {
            dtVar.a(str, map);
        }
    }
}
