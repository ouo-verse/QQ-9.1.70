package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.ar.i;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArModelResource implements Parcelable {
    public static final Parcelable.Creator<ArModelResource> CREATOR = new a();
    public String C;
    public String D;

    /* renamed from: d, reason: collision with root package name */
    public long f198420d;

    /* renamed from: e, reason: collision with root package name */
    public String f198421e;

    /* renamed from: f, reason: collision with root package name */
    public String f198422f;

    /* renamed from: h, reason: collision with root package name */
    public String f198423h;

    /* renamed from: i, reason: collision with root package name */
    public String f198424i;

    /* renamed from: m, reason: collision with root package name */
    public int f198425m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ArModelResource> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArModelResource createFromParcel(Parcel parcel) {
            return new ArModelResource(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArModelResource[] newArray(int i3) {
            return new ArModelResource[i3];
        }
    }

    public ArModelResource() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ArModelResource{");
        stringBuffer.append("modelResourceSize='");
        stringBuffer.append(this.f198420d);
        stringBuffer.append('\'');
        stringBuffer.append(", modelResourceMD5=");
        stringBuffer.append(this.f198421e);
        stringBuffer.append('\'');
        stringBuffer.append(", modelResourceUrl=");
        stringBuffer.append(this.f198422f);
        stringBuffer.append('\'');
        stringBuffer.append(", modelResourceBgMusic=");
        stringBuffer.append(this.f198423h);
        stringBuffer.append('\'');
        stringBuffer.append(", modelConfigFile=");
        stringBuffer.append(this.f198424i);
        stringBuffer.append('\'');
        stringBuffer.append(", modelRepeatTimes=");
        stringBuffer.append(this.f198425m);
        stringBuffer.append('\'');
        stringBuffer.append(", videoLayout=");
        stringBuffer.append(this.C);
        stringBuffer.append('\'');
        stringBuffer.append(", zipFileName=");
        stringBuffer.append(this.D);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f198420d);
        parcel.writeString(this.f198421e);
        parcel.writeString(this.f198422f);
        parcel.writeString(this.f198423h);
        parcel.writeString(this.f198424i);
        parcel.writeInt(this.f198425m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
    }

    protected ArModelResource(Parcel parcel) {
        this.f198420d = parcel.readLong();
        this.f198421e = parcel.readString();
        this.f198422f = parcel.readString();
        this.f198423h = parcel.readString();
        this.f198424i = parcel.readString();
        this.f198425m = parcel.readInt();
        this.C = parcel.readString();
        this.D = i.d(parcel.readString());
    }
}
