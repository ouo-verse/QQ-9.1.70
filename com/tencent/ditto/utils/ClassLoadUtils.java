package com.tencent.ditto.utils;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ClassLoadUtils {
    private static final Set<ClassLoader> LOADERS = Collections.newSetFromMap(new ConcurrentHashMap());

    public static void addSubstituteLoader(ClassLoader classLoader) {
        if (classLoader == null) {
            return;
        }
        LOADERS.add(classLoader);
    }

    public static Class<?> load(ClassLoader classLoader, String str) throws ClassNotFoundException {
        Class<?> cls;
        try {
            cls = classLoader.loadClass(str);
        } catch (ClassNotFoundException e16) {
            if (!LOADERS.isEmpty()) {
                cls = null;
            } else {
                throw e16;
            }
        }
        if (cls != null) {
            return cls;
        }
        Iterator<ClassLoader> it = LOADERS.iterator();
        while (it.hasNext()) {
            try {
                cls = it.next().loadClass(str);
                break;
            } catch (ClassNotFoundException e17) {
                if (!it.hasNext()) {
                    throw e17;
                }
            }
        }
        return cls;
    }
}
