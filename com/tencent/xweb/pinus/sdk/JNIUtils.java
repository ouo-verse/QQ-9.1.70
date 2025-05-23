package com.tencent.xweb.pinus.sdk;

import com.tencent.xweb.CalledByRuntime;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JNIUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ClassLoader sJniClassLoader;
    private static Boolean sSelectiveJniRegistrationEnabled;

    public static void enableSelectiveJniRegistration() {
        sSelectiveJniRegistrationEnabled = Boolean.TRUE;
    }

    @CalledByRuntime
    public static Object getClassLoader() {
        ClassLoader classLoader = sJniClassLoader;
        if (classLoader == null) {
            return JNIUtils.class.getClassLoader();
        }
        return classLoader;
    }

    @CalledByRuntime
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
