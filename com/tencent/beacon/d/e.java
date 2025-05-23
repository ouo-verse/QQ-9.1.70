package com.tencent.beacon.d;

import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final int f77847a;

    /* renamed from: b, reason: collision with root package name */
    public String f77848b = "";

    /* renamed from: c, reason: collision with root package name */
    private boolean f77849c = false;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, String> f77850d = null;

    /* renamed from: e, reason: collision with root package name */
    private Set<String> f77851e = null;

    /* renamed from: f, reason: collision with root package name */
    private Set<String> f77852f = null;

    public e(int i3) {
        this.f77847a = i3;
    }

    public void a(boolean z16) {
        this.f77849c = z16;
    }

    public int b() {
        return this.f77847a;
    }

    public boolean c() {
        return this.f77849c;
    }

    public Map<String, String> a() {
        return this.f77850d;
    }

    public void b(Set<String> set) {
        this.f77852f = set;
    }

    public void a(Map<String, String> map) {
        this.f77850d = map;
    }

    public void a(Set<String> set) {
        this.f77851e = set;
    }
}
