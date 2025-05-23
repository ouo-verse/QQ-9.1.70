package ny3;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* compiled from: P */
    /* renamed from: ny3.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    private static class C10872a {

        /* renamed from: a, reason: collision with root package name */
        static volatile a f421589a = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final Object f421590a;

        public b(Object obj) {
            this.f421590a = obj;
        }

        private Throwable a(Throwable th5) {
            if (!(th5 instanceof UndeclaredThrowableException) && !(th5 instanceof InvocationTargetException)) {
                return th5;
            }
            Throwable cause = th5.getCause();
            if (cause == null) {
                return th5;
            }
            return a(cause);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            boolean z16;
            if ("reportSizeConfigurations".equals(method.getName())) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("ActivityRecordIssueHelper", 2, "reportSizeConfigurations invoke execute!");
                    }
                    return method.invoke(this.f421590a, objArr);
                } catch (Throwable th5) {
                    QLog.w("ActivityRecordIssueHelper", 1, "reportSizeConfigurations Throwable: ", th5);
                    if (ly3.b.a(th5, Class.forName("java.lang.IllegalArgumentException"))) {
                        Activity topActivity = Foreground.getTopActivity();
                        if (!my3.b.b().a().f() && !ly3.a.f415786a.booleanValue()) {
                            QLog.w("ActivityRecordIssueHelper", 1, "reportSizeConfigurations has IllegalArgumentException and isActivityRecordIssueHookFix is false");
                        } else {
                            if (com.tencent.qqperf.monitor.crash.tools.c.e(topActivity) != null) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            QLog.e("ActivityRecordIssueHelper", 1, "reportSizeConfigurations invoke find DestroyMsg result " + z16 + " at " + topActivity);
                            if (z16) {
                                return null;
                            }
                        }
                        throw a(th5);
                    }
                    QLog.e("ActivityRecordIssueHelper", 1, "reportSizeConfigurations hook not IllegalArgumentException, info:", th5);
                    throw a(th5);
                }
            }
            try {
                return method.invoke(this.f421590a, objArr);
            } finally {
                Throwable a16 = a(th5);
            }
        }
    }

    public static a a() {
        return C10872a.f421589a;
    }

    private void b() {
        try {
            Field declaredField = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj == null) {
                return;
            }
            d(obj);
        } catch (Throwable th5) {
            QLog.e("ActivityRecordIssueHelper", 1, "hookActivityManagerAtAndroid_7 failed!", th5);
        }
    }

    private void c() {
        try {
            Field declaredField = ActivityManager.class.getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj == null) {
                return;
            }
            d(obj);
        } catch (Throwable th5) {
            QLog.e("ActivityRecordIssueHelper", 1, "hookActivityManagerAtAndroid_8_9 failed!", th5);
        }
    }

    private boolean d(Object obj) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        Class<? super Object> superclass = obj.getClass().getSuperclass();
        if (superclass == null) {
            QLog.e("ActivityRecordIssueHelper", 1, "hook failed! singletonCls is null");
            return true;
        }
        Field declaredField = superclass.getDeclaredField("mInstance");
        declaredField.setAccessible(true);
        Object obj2 = declaredField.get(obj);
        Class<?> cls = Class.forName("android.app.IActivityManager");
        declaredField.set(obj, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new b(obj2)));
        QLog.i("ActivityRecordIssueHelper", 1, "hook success!");
        return false;
    }

    public void e() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 28 && i3 >= 26) {
            c();
            return;
        }
        if (i3 < 26 && i3 >= 24) {
            b();
            return;
        }
        QLog.w("ActivityRecordIssueHelper", 1, "initActivityRecordIssueSafeHook jump at Android " + i3);
    }
}
