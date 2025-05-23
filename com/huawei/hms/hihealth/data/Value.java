package com.huawei.hms.hihealth.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabs;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aabz;
import com.huawei.hms.health.aacc;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Value extends aabq {
    public static final Parcelable.Creator<Value> CREATOR = new aabq.aab(Value.class);
    public static final double DOUBLE_DEFAULT_VALUE_FROM_PARCLE = -1.0d;
    private static final double DOUBLE_MARGIN = 1.0E-6d;
    private static final String MISMATCHED = "Mismatched format";
    private static final String MISMATCHED_FORMAT = "Mismatched format, Please check the data type definition.";
    private static final int RADIX = 10;
    private static final String TAG = "VALUE";
    private static final String VALUE_PARSE_ERROR = "value parse error, Please check the data type definition.";

    @aaby(id = 6)
    private double doubleValue;

    @aaby(id = 4)
    @Deprecated
    private float floatValue;

    @aaby(id = 1)
    private int format;

    @aaby(id = 2)
    private boolean hasSet;

    @aaby(id = 5)
    private Map<String, MapValue> mapValue;

    @aaby(id = 3)
    private String stringValue;

    public Value(int i3) {
        this.format = i3;
        this.hasSet = false;
        this.stringValue = null;
        this.floatValue = 0.0f;
        this.mapValue = new HashMap();
        this.doubleValue = 0.0d;
    }

    public String asActivityType() {
        return aacc.aab(asIntValue());
    }

    public double asDoubleValue() {
        boolean z16;
        if (this.format == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED);
        float f16 = this.floatValue;
        if (f16 != 0.0f) {
            double d16 = this.doubleValue;
            if (d16 == 0.0d || d16 == -1.0d) {
                this.doubleValue = Double.parseDouble(String.valueOf(f16));
            }
        }
        return this.doubleValue;
    }

    @Deprecated
    public float asFloatValue() {
        boolean z16;
        if (this.format == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED);
        return this.floatValue;
    }

    public int asIntValue() {
        boolean z16 = true;
        if (this.format != 1) {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED);
        float f16 = this.floatValue;
        if (f16 >= 0.0f) {
            return Float.floatToIntBits(f16);
        }
        return Double.valueOf(String.valueOf(f16)).intValue();
    }

    public String asLongToStringValue() {
        boolean z16;
        if (this.format == 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED);
        return this.stringValue;
    }

    public long asLongValue() {
        boolean z16;
        if (this.format == 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED);
        try {
            return Long.parseLong(this.stringValue, 10);
        } catch (NumberFormatException unused) {
            throw new IllegalStateException(VALUE_PARSE_ERROR);
        }
    }

    public String asStringValue() {
        boolean z16;
        if (this.format == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED);
        return this.stringValue;
    }

    public boolean equals(Object obj) {
        Object obj2;
        Object obj3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value)) {
            return false;
        }
        Value value = (Value) obj;
        int i3 = this.format;
        if (i3 != value.format || this.hasSet != value.hasSet) {
            return false;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            aabz.aab(TAG, "Invalid format");
                            return false;
                        }
                    } else {
                        obj2 = this.mapValue;
                        obj3 = value.mapValue;
                        return Objects.equal(obj2, obj3);
                    }
                }
                obj2 = this.stringValue;
                obj3 = value.stringValue;
                return Objects.equal(obj2, obj3);
            }
            if (Math.abs(this.doubleValue - value.doubleValue) < DOUBLE_MARGIN) {
                return true;
            }
            return false;
        }
        if (asIntValue() == value.asIntValue()) {
            return true;
        }
        return false;
    }

    public int getFormat() {
        return this.format;
    }

    public Map<String, MapValue> getMap() {
        boolean z16;
        if (this.format == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED);
        if (this.mapValue == null) {
            this.mapValue = new HashMap();
        }
        return this.mapValue;
    }

    public MapValue getMapValue(String str) {
        boolean z16;
        if (this.format == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED);
        Map<String, MapValue> map = this.mapValue;
        if (map != null && map.containsKey(str)) {
            return this.mapValue.get(str);
        }
        return null;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.floatValue), this.stringValue, this.mapValue, Double.valueOf(this.doubleValue));
    }

    public boolean isSet() {
        return this.hasSet;
    }

    public void removeMapValue(String str) {
        boolean z16;
        if (this.format == 0) {
            this.format = 4;
        }
        if (this.format == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED_FORMAT);
        Map<String, MapValue> map = this.mapValue;
        if (map != null) {
            map.remove(str);
        }
    }

    public void setActivityIndexValue(String str) {
        setIntValue(aacc.aab(str));
    }

    public void setDoubleValue(double d16) {
        boolean z16;
        if (this.format == 0) {
            this.format = 2;
        }
        if (this.format == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED_FORMAT);
        this.doubleValue = d16;
        this.hasSet = true;
    }

    @Deprecated
    public void setFloatValue(float f16) {
        if (this.format == 0) {
            this.format = 2;
        }
        if (this.format == 2) {
            this.floatValue = f16;
            this.hasSet = true;
            return;
        }
        throw new IllegalStateException(MISMATCHED_FORMAT);
    }

    public void setIntValue(int i3) {
        boolean z16;
        float parseFloat;
        if (this.format == 0) {
            this.format = 1;
        }
        if (this.format == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED_FORMAT);
        if (i3 >= 0) {
            parseFloat = Float.intBitsToFloat(i3);
        } else {
            parseFloat = Float.parseFloat(String.valueOf(i3));
        }
        this.floatValue = parseFloat;
        this.hasSet = true;
    }

    public void setKeyValue(String str, double d16) {
        if (this.format == 0) {
            this.format = 4;
        }
        Preconditions.checkState(this.format == 4, MISMATCHED_FORMAT);
        if (this.mapValue == null) {
            this.mapValue = new HashMap();
        }
        this.mapValue.put(str, new MapValue(2, d16));
        this.hasSet = true;
    }

    public void setLongValue(long j3) {
        boolean z16;
        if (this.format == 0) {
            this.format = 5;
        }
        if (this.format == 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED_FORMAT);
        this.stringValue = String.valueOf(j3);
        this.hasSet = true;
    }

    public void setStringValue(String str) {
        boolean z16;
        if (this.format == 0) {
            this.format = 3;
        }
        if (this.format == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, MISMATCHED_FORMAT);
        this.stringValue = str;
        this.hasSet = true;
    }

    public String toString() {
        if (!this.hasSet) {
            return "Value has not set";
        }
        int i3 = this.format;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return "Unidentified type";
                        }
                    } else {
                        return new TreeMap(this.mapValue).toString();
                    }
                }
                return this.stringValue;
            }
            double d16 = this.doubleValue;
            if (d16 != 0.0d) {
                return String.valueOf(d16);
            }
            return String.valueOf(this.floatValue);
        }
        return String.valueOf(asIntValue());
    }

    @Override // com.huawei.hms.health.aabq, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        com.huawei.hms.health.aab.aab("writeValueToParcel begin of ").append(Value.class.getName());
        if (this.format == 2) {
            if (this.floatValue == 0.0f && this.hasSet) {
                this.floatValue = (float) this.doubleValue;
            }
            float f16 = this.floatValue;
            if (f16 != 0.0f) {
                double d16 = this.doubleValue;
                if (d16 == 0.0d || d16 == -1.0d) {
                    this.doubleValue = Double.parseDouble(String.valueOf(f16));
                }
            }
        }
        aabs.aab(this, parcel, i3);
    }

    @aabw
    public Value(@aabv(id = 1) int i3, @aabv(id = 2) boolean z16, @aabv(id = 3) String str, @aabv(id = 4) float f16, @aabv(id = 5) Map<String, MapValue> map, @aabv(id = 6) double d16) {
        this.format = i3;
        this.hasSet = z16;
        this.stringValue = str;
        this.floatValue = f16;
        this.mapValue = map;
        this.doubleValue = d16;
    }

    @Deprecated
    public void setKeyValue(String str, float f16) {
        if (this.format == 0) {
            this.format = 4;
        }
        Preconditions.checkState(this.format == 4, MISMATCHED_FORMAT);
        if (this.mapValue == null) {
            this.mapValue = new HashMap();
        }
        this.mapValue.put(str, new MapValue(2, f16));
        this.hasSet = true;
    }

    public void setKeyValue(String str, int i3) {
        if (this.format == 0) {
            this.format = 4;
        }
        Preconditions.checkState(this.format == 4, MISMATCHED_FORMAT);
        if (this.mapValue == null) {
            this.mapValue = new HashMap();
        }
        this.mapValue.put(str, new MapValue(1, i3));
        this.hasSet = true;
    }

    public void setKeyValue(String str, long j3) {
        if (this.format == 0) {
            this.format = 4;
        }
        Preconditions.checkState(this.format == 4, MISMATCHED_FORMAT);
        if (this.mapValue == null) {
            this.mapValue = new HashMap();
        }
        this.mapValue.put(str, new MapValue(5, j3));
        this.hasSet = true;
    }

    public void setKeyValue(String str, String str2) {
        if (this.format == 0) {
            this.format = 4;
        }
        Preconditions.checkState(this.format == 4, MISMATCHED_FORMAT);
        if (this.mapValue == null) {
            this.mapValue = new HashMap();
        }
        this.mapValue.put(str, new MapValue(3, str2));
        this.hasSet = true;
    }
}
