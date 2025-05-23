package org.light.datasource;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightFormatDesc implements Parcelable {
    public static final Parcelable.Creator<LightFormatDesc> CREATOR = new Parcelable.Creator<LightFormatDesc>() { // from class: org.light.datasource.LightFormatDesc.1
        @Override // android.os.Parcelable.Creator
        public LightFormatDesc createFromParcel(Parcel parcel) {
            return new LightFormatDesc(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightFormatDesc[] newArray(int i3) {
            return new LightFormatDesc[i3];
        }
    };
    public static final String FROM_TYPE_AUTO = "auto";
    public static final String FROM_TYPE_CUSTOM = "custom";
    public String format;
    public String fromType;

    public LightFormatDesc(String str, String str2) {
        this.format = str;
        this.fromType = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFormat() {
        return this.format;
    }

    public String getFromType() {
        return this.fromType;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setFromType(String str) {
        this.fromType = str;
    }

    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("format", this.format);
        jsonObject.addProperty(IProfileCardConst.KEY_FROM_TYPE, this.fromType);
        return jsonObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.format);
        parcel.writeString(this.fromType);
    }

    protected LightFormatDesc(Parcel parcel) {
        this.format = parcel.readString();
        this.fromType = parcel.readString();
    }
}
