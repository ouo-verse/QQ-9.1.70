package com.heytap.databaseengine.apiv3.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.safeparcel.AbstractSafeParcelable;
import com.heytap.databaseengine.safeparcel.SafeParcelReader;
import com.heytap.databaseengine.safeparcel.SafeParcelWriter;
import com.heytap.databaseengine.safeparcel.SafeParcelable;
import com.heytap.databaseengine.utils.HLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Keep
/* loaded from: classes2.dex */
public class DataPoint extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataPoint> CREATOR = new Parcelable.Creator<DataPoint>() { // from class: com.heytap.databaseengine.apiv3.data.DataPoint.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataPoint createFromParcel(Parcel parcel) {
            return new DataPoint(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataPoint[] newArray(int i3) {
            return new DataPoint[i3];
        }
    };
    private static final String TAG = "DataPoint";

    @SafeParcelable.Field(2)
    private DataType dataType;

    @SafeParcelable.Field(3)
    private long startTimeStamp;

    @SafeParcelable.Field(4)
    private long timeStamp;

    @SafeParcelable.Field(1)
    private Value[] values;

    /* loaded from: classes2.dex */
    public static class Builder {
        private final DataPoint dataPoint;

        public DataPoint build() {
            return this.dataPoint;
        }

        public Builder setElement(Element element, int i3) {
            this.dataPoint.getValue(element).setInt(i3);
            return this;
        }

        public Builder setStartTimeStamp(long j3) {
            this.dataPoint.setStartTimeStamp(j3);
            return this;
        }

        public Builder setTimeStamp(long j3) {
            this.dataPoint.setTimeStamp(j3);
            return this;
        }

        Builder(DataType dataType) {
            this.dataPoint = DataPoint.create(dataType);
        }

        public Builder setElement(Element element, float f16) {
            this.dataPoint.getValue(element).setFloat(f16);
            return this;
        }

        public Builder setElement(Element element, String str) {
            this.dataPoint.getValue(element).setString(str);
            return this;
        }

        public Builder setElement(Element element, Map<String, Float> map) {
            this.dataPoint.getValue(element).setValueMap(map);
            return this;
        }
    }

    DataPoint(DataType dataType) {
        this.dataType = dataType;
        List<Element> elements = dataType.getElements();
        this.values = new Value[elements.size()];
        Iterator<Element> it = elements.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            this.values[i3] = new Value(it.next().getFormat());
            i3++;
        }
    }

    public static Builder builder(DataType dataType) {
        return new Builder(dataType);
    }

    public static DataPoint create(DataType dataType) {
        return new DataPoint(dataType);
    }

    private void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartTimeStamp(long j3) {
        this.startTimeStamp = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeStamp(long j3) {
        this.timeStamp = j3;
    }

    public DataType getDataType() {
        return this.dataType;
    }

    public long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public Value getValue(Element element) {
        return this.values[getDataType().indexOf(element)];
    }

    public Value[] getValues() {
        return this.values;
    }

    public void setValues(Value[] valueArr) {
        this.values = valueArr;
    }

    @NonNull
    public String toString() {
        return "DataPoint{values=" + Arrays.toString(this.values) + ", dataType=" + this.dataType + ", startTimeStamp=" + this.startTimeStamp + ", timeStamp=" + this.timeStamp + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int writeObjectHeader = SafeParcelWriter.writeObjectHeader(parcel);
        try {
            SafeParcelWriter.write(parcel, 1, (Parcelable[]) this.values, i3, false);
            SafeParcelWriter.write(parcel, 2, (Parcelable) this.dataType, i3, false);
            SafeParcelWriter.write(parcel, 3, Long.valueOf(this.startTimeStamp));
            SafeParcelWriter.write(parcel, 4, Long.valueOf(this.timeStamp));
        } catch (Exception e16) {
            HLog.w("Value", "Error writing field: " + e16);
        }
        SafeParcelWriter.finishObjectHeader(parcel, writeObjectHeader);
    }

    protected DataPoint(Parcel parcel) {
        int readObjectHeader = SafeParcelReader.readObjectHeader(parcel);
        while (parcel.dataPosition() < readObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                this.values = (Value[]) SafeParcelReader.readParcelableArray(parcel, readHeader, Value.CREATOR);
            } else if (fieldId == 2) {
                this.dataType = (DataType) SafeParcelReader.readParcelable(parcel, readHeader, DataType.CREATOR);
            } else if (fieldId == 3) {
                this.startTimeStamp = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId != 4) {
                HLog.e(TAG, "unknown field id:" + fieldId);
                SafeParcelReader.skip(parcel, readHeader);
            } else {
                this.timeStamp = SafeParcelReader.readLong(parcel, readHeader);
            }
        }
    }
}
