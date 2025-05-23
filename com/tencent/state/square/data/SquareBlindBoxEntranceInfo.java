package com.tencent.state.square.data;

import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/data/SquareBlindBoxEntranceInfo;", "", ViewStickEventHelper.IS_SHOW, "", "linkUrl", "", "boxCover", "(ZLjava/lang/String;Ljava/lang/String;)V", "getBoxCover", "()Ljava/lang/String;", "()Z", "getLinkUrl", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareBlindBoxEntranceInfo {
    private final String boxCover;
    private final boolean isShow;
    private final String linkUrl;

    public SquareBlindBoxEntranceInfo(boolean z16, String str, String str2) {
        this.isShow = z16;
        this.linkUrl = str;
        this.boxCover = str2;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBoxCover() {
        return this.boxCover;
    }

    public final SquareBlindBoxEntranceInfo copy(boolean isShow, String linkUrl, String boxCover) {
        return new SquareBlindBoxEntranceInfo(isShow, linkUrl, boxCover);
    }

    public final String getBoxCover() {
        return this.boxCover;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isShow;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        String str = this.linkUrl;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.boxCover;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public String toString() {
        return "SquareBlindBoxEntranceInfo(isShow=" + this.isShow + ", linkUrl=" + this.linkUrl + ", boxCover=" + this.boxCover + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareBlindBoxEntranceInfo)) {
            return false;
        }
        SquareBlindBoxEntranceInfo squareBlindBoxEntranceInfo = (SquareBlindBoxEntranceInfo) other;
        return this.isShow == squareBlindBoxEntranceInfo.isShow && Intrinsics.areEqual(this.linkUrl, squareBlindBoxEntranceInfo.linkUrl) && Intrinsics.areEqual(this.boxCover, squareBlindBoxEntranceInfo.boxCover);
    }

    public static /* synthetic */ SquareBlindBoxEntranceInfo copy$default(SquareBlindBoxEntranceInfo squareBlindBoxEntranceInfo, boolean z16, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = squareBlindBoxEntranceInfo.isShow;
        }
        if ((i3 & 2) != 0) {
            str = squareBlindBoxEntranceInfo.linkUrl;
        }
        if ((i3 & 4) != 0) {
            str2 = squareBlindBoxEntranceInfo.boxCover;
        }
        return squareBlindBoxEntranceInfo.copy(z16, str, str2);
    }
}
