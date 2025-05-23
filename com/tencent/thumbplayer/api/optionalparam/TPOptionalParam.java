package com.tencent.thumbplayer.api.optionalparam;

import androidx.annotation.NonNull;

/* loaded from: classes26.dex */
public class TPOptionalParam<T> {
    public static final String OPTIONAL_ID_BEFORE_PREFIX = "optional_id_before_";
    private final String mKey;
    private final T mValue;

    TPOptionalParam(@NonNull String str, @NonNull T t16) {
        this.mKey = str;
        this.mValue = t16;
    }

    public static TPOptionalParam<Boolean> buildBoolean(@NonNull String str, boolean z16) {
        return new TPOptionalParam<>(str, Boolean.valueOf(z16));
    }

    public static TPOptionalParam<Float> buildFloat(@NonNull String str, float f16) {
        return new TPOptionalParam<>(str, Float.valueOf(f16));
    }

    public static TPOptionalParam<Integer> buildInt(@NonNull String str, int i3) {
        return new TPOptionalParam<>(str, Integer.valueOf(i3));
    }

    public static TPOptionalParam<Long> buildLong(@NonNull String str, long j3) {
        return new TPOptionalParam<>(str, Long.valueOf(j3));
    }

    public static TPOptionalParam<Object> buildObject(String str, Object obj) {
        return new TPOptionalParam<>(str, obj);
    }

    public static TPOptionalParam<int[]> buildQueueInt(@NonNull String str, @NonNull int[] iArr) {
        return new TPOptionalParam<>(str, iArr);
    }

    public static TPOptionalParam<String[]> buildQueueString(@NonNull String str, @NonNull String[] strArr) {
        return new TPOptionalParam<>(str, strArr);
    }

    public static TPOptionalParam<String> buildString(@NonNull String str, @NonNull String str2) {
        return new TPOptionalParam<>(str, str2);
    }

    @NonNull
    public String getKey() {
        return this.mKey;
    }

    @NonNull
    public T getValue() {
        return this.mValue;
    }

    public boolean isBeforeOptionalParam() {
        return this.mKey.contains(OPTIONAL_ID_BEFORE_PREFIX);
    }

    public String toString() {
        T t16 = this.mValue;
        if (!(t16 instanceof Boolean) && !(t16 instanceof Integer) && !(t16 instanceof Float) && !(t16 instanceof String) && !(t16 instanceof Long)) {
            if (!(t16 instanceof int[]) && !(t16 instanceof String[])) {
                return "unknown";
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("type:");
            sb5.append(this.mValue.getClass());
            sb5.append(", key:");
            sb5.append(this.mKey);
            sb5.append(", value: {");
            T t17 = this.mValue;
            if (t17 instanceof Integer[]) {
                for (Integer num : (Integer[]) t17) {
                    sb5.append(num);
                    sb5.append(", ");
                }
            }
            T t18 = this.mValue;
            if (t18 instanceof String[]) {
                for (String str : (String[]) t18) {
                    sb5.append(str);
                    sb5.append(", ");
                }
            }
            sb5.append(" }");
            return sb5.toString();
        }
        return "type:" + this.mValue.getClass() + ", key:" + this.mKey + ", value:" + this.mValue;
    }
}
