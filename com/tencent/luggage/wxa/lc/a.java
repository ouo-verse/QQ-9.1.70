package com.tencent.luggage.wxa.lc;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lc.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6431a {

        /* renamed from: a, reason: collision with root package name */
        public static Object f133262a;

        /* renamed from: b, reason: collision with root package name */
        public static Handler f133263b;
    }

    public static boolean a() {
        if (C6431a.f133262a == null || C6431a.f133263b == null) {
            try {
                a((Application) z.c().getApplicationContext());
            } catch (Throwable th5) {
                w.b("MicroMsg.AppBrandProcessSuicideLogic.ActivityThreadHackDetector", "hack ActivityThread failed %s", th5);
            }
        }
        Handler handler = C6431a.f133263b;
        if (handler == null) {
            return false;
        }
        if (handler.hasMessages(100) || handler.hasMessages(126)) {
            return true;
        }
        return (Build.VERSION.SDK_INT == 28 && handler.hasMessages(160)) || handler.hasMessages(159);
    }

    public static void a(Application application) {
        Object a16 = a((Context) application);
        C6431a.f133262a = a16;
        Field declaredField = a16.getClass().getDeclaredField("mH");
        declaredField.setAccessible(true);
        C6431a.f133263b = (Handler) declaredField.get(a16);
    }

    public static Object a(Context context) {
        Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null) {
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        Object obj = field.get(context);
        Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }
}
