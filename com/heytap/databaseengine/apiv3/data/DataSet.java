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
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class DataSet extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataSet> CREATOR = new Parcelable.Creator<DataSet>() { // from class: com.heytap.databaseengine.apiv3.data.DataSet.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataSet createFromParcel(Parcel parcel) {
            return new DataSet(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataSet[] newArray(int i3) {
            return new DataSet[i3];
        }
    };
    private static final String TAG = "DataSet";

    @SafeParcelable.Field(1)
    private List<DataPoint> dataPoints;

    @SafeParcelable.Field(2)
    private DataType dataType;

    @SafeParcelable.Field(3)
    private int needSplit;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private final DataSet dataSet;

        public Builder add(DataPoint dataPoint) {
            this.dataSet.add(dataPoint);
            return this;
        }

        public Builder addAll(List<DataPoint> list) {
            this.dataSet.addAll(list);
            return this;
        }

        public DataSet build() {
            return this.dataSet;
        }

        Builder(DataType dataType) {
            this.dataSet = DataSet.create(dataType);
        }
    }

    DataSet(DataType dataType) {
        this.dataPoints = new ArrayList();
        this.dataType = dataType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void add(DataPoint dataPoint) {
        this.dataPoints.add(dataPoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAll(List<DataPoint> list) {
        this.dataPoints.addAll(list);
    }

    public static Builder builder(DataType dataType) {
        return new Builder(dataType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DataSet create(DataType dataType) {
        return new DataSet(dataType);
    }

    public List<DataPoint> getDataPoints() {
        return this.dataPoints;
    }

    public DataType getDataType() {
        return this.dataType;
    }

    public int getNeedSplit() {
        return this.needSplit;
    }

    public void setNeedSplit(int i3) {
        this.needSplit = i3;
    }

    @NonNull
    public String toString() {
        return "DataSet{dataPoints=" + this.dataPoints + ", dataType=" + this.dataType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int writeObjectHeader = SafeParcelWriter.writeObjectHeader(parcel);
        try {
            SafeParcelWriter.write(parcel, 1, (List) this.dataPoints, i3, false);
            SafeParcelWriter.write(parcel, 2, (Parcelable) this.dataType, i3, false);
            SafeParcelWriter.write(parcel, 3, Integer.valueOf(this.needSplit));
        } catch (Exception e16) {
            HLog.w("Value", "Error writing field: " + e16);
        }
        SafeParcelWriter.finishObjectHeader(parcel, writeObjectHeader);
    }

    protected DataSet(Parcel parcel) {
        this.dataPoints = new ArrayList();
        int readObjectHeader = SafeParcelReader.readObjectHeader(parcel);
        while (parcel.dataPosition() < readObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                this.dataPoints = SafeParcelReader.readParcelableList(parcel, readHeader, DataPoint.CREATOR);
            } else if (fieldId == 2) {
                this.dataType = (DataType) SafeParcelReader.readParcelable(parcel, readHeader, DataType.CREATOR);
            } else if (fieldId != 3) {
                HLog.e(TAG, "unknown field id:" + fieldId);
                SafeParcelReader.skip(parcel, readHeader);
            } else {
                this.needSplit = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
    }
}
