package org.tencchromium.base;

import org.tencchromium.base.annotations.CalledByNative;
import org.tencchromium.base.annotations.MainDex;

/* compiled from: P */
@MainDex
/* loaded from: classes29.dex */
public class JNIUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ClassLoader sJniClassLoader;
    private static Boolean sSelectiveJniRegistrationEnabled;

    public static void enableSelectiveJniRegistration() {
        sSelectiveJniRegistrationEnabled = Boolean.TRUE;
    }

    @CalledByNative
    public static Object getClassLoader() {
        ClassLoader classLoader = sJniClassLoader;
        if (classLoader == null) {
            return JNIUtils.class.getClassLoader();
        }
        return classLoader;
    }

    @CalledByNative
    public static boolean isSelectiveJniRegistrationEnabled() {
        if (sSelectiveJniRegistrationEnabled == null) {
            sSelectiveJniRegistrationEnabled = Boolean.FALSE;
        }
        return sSelectiveJniRegistrationEnabled.booleanValue();
    }

    public static void setClassLoader(ClassLoader classLoader) {
        sJniClassLoader = classLoader;
    }
}
