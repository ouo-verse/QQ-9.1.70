package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes23.dex */
public class JarReflectUtil {
    private static final String TAG = "JarReflectUtil";

    public static Object callSpecifiedMethod(Object obj, String str, boolean z16, Class[] clsArr, Object... objArr) {
        Method declaredMethod;
        Object invoke;
        QMLog.e(TAG, "reflect call: " + str);
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        try {
            if (!z16) {
                if (clsArr != null && clsArr.length != 0) {
                    declaredMethod = cls.getMethod(str, clsArr);
                }
                declaredMethod = cls.getMethod(str, new Class[0]);
            } else {
                if (clsArr != null && clsArr.length != 0) {
                    declaredMethod = cls.getDeclaredMethod(str, clsArr);
                }
                declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            }
            if (objArr != null && objArr.length != 0) {
                invoke = declaredMethod.invoke(obj, objArr);
                return invoke;
            }
            invoke = declaredMethod.invoke(obj, new Object[0]);
            return invoke;
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            QMLog.e(TAG, "IllegalAccessException: " + e16.getMessage());
            return null;
        } catch (NoSuchMethodException e17) {
            QMLog.e(TAG, "NoSuchMethodException: " + e17.getMessage());
            e17.printStackTrace();
            return null;
        } catch (NullPointerException e18) {
            e18.printStackTrace();
            QMLog.e(TAG, "NullPointerException: " + e18.getMessage());
            return null;
        } catch (InvocationTargetException e19) {
            QMLog.e(TAG, "InvocationTargetException: " + e19.getMessage());
            e19.printStackTrace();
            return null;
        }
    }

    public static Object callSpecifiedStaticMethod(String str, String str2, boolean z16, Class[] clsArr, Object... objArr) {
        Method declaredMethod;
        Object invoke;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (!z16) {
                if (clsArr != null && clsArr.length != 0) {
                    declaredMethod = cls.getMethod(str2, clsArr);
                }
                declaredMethod = cls.getMethod(str2, new Class[0]);
            } else {
                if (clsArr != null && clsArr.length != 0) {
                    declaredMethod = cls.getDeclaredMethod(str2, clsArr);
                    declaredMethod.setAccessible(true);
                }
                declaredMethod = cls.getDeclaredMethod(str2, new Class[0]);
                declaredMethod.setAccessible(true);
            }
            if (objArr != null && objArr.length != 0) {
                invoke = declaredMethod.invoke(null, objArr);
                return invoke;
            }
            invoke = declaredMethod.invoke(null, new Object[0]);
            return invoke;
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            QMLog.e(TAG, "ClassNotFoundException: " + e16.getMessage());
            return null;
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
            QMLog.e(TAG, "IllegalAccessException: " + e17.getMessage());
            return null;
        } catch (NoSuchMethodException e18) {
            e18.printStackTrace();
            QMLog.e(TAG, "NoSuchMethodException: " + e18.getMessage());
            return null;
        } catch (NullPointerException e19) {
            e19.printStackTrace();
            QMLog.e(TAG, "NullPointerException: " + e19.getMessage());
            return null;
        } catch (InvocationTargetException e26) {
            e26.printStackTrace();
            QMLog.e(TAG, "InvocationTargetException: " + e26.getMessage());
            return null;
        }
    }

    public static Object creatSpecifiedObject(String str, Class[] clsArr, Object... objArr) {
        Object newInstance;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (objArr != null && objArr.length != 0) {
                newInstance = cls.getConstructor(clsArr).newInstance(objArr);
                return newInstance;
            }
            newInstance = cls.newInstance();
            return newInstance;
        } catch (ClassNotFoundException e16) {
            QMLog.e(TAG, "ClassNotFoundException: " + e16.getMessage());
            e16.printStackTrace();
            return null;
        } catch (IllegalAccessException e17) {
            QMLog.e(TAG, "IllegalAccessException: " + e17.getMessage());
            e17.printStackTrace();
            return null;
        } catch (InstantiationException e18) {
            QMLog.e(TAG, "InstantiationException: " + e18.getMessage());
            e18.printStackTrace();
            return null;
        } catch (NoSuchMethodException e19) {
            QMLog.e(TAG, "NoSuchMethodException: " + e19.getMessage());
            e19.printStackTrace();
            return null;
        } catch (InvocationTargetException e26) {
            QMLog.e(TAG, "InvocationTargetException: " + e26.getMessage());
            e26.printStackTrace();
            return null;
        }
    }

    public static Object getClassSingleInstance(String str, String str2, Class[] clsArr, Object... objArr) {
        return callSpecifiedStaticMethod(str, str2, false, clsArr, objArr);
    }

    public static Field getField(Object obj, String str) {
        try {
            return obj.getClass().getDeclaredField(str);
        } catch (NoSuchFieldException e16) {
            QMLog.e(TAG, "fail filedName: " + str, e16);
            e16.printStackTrace();
            return null;
        }
    }

    public static Class[] getParamsClass(Class... clsArr) {
        Class[] clsArr2 = new Class[clsArr.length];
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            clsArr2[i3] = clsArr[i3];
        }
        return clsArr2;
    }

    public static Object getSpecifiedField(Object obj, String str, boolean z16) {
        Object obj2;
        Object obj3 = null;
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        try {
            if (!z16) {
                obj2 = cls.getField(str).get(obj);
            } else {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                obj2 = declaredField.get(obj);
            }
            obj3 = obj2;
            return obj3;
        } catch (IllegalAccessException e16) {
            QMLog.e(TAG, "IllegalAccessException: ");
            e16.printStackTrace();
            return obj3;
        } catch (NoSuchFieldException e17) {
            QMLog.e(TAG, "NoSuchFieldException: ");
            e17.printStackTrace();
            return obj3;
        }
    }

    public static Object getStaticField(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            return cls.getField(str2).get(cls);
        } catch (ClassNotFoundException e16) {
            QMLog.e(TAG, "ClassNotFoundException: ");
            e16.printStackTrace();
            return null;
        } catch (IllegalAccessException e17) {
            QMLog.e(TAG, "IllegalAccessException: ");
            e17.printStackTrace();
            return null;
        } catch (NoSuchFieldException e18) {
            QMLog.e(TAG, "NoSuchFieldException: ");
            e18.printStackTrace();
            return null;
        }
    }

    public static void setFieldOjbect(String str, String str2, Object obj, Object obj2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (ClassNotFoundException e16) {
            QMLog.e(TAG, "fail filedName: " + str2, e16);
            e16.printStackTrace();
        } catch (IllegalAccessException e17) {
            QMLog.e(TAG, "fail filedName: " + str2, e17);
            e17.printStackTrace();
        } catch (IllegalArgumentException e18) {
            QMLog.e(TAG, "fail filedName: " + str2, e18);
            e18.printStackTrace();
        } catch (NoSuchFieldException e19) {
            QMLog.e(TAG, "fail filedName: " + str2, e19);
            e19.printStackTrace();
        } catch (SecurityException e26) {
            QMLog.e(TAG, "fail filedName: " + str2, e26);
            e26.printStackTrace();
        }
    }
}
