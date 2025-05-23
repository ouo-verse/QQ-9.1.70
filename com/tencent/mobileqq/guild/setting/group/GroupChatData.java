package com.tencent.mobileqq.guild.setting.group;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\r\u0012\b\b\u0002\u0010,\u001a\u00020'\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0001H\u0016J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010 \u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010\"\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b!\u0010\u0017R\u001a\u0010&\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\u001a\u0010%R\"\u0010,\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010(\u001a\u0004\b#\u0010)\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/p;", "Lcom/tencent/mobileqq/guild/setting/group/a;", "newData", "", "k", "j", "other", "b", "newItem", "", "c", "", "toString", "", "hashCode", "equals", "", "J", "f", "()J", "id", "Z", tl.h.F, "()Z", "isBindGroup", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindingGroup;", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindingGroup;", "e", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindingGroup;", "groupData", "l", "isSorting", "i", "isBindLimited", "g", "I", "()I", "type", "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "()Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "setPositionType", "(Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;)V", "positionType", "<init>", "(JZLcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindingGroup;ZZILcom/tencent/mobileqq/guild/setting/group/ItemPositionType;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.group.p, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GroupChatData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isBindGroup;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IGProBindingGroup groupData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSorting;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isBindLimited;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ItemPositionType positionType;

    public /* synthetic */ GroupChatData(long j3, boolean z16, IGProBindingGroup iGProBindingGroup, boolean z17, boolean z18, int i3, ItemPositionType itemPositionType, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, z16, iGProBindingGroup, (i16 & 8) != 0 ? false : z17, (i16 & 16) != 0 ? false : z18, (i16 & 32) != 0 ? 0 : i3, (i16 & 64) != 0 ? ItemPositionType.Middle : itemPositionType);
    }

    private final boolean j(GroupChatData newData) {
        if (this.id == newData.id && this.isBindGroup == newData.isBindGroup && Intrinsics.areEqual(this.groupData, newData.groupData) && this.isSorting == newData.isSorting && this.isBindLimited == newData.isBindLimited && getType() == newData.getType() && this.positionType != newData.positionType) {
            return true;
        }
        return false;
    }

    private final boolean k(GroupChatData newData) {
        if (this.id == newData.id && this.isBindGroup == newData.isBindGroup && Intrinsics.areEqual(this.groupData, newData.groupData) && this.isBindLimited == newData.isBindLimited && getType() == newData.getType() && this.positionType == newData.positionType && this.isSorting != newData.isSorting) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.setting.group.a
    public boolean b(@NotNull a other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if ((other instanceof GroupChatData) && getType() == other.getType() && this.id == ((GroupChatData) other).id) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.setting.group.a
    @Nullable
    public Object c(@NotNull a newItem) {
        int i3;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof GroupChatData)) {
            return null;
        }
        GroupChatData groupChatData = (GroupChatData) newItem;
        if (k(groupChatData)) {
            if (groupChatData.isSorting) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            return Integer.valueOf(i3);
        }
        if (!j(groupChatData)) {
            return null;
        }
        return 5;
    }

    @Override // com.tencent.mobileqq.guild.setting.group.a
    /* renamed from: d, reason: from getter */
    public int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final IGProBindingGroup getGroupData() {
        return this.groupData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupChatData)) {
            return false;
        }
        GroupChatData groupChatData = (GroupChatData) other;
        if (this.id == groupChatData.id && this.isBindGroup == groupChatData.isBindGroup && Intrinsics.areEqual(this.groupData, groupChatData.groupData) && this.isSorting == groupChatData.isSorting && this.isBindLimited == groupChatData.isBindLimited && getType() == groupChatData.getType() && this.positionType == groupChatData.positionType) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final ItemPositionType getPositionType() {
        return this.positionType;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsBindGroup() {
        return this.isBindGroup;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = androidx.fragment.app.a.a(this.id) * 31;
        boolean z16 = this.isBindGroup;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode = (((a16 + i16) * 31) + this.groupData.hashCode()) * 31;
        boolean z17 = this.isSorting;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (hashCode + i17) * 31;
        boolean z18 = this.isBindLimited;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return ((((i18 + i3) * 31) + getType()) * 31) + this.positionType.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsBindLimited() {
        return this.isBindLimited;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsSorting() {
        return this.isSorting;
    }

    @NotNull
    public String toString() {
        return "GroupChatData(id=" + this.id + ", isBindGroup=" + this.isBindGroup + ", groupData=" + this.groupData + ", isSorting=" + this.isSorting + ", isBindLimited=" + this.isBindLimited + ", type=" + getType() + ", positionType=" + this.positionType + ")";
    }

    public GroupChatData(long j3, boolean z16, @NotNull IGProBindingGroup groupData, boolean z17, boolean z18, int i3, @NotNull ItemPositionType positionType) {
        Intrinsics.checkNotNullParameter(groupData, "groupData");
        Intrinsics.checkNotNullParameter(positionType, "positionType");
        this.id = j3;
        this.isBindGroup = z16;
        this.groupData = groupData;
        this.isSorting = z17;
        this.isBindLimited = z18;
        this.type = i3;
        this.positionType = positionType;
    }
}
