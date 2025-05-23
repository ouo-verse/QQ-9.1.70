package com.huawei.hms.hihealth.data;

import android.content.Intent;
import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabz;
import com.huawei.hms.health.aac;
import com.huawei.hms.health.aacu;
import java.math.BigDecimal;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SamplePoint implements Parcelable {
    private static final String APPID_SDKVER_CACHE = "sAppIdToSdkVersion";
    private static final String CALLING_APP_INFO_CLASS = "com.huawei.hms.hihealth.service.api.CallingAppInfo";
    public static final Parcelable.Creator<SamplePoint> CREATOR = new aab();
    private static final int INITIAL_ID = -1;
    private static final String PID_APPID_CACHE = "sAppIdCache";
    private static final String TAG = "SamplePoint";
    private DataCollector dataCollector;
    private int dataTypeId;
    private Map<String, Value> fieldValues;

    /* renamed from: id, reason: collision with root package name */
    private long f37301id;
    private long insertionTime;
    private boolean isMerged;
    private DataType mDataType;
    private String metadata;
    private int pushed;
    private DataCollector rawDataCollector;
    private long rawSamplingTime;
    private long samplingTime;
    private long startTime;

    /* loaded from: classes2.dex */
    public static class Builder {
        private DataCollector dataCollector;
        private int dataTypeId;

        /* renamed from: id, reason: collision with root package name */
        long f37302id;
        private boolean isMerged;
        private DataType mDataType;
        private String metadata;
        private int pushed;
        private DataCollector rawDataCollector;
        private long samplingTime;
        private long startTime;
        private final Map<String, Value> valuesMap;

        public Builder(DataCollector dataCollector) {
            this.dataCollector = dataCollector;
            this.valuesMap = new HashMap();
            this.f37302id = -1L;
            for (Field field : dataCollector.getDataType().getFields()) {
                this.valuesMap.put(field.toString(), new Value(field.getFormat()));
            }
        }

        public SamplePoint build() {
            return new SamplePoint(this.dataCollector, this.rawDataCollector, this.startTime, this.samplingTime, this.valuesMap, this.f37302id, this.isMerged, this.dataTypeId, this.pushed, this.metadata, this.mDataType, null);
        }

        public int getDataTypeId() {
            return this.dataTypeId;
        }

        public boolean isMerged() {
            return this.isMerged;
        }

        public Builder setActivityField(Field field, String str) {
            Value value = new Value(field.getFormat());
            value.setStringValue(str);
            this.valuesMap.put(field.toString(), value);
            return this;
        }

        public Builder setBlobFieldDoubleValue(Field field, Map<String, Double> map) {
            Value value = new Value(field.getFormat());
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                value.setKeyValue(entry.getKey(), entry.getValue().doubleValue());
            }
            this.valuesMap.put(field.toString(), value);
            return this;
        }

        @Deprecated
        public Builder setBlobFieldValue(Field field, Map<String, Float> map) {
            Value value = new Value(field.getFormat());
            for (Map.Entry<String, Float> entry : map.entrySet()) {
                value.setKeyValue(entry.getKey(), entry.getValue().floatValue());
            }
            this.valuesMap.put(field.toString(), value);
            return this;
        }

        public Builder setDataTypeId(int i3) {
            this.dataTypeId = i3;
            return this;
        }

        public Builder setFieldMapValue(Field field, Map<String, MapValue> map) {
            Value value = new Value(field.getFormat());
            for (Map.Entry<String, MapValue> entry : map.entrySet()) {
                int format = entry.getValue().getFormat();
                if (format == 1) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asIntValue());
                } else if (format == 2) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asDoubleValue());
                } else if (format == 3) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asStringValue());
                } else if (format == 5) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asLongValue());
                }
            }
            this.valuesMap.put(field.toString(), value);
            return this;
        }

        public Builder setFieldValue(Field field, double d16) {
            Value value = new Value(field.getFormat());
            value.setDoubleValue(d16);
            this.valuesMap.put(field.toString(), value);
            return this;
        }

        public Builder setFloatValueBatch(float... fArr) {
            throw new IllegalArgumentException("set value failed! This method is deprecated!");
        }

        public Builder setId(long j3) {
            this.f37302id = j3;
            return this;
        }

        public void setIntFieldValue(Field field, Map<String, Integer> map) {
            Value value = new Value(field.getFormat());
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                value.setKeyValue(entry.getKey(), entry.getValue().intValue());
            }
            this.valuesMap.put(field.toString(), value);
        }

        public Builder setIntValueBatch(int... iArr) {
            throw new IllegalArgumentException("set value failed! This method is deprecated!");
        }

        public Builder setMerged(boolean z16) {
            this.isMerged = z16;
            return this;
        }

        public Builder setMetadata(String str) {
            Preconditions.checkArgument(aacu.aabb(str), "SamplePoint mataData illegal");
            this.metadata = str;
            return this;
        }

        public Builder setPushed(int i3) {
            this.pushed = i3;
            return this;
        }

        public Builder setRawDataCollector(DataCollector dataCollector) {
            this.rawDataCollector = dataCollector;
            return this;
        }

        public Builder setSamplingTime(long j3, TimeUnit timeUnit) {
            boolean z16;
            boolean z17 = true;
            if (timeUnit != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "TimeUnit should not be null.");
            DataType dataType = this.mDataType;
            DataCollector dataCollector = this.dataCollector;
            if (dataCollector != null) {
                dataType = dataCollector.getDataType();
            }
            DataType dataType2 = dataType;
            if ((this.startTime == 0 || this.samplingTime == 0) && aac.aaba(dataType2) >= 2) {
                z17 = false;
            }
            Preconditions.checkState(z17, "This is an interval data type, the start time has not been set yet, Call setTimeInterval() instead.");
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            long convert = timeUnit2.convert(j3, timeUnit);
            long j16 = this.startTime;
            if (j16 == 0 || j16 == this.samplingTime) {
                j16 = convert;
            }
            SamplePoint.checkIntervalValidity(j16, convert, timeUnit2, dataType2);
            this.startTime = j16;
            this.samplingTime = convert;
            return this;
        }

        public Builder setTimeInterval(long j3, long j16, TimeUnit timeUnit) {
            boolean z16;
            DataType dataType = this.mDataType;
            DataCollector dataCollector = this.dataCollector;
            if (dataCollector != null) {
                dataType = dataCollector.getDataType();
            }
            SamplePoint.checkIntervalValidity(j3, j16, timeUnit, dataType);
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            this.startTime = timeUnit2.convert(j3, timeUnit);
            this.samplingTime = timeUnit2.convert(j16, timeUnit);
            boolean z17 = true;
            if (this.startTime > 1388505600000000000L) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkState(z16, "Start time must be later than default start time: 20140101 00:00:000");
            if (this.samplingTime < this.startTime) {
                z17 = false;
            }
            Preconditions.checkState(z17, "the start time must be less than the end time");
            return this;
        }

        public Builder(DataType dataType) {
            if (dataType == null || !(dataType.isPolymerized() || dataType.getName().startsWith("com.huawei.activity.feature"))) {
                aabz.aab(SamplePoint.TAG, "the dataType is illegal " + dataType);
                throw new IllegalStateException("only polymerized dataType can use this constructor, please use Builder(DataCollector) constructor");
            }
            this.mDataType = dataType;
            this.valuesMap = new HashMap();
            for (Field field : dataType.getFields()) {
                this.valuesMap.put(field.toString(), new Value(field.getFormat()));
            }
        }

        public Builder setBlobFieldDoubleValue(String str, Map<String, Double> map) {
            Value value = new Value(4);
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                value.setKeyValue(entry.getKey(), entry.getValue().doubleValue());
            }
            this.valuesMap.put(Field.getFieldString(str, 4), value);
            return this;
        }

        @Deprecated
        public Builder setBlobFieldValue(String str, Map<String, Float> map) {
            Value value = new Value(4);
            for (Map.Entry<String, Float> entry : map.entrySet()) {
                value.setKeyValue(entry.getKey(), entry.getValue().floatValue());
            }
            this.valuesMap.put(Field.getFieldString(str, 4), value);
            return this;
        }

        public Builder setFieldMapValue(String str, Map<String, MapValue> map) {
            Value value = new Value(4);
            for (Map.Entry<String, MapValue> entry : map.entrySet()) {
                int format = entry.getValue().getFormat();
                if (format == 1) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asIntValue());
                } else if (format == 2) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asDoubleValue());
                } else if (format == 3) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asStringValue());
                } else if (format == 5) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asLongValue());
                }
            }
            this.valuesMap.put(Field.getFieldString(str, 4), value);
            return this;
        }

        @Deprecated
        public Builder setFieldValue(Field field, float f16) {
            Value value = new Value(field.getFormat());
            value.setDoubleValue(new BigDecimal(String.valueOf(f16)).doubleValue());
            this.valuesMap.put(field.toString(), value);
            return this;
        }

        public void setIntFieldValue(String str, Map<String, Integer> map) {
            Value value = new Value(4);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                value.setKeyValue(entry.getKey(), entry.getValue().intValue());
            }
            this.valuesMap.put(Field.getFieldString(str, 4), value);
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

        public Builder setFieldValue(Field field, String str) {
            Value value = new Value(field.getFormat());
            value.setStringValue(str);
            this.valuesMap.put(field.toString(), value);
            return this;
        }

        public Builder setFieldValue(Field field, Map<String, Value> map) {
            Value value = new Value(field.getFormat());
            for (Map.Entry<String, Value> entry : map.entrySet()) {
                int format = entry.getValue().getFormat();
                if (format == 1) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asIntValue());
                } else if (format == 2) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asDoubleValue());
                } else if (format == 3) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asStringValue());
                } else if (format == 4) {
                    setFieldMapValue(field, entry.getValue().getMap());
                } else if (format == 5) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asLongValue());
                }
            }
            this.valuesMap.put(field.toString(), value);
            return this;
        }

        public Builder setFieldValue(String str, double d16) {
            Value value = new Value(2);
            value.setDoubleValue(d16);
            this.valuesMap.put(Field.getFieldString(str, 2), value);
            return this;
        }

        @Deprecated
        public Builder setFieldValue(String str, float f16) {
            Value value = new Value(2);
            value.setDoubleValue(new BigDecimal(String.valueOf(f16)).doubleValue());
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

        public Builder setFieldValue(String str, String str2) {
            Value value = new Value(3);
            value.setStringValue(str2);
            this.valuesMap.put(Field.getFieldString(str, 3), value);
            return this;
        }

        public Builder setFieldValue(String str, Map<String, Value> map) {
            Value value = new Value(4);
            for (Map.Entry<String, Value> entry : map.entrySet()) {
                int format = entry.getValue().getFormat();
                if (format == 1) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asIntValue());
                } else if (format == 2) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asDoubleValue());
                } else if (format == 3) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asStringValue());
                } else if (format == 4) {
                    setFieldMapValue(str, entry.getValue().getMap());
                } else if (format == 5) {
                    value.setKeyValue(entry.getKey(), entry.getValue().asLongValue());
                }
            }
            this.valuesMap.put(Field.getFieldString(str, 4), value);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    static class aab implements Parcelable.Creator<SamplePoint> {
        aab() {
        }

        @Override // android.os.Parcelable.Creator
        public SamplePoint createFromParcel(Parcel parcel) {
            return new SamplePoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SamplePoint[] newArray(int i3) {
            return new SamplePoint[i3];
        }
    }

    /* loaded from: classes2.dex */
    private static class aaba implements PrivilegedAction {
        private java.lang.reflect.Field aab;
        private java.lang.reflect.Field aaba;

        aaba(java.lang.reflect.Field field, java.lang.reflect.Field field2) {
            this.aab = field;
            this.aaba = field2;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            this.aab.setAccessible(true);
            this.aaba.setAccessible(true);
            return null;
        }
    }

    protected SamplePoint(DataCollector dataCollector) {
        this.rawSamplingTime = 0L;
        this.insertionTime = 0L;
        Preconditions.checkNotNull(dataCollector, "DataCollector cannot be null");
        this.dataCollector = dataCollector;
        List<Field> fields = dataCollector.getDataType().getFields();
        this.fieldValues = new HashMap(fields.size());
        for (Field field : fields) {
            this.fieldValues.put(field.toString(), new Value(field.getFormat()));
        }
    }

    public static Builder builder(DataCollector dataCollector) {
        Preconditions.checkNotNull(dataCollector, "DataCollector cannot be null");
        return new Builder(dataCollector);
    }

    public static SamplePoint create(DataCollector dataCollector) {
        return new SamplePoint(dataCollector);
    }

    @Deprecated
    public static SamplePoint extract(Intent intent) {
        return null;
    }

    public void addMetadata(String str, String str2) {
        JSONObject jSONObject;
        Preconditions.checkArgument(aacu.aabb(str), "metadata key illegal");
        Preconditions.checkArgument(aacu.aabb(str2), "metadata value illegal");
        try {
            if (TextUtils.isEmpty(this.metadata)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(this.metadata);
            }
            jSONObject.remove(str);
            jSONObject.put(str, str2);
            this.metadata = jSONObject.toString();
        } catch (JSONException unused) {
            aabz.aabb(TAG, "addMetadata catch JSONException");
            throw new IllegalArgumentException("addMetadata catch JSONException");
        }
    }

    public final void checkIntervalValidity() {
        checkIntervalValidity(this.startTime, this.samplingTime, TimeUnit.NANOSECONDS, getDataType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SamplePoint)) {
            return false;
        }
        SamplePoint samplePoint = (SamplePoint) obj;
        if (this.samplingTime == samplePoint.samplingTime && this.startTime == samplePoint.startTime && Objects.equal(this.dataCollector, samplePoint.dataCollector) && Objects.equal(this.fieldValues, samplePoint.fieldValues) && Objects.equal(this.rawDataCollector, samplePoint.rawDataCollector)) {
            return true;
        }
        return false;
    }

    public DataCollector getDataCollector() {
        return this.dataCollector;
    }

    public DataType getDataType() {
        DataCollector dataCollector = this.dataCollector;
        if (dataCollector == null) {
            return this.mDataType;
        }
        return dataCollector.getDataType();
    }

    public int getDataTypeId() {
        return this.dataTypeId;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return getSamplingTime(timeUnit);
    }

    public Value getFieldValue(Field field) {
        return getFieldValue(field.getName());
    }

    public Map<String, Value> getFieldValues() {
        return this.fieldValues;
    }

    public long getId() {
        return this.f37301id;
    }

    public long getInsertionTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.insertionTime, TimeUnit.NANOSECONDS);
    }

    public String getMetadata() {
        return this.metadata;
    }

    public final DataCollector getNullableRawCollector() {
        return this.rawDataCollector;
    }

    public int getPushed() {
        return this.pushed;
    }

    public final DataCollector getRawDataCollector() {
        DataCollector dataCollector = this.rawDataCollector;
        if (dataCollector == null) {
            return this.dataCollector;
        }
        return dataCollector;
    }

    public long getSamplingTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.samplingTime, TimeUnit.NANOSECONDS);
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime, TimeUnit.NANOSECONDS);
    }

    public final int hashCode() {
        return Objects.hashCode(this.dataCollector, Long.valueOf(this.samplingTime), Long.valueOf(this.startTime));
    }

    public boolean isMerged() {
        return this.isMerged;
    }

    public void setDataTypeId(int i3) {
        this.dataTypeId = i3;
    }

    public void setFieldMapValue(Field field, Map<String, MapValue> map) {
        Value value = new Value(field.getFormat());
        for (Map.Entry<String, MapValue> entry : map.entrySet()) {
            int format = entry.getValue().getFormat();
            if (format != 1) {
                if (format != 2) {
                    if (format != 3) {
                        if (format == 5) {
                            value.setKeyValue(entry.getKey(), entry.getValue().asLongValue());
                        }
                    } else {
                        value.setKeyValue(entry.getKey(), entry.getValue().asStringValue());
                    }
                } else {
                    value.setKeyValue(entry.getKey(), entry.getValue().asDoubleValue());
                }
            } else {
                value.setKeyValue(entry.getKey(), entry.getValue().asIntValue());
            }
        }
        this.fieldValues.put(field.toString(), value);
    }

    @Deprecated
    public final SamplePoint setFloatValues(float... fArr) {
        throw new IllegalArgumentException("set value failed! This method is deprecated!");
    }

    public void setId(long j3) {
        this.f37301id = j3;
    }

    public void setInsertionTime(long j3, TimeUnit timeUnit) {
        this.insertionTime = TimeUnit.NANOSECONDS.convert(j3, timeUnit);
    }

    @Deprecated
    public final SamplePoint setIntValues(int... iArr) {
        throw new IllegalArgumentException("set value failed! This method is deprecated!");
    }

    public void setMerged(boolean z16) {
        this.isMerged = z16;
    }

    public void setMetadata(String str) {
        Preconditions.checkArgument(aacu.aabb(str), "SamplePoint mataData illegal");
        this.metadata = str;
    }

    public void setPushed(int i3) {
        this.pushed = i3;
    }

    public final SamplePoint setSamplingTime(long j3, TimeUnit timeUnit) {
        boolean z16;
        boolean z17 = true;
        if (timeUnit != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkArgument(z16, "TimeUnit should not be null.");
        DataType dataType = this.mDataType;
        DataCollector dataCollector = this.dataCollector;
        if (dataCollector != null) {
            dataType = dataCollector.getDataType();
        }
        DataType dataType2 = dataType;
        if ((this.startTime == 0 || this.samplingTime == 0) && aac.aaba(dataType2) >= 2) {
            z17 = false;
        }
        Preconditions.checkState(z17, "This is an interval data type, the start time has not been set yet, Call setTimeInterval() instead.");
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        long convert = timeUnit2.convert(j3, timeUnit);
        long j16 = this.startTime;
        if (j16 == 0 || j16 == this.samplingTime) {
            j16 = convert;
        }
        checkIntervalValidity(j16, convert, timeUnit2, dataType2);
        this.startTime = j16;
        this.samplingTime = convert;
        return this;
    }

    public final SamplePoint setTimeInterval(long j3, long j16, TimeUnit timeUnit) {
        boolean z16;
        DataType dataType = this.mDataType;
        DataCollector dataCollector = this.dataCollector;
        if (dataCollector != null) {
            dataType = dataCollector.getDataType();
        }
        checkIntervalValidity(j3, j16, timeUnit, dataType);
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        this.startTime = timeUnit2.convert(j3, timeUnit);
        this.samplingTime = timeUnit2.convert(j16, timeUnit);
        boolean z17 = true;
        if (this.startTime > 1388505600000000000L) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, "Start time must be later than default start time: 20140101 00:00:000");
        if (this.samplingTime < this.startTime) {
            z17 = false;
        }
        Preconditions.checkState(z17, "the start time must be less than the end time");
        return this;
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder aab2 = com.huawei.hms.health.aab.aab("SamplePoint{");
        aab2.append(Arrays.toString(this.fieldValues.values().toArray()));
        StringBuilder aab3 = com.huawei.hms.health.aab.aab("[");
        aab3.append(this.startTime);
        aab3.append(", ");
        aab3.append(this.samplingTime);
        aab2.append(aab3.toString());
        StringBuilder aab4 = com.huawei.hms.health.aab.aab(", rawSamplingTime=");
        aab4.append(this.rawSamplingTime);
        aab2.append(aab4.toString());
        StringBuilder aab5 = com.huawei.hms.health.aab.aab(", insertionTime=");
        aab5.append(this.insertionTime);
        aab5.append("]");
        aab2.append(aab5.toString());
        StringBuilder aab6 = com.huawei.hms.health.aab.aab("[");
        DataCollector dataCollector = this.dataCollector;
        String str3 = "NULL";
        if (dataCollector == null) {
            str = "NULL";
        } else {
            str = dataCollector.toString();
        }
        aab6.append(str);
        aab6.append("]}");
        aab2.append(aab6.toString());
        StringBuilder aab7 = com.huawei.hms.health.aab.aab("[");
        DataType dataType = this.mDataType;
        if (dataType == null) {
            str2 = "NULL";
        } else {
            str2 = dataType.toString();
        }
        aab7.append(str2);
        aab7.append("]}");
        aab2.append(aab7.toString());
        StringBuilder aab8 = com.huawei.hms.health.aab.aab("/");
        DataCollector dataCollector2 = this.rawDataCollector;
        if (dataCollector2 != null) {
            str3 = dataCollector2.toString();
        }
        aab8.append(str3);
        aab8.append("]}");
        aab2.append(aab8.toString());
        return String.format(Locale.ENGLISH, aab2.toString(), new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.Parcelable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeToParcel(Parcel parcel, int i3) {
        String str;
        try {
            Class<?> cls = Class.forName(CALLING_APP_INFO_CLASS);
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            java.lang.reflect.Field declaredField = cls.getDeclaredField(APPID_SDKVER_CACHE);
            java.lang.reflect.Field declaredField2 = cls.getDeclaredField(PID_APPID_CACHE);
            new aaba(declaredField, declaredField2).run();
            str = (String) ((Map) declaredField.get(declaredFields)).get(((Map) declaredField2.get(declaredFields)).get(Integer.valueOf(Binder.getCallingPid())));
        } catch (ClassNotFoundException | NoSuchFieldException | SecurityException unused) {
            aabz.aabb(TAG, "catch ClassNotFoundException or NoSuchFieldException or SecurityException");
            str = null;
            parcel.writeLong(this.startTime);
            parcel.writeLong(this.samplingTime);
            parcel.writeParcelable(this.dataCollector, i3);
            parcel.writeParcelable(this.rawDataCollector, i3);
            parcel.writeMap(this.fieldValues);
            if (str != null) {
            }
            parcel.writeString(this.metadata);
        } catch (Exception unused2) {
            aabz.aab(TAG, "catch basic exception");
            str = null;
            parcel.writeLong(this.startTime);
            parcel.writeLong(this.samplingTime);
            parcel.writeParcelable(this.dataCollector, i3);
            parcel.writeParcelable(this.rawDataCollector, i3);
            parcel.writeMap(this.fieldValues);
            if (str != null) {
            }
            parcel.writeString(this.metadata);
        }
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.samplingTime);
        parcel.writeParcelable(this.dataCollector, i3);
        parcel.writeParcelable(this.rawDataCollector, i3);
        parcel.writeMap(this.fieldValues);
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str) || Integer.parseInt(str.replace(".", "")) <= 520302) {
                    return;
                }
            } catch (NumberFormatException unused3) {
                aabz.aab(TAG, "parse sdkVersion fail : catch NumberFormatException");
                return;
            }
        }
        parcel.writeString(this.metadata);
    }

    SamplePoint(DataCollector dataCollector, DataCollector dataCollector2, long j3, long j16, Map<String, Value> map, long j17, boolean z16, int i3, int i16, String str, DataType dataType) {
        this.rawSamplingTime = 0L;
        this.insertionTime = 0L;
        this.dataCollector = dataCollector;
        this.rawDataCollector = dataCollector2;
        this.startTime = j3;
        this.samplingTime = j16;
        this.fieldValues = map;
        this.f37301id = j17;
        this.isMerged = z16;
        this.dataTypeId = i3;
        this.pushed = i16;
        this.metadata = str;
        this.mDataType = dataType;
    }

    public static Builder builder(DataType dataType) {
        return new Builder(dataType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkIntervalValidity(long j3, long j16, TimeUnit timeUnit, DataType dataType) {
        boolean z16;
        String str;
        Preconditions.checkArgument(j3 > 0 && j16 > 0, "Neither start time nor end time should be set to 0");
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        Preconditions.checkArgument(timeUnit2.convert(j3, timeUnit) < Long.MAX_VALUE && timeUnit2.convert(j16, timeUnit) < Long.MAX_VALUE, "The start or end time is too large, please check the time or unit.");
        long aab2 = aac.aab(dataType);
        TimeUnit timeUnit3 = TimeUnit.SECONDS;
        Preconditions.checkArgument(timeUnit3.convert(j16, timeUnit) - timeUnit3.convert(j3, timeUnit) <= aab2, String.format(Locale.ENGLISH, "The sampling time interval should be less than %s days.", Long.valueOf(TimeUnit.DAYS.convert(aab2, timeUnit3))));
        int aaba2 = aac.aaba(dataType);
        if (aaba2 == 2 || aaba2 == 3) {
            z16 = j3 < j16;
            str = "This is an interval data type, the start time should be less than the end time.";
        } else {
            z16 = j3 <= j16;
            str = "The start time should not be greater than end time";
        }
        Preconditions.checkArgument(z16, str);
    }

    public Value getFieldValue(String str) {
        DataCollector dataCollector;
        Map<String, Value> map;
        if (this.fieldValues.containsKey(str)) {
            map = this.fieldValues;
        } else if (this.fieldValues.containsKey(Field.getFieldString(str, 0))) {
            map = this.fieldValues;
            str = Field.getFieldString(str, 0);
        } else {
            if (!this.fieldValues.containsKey(Field.getFieldString(str, 1))) {
                DataType dataType = this.mDataType;
                if ((dataType == null || !aabz.aaba(dataType.getFields()).booleanValue()) && ((dataCollector = this.dataCollector) == null || !aabz.aaba(dataCollector.getDataType().getFields()).booleanValue())) {
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

    /* synthetic */ SamplePoint(DataCollector dataCollector, DataCollector dataCollector2, long j3, long j16, Map map, long j17, boolean z16, int i3, int i16, String str, DataType dataType, aab aabVar) {
        this(dataCollector, dataCollector2, j3, j16, map, j17, z16, i3, i16, str, dataType);
    }

    protected SamplePoint(Parcel parcel) {
        this.rawSamplingTime = 0L;
        this.insertionTime = 0L;
        this.startTime = parcel.readLong();
        this.samplingTime = parcel.readLong();
        this.dataCollector = (DataCollector) parcel.readParcelable(SamplePoint.class.getClassLoader());
        this.rawDataCollector = (DataCollector) parcel.readParcelable(SamplePoint.class.getClassLoader());
        HashMap hashMap = new HashMap();
        this.fieldValues = hashMap;
        ClassLoader classLoader = Value.class.getClassLoader();
        int readInt = parcel.readInt();
        for (readInt = readInt > 300000 ? 300000 : readInt; readInt > 0; readInt--) {
            hashMap.put(parcel.readValue(classLoader), parcel.readValue(classLoader));
        }
        this.metadata = parcel.readString();
    }
}
