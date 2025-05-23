package g;

import android.os.Build;
import android.os.IBinder;
import android.os.WorkSource;
import g.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static List<d> f400997a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f400998b;

    /* renamed from: c, reason: collision with root package name */
    public static a f400999c;

    /* renamed from: d, reason: collision with root package name */
    public static g.c f401000d;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements c.b {
        @Override // g.c.b
        public final void a() {
        }

        @Override // g.c.b
        public final void a(Method method, Object[] objArr) {
            try {
                if (method.getName().equals("acquireWakeLock")) {
                    b.a(objArr);
                } else if (method.getName().equals("releaseWakeLock")) {
                    b.b(objArr);
                }
            } catch (Exception e16) {
                com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_PowerHooker", e16, "wakeLock dispatchListeners error", new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: g.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C10343b {

        /* renamed from: a, reason: collision with root package name */
        public IBinder f401001a;

        /* renamed from: b, reason: collision with root package name */
        public int f401002b;

        /* renamed from: c, reason: collision with root package name */
        public String f401003c;

        /* renamed from: d, reason: collision with root package name */
        public String f401004d;

        /* renamed from: e, reason: collision with root package name */
        public WorkSource f401005e;

        /* renamed from: f, reason: collision with root package name */
        public String f401006f;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class c {
        public static C10343b a(Object[] objArr) {
            C10343b c10343b;
            if (objArr == null) {
                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs args null", new Object[0]);
                return null;
            }
            int i3 = Build.VERSION.SDK_INT;
            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_PowerHooker", "createAcquireWakeLockArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(i3), Build.VERSION.CODENAME, Integer.valueOf(i3));
            int length = objArr.length;
            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_PowerHooker", "createAcquireWakeLockArgsAccordingToArgsLength: length:%s", Integer.valueOf(length));
            if (length != 4) {
                if (length != 5 && length != 6) {
                    if (objArr.length != 7) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs7 args length invalid : %d", Integer.valueOf(objArr.length));
                        return null;
                    }
                    c10343b = new C10343b();
                    Object obj = objArr[0];
                    if (!(obj instanceof IBinder)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs7 args idx 0 not IBinder, %s", obj);
                        return null;
                    }
                    c10343b.f401001a = (IBinder) obj;
                    Object obj2 = objArr[1];
                    if (!(obj2 instanceof Integer)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs7 args idx 1 not Integer, %s", obj2);
                        return null;
                    }
                    c10343b.f401002b = ((Integer) obj2).intValue();
                    Object obj3 = objArr[2];
                    if (obj3 != null && !(obj3 instanceof String)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs7 args idx 2 not String, %s", obj3);
                        return null;
                    }
                    c10343b.f401003c = (String) obj3;
                    Object obj4 = objArr[3];
                    if (obj4 != null && !(obj4 instanceof String)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs7 args idx 3 not String, %s", obj4);
                        return null;
                    }
                    c10343b.f401004d = (String) obj4;
                    Object obj5 = objArr[4];
                    if (obj5 != null && !(obj5 instanceof WorkSource)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs7 args idx 4 not WorkSource, %s", obj5);
                        return null;
                    }
                    c10343b.f401005e = (WorkSource) obj5;
                    if (objArr.length != 5) {
                        Object obj6 = objArr[5];
                        if (obj6 != null && !(obj6 instanceof String)) {
                            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs7 args idx 5 not String, %s", obj6);
                            return null;
                        }
                        c10343b.f401006f = (String) obj6;
                        Object obj7 = objArr[6];
                        if (obj7 != null && !(obj7 instanceof Integer)) {
                            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs7 args idx 7 not Integer, %d", obj6);
                            return null;
                        }
                        ((Integer) obj7).intValue();
                    }
                } else {
                    if (objArr.length != 6 && objArr.length != 5) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs6 args length invalid : %d", Integer.valueOf(objArr.length));
                        return null;
                    }
                    c10343b = new C10343b();
                    Object obj8 = objArr[0];
                    if (!(obj8 instanceof IBinder)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs6 args idx 0 not IBinder, %s", obj8);
                        return null;
                    }
                    c10343b.f401001a = (IBinder) obj8;
                    Object obj9 = objArr[1];
                    if (!(obj9 instanceof Integer)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs6 args idx 1 not Integer, %s", obj9);
                        return null;
                    }
                    c10343b.f401002b = ((Integer) obj9).intValue();
                    Object obj10 = objArr[2];
                    if (obj10 != null && !(obj10 instanceof String)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs6 args idx 2 not String, %s", obj10);
                        return null;
                    }
                    c10343b.f401003c = (String) obj10;
                    Object obj11 = objArr[3];
                    if (obj11 != null && !(obj11 instanceof String)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs6 args idx 3 not String, %s", obj11);
                        return null;
                    }
                    c10343b.f401004d = (String) obj11;
                    Object obj12 = objArr[4];
                    if (obj12 != null && !(obj12 instanceof WorkSource)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs6 args idx 4 not WorkSource, %s", obj12);
                        return null;
                    }
                    c10343b.f401005e = (WorkSource) obj12;
                    if (objArr.length != 5) {
                        Object obj13 = objArr[5];
                        if (obj13 != null && !(obj13 instanceof String)) {
                            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs6 args idx 5 not String, %s", obj13);
                            return null;
                        }
                        c10343b.f401006f = (String) obj13;
                    }
                }
            } else {
                if (objArr.length != 4) {
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs4 args length invalid : %d", Integer.valueOf(objArr.length));
                    return null;
                }
                c10343b = new C10343b();
                Object obj14 = objArr[2];
                if (obj14 != null && !(obj14 instanceof String)) {
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs6 args idx 2 not String, %s", obj14);
                    return null;
                }
                c10343b.f401003c = (String) obj14;
                Object obj15 = objArr[3];
                if (obj15 != null && !(obj15 instanceof WorkSource)) {
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs6 args idx 3 not WorkSource, %s", obj15);
                    return null;
                }
                c10343b.f401005e = (WorkSource) obj15;
                Object obj16 = objArr[0];
                if (obj16 instanceof Integer) {
                    c10343b.f401002b = ((Integer) obj16).intValue();
                    Object obj17 = objArr[1];
                    if (!(obj17 instanceof IBinder)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs6 args idx 1 not IBinder, %s", obj17);
                        return null;
                    }
                    c10343b.f401001a = (IBinder) obj17;
                } else if (obj16 instanceof IBinder) {
                    c10343b.f401001a = (IBinder) obj16;
                    Object obj18 = objArr[1];
                    if (!(obj18 instanceof Integer)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs4 args idx 1 not Integer, %s", obj18);
                        return null;
                    }
                    c10343b.f401002b = ((Integer) obj18).intValue();
                } else {
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createAcquireWakeLockArgs4 args idx 0 not IBinder an Integer, %s", obj16);
                    return null;
                }
            }
            return c10343b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface d {
        void a(IBinder iBinder, int i3, String str, String str2, WorkSource workSource, String str3);

        void onReleaseWakeLock(IBinder iBinder, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public IBinder f401007a;

        /* renamed from: b, reason: collision with root package name */
        public int f401008b;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class f {
        public static e a(Object[] objArr) {
            if (objArr == null) {
                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createReleaseWakeLockArgs args null", new Object[0]);
                return null;
            }
            int i3 = Build.VERSION.SDK_INT;
            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_PowerHooker", "createReleaseWakeLockArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(i3), Build.VERSION.CODENAME, Integer.valueOf(i3));
            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_PowerHooker", "createReleaseWakeLockArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
            if (objArr.length != 2) {
                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createReleaseWakeLockArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            e eVar = new e();
            Object obj = objArr[0];
            if (!(obj instanceof IBinder)) {
                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createReleaseWakeLockArgs2 args idx 0 not IBinder, %s", obj);
                return null;
            }
            eVar.f401007a = (IBinder) obj;
            Object obj2 = objArr[1];
            if (!(obj2 instanceof Integer)) {
                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "createReleaseWakeLockArgs2 args idx 1 not Integer, %s", obj2);
                return null;
            }
            eVar.f401008b = ((Integer) obj2).intValue();
            return eVar;
        }
    }

    static {
        a aVar = new a();
        f400999c = aVar;
        f401000d = new g.c("power", "android.os.IPowerManager", aVar);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<g.b$d>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List<g.b$d>, java.util.ArrayList] */
    public static void a(Object[] objArr) {
        C10343b a16 = c.a(objArr);
        if (a16 == null) {
            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "dispatchAcquireWakeLock AcquireWakeLockArgs null", new Object[0]);
            return;
        }
        synchronized (b.class) {
            for (int i3 = 0; i3 < f400997a.size(); i3++) {
                ((d) f400997a.get(i3)).a(a16.f401001a, a16.f401002b, a16.f401003c, a16.f401004d, a16.f401005e, a16.f401006f);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<g.b$d>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List<g.b$d>, java.util.ArrayList] */
    public static void b(Object[] objArr) {
        e a16 = f.a(objArr);
        if (a16 == null) {
            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_PowerHooker", "dispatchReleaseWakeLock AcquireWakeLockArgs null", new Object[0]);
            return;
        }
        synchronized (b.class) {
            for (int i3 = 0; i3 < f400997a.size(); i3++) {
                ((d) f400997a.get(i3)).onReleaseWakeLock(a16.f401007a, a16.f401008b);
            }
        }
    }
}
