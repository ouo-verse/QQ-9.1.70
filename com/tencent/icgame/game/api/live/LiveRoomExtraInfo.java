package com.tencent.icgame.game.api.live;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LiveRoomExtraInfo implements Parcelable {
    public static final Parcelable.Creator<LiveRoomExtraInfo> CREATOR = new a();
    public String C;
    public String D;
    public Bundle E;
    public boolean F;
    public String G;
    private Map<String, String> H;
    public String I;

    /* renamed from: d, reason: collision with root package name */
    public long f114880d;

    /* renamed from: e, reason: collision with root package name */
    public int f114881e;

    /* renamed from: f, reason: collision with root package name */
    public int f114882f;

    /* renamed from: h, reason: collision with root package name */
    public int f114883h;

    /* renamed from: i, reason: collision with root package name */
    public int f114884i;

    /* renamed from: m, reason: collision with root package name */
    public long f114885m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Parcelable.Creator<LiveRoomExtraInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LiveRoomExtraInfo createFromParcel(Parcel parcel) {
            return new LiveRoomExtraInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LiveRoomExtraInfo[] newArray(int i3) {
            return new LiveRoomExtraInfo[i3];
        }
    }

    public LiveRoomExtraInfo() {
        this.F = false;
        this.G = "";
        this.H = new HashMap();
        this.I = "";
    }

    private void f() {
        if (TextUtils.isEmpty(this.G)) {
            return;
        }
        String[] split = this.G.split("\\?");
        if (split.length != 2) {
            return;
        }
        for (String str : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split2 = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                this.H.put(split2[0], split2[1]);
            }
        }
    }

    private int g(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public int a(String str, int i3) {
        if (this.H.isEmpty()) {
            f();
        }
        String b16 = b(str);
        if (TextUtils.isEmpty(b16)) {
            return i3;
        }
        return g(b16);
    }

    public String b(String str) {
        if (this.H.isEmpty()) {
            f();
        }
        return this.H.get(str);
    }

    public boolean c() {
        if (!String.valueOf(17).equals(this.I) && !String.valueOf(18).equals(this.I) && !String.valueOf(16).equals(this.I) && !String.valueOf(20).equals(this.I)) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        if (String.valueOf(17).equals(this.I) && this.f114881e == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "LiveRoomExtraInfo{roomId=" + this.f114880d + ", roomIndex=" + this.f114881e + ", roomType=" + this.f114882f + ", gameId=" + this.f114883h + ", gameTagId=" + this.f114884i + ", videoSource=" + this.f114885m + ", comingWay='" + this.C + "', traceDetail='" + this.D + "', extra=" + this.E + ", jumpSource='" + this.I + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f114880d);
        parcel.writeInt(this.f114881e);
        parcel.writeInt(this.f114882f);
        parcel.writeInt(this.f114883h);
        parcel.writeInt(this.f114884i);
        parcel.writeLong(this.f114885m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeBundle(this.E);
        parcel.writeString(this.I);
        parcel.writeInt(this.F ? 1 : 0);
    }

    protected LiveRoomExtraInfo(Parcel parcel) {
        this.F = false;
        this.G = "";
        this.H = new HashMap();
        this.I = "";
        this.f114880d = parcel.readLong();
        this.f114881e = parcel.readInt();
        this.f114882f = parcel.readInt();
        this.f114883h = parcel.readInt();
        this.f114884i = parcel.readInt();
        this.f114885m = parcel.readLong();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readBundle();
        this.I = parcel.readString();
        this.F = parcel.readInt() == 1;
    }
}
