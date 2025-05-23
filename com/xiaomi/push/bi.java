package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ae;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bi extends ae.a {

    /* renamed from: d, reason: collision with root package name */
    private Context f388273d;

    public bi(Context context) {
        this.f388273d = context;
    }

    private boolean f() {
        return com.xiaomi.clientreport.manager.a.c(this.f388273d).e().g();
    }

    @Override // com.xiaomi.push.ae.a
    public String e() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (f()) {
                jz4.c.z(this.f388273d.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.c(this.f388273d).s();
            }
        } catch (Exception e16) {
            jz4.c.q(e16);
        }
    }
}
