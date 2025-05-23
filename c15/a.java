package c15;

import android.app.Activity;
import cooperation.vip.common.VipClass;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f30238a;

    public static void a() {
        try {
            int i3 = VipClass.f391241c;
            Method method = VipClass.class.getMethod("getInstance", new Class[0]);
            method.setAccessible(true);
            f30238a = (a) method.invoke(null, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public static void b(Activity activity, String str) {
        a aVar = f30238a;
        if (aVar != null) {
            aVar.c(activity, str);
        }
    }

    public abstract void c(Activity activity, String str);
}
