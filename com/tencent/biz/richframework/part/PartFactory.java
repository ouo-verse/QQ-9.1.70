package com.tencent.biz.richframework.part;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes5.dex */
public class PartFactory {
    private static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> sClassCacheMap = new SimpleArrayMap<>();

    /* loaded from: classes5.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(@NonNull String str, @Nullable Exception exc) {
            super(str, exc);
        }
    }

    @NonNull
    public static Part instantiate(@NonNull ClassLoader classLoader, @NonNull String str) {
        try {
            return loadPartClass(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e16) {
            e = e16;
            throw new InstantiationException("Unable to instantiate part " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (java.lang.InstantiationException e17) {
            e = e17;
            throw new InstantiationException("Unable to instantiate part " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (NoSuchMethodException e18) {
            throw new InstantiationException("Unable to instantiate part " + str + ": could not find Part constructor", e18);
        } catch (InvocationTargetException e19) {
            throw new InstantiationException("Unable to instantiate part " + str + ": calling Part constructor caused an exception", e19);
        }
    }

    @NonNull
    private static Class<?> loadClass(@NonNull ClassLoader classLoader, @NonNull String str) throws ClassNotFoundException {
        SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> simpleArrayMap = sClassCacheMap;
        SimpleArrayMap<String, Class<?>> simpleArrayMap2 = simpleArrayMap.get(classLoader);
        if (simpleArrayMap2 == null) {
            simpleArrayMap2 = new SimpleArrayMap<>();
            simpleArrayMap.put(classLoader, simpleArrayMap2);
        }
        Class<?> cls = simpleArrayMap2.get(str);
        if (cls == null) {
            Class<?> cls2 = Class.forName(str, false, classLoader);
            simpleArrayMap2.put(str, cls2);
            return cls2;
        }
        return cls;
    }

    @NonNull
    public static Class<? extends Part> loadPartClass(@NonNull ClassLoader classLoader, @NonNull String str) {
        try {
            return loadClass(classLoader, str);
        } catch (ClassCastException e16) {
            throw new InstantiationException("Unable to instantiate part " + str + ": make sure class is a valid subclass of Part", e16);
        } catch (ClassNotFoundException e17) {
            throw new InstantiationException("Unable to instantiate part " + str + ": make sure class name exists", e17);
        }
    }
}
