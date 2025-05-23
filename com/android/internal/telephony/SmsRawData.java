package com.android.internal.telephony;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes.dex */
public class SmsRawData implements Parcelable {
    public static final Parcelable.Creator<SmsRawData> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    byte[] f31266d;

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<SmsRawData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SmsRawData createFromParcel(Parcel parcel) {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return new SmsRawData(bArr);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SmsRawData[] newArray(int i3) {
            return new SmsRawData[i3];
        }
    }

    public SmsRawData(byte[] bArr) {
        this.f31266d = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f31266d.length);
        parcel.writeByteArray(this.f31266d);
    }
}
