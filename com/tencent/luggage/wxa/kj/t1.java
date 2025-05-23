package com.tencent.luggage.wxa.kj;

import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class t1 {
    public static x a(v vVar, Class cls) {
        return (x) Reflect.on((Class<?>) cls).create(vVar).get();
    }
}
