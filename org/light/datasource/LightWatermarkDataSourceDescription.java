package org.light.datasource;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightWatermarkDataSourceDescription extends LightBaseDataSourceDescription {
    public static final Parcelable.Creator<LightWatermarkDataSourceDescription> CREATOR = new Parcelable.Creator<LightWatermarkDataSourceDescription>() { // from class: org.light.datasource.LightWatermarkDataSourceDescription.1
        @Override // android.os.Parcelable.Creator
        public LightWatermarkDataSourceDescription createFromParcel(Parcel parcel) {
            return new LightWatermarkDataSourceDescription(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightWatermarkDataSourceDescription[] newArray(int i3) {
            return new LightWatermarkDataSourceDescription[i3];
        }
    };
    LightFormatDesc[] watermarkFormats;

    public LightWatermarkDataSourceDescription() {
        this.type = "WatermarkDataSourceDescription";
    }

    public static LightWatermarkDataSourceDescription makeFromJson(JsonObject jsonObject) {
        if (jsonObject != null && jsonObject.get("type") != null) {
            if (jsonObject.get("type").getAsString().equals("WatermarkDataSourceDescription")) {
                LightWatermarkDataSourceDescription lightWatermarkDataSourceDescription = new LightWatermarkDataSourceDescription();
                JsonArray asJsonArray = jsonObject.get("watermarkFormats").getAsJsonArray();
                ArrayList arrayList = new ArrayList();
                Iterator<JsonElement> it = asJsonArray.iterator();
                while (it.hasNext()) {
                    JsonObject asJsonObject = it.next().getAsJsonObject();
                    arrayList.add(new LightFormatDesc(asJsonObject.get("format").getAsString(), asJsonObject.get(IProfileCardConst.KEY_FROM_TYPE).getAsString()));
                }
                lightWatermarkDataSourceDescription.setWatermarkFormats((LightFormatDesc[]) arrayList.toArray(new LightFormatDesc[arrayList.size()]));
                return lightWatermarkDataSourceDescription;
            }
            return new LightWatermarkDataSourceDescription();
        }
        return new LightWatermarkDataSourceDescription();
    }

    @Override // org.light.datasource.LightBaseDataSourceDescription, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LightFormatDesc[] getWatermarkFormats() {
        return this.watermarkFormats;
    }

    public void setWatermarkFormats(LightFormatDesc[] lightFormatDescArr) {
        this.watermarkFormats = lightFormatDescArr;
    }

    @Override // org.light.datasource.LightBaseDataSourceDescription
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", this.type);
        JsonArray jsonArray = new JsonArray();
        LightFormatDesc[] lightFormatDescArr = this.watermarkFormats;
        if (lightFormatDescArr != null) {
            for (LightFormatDesc lightFormatDesc : lightFormatDescArr) {
                jsonArray.add(lightFormatDesc.toJsonObject());
            }
        }
        jsonObject.add("watermarkFormats", jsonArray);
        return jsonObject;
    }

    @Override // org.light.datasource.LightBaseDataSourceDescription, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedArray(this.watermarkFormats, i3);
    }

    protected LightWatermarkDataSourceDescription(Parcel parcel) {
        super(parcel);
        this.watermarkFormats = (LightFormatDesc[]) parcel.createTypedArray(LightFormatDesc.CREATOR);
    }
}
