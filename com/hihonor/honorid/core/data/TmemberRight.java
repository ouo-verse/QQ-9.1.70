package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TmemberRight implements Parcelable {
    public static final Parcelable.Creator<TmemberRight> CREATOR = new a();
    private String C;
    private String D;

    /* renamed from: d, reason: collision with root package name */
    private long f36280d;

    /* renamed from: e, reason: collision with root package name */
    private int f36281e;

    /* renamed from: f, reason: collision with root package name */
    private String f36282f;

    /* renamed from: h, reason: collision with root package name */
    private String f36283h;

    /* renamed from: i, reason: collision with root package name */
    private String f36284i;

    /* renamed from: m, reason: collision with root package name */
    private int f36285m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<TmemberRight> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TmemberRight createFromParcel(Parcel parcel) {
            TmemberRight tmemberRight = new TmemberRight();
            tmemberRight.f36280d = parcel.readLong();
            tmemberRight.f36281e = parcel.readInt();
            tmemberRight.f36282f = parcel.readString();
            tmemberRight.f36283h = parcel.readString();
            tmemberRight.f36284i = parcel.readString();
            tmemberRight.f36285m = parcel.readInt();
            tmemberRight.C = parcel.readString();
            tmemberRight.D = parcel.readString();
            return tmemberRight;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TmemberRight[] newArray(int i3) {
            return new TmemberRight[i3];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f36280d);
        parcel.writeInt(this.f36281e);
        parcel.writeString(this.f36282f);
        parcel.writeString(this.f36283h);
        parcel.writeString(this.f36284i);
        parcel.writeInt(this.f36285m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
    }
}
