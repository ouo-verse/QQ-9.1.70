package com.tencent.luggage.wxa.m6;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum e {
    MAIN("ilinkgeta8key", 5112, a.class),
    MP("ilinkmpgeta8key", 2909, f.class),
    PAY("ilinkpaygeta8key", 4748, h.class),
    MINOR("ilinkminorgeta8key", 5101, g.class),
    THREE_RD("ilink3rdgeta8key", com.tencent.mobileqq.msf.core.c0.g.f247764w1, i.class);


    /* renamed from: a, reason: collision with root package name */
    public final String f134207a;

    /* renamed from: b, reason: collision with root package name */
    public final int f134208b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f134209c;

    e(String str, int i3, Class cls) {
        this.f134207a = str;
        this.f134208b = i3;
        this.f134209c = cls;
    }

    public final Class b() {
        return this.f134209c;
    }

    public final int c() {
        return this.f134208b;
    }

    public final String d() {
        return this.f134207a;
    }
}
