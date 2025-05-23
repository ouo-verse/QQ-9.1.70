package com.tencent.state.square.bubblesetting;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003JA\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/bubblesetting/SquareBubbleSkin;", "", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "showPic", "", "bubbleType", "", WadlProxyConsts.KEY_JUMP_URL, "skinExpireTips", "(Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getBubbleInfo", "()Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "getBubbleType", "()I", "setBubbleType", "(I)V", "getJumpUrl", "()Ljava/lang/String;", "getShowPic", "getSkinExpireTips", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareBubbleSkin {
    private final SquareBubbleInfo bubbleInfo;
    private int bubbleType;
    private final String jumpUrl;
    private final String showPic;
    private final String skinExpireTips;

    public SquareBubbleSkin() {
        this(null, null, 0, null, null, 31, null);
    }

    /* renamed from: component1, reason: from getter */
    public final SquareBubbleInfo getBubbleInfo() {
        return this.bubbleInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getShowPic() {
        return this.showPic;
    }

    /* renamed from: component3, reason: from getter */
    public final int getBubbleType() {
        return this.bubbleType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSkinExpireTips() {
        return this.skinExpireTips;
    }

    public final SquareBubbleSkin copy(SquareBubbleInfo bubbleInfo, String showPic, int bubbleType, String jumpUrl, String skinExpireTips) {
        Intrinsics.checkNotNullParameter(skinExpireTips, "skinExpireTips");
        return new SquareBubbleSkin(bubbleInfo, showPic, bubbleType, jumpUrl, skinExpireTips);
    }

    public final SquareBubbleInfo getBubbleInfo() {
        return this.bubbleInfo;
    }

    public final int getBubbleType() {
        return this.bubbleType;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getShowPic() {
        return this.showPic;
    }

    public final String getSkinExpireTips() {
        return this.skinExpireTips;
    }

    public int hashCode() {
        SquareBubbleInfo squareBubbleInfo = this.bubbleInfo;
        int hashCode = (squareBubbleInfo != null ? squareBubbleInfo.hashCode() : 0) * 31;
        String str = this.showPic;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.bubbleType) * 31;
        String str2 = this.jumpUrl;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.skinExpireTips;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setBubbleType(int i3) {
        this.bubbleType = i3;
    }

    public String toString() {
        return "SquareBubbleSkin(bubbleInfo=" + this.bubbleInfo + ", showPic=" + this.showPic + ", bubbleType=" + this.bubbleType + ", jumpUrl=" + this.jumpUrl + ", skinExpireTips=" + this.skinExpireTips + ")";
    }

    public SquareBubbleSkin(SquareBubbleInfo squareBubbleInfo, String str, int i3, String str2, String skinExpireTips) {
        Intrinsics.checkNotNullParameter(skinExpireTips, "skinExpireTips");
        this.bubbleInfo = squareBubbleInfo;
        this.showPic = str;
        this.bubbleType = i3;
        this.jumpUrl = str2;
        this.skinExpireTips = skinExpireTips;
    }

    public /* synthetic */ SquareBubbleSkin(SquareBubbleInfo squareBubbleInfo, String str, int i3, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : squareBubbleInfo, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? -1 : i3, (i16 & 8) == 0 ? str2 : null, (i16 & 16) != 0 ? "" : str3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareBubbleSkin)) {
            return false;
        }
        SquareBubbleSkin squareBubbleSkin = (SquareBubbleSkin) other;
        return Intrinsics.areEqual(this.bubbleInfo, squareBubbleSkin.bubbleInfo) && Intrinsics.areEqual(this.showPic, squareBubbleSkin.showPic) && this.bubbleType == squareBubbleSkin.bubbleType && Intrinsics.areEqual(this.jumpUrl, squareBubbleSkin.jumpUrl) && Intrinsics.areEqual(this.skinExpireTips, squareBubbleSkin.skinExpireTips);
    }

    public static /* synthetic */ SquareBubbleSkin copy$default(SquareBubbleSkin squareBubbleSkin, SquareBubbleInfo squareBubbleInfo, String str, int i3, String str2, String str3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            squareBubbleInfo = squareBubbleSkin.bubbleInfo;
        }
        if ((i16 & 2) != 0) {
            str = squareBubbleSkin.showPic;
        }
        String str4 = str;
        if ((i16 & 4) != 0) {
            i3 = squareBubbleSkin.bubbleType;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            str2 = squareBubbleSkin.jumpUrl;
        }
        String str5 = str2;
        if ((i16 & 16) != 0) {
            str3 = squareBubbleSkin.skinExpireTips;
        }
        return squareBubbleSkin.copy(squareBubbleInfo, str4, i17, str5, str3);
    }
}
