package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ImageInfo implements Parcelable {
    public static final Parcelable.Creator<ImageInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private String f32376d;

    /* renamed from: e, reason: collision with root package name */
    private String f32377e;

    /* renamed from: f, reason: collision with root package name */
    private long f32378f;

    /* renamed from: h, reason: collision with root package name */
    private long f32379h;

    /* renamed from: i, reason: collision with root package name */
    private String f32380i;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ImageInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImageInfo createFromParcel(Parcel parcel) {
            return new ImageInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ImageInfo[] newArray(int i3) {
            return new ImageInfo[i3];
        }
    }

    ImageInfo(Parcel parcel) {
        this.f32376d = parcel.readString();
        this.f32377e = parcel.readString();
        this.f32378f = parcel.readLong();
        this.f32379h = parcel.readLong();
        this.f32380i = parcel.readString();
    }

    private boolean a(ImageInfo imageInfo) {
        if (this.f32377e.equals(imageInfo.f32377e) && this.f32378f == imageInfo.f32378f && this.f32379h == imageInfo.f32379h && this.f32376d.equals(imageInfo.f32376d)) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ImageInfo)) {
            return a((ImageInfo) obj);
        }
        return false;
    }

    public int hashCode() {
        return (this.f32377e + this.f32378f + this.f32379h).hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f32376d);
        parcel.writeString(this.f32377e);
        parcel.writeLong(this.f32378f);
        parcel.writeLong(this.f32379h);
        parcel.writeString(this.f32380i);
    }
}
