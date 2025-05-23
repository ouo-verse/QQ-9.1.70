package com.tencent.mobileqq.guild.setting.group;

import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0017\u0012\b\b\u0002\u0010!\u001a\u00020\b\u00a2\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0016J\t\u0010\u0007\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b\u0018\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/b;", "Lcom/tencent/mobileqq/guild/setting/group/a;", "", "g", "newItem", "", "c", "toString", "", "hashCode", "other", "", "equals", "b", "Z", tl.h.F, "()Z", "isCollapse", "Lcom/tencent/mobileqq/guild/setting/group/GroupType;", "Lcom/tencent/mobileqq/guild/setting/group/GroupType;", "e", "()Lcom/tencent/mobileqq/guild/setting/group/GroupType;", NotifyMsgApiImpl.KEY_GROUP_TYPE, "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "d", "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "f", "()Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "setPositionType", "(Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;)V", "positionType", "I", "()I", "type", "<init>", "(ZLcom/tencent/mobileqq/guild/setting/group/GroupType;Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.group.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class BindGroupGroupData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isCollapse;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GroupType groupType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ItemPositionType positionType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int type;

    public /* synthetic */ BindGroupGroupData(boolean z16, GroupType groupType, ItemPositionType itemPositionType, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, groupType, (i16 & 4) != 0 ? ItemPositionType.Top : itemPositionType, (i16 & 8) != 0 ? 5 : i3);
    }

    @Override // com.tencent.mobileqq.guild.setting.group.a
    @Nullable
    public Object c(@NotNull a newItem) {
        int i3;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof BindGroupGroupData)) {
            return null;
        }
        BindGroupGroupData bindGroupGroupData = (BindGroupGroupData) newItem;
        if (this.groupType != bindGroupGroupData.groupType) {
            return null;
        }
        boolean z16 = this.isCollapse;
        boolean z17 = bindGroupGroupData.isCollapse;
        if (z16 == z17) {
            return null;
        }
        if (z17) {
            i3 = 7;
        } else {
            i3 = 6;
        }
        return Integer.valueOf(i3);
    }

    @Override // com.tencent.mobileqq.guild.setting.group.a
    /* renamed from: d, reason: from getter */
    public int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final GroupType getGroupType() {
        return this.groupType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindGroupGroupData)) {
            return false;
        }
        BindGroupGroupData bindGroupGroupData = (BindGroupGroupData) other;
        if (this.isCollapse == bindGroupGroupData.isCollapse && this.groupType == bindGroupGroupData.groupType && this.positionType == bindGroupGroupData.positionType && getType() == bindGroupGroupData.getType()) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final ItemPositionType getPositionType() {
        return this.positionType;
    }

    @NotNull
    public final String g() {
        return this.groupType.getGroupName();
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsCollapse() {
        return this.isCollapse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        boolean z16 = this.isCollapse;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return (((((i3 * 31) + this.groupType.hashCode()) * 31) + this.positionType.hashCode()) * 31) + getType();
    }

    @NotNull
    public String toString() {
        return "BindGroupGroupData(isCollapse=" + this.isCollapse + ", groupType=" + this.groupType + ", positionType=" + this.positionType + ", type=" + getType() + ")";
    }

    public BindGroupGroupData(boolean z16, @NotNull GroupType groupType, @NotNull ItemPositionType positionType, int i3) {
        Intrinsics.checkNotNullParameter(groupType, "groupType");
        Intrinsics.checkNotNullParameter(positionType, "positionType");
        this.isCollapse = z16;
        this.groupType = groupType;
        this.positionType = positionType;
        this.type = i3;
    }
}
