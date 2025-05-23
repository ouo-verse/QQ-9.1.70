package com.tencent.timi.game.api.param;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public class ExpandHallLaunchParam implements Parcelable {
    public static final Parcelable.Creator<ExpandHallLaunchParam> CREATOR = new a();
    public String C;
    public String D;
    public boolean E;
    public long F;
    public boolean G;
    public long H;
    public boolean I;

    /* renamed from: d, reason: collision with root package name */
    public int f376301d;

    /* renamed from: e, reason: collision with root package name */
    public int f376302e;

    /* renamed from: f, reason: collision with root package name */
    public int f376303f;

    /* renamed from: h, reason: collision with root package name */
    public long f376304h;

    /* renamed from: i, reason: collision with root package name */
    public String f376305i;

    /* renamed from: m, reason: collision with root package name */
    public String f376306m;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface RoomType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface SourceId {
    }

    /* loaded from: classes26.dex */
    class a implements Parcelable.Creator<ExpandHallLaunchParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExpandHallLaunchParam createFromParcel(Parcel parcel) {
            return new ExpandHallLaunchParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExpandHallLaunchParam[] newArray(int i3) {
            return new ExpandHallLaunchParam[i3];
        }
    }

    public ExpandHallLaunchParam() {
        this.f376301d = 1;
        this.f376302e = 1;
        this.f376303f = 101;
        this.f376305i = "";
        this.f376306m = "";
        this.C = "";
        this.D = "1";
        this.E = false;
        this.G = false;
        this.I = false;
    }

    public boolean a(int... iArr) {
        for (int i3 : iArr) {
            if (i3 == this.f376301d) {
                return true;
            }
        }
        return false;
    }

    public boolean b(int i3) {
        if (i3 != this.f376301d) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ExpandHallLaunchParam{sourceId=" + this.f376301d + ", roomType=" + this.f376302e + ", yesGameId=" + this.f376303f + ", guildId=" + this.f376304h + ", channelName='" + this.f376305i + "', channelIcon='" + this.f376306m + "', channelId='" + this.C + "', teamId=" + this.F + ", autoShowTeamList=" + this.G + ", roomId=" + this.H + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f376301d);
        parcel.writeInt(this.f376302e);
        parcel.writeInt(this.f376303f);
        parcel.writeLong(this.f376304h);
        parcel.writeString(this.f376305i);
        parcel.writeString(this.f376306m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeByte(this.E ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.F);
        parcel.writeByte(this.G ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.H);
        parcel.writeByte(this.I ? (byte) 1 : (byte) 0);
    }

    protected ExpandHallLaunchParam(Parcel parcel) {
        this.f376301d = 1;
        this.f376302e = 1;
        this.f376303f = 101;
        this.f376305i = "";
        this.f376306m = "";
        this.C = "";
        this.D = "1";
        this.E = false;
        this.G = false;
        this.I = false;
        this.f376301d = parcel.readInt();
        this.f376302e = parcel.readInt();
        this.f376303f = parcel.readInt();
        this.f376304h = parcel.readLong();
        this.f376305i = parcel.readString();
        this.f376306m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readByte() != 0;
        this.F = parcel.readLong();
        this.G = parcel.readByte() != 0;
        this.H = parcel.readLong();
        this.I = parcel.readByte() != 0;
    }
}
