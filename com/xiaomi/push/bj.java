package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ae;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bj extends ae.a {

    /* renamed from: d, reason: collision with root package name */
    private Context f388274d;

    public bj(Context context) {
        this.f388274d = context;
    }

    private boolean f() {
        return com.xiaomi.clientreport.manager.a.c(this.f388274d).e().h();
    }

    @Override // com.xiaomi.push.ae.a
    public String e() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (f()) {
                com.xiaomi.clientreport.manager.a.c(this.f388274d).w();
                jz4.c.z(this.f388274d.getPackageName() + " perf begin upload");
            }
        } catch (Exception e16) {
            jz4.c.B("fail to send perf data. " + e16);
        }
    }
}
