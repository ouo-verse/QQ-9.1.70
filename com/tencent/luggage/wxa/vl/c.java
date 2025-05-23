package com.tencent.luggage.wxa.vl;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum c {
    DONE(6),
    SEARCH(3),
    NEXT(5),
    GO(2),
    SEND(4),
    RETURN(0);


    /* renamed from: a, reason: collision with root package name */
    public final int f143658a;

    c(int i3) {
        this.f143658a = i3;
    }

    public static c a(boolean z16) {
        return z16 ? RETURN : DONE;
    }

    public static c a(String str) {
        return (c) e.a(str, c.class);
    }
}
