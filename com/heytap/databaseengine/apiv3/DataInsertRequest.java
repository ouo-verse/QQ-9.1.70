package com.heytap.databaseengine.apiv3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.heytap.databaseengine.apiv3.data.DataSet;
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
public class DataInsertRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataInsertRequest> CREATOR = new Parcelable.Creator<DataInsertRequest>() { // from class: com.heytap.databaseengine.apiv3.DataInsertRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataInsertRequest createFromParcel(Parcel parcel) {
            return new DataInsertRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataInsertRequest[] newArray(int i3) {
            return new DataInsertRequest[i3];
        }
    };
    private static final String TAG = "DataInsertRequest";

    @SafeParcelable.Field(1)
    private List<DataSet> dataSetList;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private List<DataSet> dataSetList;

        public DataInsertRequest build() {
            return new DataInsertRequest(this);
        }

        public Builder setData(List<DataSet> list) {
            this.dataSetList = list;
            return this;
        }
    }

    public DataInsertRequest(Builder builder) {
        this.dataSetList = new ArrayList();
        this.dataSetList = builder.dataSetList;
    }

    public List<DataSet> getData() {
        return this.dataSetList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int writeObjectHeader = SafeParcelWriter.writeObjectHeader(parcel);
        try {
            SafeParcelWriter.write(parcel, 1, (List) this.dataSetList, i3, false);
        } catch (Exception e16) {
            HLog.w("Value", "Error writing field: " + e16);
        }
        SafeParcelWriter.finishObjectHeader(parcel, writeObjectHeader);
    }

    protected DataInsertRequest(Parcel parcel) {
        this.dataSetList = new ArrayList();
        int readObjectHeader = SafeParcelReader.readObjectHeader(parcel);
        while (parcel.dataPosition() < readObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                HLog.e(TAG, "unknown field id:" + fieldId);
                SafeParcelReader.skip(parcel, readHeader);
            } else {
                this.dataSetList = SafeParcelReader.readParcelableList(parcel, readHeader, DataSet.CREATOR);
            }
        }
    }
}
