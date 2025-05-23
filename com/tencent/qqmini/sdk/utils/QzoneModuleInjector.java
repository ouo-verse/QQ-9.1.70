package com.tencent.qqmini.sdk.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class QzoneModuleInjector {
    private static final String CLASS_LOADER_ALIYUN = "dalvik.system.LexClassLoader";
    private static final String CLASS_LOADER_BASE_DEX = "dalvik.system.BaseDexClassLoader";
    private static final String TAG = "QzoneModuleInjector";

    private static Object appendArray(Object obj, Object obj2, boolean z16) {
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        int i3 = length + 1;
        Object newInstance = Array.newInstance(componentType, i3);
        if (z16) {
            Array.set(newInstance, 0, obj2);
            for (int i16 = 1; i16 < i3; i16++) {
                Array.set(newInstance, i16, Array.get(obj, i16 - 1));
            }
        } else {
            for (int i17 = 0; i17 < i3; i17++) {
                if (i17 < length) {
                    Array.set(newInstance, i17, Array.get(obj, i17));
                } else {
                    Array.set(newInstance, i17, obj2);
                }
            }
        }
        return newInstance;
    }

    private static Object combineArray(Object obj, Object obj2, boolean z16) {
        if (z16) {
            obj2 = obj;
            obj = obj2;
        }
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2) + length;
        Object newInstance = Array.newInstance(componentType, length2);
        for (int i3 = 0; i3 < length2; i3++) {
            if (i3 < length) {
                Array.set(newInstance, i3, Array.get(obj, i3));
            } else {
                Array.set(newInstance, i3, Array.get(obj2, i3 - length));
            }
        }
        return newInstance;
    }

    private static Object getDexElements(Object obj) throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        return getField(obj, obj.getClass(), "dexElements");
    }

    private static Object getField(Object obj, Class<?> cls, String str) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static Object getPathList(Object obj) throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return getField(obj, Class.forName(CLASS_LOADER_BASE_DEX), "pathList");
    }

    private static boolean hasBaseDexClassLoader() {
        try {
            Class.forName(CLASS_LOADER_BASE_DEX);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean inject(Context context, ClassLoader classLoader, String str, String str2, boolean z16) throws Exception {
        Class cls;
        Class cls2;
        if (str == null || !new File(str).exists()) {
            return false;
        }
        if (isAliyunOs()) {
            if (classLoader instanceof PathClassLoader) {
                cls2 = PathClassLoader.class;
            } else {
                cls2 = DexClassLoader.class;
            }
            injectInAliyunOs(context, classLoader, cls2, str, str2, z16);
            return true;
        }
        if (!hasBaseDexClassLoader()) {
            if (classLoader instanceof PathClassLoader) {
                cls = PathClassLoader.class;
            } else {
                cls = DexClassLoader.class;
            }
            injectBelowApiLevel14(context, classLoader, cls, str, str2, z16);
        } else {
            injectAboveEqualApiLevel14(context, classLoader, str, str2, z16);
        }
        return true;
    }

    private static void injectAboveEqualApiLevel14(Context context, ClassLoader classLoader, String str, String str2, boolean z16) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        QMLog.d(TAG, "injectAboveEqualApiLevel14, libPathL:" + str);
        Object combineArray = combineArray(getDexElements(getPathList(classLoader)), getDexElements(getPathList(new DexClassLoader(str, context.getDir("dex", 0).getAbsolutePath(), str, context.getClassLoader()))), z16);
        Object pathList = getPathList(classLoader);
        setField(pathList, pathList.getClass(), "dexElements", combineArray);
        if (!TextUtils.isEmpty(str2)) {
            classLoader.loadClass(str2);
        }
    }

    private static void injectBelowApiLevel14(Context context, ClassLoader classLoader, Class cls, String str, String str2, boolean z16) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        DexClassLoader dexClassLoader = new DexClassLoader(str, context.getDir("dex", 0).getAbsolutePath(), str, context.getClassLoader());
        if (!TextUtils.isEmpty(str2)) {
            dexClassLoader.loadClass(str2);
        }
        if (classLoader instanceof PathClassLoader) {
            setField(classLoader, cls, "mPaths", appendArray(getField(classLoader, cls, "mPaths"), getField(dexClassLoader, DexClassLoader.class, "mRawDexPath"), z16));
        }
        setField(classLoader, cls, "mFiles", combineArray(getField(classLoader, cls, "mFiles"), getField(dexClassLoader, DexClassLoader.class, "mFiles"), z16));
        setField(classLoader, cls, "mZips", combineArray(getField(classLoader, cls, "mZips"), getField(dexClassLoader, DexClassLoader.class, "mZips"), z16));
        setField(classLoader, cls, "mDexs", combineArray(getField(classLoader, cls, "mDexs"), getField(dexClassLoader, DexClassLoader.class, "mDexs"), z16));
        if (!TextUtils.isEmpty(str2)) {
            classLoader.loadClass(str2);
        }
    }

    private static void injectInAliyunOs(Context context, ClassLoader classLoader, Class cls, String str, String str2, boolean z16) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        new DexClassLoader(str, context.getDir("dex", 0).getAbsolutePath(), str, classLoader);
        String replaceAll = new File(str).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
        Class<?> cls2 = Class.forName(CLASS_LOADER_ALIYUN);
        Object newInstance = cls2.getConstructor(String.class, String.class, String.class, ClassLoader.class).newInstance(context.getDir("dex", 0).getAbsolutePath() + File.separator + replaceAll, context.getDir("dex", 0).getAbsolutePath(), str, classLoader);
        if (!TextUtils.isEmpty(str2)) {
            cls2.getMethod("loadClass", String.class).invoke(newInstance, str2);
        }
        if (classLoader instanceof PathClassLoader) {
            setField(classLoader, cls, "mPaths", appendArray(getField(classLoader, cls, "mPaths"), getField(newInstance, cls2, "mRawDexPath"), z16));
        }
        setField(classLoader, cls, "mFiles", combineArray(getField(classLoader, cls, "mFiles"), getField(newInstance, cls2, "mFiles"), z16));
        setField(classLoader, cls, "mZips", combineArray(getField(classLoader, cls, "mZips"), getField(newInstance, cls2, "mZips"), z16));
        setField(classLoader, cls, "mLexs", combineArray(getField(classLoader, cls, "mLexs"), getField(newInstance, cls2, "mDexs"), z16));
    }

    private static boolean isAliyunOs() {
        try {
            Class.forName(CLASS_LOADER_ALIYUN);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Object removeElementFromArray(Object obj, int i3) {
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

    private static void setField(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    @SuppressLint({"NewApi"})
    private static String unloadDexAboveEqualApiLevel14(ClassLoader classLoader, int i3) {
        try {
            Object removeElementFromArray = removeElementFromArray(getDexElements(getPathList(classLoader)), i3);
            Object pathList = getPathList(classLoader);
            setField(pathList, pathList.getClass(), "dexElements", removeElementFromArray);
            return "Success";
        } catch (Throwable unused) {
            return "unloadDexAboveEqualApiLevel14 error: " + Log.getStackTraceString(null);
        }
    }

    @TargetApi(14)
    private static String unloadDexBelowApiLevel14(ClassLoader classLoader, Class cls, int i3) {
        try {
            if (classLoader instanceof PathClassLoader) {
                setField(classLoader, cls, "mPaths", removeElementFromArray(getField(classLoader, cls, "mPaths"), i3));
            }
            setField(classLoader, PathClassLoader.class, "mFiles", removeElementFromArray(getField(classLoader, cls, "mFiles"), i3));
            setField(classLoader, PathClassLoader.class, "mZips", removeElementFromArray(getField(classLoader, cls, "mZips"), i3));
            setField(classLoader, PathClassLoader.class, "mDexs", removeElementFromArray(getField(classLoader, cls, "mDexs"), i3));
            return "Success";
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "unloadDexBelowApiLevel14 error: " + Log.getStackTraceString(th5);
        }
    }

    public static String unloadDexElement(ClassLoader classLoader, int i3) {
        Class<PathClassLoader> cls = PathClassLoader.class;
        if (isAliyunOs()) {
            if (!(classLoader instanceof PathClassLoader)) {
                cls = DexClassLoader.class;
            }
            return unloadDexInAliyunOs(classLoader, cls, 0);
        }
        if (!hasBaseDexClassLoader()) {
            try {
                if (!(classLoader instanceof PathClassLoader)) {
                    cls = DexClassLoader.class;
                }
                return unloadDexBelowApiLevel14(classLoader, cls, 0);
            } catch (Throwable th5) {
                Log.e(TAG, "fail to inject", th5);
                return "";
            }
        }
        return unloadDexAboveEqualApiLevel14(classLoader, 0);
    }

    private static String unloadDexInAliyunOs(ClassLoader classLoader, Class cls, int i3) {
        try {
            if (classLoader instanceof PathClassLoader) {
                setField(classLoader, cls, "mPaths", removeElementFromArray(getField(classLoader, cls, "mPaths"), i3));
            }
            setField(classLoader, PathClassLoader.class, "mFiles", removeElementFromArray(getField(classLoader, cls, "mFiles"), i3));
            setField(classLoader, PathClassLoader.class, "mZips", removeElementFromArray(getField(classLoader, cls, "mZips"), i3));
            setField(classLoader, PathClassLoader.class, "mLexs", removeElementFromArray(getField(classLoader, cls, "mLexs"), i3));
            return "Success";
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "unloadDexInAliyunOs error: " + Log.getStackTraceString(th5);
        }
    }
}
