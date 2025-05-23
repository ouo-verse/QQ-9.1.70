package com.tencent.mobileqq.perf.memory.leak;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.util.ArrayMap;
import android.view.Choreographer;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.tools.p;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f257765a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f257766b;

    /* renamed from: c, reason: collision with root package name */
    static Field f257767c;

    /* renamed from: d, reason: collision with root package name */
    static boolean f257768d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47401);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f257765a = false;
        f257766b = false;
        f257767c = null;
        f257768d = false;
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            d(activity);
        }
        if (g.hasCacheInit) {
            d.f257770a.b(activity);
            c.f257769a.a(activity);
            f.f257774a.b(activity);
            p.a(activity, "ActivityLeakSolutionInner.fixActivityLeak");
        }
    }

    private static void c(Context context) {
        if (f257766b) {
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        try {
            Field declaredField = audioManager.getClass().getDeclaredField("mContext");
            declaredField.setAccessible(true);
            declaredField.set(audioManager, context.getApplicationContext());
        } catch (IllegalAccessException | IllegalArgumentException unused) {
        } catch (NoSuchFieldException unused2) {
            f257766b = true;
        }
    }

    private static void d(Activity activity) {
        QLog.w("ActivityLeakSolution", 1, "fixByReflect run");
        f(activity);
        c(activity);
        e(activity);
        j();
        i(activity);
        g(activity);
        h(activity);
    }

    private static void e(final Activity activity) {
        if (f257767c == null && !f257768d) {
            try {
                f257768d = true;
                Field declaredField = Choreographer.class.getDeclaredField("mContext");
                f257767c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
            }
        }
        if (f257767c != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.perf.memory.leak.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.k(activity);
                }
            });
        }
    }

    private static void f(Context context) {
        if (!f257765a) {
            f257765a = true;
            try {
                Method declaredMethod = Class.forName("android.sec.clipboard.ClipboardUIManager").getDeclaredMethod("getInstance", Context.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, context.getApplicationContext());
            } catch (ClassNotFoundException e16) {
                e16.printStackTrace();
            } catch (IllegalAccessException e17) {
                e17.printStackTrace();
            } catch (NoSuchMethodException e18) {
                e18.printStackTrace();
            } catch (InvocationTargetException e19) {
                e19.printStackTrace();
            }
        }
    }

    private static void g(Activity activity) {
        try {
            if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                Class<?> cls = Class.forName("android.gestureboost.GestureBoostManager");
                Field declaredField = cls.getDeclaredField("sGestureBoostManager");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(cls);
                Field declaredField2 = cls.getDeclaredField("mContext");
                declaredField2.setAccessible(true);
                if (declaredField2.get(obj) == activity) {
                    declaredField2.set(obj, activity.getApplicationContext());
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void h(Activity activity) {
        if (Build.VERSION.SDK_INT < 28 && activity != null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                if (invoke == null) {
                    return;
                }
                Field declaredField = cls.getDeclaredField("mOnPauseListeners");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(invoke);
                if (obj instanceof ArrayMap) {
                    ((ArrayMap) obj).remove(activity);
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void i(Activity activity) {
        try {
            if (Build.MANUFACTURER.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
                Object systemService = activity.getSystemService(Class.forName("com.samsung.android.content.clipboard.SemClipboardManager"));
                Field declaredField = systemService.getClass().getDeclaredField("mContext");
                declaredField.setAccessible(true);
                if (declaredField.get(systemService) == activity) {
                    declaredField.set(systemService, activity.getApplicationContext());
                }
                Class<?> cls = Class.forName("com.samsung.android.smartclip.SpenGestureManager");
                Field declaredField2 = cls.getDeclaredField("mContext");
                int modifiers = declaredField2.getModifiers();
                if ((modifiers | 8) == modifiers) {
                    declaredField2.setAccessible(true);
                    if (declaredField2.get(cls) == activity) {
                        declaredField2.set(cls, null);
                    }
                }
            }
        } catch (ClassNotFoundException e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
                QLog.i("ActivityLeakSolution", 2, e16.getMessage());
            }
        } catch (NoSuchFieldException e17) {
            if (QLog.isColorLevel()) {
                e17.printStackTrace();
                QLog.i("ActivityLeakSolution", 2, e17.getMessage());
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                th5.printStackTrace();
                QLog.i("ActivityLeakSolution", 2, th5.getMessage());
            }
        }
    }

    private static void j() {
        try {
            Field declaredField = Class.forName("android.text.TextLine").getDeclaredField("sCached");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj != null) {
                int length = Array.getLength(obj);
                for (int i3 = 0; i3 < length; i3++) {
                    Array.set(obj, i3, null);
                }
            }
        } catch (ClassNotFoundException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ActivityLeakSolution", 2, "e", e16);
            }
        } catch (IllegalAccessException e17) {
            if (QLog.isColorLevel()) {
                QLog.e("ActivityLeakSolution", 2, "e", e17);
            }
        } catch (IllegalArgumentException e18) {
            if (QLog.isColorLevel()) {
                QLog.e("ActivityLeakSolution", 2, "e", e18);
            }
        } catch (NoSuchFieldException e19) {
            if (QLog.isColorLevel()) {
                QLog.e("ActivityLeakSolution", 2, "e", e19);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(Activity activity) {
        try {
            f257767c.set(Choreographer.getInstance(), activity.getApplicationContext());
        } catch (Throwable unused) {
        }
    }
}
