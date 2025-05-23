package com.tencent.luggage.wxa.ka;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m implements com.tencent.luggage.wxa.oa.c {

    /* renamed from: a, reason: collision with root package name */
    public String f131856a;

    public m(String str) {
        this.f131856a = str;
        com.tencent.luggage.wxa.er.a.a((Object) str);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof m)) {
            return this.f131856a.equals(((m) obj).f131856a);
        }
        return false;
    }
}
