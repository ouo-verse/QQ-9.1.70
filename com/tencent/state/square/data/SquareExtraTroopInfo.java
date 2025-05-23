package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/data/SquareExtraTroopInfo;", "", "isDisturb", "", "needLandAnim", "needRingAnim", "changeAvatarImageVisible", "(ZZZLjava/lang/Boolean;)V", "getChangeAvatarImageVisible", "()Ljava/lang/Boolean;", "setChangeAvatarImageVisible", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "()Z", "setDisturb", "(Z)V", "getNeedLandAnim", "setNeedLandAnim", "getNeedRingAnim", "setNeedRingAnim", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareExtraTroopInfo {
    private Boolean changeAvatarImageVisible;
    private boolean isDisturb;
    private boolean needLandAnim;
    private boolean needRingAnim;

    public SquareExtraTroopInfo() {
        this(false, false, false, null, 15, null);
    }

    public final Boolean getChangeAvatarImageVisible() {
        return this.changeAvatarImageVisible;
    }

    public final boolean getNeedLandAnim() {
        return this.needLandAnim;
    }

    public final boolean getNeedRingAnim() {
        return this.needRingAnim;
    }

    /* renamed from: isDisturb, reason: from getter */
    public final boolean getIsDisturb() {
        return this.isDisturb;
    }

    public final void setChangeAvatarImageVisible(Boolean bool) {
        this.changeAvatarImageVisible = bool;
    }

    public final void setDisturb(boolean z16) {
        this.isDisturb = z16;
    }

    public final void setNeedLandAnim(boolean z16) {
        this.needLandAnim = z16;
    }

    public final void setNeedRingAnim(boolean z16) {
        this.needRingAnim = z16;
    }

    public SquareExtraTroopInfo(boolean z16, boolean z17, boolean z18, Boolean bool) {
        this.isDisturb = z16;
        this.needLandAnim = z17;
        this.needRingAnim = z18;
        this.changeAvatarImageVisible = bool;
    }

    public /* synthetic */ SquareExtraTroopInfo(boolean z16, boolean z17, boolean z18, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18, (i3 & 8) != 0 ? null : bool);
    }
}
