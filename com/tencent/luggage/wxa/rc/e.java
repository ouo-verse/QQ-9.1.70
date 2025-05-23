package com.tencent.luggage.wxa.rc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
@Deprecated
/* loaded from: classes8.dex */
public class e extends c {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: h, reason: collision with root package name */
    public int f139517h;

    /* renamed from: i, reason: collision with root package name */
    public long f139518i;

    /* renamed from: j, reason: collision with root package name */
    public int f139519j;

    /* renamed from: k, reason: collision with root package name */
    public int f139520k;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i3) {
            return new e[i3];
        }
    }

    public /* synthetic */ e(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.tencent.luggage.wxa.rc.c, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.rc.c
    public String toString() {
        return "AppBrandLocalVideoObject{duration=" + this.f139517h + ", size=" + this.f139518i + ", width=" + this.f139519j + ", height=" + this.f139520k + '}';
    }

    @Override // com.tencent.luggage.wxa.rc.c, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f139517h);
        parcel.writeLong(this.f139518i);
        parcel.writeInt(this.f139519j);
        parcel.writeInt(this.f139520k);
    }

    public e() {
    }

    e(Parcel parcel) {
        super(parcel);
        this.f139517h = parcel.readInt();
        this.f139518i = parcel.readLong();
        this.f139519j = parcel.readInt();
        this.f139520k = parcel.readInt();
    }
}
