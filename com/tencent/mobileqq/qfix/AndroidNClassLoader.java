package com.tencent.mobileqq.qfix;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes16.dex */
public class AndroidNClassLoader extends PathClassLoader {
    static ArrayList<DexFile> oldDexFiles = new ArrayList<>();
    PathClassLoader originClassLoader;

    AndroidNClassLoader(String str, PathClassLoader pathClassLoader) {
        super(str, pathClassLoader.getParent());
        this.originClassLoader = pathClassLoader;
    }

    private static AndroidNClassLoader createAndroidNClassLoader(PathClassLoader pathClassLoader) throws Exception {
        AndroidNClassLoader androidNClassLoader = new AndroidNClassLoader("", pathClassLoader);
        Object obj = ShareReflectUtil.findField(pathClassLoader, "pathList").get(pathClassLoader);
        ShareReflectUtil.findField(obj, "definingContext").set(obj, androidNClassLoader);
        ShareReflectUtil.findField(androidNClassLoader, "pathList").set(androidNClassLoader, obj);
        ArrayList arrayList = new ArrayList();
        Field findField = ShareReflectUtil.findField(obj, "dexElements");
        for (Object obj2 : (Object[]) findField.get(obj)) {
            DexFile dexFile = (DexFile) ShareReflectUtil.findField(obj2, "dexFile").get(obj2);
            arrayList.add(new File(dexFile.getName()));
            oldDexFiles.add(dexFile);
        }
        findField.set(obj, (Object[]) ShareReflectUtil.findMethod(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        return androidNClassLoader;
    }

    public static AndroidNClassLoader inject(PathClassLoader pathClassLoader, Application application) throws Exception {
        AndroidNClassLoader createAndroidNClassLoader = createAndroidNClassLoader(pathClassLoader);
        reflectPackageInfoClassloader(application, createAndroidNClassLoader);
        return createAndroidNClassLoader;
    }

    private static void reflectPackageInfoClassloader(Application application, ClassLoader classLoader) throws Exception {
        Context context = (Context) ShareReflectUtil.findField(application, "mBase").get(application);
        Object obj = ShareReflectUtil.findField(context, "mPackageInfo").get(context);
        Field findField = ShareReflectUtil.findField(obj, "mClassLoader");
        Thread.currentThread().setContextClassLoader(classLoader);
        findField.set(obj, classLoader);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> cls;
        if (str != null && (str.startsWith("com.tencent.mobileqq.qfix.") || str.startsWith("com.tencent.common.app.QFixApplicationImpl"))) {
            cls = this.originClassLoader.loadClass(str);
        } else {
            cls = null;
        }
        if (cls == null) {
            return super.findClass(str);
        }
        return cls;
    }
}
