package com.tencent.mobileqq.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.tencent.commonsdk.classload.DexClassLoaderUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dd {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a extends BaseDexClassLoader {
        static IPatchRedirector $redirector_;

        public a(String str, File file, String str2, ClassLoader classLoader) {
            super(str, null, str2, classLoader);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, file, str2, classLoader);
            }
        }
    }

    private static Object a(Object obj, Object obj2, boolean z16) {
        int i3;
        Object obj3;
        Object obj4;
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        if (z16) {
            i3 = length;
        } else {
            i3 = 1;
        }
        if (z16) {
            length = 1;
        }
        int i16 = length + i3;
        Object newInstance = Array.newInstance(componentType, i16);
        for (int i17 = 0; i17 < i16; i17++) {
            if (i17 < i3) {
                if (z16) {
                    obj4 = Array.get(obj, i17);
                } else {
                    obj4 = obj2;
                }
                Array.set(newInstance, i17, obj4);
            } else {
                if (z16) {
                    obj3 = obj2;
                } else {
                    obj3 = Array.get(obj, i17 - i3);
                }
                Array.set(newInstance, i17, obj3);
            }
        }
        return newInstance;
    }

    public static Object b(Object obj, Object obj2, boolean z16) {
        int i3;
        Object obj3;
        Object obj4;
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        if (z16) {
            i3 = length;
        } else {
            i3 = length2;
        }
        if (z16) {
            length = length2;
        }
        int i16 = length + i3;
        Object newInstance = Array.newInstance(componentType, i16);
        for (int i17 = 0; i17 < i16; i17++) {
            if (i17 < i3) {
                if (z16) {
                    obj4 = obj;
                } else {
                    obj4 = obj2;
                }
                Array.set(newInstance, i17, Array.get(obj4, i17));
            } else {
                if (z16) {
                    obj3 = obj2;
                } else {
                    obj3 = obj;
                }
                Array.set(newInstance, i17, Array.get(obj3, i17 - i3));
            }
        }
        return newInstance;
    }

    public static Object c(Object obj) throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        return d(obj, obj.getClass(), "dexElements");
    }

    private static Object d(Object obj, Class<?> cls, String str) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object e(Object obj) throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return d(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String f(Context context, String str, String str2, String str3, boolean z16) {
        boolean z17;
        try {
            try {
                Class.forName("dalvik.system.LexClassLoader");
                return m(context, str, str3, z16);
            } catch (ClassNotFoundException unused) {
                Class.forName("dalvik.system.BaseDexClassLoader");
                z17 = true;
                if (z17) {
                }
            }
        } catch (ClassNotFoundException unused2) {
            z17 = false;
            if (z17) {
                return k(context, str, str3, z16);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return l(context, str, str2, str3, z16, true);
            }
            return i(context, str, str2, str3, z16, true);
        }
    }

    public static String g(Context context, String str, String str2, boolean z16) {
        return f(context, str, null, str2, z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h(Context context, String str, String str2, boolean z16, boolean z17) {
        boolean z18;
        try {
            try {
                Class.forName("dalvik.system.LexClassLoader");
                return m(context, str, str2, z16);
            } catch (ClassNotFoundException unused) {
                Class.forName("dalvik.system.BaseDexClassLoader");
                z18 = true;
                if (z18) {
                }
            }
        } catch (ClassNotFoundException unused2) {
            z18 = false;
            if (z18) {
                return k(context, str, str2, z16);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return l(context, str, null, str2, z16, z17);
            }
            return j(context, str, str2, z16, z17);
        }
    }

    @SuppressLint({"NewApi"})
    private static String i(Context context, String str, String str2, String str3, boolean z16, boolean z17) {
        ClassLoader classLoader;
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        if (z17) {
            if (str2 == null) {
                str2 = context.getDir("dex", 0).getAbsolutePath();
            }
            classLoader = DexClassLoaderUtil.createDexClassLoader(str, str2, str, context.getClassLoader());
        } else {
            a aVar = new a(str, null, str, context.getClassLoader());
            Log.i("loadInternal ", "use SpeedyDexClassLoader");
            classLoader = aVar;
        }
        try {
            if (!TextUtils.isEmpty(str3)) {
                classLoader.loadClass(str3);
            }
            Object b16 = b(c(e(pathClassLoader)), c(e(classLoader)), z16);
            Object e16 = e(pathClassLoader);
            o(e16, e16.getClass(), "dexElements", b16);
            Log.e("SystemLoaderInjector", "[\u6ce8\u5165\u5b8c\u6210\u8c03\u7528] injectAboveEqualApiLevel14 classLoader:" + pathClassLoader);
            return "Success";
        } catch (Throwable th5) {
            Log.e("SystemLoaderInjector", NotificationCompat.CATEGORY_ERROR, th5);
            return "injectAboveEqualApiLevel14 error: " + Log.getStackTraceString(th5);
        }
    }

    @SuppressLint({"NewApi"})
    private static String j(Context context, String str, String str2, boolean z16, boolean z17) {
        return i(context, str, null, str2, z16, z17);
    }

    @TargetApi(14)
    private static String k(Context context, String str, String str2, boolean z16) {
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        DexClassLoader createDexClassLoader = DexClassLoaderUtil.createDexClassLoader(str, context.getDir("dex", 0).getAbsolutePath(), str, context.getClassLoader());
        try {
            if (!TextUtils.isEmpty(str2)) {
                createDexClassLoader.loadClass(str2);
            }
            o(pathClassLoader, PathClassLoader.class, "mPaths", a(d(pathClassLoader, PathClassLoader.class, "mPaths"), d(createDexClassLoader, DexClassLoader.class, "mRawDexPath"), z16));
            o(pathClassLoader, PathClassLoader.class, "mFiles", b(d(pathClassLoader, PathClassLoader.class, "mFiles"), d(createDexClassLoader, DexClassLoader.class, "mFiles"), z16));
            o(pathClassLoader, PathClassLoader.class, "mZips", b(d(pathClassLoader, PathClassLoader.class, "mZips"), d(createDexClassLoader, DexClassLoader.class, "mZips"), z16));
            o(pathClassLoader, PathClassLoader.class, "mDexs", b(d(pathClassLoader, PathClassLoader.class, "mDexs"), d(createDexClassLoader, DexClassLoader.class, "mDexs"), z16));
            return "Success";
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "injectBelowApiLevel14 error: " + Log.getStackTraceString(th5);
        }
    }

    private static String l(Context context, String str, String str2, String str3, boolean z16, boolean z17) {
        File file;
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        if (z17) {
            if (str2 == null) {
                file = context.getDir("dex", 0);
            } else {
                file = new File(str2);
            }
        } else {
            file = null;
        }
        try {
            Object e16 = e(pathClassLoader);
            o(e16, e16.getClass(), "dexElements", b(c(e(pathClassLoader)), n(e16, Collections.singletonList(new File(str)), file, pathClassLoader), z16));
            if (!TextUtils.isEmpty(str3)) {
                pathClassLoader.loadClass(str3);
            }
            Log.e("SystemLoaderInjector", "[\u6ce8\u5165\u5b8c\u6210\u8c03\u7528] injectForR classLoader:" + pathClassLoader);
            return "Success";
        } catch (Throwable th5) {
            Log.e("SystemLoaderInjector", NotificationCompat.CATEGORY_ERROR, th5);
            return "injectForR error: " + Log.getStackTraceString(th5);
        }
    }

    private static String m(Context context, String str, String str2, boolean z16) {
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        new DexClassLoader(str, context.getDir("dex", 0).getAbsolutePath(), str, pathClassLoader);
        String replaceAll = new File(str).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
        try {
            Class<?> cls = Class.forName("dalvik.system.LexClassLoader");
            Object newInstance = cls.getConstructor(String.class, String.class, String.class, ClassLoader.class).newInstance(context.getDir("dex", 0).getAbsolutePath() + File.separator + replaceAll, context.getDir("dex", 0).getAbsolutePath(), str, pathClassLoader);
            Method method = cls.getMethod("loadClass", String.class);
            if (!TextUtils.isEmpty(str2)) {
                method.invoke(newInstance, str2);
            }
            o(pathClassLoader, PathClassLoader.class, "mPaths", a(d(pathClassLoader, PathClassLoader.class, "mPaths"), d(newInstance, cls, "mRawDexPath"), z16));
            o(pathClassLoader, PathClassLoader.class, "mFiles", b(d(pathClassLoader, PathClassLoader.class, "mFiles"), d(newInstance, cls, "mFiles"), z16));
            o(pathClassLoader, PathClassLoader.class, "mZips", b(d(pathClassLoader, PathClassLoader.class, "mZips"), d(newInstance, cls, "mZips"), z16));
            o(pathClassLoader, PathClassLoader.class, "mLexs", b(d(pathClassLoader, PathClassLoader.class, "mLexs"), d(newInstance, cls, "mDexs"), z16));
            return "Success";
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "injectInAliyunOs error: " + Log.getStackTraceString(th5);
        }
    }

    public static Object n(Object obj, List<File> list, File file, ClassLoader classLoader) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method declaredMethod = obj.getClass().getDeclaredMethod("makeDexElements", List.class, File.class, List.class, ClassLoader.class);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(null, list, file, new ArrayList(), classLoader);
    }

    public static void o(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }
}
