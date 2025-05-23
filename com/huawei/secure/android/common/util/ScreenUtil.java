package com.huawei.secure.android.common.util;

import android.app.Activity;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ScreenUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38022a = "ScreenUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final int f38023b = 524288;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class a implements PrivilegedAction {

        /* renamed from: a, reason: collision with root package name */
        Method f38024a;

        public a(Method method) {
            this.f38024a = method;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            Method method = this.f38024a;
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return null;
        }
    }

    private static void a(Activity activity, int i3) {
        if (activity != null && !activity.isFinishing()) {
            activity.getWindow().addFlags(i3);
        } else {
            LogsUtil.e("", "activity is null");
        }
    }

    private static void b(Activity activity, int i3) {
        if (activity != null && !activity.isFinishing()) {
            activity.getWindow().clearFlags(i3);
        } else {
            LogsUtil.e("", "activity is null");
        }
    }

    public static void disableScreenshots(Activity activity) {
        a(activity, 8192);
    }

    public static void enableScreenshots(Activity activity) {
        b(activity, 8192);
    }

    public static void hideOverlayWindows(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            try {
                Window window = activity.getWindow();
                Method declaredMethod = Class.forName("android.view.Window").getDeclaredMethod("addPrivateFlags", Integer.TYPE);
                AccessController.doPrivileged(new a(declaredMethod));
                declaredMethod.invoke(window, 524288);
            } catch (ClassNotFoundException unused) {
                LogsUtil.e(f38022a, "hideOverlayWindows ClassNotFoundException");
            } catch (IllegalAccessException unused2) {
                LogsUtil.e(f38022a, "hideOverlayWindows IllegalAccessException");
            } catch (NoSuchMethodException unused3) {
                LogsUtil.e(f38022a, "hideOverlayWindows NoSuchMethodException");
            } catch (InvocationTargetException unused4) {
                LogsUtil.e(f38022a, "hideOverlayWindows InvocationTargetException");
            }
        }
    }
}
