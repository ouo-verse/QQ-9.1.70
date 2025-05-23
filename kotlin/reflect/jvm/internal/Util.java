package kotlin.reflect.jvm.internal;

/* compiled from: P */
/* loaded from: classes28.dex */
class Util {
    public static Object getEnumConstantByName(Class<? extends Enum<?>> cls, String str) {
        return Enum.valueOf(cls, str);
    }
}
