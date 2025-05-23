package com.tencent.qimei.ar;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final Map<String, a> f343092c = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String f343093a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.qimei.at.a f343094b;

    public a(String str) {
        this.f343093a = str;
        this.f343094b = new com.tencent.qimei.at.a(str);
    }

    public static synchronized a a(String str) {
        a aVar;
        synchronized (a.class) {
            Map<String, a> map = f343092c;
            aVar = map.get(str);
            if (aVar == null) {
                aVar = new a(str);
                map.put(str, aVar);
            }
        }
        return aVar;
    }
}
