package com.tencent.robot.profile.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001a\u0010\u0012\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/profile/data/c;", "Lcom/tencent/robot/profile/data/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Z", "()Z", "showDivider", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "itemId", "<init>", "(ZLjava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.c, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AddToTroopTitleData extends a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean showDivider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String itemId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddToTroopTitleData(boolean z16, @NotNull String itemId) {
        super(AddToTroopItemType.TITLE, itemId, null);
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.showDivider = z16;
        this.itemId = itemId;
    }

    @Override // com.tencent.robot.profile.data.a
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getItemId() {
        return this.itemId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getShowDivider() {
        return this.showDivider;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddToTroopTitleData)) {
            return false;
        }
        AddToTroopTitleData addToTroopTitleData = (AddToTroopTitleData) other;
        if (this.showDivider == addToTroopTitleData.showDivider && Intrinsics.areEqual(getItemId(), addToTroopTitleData.getItemId())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        boolean z16 = this.showDivider;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return (i3 * 31) + getItemId().hashCode();
    }

    @NotNull
    public String toString() {
        return "AddToTroopTitleData(showDivider=" + this.showDivider + ", itemId=" + getItemId() + ")";
    }
}
