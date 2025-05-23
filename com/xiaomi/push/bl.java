package com.xiaomi.push;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bl implements eu, ex {

    /* renamed from: a, reason: collision with root package name */
    private Context f388277a;

    public bl(Context context) {
        this.f388277a = context;
    }

    @Override // com.xiaomi.push.ex
    /* renamed from: a */
    public boolean mo300a(fc fcVar) {
        return true;
    }

    @Override // com.xiaomi.push.eu
    public void b(eb ebVar) {
        if (ebVar != null && ebVar.a() == 0 && "PING".equals(ebVar.e())) {
            bz.h(this.f388277a);
        } else {
            bz.a(this.f388277a);
        }
    }

    @Override // com.xiaomi.push.eu
    public void a(fc fcVar) {
        bz.a(this.f388277a);
    }
}
