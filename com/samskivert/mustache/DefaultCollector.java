package com.samskivert.mustache;

import com.samskivert.mustache.Mustache;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DefaultCollector extends BasicCollector {
    private final boolean _allowAccessCoercion;

    public DefaultCollector() {
        this(true);
    }

    private void addIfaces(Set<Class<?>> set, Class<?> cls, boolean z16) {
        if (z16) {
            set.add(cls);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            addIfaces(set, cls2, true);
        }
    }

    private Method makeAccessible(Method method) {
        if (method.isAccessible()) {
            return method;
        }
        if (!this._allowAccessCoercion) {
            return null;
        }
        method.setAccessible(true);
        return method;
    }

    @Override // com.samskivert.mustache.BasicCollector, com.samskivert.mustache.Mustache.Collector
    public Mustache.VariableFetcher createFetcher(Object obj, String str) {
        Mustache.VariableFetcher createFetcher = super.createFetcher(obj, str);
        if (createFetcher != null) {
            return createFetcher;
        }
        Class<?> cls = obj.getClass();
        final Method method = getMethod(cls, str);
        if (method != null) {
            return new Mustache.VariableFetcher() { // from class: com.samskivert.mustache.DefaultCollector.1
                @Override // com.samskivert.mustache.Mustache.VariableFetcher
                public Object get(Object obj2, String str2) throws Exception {
                    return method.invoke(obj2, new Object[0]);
                }
            };
        }
        final Field field = getField(cls, str);
        if (field != null) {
            return new Mustache.VariableFetcher() { // from class: com.samskivert.mustache.DefaultCollector.2
                @Override // com.samskivert.mustache.Mustache.VariableFetcher
                public Object get(Object obj2, String str2) throws Exception {
                    return field.get(obj2);
                }
            };
        }
        final Method ifaceMethod = getIfaceMethod(cls, str);
        if (ifaceMethod != null) {
            return new Mustache.VariableFetcher() { // from class: com.samskivert.mustache.DefaultCollector.3
                @Override // com.samskivert.mustache.Mustache.VariableFetcher
                public Object get(Object obj2, String str2) throws Exception {
                    return ifaceMethod.invoke(obj2, new Object[0]);
                }
            };
        }
        return null;
    }

    @Override // com.samskivert.mustache.BasicCollector, com.samskivert.mustache.Mustache.Collector
    public <K, V> Map<K, V> createFetcherCache() {
        return new ConcurrentHashMap();
    }

    protected Field getField(Class<?> cls, String str) {
        if (!this._allowAccessCoercion) {
            try {
                return cls.getField(str);
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (Exception unused2) {
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass == Object.class || superclass == null) {
                return null;
            }
            return getField(cls.getSuperclass(), str);
        }
    }

    protected Method getIfaceMethod(Class<?> cls, String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (cls != null && cls != Object.class) {
            addIfaces(linkedHashSet, cls, false);
            cls = cls.getSuperclass();
        }
        Iterator<Class<?>> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            Method methodOn = getMethodOn(it.next(), str);
            if (methodOn != null) {
                return methodOn;
            }
        }
        return null;
    }

    protected Method getMethod(Class<?> cls, String str) {
        if (this._allowAccessCoercion) {
            while (cls != null && cls != Object.class) {
                Method methodOn = getMethodOn(cls, str);
                if (methodOn != null) {
                    return methodOn;
                }
                cls = cls.getSuperclass();
            }
            return null;
        }
        try {
            return cls.getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    protected Method getMethodOn(Class<?> cls, String str) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            if (!declaredMethod.getReturnType().equals(Void.TYPE)) {
                return makeAccessible(declaredMethod);
            }
        } catch (Exception unused) {
        }
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        try {
            Method declaredMethod2 = cls.getDeclaredMethod("get" + str2, new Class[0]);
            if (!declaredMethod2.getReturnType().equals(Void.TYPE)) {
                return makeAccessible(declaredMethod2);
            }
        } catch (Exception unused2) {
        }
        try {
            Method declaredMethod3 = cls.getDeclaredMethod("is" + str2, new Class[0]);
            if (declaredMethod3.getReturnType().equals(Boolean.TYPE) || declaredMethod3.getReturnType().equals(Boolean.class)) {
                return makeAccessible(declaredMethod3);
            }
            return null;
        } catch (Exception unused3) {
            return null;
        }
    }

    public DefaultCollector(boolean z16) {
        this._allowAccessCoercion = z16;
    }
}
