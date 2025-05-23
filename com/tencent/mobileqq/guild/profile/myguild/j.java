package com.tencent.mobileqq.guild.profile.myguild;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00068\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/myguild/j;", "", "", "toString", "", "isCollapse", "", "topGuildIds", "Lcom/tencent/mobileqq/guild/profile/myguild/a;", "b", "", "hashCode", "other", "equals", "Lcom/tencent/mobileqq/guild/profile/myguild/GroupType;", "a", "Lcom/tencent/mobileqq/guild/profile/myguild/GroupType;", "()Lcom/tencent/mobileqq/guild/profile/myguild/GroupType;", NotifyMsgApiImpl.KEY_GROUP_TYPE, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Ljava/util/List;", "getGuilds", "()Ljava/util/List;", "guilds", "<init>", "(Lcom/tencent/mobileqq/guild/profile/myguild/GroupType;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GroupType groupType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IGProGuildInfo> guilds;

    /* JADX WARN: Multi-variable type inference failed */
    public j(@NotNull GroupType groupType, @NotNull List<? extends IGProGuildInfo> guilds) {
        Intrinsics.checkNotNullParameter(groupType, "groupType");
        Intrinsics.checkNotNullParameter(guilds, "guilds");
        this.groupType = groupType;
        this.guilds = guilds;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GroupType getGroupType() {
        return this.groupType;
    }

    @NotNull
    public final List<a> b(boolean isCollapse, @NotNull List<String> topGuildIds) {
        int collectionSizeOrDefault;
        boolean z16;
        Intrinsics.checkNotNullParameter(topGuildIds, "topGuildIds");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new GroupData(this.groupType, this.guilds.size(), isCollapse));
        if (isCollapse) {
            return arrayList;
        }
        List<IGProGuildInfo> list = this.guilds;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (IGProGuildInfo iGProGuildInfo : list) {
            String guildID = iGProGuildInfo.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID, "it.guildID");
            String guildName = iGProGuildInfo.getGuildName();
            Intrinsics.checkNotNullExpressionValue(guildName, "it.guildName");
            String avatarUrl = iGProGuildInfo.getAvatarUrl(140);
            Intrinsics.checkNotNullExpressionValue(avatarUrl, "it.getAvatarUrl(IGuiildAvatarUrlType.SIZE_140)");
            if (iGProGuildInfo.getGuildUnNotifyFlag() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            arrayList2.add(new GuildData(guildID, guildName, avatarUrl, z16, topGuildIds.contains(iGProGuildInfo.getGuildID())));
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof j)) {
            return false;
        }
        j jVar = (j) other;
        if (this.groupType == jVar.groupType && Intrinsics.areEqual(this.guilds, jVar.guilds)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.groupType.hashCode() * 31) + this.guilds.hashCode();
    }

    @NotNull
    public String toString() {
        int collectionSizeOrDefault;
        String groupName = this.groupType.getGroupName();
        List<IGProGuildInfo> list = this.guilds;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((IGProGuildInfo) it.next()).getGuildName());
        }
        return "OneGroupData(groupType=" + groupName + ", guilds=" + arrayList;
    }
}
