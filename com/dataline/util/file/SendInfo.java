package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SendInfo implements Parcelable {
    public static final Parcelable.Creator<SendInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private String f32381d;

    /* renamed from: e, reason: collision with root package name */
    private String f32382e;

    /* renamed from: f, reason: collision with root package name */
    private long f32383f;

    /* renamed from: h, reason: collision with root package name */
    private int f32384h;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SendInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SendInfo createFromParcel(Parcel parcel) {
            return new SendInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SendInfo[] newArray(int i3) {
            return new SendInfo[i3];
        }
    }

    SendInfo(Parcel parcel) {
        this.f32381d = parcel.readString();
        this.f32382e = parcel.readString();
        this.f32383f = parcel.readLong();
        this.f32384h = parcel.readInt();
    }

    private boolean a(SendInfo sendInfo) {
        if (this.f32381d.equals(sendInfo.f32381d) && this.f32382e.equals(sendInfo.f32382e) && this.f32383f == sendInfo.f32383f && this.f32384h == sendInfo.f32384h) {
            return true;
        }
        return false;
    }

    public long b() {
        return this.f32383f;
    }

    public String c() {
        return this.f32381d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f32382e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof SendInfo)) {
            return a((SendInfo) obj);
        }
        return false;
    }

    public int hashCode() {
        return (this.f32381d + this.f32382e + this.f32383f).hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f32381d);
        parcel.writeString(this.f32382e);
        parcel.writeLong(this.f32383f);
        parcel.writeInt(this.f32384h);
    }
}
