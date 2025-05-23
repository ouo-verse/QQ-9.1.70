package org.light;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightImageFaceDetectResult implements Parcelable {
    public static final Parcelable.Creator<LightImageFaceDetectResult> CREATOR = new Parcelable.Creator<LightImageFaceDetectResult>() { // from class: org.light.LightImageFaceDetectResult.1
        @Override // android.os.Parcelable.Creator
        public LightImageFaceDetectResult createFromParcel(Parcel parcel) {
            return new LightImageFaceDetectResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightImageFaceDetectResult[] newArray(int i3) {
            return new LightImageFaceDetectResult[i3];
        }
    };
    public LightSingleFaceInfo[] faceInfoArray;

    /* renamed from: msg, reason: collision with root package name */
    public String f423798msg;
    public LightFaceResultType type;

    public LightImageFaceDetectResult(LightSingleFaceInfo[] lightSingleFaceInfoArr, int i3, String str) {
        this.faceInfoArray = lightSingleFaceInfoArr;
        this.type = LightFaceResultType.values()[i3];
        this.f423798msg = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedArray(this.faceInfoArray, i3);
        parcel.writeInt(this.type.ordinal());
        parcel.writeString(this.f423798msg);
    }

    protected LightImageFaceDetectResult(Parcel parcel) {
        this.faceInfoArray = (LightSingleFaceInfo[]) parcel.createTypedArray(LightSingleFaceInfo.CREATOR);
        this.type = LightFaceResultType.values()[parcel.readInt()];
        this.f423798msg = parcel.readString();
    }
}
