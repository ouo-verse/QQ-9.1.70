package com.tencent.mobileqq.nearby.ipc;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes33.dex */
public class BasicTypeDataParcel implements Parcelable {
    public static final Parcelable.Creator<BasicTypeDataParcel> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f252605d;

    /* renamed from: e, reason: collision with root package name */
    public Object[] f252606e;

    /* loaded from: classes33.dex */
    class a implements Parcelable.Creator<BasicTypeDataParcel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BasicTypeDataParcel createFromParcel(Parcel parcel) {
            return new BasicTypeDataParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BasicTypeDataParcel[] newArray(int i3) {
            return new BasicTypeDataParcel[i3];
        }
    }

    public BasicTypeDataParcel(int i3, Object... objArr) {
        this.f252605d = i3;
        this.f252606e = objArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("--------------------start-------------------");
        sb5.append("\n");
        sb5.append(this.f252605d);
        sb5.append("\n");
        if (this.f252606e != null) {
            int i3 = 0;
            while (true) {
                Object[] objArr = this.f252606e;
                if (i3 >= objArr.length) {
                    break;
                }
                sb5.append(objArr[i3]);
                sb5.append("\n");
                i3++;
            }
        }
        sb5.append("--------------------end-------------------");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f252605d);
        parcel.writeArray(this.f252606e);
    }

    protected BasicTypeDataParcel(Parcel parcel) {
        this.f252605d = parcel.readInt();
        this.f252606e = parcel.readArray(Object.class.getClassLoader());
    }
}
