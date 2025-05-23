package com.tencent.mobileqq.app.compact;

import android.annotation.TargetApi;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            com.tencent.mobileqq.app.compact.c.a(com.tencent.mobileqq.app.compact.c.b(classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.compact.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static final class C7376b {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = com.tencent.mobileqq.app.compact.c.b(classLoader, "pathList").get(classLoader);
            List list = (List) com.tencent.mobileqq.app.compact.c.b(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            List list2 = (List) com.tencent.mobileqq.app.compact.c.b(obj, "systemNativeLibraryDirectories").get(obj);
            Method c16 = com.tencent.mobileqq.app.compact.c.c(obj, "makePathElements", List.class, File.class, List.class);
            ArrayList arrayList = new ArrayList();
            list.addAll(list2);
            Object[] objArr = (Object[]) c16.invoke(obj, list, null, arrayList);
            Field b16 = com.tencent.mobileqq.app.compact.c.b(obj, "nativeLibraryPathElements");
            b16.setAccessible(true);
            b16.set(obj, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static final class c {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = com.tencent.mobileqq.app.compact.c.b(classLoader, "pathList").get(classLoader);
            List list = (List) com.tencent.mobileqq.app.compact.c.b(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            List list2 = (List) com.tencent.mobileqq.app.compact.c.b(obj, "systemNativeLibraryDirectories").get(obj);
            Method c16 = com.tencent.mobileqq.app.compact.c.c(obj, "makePathElements", List.class);
            list.addAll(list2);
            Object[] objArr = (Object[]) c16.invoke(obj, list);
            Field b16 = com.tencent.mobileqq.app.compact.c.b(obj, "nativeLibraryPathElements");
            b16.setAccessible(true);
            b16.set(obj, objArr);
        }
    }

    @TargetApi(23)
    private static int a() {
        return Build.VERSION.PREVIEW_SDK_INT;
    }

    public static synchronized void b(ClassLoader classLoader, File file) throws Throwable {
        synchronized (b.class) {
            if (file != null) {
                if (file.exists()) {
                    int i3 = Build.VERSION.SDK_INT;
                    if ((i3 != 25 || a() == 0) && i3 <= 25) {
                        try {
                            C7376b.b(classLoader, file);
                        } catch (Throwable unused) {
                            a.b(classLoader, file);
                        }
                        return;
                    } else {
                        try {
                            c.b(classLoader, file);
                            return;
                        } catch (Throwable unused2) {
                            C7376b.b(classLoader, file);
                        }
                    }
                }
            }
        }
    }
}
