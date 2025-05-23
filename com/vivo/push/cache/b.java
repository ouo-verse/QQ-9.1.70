package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.u;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f387617a;

    /* renamed from: b, reason: collision with root package name */
    private d f387618b;

    b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f387617a == null) {
                f387617a = new b();
            }
            bVar = f387617a;
        }
        return bVar;
    }

    public final d a(Context context) {
        d dVar = this.f387618b;
        if (dVar != null) {
            return dVar;
        }
        try {
            Method method = ClientConfigManagerImpl.class.getMethod("getInstance", Context.class);
            u.d(com.tencent.mobileqq.msf.core.x.c.f250206a, "createConfig success is ".concat("com.vivo.push.cache.ClientConfigManagerImpl"));
            d dVar2 = (d) method.invoke(null, context);
            this.f387618b = dVar2;
            return dVar2;
        } catch (Exception e16) {
            e16.printStackTrace();
            u.b(com.tencent.mobileqq.msf.core.x.c.f250206a, "createConfig error", e16);
            return null;
        }
    }
}
