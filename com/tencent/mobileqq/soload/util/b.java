package com.tencent.mobileqq.soload.util;

import android.annotation.TargetApi;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static File f288690a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            com.tencent.mobileqq.soload.util.c.a(com.tencent.mobileqq.soload.util.c.b(classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.soload.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private static final class C8601b {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = com.tencent.mobileqq.soload.util.c.b(classLoader, "pathList").get(classLoader);
            List list = (List) com.tencent.mobileqq.soload.util.c.b(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next()) || file.equals(b.f288690a)) {
                    it.remove();
                    QLog.d("SoLoadWidget.LoadLibraryUtil", 2, "dq libDirIt.remove() " + file.getAbsolutePath());
                    break;
                }
            }
            list.add(0, file);
            List list2 = (List) com.tencent.mobileqq.soload.util.c.b(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("SoLoadWidget.LoadLibraryUtil", 2, "systemLibDirs,size=" + list2.size());
            }
            Method c16 = com.tencent.mobileqq.soload.util.c.c(obj, "makePathElements", List.class, File.class, List.class);
            ArrayList arrayList = new ArrayList();
            list.addAll(list2);
            Object[] objArr = (Object[]) c16.invoke(obj, list, null, arrayList);
            Field b16 = com.tencent.mobileqq.soload.util.c.b(obj, "nativeLibraryPathElements");
            b16.setAccessible(true);
            b16.set(obj, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static final class c {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = com.tencent.mobileqq.soload.util.c.b(classLoader, "pathList").get(classLoader);
            List list = (List) com.tencent.mobileqq.soload.util.c.b(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next()) || file.equals(b.f288690a)) {
                    it.remove();
                    QLog.d("SoLoadWidget.LoadLibraryUtil", 2, "dq libDirIt.remove()" + file.getAbsolutePath());
                    break;
                }
            }
            list.add(0, file);
            List list2 = (List) com.tencent.mobileqq.soload.util.c.b(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            QLog.d("SoLoadWidget.LoadLibraryUtil", 2, "systemLibDirs,size=" + list2.size());
            Method c16 = com.tencent.mobileqq.soload.util.c.c(obj, "makePathElements", List.class);
            list.addAll(list2);
            Object[] objArr = (Object[]) c16.invoke(obj, list);
            Field b16 = com.tencent.mobileqq.soload.util.c.b(obj, "nativeLibraryPathElements");
            b16.setAccessible(true);
            b16.set(obj, objArr);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22070);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f288690a = null;
        }
    }

    @TargetApi(23)
    private static int b() {
        try {
            return Build.VERSION.PREVIEW_SDK_INT;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static synchronized boolean c(ClassLoader classLoader, File file) throws Throwable {
        synchronized (b.class) {
            boolean z16 = false;
            if (classLoader != null && file != null) {
                if (file.exists()) {
                    int i3 = Build.VERSION.SDK_INT;
                    if ((i3 == 25 && b() != 0) || i3 > 25) {
                        z16 = true;
                    }
                    if (z16) {
                        try {
                            try {
                                c.b(classLoader, file);
                            } catch (Throwable unused) {
                                a.b(classLoader, file);
                            }
                        } catch (Throwable unused2) {
                            C8601b.b(classLoader, file);
                        }
                        f288690a = file;
                        return true;
                    }
                    try {
                        C8601b.b(classLoader, file);
                    } catch (Throwable unused3) {
                        a.b(classLoader, file);
                    }
                    f288690a = file;
                    return true;
                }
            }
            QLog.e("SoLoadWidget.LoadLibraryUtil", 1, "classLoader or folder is illegal " + file);
            return false;
        }
    }
}
