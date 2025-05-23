package com.tencent.mobileqq.commonutils.classloader;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
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
/* loaded from: classes5.dex */
public class SystemClassLoaderInjector {
    public static final String SUCCESS = "Success";
    private static final String TAG = "SystemLoaderInjector";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class SpeedyDexClassLoader extends BaseDexClassLoader {
        public SpeedyDexClassLoader(String str, File file, String str2, ClassLoader classLoader) {
            super(str, null, str2, classLoader);
        }
    }

    protected static Object appendArray(Object obj, Object obj2, boolean z16) {
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

    public static Object combineArray(Object obj, Object obj2, boolean z16) {
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

    public static Object getDexElements(Object obj) throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        return getField(obj, obj.getClass(), "dexElements");
    }

    private static Object getField(Object obj, Class<?> cls, String str) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static PathClassLoader getPathClassLoader(Context context) {
        ClassLoader classLoader = context.getClassLoader();
        ClassLoader classLoader2 = context.getClass().getClassLoader();
        if (classLoader != classLoader2) {
            Log.w(TAG, "getPathClassLoader use app classloader. appClassLoader=" + classLoader2);
            return (PathClassLoader) classLoader2;
        }
        return (PathClassLoader) classLoader;
    }

    public static Object getPathList(Object obj) throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return getField(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }

    public static String inject(Context context, String str, String str2, boolean z16) {
        return inject(context, str, (String) null, str2, z16);
    }

    @SuppressLint({"NewApi"})
    private static String injectAboveEqualApiLevel14(Context context, String str, String str2, boolean z16, boolean z17) {
        return injectAboveEqualApiLevel14(context, str, null, str2, z16, z17);
    }

    @TargetApi(14)
    private static String injectBelowApiLevel14(Context context, String str, String str2, boolean z16) {
        PathClassLoader pathClassLoader = getPathClassLoader(context);
        DexClassLoader createDexClassLoader = DexClassLoaderUtil.createDexClassLoader(str, context.getDir("dex", 0).getAbsolutePath(), str, pathClassLoader);
        try {
            if (!TextUtils.isEmpty(str2)) {
                createDexClassLoader.loadClass(str2);
            }
            setField(pathClassLoader, PathClassLoader.class, "mPaths", appendArray(getField(pathClassLoader, PathClassLoader.class, "mPaths"), getField(createDexClassLoader, DexClassLoader.class, "mRawDexPath"), z16));
            setField(pathClassLoader, PathClassLoader.class, "mFiles", combineArray(getField(pathClassLoader, PathClassLoader.class, "mFiles"), getField(createDexClassLoader, DexClassLoader.class, "mFiles"), z16));
            setField(pathClassLoader, PathClassLoader.class, "mZips", combineArray(getField(pathClassLoader, PathClassLoader.class, "mZips"), getField(createDexClassLoader, DexClassLoader.class, "mZips"), z16));
            setField(pathClassLoader, PathClassLoader.class, "mDexs", combineArray(getField(pathClassLoader, PathClassLoader.class, "mDexs"), getField(createDexClassLoader, DexClassLoader.class, "mDexs"), z16));
            return "Success";
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "injectBelowApiLevel14 error: " + Log.getStackTraceString(th5);
        }
    }

    private static String injectForR(Context context, String str, String str2, String str3, boolean z16, boolean z17) {
        File file;
        PathClassLoader pathClassLoader = getPathClassLoader(context);
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
            Object pathList = getPathList(pathClassLoader);
            setField(pathList, pathList.getClass(), "dexElements", combineArray(getDexElements(getPathList(pathClassLoader)), makeDexElements(pathList, Collections.singletonList(new File(str)), file, pathClassLoader), z16));
            if (!TextUtils.isEmpty(str3)) {
                pathClassLoader.loadClass(str3);
            }
            Log.e(TAG, "[\u6ce8\u5165\u5b8c\u6210\u8c03\u7528] injectForR classLoader:" + pathClassLoader);
            return "Success";
        } catch (Throwable th5) {
            Log.e(TAG, NotificationCompat.CATEGORY_ERROR, th5);
            return "injectForR error: " + Log.getStackTraceString(th5);
        }
    }

