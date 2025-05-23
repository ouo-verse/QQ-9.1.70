package com.tencent.mobileqq.intervideo.singtogether;

import android.os.Parcel;
import android.os.Parcelable;
import tr2.f;

/* compiled from: P */
/* loaded from: classes15.dex */
public class SingTogetherSession extends f implements Parcelable {
    public static final Parcelable.Creator<SingTogetherSession> CREATOR = new a();
    public int L;
    public long M;
    public String N;
    public int P;
    public String Q;
    public String R;
    public long S;
    public String T;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<SingTogetherSession> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SingTogetherSession createFromParcel(Parcel parcel) {
            return new SingTogetherSession(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SingTogetherSession[] newArray(int i3) {
            return new SingTogetherSession[i3];
        }
    }

    public SingTogetherSession(int i3, String str) {
        this.f437187d = 4;
        this.f437188e = i3;
        this.f437189f = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ListenTogetherSession{type=" + this.f437188e + ", uin='" + this.f437189f + "', status=" + this.f437191i + ", timeStamp=" + this.E + ", userState=" + this.f437192m + ", creator='" + this.C + "', joinNum='" + this.f437190h + "', serviceType='" + this.f437187d + "', roomCover='" + this.R + "', singerUin='" + this.S + "', songName='" + this.T + "', identifyId=" + this.I + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f437187d);
        parcel.writeInt(this.f437188e);
        parcel.writeString(this.f437189f);
        parcel.writeInt(this.f437191i);
        parcel.writeLong(this.E);
        parcel.writeInt(this.f437192m);
        parcel.writeString(this.C);
        parcel.writeInt(this.f437190h);
        parcel.writeString(this.R);
        parcel.writeLong(this.S);
        parcel.writeString(this.T);
        parcel.writeLong(this.I);
    }

    SingTogetherSession(Parcel parcel) {
        this.f437187d = parcel.readInt();
        this.f437188e = parcel.readInt();
        this.f437189f = parcel.readString();
        this.f437191i = parcel.readInt();
        this.E = parcel.readLong();
        this.f437192m = parcel.readInt();
        this.C = parcel.readString();
        this.f437190h = parcel.readInt();
        this.R = parcel.readString();
        this.S = parcel.readLong();
        this.T = parcel.readString();
        this.I = parcel.readLong();
    }
}
