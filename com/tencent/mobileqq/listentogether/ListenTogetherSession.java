package com.tencent.mobileqq.listentogether;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ListenTogetherSession extends tr2.f implements Parcelable {
    public static final Parcelable.Creator<ListenTogetherSession> CREATOR = new a();
    public List<MusicInfo> L;
    public boolean M;
    public String N;
    public int P;
    public String Q;
    public int R;
    public boolean S;
    public boolean T;
    public boolean U;
    public int V;
    public int W;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Parcelable.Creator<ListenTogetherSession> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ListenTogetherSession createFromParcel(Parcel parcel) {
            return new ListenTogetherSession(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ListenTogetherSession[] newArray(int i3) {
            return new ListenTogetherSession[i3];
        }
    }

    public ListenTogetherSession(int i3, String str) {
        this.M = false;
        this.T = false;
        this.U = false;
        this.V = 1;
        this.W = 0;
        this.f437187d = 1;
        this.f437188e = i3;
        this.f437189f = str;
    }

    public int b() {
        if (this.f437188e == 1) {
            return -1;
        }
        if (HardCodeUtil.qqStr(R.string.irv).equals(this.N)) {
            return 3;
        }
        if (HardCodeUtil.qqStr(R.string.is6).equals(this.N)) {
            return 2;
        }
        return HardCodeUtil.qqStr(R.string.iso).equals(this.N) ? 1 : 4;
    }

    public MusicInfo c() {
        List<MusicInfo> list;
        if (this.f437191i == 3 || (list = this.L) == null || list.size() <= 0) {
            return null;
        }
        return this.L.get(0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e(int i3, int i16) {
        return d72.b.i(this.f437188e, i3, i16);
    }

    public String f() {
        return this.f437188e + "_" + this.f437189f;
    }

    public void j(ListenTogetherSession listenTogetherSession) {
        this.f437191i = listenTogetherSession.f437191i;
        this.f437192m = listenTogetherSession.f437192m;
        this.N = listenTogetherSession.N;
        this.C = listenTogetherSession.C;
        this.D = listenTogetherSession.D;
        this.P = listenTogetherSession.P;
        this.Q = listenTogetherSession.Q;
        this.S = listenTogetherSession.S;
        this.E = listenTogetherSession.E;
        this.L = listenTogetherSession.L;
        this.R = listenTogetherSession.R;
        this.T = listenTogetherSession.T;
        this.U = listenTogetherSession.U;
        this.V = listenTogetherSession.V;
        this.I = listenTogetherSession.I;
    }

    public String toString() {
        return "ListenTogetherSession{type=" + this.f437188e + ", uin='" + this.f437189f + "', status=" + this.f437191i + ", musicList=" + this.L + ", timeStamp=" + this.E + ", fold=" + this.M + ", userState=" + this.f437192m + ", creator='" + this.C + "', playMode='" + this.V + "', joinedType=" + this.P + ", joinedUin='" + this.Q + "', joinedIsCreator=" + this.S + ", themeId=" + this.R + ", bAlowMemberStart=" + this.T + ", bAlowMemberAddSong=" + this.U + ", identifyId=" + this.I + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f437187d);
        parcel.writeInt(this.f437188e);
        parcel.writeString(this.f437189f);
        parcel.writeInt(this.f437191i);
        parcel.writeTypedList(this.L);
        parcel.writeLong(this.E);
        parcel.writeByte(this.M ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f437192m);
        parcel.writeString(this.N);
        parcel.writeString(this.C);
        parcel.writeInt(this.P);
        parcel.writeString(this.Q);
        parcel.writeByte(this.S ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.V);
        parcel.writeLong(this.I);
        parcel.writeString(this.D);
    }

    ListenTogetherSession(Parcel parcel) {
        this.M = false;
        this.T = false;
        this.U = false;
        this.V = 1;
        this.W = 0;
        this.f437187d = parcel.readInt();
        this.f437188e = parcel.readInt();
        this.f437189f = parcel.readString();
        this.f437191i = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.L = arrayList;
        parcel.readTypedList(arrayList, MusicInfo.CREATOR);
        this.E = parcel.readLong();
        this.M = parcel.readByte() == 1;
        this.f437192m = parcel.readInt();
        this.N = parcel.readString();
        this.C = parcel.readString();
        this.P = parcel.readInt();
        this.Q = parcel.readString();
        this.S = parcel.readByte() == 1;
        this.V = parcel.readInt();
        this.I = parcel.readLong();
        this.D = parcel.readString();
    }
}
