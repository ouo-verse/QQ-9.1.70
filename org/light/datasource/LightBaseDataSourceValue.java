package org.light.datasource;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightBaseDataSourceValue implements Parcelable {
    public static final Parcelable.Creator<LightBaseDataSourceValue> CREATOR = new Parcelable.Creator<LightBaseDataSourceValue>() { // from class: org.light.datasource.LightBaseDataSourceValue.1
        @Override // android.os.Parcelable.Creator
        public LightBaseDataSourceValue createFromParcel(Parcel parcel) {
            return new LightBaseDataSourceValue(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightBaseDataSourceValue[] newArray(int i3) {
            return new LightBaseDataSourceValue[i3];
        }
    };
    protected HashMap<String, String> extendBundle;
    protected String type;

    public LightBaseDataSourceValue() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", this.type);
        return jsonObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.type);
        parcel.writeSerializable(this.extendBundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LightBaseDataSourceValue(Parcel parcel) {
        this.type = parcel.readString();
        this.extendBundle = (HashMap) parcel.readSerializable();
    }
}
