package c.t.m.g;

/* compiled from: P */
/* loaded from: classes.dex */
public class q3 {
    public static boolean a(Object obj) {
        return obj == null;
    }

    public static boolean b(Object obj) {
        return obj != null;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null && obj2 == null;
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null || obj2 == null;
    }

    public static boolean a(Object obj, Object obj2, Object... objArr) {
        if (!a(objArr, obj2)) {
            return false;
        }
        for (Object obj3 : objArr) {
            if (obj3 != null) {
                return false;
            }
        }
        return true;
    }
}
