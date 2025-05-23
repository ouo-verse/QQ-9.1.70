package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u00c6\u0001J\t\u0010\u000f\u001a\u00020\nH\u00d6\u0001R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/b;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/e;", "", "other", "", "equals", "", "hashCode", "", "groupId", "", "groupName", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/GroupSelectType;", "selectType", "b", "toString", "J", "d", "()J", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/GroupSelectType;", "f", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/GroupSelectType;", "<init>", "(JLjava/lang/String;Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/GroupSelectType;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildRiskGroupData extends e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long groupId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String groupName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GroupSelectType selectType;

    public /* synthetic */ GuildRiskGroupData(long j3, String str, GroupSelectType groupSelectType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, (i3 & 4) != 0 ? GroupSelectType.EMPTY_SELECT : groupSelectType);
    }

    public static /* synthetic */ GuildRiskGroupData c(GuildRiskGroupData guildRiskGroupData, long j3, String str, GroupSelectType groupSelectType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = guildRiskGroupData.groupId;
        }
        if ((i3 & 2) != 0) {
            str = guildRiskGroupData.groupName;
        }
        if ((i3 & 4) != 0) {
            groupSelectType = guildRiskGroupData.selectType;
        }
        return guildRiskGroupData.b(j3, str, groupSelectType);
    }

    @NotNull
    public final GuildRiskGroupData b(long groupId, @NotNull String groupName, @NotNull GroupSelectType selectType) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(selectType, "selectType");
        return new GuildRiskGroupData(groupId, groupName, selectType);
    }

    /* renamed from: d, reason: from getter */
    public final long getGroupId() {
        return this.groupId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e
    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(GuildRiskGroupData.class, cls) || !super.equals(other)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GuildRiskGroupData");
        GuildRiskGroupData guildRiskGroupData = (GuildRiskGroupData) other;
        if (this.groupId == guildRiskGroupData.groupId && Intrinsics.areEqual(this.groupName, guildRiskGroupData.groupName) && this.selectType == guildRiskGroupData.selectType) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final GroupSelectType getSelectType() {
        return this.selectType;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e
    public int hashCode() {
        return (((((super.hashCode() * 31) + androidx.fragment.app.a.a(this.groupId)) * 31) + this.groupName.hashCode()) * 31) + this.selectType.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildRiskGroupData(groupId=" + this.groupId + ", groupName=" + this.groupName + ", selectType=" + this.selectType + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRiskGroupData(long j3, @NotNull String groupName, @NotNull GroupSelectType selectType) {
        super(0);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(selectType, "selectType");
        this.groupId = j3;
        this.groupName = groupName;
        this.selectType = selectType;
    }
}
