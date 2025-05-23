package com.huawei.hms.hihealth.data;

import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MapValue extends aabq {
    public static final Parcelable.Creator<MapValue> CREATOR = new aabq.aab(MapValue.class);
    private static final double EPSILON = 1.0E-7d;

    @aaby(id = 6)
    private double doubleValue;

    @aaby(id = 2)
    @Deprecated
    private float floatValue;

    @aaby(id = 1)
    private final int format;

    @aaby(id = 3)
    private int intValue;

    @aaby(id = 5)
    private long longValue;

    @aaby(id = 4)
    private String strValue;

    public MapValue(int i3, double d16) {
        this.format = i3;
        this.doubleValue = d16;
    }

    public final double asDoubleValue() {
        boolean z16;
        if (this.format == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, "Format mismatch");
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
    public final float asFloatValue() {
        boolean z16;
        if (this.format == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, "Format mismatch");
        return this.floatValue;
    }

    public final int asIntValue() {
        boolean z16 = true;
        if (this.format != 1) {
            z16 = false;
        }
        Preconditions.checkState(z16, "Format mismatch");
        return this.intValue;
    }

    public final long asLongValue() {
        boolean z16;
        if (this.format == 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, "Format mismatch");
        return this.longValue;
    }

    public final String asStringValue() {
        boolean z16;
        if (this.format == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, "Format mismatch");
        return this.strValue;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MapValue) {
            MapValue mapValue = (MapValue) obj;
            int i3 = this.format;
            if (i3 == mapValue.format) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 5 && this.longValue == mapValue.longValue) {
                                return true;
                            }
                            return false;
                        }
                        String str = this.strValue;
                        if (str != null && str.equals(mapValue.strValue)) {
                            return true;
                        }
                        return false;
                    }
                    if (Math.abs(this.doubleValue - mapValue.doubleValue) < EPSILON) {
                        return true;
                    }
                    return false;
                }
                if (this.intValue == mapValue.intValue) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public int getFormat() {
        return this.format;
    }

    public int hashCode() {
        return (int) this.doubleValue;
    }

    public void setDoubleValue(Double d16) {
        this.doubleValue = d16.doubleValue();
    }

    @Deprecated
    public void setFloatValue(Float f16) {
        this.floatValue = f16.floatValue();
    }

    public String toString() {
        int i3 = this.format;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        return "unknown format";
                    }
                    return String.valueOf(this.longValue);
                }
                return String.valueOf(this.strValue);
            }
            return String.valueOf(this.doubleValue);
        }
        return String.valueOf(this.intValue);
    }

    @Deprecated
    public MapValue(int i3, float f16) {
        this.format = i3;
        this.floatValue = f16;
    }

    @aabw
    public MapValue(@aabv(id = 1) int i3, @aabv(id = 2) float f16, @aabv(id = 3) int i16, @aabv(id = 4) String str, @aabv(id = 5) long j3, @aabv(id = 6) double d16) {
        this.format = i3;
        this.floatValue = f16;
        this.intValue = i16;
        this.strValue = str;
        this.longValue = j3;
        this.doubleValue = d16;
    }

    public MapValue(int i3, int i16) {
        this.format = i3;
        this.intValue = i16;
    }

    public MapValue(int i3, long j3) {
        this.format = i3;
        this.longValue = j3;
    }

    public MapValue(int i3, String str) {
        this.format = i3;
        this.strValue = str;
    }
}
