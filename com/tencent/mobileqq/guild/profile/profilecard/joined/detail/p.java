package com.tencent.mobileqq.guild.profile.profilecard.joined.detail;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/p;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/i;", "a", "Ljava/util/List;", "oldDataList", "b", "newDataList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class p extends DiffUtil.Callback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GuildProfileJoinedData> oldDataList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GuildProfileJoinedData> newDataList;

    public p(@NotNull List<GuildProfileJoinedData> oldDataList, @NotNull List<GuildProfileJoinedData> newDataList) {
        Intrinsics.checkNotNullParameter(oldDataList, "oldDataList");
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        this.oldDataList = oldDataList;
        this.newDataList = newDataList;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        GuildProfileJoinedData guildProfileJoinedData = this.oldDataList.get(oldItemPosition);
        GuildProfileJoinedData guildProfileJoinedData2 = this.newDataList.get(newItemPosition);
        if (Intrinsics.areEqual(guildProfileJoinedData.getGuildId(), guildProfileJoinedData2.getGuildId()) && Intrinsics.areEqual(guildProfileJoinedData.getGuildName(), guildProfileJoinedData2.getGuildName()) && Intrinsics.areEqual(guildProfileJoinedData.getGuildProfile(), guildProfileJoinedData2.getGuildProfile()) && guildProfileJoinedData.getHasMedal() == guildProfileJoinedData2.getHasMedal() && guildProfileJoinedData.getIsLeftItem() == guildProfileJoinedData2.getIsLeftItem() && guildProfileJoinedData.getChannelStatus() == guildProfileJoinedData2.getChannelStatus() && Intrinsics.areEqual(guildProfileJoinedData.getOnlineNumberString(), guildProfileJoinedData2.getOnlineNumberString()) && guildProfileJoinedData.getFriendJoinedNum() == guildProfileJoinedData2.getFriendJoinedNum() && guildProfileJoinedData.o().size() == guildProfileJoinedData2.o().size() && guildProfileJoinedData.l().size() == guildProfileJoinedData2.l().size() && guildProfileJoinedData.n().size() == guildProfileJoinedData2.n().size()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return Intrinsics.areEqual(this.oldDataList.get(oldItemPosition).getGuildId(), this.newDataList.get(newItemPosition).getGuildId());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.newDataList.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.oldDataList.size();
    }
}
