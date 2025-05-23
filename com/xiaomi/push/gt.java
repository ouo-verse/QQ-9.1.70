package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum gt {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);


    /* renamed from: a, reason: collision with other field name */
    private final int f24773a;

    gt(int i3) {
        this.f24773a = i3;
    }

    public int a() {
        return this.f24773a;
    }

    public static gt a(int i3) {
        if (i3 == 0) {
            return RegIdExpired;
        }
        if (i3 == 1) {
            return PackageUnregistered;
        }
        if (i3 != 2) {
            return null;
        }
        return Init;
    }
}
