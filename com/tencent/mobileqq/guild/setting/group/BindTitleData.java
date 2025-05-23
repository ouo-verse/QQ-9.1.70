package com.tencent.mobileqq.guild.setting.group;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0001H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u0012\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/e;", "Lcom/tencent/mobileqq/guild/setting/group/a;", "newData", "", "f", "newItem", "", "c", "", "toString", "", "hashCode", "other", "equals", "b", "Z", "e", "()Z", "needShowSortView", "g", "isSorting", "d", "I", "()I", "type", "<init>", "(ZZI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.group.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class BindTitleData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needShowSortView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSorting;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int type;

    public /* synthetic */ BindTitleData(boolean z16, boolean z17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, z17, (i16 & 4) != 0 ? 1 : i3);
    }

    private final boolean f(BindTitleData newData) {
        if (this.needShowSortView == newData.needShowSortView && getType() == newData.getType()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.setting.group.a
    @Nullable
    public Object c(@NotNull a newItem) {
        int i3;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof BindTitleData)) {
            return null;
        }
        BindTitleData bindTitleData = (BindTitleData) newItem;
        if (!f(bindTitleData)) {
            return null;
        }
        if (bindTitleData.isSorting) {
            i3 = 3;
        } else {
            i3 = 4;
        }
        return Integer.valueOf(i3);
    }

    @Override // com.tencent.mobileqq.guild.setting.group.a
    /* renamed from: d, reason: from getter */
    public int getType() {
        return this.type;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getNeedShowSortView() {
        return this.needShowSortView;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindTitleData)) {
            return false;
        }
        BindTitleData bindTitleData = (BindTitleData) other;
        if (this.needShowSortView == bindTitleData.needShowSortView && this.isSorting == bindTitleData.isSorting && getType() == bindTitleData.getType()) {
            return true;
        }
        return false;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsSorting() {
        return this.isSorting;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        boolean z16 = this.needShowSortView;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = i16 * 31;
        boolean z17 = this.isSorting;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i17 + i3) * 31) + getType();
    }

    @NotNull
    public String toString() {
        return "BindTitleData(needShowSortView=" + this.needShowSortView + ", isSorting=" + this.isSorting + ", type=" + getType() + ")";
    }

    public BindTitleData(boolean z16, boolean z17, int i3) {
        this.needShowSortView = z16;
        this.isSorting = z17;
        this.type = i3;
    }
}
