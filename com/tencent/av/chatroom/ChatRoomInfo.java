package com.tencent.av.chatroom;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ChatRoomInfo implements Parcelable {
    public static final Parcelable.Creator<ChatRoomInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f73504d;

    /* renamed from: e, reason: collision with root package name */
    public long f73505e;

    /* renamed from: f, reason: collision with root package name */
    public long f73506f;

    /* renamed from: h, reason: collision with root package name */
    public long f73507h;

    /* renamed from: i, reason: collision with root package name */
    private int f73508i = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f73509m = 0;
    public int C = 0;
    public int D = 0;
    public boolean E = false;
    public boolean F = false;
    public boolean G = false;
    public long H = 0;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<ChatRoomInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChatRoomInfo createFromParcel(Parcel parcel) {
            return new ChatRoomInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChatRoomInfo[] newArray(int i3) {
            return new ChatRoomInfo[i3];
        }
    }

    public ChatRoomInfo(int i3, long j3, long j16, long j17) {
        this.f73504d = i3;
        this.f73505e = j3;
        this.f73506f = j16;
        this.f73507h = j17;
    }

    public boolean a() {
        if (this.f73508i <= 3) {
            return true;
        }
        return false;
    }

    public boolean b(int i3, long j3, long j16, long j17) {
        if (this.f73504d == i3 && this.f73505e == j3 && this.f73506f == j16 && this.f73507h == j17) {
            return true;
        }
        return false;
    }

    public void c() {
        this.f73508i++;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChatRoomInfo)) {
            return false;
        }
        ChatRoomInfo chatRoomInfo = (ChatRoomInfo) obj;
        if (this.f73504d != chatRoomInfo.f73504d || this.f73505e != chatRoomInfo.f73505e || this.f73506f != chatRoomInfo.f73506f || this.f73507h != chatRoomInfo.f73507h) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("ChatRoomInfo{");
        sb5.append("type: ");
        sb5.append(this.f73504d);
        sb5.append(", roomID: ");
        sb5.append(this.f73505e);
        sb5.append(", id: ");
        sb5.append(this.f73506f);
        sb5.append(", createTime: ");
        sb5.append(this.f73507h);
        sb5.append(", isFromSwitchTerminal: ");
        sb5.append(this.G);
        sb5.append(", preRoomId: ");
        sb5.append(this.H);
        sb5.append("}");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f73504d);
        parcel.writeLong(this.f73505e);
        parcel.writeLong(this.f73506f);
        parcel.writeLong(this.f73507h);
    }

    protected ChatRoomInfo(Parcel parcel) {
        this.f73504d = parcel.readInt();
        this.f73505e = parcel.readLong();
        this.f73506f = parcel.readLong();
        this.f73507h = parcel.readLong();
    }
}
