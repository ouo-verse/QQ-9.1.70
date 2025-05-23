package g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import g.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f400986a;

    /* renamed from: b, reason: collision with root package name */
    public static C10342a f400987b;

    /* renamed from: c, reason: collision with root package name */
    public static g.c f400988c;

    /* renamed from: d, reason: collision with root package name */
    public static List<d> f400989d;

    /* compiled from: P */
    /* renamed from: g.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C10342a implements c.b {
        @Override // g.c.b
        public final void a() {
        }

        @Override // g.c.b
        public final void a(Method method, Object[] objArr) {
            try {
                if (!method.getName().equals("set") && !method.getName().equals("setRepeating") && !method.getName().equals("setInexactRepeating")) {
                    if (method.getName().equals("remove")) {
                        a.a(objArr);
                    }
                }
                a.b(objArr);
            } catch (Exception e16) {
                com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_AlarmHooker", e16, "alarm dispatchListeners error", new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public PendingIntent f400990a;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class c {
        public static b a(Object[] objArr) {
            b bVar;
            if (objArr == null) {
                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createCancelArgs args null", new Object[0]);
                return null;
            }
            int i3 = Build.VERSION.SDK_INT;
            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_AlarmHooker", "createCancelArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(i3), Build.VERSION.CODENAME, Integer.valueOf(i3));
            int length = objArr.length;
            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_AlarmHooker", "createCancelArgsAccordingToArgsLength: length:%s", Integer.valueOf(length));
            if (length != 1) {
                if (objArr.length != 2) {
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createCancelArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                    return null;
                }
                bVar = new b();
                Object obj = objArr[0];
                if (obj != null && !(obj instanceof PendingIntent)) {
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createCancelArgs2 args idx 0 not PendingIntent, %s", obj);
                    return null;
                }
                bVar.f400990a = (PendingIntent) obj;
            } else {
                if (objArr.length != 1) {
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createCancelArgs1 args length invalid : %d", Integer.valueOf(objArr.length));
                    return null;
                }
                bVar = new b();
                Object obj2 = objArr[0];
                if (obj2 != null && !(obj2 instanceof PendingIntent)) {
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createCancelArgs1 args idx 0 not PendingIntent, %s", obj2);
                    return null;
                }
                bVar.f400990a = (PendingIntent) obj2;
            }
            return bVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface d {
        void a(int i3, long j3, long j16, long j17, int i16, PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener);

        void onAlarmRemove(PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public int f400991a;

        /* renamed from: b, reason: collision with root package name */
        public long f400992b;

        /* renamed from: c, reason: collision with root package name */
        public long f400993c;

        /* renamed from: d, reason: collision with root package name */
        public long f400994d;

        /* renamed from: e, reason: collision with root package name */
        public int f400995e;

        /* renamed from: f, reason: collision with root package name */
        public PendingIntent f400996f;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class f {
        public static e a(Object[] objArr) {
            if (objArr == null) {
                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args null", new Object[0]);
                return null;
            }
            int i3 = Build.VERSION.SDK_INT;
            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_AlarmHooker", "createSetArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(i3), Build.VERSION.CODENAME, Integer.valueOf(i3));
            int length = objArr.length;
            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_AlarmHooker", "createSetArgsAccordingToArgsLength: length:%s", Integer.valueOf(length));
            if (length != 3) {
                if (length != 4) {
                    if (length != 6 && length != 7) {
                        if (length != 8) {
                            if (objArr.length != 11) {
                                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                            } else {
                                e eVar = new e();
                                Object obj = objArr[1];
                                if (!(obj instanceof Integer)) {
                                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 1 not Integer, %s", obj);
                                } else {
                                    eVar.f400991a = ((Integer) obj).intValue();
                                    Object obj2 = objArr[2];
                                    if (!(obj2 instanceof Long)) {
                                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 2 not Long, %s", obj2);
                                    } else {
                                        eVar.f400992b = ((Long) obj2).longValue();
                                        Object obj3 = objArr[3];
                                        if (!(obj3 instanceof Long)) {
                                            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 3 not Long, %s", obj3);
                                        } else {
                                            eVar.f400993c = ((Long) obj3).longValue();
                                            Object obj4 = objArr[4];
                                            if (!(obj4 instanceof Long)) {
                                                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 4 not Long, %s", obj4);
                                            } else {
                                                eVar.f400994d = ((Long) obj4).longValue();
                                                Object obj5 = objArr[5];
                                                if (!(obj5 instanceof Integer)) {
                                                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 5 not Integer, %s", obj5);
                                                } else {
                                                    eVar.f400995e = ((Integer) obj5).intValue();
                                                    Object obj6 = objArr[6];
                                                    if (obj6 != null && !(obj6 instanceof PendingIntent)) {
                                                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 6 not PendingIntent, %s", obj6);
                                                    } else {
                                                        eVar.f400996f = (PendingIntent) obj6;
                                                        return eVar;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (objArr.length != 8) {
                            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                        } else {
                            e eVar2 = new e();
                            Object obj7 = objArr[0];
                            if (!(obj7 instanceof Integer)) {
                                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 0 not Integer, %s", obj7);
                            } else {
                                eVar2.f400991a = ((Integer) obj7).intValue();
                                Object obj8 = objArr[1];
                                if (!(obj8 instanceof Long)) {
                                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 1 not Long, %s", obj8);
                                } else {
                                    eVar2.f400992b = ((Long) obj8).longValue();
                                    Object obj9 = objArr[2];
                                    if (!(obj9 instanceof Long)) {
                                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 2 not Long, %s", obj9);
                                    } else {
                                        eVar2.f400993c = ((Long) obj9).longValue();
                                        Object obj10 = objArr[3];
                                        if (!(obj10 instanceof Long)) {
                                            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 3 not Long, %s", obj10);
                                        } else {
                                            eVar2.f400994d = ((Long) obj10).longValue();
                                            Object obj11 = objArr[4];
                                            if (!(obj11 instanceof Integer)) {
                                                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 4 not Integer, %s", obj11);
                                            } else {
                                                eVar2.f400995e = ((Integer) obj11).intValue();
                                                Object obj12 = objArr[5];
                                                if (obj12 != null && !(obj12 instanceof PendingIntent)) {
                                                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 5 not PendingIntent, %s", obj12);
                                                } else {
                                                    eVar2.f400996f = (PendingIntent) obj12;
                                                    return eVar2;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (objArr.length != 7 && objArr.length != 6) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                    } else {
                        e eVar3 = new e();
                        Object obj13 = objArr[0];
                        if (!(obj13 instanceof Integer)) {
                            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 0 not Integer, %s", obj13);
                        } else {
                            eVar3.f400991a = ((Integer) obj13).intValue();
                            Object obj14 = objArr[1];
                            if (!(obj14 instanceof Long)) {
                                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 1 not Long, %s", obj14);
                            } else {
                                eVar3.f400992b = ((Long) obj14).longValue();
                                Object obj15 = objArr[2];
                                if (!(obj15 instanceof Long)) {
                                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 2 not Long, %s", obj15);
                                } else {
                                    eVar3.f400993c = ((Long) obj15).longValue();
                                    Object obj16 = objArr[3];
                                    if (!(obj16 instanceof Long)) {
                                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 3 not Long, %s", obj16);
                                    } else {
                                        eVar3.f400994d = ((Long) obj16).longValue();
                                        Object obj17 = objArr[4];
                                        if (obj17 != null && !(obj17 instanceof PendingIntent)) {
                                            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 4 not PendingIntent, %s", obj17);
                                        } else {
                                            eVar3.f400996f = (PendingIntent) obj17;
                                            return eVar3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (objArr.length != 4) {
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                } else {
                    e eVar4 = new e();
                    Object obj18 = objArr[0];
                    if (!(obj18 instanceof Integer)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 0 not Integer, %s", obj18);
                    } else {
                        eVar4.f400991a = ((Integer) obj18).intValue();
                        Object obj19 = objArr[1];
                        if (!(obj19 instanceof Long)) {
                            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 1 not Long, %s", obj19);
                        } else {
                            eVar4.f400992b = ((Long) obj19).longValue();
                            Object obj20 = objArr[2];
                            if (!(obj20 instanceof Long)) {
                                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 2 not Long, %s", obj20);
                            } else {
                                eVar4.f400994d = ((Long) obj20).longValue();
                                Object obj21 = objArr[3];
                                if (obj21 != null && !(obj21 instanceof PendingIntent)) {
                                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 3 not PendingIntent, %s", obj21);
                                } else {
                                    eVar4.f400996f = (PendingIntent) obj21;
                                    return eVar4;
                                }
                            }
                        }
                    }
                }
            } else if (objArr.length != 3) {
                com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
            } else {
                e eVar5 = new e();
                Object obj22 = objArr[0];
                if (!(obj22 instanceof Integer)) {
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 0 not Integer, %s", obj22);
                } else {
                    eVar5.f400991a = ((Integer) obj22).intValue();
                    Object obj23 = objArr[1];
                    if (!(obj23 instanceof Long)) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 1 not Long, %s", obj23);
                    } else {
                        eVar5.f400992b = ((Long) obj23).longValue();
                        Object obj24 = objArr[2];
                        if (obj24 != null && !(obj24 instanceof PendingIntent)) {
                            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "createSetArgs args idx 2 not PendingIntent, %s", obj24);
                        } else {
                            eVar5.f400996f = (PendingIntent) obj24;
                            return eVar5;
                        }
                    }
                }
            }
            return null;
        }
    }

    static {
        C10342a c10342a = new C10342a();
        f400987b = c10342a;
        f400988c = new g.c(NotificationCompat.CATEGORY_ALARM, "android.app.IAlarmManager", c10342a);
        f400989d = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<g.a$d>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List<g.a$d>, java.util.ArrayList] */
    public static void a(Object[] objArr) {
        b a16 = c.a(objArr);
        if (a16 == null) {
            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "dispatchCancel cancelArgs null", new Object[0]);
            return;
        }
        synchronized (a.class) {
            for (int i3 = 0; i3 < f400989d.size(); i3++) {
                ((d) f400989d.get(i3)).onAlarmRemove(a16.f400990a, null);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<g.a$d>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List<g.a$d>, java.util.ArrayList] */
    public static void b(Object[] objArr) {
        e a16 = f.a(objArr);
        if (a16 == null) {
            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_AlarmHooker", "dispatchSet setArgs null", new Object[0]);
            return;
        }
        synchronized (a.class) {
            for (int i3 = 0; i3 < f400989d.size(); i3++) {
                ((d) f400989d.get(i3)).a(a16.f400991a, a16.f400992b, a16.f400993c, a16.f400994d, a16.f400995e, a16.f400996f, null);
            }
        }
    }
}
