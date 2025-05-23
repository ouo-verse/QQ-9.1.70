package com.tencent.state.square.data;

import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.state.square.EntranceLink;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\bH\u00c6\u0003J\t\u0010+\u001a\u00020\nH\u00c6\u0003J\t\u0010,\u001a\u00020\nH\u00c6\u0003J\t\u0010-\u001a\u00020\rH\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003Je\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001J\u0013\u00100\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u00020\nH\u00d6\u0001J\t\u00103\u001a\u000204H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#\u00a8\u00065"}, d2 = {"Lcom/tencent/state/square/data/SquareAnchorEntrance;", "", "anchorLeft", "", "anchorTop", "anchorRight", "anchorBottom", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "Lcom/tencent/state/square/EntranceLink;", "status", "", "richStatus", "needUnlock", "", "anchorBubble", "Lcom/tencent/state/square/data/AnchorBubble;", "(FFFFLcom/tencent/state/square/EntranceLink;IIZLcom/tencent/state/square/data/AnchorBubble;)V", "getAnchorBottom", "()F", "getAnchorBubble", "()Lcom/tencent/state/square/data/AnchorBubble;", "setAnchorBubble", "(Lcom/tencent/state/square/data/AnchorBubble;)V", "getAnchorLeft", "getAnchorRight", "getAnchorTop", "getLink", "()Lcom/tencent/state/square/EntranceLink;", "getNeedUnlock", "()Z", "setNeedUnlock", "(Z)V", "getRichStatus", "()I", "setRichStatus", "(I)V", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "setStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareAnchorEntrance {
    private final float anchorBottom;
    private AnchorBubble anchorBubble;
    private final float anchorLeft;
    private final float anchorRight;
    private final float anchorTop;
    private final EntranceLink link;
    private boolean needUnlock;
    private int richStatus;
    private int status;

    public SquareAnchorEntrance() {
        this(0.0f, 0.0f, 0.0f, 0.0f, null, 0, 0, false, null, 511, null);
    }

    /* renamed from: component1, reason: from getter */
    public final float getAnchorLeft() {
        return this.anchorLeft;
    }

    /* renamed from: component2, reason: from getter */
    public final float getAnchorTop() {
        return this.anchorTop;
    }

    /* renamed from: component3, reason: from getter */
    public final float getAnchorRight() {
        return this.anchorRight;
    }

    /* renamed from: component4, reason: from getter */
    public final float getAnchorBottom() {
        return this.anchorBottom;
    }

    /* renamed from: component5, reason: from getter */
    public final EntranceLink getLink() {
        return this.link;
    }

    /* renamed from: component6, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRichStatus() {
        return this.richStatus;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getNeedUnlock() {
        return this.needUnlock;
    }

    /* renamed from: component9, reason: from getter */
    public final AnchorBubble getAnchorBubble() {
        return this.anchorBubble;
    }

    public final SquareAnchorEntrance copy(float anchorLeft, float anchorTop, float anchorRight, float anchorBottom, EntranceLink link, int status, int richStatus, boolean needUnlock, AnchorBubble anchorBubble) {
        Intrinsics.checkNotNullParameter(link, "link");
        return new SquareAnchorEntrance(anchorLeft, anchorTop, anchorRight, anchorBottom, link, status, richStatus, needUnlock, anchorBubble);
    }

    public final float getAnchorBottom() {
        return this.anchorBottom;
    }

    public final AnchorBubble getAnchorBubble() {
        return this.anchorBubble;
    }

    public final float getAnchorLeft() {
        return this.anchorLeft;
    }

    public final float getAnchorRight() {
        return this.anchorRight;
    }

    public final float getAnchorTop() {
        return this.anchorTop;
    }

    public final EntranceLink getLink() {
        return this.link;
    }

    public final boolean getNeedUnlock() {
        return this.needUnlock;
    }

    public final int getRichStatus() {
        return this.richStatus;
    }

    public final int getStatus() {
        return this.status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((Float.floatToIntBits(this.anchorLeft) * 31) + Float.floatToIntBits(this.anchorTop)) * 31) + Float.floatToIntBits(this.anchorRight)) * 31) + Float.floatToIntBits(this.anchorBottom)) * 31;
        EntranceLink entranceLink = this.link;
        int hashCode = (((((floatToIntBits + (entranceLink != null ? entranceLink.hashCode() : 0)) * 31) + this.status) * 31) + this.richStatus) * 31;
        boolean z16 = this.needUnlock;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        AnchorBubble anchorBubble = this.anchorBubble;
        return i16 + (anchorBubble != null ? anchorBubble.hashCode() : 0);
    }

    public final void setAnchorBubble(AnchorBubble anchorBubble) {
        this.anchorBubble = anchorBubble;
    }

    public final void setNeedUnlock(boolean z16) {
        this.needUnlock = z16;
    }

    public final void setRichStatus(int i3) {
        this.richStatus = i3;
    }

    public final void setStatus(int i3) {
        this.status = i3;
    }

    public String toString() {
        return "SquareAnchorEntrance(anchorLeft=" + this.anchorLeft + ", anchorTop=" + this.anchorTop + ", anchorRight=" + this.anchorRight + ", anchorBottom=" + this.anchorBottom + ", link=" + this.link + ", status=" + this.status + ", richStatus=" + this.richStatus + ", needUnlock=" + this.needUnlock + ", anchorBubble=" + this.anchorBubble + ")";
    }

    public SquareAnchorEntrance(float f16, float f17, float f18, float f19, EntranceLink link, int i3, int i16, boolean z16, AnchorBubble anchorBubble) {
        Intrinsics.checkNotNullParameter(link, "link");
        this.anchorLeft = f16;
        this.anchorTop = f17;
        this.anchorRight = f18;
        this.anchorBottom = f19;
        this.link = link;
        this.status = i3;
        this.richStatus = i16;
        this.needUnlock = z16;
        this.anchorBubble = anchorBubble;
    }

    public /* synthetic */ SquareAnchorEntrance(float f16, float f17, float f18, float f19, EntranceLink entranceLink, int i3, int i16, boolean z16, AnchorBubble anchorBubble, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0.0f : f16, (i17 & 2) != 0 ? 0.0f : f17, (i17 & 4) != 0 ? 0.0f : f18, (i17 & 8) == 0 ? f19 : 0.0f, (i17 & 16) != 0 ? new EntranceLink("", 0) : entranceLink, (i17 & 32) != 0 ? -1 : i3, (i17 & 64) == 0 ? i16 : -1, (i17 & 128) == 0 ? z16 : false, (i17 & 256) != 0 ? null : anchorBubble);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareAnchorEntrance)) {
            return false;
        }
        SquareAnchorEntrance squareAnchorEntrance = (SquareAnchorEntrance) other;
        return Float.compare(this.anchorLeft, squareAnchorEntrance.anchorLeft) == 0 && Float.compare(this.anchorTop, squareAnchorEntrance.anchorTop) == 0 && Float.compare(this.anchorRight, squareAnchorEntrance.anchorRight) == 0 && Float.compare(this.anchorBottom, squareAnchorEntrance.anchorBottom) == 0 && Intrinsics.areEqual(this.link, squareAnchorEntrance.link) && this.status == squareAnchorEntrance.status && this.richStatus == squareAnchorEntrance.richStatus && this.needUnlock == squareAnchorEntrance.needUnlock && Intrinsics.areEqual(this.anchorBubble, squareAnchorEntrance.anchorBubble);
    }
}
