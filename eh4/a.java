package eh4;

import android.app.Application;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.utils.l;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Application f396286a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f396287b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f396288c = false;

    /* renamed from: d, reason: collision with root package name */
    private static volatile AtomicBoolean f396289d;

    a() {
    }

    public static void a(Application application) {
        l.i("ENV", "attachContext - " + application);
        f396286a = application;
    }

    public static Application b() {
        return BaseApplication.getContext();
    }

    public static boolean c() {
        boolean z16;
        if (f396289d == null) {
            synchronized (a.class) {
                if (f396289d == null && f396286a != null) {
                    if (f396286a.getApplicationInfo() != null && (f396286a.getApplicationInfo().flags & 2) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    f396289d = new AtomicBoolean(z16);
                }
            }
        }
        if (f396289d != null && f396289d.get()) {
            return true;
        }
        return false;
    }

    private static boolean d() {
        if (f396287b == null) {
            synchronized (a.class) {
                if (f396287b == null) {
                    String str = "";
                    InputStream inputStream = null;
                    try {
                        inputStream = b().getResources().getAssets().open("enable_debug_for_release.txt");
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        inputStream.close();
                        str = properties.getProperty("ENABLE_DEBUG_FOR_RELEASE", "");
                    } catch (Exception e16) {
                        l.i("ENV", e16.getMessage());
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e17) {
                            l.f("ENV", "isEnableDebugModeInRelease close stream error", e17);
                        }
                    }
                    f396287b = str;
                    f396288c = "true".equals(str);
                }
            }
        }
        return f396288c;
    }

    public static boolean e() {
        if (!c() && !d()) {
            return false;
        }
        return true;
    }
}
