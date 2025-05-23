package org.light.datasource;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightBaseDataSourceDescription implements Parcelable {
    public static final Parcelable.Creator<LightBaseDataSourceDescription> CREATOR = new Parcelable.Creator<LightBaseDataSourceDescription>() { // from class: org.light.datasource.LightBaseDataSourceDescription.1
        @Override // android.os.Parcelable.Creator
        public LightBaseDataSourceDescription createFromParcel(Parcel parcel) {
            return new LightBaseDataSourceDescription(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightBaseDataSourceDescription[] newArray(int i3) {
            return new LightBaseDataSourceDescription[i3];
        }
    };
    protected String type;

    public LightBaseDataSourceDescription() {
        this.type = "LightBaseDataSourceDescription";
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LightBaseDataSourceDescription(Parcel parcel) {
        this.type = parcel.readString();
    }
}
