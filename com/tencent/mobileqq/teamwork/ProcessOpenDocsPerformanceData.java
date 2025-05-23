package com.tencent.mobileqq.teamwork;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes18.dex */
public class ProcessOpenDocsPerformanceData implements Parcelable {
    public static final Parcelable.Creator<ProcessOpenDocsPerformanceData> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public long f291499d;

    /* renamed from: e, reason: collision with root package name */
    public long f291500e;

    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<ProcessOpenDocsPerformanceData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProcessOpenDocsPerformanceData createFromParcel(Parcel parcel) {
            return new ProcessOpenDocsPerformanceData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ProcessOpenDocsPerformanceData[] newArray(int i3) {
            return new ProcessOpenDocsPerformanceData[i3];
        }
    }

    public ProcessOpenDocsPerformanceData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f291499d);
        parcel.writeLong(this.f291500e);
    }

    public ProcessOpenDocsPerformanceData(Parcel parcel) {
        this.f291499d = parcel.readLong();
        this.f291500e = parcel.readLong();
    }
}
