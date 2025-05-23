package com.qwallet.activity.patternlock.biz;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f41384a;

    public static c a() {
        if (f41384a == null) {
            synchronized (c.class) {
                if (f41384a == null) {
                    f41384a = new c();
                }
            }
        }
        return f41384a;
    }

    public a b(int i3) {
        return new GestureLockScreenStrategy();
    }
}
