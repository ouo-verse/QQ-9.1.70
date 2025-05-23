package com.tencent.luggage.wxa.b4;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qbar.QBar;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends QBar.QBarResult implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f121842a;

    /* renamed from: b, reason: collision with root package name */
    public c f121843b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i3) {
            return new d[i3];
        }
    }

    public d(int i3, String str, String str2, byte[] bArr, String str3, int i16) {
        this.f121842a = 0;
        this.typeID = i3;
        this.typeName = str;
        this.data = str2;
        this.rawData = bArr;
        this.charset = str3;
        this.priorityLevel = i16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.typeID);
        parcel.writeString(this.typeName);
        parcel.writeString(this.data);
        parcel.writeByteArray(this.rawData);
        parcel.writeString(this.charset);
        parcel.writeInt(this.f121842a);
        parcel.writeParcelable(this.f121843b, i3);
        parcel.writeInt(this.priorityLevel);
    }

    public d(Parcel parcel) {
        this.f121842a = 0;
        this.typeID = parcel.readInt();
        this.typeName = parcel.readString();
        this.data = parcel.readString();
        parcel.readByteArray(this.rawData);
        this.charset = parcel.readString();
        this.f121842a = parcel.readInt();
        this.f121843b = (c) parcel.readParcelable(c.class.getClassLoader());
        this.priorityLevel = parcel.readInt();
    }
}
