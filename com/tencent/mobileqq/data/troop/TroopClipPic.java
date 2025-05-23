package com.tencent.mobileqq.data.troop;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes10.dex */
public class TroopClipPic implements Serializable, Parcelable {
    public static final Parcelable.Creator<TroopClipPic> CREATOR = new a();
    public String clipInfo;

    /* renamed from: id, reason: collision with root package name */
    public String f203184id;

    /* renamed from: ts, reason: collision with root package name */
    public long f203185ts;
    public int type;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<TroopClipPic> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopClipPic createFromParcel(Parcel parcel) {
            return new TroopClipPic(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TroopClipPic[] newArray(int i3) {
            return new TroopClipPic[i3];
        }
    }

    public TroopClipPic() {
        this.type = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "id=" + this.f203184id + " type=" + this.type + " clip=" + this.clipInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f203184id);
        parcel.writeString(this.clipInfo);
        parcel.writeInt(this.type);
        parcel.writeLong(this.f203185ts);
    }

    protected TroopClipPic(Parcel parcel) {
        this.type = 0;
        this.f203184id = parcel.readString();
        this.clipInfo = parcel.readString();
        this.type = parcel.readInt();
        this.f203185ts = parcel.readLong();
    }
}
