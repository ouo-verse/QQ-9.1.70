package com.tencent.ams.hippo.quickjs.android;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes3.dex */
class JNIHelper {
    static IPatchRedirector $redirector_;
    private static Type BOOLEAN_PRIMITIVE_TYPE;
    private static Type BYTE_PRIMITIVE_TYPE;
    private static Type CHAR_PRIMITIVE_TYPE;
    private static Type DOUBLE_PRIMITIVE_TYPE;
    private static Type FLOAT_PRIMITIVE_TYPE;
    private static Type INT_PRIMITIVE_TYPE;
    private static Type LONG_PRIMITIVE_TYPE;
    private static Type SHORT_PRIMITIVE_TYPE;
    private static Type VOID_PRIMITIVE_TYPE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13935);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        VOID_PRIMITIVE_TYPE = Void.TYPE;
        CHAR_PRIMITIVE_TYPE = Character.TYPE;
        BOOLEAN_PRIMITIVE_TYPE = Boolean.TYPE;
        BYTE_PRIMITIVE_TYPE = Byte.TYPE;
        SHORT_PRIMITIVE_TYPE = Short.TYPE;
        INT_PRIMITIVE_TYPE = Integer.TYPE;
        LONG_PRIMITIVE_TYPE = Long.TYPE;
        FLOAT_PRIMITIVE_TYPE = Float.TYPE;
        DOUBLE_PRIMITIVE_TYPE = Double.TYPE;
    }

    JNIHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean isPrimitiveType(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            return true;
        }
        return false;
    }

    private static boolean isSameType(Type type, Type type2) {
        if (type != type2 && (type == null || !type.equals(type2))) {
            return false;
        }
        return true;
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, boolean z16) {
        return javaValueToJSValue(jSContext, type, Boolean.valueOf(z16));
    }

    private static Object jsValueToJavaValue(JSContext jSContext, Type type, long j3) {
        Object fromJSValue;
        synchronized (jSContext.jsRuntime) {
            JSValue jSValue = null;
            try {
                jSContext.checkClosed();
                TypeAdapter adapter = jSContext.quickJS.getAdapter(type);
                jSValue = jSContext.wrapAsJSValue(j3);
                fromJSValue = adapter.fromJSValue(jSContext, jSValue);
            } finally {
                if (jSValue == null) {
                    QuickJS.destroyValue(jSContext.pointer, j3);
                }
            }
        }
        return fromJSValue;
    }

    private static boolean unbox(Boolean bool) {
        return bool.booleanValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, char c16) {
        return javaValueToJSValue(jSContext, type, Character.valueOf(c16));
    }

    private static char unbox(Character ch5) {
        return ch5.charValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, byte b16) {
        return javaValueToJSValue(jSContext, type, Byte.valueOf(b16));
    }

    private static byte unbox(Byte b16) {
        return b16.byteValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, short s16) {
        return javaValueToJSValue(jSContext, type, Short.valueOf(s16));
    }

    private static short unbox(Short sh5) {
        return sh5.shortValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, int i3) {
        return javaValueToJSValue(jSContext, type, Integer.valueOf(i3));
    }

    private static int unbox(Integer num) {
        return num.intValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, long j3) {
        return javaValueToJSValue(jSContext, type, Long.valueOf(j3));
    }

    private static long unbox(Long l3) {
        return l3.longValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, float f16) {
        return javaValueToJSValue(jSContext, type, Float.valueOf(f16));
    }

    private static float unbox(Float f16) {
        return f16.floatValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, double d16) {
        return javaValueToJSValue(jSContext, type, Double.valueOf(d16));
    }

    private static double unbox(Double d16) {
        return d16.doubleValue();
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, Object obj) {
        long j3;
        synchronized (jSContext.jsRuntime) {
            jSContext.checkClosed();
            j3 = jSContext.quickJS.getAdapter(type).toJSValue(jSContext, obj).pointer;
        }
        return j3;
    }
}
