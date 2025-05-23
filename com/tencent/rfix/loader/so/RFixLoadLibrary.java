package com.tencent.rfix.loader.so;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFixLoadLibrary {
    private static final String TAG = "RFixLoadLibrary";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class V14 {
        V14() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file, boolean z16) throws NoSuchFieldException, IllegalAccessException {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            Field findField = ShareReflectUtil.findField(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) findField.get(obj);
            ArrayList arrayList = new ArrayList(fileArr.length + 1);
            if (!z16) {
                arrayList.add(file);
            }
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            findField.set(obj, arrayList.toArray(new File[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class V23 {
        V23() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file, boolean z16) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            List list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (file.equals((File) it.next())) {
                    it.remove();
                    break;
                }
            }
            if (!z16) {
                list.add(0, file);
            }
            List list2 = (List) ShareReflectUtil.findField(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            ShareReflectUtil.findField(obj, "nativeLibraryPathElements").set(obj, (Object[]) ShareReflectUtil.findMethod(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class V25 {
        V25() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file, boolean z16) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            List list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (file.equals((File) it.next())) {
                    it.remove();
                    break;
                }
            }
            if (!z16) {
                list.add(0, file);
            }
            List list2 = (List) ShareReflectUtil.findField(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            ShareReflectUtil.findField(obj, "nativeLibraryPathElements").set(obj, (Object[]) ShareReflectUtil.findMethod(obj, "makePathElements", List.class).invoke(obj, arrayList));
        }
    }

    public static void installNativeLibraryPath(ClassLoader classLoader, File file) throws Throwable {
        modifyPathList(classLoader, file, false);
    }

    private static void modifyPathList(ClassLoader classLoader, File file, boolean z16) throws Throwable {
        if (file != null && file.exists()) {
            int i3 = Build.VERSION.SDK_INT;
            if ((i3 != 25 || Build.VERSION.PREVIEW_SDK_INT == 0) && i3 <= 25) {
                try {
                    V23.b(classLoader, file, z16);
                    return;
                } catch (Throwable th5) {
                    Log.e(TAG, "installNativeLibraryPath, v23 fail, sdk: " + Build.VERSION.SDK_INT + ", error: " + th5.getMessage() + ", try to fallback to V14");
                    V14.b(classLoader, file, z16);
                    return;
                }
            }
            try {
                V25.b(classLoader, file, z16);
                return;
            } catch (Throwable th6) {
                Log.e(TAG, "installNativeLibraryPath, v25 fail, sdk: " + Build.VERSION.SDK_INT + ", error: " + th6.getMessage() + ", try to fallback to V23");
                V23.b(classLoader, file, z16);
                return;
            }
        }
        Log.e(TAG, "installNativeLibraryPath, folder " + file + " is illegal");
    }

    public static void uninstallNativeLibraryPath(ClassLoader classLoader, File file) throws Throwable {
        modifyPathList(classLoader, file, true);
    }
}
