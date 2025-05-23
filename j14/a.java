package j14;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.support.annotation.NonNull;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends c {

    /* renamed from: c, reason: collision with root package name */
    private static Instrumentation f409133c;

    /* renamed from: d, reason: collision with root package name */
    private static Object f409134d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f409135e;

    /* renamed from: b, reason: collision with root package name */
    private boolean f409136b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class b extends Instrumentation {
        b() {
        }

        @Override // android.app.Instrumentation
        public void callActivityOnDestroy(@NonNull Activity activity) {
            a.f409133c.callActivityOnDestroy(activity);
            a.this.d(activity);
        }
    }

    public a(MemoryLeakInspector memoryLeakInspector) {
        super(memoryLeakInspector);
        this.f409136b = false;
    }

    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    private void f() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            f409134d = invoke;
            if (invoke != null) {
                Field declaredField = invoke.getClass().getDeclaredField("mInstrumentation");
                declaredField.setAccessible(true);
                Instrumentation instrumentation = (Instrumentation) declaredField.get(f409134d);
                if (instrumentation != null) {
                    if (instrumentation.getClass().equals(Instrumentation.class)) {
                        if (!instrumentation.getClass().equals(b.class)) {
                            f409133c = instrumentation;
                            Field declaredField2 = f409134d.getClass().getDeclaredField("mInstrumentation");
                            f409135e = declaredField2;
                            declaredField2.setAccessible(true);
                            return;
                        }
                        throw new RuntimeException("Buddy you already hacked the system.");
                    }
                    throw new IllegalStateException("Not an Instrumentation instance. Maybe something is modified in this system.");
                }
                throw new IllegalStateException("Failed to get mInstrumentation.");
            }
            throw new IllegalStateException("Failed to invoke currentActivityThread");
        } catch (Exception e16) {
            Logger.f365497g.c("RMonitor_MemoryLeak_ActivityIceWatcher", e16);
        }
    }

    private boolean g() {
        if (this.f409136b) {
            return false;
        }
        if (f409135e == null || f409134d == null) {
            f();
        }
        if (!h(new b())) {
            return false;
        }
        this.f409136b = true;
        return true;
    }

    private boolean h(Instrumentation instrumentation) {
        Object obj;
        try {
            Field field = f409135e;
            if (field != null && (obj = f409134d) != null) {
                field.set(obj, instrumentation);
                return true;
            }
            return false;
        } catch (IllegalAccessException e16) {
            Logger.f365497g.c("RMonitor_MemoryLeak_ActivityIceWatcher", e16);
            return false;
        }
    }

    @Override // i14.c
    public boolean a() {
        return g();
    }

    @Override // i14.c
    public void b() {
        if (f409133c != null && c()) {
            h(f409133c);
            this.f409136b = false;
        }
    }

    @Override // i14.b, i14.c
    public boolean c() {
        return !AndroidVersion.isOverIceScreamSandwich();
    }
}
