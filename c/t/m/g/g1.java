package c.t.m.g;

/* compiled from: P */
/* loaded from: classes.dex */
public class g1 {
    public static void a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("object is null.");
        }
    }

    public static <T> T a(T t16, T t17) {
        a(t17);
        return t16 == null ? t17 : t16;
    }
}
