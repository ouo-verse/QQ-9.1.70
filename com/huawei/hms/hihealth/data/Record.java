package com.huawei.hms.hihealth.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Record implements Parcelable {
    private static final int ACCURACY_LEVEL = 2;
    public static final Parcelable.Creator<Record> CREATOR = new aab();
    private static final long SAMPLING_RATE = -1;
    private int accuracyLevel;
    private DataCollector dataCollector;
    private DataType dataType;
    private long samplingRate;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private DataCollector dataCollector;
        private DataType dataType;
        private long samplingRate = -1;
        private int accuracyLevel = 2;

        public final Record build() {
            boolean z16;
            DataCollector dataCollector;
            boolean z17 = false;
            if (this.dataCollector == null && this.dataType == null) {
                z16 = false;
            } else {
                z16 = true;
            }
            Preconditions.checkState(z16, "Call either setDataCollector() or setDataType()");
            DataType dataType = this.dataType;
            if (dataType == null || (dataCollector = this.dataCollector) == null || dataType.equals(dataCollector.getDataType())) {
                z17 = true;
            }
            Preconditions.checkState(z17, "Target data type does not match the data type in the correlated data collector");
            return new Record(this, null);
        }

        public final Builder setDataCollector(DataCollector dataCollector) {
            this.dataCollector = dataCollector;
            return this;
        }

        public final Builder setDataType(DataType dataType) {
            this.dataType = dataType;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aab implements Parcelable.Creator<Record> {
        aab() {
        }

        @Override // android.os.Parcelable.Creator
        public Record createFromParcel(Parcel parcel) {
            return new Record(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Record[] newArray(int i3) {
            return new Record[i3];
        }
    }

    Record(int i3, long j3, DataCollector dataCollector, DataType dataType) {
        this.accuracyLevel = i3;
        this.samplingRate = j3;
        this.dataCollector = dataCollector;
        this.dataType = dataType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Record)) {
            return false;
        }
        Record record = (Record) obj;
        if (Objects.equal(this.dataCollector, record.dataCollector) && Objects.equal(this.dataType, record.dataType) && this.samplingRate == record.samplingRate && this.accuracyLevel == record.accuracyLevel) {
            return true;
        }
        return false;
    }

    public final DataType findTrueDataType() {
        DataType dataType = this.dataType;
        if (dataType == null) {
            return this.dataCollector.getDataType();
        }
        return dataType;
    }

    public DataCollector getDataCollector() {
        return this.dataCollector;
    }

    public DataType getDataType() {
        return this.dataType;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.accuracyLevel), Long.valueOf(this.samplingRate), this.dataCollector, this.dataType);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("accuracyLevel", Integer.valueOf(this.accuracyLevel)).add("samplingRate", Long.valueOf(this.samplingRate)).add("dataCollector", this.dataCollector).add("dataType", this.dataType).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.accuracyLevel);
        parcel.writeLong(this.samplingRate);
        parcel.writeParcelable(this.dataCollector, i3);
        parcel.writeParcelable(this.dataType, i3);
    }

    protected Record(Parcel parcel) {
        this.accuracyLevel = parcel.readInt();
        this.samplingRate = parcel.readLong();
        this.dataCollector = (DataCollector) parcel.readParcelable(DataCollector.class.getClassLoader());
        this.dataType = (DataType) parcel.readParcelable(DataType.class.getClassLoader());
    }

    Record(Builder builder) {
        this.accuracyLevel = builder.accuracyLevel;
        this.samplingRate = builder.samplingRate;
        this.dataType = builder.dataType;
        this.dataCollector = builder.dataCollector;
    }

    /* synthetic */ Record(Builder builder, aab aabVar) {
        this(builder);
    }
}
