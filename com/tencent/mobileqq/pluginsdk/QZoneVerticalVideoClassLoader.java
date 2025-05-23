package com.tencent.mobileqq.pluginsdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QZoneVerticalVideoClassLoader extends DexClassLoader {
    static IPatchRedirector $redirector_;
    private ClassLoader mGrandParent;
    private final String[] mInterceptPackageNames;

    public QZoneVerticalVideoClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, classLoader);
        } else {
            this.mInterceptPackageNames = new String[0];
            this.mGrandParent = classLoader.getParent().getParent();
        }
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z16) throws ClassNotFoundException {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
        } else {
            str2 = "";
        }
        boolean z17 = false;
        for (String str3 : this.mInterceptPackageNames) {
            if (str2.startsWith(str3)) {
                QLog.d("rays", 1, "intercept class=" + str);
                z17 = true;
            }
        }
        if (!z17) {
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
                    return this.mGrandParent.loadClass(str);
                } catch (ClassNotFoundException e17) {
                    e17.addSuppressed(e);
                    throw e17;
                }
            }
            return findLoadedClass;
        }
        return findLoadedClass;
    }
}