    private static String injectInAliyunOs(Context context, String str, String str2, boolean z16) {
        PathClassLoader pathClassLoader = getPathClassLoader(context);
        new DexClassLoader(str, context.getDir("dex", 0).getAbsolutePath(), str, pathClassLoader);
        String replaceAll = new File(str).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
        try {
            Class<?> cls = Class.forName("dalvik.system.LexClassLoader");
            Object newInstance = cls.getConstructor(String.class, String.class, String.class, ClassLoader.class).newInstance(context.getDir("dex", 0).getAbsolutePath() + File.separator + replaceAll, context.getDir("dex", 0).getAbsolutePath(), str, pathClassLoader);
            Method method = cls.getMethod("loadClass", String.class);
            if (!TextUtils.isEmpty(str2)) {
                method.invoke(newInstance, str2);
            }
            setField(pathClassLoader, PathClassLoader.class, "mPaths", appendArray(getField(pathClassLoader, PathClassLoader.class, "mPaths"), getField(newInstance, cls, "mRawDexPath"), z16));
            setField(pathClassLoader, PathClassLoader.class, "mFiles", combineArray(getField(pathClassLoader, PathClassLoader.class, "mFiles"), getField(newInstance, cls, "mFiles"), z16));
            setField(pathClassLoader, PathClassLoader.class, "mZips", combineArray(getField(pathClassLoader, PathClassLoader.class, "mZips"), getField(newInstance, cls, "mZips"), z16));
            setField(pathClassLoader, PathClassLoader.class, "mLexs", combineArray(getField(pathClassLoader, PathClassLoader.class, "mLexs"), getField(newInstance, cls, "mDexs"), z16));
            return "Success";
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "injectInAliyunOs error: " + Log.getStackTraceString(th5);
        }
    }

