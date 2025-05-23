package com.tencent.luggage.wxa.sa;

import com.tencent.luggage.wxa.ta.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {
        public static String a(boolean z16) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 4) {
                StringBuilder sb5 = new StringBuilder();
                for (int i3 = 3; i3 < stackTrace.length; i3++) {
                    if (stackTrace[i3].getClassName().contains("com.tencent.mm")) {
                        sb5.append("[");
                        sb5.append(stackTrace[i3].getClassName().substring(15));
                        sb5.append(":");
                        sb5.append(stackTrace[i3].getMethodName());
                        if (z16) {
                            sb5.append("(" + stackTrace[i3].getLineNumber() + ")]");
                        } else {
                            sb5.append("]");
                        }
                    }
                }
                return sb5.toString();
            }
            return "";
        }

        public String toString() {
            return a(true);
        }
    }

    public static boolean a(Class cls) {
        if (cls == null) {
            c.e("IPC.ReflectUtil", "check failed: class is null", new Object[0]);
            return false;
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            return true;
        }
        if (cls.isLocalClass()) {
            c.e("IPC.ReflectUtil", "check failed: isLocalClass = true", new Object[0]);
            return false;
        }
        if (cls.isMemberClass()) {
            c.e("IPC.ReflectUtil", "check failed: isMemberClass = true", new Object[0]);
            return false;
        }
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes == null || parameterTypes.length == 0) {
                return true;
            }
        }
        c.e("IPC.ReflectUtil", "check failed: no non-params constructor.  class:%s, stack:%s", cls.getName(), new a());
        return false;
    }

    public static Object b(Class cls) {
        if (cls == null) {
            c.b("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e16) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e16);
            return null;
        } catch (InstantiationException e17) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e17);
            return null;
        } catch (NoSuchMethodException e18) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e18);
            return null;
        } catch (InvocationTargetException e19) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e19);
            return null;
        }
    }

    public static Object a(String str, Class cls) {
        if (str == null || str.length() == 0) {
            c.b("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
            return null;
        }
        if (cls == null) {
            c.b("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
            return null;
        }
        try {
            Class<?> cls2 = Class.forName(str);
            if (!cls.isAssignableFrom(cls2)) {
                c.b("IPC.ReflectUtil", "%s isAssignableFrom %s return false", cls, cls2);
                return null;
            }
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException e16) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e16);
            return null;
        } catch (IllegalAccessException e17) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e17);
            return null;
        } catch (InstantiationException e18) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e18);
            return null;
        } catch (NoSuchMethodException e19) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e19);
            return null;
        } catch (InvocationTargetException e26) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e26);
            return null;
        }
    }

    public static Object a(Class cls, Class cls2) {
        if (cls == null) {
            c.b("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
            return null;
        }
        if (cls2 == null) {
            c.b("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
            return null;
        }
        try {
            if (!cls2.isAssignableFrom(cls)) {
                c.b("IPC.ReflectUtil", "%s isAssignableFrom %s return false", cls2, cls);
                return null;
            }
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e16) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e16);
            return null;
        } catch (InstantiationException e17) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e17);
            return null;
        } catch (NoSuchMethodException e18) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e18);
            return null;
        } catch (InvocationTargetException e19) {
            c.b("IPC.ReflectUtil", "reflect error : %s", e19);
            return null;
        }
    }
}
