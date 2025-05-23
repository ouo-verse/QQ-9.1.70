package com.tencent.luggage.wxa.lo;

import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f133704a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f133705b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Map f133706c = new LinkedHashMap();

    public final Constructor a(Class cls) {
        Constructor constructor;
        String key = cls.getName();
        Map map = f133705b;
        Intrinsics.checkNotNullExpressionValue(key, "key");
        Object obj = map.get(key);
        if (obj == null) {
            try {
                constructor = cls.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                constructor = null;
            }
            obj = constructor;
            map.put(key, obj);
        }
        return (Constructor) obj;
    }

    public final Object b(Class clazz) {
        Constructor a16;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Map map = f133706c;
        Object obj = map.get(clazz);
        if (obj == null) {
            try {
                a16 = f133704a.a(clazz);
            } catch (NoSuchMethodException unused) {
            }
            if (a16 != null) {
                obj = a16.newInstance(new Object[0]);
                map.put(clazz, obj);
            }
            obj = null;
            map.put(clazz, obj);
        }
        return obj;
    }
}
