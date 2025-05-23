package com.tencent.qqlive.tvkplayer.tools.utils;

import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VMCompat {
    private static final byte[] GET_LOCKER = new byte[0];
    private static volatile Boolean sIs64Bit;

    public static boolean is64Bit() {
        if (sIs64Bit != null) {
            return sIs64Bit.booleanValue();
        }
        synchronized (GET_LOCKER) {
            if (sIs64Bit != null) {
                return sIs64Bit.booleanValue();
            }
            sIs64Bit = Boolean.valueOf(is64BitImpl());
            return sIs64Bit.booleanValue();
        }
    }

    private static boolean is64BitImpl() {
        Class<?> cls;
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        try {
            cls = Class.forName("dalvik.system.VMRuntime");
            declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0]);
        } catch (Throwable th5) {
            TVKLogUtil.e("VMCompat", th5);
        }
        if (declaredMethod == null || (invoke = declaredMethod.invoke(null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0])) == null) {
            return false;
        }
        Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
        if (invoke2 instanceof Boolean) {
            return ((Boolean) invoke2).booleanValue();
        }
        return false;
    }
}
