package com.tencent.mobileqq.wink.export.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes21.dex */
public class ExportingParam implements Parcelable {
    public static final Parcelable.Creator<ExportingParam> CREATOR = new a();
    public long C;

    /* renamed from: d, reason: collision with root package name */
    public String f322841d;

    /* renamed from: e, reason: collision with root package name */
    public float f322842e;

    /* renamed from: f, reason: collision with root package name */
    public float f322843f;

    /* renamed from: h, reason: collision with root package name */
    public float f322844h;

    /* renamed from: i, reason: collision with root package name */
    public long f322845i;

    /* renamed from: m, reason: collision with root package name */
    public String f322846m;

    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<ExportingParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExportingParam createFromParcel(Parcel parcel) {
            return new ExportingParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExportingParam[] newArray(int i3) {
            return new ExportingParam[i3];
        }
    }

    public ExportingParam(String str, float f16, float f17, float f18, long j3, String str2) {
        this.f322841d = str;
        this.f322842e = f16;
        this.f322843f = f17;
        this.f322844h = f18;
        this.f322845i = j3;
        this.f322846m = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ExportingParam{missionID='" + this.f322841d + "', progress=" + this.f322842e + ", videoProgress=" + this.f322843f + ", audioProgress=" + this.f322844h + ", predictTime=" + this.f322845i + ", filePath='" + this.f322846m + "', originalFileSize=" + this.C + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f322841d);
        parcel.writeFloat(this.f322842e);
        parcel.writeFloat(this.f322843f);
        parcel.writeFloat(this.f322844h);
        parcel.writeLong(this.f322845i);
        parcel.writeString(this.f322846m);
        parcel.writeLong(this.C);
    }

    protected ExportingParam(Parcel parcel) {
        this.f322841d = parcel.readString();
        this.f322842e = parcel.readFloat();
        this.f322843f = parcel.readFloat();
        this.f322844h = parcel.readFloat();
        this.f322845i = parcel.readLong();
        this.f322846m = parcel.readString();
        this.C = parcel.readLong();
    }
}
