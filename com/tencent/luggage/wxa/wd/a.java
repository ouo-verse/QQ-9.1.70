package com.tencent.luggage.wxa.wd;

import com.tencent.luggage.wxa.ka.o;
import com.tencent.luggage.wxa.ka.p;
import com.tencent.luggage.wxa.ka.u;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.zp.h;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f144170a = false;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.wd.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC6878a implements u {
        INSTANCE;

        @Override // com.tencent.luggage.wxa.ka.u
        public void a() {
            w.d("MicroMsg.AppBrandMainProcessService", "onDisconnect: [%s] disconnected, reconnect immediately", z.g());
            a.a();
        }
    }

    public static void a() {
        if (!c0.b()) {
            h.f146825d.a(new Runnable() { // from class: com.tencent.luggage.wxa.wd.g
                @Override // java.lang.Runnable
                public final void run() {
                    a.a();
                }
            });
            return;
        }
        w.e("MicroMsg.AppBrandMainProcessService", "tryBind: ");
        if (!f144170a) {
            o.a(z.g(), EnumC6878a.INSTANCE);
            f144170a = true;
        }
        p.a(z.g());
    }
}
