package com.huawei.hms.hihealth.data;

import android.os.Parcelable;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aabz;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class RealTimeSamplePoint extends aabq {
    public static final Parcelable.Creator<RealTimeSamplePoint> CREATOR = new aabq.aab(RealTimeSamplePoint.class);

    @aaby(id = 2)
    private Map<String, Value> fieldValues;

    @aaby(id = 1)
    private DataType mDataType;

    /* loaded from: classes2.dex */
    public static class Builder {
        private DataType mDataType;
        private Map<String, Value> valuesMap = new HashMap();

        public RealTimeSamplePoint build() {
            return new RealTimeSamplePoint(this.mDataType, this.valuesMap);
        }

        public Builder setDataType(DataType dataType) {
            this.mDataType = dataType;
            return this;
        }

        public Builder setFieldValue(Field field, double d16) {
            Value value = new Value(field.getFormat());
            value.setDoubleValue(d16);
            this.valuesMap.put(field.toString(), value);
            return this;
        }

        public Builder setFieldValue(Field field, int i3) {
            Value value = new Value(field.getFormat());
            value.setIntValue(i3);
            this.valuesMap.put(field.toString(), value);
            return this;
        }

        public Builder setFieldValue(Field field, long j3) {
            Value value = new Value(field.getFormat());
            value.setLongValue(j3);
            this.valuesMap.put(field.toString(), value);
            return this;
        }

        public Builder setFieldValue(String str, double d16) {
            Value value = new Value(2);
            value.setDoubleValue(d16);
            this.valuesMap.put(Field.getFieldString(str, 2), value);
            return this;
        }

        public Builder setFieldValue(String str, int i3) {
            Value value = new Value(1);
            value.setIntValue(i3);
            this.valuesMap.put(Field.getFieldString(str, 1), value);
            return this;
        }

        public Builder setFieldValue(String str, long j3) {
            Value value = new Value(5);
            value.setLongValue(j3);
            this.valuesMap.put(Field.getFieldString(str, 5), value);
            return this;
        }
    }

    @aabw
    RealTimeSamplePoint(@aabv(id = 1) DataType dataType, @aabv(id = 2) Map<String, Value> map) {
        this.mDataType = dataType;
        this.fieldValues = map;
    }

    public DataType getDataType() {
        return this.mDataType;
    }

    public double getDoubleValue(Field field) {
        return getFieldValue(field.getName()).asDoubleValue();
    }

    public Value getFieldValue(Field field) {
        return getFieldValue(field.getName());
    }

    public Map<String, Value> getFieldValues() {
        return this.fieldValues;
    }

    public int getIntValue(Field field) {
        return getFieldValue(field.getName()).asIntValue();
    }

    public final String toString() {
        String str;
        StringBuilder aab2 = com.huawei.hms.health.aab.aab("RealTimeSamplePoint{");
        aab2.append(Arrays.toString(this.fieldValues.values().toArray()));
        StringBuilder aab3 = com.huawei.hms.health.aab.aab("[");
        DataType dataType = this.mDataType;
        if (dataType != null) {
            str = dataType.toString();
        } else {
            str = "NULL";
        }
        aab3.append(str);
        aab3.append("]}");
        aab2.append(aab3.toString());
        return String.format(Locale.ENGLISH, aab2.toString(), new Object[0]);
    }

    public Value getFieldValue(String str) {
        Map<String, Value> map;
        if (this.fieldValues.containsKey(str)) {
            map = this.fieldValues;
        } else if (this.fieldValues.containsKey(Field.getFieldString(str, 0))) {
            map = this.fieldValues;
            str = Field.getFieldString(str, 0);
        } else {
            if (!this.fieldValues.containsKey(Field.getFieldString(str, 1))) {
                DataType dataType = this.mDataType;
                if (dataType == null || !aabz.aaba(dataType.getFields()).booleanValue()) {
                    Value value = new Value(0);
                    this.fieldValues.put(str, value);
                    return value;
                }
                throw new IllegalArgumentException("Invalid field: " + str + " in dataType.");
            }
            map = this.fieldValues;
            str = Field.getFieldString(str, 1);
        }
        return map.get(str);
    }
}
