package com.tencent.tab.exp.sdk.impl;

import com.tencent.tab.exp.sdk.pbdata.ControlData;

/* compiled from: P */
/* loaded from: classes26.dex */
final class e {

    /* renamed from: e, reason: collision with root package name */
    public static final ControlData f374076e = null;

    /* renamed from: a, reason: collision with root package name */
    private ControlData f374077a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f374078b;

    /* renamed from: c, reason: collision with root package name */
    private int f374079c;

    /* renamed from: d, reason: collision with root package name */
    private int f374080d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        f(f374076e, false, 600, 60);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ControlData b() {
        return this.f374077a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f374080d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f374079c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f374078b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f374078b == eVar.f374078b && this.f374079c == eVar.f374079c && this.f374080d == eVar.f374080d && x.g(this.f374077a, eVar.f374077a)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void f(ControlData controlData, boolean z16, int i3, int i16) {
        this.f374077a = controlData;
        this.f374078b = z16;
        this.f374079c = i3;
        this.f374080d = i16;
    }

    public int hashCode() {
        return x.h(this.f374077a, Boolean.valueOf(this.f374078b), Integer.valueOf(this.f374079c), Integer.valueOf(this.f374080d));
    }

    public String toString() {
        return "TabExpControlInfo{mData=" + this.f374077a + ", mEnableReport=" + this.f374078b + ", mRollInterval=" + this.f374079c + ", mReportInterval=" + this.f374080d + '}';
    }
}
