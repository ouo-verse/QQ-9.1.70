package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;

/* loaded from: classes9.dex */
public final class ParcelableMMKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private final String f154051d;

    /* renamed from: e, reason: collision with root package name */
    private int f154052e;

    /* renamed from: f, reason: collision with root package name */
    private int f154053f;

    /* renamed from: h, reason: collision with root package name */
    private String f154054h;

    /* loaded from: classes9.dex */
    class a implements Parcelable.Creator<ParcelableMMKV> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableMMKV createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            String readString2 = parcel.readString();
            if (parcelFileDescriptor != null && parcelFileDescriptor2 != null) {
                return new ParcelableMMKV(readString, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), readString2, null);
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableMMKV[] newArray(int i3) {
            return new ParcelableMMKV[i3];
        }
    }

    /* synthetic */ ParcelableMMKV(String str, int i3, int i16, String str2, a aVar) {
        this(str, i3, i16, str2);
    }

    public MMKV a() {
        int i3;
        int i16 = this.f154052e;
        if (i16 >= 0 && (i3 = this.f154053f) >= 0) {
            return MMKV.Y(this.f154051d, i16, i3, this.f154054h);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        try {
            parcel.writeString(this.f154051d);
            ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.f154052e);
            ParcelFileDescriptor fromFd2 = ParcelFileDescriptor.fromFd(this.f154053f);
            int i16 = i3 | 1;
            fromFd.writeToParcel(parcel, i16);
            fromFd2.writeToParcel(parcel, i16);
            String str = this.f154054h;
            if (str != null) {
                parcel.writeString(str);
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public ParcelableMMKV(MMKV mmkv) {
        this.f154052e = -1;
        this.f154053f = -1;
        this.f154054h = null;
        this.f154051d = mmkv.mmapID();
        this.f154052e = mmkv.ashmemFD();
        this.f154053f = mmkv.ashmemMetaFD();
        this.f154054h = mmkv.cryptKey();
    }

    ParcelableMMKV(String str, int i3, int i16, String str2) {
        this.f154051d = str;
        this.f154052e = i3;
        this.f154053f = i16;
        this.f154054h = str2;
    }
}
