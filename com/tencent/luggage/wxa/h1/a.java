package com.tencent.luggage.wxa.h1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public static Map f126829a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map f126830b = new ConcurrentHashMap();

    @Override // com.tencent.luggage.wxa.h1.c
    public Map b() {
        return f126829a;
    }

    @Override // com.tencent.luggage.wxa.h1.c
    public Map c() {
        return f126830b;
    }

    @Override // com.tencent.luggage.wxa.h1.c
    public String getName() {
        return "luggage-core";
    }

    @Override // com.tencent.luggage.wxa.h1.c
    public void a() {
    }
}
