package com.tencent.mobileqq.qqexpand.bean.profile;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.data.Card;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExtendFriendInfo implements Parcelable, Cloneable {
    public static final Parcelable.Creator<ExtendFriendInfo> CREATOR = new a();
    public int C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public String H;
    public String I;
    public long J;
    public int K;
    public int L;

    /* renamed from: d, reason: collision with root package name */
    public String f263491d;

    /* renamed from: e, reason: collision with root package name */
    public int f263492e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f263493f;

    /* renamed from: h, reason: collision with root package name */
    public String f263494h;

    /* renamed from: i, reason: collision with root package name */
    public int f263495i;

    /* renamed from: m, reason: collision with root package name */
    public int f263496m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<ExtendFriendInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExtendFriendInfo createFromParcel(Parcel parcel) {
            return new ExtendFriendInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExtendFriendInfo[] newArray(int i3) {
            return new ExtendFriendInfo[i3];
        }
    }

    public ExtendFriendInfo() {
        this.D = 0;
        this.E = 0;
    }

    public boolean a() {
        return true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f263491d);
        parcel.writeInt(this.f263492e);
        parcel.writeString(this.f263494h);
        parcel.writeByte(this.f263493f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f263495i);
        parcel.writeInt(this.f263496m);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeByte(this.F ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.G ? (byte) 1 : (byte) 0);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeLong(this.J);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
    }

    public ExtendFriendInfo(Card card) {
        this.D = 0;
        this.E = 0;
        this.f263491d = card.declaration;
        this.f263492e = card.popularity;
        this.f263494h = card.voiceUrl;
        this.f263493f = card.isShowCard;
        this.f263495i = card.extendFriendVoiceDuration;
        this.f263496m = card.fontId;
        this.C = card.clothesId;
        this.H = card.schoolId;
        this.I = card.schoolName;
        this.J = card.authState;
        this.K = card.idx;
        this.L = card.category;
    }

    protected ExtendFriendInfo(Parcel parcel) {
        this.D = 0;
        this.E = 0;
        this.f263491d = parcel.readString();
        this.f263492e = parcel.readInt();
        this.f263494h = parcel.readString();
        this.f263493f = parcel.readByte() != 0;
        this.f263495i = parcel.readInt();
        this.f263496m = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.F = parcel.readByte() != 0;
        this.G = parcel.readByte() != 0;
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readLong();
        this.K = parcel.readInt();
        this.L = parcel.readInt();
    }
}
