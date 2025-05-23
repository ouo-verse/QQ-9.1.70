package com.vivo.push.e;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    private static volatile b f387653c;

    /* renamed from: a, reason: collision with root package name */
    private a f387654a;

    /* renamed from: b, reason: collision with root package name */
    private Context f387655b;

    b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f387653c == null) {
                f387653c = new b();
            }
            bVar = f387653c;
        }
        return bVar;
    }

    public final synchronized a a(Context context) {
        a aVar = this.f387654a;
        if (aVar != null) {
            return aVar;
        }
        if (context == null) {
            return null;
        }
        if (aVar == null) {
            Context context2 = ContextDelegate.getContext(context.getApplicationContext());
            this.f387655b = context2;
            this.f387654a = new c(context2);
        }
        return this.f387654a;
    }
}
