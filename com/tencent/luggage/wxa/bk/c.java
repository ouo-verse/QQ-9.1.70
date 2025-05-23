package com.tencent.luggage.wxa.bk;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f122968a;

    /* renamed from: b, reason: collision with root package name */
    public String f122969b;

    /* renamed from: c, reason: collision with root package name */
    public String f122970c;

    /* renamed from: d, reason: collision with root package name */
    public String f122971d;

    /* renamed from: e, reason: collision with root package name */
    public String f122972e;

    /* renamed from: f, reason: collision with root package name */
    public String f122973f;

    /* renamed from: g, reason: collision with root package name */
    public int f122974g;

    /* renamed from: h, reason: collision with root package name */
    public String f122975h;

    /* renamed from: i, reason: collision with root package name */
    public int f122976i;

    /* renamed from: j, reason: collision with root package name */
    public float f122977j;

    /* renamed from: k, reason: collision with root package name */
    public float f122978k;

    /* renamed from: l, reason: collision with root package name */
    public long f122979l;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c(Parcel parcel) {
        this.f122968a = parcel.readString();
        this.f122969b = parcel.readString();
        this.f122970c = parcel.readString();
        this.f122971d = parcel.readString();
        this.f122972e = parcel.readString();
        this.f122973f = parcel.readString();
        this.f122974g = parcel.readInt();
        this.f122975h = parcel.readString();
        this.f122976i = parcel.readInt();
        this.f122977j = parcel.readFloat();
        this.f122978k = parcel.readFloat();
        this.f122979l = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AppBrandRecommendStatObj{username=" + this.f122968a + ", recommend_id='" + this.f122969b + "', strategy_info=" + this.f122970c + ", appid='" + this.f122971d + "', page_path=" + this.f122972e + ", page_param=" + this.f122973f + ", card_type=" + this.f122974g + ", pass_str=" + this.f122975h + ", position=" + this.f122976i + ", longitude=" + this.f122977j + ", latitude=" + this.f122978k + ", sessionId=" + this.f122979l + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f122968a);
        parcel.writeString(this.f122969b);
        parcel.writeString(this.f122970c);
        parcel.writeString(this.f122971d);
        parcel.writeString(this.f122972e);
        parcel.writeString(this.f122973f);
        parcel.writeInt(this.f122974g);
        parcel.writeString(this.f122975h);
        parcel.writeInt(this.f122976i);
        parcel.writeFloat(this.f122977j);
        parcel.writeFloat(this.f122978k);
        parcel.writeLong(this.f122979l);
    }
}
