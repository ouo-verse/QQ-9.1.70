package javax.annotation.meta;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum When {
    ALWAYS,
    UNKNOWN,
    MAYBE,
    NEVER;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static When[] valuesCustom() {
        When[] valuesCustom = values();
        int length = valuesCustom.length;
        When[] whenArr = new When[length];
        System.arraycopy(valuesCustom, 0, whenArr, 0, length);
        return whenArr;
    }
}
