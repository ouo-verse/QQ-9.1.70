package com.tencent.luggage.wxa.ka;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f131892a = new ConcurrentHashMap();

    public static Object a(String str, Class cls) {
        try {
            Class<?> cls2 = Class.forName(str);
            if (!cls.isAssignableFrom(cls2)) {
                com.tencent.luggage.wxa.ta.c.b("IPC.ObjectStore", "%s isAssignableFrom %s return false", cls, cls2);
                return null;
            }
            if (cls2.isAnnotationPresent(com.tencent.luggage.wxa.na.b.class)) {
                Map map = f131892a;
                com.tencent.luggage.wxa.qa.e eVar = (com.tencent.luggage.wxa.qa.e) map.get(str);
                if (eVar == null) {
                    eVar = new com.tencent.luggage.wxa.qa.e(cls2);
                    map.put(str, eVar);
                }
                return eVar.a();
            }
            return com.tencent.luggage.wxa.sa.b.a(str, cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object b(String str, Class cls) {
        return com.tencent.luggage.wxa.sa.b.a(str, cls);
    }

    public static Object a(Class cls, Class cls2) {
        try {
            if (!cls2.isAssignableFrom(cls)) {
                com.tencent.luggage.wxa.ta.c.b("IPC.ObjectStore", "%s isAssignableFrom %s return false", cls2, cls);
                return null;
            }
            if (cls.isAnnotationPresent(com.tencent.luggage.wxa.na.b.class)) {
                String name = cls.getName();
                Map map = f131892a;
                com.tencent.luggage.wxa.qa.e eVar = (com.tencent.luggage.wxa.qa.e) map.get(name);
                if (eVar == null) {
                    eVar = new com.tencent.luggage.wxa.qa.e(cls);
                    map.put(name, eVar);
                }
                return eVar.a();
            }
            return com.tencent.luggage.wxa.sa.b.a(cls, cls2);
        } catch (Exception unused) {
            return null;
        }
    }
}
