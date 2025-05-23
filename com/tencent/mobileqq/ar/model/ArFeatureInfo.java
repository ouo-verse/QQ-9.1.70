package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.ar.i;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArFeatureInfo implements Parcelable {
    public static final Parcelable.Creator<ArFeatureInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f198409d;

    /* renamed from: e, reason: collision with root package name */
    public long f198410e;

    /* renamed from: f, reason: collision with root package name */
    public String f198411f;

    /* renamed from: h, reason: collision with root package name */
    public String f198412h;

    /* renamed from: i, reason: collision with root package name */
    public String f198413i;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ArFeatureInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArFeatureInfo createFromParcel(Parcel parcel) {
            return new ArFeatureInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArFeatureInfo[] newArray(int i3) {
            return new ArFeatureInfo[i3];
        }
    }

    public ArFeatureInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ArFeatureInfo{");
        stringBuffer.append("featureMd5='");
        stringBuffer.append(this.f198409d);
        stringBuffer.append('\'');
        stringBuffer.append(", featureSize=");
        stringBuffer.append(this.f198410e);
        stringBuffer.append('\'');
        stringBuffer.append(", featureUrl=");
        stringBuffer.append(this.f198411f);
        stringBuffer.append('\'');
        stringBuffer.append(", featurefileName=");
        stringBuffer.append(this.f198412h);
        stringBuffer.append('\'');
        stringBuffer.append(", modelRootDir=");
        stringBuffer.append(this.f198413i);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f198409d);
        parcel.writeLong(this.f198410e);
        parcel.writeString(this.f198411f);
        parcel.writeString(this.f198412h);
        parcel.writeString(this.f198413i);
    }

    protected ArFeatureInfo(Parcel parcel) {
        this.f198409d = parcel.readString();
        this.f198410e = parcel.readLong();
        this.f198411f = parcel.readString();
        this.f198412h = i.d(parcel.readString());
        this.f198413i = i.d(parcel.readString());
    }
}
