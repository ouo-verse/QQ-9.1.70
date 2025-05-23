package com.tencent.luggage.wxa.oe;

import android.bluetooth.le.ScanSettings;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p implements Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f136442a;

    /* renamed from: b, reason: collision with root package name */
    public final int f136443b;

    /* renamed from: c, reason: collision with root package name */
    public final long f136444c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p[] newArray(int i3) {
            return new p[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p createFromParcel(Parcel parcel) {
            return new p(parcel, null);
        }
    }

    public /* synthetic */ p(int i3, int i16, long j3, a aVar) {
        this(i3, i16, j3);
    }

    public long a() {
        return this.f136444c;
    }

    public int b() {
        return this.f136442a;
    }

    public ScanSettings c() {
        return new ScanSettings.Builder().setReportDelay(a()).setScanMode(b()).build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f136442a);
        parcel.writeInt(this.f136443b);
        parcel.writeLong(this.f136444c);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f136445a = 0;

        /* renamed from: b, reason: collision with root package name */
        public final int f136446b = 1;

        /* renamed from: c, reason: collision with root package name */
        public long f136447c = 0;

        public b a(int i3) {
            if (i3 >= 0 && i3 <= 2) {
                this.f136445a = i3;
                return this;
            }
            throw new IllegalArgumentException("invalid scan mode " + i3);
        }

        public p a() {
            return new p(this.f136445a, 1, this.f136447c, null);
        }
    }

    public /* synthetic */ p(Parcel parcel, a aVar) {
        this(parcel);
    }

    public p(int i3, int i16, long j3) {
        this.f136442a = i3;
        this.f136443b = i16;
        this.f136444c = j3;
    }

    public p(Parcel parcel) {
        this.f136442a = parcel.readInt();
        this.f136443b = parcel.readInt();
        this.f136444c = parcel.readLong();
    }
}
