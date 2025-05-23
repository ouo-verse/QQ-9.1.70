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

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class MapValue extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MapValue> CREATOR = new Parcelable.Creator<MapValue>() { // from class: com.heytap.databaseengine.apiv3.data.MapValue.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapValue createFromParcel(Parcel parcel) {
            return new MapValue(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapValue[] newArray(int i3) {
            return new MapValue[i3];
        }
    };
    private static final String TAG = "MapValue";

    @SafeParcelable.Field(1)
    private int format;

    @SafeParcelable.Field(2)
    private float value;

    public MapValue(int i3, float f16) {
        this.format = i3;
        this.value = f16;
    }

    public static MapValue create(float f16) {
        return new MapValue(3, f16);
    }

    public float asFloat() {
        return this.value;
    }

    @NonNull
    public String toString() {
        return "MapValue{format=" + this.format + ", value=" + this.value + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int writeObjectHeader = SafeParcelWriter.writeObjectHeader(parcel);
        try {
            SafeParcelWriter.write(parcel, 1, Integer.valueOf(this.format));
            SafeParcelWriter.write(parcel, 2, Float.valueOf(this.value));
        } catch (Exception e16) {
            HLog.w("Value", "Error writing field: " + e16);
        }
        SafeParcelWriter.finishObjectHeader(parcel, writeObjectHeader);
    }

    protected MapValue(Parcel parcel) {
        int readObjectHeader = SafeParcelReader.readObjectHeader(parcel);
        while (parcel.dataPosition() < readObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                this.format = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 2) {
                HLog.e(TAG, "unknown field id:" + fieldId);
                SafeParcelReader.skip(parcel, readHeader);
            } else {
                this.value = SafeParcelReader.readFloat(parcel, readHeader);
            }
        }
    }
}
