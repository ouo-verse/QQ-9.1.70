package com.tencent.luggage.wxa.k2;

import com.tencent.luggage.wxa.qm.j;
import com.tencent.luggage.wxa.qm.k;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f131426a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f131427b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends j {
        @Override // com.tencent.luggage.wxa.qm.h, com.tencent.luggage.wxa.qm.b
        public boolean f(int i3) {
            if (i3 != 7) {
                return true;
            }
            return false;
        }
    }

    public static final synchronized void a() {
        synchronized (f.class) {
            if (f131427b) {
                return;
            }
            f131427b = true;
            k.a(new a());
        }
    }
}
