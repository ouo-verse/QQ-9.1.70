package com.tencent.mobileqq.guild.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;

/* loaded from: classes12.dex */
public class LaunchGuildChatPieParam implements Parcelable {
    public static final Parcelable.Creator<LaunchGuildChatPieParam> CREATOR = new a();
    public int C;
    public boolean D;
    public int E;
    public boolean F;
    public Bundle G;
    public MsgRecord H;

    /* renamed from: d, reason: collision with root package name */
    public String f214354d;

    /* renamed from: e, reason: collision with root package name */
    public String f214355e;

    /* renamed from: f, reason: collision with root package name */
    public String f214356f;

    /* renamed from: h, reason: collision with root package name */
    public int f214357h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f214358i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f214359m;

    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<LaunchGuildChatPieParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LaunchGuildChatPieParam createFromParcel(Parcel parcel) {
            return new LaunchGuildChatPieParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LaunchGuildChatPieParam[] newArray(int i3) {
            return new LaunchGuildChatPieParam[i3];
        }
    }

    public LaunchGuildChatPieParam() {
        this.f214357h = 0;
        this.f214359m = true;
        this.C = 1;
        this.f214358i = false;
        this.D = false;
        this.E = 0;
        this.F = true;
        this.G = new Bundle();
    }

    public LaunchGuildChatPieParam b(String str) {
        this.f214355e = str;
        return this;
    }

    public LaunchGuildChatPieParam c(int i3) {
        this.f214357h = i3;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LaunchGuildChatPieParam e(boolean z16) {
        this.F = z16;
        return this;
    }

    public LaunchGuildChatPieParam f(boolean z16) {
        this.D = z16;
        return this;
    }

    public LaunchGuildChatPieParam g(int i3) {
        this.E = i3;
        return this;
    }

    public String j() {
        Bundle bundle = this.G;
        if (bundle != null) {
            return bundle.getString(AppConstants.Key.GUILD_INBOX_NODE_TYPE);
        }
        return "";
    }

    public LaunchGuildChatPieParam k(Bundle bundle) {
        this.G = bundle;
        return this;
    }

    public LaunchGuildChatPieParam l(String str) {
        this.f214354d = str;
        return this;
    }

    public boolean m() {
        Bundle bundle = this.G;
        if (bundle == null || bundle.getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 0).byteValue() != 1) {
            return false;
        }
        return true;
    }

    public boolean n() {
        if (TextUtils.isEmpty(this.f214355e)) {
            return false;
        }
        return true;
    }

    public LaunchGuildChatPieParam o(int i3) {
        this.C = i3;
        return this;
    }

    public LaunchGuildChatPieParam p(MsgRecord msgRecord) {
        this.H = msgRecord;
        return this;
    }

    public LaunchGuildChatPieParam q(String str) {
        this.f214356f = str;
        return this;
    }

    public LaunchGuildChatPieParam r(boolean z16) {
        this.f214359m = z16;
        return this;
    }

    public String toString() {
        String bundle;
        StringBuilder sb5 = new StringBuilder(200);
        sb5.append("guildId:");
        sb5.append(this.f214354d);
        sb5.append(" ");
        sb5.append("channelId:");
        sb5.append(this.f214355e);
        sb5.append(" ");
        sb5.append("uinName:");
        sb5.append(this.f214356f);
        sb5.append(" ");
        sb5.append("channelType:");
        sb5.append(this.f214357h);
        sb5.append(" ");
        sb5.append("keepOpenPos:");
        sb5.append(this.f214358i);
        sb5.append(" ");
        sb5.append("withoutAnimation:");
        sb5.append(this.f214359m);
        sb5.append(" ");
        sb5.append("showType:");
        sb5.append(this.C);
        sb5.append(" ");
        sb5.append("forceStartActivity:");
        sb5.append(this.D);
        sb5.append(" ");
        sb5.append("from:");
        sb5.append(this.E);
        sb5.append(" ");
        sb5.append("diableReuse:");
        sb5.append(this.F);
        sb5.append(" ");
        sb5.append("guildExtra:");
        Bundle bundle2 = this.G;
        if (bundle2 == null) {
            bundle = "";
        } else {
            bundle = bundle2.toString();
        }
        sb5.append(bundle);
        sb5.append(" ");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f214354d);
        parcel.writeString(this.f214355e);
        parcel.writeString(this.f214356f);
        parcel.writeInt(this.f214357h);
        parcel.writeByte(this.f214358i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f214359m ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.C);
        parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.E);
        parcel.writeByte(this.F ? (byte) 1 : (byte) 0);
        parcel.writeBundle(this.G);
    }

    protected LaunchGuildChatPieParam(Parcel parcel) {
        this.f214354d = parcel.readString();
        this.f214355e = parcel.readString();
        this.f214356f = parcel.readString();
        this.f214357h = parcel.readInt();
        this.f214358i = parcel.readByte() != 0;
        this.f214359m = parcel.readByte() != 0;
        this.C = parcel.readInt();
        this.D = parcel.readByte() != 0;
        this.E = parcel.readInt();
        this.F = parcel.readByte() != 0;
        this.G = parcel.readBundle(getClass().getClassLoader());
    }

    public LaunchGuildChatPieParam a() {
        return this;
    }
}
