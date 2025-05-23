package com.tencent.mobileqq.zplan.minihome;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/an;", "", "", "toString", "", "hashCode", "other", "", "equals", "bootHasDownload", "Z", "b", "()Z", "roomHasDownload", "c", "avatarHasDownload", "a", "bootResTimeCost", "Ljava/lang/String;", "getBootResTimeCost", "()Ljava/lang/String;", "bootTimeCost", "getBootTimeCost", "userRoomResTimeCost", "getUserRoomResTimeCost", "loadUserRoomTimeCost", "getLoadUserRoomTimeCost", "avatarResTimeCost", "getAvatarResTimeCost", "resetAvatarTimeCost", "getResetAvatarTimeCost", "<init>", "(ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.minihome.an, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class MiniHomeTimeStat {

    @SerializedName("avatarHasDownload")
    private final boolean avatarHasDownload;

    @SerializedName("avatarResTimeCost")
    private final String avatarResTimeCost;

    @SerializedName("bootHasDownload")
    private final boolean bootHasDownload;

    @SerializedName("bootResTimeCost")
    private final String bootResTimeCost;

    @SerializedName("bootTimeCost")
    private final String bootTimeCost;

    @SerializedName("loadUserRoomTimeCost")
    private final String loadUserRoomTimeCost;

    @SerializedName("resetAvatarTimeCost")
    private final String resetAvatarTimeCost;

    @SerializedName("roomHasDownload")
    private final boolean roomHasDownload;

    @SerializedName("userRoomResTimeCost")
    private final String userRoomResTimeCost;

    public MiniHomeTimeStat() {
        this(false, false, false, null, null, null, null, null, null, 511, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAvatarHasDownload() {
        return this.avatarHasDownload;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getBootHasDownload() {
        return this.bootHasDownload;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getRoomHasDownload() {
        return this.roomHasDownload;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.bootHasDownload;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        ?? r26 = this.roomHasDownload;
        int i16 = r26;
        if (r26 != 0) {
            i16 = 1;
        }
        int i17 = (i3 + i16) * 31;
        boolean z17 = this.avatarHasDownload;
        int i18 = (i17 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        String str = this.bootResTimeCost;
        int hashCode = (i18 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bootTimeCost;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userRoomResTimeCost;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.loadUserRoomTimeCost;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.avatarResTimeCost;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.resetAvatarTimeCost;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "MiniHomeTimeStat(bootHasDownload=" + this.bootHasDownload + ", roomHasDownload=" + this.roomHasDownload + ", avatarHasDownload=" + this.avatarHasDownload + ", bootResTimeCost=" + this.bootResTimeCost + ", bootTimeCost=" + this.bootTimeCost + ", userRoomResTimeCost=" + this.userRoomResTimeCost + ", loadUserRoomTimeCost=" + this.loadUserRoomTimeCost + ", avatarResTimeCost=" + this.avatarResTimeCost + ", resetAvatarTimeCost=" + this.resetAvatarTimeCost + ")";
    }

    public MiniHomeTimeStat(boolean z16, boolean z17, boolean z18, String str, String str2, String str3, String str4, String str5, String str6) {
        this.bootHasDownload = z16;
        this.roomHasDownload = z17;
        this.avatarHasDownload = z18;
        this.bootResTimeCost = str;
        this.bootTimeCost = str2;
        this.userRoomResTimeCost = str3;
        this.loadUserRoomTimeCost = str4;
        this.avatarResTimeCost = str5;
        this.resetAvatarTimeCost = str6;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniHomeTimeStat)) {
            return false;
        }
        MiniHomeTimeStat miniHomeTimeStat = (MiniHomeTimeStat) other;
        return this.bootHasDownload == miniHomeTimeStat.bootHasDownload && this.roomHasDownload == miniHomeTimeStat.roomHasDownload && this.avatarHasDownload == miniHomeTimeStat.avatarHasDownload && Intrinsics.areEqual(this.bootResTimeCost, miniHomeTimeStat.bootResTimeCost) && Intrinsics.areEqual(this.bootTimeCost, miniHomeTimeStat.bootTimeCost) && Intrinsics.areEqual(this.userRoomResTimeCost, miniHomeTimeStat.userRoomResTimeCost) && Intrinsics.areEqual(this.loadUserRoomTimeCost, miniHomeTimeStat.loadUserRoomTimeCost) && Intrinsics.areEqual(this.avatarResTimeCost, miniHomeTimeStat.avatarResTimeCost) && Intrinsics.areEqual(this.resetAvatarTimeCost, miniHomeTimeStat.resetAvatarTimeCost);
    }

    public /* synthetic */ MiniHomeTimeStat(boolean z16, boolean z17, boolean z18, String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? true : z17, (i3 & 4) == 0 ? z18 : true, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? null : str4, (i3 & 128) != 0 ? null : str5, (i3 & 256) == 0 ? str6 : null);
    }
}
