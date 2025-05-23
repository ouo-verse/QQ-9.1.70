package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlackUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001c\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\bJ\b\u0010\u0011\u001a\u00020\u0006H\u0016R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040)8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010*\u001a\u0004\b\"\u0010+\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/i;", "", "", "groupId", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/j;", "b", "", "guildId", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRiskMemberGroupInfo;", "groupList", "", "a", "", "selectAll", "tinyIdList", tl.h.F, "toString", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/State;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/State;", "c", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/State;", "i", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/State;)V", "currentState", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "tipsTitle", "e", "j", "tipsSubTitle", "d", "J", "g", "()J", "l", "(J)V", "totalNum", "", "Ljava/util/List;", "()Ljava/util/List;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long totalNum;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private State currentState = State.IDLE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String tipsTitle = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String tipsSubTitle = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<j> groupList = new ArrayList();

    private final j b(long groupId) {
        Object obj;
        boolean z16;
        Iterator<T> it = this.groupList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((j) obj).getCom.tencent.mobileqq.vas.vipav.api.VipFunCallConstants.KEY_GROUP java.lang.String().getGroupId() == groupId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (j) obj;
    }

    public final void a(@NotNull String guildId, @NotNull List<? extends IGProRiskMemberGroupInfo> groupList) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(groupList, "groupList");
        for (IGProRiskMemberGroupInfo iGProRiskMemberGroupInfo : groupList) {
            j b16 = b(iGProRiskMemberGroupInfo.getGroupId());
            if (b16 == null) {
                if (!iGProRiskMemberGroupInfo.getRptMemberList().isEmpty()) {
                    long groupId = iGProRiskMemberGroupInfo.getGroupId();
                    String groupName = iGProRiskMemberGroupInfo.getGroupName();
                    Intrinsics.checkNotNullExpressionValue(groupName, "groupInfo.groupName");
                    j jVar = new j(new GuildRiskGroupData(groupId, groupName, null, 4, null), new ArrayList());
                    this.groupList.add(jVar);
                    b16 = jVar;
                }
            }
            ArrayList<GuildRiskMemberData> b17 = b16.b();
            Iterator<IGProBlackUserInfo> it = iGProRiskMemberGroupInfo.getRptMemberList().iterator();
            while (it.hasNext()) {
                IGProBlackUserInfo next = it.next();
                long tinyId = next.getTinyId();
                String nickName = next.getNickName();
                Intrinsics.checkNotNullExpressionValue(nickName, "memberData.nickName");
                String avatarUrl = next.getAvatarUrl();
                Intrinsics.checkNotNullExpressionValue(avatarUrl, "memberData.avatarUrl");
                b17.add(new GuildRiskMemberData(guildId, tinyId, nickName, avatarUrl, false, false, 48, null));
            }
        }
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final State getCurrentState() {
        return this.currentState;
    }

    @NotNull
    public final List<j> d() {
        return this.groupList;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getTipsSubTitle() {
        return this.tipsSubTitle;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getTipsTitle() {
        return this.tipsTitle;
    }

    /* renamed from: g, reason: from getter */
    public final long getTotalNum() {
        return this.totalNum;
    }

    public final void h(boolean selectAll, @NotNull List<Long> tinyIdList) {
        long coerceAtLeast;
        Intrinsics.checkNotNullParameter(tinyIdList, "tinyIdList");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (j jVar : this.groupList) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            ArrayList<GuildRiskMemberData> b16 = jVar.b();
            Iterator<GuildRiskMemberData> it = b16.iterator();
            while (it.hasNext()) {
                GuildRiskMemberData memberData = it.next();
                if ((!selectAll && tinyIdList.contains(Long.valueOf(memberData.getTinyId()))) || (selectAll && !tinyIdList.contains(Long.valueOf(memberData.getTinyId())))) {
                    Intrinsics.checkNotNullExpressionValue(memberData, "memberData");
                    linkedHashSet2.add(memberData);
                }
            }
            if (linkedHashSet2.size() > 0) {
                b16.removeAll(linkedHashSet2);
            }
            if (b16.size() == 0) {
                linkedHashSet.add(jVar);
            }
        }
        if (linkedHashSet.size() > 0) {
            this.groupList.removeAll(linkedHashSet);
        }
        if (!selectAll) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.totalNum - tinyIdList.size(), 0L);
        } else {
            coerceAtLeast = tinyIdList.size();
        }
        this.totalNum = coerceAtLeast;
    }

    public final void i(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.currentState = state;
    }

    public final void j(@Nullable String str) {
        this.tipsSubTitle = str;
    }

    public final void k(@Nullable String str) {
        this.tipsTitle = str;
    }

    public final void l(long j3) {
        this.totalNum = j3;
    }

    @NotNull
    public String toString() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        String joinToString$default;
        List<j> list = this.groupList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (j jVar : list) {
            String groupName = jVar.getCom.tencent.mobileqq.vas.vipav.api.VipFunCallConstants.KEY_GROUP java.lang.String().getGroupName();
            ArrayList<GuildRiskMemberData> b16 = jVar.b();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it = b16.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.valueOf(((GuildRiskMemberData) it.next()).getTinyId()));
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null);
            arrayList.add(groupName + ":[" + joinToString$default + "]");
        }
        return "LoadedRiskData{tipsTitle = " + this.tipsTitle + ", tipsSubTitle = " + this.tipsSubTitle + ", totalNum = " + this.totalNum + ", groupList = " + arrayList + "}";
    }
}
