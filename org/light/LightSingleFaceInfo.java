package org.light;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightSingleFaceInfo implements Parcelable {
    public static final Parcelable.Creator<LightSingleFaceInfo> CREATOR = new Parcelable.Creator<LightSingleFaceInfo>() { // from class: org.light.LightSingleFaceInfo.1
        @Override // android.os.Parcelable.Creator
        public LightSingleFaceInfo createFromParcel(Parcel parcel) {
            return new LightSingleFaceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightSingleFaceInfo[] newArray(int i3) {
            return new LightSingleFaceInfo[i3];
        }
    };
    public LightFaceDirection faceDirection;

    /* renamed from: h, reason: collision with root package name */
    public float f423799h;

    /* renamed from: w, reason: collision with root package name */
    public float f423800w;

    /* renamed from: x, reason: collision with root package name */
    public float f423801x;

    /* renamed from: y, reason: collision with root package name */
    public float f423802y;

    public LightSingleFaceInfo(int i3, float f16, float f17, float f18, float f19) {
        this.f423801x = 0.0f;
        this.f423802y = 0.0f;
        this.f423800w = 0.0f;
        this.f423799h = 0.0f;
        this.faceDirection = LightFaceDirection.values()[i3];
        this.f423801x = f16;
        this.f423802y = f17;
        this.f423800w = f18;
        this.f423799h = f19;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.f423801x);
        parcel.writeFloat(this.f423802y);
        parcel.writeFloat(this.f423800w);
        parcel.writeFloat(this.f423799h);
        parcel.writeInt(this.faceDirection.ordinal());
    }

    protected LightSingleFaceInfo(Parcel parcel) {
        this.f423801x = 0.0f;
        this.f423802y = 0.0f;
        this.f423800w = 0.0f;
        this.f423799h = 0.0f;
        this.f423801x = parcel.readFloat();
        this.f423802y = parcel.readFloat();
        this.f423800w = parcel.readFloat();
        this.f423799h = parcel.readFloat();
        this.faceDirection = LightFaceDirection.values()[parcel.readInt()];
    }
}
