package fk0;

import android.app.Application;
import android.util.DisplayMetrics;
import com.tencent.ecommerce.richtext.utils.e;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static Application f399703a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f399704b;

    public static Application a() {
        return f399703a;
    }

    public static DisplayMetrics b() {
        DisplayMetrics h16 = e.h();
        if (h16 != null) {
            return h16;
        }
        Application application = f399703a;
        if (application == null) {
            return null;
        }
        return application.getResources().getDisplayMetrics();
    }

    public static boolean c() {
        return f399704b;
    }

    public static void d(Application application) {
        f399703a = application;
        f399704b = application.getPackageManager().hasSystemFeature("oplus.feature.largescreen.land");
    }
}