    public static Object makeDexElements(Object obj, List<File> list, File file, ClassLoader classLoader) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method declaredMethod = obj.getClass().getDeclaredMethod("makeDexElements", List.class, File.class, List.class, ClassLoader.class);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(null, list, file, new ArrayList(), classLoader);
    }

    protected static Object removeElementFromArray(Object obj, int i3) {
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        if (i3 >= 0 && i3 < length) {
            Object newInstance = Array.newInstance(componentType, length - 1);
            int i16 = 0;
            for (int i17 = 0; i17 < length; i17++) {
                if (i17 != i3) {
                    Array.set(newInstance, i16, Array.get(obj, i17));
                    i16++;
                }
            }
            return newInstance;
        }
        return obj;
    }

    public static void setField(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    @SuppressLint({"NewApi"})
    private static String unloadDexAboveEqualApiLevel14(Context context, int i3) {
        PathClassLoader pathClassLoader = getPathClassLoader(context);
        try {
            Object removeElementFromArray = removeElementFromArray(getDexElements(getPathList(pathClassLoader)), i3);
            Object pathList = getPathList(pathClassLoader);
            setField(pathList, pathList.getClass(), "dexElements", removeElementFromArray);
            return "Success";
        } catch (Throwable th5) {
            return "unloadDexAboveEqualApiLevel14 error: " + Log.getStackTraceString(th5);
        }
    }

    @TargetApi(14)
    private static String unloadDexBelowApiLevel14(Context context, int i3) {
        PathClassLoader pathClassLoader = getPathClassLoader(context);
        try {
            setField(pathClassLoader, PathClassLoader.class, "mPaths", removeElementFromArray(getField(pathClassLoader, PathClassLoader.class, "mPaths"), i3));
            setField(pathClassLoader, PathClassLoader.class, "mFiles", removeElementFromArray(getField(pathClassLoader, PathClassLoader.class, "mFiles"), i3));
            setField(pathClassLoader, PathClassLoader.class, "mZips", removeElementFromArray(getField(pathClassLoader, PathClassLoader.class, "mZips"), i3));
            setField(pathClassLoader, PathClassLoader.class, "mDexs", removeElementFromArray(getField(pathClassLoader, PathClassLoader.class, "mDexs"), i3));
            return "Success";
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "unloadDexBelowApiLevel14 error: " + Log.getStackTraceString(th5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String unloadDexElement(Context context, int i3) {
        boolean z16;
        try {
            try {
                Class.forName("dalvik.system.LexClassLoader");
                return unloadDexInAliyunOs(context, i3);
            } catch (ClassNotFoundException unused) {
                Class.forName("dalvik.system.BaseDexClassLoader");
                z16 = true;
                if (z16) {
                }
            }
        } catch (ClassNotFoundException unused2) {
            z16 = false;
            if (z16) {
                return unloadDexBelowApiLevel14(context, i3);
            }
            return unloadDexAboveEqualApiLevel14(context, i3);
        }
    }

    private static String unloadDexInAliyunOs(Context context, int i3) {
        PathClassLoader pathClassLoader = getPathClassLoader(context);
        try {
            setField(pathClassLoader, PathClassLoader.class, "mPaths", removeElementFromArray(getField(pathClassLoader, PathClassLoader.class, "mPaths"), i3));
            setField(pathClassLoader, PathClassLoader.class, "mFiles", removeElementFromArray(getField(pathClassLoader, PathClassLoader.class, "mFiles"), i3));
            setField(pathClassLoader, PathClassLoader.class, "mZips", removeElementFromArray(getField(pathClassLoader, PathClassLoader.class, "mZips"), i3));
            setField(pathClassLoader, PathClassLoader.class, "mLexs", removeElementFromArray(getField(pathClassLoader, PathClassLoader.class, "mLexs"), i3));
            return "Success";
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "unloadDexInAliyunOs error: " + Log.getStackTraceString(th5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String inject(Context context, String str, String str2, String str3, boolean z16) {
        boolean z17;
        try {
            try {
                Class.forName("dalvik.system.LexClassLoader");
                return injectInAliyunOs(context, str, str3, z16);
            } catch (ClassNotFoundException unused) {
                Class.forName("dalvik.system.BaseDexClassLoader");
                z17 = true;
                if (z17) {
                }
            }
        } catch (ClassNotFoundException unused2) {
            z17 = false;
            if (z17) {
                return injectBelowApiLevel14(context, str, str3, z16);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return injectForR(context, str, str2, str3, z16, true);
            }
            return injectAboveEqualApiLevel14(context, str, str2, str3, z16, true);
        }
    }

    @SuppressLint({"NewApi"})
    private static String injectAboveEqualApiLevel14(Context context, String str, String str2, String str3, boolean z16, boolean z17) {
        ClassLoader speedyDexClassLoader;
        PathClassLoader pathClassLoader = getPathClassLoader(context);
        if (z17) {
            if (str2 == null) {
                str2 = context.getDir("dex", 0).getAbsolutePath();
            }
            speedyDexClassLoader = DexClassLoaderUtil.createDexClassLoader(str, str2, str, pathClassLoader);
        } else {
            speedyDexClassLoader = new SpeedyDexClassLoader(str, null, str, pathClassLoader);
            Log.i("loadInternal ", "use SpeedyDexClassLoader");
        }
        try {
            if (!TextUtils.isEmpty(str3)) {
                speedyDexClassLoader.loadClass(str3);
            }
            Object combineArray = combineArray(getDexElements(getPathList(pathClassLoader)), getDexElements(getPathList(speedyDexClassLoader)), z16);
            Object pathList = getPathList(pathClassLoader);
            setField(pathList, pathList.getClass(), "dexElements", combineArray);
            Log.e(TAG, "[\u6ce8\u5165\u5b8c\u6210\u8c03\u7528] injectAboveEqualApiLevel14 classLoader:" + pathClassLoader);
            return "Success";
        } catch (Throwable th5) {
            Log.e(TAG, NotificationCompat.CATEGORY_ERROR, th5);
            return "injectAboveEqualApiLevel14 error: " + Log.getStackTraceString(th5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String inject(Context context, String str, String str2, boolean z16, boolean z17) {
        boolean z18;
        try {
            try {
                Class.forName("dalvik.system.LexClassLoader");
                return injectInAliyunOs(context, str, str2, z16);
            } catch (ClassNotFoundException unused) {
                Class.forName("dalvik.system.BaseDexClassLoader");
                z18 = true;
                if (z18) {
                }
            }
        } catch (ClassNotFoundException unused2) {
            z18 = false;
            if (z18) {
                return injectBelowApiLevel14(context, str, str2, z16);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return injectForR(context, str, null, str2, z16, z17);
            }
            return injectAboveEqualApiLevel14(context, str, str2, z16, z17);
        }
    }
}
