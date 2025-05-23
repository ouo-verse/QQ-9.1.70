package com.tencent.mobileqq.guild.setting.group;

import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/c;", "Lcom/tencent/mobileqq/guild/setting/group/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/setting/group/GroupType;", "b", "Lcom/tencent/mobileqq/guild/setting/group/GroupType;", "e", "()Lcom/tencent/mobileqq/guild/setting/group/GroupType;", NotifyMsgApiImpl.KEY_GROUP_TYPE, "c", "I", "f", "()I", "moreCount", "d", "type", "<init>", "(Lcom/tencent/mobileqq/guild/setting/group/GroupType;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.group.c, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class BindGroupShowMoreData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GroupType groupType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int moreCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int type;

    public /* synthetic */ BindGroupShowMoreData(GroupType groupType, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(groupType, i3, (i17 & 4) != 0 ? 6 : i16);
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
        if (!(other instanceof BindGroupShowMoreData)) {
            return false;
        }
        BindGroupShowMoreData bindGroupShowMoreData = (BindGroupShowMoreData) other;
        if (this.groupType == bindGroupShowMoreData.groupType && this.moreCount == bindGroupShowMoreData.moreCount && getType() == bindGroupShowMoreData.getType()) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getMoreCount() {
        return this.moreCount;
    }

    public int hashCode() {
        return (((this.groupType.hashCode() * 31) + this.moreCount) * 31) + getType();
    }

    @NotNull
    public String toString() {
        return "BindGroupShowMoreData(groupType=" + this.groupType + ", moreCount=" + this.moreCount + ", type=" + getType() + ")";
    }

    public BindGroupShowMoreData(@NotNull GroupType groupType, int i3, int i16) {
        Intrinsics.checkNotNullParameter(groupType, "groupType");
        this.groupType = groupType;
        this.moreCount = i3;
        this.type = i16;
    }
}
