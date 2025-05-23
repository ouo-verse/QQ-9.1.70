package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class s {

    /* renamed from: b, reason: collision with root package name */
    static Map<String, l1> f37205b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static s f37206c;

    /* renamed from: a, reason: collision with root package name */
    private g1 f37207a = new g1();

    s() {
    }

    public static s c() {
        if (f37206c == null) {
            d();
        }
        return f37206c;
    }

    private static synchronized void d() {
        synchronized (s.class) {
            if (f37206c == null) {
                f37206c = new s();
            }
        }
    }

    public l1 a(String str) {
        return f37205b.get(str);
    }

    public g1 b() {
        return this.f37207a;
    }

    public Set<String> a() {
        return f37205b.keySet();
    }

    public void a(String str, l1 l1Var) {
        f37205b.put(str, l1Var);
    }
}
