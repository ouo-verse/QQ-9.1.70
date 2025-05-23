package com.tencent.mobileqq.guild.setting.guildmanage.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001\u0017B'\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u001e\u001a\u00020\u000e\u0012\u0006\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010'B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigation/GuildNavigationStatus;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "e", "Z", "a", "()Z", "enableShowNavBar", "f", "b", "setHasNavigationInfo", "(Z)V", "hasNavigationInfo", h.F, "I", "c", "()I", "setStatus", "(I)V", "status", "<init>", "(Ljava/lang/String;ZZI)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class GuildNavigationStatus implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableShowNavBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasNavigationInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int status;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigation/GuildNavigationStatus$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigation/GuildNavigationStatus;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/setting/guildmanage/navigation/GuildNavigationStatus;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.navigation.GuildNavigationStatus$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion implements Parcelable.Creator<GuildNavigationStatus> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildNavigationStatus createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GuildNavigationStatus(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildNavigationStatus[] newArray(int size) {
            return new GuildNavigationStatus[size];
        }

        Companion() {
        }
    }

    public GuildNavigationStatus(@NotNull String guildId, boolean z16, boolean z17, int i3) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.enableShowNavBar = z16;
        this.hasNavigationInfo = z17;
        this.status = i3;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnableShowNavBar() {
        return this.enableShowNavBar;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasNavigationInfo() {
        return this.hasNavigationInfo;
    }

    /* renamed from: c, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildNavigationStatus)) {
            return false;
        }
        GuildNavigationStatus guildNavigationStatus = (GuildNavigationStatus) other;
        if (Intrinsics.areEqual(this.guildId, guildNavigationStatus.guildId) && this.enableShowNavBar == guildNavigationStatus.enableShowNavBar && this.hasNavigationInfo == guildNavigationStatus.hasNavigationInfo && this.status == guildNavigationStatus.status) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.guildId.hashCode() * 31;
        boolean z16 = this.enableShowNavBar;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.hasNavigationInfo;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i17 + i3) * 31) + this.status;
    }

    @NotNull
    public String toString() {
        return "GuildNavigationStatus(guildId=" + this.guildId + ", enableShowNavBar=" + this.enableShowNavBar + ", hasNavigationInfo=" + this.hasNavigationInfo + ", status=" + this.status + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.guildId);
        parcel.writeByte(this.enableShowNavBar ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hasNavigationInfo ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.status);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GuildNavigationStatus(@NotNull Parcel parcel) {
        this(r0 == null ? "" : r0, parcel.readByte() != 0, parcel.readByte() != 0, parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
    }
}
