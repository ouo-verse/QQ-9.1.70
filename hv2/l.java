package hv2;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class l {
    public static <S extends dv2.a> String a(Class<S> cls) {
        if (cls == null) {
            return "";
        }
        while (cls != dv2.a.class) {
            Class<S> superclass = cls.getSuperclass();
            if (superclass == j.class) {
                return cls.getName();
            }
            cls = superclass;
        }
        return "";
    }
}
