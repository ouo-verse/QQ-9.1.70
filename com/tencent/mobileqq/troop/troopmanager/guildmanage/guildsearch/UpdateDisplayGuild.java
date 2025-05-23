package com.tencent.mobileqq.troop.troopmanager.guildmanage.guildsearch;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qqnt.kernel.nativeinterface.AIOBindGuildInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/guildsearch/UpdateDisplayGuild;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "guildInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "(Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;)V", "getGuildInfo", "()Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final /* data */ class UpdateDisplayGuild extends SimpleBaseEvent {

    @Nullable
    private final AIOBindGuildInfo guildInfo;

    public UpdateDisplayGuild(@Nullable AIOBindGuildInfo aIOBindGuildInfo) {
        this.guildInfo = aIOBindGuildInfo;
    }

    public static /* synthetic */ UpdateDisplayGuild copy$default(UpdateDisplayGuild updateDisplayGuild, AIOBindGuildInfo aIOBindGuildInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aIOBindGuildInfo = updateDisplayGuild.guildInfo;
        }
        return updateDisplayGuild.copy(aIOBindGuildInfo);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final AIOBindGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    @NotNull
    public final UpdateDisplayGuild copy(@Nullable AIOBindGuildInfo guildInfo) {
        return new UpdateDisplayGuild(guildInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof UpdateDisplayGuild) && Intrinsics.areEqual(this.guildInfo, ((UpdateDisplayGuild) other).guildInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final AIOBindGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public int hashCode() {
        AIOBindGuildInfo aIOBindGuildInfo = this.guildInfo;
        if (aIOBindGuildInfo == null) {
            return 0;
        }
        return aIOBindGuildInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "UpdateDisplayGuild(guildInfo=" + this.guildInfo + ")";
    }
}
