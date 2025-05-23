package com.tencent.commonsdk.soload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class SoDexClassLoader extends DexClassLoader {
    static IPatchRedirector $redirector_;

    public SoDexClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
        Object newInstance;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, classLoader);
            return;
        }
        try {
            File file = new File(str);
            File file2 = new File(str2);
            Object pathList = getPathList(this);
            Object pathList2 = getPathList(classLoader);
            Object dexElements = getDexElements(pathList2);
            Method declaredMethod = pathList2.getClass().getDeclaredMethod("loadDexFile", File.class, File.class);
            declaredMethod.setAccessible(true);
            DexFile dexFile = (DexFile) declaredMethod.invoke(null, file, file2);
            ZipFile zipFile = new ZipFile(file);
            Class<?> componentType = dexElements.getClass().getComponentType();
            try {
                try {
                    try {
                        componentType.getConstructors();
                        newInstance = componentType.getConstructor(File.class, File.class, DexFile.class).newInstance(file, file, dexFile);
                    } catch (Exception unused) {
                        newInstance = componentType.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class).newInstance(file, Boolean.FALSE, file, dexFile);
                    }
                } catch (Exception unused2) {
                    newInstance = componentType.getConstructor(File.class, Boolean.TYPE, ZipFile.class, DexFile.class).newInstance(file, Boolean.FALSE, zipFile, dexFile);
                }
            } catch (Exception unused3) {
                newInstance = componentType.getConstructor(File.class, ZipFile.class, DexFile.class).newInstance(file, zipFile, dexFile);
            }
            Object newInstance2 = Array.newInstance(componentType, 1);
            Array.set(newInstance2, 0, newInstance);
            setField(pathList, pathList2.getClass(), "dexElements", newInstance2);
        } catch (Throwable unused4) {
        }
    }

    public static Object getDexElements(Object obj) throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        return getField(obj, obj.getClass(), "dexElements");
    }

    public static Object getField(Object obj, Class<?> cls, String str) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object getPathList(Object obj) throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return getField(obj, BaseDexClassLoader.class, "pathList");
    }

    public static void setField(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }
}
