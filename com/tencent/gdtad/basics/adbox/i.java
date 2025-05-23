package com.tencent.gdtad.basics.adbox;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes6.dex */
public class i {

    /* renamed from: c, reason: collision with root package name */
    private static volatile i f108717c;

    /* renamed from: a, reason: collision with root package name */
    private final Set<String> f108718a = Collections.synchronizedSet(new HashSet());

    /* renamed from: b, reason: collision with root package name */
    private final Set<String> f108719b = Collections.synchronizedSet(new HashSet());

    public static i b() {
        if (f108717c == null) {
            synchronized (i.class) {
                if (f108717c == null) {
                    f108717c = new i();
                }
            }
        }
        return f108717c;
    }

    public void a() {
        this.f108718a.clear();
        this.f108719b.clear();
    }

    public boolean c(String str) {
        return this.f108719b.contains(str);
    }

    public boolean d(String str) {
        return this.f108718a.contains(str);
    }

    public void e(String str) {
        this.f108719b.add(str);
    }

    public void f(String str) {
        this.f108718a.add(str);
    }
}
