package com.tencent.mobileqq.guild.home.viewmodels.header.uidata;

import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "a", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "c", "()Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "setUnreadInfo", "(Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;)V", "unreadInfo", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/a;", "b", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/a;", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/a;", "e", "(Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/a;)V", "capsuleInfo", "Z", "()Z", "setShowTips", "(Z)V", "showTips", "d", "f", ViewStickEventHelper.IS_SHOW, "<init>", "(Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/a;ZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.uidata.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildHomeHeaderGroupChatInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private UnreadInfo.a unreadInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private GuildCapsuleInfo capsuleInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean showTips;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isShow;

    public GuildHomeHeaderGroupChatInfo() {
        this(null, null, false, false, 15, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final GuildCapsuleInfo getCapsuleInfo() {
        return this.capsuleInfo;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getShowTips() {
        return this.showTips;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final UnreadInfo.a getUnreadInfo() {
        return this.unreadInfo;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    public final void e(@Nullable GuildCapsuleInfo guildCapsuleInfo) {
        this.capsuleInfo = guildCapsuleInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHomeHeaderGroupChatInfo)) {
            return false;
        }
        GuildHomeHeaderGroupChatInfo guildHomeHeaderGroupChatInfo = (GuildHomeHeaderGroupChatInfo) other;
        if (Intrinsics.areEqual(this.unreadInfo, guildHomeHeaderGroupChatInfo.unreadInfo) && Intrinsics.areEqual(this.capsuleInfo, guildHomeHeaderGroupChatInfo.capsuleInfo) && this.showTips == guildHomeHeaderGroupChatInfo.showTips && this.isShow == guildHomeHeaderGroupChatInfo.isShow) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.isShow = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        UnreadInfo.a aVar = this.unreadInfo;
        int i3 = 0;
        if (aVar == null) {
            hashCode = 0;
        } else {
            hashCode = aVar.hashCode();
        }
        int i16 = hashCode * 31;
        GuildCapsuleInfo guildCapsuleInfo = this.capsuleInfo;
        if (guildCapsuleInfo != null) {
            i3 = guildCapsuleInfo.hashCode();
        }
        int i17 = (i16 + i3) * 31;
        boolean z16 = this.showTips;
        int i18 = 1;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        int i26 = (i17 + i19) * 31;
        boolean z17 = this.isShow;
        if (!z17) {
            i18 = z17 ? 1 : 0;
        }
        return i26 + i18;
    }

    @NotNull
    public String toString() {
        return "GuildHomeHeaderGroupChatInfo(unreadInfo=" + this.unreadInfo + ", capsuleInfo=" + this.capsuleInfo + ", showTips=" + this.showTips + ", isShow=" + this.isShow + ")";
    }

    public GuildHomeHeaderGroupChatInfo(@Nullable UnreadInfo.a aVar, @Nullable GuildCapsuleInfo guildCapsuleInfo, boolean z16, boolean z17) {
        this.unreadInfo = aVar;
        this.capsuleInfo = guildCapsuleInfo;
        this.showTips = z16;
        this.isShow = z17;
    }

    public /* synthetic */ GuildHomeHeaderGroupChatInfo(UnreadInfo.a aVar, GuildCapsuleInfo guildCapsuleInfo, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aVar, (i3 & 2) != 0 ? null : guildCapsuleInfo, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? false : z17);
    }
}
