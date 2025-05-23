package com.tencent.qqperf.reporter.flow;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class TrafficFlowRecord implements Parcelable {
    public static final Parcelable.Creator<TrafficFlowRecord> CREATOR = new a();
    long C;

    /* renamed from: d, reason: collision with root package name */
    long f363352d;

    /* renamed from: e, reason: collision with root package name */
    long f363353e;

    /* renamed from: f, reason: collision with root package name */
    long f363354f;

    /* renamed from: h, reason: collision with root package name */
    long f363355h;

    /* renamed from: i, reason: collision with root package name */
    long f363356i;

    /* renamed from: m, reason: collision with root package name */
    long f363357m;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a implements Parcelable.Creator<TrafficFlowRecord> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrafficFlowRecord createFromParcel(Parcel parcel) {
            return new TrafficFlowRecord(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TrafficFlowRecord[] newArray(int i3) {
            return new TrafficFlowRecord[i3];
        }
    }

    public TrafficFlowRecord() {
        this.f363352d = 0L;
        this.f363353e = 0L;
        this.f363354f = 0L;
        this.f363355h = 0L;
        this.f363356i = 0L;
        this.f363357m = 0L;
        this.C = 0L;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[totalAmount=" + this.f363352d + ", wifiTotal=" + this.f363353e + ", wifiRxBytes=" + this.f363354f + ", wifiTxBytes=" + this.f363355h + ", mobileTotal=" + this.f363356i + ", mobileRxBytes=" + this.f363357m + ", mobileTxBytes=" + this.C + ']';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f363352d);
        parcel.writeLong(this.f363353e);
        parcel.writeLong(this.f363354f);
        parcel.writeLong(this.f363355h);
        parcel.writeLong(this.f363356i);
        parcel.writeLong(this.f363357m);
        parcel.writeLong(this.C);
    }

    protected TrafficFlowRecord(Parcel parcel) {
        this.f363352d = parcel.readLong();
        this.f363353e = parcel.readLong();
        this.f363354f = parcel.readLong();
        this.f363355h = parcel.readLong();
        this.f363356i = parcel.readLong();
        this.f363357m = parcel.readLong();
        this.C = parcel.readLong();
    }
}
