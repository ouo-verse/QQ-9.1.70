package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ae;
import com.xiaomi.push.fv;
import com.xiaomi.push.gf;
import com.xiaomi.push.gl;
import com.xiaomi.push.gp;
import com.xiaomi.push.gx;
import com.xiaomi.push.he;
import com.xiaomi.push.service.ah;

/* compiled from: P */
/* loaded from: classes28.dex */
public class o extends ae.a {

    /* renamed from: d, reason: collision with root package name */
    private Context f388079d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f388080e = false;

    public o(Context context) {
        this.f388079d = context;
    }

    @Override // com.xiaomi.push.ae.a
    public String e() {
        return "2";
    }

    @Override // java.lang.Runnable
    public void run() {
        ah d16 = ah.d(this.f388079d);
        gx gxVar = new gx();
        if (this.f388080e) {
            gxVar.a(0);
            gxVar.b(0);
        } else {
            gxVar.a(com.xiaomi.push.service.l.a(d16, gl.MISC_CONFIG));
            gxVar.b(com.xiaomi.push.service.l.a(d16, gl.PLUGIN_CONFIG));
        }
        he heVar = new he("-1", false);
        heVar.c(gp.DailyCheckClientConfig.f24750a);
        heVar.a(fv.e(gxVar));
        jz4.c.y("OcVersionCheckJob", "-->check version: checkMessage=", gxVar);
        ag.h(this.f388079d).w(heVar, gf.Notification, null);
    }
}
