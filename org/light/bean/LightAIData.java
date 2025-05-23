package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightAIData implements Parcelable {
    public static final Parcelable.Creator<LightAIData> CREATOR = new Parcelable.Creator<LightAIData>() { // from class: org.light.bean.LightAIData.1
        @Override // android.os.Parcelable.Creator
        public LightAIData createFromParcel(Parcel parcel) {
            return new LightAIData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightAIData[] newArray(int i3) {
            return new LightAIData[i3];
        }
    };
    List<LightAIClassifier> aiClassifiers;
    String aiDataStr;
    Object aiResult;
    int dataType;
    List<LightAIKeyPoint> lightAIKeyPoints;

    public LightAIData() {
        this.dataType = 6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<LightAIClassifier> getAiClassifiers() {
        return this.aiClassifiers;
    }

    public String getAiDataStr() {
        return this.aiDataStr;
    }

    public List<LightAIKeyPoint> getAiKeyPoints() {
        return this.lightAIKeyPoints;
    }

    public Object getAiResult() {
        return this.aiResult;
    }

    public int getDataType() {
        return this.dataType;
    }

    public void readFromParcel(Parcel parcel) {
        this.aiResult = parcel.readParcelable(Object.class.getClassLoader());
        this.lightAIKeyPoints = parcel.createTypedArrayList(LightAIKeyPoint.CREATOR);
        this.aiClassifiers = parcel.createTypedArrayList(LightAIClassifier.CREATOR);
        this.aiDataStr = parcel.readString();
        this.dataType = parcel.readInt();
    }

    public void setAiClassifiers(List<LightAIClassifier> list) {
        this.aiClassifiers = list;
    }

    public void setAiDataStr(String str) {
        this.aiDataStr = str;
    }

    public void setAiResult(Object obj) {
        this.aiResult = obj;
    }

    public void setDataType(int i3) {
        this.dataType = i3;
    }

    public void setLightAIKeyPoints(List<LightAIKeyPoint> list) {
        this.lightAIKeyPoints = list;
    }

    public String toString() {
        if (this.dataType == 2) {
            return this.aiDataStr;
        }
        return "LightAIData{aiResult=" + this.aiResult + ", lightAIKeyPoints=" + this.lightAIKeyPoints + ", aiClassifiers=" + this.aiClassifiers + ", aiDataStr='" + this.aiDataStr + "', dataType=" + this.dataType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable((Parcelable) this.aiResult, i3);
        parcel.writeTypedList(this.lightAIKeyPoints);
        parcel.writeTypedList(this.aiClassifiers);
        parcel.writeString(this.aiDataStr);
        parcel.writeInt(this.dataType);
    }

    public LightAIData(Object obj, List<LightAIKeyPoint> list, List<LightAIClassifier> list2, String str, int i3) {
        this.aiResult = obj;
        this.lightAIKeyPoints = list;
        this.aiClassifiers = list2;
        this.aiDataStr = str;
        this.dataType = i3;
    }

    protected LightAIData(Parcel parcel) {
        this.dataType = 6;
        this.aiResult = parcel.readParcelable(Object.class.getClassLoader());
        this.lightAIKeyPoints = parcel.createTypedArrayList(LightAIKeyPoint.CREATOR);
        this.aiClassifiers = parcel.createTypedArrayList(LightAIClassifier.CREATOR);
        this.aiDataStr = parcel.readString();
        this.aiResult = Integer.valueOf(parcel.readInt());
    }
}
