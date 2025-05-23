package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DLFileInfo implements Parcelable {
    public static final Parcelable.Creator<DLFileInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public long f32371d;

    /* renamed from: e, reason: collision with root package name */
    public int f32372e;

    /* renamed from: f, reason: collision with root package name */
    public String f32373f;

    /* renamed from: h, reason: collision with root package name */
    public String f32374h;

    /* renamed from: i, reason: collision with root package name */
    public long f32375i;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<DLFileInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DLFileInfo createFromParcel(Parcel parcel) {
            return new DLFileInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DLFileInfo[] newArray(int i3) {
            return new DLFileInfo[i3];
        }
    }

    public DLFileInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f32371d);
        parcel.writeInt(this.f32372e);
        parcel.writeString(this.f32373f);
        parcel.writeString(this.f32374h);
        parcel.writeLong(this.f32375i);
    }

    DLFileInfo(Parcel parcel) {
        this.f32371d = parcel.readLong();
        this.f32372e = parcel.readInt();
        this.f32373f = parcel.readString();
        this.f32374h = parcel.readString();
        this.f32375i = parcel.readLong();
    }
}
