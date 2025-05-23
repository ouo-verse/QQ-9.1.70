package com.tencent.mobileqq.nativememorymonitor.library;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes15.dex */
public class Utils {
    static IPatchRedirector $redirector_;

    public Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static long getArtMethod(Class cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            Field declaredField = declaredMethod.getClass().getSuperclass().getDeclaredField("artMethod");
            declaredField.setAccessible(true);
            return ((Long) declaredField.get(declaredMethod)).longValue();
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return 0L;
        } catch (NoSuchFieldException e17) {
            e17.printStackTrace();
            return 0L;
        } catch (NoSuchMethodException e18) {
            e18.printStackTrace();
            return 0L;
        }
    }

    public static long getHiddenArtMethod(String str, String str2, Class<?>... clsArr) {
        try {
            Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(Class.forName(str), str2, clsArr);
            Field declaredField = method.getClass().getSuperclass().getDeclaredField("artMethod");
            declaredField.setAccessible(true);
            return ((Long) declaredField.get(method)).longValue();
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            return 0L;
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
            return 0L;
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
            return 0L;
        } catch (NoSuchMethodException e19) {
            e19.printStackTrace();
            return 0L;
        } catch (InvocationTargetException e26) {
            e26.printStackTrace();
            return 0L;
        }
    }

    public static void setFieldAccessible(String str, String str2) {
        try {
            ((Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(Class.forName(str), str2)).setAccessible(true);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
        } catch (NoSuchMethodException e18) {
            e18.printStackTrace();
        } catch (InvocationTargetException e19) {
            e19.printStackTrace();
        }
    }
}
