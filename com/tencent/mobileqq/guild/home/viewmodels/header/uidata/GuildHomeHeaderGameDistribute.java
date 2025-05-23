package com.tencent.mobileqq.guild.home.viewmodels.header.uidata;

import com.tencent.gamecenter.wadl.distribute.data.GameDistributeExtraInfo;
import com.tencent.gamecenter.wadl.distribute.data.GameDistributeInfo;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0005J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0013\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\r\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010#\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/c;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "other", "", "b", "a", "", "c", "", "toString", "", "hashCode", "equals", "e", "Z", "f", "()Z", "setActive", "(Z)V", "isActive", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "g", "(Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;)V", "tintColors", "Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeInfo;", "Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeInfo;", "i", "()Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeInfo;", "gameDistributeInfo", "Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeExtraInfo;", h.F, "Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeExtraInfo;", "()Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeExtraInfo;", "gameDistributeExtraInfo", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.uidata.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildHomeHeaderGameDistribute extends b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildHomeCoverColors tintColors;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GameDistributeInfo gameDistributeInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final GameDistributeExtraInfo gameDistributeExtraInfo;

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    public boolean a(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof GuildHomeHeaderGameDistribute) || !Intrinsics.areEqual(other.getTintColors(), getTintColors())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    public boolean b(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (getId() == other.getId()) {
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

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHomeHeaderGameDistribute)) {
            return false;
        }
        GuildHomeHeaderGameDistribute guildHomeHeaderGameDistribute = (GuildHomeHeaderGameDistribute) other;
        if (getIsActive() == guildHomeHeaderGameDistribute.getIsActive() && Intrinsics.areEqual(getTintColors(), guildHomeHeaderGameDistribute.getTintColors()) && Intrinsics.areEqual(this.gameDistributeInfo, guildHomeHeaderGameDistribute.gameDistributeInfo) && Intrinsics.areEqual(this.gameDistributeExtraInfo, guildHomeHeaderGameDistribute.gameDistributeExtraInfo)) {
            return true;
        }
        return false;
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
    public final GameDistributeExtraInfo getGameDistributeExtraInfo() {
        return this.gameDistributeExtraInfo;
    }

    public int hashCode() {
        int hashCode;
        boolean isActive = getIsActive();
        int i3 = isActive;
        if (isActive) {
            i3 = 1;
        }
        int hashCode2 = ((((i3 * 31) + getTintColors().hashCode()) * 31) + this.gameDistributeInfo.hashCode()) * 31;
        GameDistributeExtraInfo gameDistributeExtraInfo = this.gameDistributeExtraInfo;
        if (gameDistributeExtraInfo == null) {
            hashCode = 0;
        } else {
            hashCode = gameDistributeExtraInfo.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final GameDistributeInfo getGameDistributeInfo() {
        return this.gameDistributeInfo;
    }

    @NotNull
    public String toString() {
        return "GuildHomeHeaderGameDistribute(isActive=" + getIsActive() + ", tintColors=" + getTintColors() + ", gameDistributeInfo=" + this.gameDistributeInfo + ", gameDistributeExtraInfo=" + this.gameDistributeExtraInfo + ")";
    }
}
