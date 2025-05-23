package org.light.datasource;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightDateDataSourceValue extends LightBaseDataSourceValue {
    public static final Parcelable.Creator<LightDateDataSourceValue> CREATOR = new Parcelable.Creator<LightDateDataSourceValue>() { // from class: org.light.datasource.LightDateDataSourceValue.1
        @Override // android.os.Parcelable.Creator
        public LightDateDataSourceValue createFromParcel(Parcel parcel) {
            return new LightDateDataSourceValue(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightDateDataSourceValue[] newArray(int i3) {
            return new LightDateDataSourceValue[i3];
        }
    };
    private long timestamp;

    public LightDateDataSourceValue() {
        this.timestamp = 0L;
        this.type = "DateDataSourceValue";
    }

    @Override // org.light.datasource.LightBaseDataSourceValue, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j3) {
        this.timestamp = j3;
    }

    @Override // org.light.datasource.LightBaseDataSourceValue
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", this.type);
        jsonObject.addProperty("timestamp", Long.valueOf(this.timestamp));
        return jsonObject;
    }

    @Override // org.light.datasource.LightBaseDataSourceValue, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeLong(this.timestamp);
    }

    public LightDateDataSourceValue(long j3) {
        this.type = "DateDataSourceValue";
        this.timestamp = j3;
    }

    protected LightDateDataSourceValue(Parcel parcel) {
        super(parcel);
        this.timestamp = 0L;
        this.timestamp = parcel.readLong();
    }
}
