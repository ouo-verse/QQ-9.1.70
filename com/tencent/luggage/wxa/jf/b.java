package com.tencent.luggage.wxa.jf;

import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum b {
    RELEASE(0),
    DEVELOP(1),
    TRIAL(2);


    /* renamed from: a, reason: collision with root package name */
    public final int f130986a;

    b(int i3) {
        this.f130986a = i3;
    }

    public static b a(String str, b bVar) {
        if (w0.c(str)) {
            return bVar;
        }
        for (b bVar2 : values()) {
            if (bVar2.name().toLowerCase().equals(str)) {
                return bVar2;
            }
        }
        return bVar;
    }

    public static b a(int i3) {
        for (b bVar : values()) {
            if (bVar.f130986a == i3) {
                return bVar;
            }
        }
        return RELEASE;
    }
}
