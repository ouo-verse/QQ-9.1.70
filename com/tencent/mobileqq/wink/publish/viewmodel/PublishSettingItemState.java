package com.tencent.mobileqq.wink.publish.viewmodel;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J'\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/q;", "", "", "toString", "", NodeProps.VISIBLE, "selectable", "isSelected", "a", "", "hashCode", "other", "equals", "Z", "d", "()Z", "f", "(Z)V", "b", "c", "setSelectable", "e", "setSelected", "<init>", "(ZZZ)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.publish.viewmodel.q, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PublishSettingItemState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean visible;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean selectable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelected;

    public PublishSettingItemState(boolean z16, boolean z17, boolean z18) {
        this.visible = z16;
        this.selectable = z17;
        this.isSelected = z18;
    }

    public static /* synthetic */ PublishSettingItemState b(PublishSettingItemState publishSettingItemState, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = publishSettingItemState.visible;
        }
        if ((i3 & 2) != 0) {
            z17 = publishSettingItemState.selectable;
        }
        if ((i3 & 4) != 0) {
            z18 = publishSettingItemState.isSelected;
        }
        return publishSettingItemState.a(z16, z17, z18);
    }

    @NotNull
    public final PublishSettingItemState a(boolean visible, boolean selectable, boolean isSelected) {
        return new PublishSettingItemState(visible, selectable, isSelected);
    }

    /* renamed from: c, reason: from getter */
    public final boolean getSelectable() {
        return this.selectable;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishSettingItemState)) {
            return false;
        }
        PublishSettingItemState publishSettingItemState = (PublishSettingItemState) other;
        if (this.visible == publishSettingItemState.visible && this.selectable == publishSettingItemState.selectable && this.isSelected == publishSettingItemState.isSelected) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.visible = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.visible;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.selectable;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z17 = this.isSelected;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i18 + i3;
    }

    @NotNull
    public String toString() {
        return "PublishSettingItemState(visible=" + this.visible + ", selectable=" + this.selectable + ", isSelected=" + this.isSelected + ")";
    }
}
