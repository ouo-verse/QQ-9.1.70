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
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class Value extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Value> CREATOR = new Parcelable.Creator<Value>() { // from class: com.heytap.databaseengine.apiv3.data.Value.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Value createFromParcel(Parcel parcel) {
            return new Value(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Value[] newArray(int i3) {
            return new Value[i3];
        }
    };
    private static final String TAG = "Value";

    @SafeParcelable.Field(7)
    private byte[] arrayByte;

    @SafeParcelable.Field(6)
    private float[] arrayFloat;

    @SafeParcelable.Field(5)
    private int[] arrayInt;

    @SafeParcelable.Field(1)
    private int format;

    @SafeParcelable.Field(2)
    private boolean isSet;

    @SafeParcelable.Field(3)
    private float valueFloat;

    @SafeParcelable.Field(8)
    private Map<String, MapValue> valueMap;

    @SafeParcelable.Field(4)
    private String valueString;

    public Value(int i3) {
        this.format = i3;
    }

    public float asFloat() {
        return this.valueFloat;
    }

    public int asInt() {
        return Float.floatToRawIntBits(this.valueFloat);
    }

    public String asString() {
        return this.valueString;
    }

    public boolean isSet() {
        return this.isSet;
    }

    public void setFloat(float f16) {
        this.isSet = true;
        this.valueFloat = f16;
    }

    public void setInt(int i3) {
        this.isSet = true;
        this.valueFloat = Float.intBitsToFloat(i3);
    }

    public void setKeyValue(String str, float f16) {
        this.isSet = true;
        if (this.valueMap == null) {
            this.valueMap = new HashMap();
        }
        this.valueMap.put(str, MapValue.create(f16));
    }

    public void setSet(boolean z16) {
        this.isSet = z16;
    }

    public void setString(String str) {
        this.isSet = true;
        this.valueString = str;
    }

    public void setValueMap(Map<String, Float> map) {
        this.isSet = true;
        this.valueMap = new HashMap();
        for (Map.Entry<String, Float> entry : map.entrySet()) {
            this.valueMap.put(entry.getKey(), MapValue.create(entry.getValue().floatValue()));
        }
    }

    @NonNull
    public String toString() {
        if (!this.isSet) {
            return "unset";
        }
        int i3 = this.format;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "unknown";
                }
                return Float.toString(asFloat());
            }
            return asString();
        }
        return Integer.toString(asInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int writeObjectHeader = SafeParcelWriter.writeObjectHeader(parcel);
        try {
            SafeParcelWriter.write(parcel, 1, Integer.valueOf(this.format));
            SafeParcelWriter.write(parcel, 2, Boolean.valueOf(this.isSet));
            SafeParcelWriter.write(parcel, 3, Float.valueOf(this.valueFloat));
            SafeParcelWriter.write(parcel, 4, this.valueString, false);
            SafeParcelWriter.write(parcel, 5, this.arrayInt, false);
            SafeParcelWriter.write(parcel, 6, this.arrayFloat, false);
            SafeParcelWriter.write(parcel, 7, this.arrayByte, false);
            SafeParcelWriter.write(parcel, 8, (Map) this.valueMap, false);
        } catch (Exception e16) {
            HLog.w(TAG, "Error writing field: " + e16);
        }
        SafeParcelWriter.finishObjectHeader(parcel, writeObjectHeader);
    }

    protected Value(Parcel parcel) {
        int readObjectHeader = SafeParcelReader.readObjectHeader(parcel);
        while (parcel.dataPosition() < readObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            switch (fieldId) {
                case 1:
                    this.format = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    this.isSet = SafeParcelReader.readBool(parcel, readHeader);
                    break;
                case 3:
                    this.valueFloat = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 4:
                    this.valueString = SafeParcelReader.readString(parcel, readHeader);
                    break;
                case 5:
                    this.arrayInt = SafeParcelReader.readIntArray(parcel, readHeader);
                    break;
                case 6:
                    this.arrayFloat = SafeParcelReader.readFloatArray(parcel, readHeader);
                    break;
                case 7:
                    this.arrayByte = SafeParcelReader.readByteArray(parcel, readHeader);
                    break;
                case 8:
                    this.valueMap = SafeParcelReader.readMap(parcel, readHeader, MapValue.class.getClassLoader());
                    break;
                default:
                    HLog.e(TAG, "unknown field id:" + fieldId);
                    SafeParcelReader.skip(parcel, readHeader);
                    break;
            }
        }
    }
}
