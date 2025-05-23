package com.tencent.mobileqq.guild.setting.guildmanage.riskmember;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/a;", "", "", "a", "", "toString", "", "hashCode", "other", "", "equals", "Z", "c", "()Z", "setShowBatchHandleLayout", "(Z)V", "showBatchHandleLayout", "b", "d", "setEditMode", "isEditMode", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/k;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/k;", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/k;", "setSelectedMemberInfo", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/k;)V", "selectedMemberInfo", "<init>", "(ZZLcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/k;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class BatchHandleRiskData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean showBatchHandleLayout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isEditMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.k selectedMemberInfo;

    public BatchHandleRiskData() {
        this(false, false, null, 7, null);
    }

    public final long a() {
        return this.selectedMemberInfo.c();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.k getSelectedMemberInfo() {
        return this.selectedMemberInfo;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getShowBatchHandleLayout() {
        return this.showBatchHandleLayout;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsEditMode() {
        return this.isEditMode;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchHandleRiskData)) {
            return false;
        }
        BatchHandleRiskData batchHandleRiskData = (BatchHandleRiskData) other;
        if (this.showBatchHandleLayout == batchHandleRiskData.showBatchHandleLayout && this.isEditMode == batchHandleRiskData.isEditMode && Intrinsics.areEqual(this.selectedMemberInfo, batchHandleRiskData.selectedMemberInfo)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.showBatchHandleLayout;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.isEditMode;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i16 + i3) * 31) + this.selectedMemberInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "BatchHandleRiskData(showBatchHandleLayout=" + this.showBatchHandleLayout + ", isEditMode=" + this.isEditMode + ", selectedMemberInfo=" + this.selectedMemberInfo + ")";
    }

    public BatchHandleRiskData(boolean z16, boolean z17, @NotNull com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.k selectedMemberInfo) {
        Intrinsics.checkNotNullParameter(selectedMemberInfo, "selectedMemberInfo");
        this.showBatchHandleLayout = z16;
        this.isEditMode = z17;
        this.selectedMemberInfo = selectedMemberInfo;
    }

    public /* synthetic */ BatchHandleRiskData(boolean z16, boolean z17, com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.k kVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? new com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.k(0L, false, null, 7, null) : kVar);
    }
}
