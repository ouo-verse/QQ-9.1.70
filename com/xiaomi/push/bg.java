package com.xiaomi.push;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bg implements eu, ex {

    /* renamed from: a, reason: collision with root package name */
    private Context f388263a;

    public bg(Context context) {
        this.f388263a = context;
    }

    @Override // com.xiaomi.push.ex
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo300a(fc fcVar) {
        return true;
    }

    @Override // com.xiaomi.push.eu
    public void b(eb ebVar) {
        if (ebVar != null && ebVar.a() == 0 && "PING".equals(ebVar.e())) {
            bz.i(this.f388263a);
        } else {
            bz.e(this.f388263a);
        }
    }

    @Override // com.xiaomi.push.eu
    public void a(fc fcVar) {
        bz.e(this.f388263a);
    }
}
