package com.google.android.vending.expansion.downloader;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class DownloadProgressInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadProgressInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public long f34532d;

    /* renamed from: e, reason: collision with root package name */
    public long f34533e;

    /* renamed from: f, reason: collision with root package name */
    public long f34534f;

    /* renamed from: h, reason: collision with root package name */
    public float f34535h;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<DownloadProgressInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadProgressInfo createFromParcel(Parcel parcel) {
            return new DownloadProgressInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownloadProgressInfo[] newArray(int i3) {
            return new DownloadProgressInfo[i3];
        }
    }

    public DownloadProgressInfo(Parcel parcel) {
        this.f34532d = parcel.readLong();
        this.f34533e = parcel.readLong();
        this.f34534f = parcel.readLong();
        this.f34535h = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f34532d);
        parcel.writeLong(this.f34533e);
        parcel.writeLong(this.f34534f);
        parcel.writeFloat(this.f34535h);
    }

    public DownloadProgressInfo(long j3, long j16, long j17, float f16) {
        this.f34532d = j3;
        this.f34533e = j16;
        this.f34534f = j17;
        this.f34535h = f16;
    }
}
