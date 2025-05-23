package com.tencent.mobileqq.search.model;

import addcontacts.AccountSearchPb$record;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchResultItem implements Parcelable {
    public static final Parcelable.Creator<SearchResultItem> CREATOR = new a();
    public byte C;
    public byte[] D;
    public byte[] E;
    public int F;
    public int G;
    public int H;

    /* renamed from: d, reason: collision with root package name */
    public long f283460d;

    /* renamed from: e, reason: collision with root package name */
    public int f283461e;

    /* renamed from: f, reason: collision with root package name */
    public String f283462f;

    /* renamed from: h, reason: collision with root package name */
    public String f283463h;

    /* renamed from: i, reason: collision with root package name */
    public byte f283464i;

    /* renamed from: m, reason: collision with root package name */
    public byte f283465m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<SearchResultItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SearchResultItem createFromParcel(Parcel parcel) {
            return new SearchResultItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SearchResultItem[] newArray(int i3) {
            return new SearchResultItem[i3];
        }
    }

    public SearchResultItem() {
        this.f283460d = 0L;
        this.f283461e = 0;
        this.f283462f = "";
        this.f283463h = "";
        this.f283464i = (byte) 0;
        this.f283465m = (byte) 0;
        this.C = (byte) 0;
        this.D = null;
        this.E = null;
        this.F = 0;
        this.G = 0;
        this.H = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f283460d);
        parcel.writeInt(this.f283461e);
        parcel.writeString(this.f283462f);
        parcel.writeString(this.f283463h);
        parcel.writeByte(this.f283464i);
        parcel.writeByte(this.f283465m);
        parcel.writeByte(this.C);
        parcel.writeByteArray(this.D);
        parcel.writeByteArray(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.H);
    }

    public SearchResultItem(AccountSearchPb$record accountSearchPb$record) {
        this.f283460d = 0L;
        this.f283461e = 0;
        this.f283462f = "";
        this.f283463h = "";
        this.f283464i = (byte) 0;
        this.f283465m = (byte) 0;
        this.C = (byte) 0;
        this.D = null;
        this.E = null;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        if (accountSearchPb$record != null) {
            this.f283460d = accountSearchPb$record.uin.get();
            this.f283461e = accountSearchPb$record.source.get();
            this.f283462f = accountSearchPb$record.name.get();
            this.f283463h = accountSearchPb$record.mobile.get();
            this.f283464i = (byte) (accountSearchPb$record.relation.get() & 1);
            this.f283465m = (byte) (accountSearchPb$record.relation.get() & 2);
            this.E = accountSearchPb$record.bytes_token.get().toByteArray();
        }
    }

    protected SearchResultItem(Parcel parcel) {
        this.f283460d = 0L;
        this.f283461e = 0;
        this.f283462f = "";
        this.f283463h = "";
        this.f283464i = (byte) 0;
        this.f283465m = (byte) 0;
        this.C = (byte) 0;
        this.D = null;
        this.E = null;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.f283460d = parcel.readLong();
        this.f283461e = parcel.readInt();
        this.f283462f = parcel.readString();
        this.f283463h = parcel.readString();
        this.f283464i = parcel.readByte();
        this.f283465m = parcel.readByte();
        this.C = parcel.readByte();
        this.D = parcel.createByteArray();
        this.E = parcel.createByteArray();
        this.F = parcel.readInt();
        this.H = parcel.readInt();
    }
}
