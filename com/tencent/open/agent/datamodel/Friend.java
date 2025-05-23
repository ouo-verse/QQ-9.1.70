package com.tencent.open.agent.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Friend implements Parcelable {
    public static final Parcelable.Creator<Friend> CREATOR = new a();
    public int C;
    public int D;
    public String E;
    public String F;

    /* renamed from: d, reason: collision with root package name */
    public String f340346d;

    /* renamed from: e, reason: collision with root package name */
    public String f340347e;

    /* renamed from: f, reason: collision with root package name */
    public String f340348f;

    /* renamed from: h, reason: collision with root package name */
    public String f340349h;

    /* renamed from: i, reason: collision with root package name */
    public int f340350i;

    /* renamed from: m, reason: collision with root package name */
    public String f340351m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Parcelable.Creator<Friend> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Friend createFromParcel(Parcel parcel) {
            Friend friend = new Friend();
            friend.f340346d = parcel.readString();
            friend.f340347e = parcel.readString();
            friend.f340348f = parcel.readString();
            friend.f340349h = parcel.readString();
            friend.f340350i = parcel.readInt();
            friend.f340351m = parcel.readString();
            return friend;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Friend[] newArray(int i3) {
            return new Friend[i3];
        }
    }

    public Friend() {
        this.f340350i = -1;
        this.f340347e = "";
        this.f340348f = "";
        this.f340349h = "";
        this.C = -1;
        this.D = -1;
        this.E = "";
        this.F = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Friend friend = (Friend) obj;
        String str = this.f340346d;
        if (str == null) {
            return false;
        }
        return str.equals(friend.f340346d);
    }

    public int hashCode() {
        String str = this.f340346d;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f340346d);
        parcel.writeString(this.f340347e);
        parcel.writeString(this.f340348f);
        parcel.writeString(this.f340349h);
        parcel.writeInt(this.f340350i);
        parcel.writeString(this.f340351m);
    }

    public Friend(Friend friend) {
        this.f340350i = -1;
        this.f340346d = friend.f340346d;
        this.f340347e = friend.f340347e;
        this.f340348f = friend.f340348f;
        this.f340349h = friend.f340349h;
        this.C = friend.C;
        this.D = friend.D;
        this.E = friend.E;
        this.F = friend.F;
        this.f340350i = friend.f340350i;
        this.f340351m = friend.f340351m;
    }
}
