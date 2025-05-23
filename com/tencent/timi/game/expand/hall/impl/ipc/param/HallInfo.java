package com.tencent.timi.game.expand.hall.impl.ipc.param;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes26.dex */
public class HallInfo implements Parcelable {
    public static final Parcelable.Creator<HallInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public long f376905d;

    /* renamed from: e, reason: collision with root package name */
    public int f376906e;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Parcelable.Creator<HallInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HallInfo createFromParcel(Parcel parcel) {
            return new HallInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public HallInfo[] newArray(int i3) {
            return new HallInfo[i3];
        }
    }

    public HallInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f376905d);
        parcel.writeInt(this.f376906e);
    }

    protected HallInfo(Parcel parcel) {
        this.f376905d = parcel.readLong();
        this.f376906e = parcel.readInt();
    }
}
