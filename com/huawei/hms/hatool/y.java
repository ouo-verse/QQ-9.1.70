package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class y {

    /* renamed from: b, reason: collision with root package name */
    private static y f37241b;

    /* renamed from: a, reason: collision with root package name */
    private volatile Map<String, p0> f37242a = new HashMap();

    y() {
    }

    private p0 a(String str) {
        if (!this.f37242a.containsKey(str)) {
            this.f37242a.put(str, new p0());
        }
        return this.f37242a.get(str);
    }

    private static synchronized void b() {
        synchronized (y.class) {
            if (f37241b == null) {
                f37241b = new y();
            }
        }
    }

    public p0 a(String str, long j3) {
        p0 a16 = a(str);
        a16.a(j3);
        return a16;
    }

    public static y a() {
        if (f37241b == null) {
            b();
        }
        return f37241b;
    }
}
