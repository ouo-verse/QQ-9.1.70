package com.tencent.now.linkpkanchorplay.invite.model;

import com.tencent.now.linkpkanchorplay.componententry.AnchorRoomInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "curSelectInviteType", "Lcom/tencent/now/linkpkanchorplay/componententry/e;", "b", "Lcom/tencent/now/linkpkanchorplay/componententry/e;", "()Lcom/tencent/now/linkpkanchorplay/componententry/e;", "roomInfo", "<init>", "(ILcom/tencent/now/linkpkanchorplay/componententry/e;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.now.linkpkanchorplay.invite.model.a, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class AnchorTabPageContext {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int curSelectInviteType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final AnchorRoomInfo roomInfo;

    public AnchorTabPageContext(int i3, @NotNull AnchorRoomInfo roomInfo) {
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        this.curSelectInviteType = i3;
        this.roomInfo = roomInfo;
    }

    /* renamed from: a, reason: from getter */
    public final int getCurSelectInviteType() {
        return this.curSelectInviteType;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final AnchorRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnchorTabPageContext)) {
            return false;
        }
        AnchorTabPageContext anchorTabPageContext = (AnchorTabPageContext) other;
        if (this.curSelectInviteType == anchorTabPageContext.curSelectInviteType && Intrinsics.areEqual(this.roomInfo, anchorTabPageContext.roomInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.curSelectInviteType * 31) + this.roomInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnchorTabPageContext(curSelectInviteType=" + this.curSelectInviteType + ", roomInfo=" + this.roomInfo + ')';
    }
}
