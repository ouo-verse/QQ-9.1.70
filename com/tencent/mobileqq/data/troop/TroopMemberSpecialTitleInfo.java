package com.tencent.mobileqq.data.troop;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0087\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001/B/\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\b\u00a2\u0006\u0004\b+\u0010,B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b+\u0010-J\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\t\u0010\u000e\u001a\u00020\rH\u00c6\u0003J\t\u0010\u000f\u001a\u00020\rH\u00c6\u0003J\t\u0010\u0010\u001a\u00020\rH\u00c6\u0003J\t\u0010\u0011\u001a\u00020\rH\u00c6\u0003J\t\u0010\u0012\u001a\u00020\bH\u00c6\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\bH\u00c6\u0001J\t\u0010\u0019\u001a\u00020\rH\u00d6\u0001J\t\u0010\u001a\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003R\u0017\u0010\u0013\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0014\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b!\u0010 R\u0017\u0010\u0015\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\"\u0010 R\"\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b#\u0010 \"\u0004\b$\u0010%R\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/data/troop/TroopMemberSpecialTitleInfo;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "", "isExpiredSoon", "isExpired", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "component1", "component2", "component3", "component4", "component5", "troopUin", "uin", "friendNick", "specialTitle", "expireTimeSec", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "getUin", "getFriendNick", "getSpecialTitle", "setSpecialTitle", "(Ljava/lang/String;)V", "I", "getExpireTimeSec", "()I", "setExpireTimeSec", "(I)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "imcore-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class TroopMemberSpecialTitleInfo implements Serializable, Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int SPECIAL_TITLE_EXPIRE_SOON_TIME = 259200;
    private int expireTimeSec;

    @NotNull
    private final String friendNick;

    @NotNull
    private String specialTitle;

    @NotNull
    private final String troopUin;

    @NotNull
    private final String uin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/data/troop/TroopMemberSpecialTitleInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/data/troop/TroopMemberSpecialTitleInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/data/troop/TroopMemberSpecialTitleInfo;", "SPECIAL_TITLE_EXPIRE_SOON_TIME", "I", "<init>", "()V", "imcore-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion implements Parcelable.Creator<TroopMemberSpecialTitleInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopMemberSpecialTitleInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TroopMemberSpecialTitleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TroopMemberSpecialTitleInfo[] newArray(int size) {
            return new TroopMemberSpecialTitleInfo[size];
        }

        Companion() {
        }
    }

    public TroopMemberSpecialTitleInfo(@NotNull String troopUin, @NotNull String uin, @NotNull String friendNick, @NotNull String specialTitle, int i3) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(friendNick, "friendNick");
        Intrinsics.checkNotNullParameter(specialTitle, "specialTitle");
        this.troopUin = troopUin;
        this.uin = uin;
        this.friendNick = friendNick;
        this.specialTitle = specialTitle;
        this.expireTimeSec = i3;
    }

    public static /* synthetic */ TroopMemberSpecialTitleInfo copy$default(TroopMemberSpecialTitleInfo troopMemberSpecialTitleInfo, String str, String str2, String str3, String str4, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = troopMemberSpecialTitleInfo.troopUin;
        }
        if ((i16 & 2) != 0) {
            str2 = troopMemberSpecialTitleInfo.uin;
        }
        String str5 = str2;
        if ((i16 & 4) != 0) {
            str3 = troopMemberSpecialTitleInfo.friendNick;
        }
        String str6 = str3;
        if ((i16 & 8) != 0) {
            str4 = troopMemberSpecialTitleInfo.specialTitle;
        }
        String str7 = str4;
        if ((i16 & 16) != 0) {
            i3 = troopMemberSpecialTitleInfo.expireTimeSec;
        }
        return troopMemberSpecialTitleInfo.copy(str, str5, str6, str7, i3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getFriendNick() {
        return this.friendNick;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getSpecialTitle() {
        return this.specialTitle;
    }

    /* renamed from: component5, reason: from getter */
    public final int getExpireTimeSec() {
        return this.expireTimeSec;
    }

    @NotNull
    public final TroopMemberSpecialTitleInfo copy(@NotNull String troopUin, @NotNull String uin, @NotNull String friendNick, @NotNull String specialTitle, int expireTimeSec) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(friendNick, "friendNick");
        Intrinsics.checkNotNullParameter(specialTitle, "specialTitle");
        return new TroopMemberSpecialTitleInfo(troopUin, uin, friendNick, specialTitle, expireTimeSec);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopMemberSpecialTitleInfo)) {
            return false;
        }
        TroopMemberSpecialTitleInfo troopMemberSpecialTitleInfo = (TroopMemberSpecialTitleInfo) other;
        if (Intrinsics.areEqual(this.troopUin, troopMemberSpecialTitleInfo.troopUin) && Intrinsics.areEqual(this.uin, troopMemberSpecialTitleInfo.uin) && Intrinsics.areEqual(this.friendNick, troopMemberSpecialTitleInfo.friendNick) && Intrinsics.areEqual(this.specialTitle, troopMemberSpecialTitleInfo.specialTitle) && this.expireTimeSec == troopMemberSpecialTitleInfo.expireTimeSec) {
            return true;
        }
        return false;
    }

    public final int getExpireTimeSec() {
        return this.expireTimeSec;
    }

    @NotNull
    public final String getFriendNick() {
        return this.friendNick;
    }

    @NotNull
    public final String getSpecialTitle() {
        return this.specialTitle;
    }

    @NotNull
    public final String getTroopUin() {
        return this.troopUin;
    }

    @NotNull
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        return (((((((this.troopUin.hashCode() * 31) + this.uin.hashCode()) * 31) + this.friendNick.hashCode()) * 31) + this.specialTitle.hashCode()) * 31) + this.expireTimeSec;
    }

    public final boolean isExpired() {
        long serverTime = NetConnInfoCenter.getServerTime();
        int i3 = this.expireTimeSec;
        if (i3 > 0 && i3 - serverTime < 0) {
            return true;
        }
        return false;
    }

    public final boolean isExpiredSoon() {
        long serverTime = NetConnInfoCenter.getServerTime();
        int i3 = this.expireTimeSec;
        if (i3 > 0 && i3 - serverTime < 259200) {
            return true;
        }
        return false;
    }

    public final void setExpireTimeSec(int i3) {
        this.expireTimeSec = i3;
    }

    public final void setSpecialTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.specialTitle = str;
    }

    @NotNull
    public String toString() {
        return "TroopMemberSpecialTitleInfo(troopUin=" + this.troopUin + ", uin=" + this.uin + ", friendNick=" + this.friendNick + ", specialTitle=" + this.specialTitle + ", expireTimeSec=" + this.expireTimeSec + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.troopUin);
        parcel.writeString(this.uin);
        parcel.writeString(this.friendNick);
        parcel.writeString(this.specialTitle);
        parcel.writeInt(this.expireTimeSec);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TroopMemberSpecialTitleInfo(@NotNull Parcel parcel) {
        this(r3, r4, r5, r0 == null ? "" : r0, parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
    }
}
