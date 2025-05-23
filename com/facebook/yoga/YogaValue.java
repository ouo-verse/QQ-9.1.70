package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public class YogaValue {
    public final YogaUnit unit;
    public final float value;
    static final YogaValue UNDEFINED = new YogaValue(Float.NaN, YogaUnit.UNDEFINED);
    static final YogaValue ZERO = new YogaValue(0.0f, YogaUnit.POINT);
    static final YogaValue AUTO = new YogaValue(Float.NaN, YogaUnit.AUTO);

    /* compiled from: P */
    /* renamed from: com.facebook.yoga.YogaValue$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaUnit;

        static {
            int[] iArr = new int[YogaUnit.values().length];
            $SwitchMap$com$facebook$yoga$YogaUnit = iArr;
            try {
                iArr[YogaUnit.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.POINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public YogaValue(float f16, YogaUnit yogaUnit) {
        this.value = f16;
        this.unit = yogaUnit;
    }

    public static YogaValue parse(String str) {
        if (str == null) {
            return null;
        }
        if ("undefined".equals(str)) {
            return UNDEFINED;
        }
        if ("auto".equals(str)) {
            return AUTO;
        }
        if (str.endsWith("%")) {
            return new YogaValue(Float.parseFloat(str.substring(0, str.length() - 1)), YogaUnit.PERCENT);
        }
        return new YogaValue(Float.parseFloat(str), YogaUnit.POINT);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof YogaValue)) {
            return false;
        }
        YogaValue yogaValue = (YogaValue) obj;
        YogaUnit yogaUnit = this.unit;
        if (yogaUnit != yogaValue.unit) {
            return false;
        }
        if (yogaUnit != YogaUnit.UNDEFINED && yogaUnit != YogaUnit.AUTO && Float.compare(this.value, yogaValue.value) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value) + this.unit.intValue();
    }

    public String toString() {
        int i3 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.unit.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return "auto";
                    }
                    throw new IllegalStateException();
                }
                return this.value + "%";
            }
            return Float.toString(this.value);
        }
        return "undefined";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public YogaValue(float f16, int i3) {
        this(f16, YogaUnit.fromInt(i3));
    }
}
