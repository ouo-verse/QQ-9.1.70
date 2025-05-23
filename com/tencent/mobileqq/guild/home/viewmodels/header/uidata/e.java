package com.tencent.mobileqq.guild.home.viewmodels.header.uidata;

import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001\u0005B=\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010%\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0016R\"\u0010\u000e\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0010\u001a\u0004\b\b\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000bR\u0019\u0010!\u001a\u0004\u0018\u00010\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010%\u001a\u0004\u0018\u00010\"8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010#\u001a\u0004\b\u001a\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/e;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "other", "", "b", "a", "", "c", "e", "Z", "f", "()Z", "setActive", "(Z)V", "isActive", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "g", "(Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;)V", "tintColors", "", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", h.F, "i", "showTips", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "j", "()Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "unreadInfo", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/a;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/a;", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/a;", "capsuleInfo", "<init>", "(ZLcom/tencent/mobileqq/guild/home/viewmodels/header/e;Ljava/lang/String;ZLcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/a;)V", "k", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildHomeCoverColors tintColors;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean showTips;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final UnreadInfo.a unreadInfo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GuildCapsuleInfo capsuleInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(boolean z16, @NotNull GuildHomeCoverColors tintColors, @NotNull String guildId, boolean z17, @Nullable UnreadInfo.a aVar, @Nullable GuildCapsuleInfo guildCapsuleInfo) {
        super(4, false, tintColors, 2, null);
        Intrinsics.checkNotNullParameter(tintColors, "tintColors");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.isActive = z16;
        this.tintColors = tintColors;
        this.guildId = guildId;
        this.showTips = z17;
        this.unreadInfo = aVar;
        this.capsuleInfo = guildCapsuleInfo;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    public boolean a(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof e) || !Intrinsics.areEqual(other.getTintColors(), getTintColors())) {
            return false;
        }
        e eVar = (e) other;
        if (!Intrinsics.areEqual(eVar.guildId, this.guildId) || !Intrinsics.areEqual(eVar.unreadInfo, this.unreadInfo) || !Intrinsics.areEqual(eVar.capsuleInfo, this.capsuleInfo)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    public boolean b(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other.getId() == getId()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    @Nullable
    public Object c(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    @NotNull
    /* renamed from: e, reason: from getter */
    public GuildHomeCoverColors getTintColors() {
        return this.tintColors;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    /* renamed from: f, reason: from getter */
    public boolean getIsActive() {
        return this.isActive;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    public void g(@NotNull GuildHomeCoverColors guildHomeCoverColors) {
        Intrinsics.checkNotNullParameter(guildHomeCoverColors, "<set-?>");
        this.tintColors = guildHomeCoverColors;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final GuildCapsuleInfo getCapsuleInfo() {
        return this.capsuleInfo;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getShowTips() {
        return this.showTips;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final UnreadInfo.a getUnreadInfo() {
        return this.unreadInfo;
    }
}
