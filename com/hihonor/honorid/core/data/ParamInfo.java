package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class ParamInfo implements Parcelable {
    public static final Parcelable.Creator<ParamInfo> CREATOR = new a();
    private boolean C;
    private String D;
    private String E;
    private String F;
    private String G;

    /* renamed from: d, reason: collision with root package name */
    private String f36274d;

    /* renamed from: e, reason: collision with root package name */
    private String f36275e;

    /* renamed from: f, reason: collision with root package name */
    private String f36276f;

    /* renamed from: h, reason: collision with root package name */
    private int f36277h;

    /* renamed from: i, reason: collision with root package name */
    private String f36278i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f36279m;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ParamInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParamInfo createFromParcel(Parcel parcel) {
            return new ParamInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParamInfo[] newArray(int i3) {
            return new ParamInfo[i3];
        }
    }

    protected ParamInfo(Parcel parcel) {
        boolean z16;
        this.f36274d = parcel.readString();
        this.f36275e = parcel.readString();
        this.f36276f = parcel.readString();
        this.f36277h = parcel.readInt();
        this.f36278i = parcel.readString();
        if (parcel.readByte() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f36279m = z16;
        this.C = parcel.readByte() != 0;
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f36274d);
        parcel.writeString(this.f36275e);
        parcel.writeString(this.f36276f);
        parcel.writeInt(this.f36277h);
        parcel.writeString(this.f36278i);
        parcel.writeByte(this.f36279m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.C ? (byte) 1 : (byte) 0);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
    }
}
