package com.tencent.magicbrush.engine;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.p8.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class JsClassUtils {
    static IPatchRedirector $redirector_ = null;
    private static final int BOOLEAN = 1;
    private static final int BYTE = 3;
    private static final int CHAR = 2;
    private static final int DOUBLE = 8;
    private static final int FLOAT = 6;
    private static final int INT = 5;
    private static final int LONG = 7;
    private static final int SHORT = 4;
    private static final String TAG = "MicroMsg.JsClassUtils";
    private static final int VOID = 0;
    public static final int log_type_d = 0;
    public static final int log_type_e = 2;
    public static final int log_type_i = 1;
    private static final int string = 9;
    private static final int unknown = 10;

    public JsClassUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void getDescriptor(StringBuilder sb5, Class<?> cls) {
        char c16;
        while (!cls.isPrimitive()) {
            if (cls.isArray()) {
                sb5.append('[');
                cls = cls.getComponentType();
            } else {
                sb5.append('L');
                String name = cls.getName();
                int length = name.length();
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt = name.charAt(i3);
                    if (charAt == '.') {
                        charAt = '/';
                    }
                    sb5.append(charAt);
                }
                sb5.append(';');
                return;
            }
        }
        if (cls == Integer.TYPE) {
            c16 = 'I';
        } else if (cls == Void.TYPE) {
            c16 = 'V';
        } else if (cls == Boolean.TYPE) {
            c16 = 'Z';
        } else if (cls == Byte.TYPE) {
            c16 = 'B';
        } else if (cls == Character.TYPE) {
            c16 = 'C';
        } else if (cls == Short.TYPE) {
            c16 = 'S';
        } else if (cls == Double.TYPE) {
            c16 = 'D';
        } else if (cls == Float.TYPE) {
            c16 = 'F';
        } else {
            c16 = 'J';
        }
        sb5.append(c16);
    }

    private static int getJavaType(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return 5;
        }
        if (cls == Void.TYPE) {
            return 0;
        }
        if (cls == Boolean.TYPE) {
            return 1;
        }
        if (cls == Byte.TYPE) {
            return 3;
        }
        if (cls == Character.TYPE) {
            return 2;
        }
        if (cls == Short.TYPE) {
            return 4;
        }
        if (cls == Double.TYPE) {
            return 8;
        }
        if (cls == Float.TYPE) {
            return 6;
        }
        if (cls.getCanonicalName().equals("java.lang.String")) {
            return 9;
        }
        return 10;
    }

    @Keep
    public static Method[] getJavascriptInterfaceMethod(Object obj) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Method method : obj.getClass().getMethods()) {
                if (method.isAnnotationPresent(JavascriptInterface.class)) {
                    arrayList.add(method);
                }
            }
        } catch (Exception unused) {
        }
        return (Method[]) arrayList.toArray(new Method[arrayList.size()]);
    }

    @Keep
    public static String getMethodName(Method method) {
        return method.getName();
    }

    @Keep
    public static String getMethodSignature(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringBuilder sb5 = new StringBuilder();
        sb5.append('(');
        for (Class<?> cls : parameterTypes) {
            getDescriptor(sb5, cls);
        }
        sb5.append(')');
        getDescriptor(sb5, method.getReturnType());
        return sb5.toString();
    }

    @Keep
    public static int[] getMethodType(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        int[] iArr = new int[parameterTypes.length + 2];
        iArr[0] = parameterTypes.length;
        iArr[1] = getJavaType(method.getReturnType());
        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
            iArr[i3 + 2] = getJavaType(parameterTypes[i3]);
        }
        return iArr;
    }

    @Keep
    public static byte[] getStringUtf8(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static boolean hasJavascriptInterface(Object obj) {
        try {
            for (Method method : obj.getClass().getMethods()) {
                if (method.isAnnotationPresent(JavascriptInterface.class)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Keep
    public static void jsLog(int i3, String str) {
        if (i3 != 1) {
            if (i3 != 2) {
                f.a(TAG, str, new Object[0]);
                return;
            } else {
                f.b(TAG, str, new Object[0]);
                return;
            }
        }
        f.c(TAG, str, new Object[0]);
    }
}
