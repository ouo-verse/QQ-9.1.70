package org.light.datasource;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightDataSource implements Parcelable {
    public static final Parcelable.Creator<LightDataSource> CREATOR = new Parcelable.Creator<LightDataSource>() { // from class: org.light.datasource.LightDataSource.1
        @Override // android.os.Parcelable.Creator
        public LightDataSource createFromParcel(Parcel parcel) {
            return new LightDataSource(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightDataSource[] newArray(int i3) {
            return new LightDataSource[i3];
        }
    };
    private LightBaseDataSourceDescription desc;
    private long entityId;
    private String key;
    private LightBaseDataSourceValue value;

    public LightDataSource() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDataKey() {
        return this.key;
    }

    public LightBaseDataSourceDescription getDesc() {
        return this.desc;
    }

    public long getEntityId() {
        return this.entityId;
    }

    public LightBaseDataSourceValue getValue() {
        return this.value;
    }

    public void setDataKey(String str) {
        this.key = str;
    }

    public void setDesc(LightBaseDataSourceDescription lightBaseDataSourceDescription) {
        this.desc = lightBaseDataSourceDescription;
    }

    public void setEntityId(long j3) {
        this.entityId = j3;
    }

    public void setValue(LightBaseDataSourceValue lightBaseDataSourceValue) {
        this.value = lightBaseDataSourceValue;
    }

    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(TemplateParser.KEY_ENTITY_ID, Long.valueOf(this.entityId));
        jsonObject.addProperty("key", this.key);
        LightBaseDataSourceDescription lightBaseDataSourceDescription = this.desc;
        if (lightBaseDataSourceDescription != null) {
            jsonObject.add("desc", lightBaseDataSourceDescription.toJsonObject());
        }
        LightBaseDataSourceValue lightBaseDataSourceValue = this.value;
        if (lightBaseDataSourceValue != null) {
            jsonObject.add("value", lightBaseDataSourceValue.toJsonObject());
        }
        return jsonObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.entityId);
        parcel.writeString(this.key);
        parcel.writeParcelable(this.desc, i3);
        parcel.writeParcelable(this.value, i3);
    }

    protected LightDataSource(Parcel parcel) {
        this.entityId = parcel.readLong();
        this.key = parcel.readString();
        this.desc = (LightBaseDataSourceDescription) parcel.readParcelable(LightBaseDataSourceDescription.class.getClassLoader());
        this.value = (LightBaseDataSourceValue) parcel.readParcelable(LightBaseDataSourceValue.class.getClassLoader());
    }
}
