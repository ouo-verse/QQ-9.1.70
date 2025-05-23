package com.tencent.mobileqq.guild.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildEmojiDetailsData implements Parcelable {
    public static final Parcelable.Creator<GuildEmojiDetailsData> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private String f216394d;

    /* renamed from: e, reason: collision with root package name */
    private String f216395e;

    /* renamed from: f, reason: collision with root package name */
    private String f216396f;

    /* renamed from: h, reason: collision with root package name */
    private long f216397h;

    /* renamed from: i, reason: collision with root package name */
    private int f216398i;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<b> f216399m;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements Parcelable.Creator<GuildEmojiDetailsData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildEmojiDetailsData createFromParcel(Parcel parcel) {
            return new GuildEmojiDetailsData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildEmojiDetailsData[] newArray(int i3) {
            return new GuildEmojiDetailsData[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f216400a;

        /* renamed from: b, reason: collision with root package name */
        public int f216401b;

        /* renamed from: c, reason: collision with root package name */
        public int f216402c;
    }

    public GuildEmojiDetailsData(String str, String str2, long j3, int i3, ArrayList<b> arrayList) {
        this.f216396f = str2;
        this.f216394d = str;
        this.f216397h = j3;
        this.f216398i = i3;
        this.f216399m = arrayList;
    }

    public String a() {
        return this.f216396f;
    }

    public ArrayList<b> b() {
        return this.f216399m;
    }

    public String c() {
        return this.f216394d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f216398i;
    }

    public String toString() {
        return "GuildEmojiDetailsData{mGuildId='" + this.f216394d + "', mTroopUin='" + this.f216395e + "', mChannelId='" + this.f216396f + "', mMsgSeqno=" + this.f216397h + ", mSelectedTabPosition=" + this.f216398i + ", mEmojiList=" + this.f216399m + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f216394d);
        parcel.writeString(this.f216395e);
        parcel.writeString(this.f216396f);
        parcel.writeLong(this.f216397h);
        parcel.writeInt(this.f216398i);
        parcel.writeList(this.f216399m);
    }

    protected GuildEmojiDetailsData(Parcel parcel) {
        this.f216394d = parcel.readString();
        this.f216395e = parcel.readString();
        this.f216396f = parcel.readString();
        this.f216397h = parcel.readLong();
        this.f216398i = parcel.readInt();
        this.f216399m = parcel.readArrayList(getClass().getClassLoader());
    }
}
