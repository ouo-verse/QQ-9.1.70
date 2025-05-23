package com.tencent.mobileqq.guild.profile.me.edit;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/edit/ab;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "status", "b", "enable", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "<init>", "(ZZLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.profile.me.edit.ab, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildMeAddFriendModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errorMsg;

    @JvmOverloads
    public GuildMeAddFriendModel(boolean z16) {
        this(z16, false, null, 6, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMeAddFriendModel)) {
            return false;
        }
        GuildMeAddFriendModel guildMeAddFriendModel = (GuildMeAddFriendModel) other;
        if (this.status == guildMeAddFriendModel.status && this.enable == guildMeAddFriendModel.enable && Intrinsics.areEqual(this.errorMsg, guildMeAddFriendModel.errorMsg)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.status;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.enable;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i16 + i3) * 31) + this.errorMsg.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildMeAddFriendModel(status=" + this.status + ", enable=" + this.enable + ", errorMsg=" + this.errorMsg + ")";
    }

    @JvmOverloads
    public GuildMeAddFriendModel(boolean z16, boolean z17) {
        this(z16, z17, null, 4, null);
    }

    @JvmOverloads
    public GuildMeAddFriendModel(boolean z16, boolean z17, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.status = z16;
        this.enable = z17;
        this.errorMsg = errorMsg;
    }

    public /* synthetic */ GuildMeAddFriendModel(boolean z16, boolean z17, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? true : z17, (i3 & 4) != 0 ? "" : str);
    }
}
