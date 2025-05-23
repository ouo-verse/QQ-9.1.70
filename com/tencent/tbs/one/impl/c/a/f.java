package com.tencent.tbs.one.impl.c.a;

import dalvik.system.DexClassLoader;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class f extends DexClassLoader {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f374729a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f374730b;

    public f(String str, String str2, String str3, ClassLoader classLoader, String[] strArr) {
        super(str, str2, str3, classLoader);
        boolean z16;
        this.f374729a = strArr;
        if (strArr != null && strArr.length > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f374730b = z16;
    }

    private Class<?> a(String str) throws ClassNotFoundException {
        ClassLoader parent;
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                findLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            if (findLoadedClass == null && (parent = getParent()) != null) {
                return parent.loadClass(str);
            }
            return findLoadedClass;
        }
        return findLoadedClass;
    }

    @Override // java.lang.ClassLoader
    protected final Class<?> loadClass(String str, boolean z16) throws ClassNotFoundException {
        if (this.f374730b && str != null) {
            for (String str2 : this.f374729a) {
                if (str.startsWith(str2)) {
                    return super.loadClass(str, z16);
                }
            }
        }
        return a(str);
    }
}
