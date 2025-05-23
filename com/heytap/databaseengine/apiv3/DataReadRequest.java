package com.heytap.databaseengine.apiv3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.heytap.databaseengine.apiv3.data.DataType;
import com.heytap.databaseengine.safeparcel.AbstractSafeParcelable;
import com.heytap.databaseengine.safeparcel.SafeParcelReader;
import com.heytap.databaseengine.safeparcel.SafeParcelWriter;
import com.heytap.databaseengine.safeparcel.SafeParcelable;
import com.heytap.databaseengine.utils.HLog;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class DataReadRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataReadRequest> CREATOR = new Parcelable.Creator<DataReadRequest>() { // from class: com.heytap.databaseengine.apiv3.DataReadRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataReadRequest createFromParcel(Parcel parcel) {
            return new DataReadRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataReadRequest[] newArray(int i3) {
            return new DataReadRequest[i3];
        }
    };
    private static final String TAG = "DataReadRequest";

    @SafeParcelable.Field(1)
    private DataType dataType;

    @SafeParcelable.Field(3)
    private long endTime;

    @SafeParcelable.Field(2)
    private long startTime;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private DataType dataType;
        private long endTime;
        private long startTime;

        public DataReadRequest build() {
            return new DataReadRequest(this);
        }

        public Builder read(DataType dataType) {
            this.dataType = dataType;
            return this;
        }

        public Builder setTimeRange(long j3, long j16) {
            this.startTime = j3;
            this.endTime = j16;
            return this;
        }
    }

    public DataReadRequest(Builder builder) {
        this.dataType = builder.dataType;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
    }

    public DataType getDataType() {
        return this.dataType;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int writeObjectHeader = SafeParcelWriter.writeObjectHeader(parcel);
        try {
            SafeParcelWriter.write(parcel, 1, (Parcelable) this.dataType, i3, false);
            SafeParcelWriter.write(parcel, 2, Long.valueOf(this.startTime));
            SafeParcelWriter.write(parcel, 3, Long.valueOf(this.endTime));
        } catch (Exception e16) {
            HLog.w("Value", "Error writing field: " + e16);
        }
        SafeParcelWriter.finishObjectHeader(parcel, writeObjectHeader);
    }

    protected DataReadRequest(Parcel parcel) {
        int readObjectHeader = SafeParcelReader.readObjectHeader(parcel);
        while (parcel.dataPosition() < readObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                this.dataType = (DataType) SafeParcelReader.readParcelable(parcel, readHeader, DataType.CREATOR);
            } else if (fieldId == 2) {
                this.startTime = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId != 3) {
                HLog.e(TAG, "unknown field id:" + fieldId);
                SafeParcelReader.skip(parcel, readHeader);
            } else {
                this.endTime = SafeParcelReader.readLong(parcel, readHeader);
            }
        }
    }
}
