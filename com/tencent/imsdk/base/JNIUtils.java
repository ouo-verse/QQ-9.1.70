package com.tencent.imsdk.base;

import com.tencent.imsdk.base.annotations.CalledByNative;
import com.tencent.imsdk.base.annotations.MainDex;

/* compiled from: P */
@MainDex
/* loaded from: classes7.dex */
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
