package com.tencent.hydevteam.common.classloader;

import com.tencent.hydevteam.common.annotation.API;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import dalvik.system.DexClassLoader;

/* compiled from: P */
@API
/* loaded from: classes7.dex */
public class ApkClassLoader extends DexClassLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ClassLoader f114737a;

    /* renamed from: b, reason: collision with root package name */
    private final String[] f114738b;

    public ApkClassLoader(String str, String str2, String str3, ClassLoader classLoader, String[] strArr) {
        super(str, str2, str3, classLoader);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, classLoader, strArr);
        } else {
            this.f114737a = classLoader.getParent();
            this.f114738b = strArr;
        }
    }

    public final <T> T a(Class<T> cls, String str) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls, (Object) str);
        }
        try {
            return cls.cast(loadClass(str).newInstance());
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException e16) {
            throw new Exception(e16);
        }
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z16) throws ClassNotFoundException {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
        } else {
            str2 = "";
        }
        String[] strArr = this.f114738b;
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (str2.equals(strArr[i3])) {
                    break;
                }
                i3++;
            } else {
                z17 = false;
                break;
            }
        }
        if (z17) {
            return super.loadClass(str, z16);
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                findLoadedClass = findClass(str);
                e = null;
            } catch (ClassNotFoundException e16) {
                e = e16;
            }
            if (findLoadedClass == null) {
                try {
                    return this.f114737a.loadClass(str);
                } catch (ClassNotFoundException e17) {
                    e17.addSuppressed(e);
                    throw e17;
                }
            }
            return findLoadedClass;
        }
        return findLoadedClass;
    }

    public final <T> T a(Class<T> cls, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, this, cls, str, clsArr, objArr);
        }
        try {
            return cls.cast(loadClass(str).getConstructor(clsArr).newInstance(objArr));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException e16) {
            throw new Exception(e16);
        }
    }
}
