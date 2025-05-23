package com.tencent.state.square.bubblesetting;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JQ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/square/bubblesetting/SquareBubbleColor;", "", "fontColor", "", "assistColor", "listenMusicColor", "selectColor", "Lcom/tencent/state/square/bubblesetting/SquareLikeButtonColor;", "unselectColor", "iconColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/square/bubblesetting/SquareLikeButtonColor;Lcom/tencent/state/square/bubblesetting/SquareLikeButtonColor;Ljava/lang/String;)V", "getAssistColor", "()Ljava/lang/String;", "getFontColor", "getIconColor", "setIconColor", "(Ljava/lang/String;)V", "getListenMusicColor", "getSelectColor", "()Lcom/tencent/state/square/bubblesetting/SquareLikeButtonColor;", "getUnselectColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareBubbleColor {
    private final String assistColor;
    private final String fontColor;
    private String iconColor;
    private final String listenMusicColor;
    private final SquareLikeButtonColor selectColor;
    private final SquareLikeButtonColor unselectColor;

    public SquareBubbleColor() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFontColor() {
        return this.fontColor;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAssistColor() {
        return this.assistColor;
    }

    /* renamed from: component3, reason: from getter */
    public final String getListenMusicColor() {
        return this.listenMusicColor;
    }

    /* renamed from: component4, reason: from getter */
    public final SquareLikeButtonColor getSelectColor() {
        return this.selectColor;
    }

    /* renamed from: component5, reason: from getter */
    public final SquareLikeButtonColor getUnselectColor() {
        return this.unselectColor;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIconColor() {
        return this.iconColor;
    }

    public final SquareBubbleColor copy(String fontColor, String assistColor, String listenMusicColor, SquareLikeButtonColor selectColor, SquareLikeButtonColor unselectColor, String iconColor) {
        return new SquareBubbleColor(fontColor, assistColor, listenMusicColor, selectColor, unselectColor, iconColor);
    }

    public final String getAssistColor() {
        return this.assistColor;
    }

    public final String getFontColor() {
        return this.fontColor;
    }

    public final String getIconColor() {
        return this.iconColor;
    }

    public final String getListenMusicColor() {
        return this.listenMusicColor;
    }

    public final SquareLikeButtonColor getSelectColor() {
        return this.selectColor;
    }

    public final SquareLikeButtonColor getUnselectColor() {
        return this.unselectColor;
    }

    public int hashCode() {
        String str = this.fontColor;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.assistColor;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.listenMusicColor;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        SquareLikeButtonColor squareLikeButtonColor = this.selectColor;
        int hashCode4 = (hashCode3 + (squareLikeButtonColor != null ? squareLikeButtonColor.hashCode() : 0)) * 31;
        SquareLikeButtonColor squareLikeButtonColor2 = this.unselectColor;
        int hashCode5 = (hashCode4 + (squareLikeButtonColor2 != null ? squareLikeButtonColor2.hashCode() : 0)) * 31;
        String str4 = this.iconColor;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setIconColor(String str) {
        this.iconColor = str;
    }

    public String toString() {
        return "SquareBubbleColor(fontColor=" + this.fontColor + ", assistColor=" + this.assistColor + ", listenMusicColor=" + this.listenMusicColor + ", selectColor=" + this.selectColor + ", unselectColor=" + this.unselectColor + ", iconColor=" + this.iconColor + ")";
    }

    public SquareBubbleColor(String str, String str2, String str3, SquareLikeButtonColor squareLikeButtonColor, SquareLikeButtonColor squareLikeButtonColor2, String str4) {
        this.fontColor = str;
        this.assistColor = str2;
        this.listenMusicColor = str3;
        this.selectColor = squareLikeButtonColor;
        this.unselectColor = squareLikeButtonColor2;
        this.iconColor = str4;
    }

    public /* synthetic */ SquareBubbleColor(String str, String str2, String str3, SquareLikeButtonColor squareLikeButtonColor, SquareLikeButtonColor squareLikeButtonColor2, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : squareLikeButtonColor, (i3 & 16) != 0 ? null : squareLikeButtonColor2, (i3 & 32) != 0 ? null : str4);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareBubbleColor)) {
            return false;
        }
        SquareBubbleColor squareBubbleColor = (SquareBubbleColor) other;
        return Intrinsics.areEqual(this.fontColor, squareBubbleColor.fontColor) && Intrinsics.areEqual(this.assistColor, squareBubbleColor.assistColor) && Intrinsics.areEqual(this.listenMusicColor, squareBubbleColor.listenMusicColor) && Intrinsics.areEqual(this.selectColor, squareBubbleColor.selectColor) && Intrinsics.areEqual(this.unselectColor, squareBubbleColor.unselectColor) && Intrinsics.areEqual(this.iconColor, squareBubbleColor.iconColor);
    }

    public static /* synthetic */ SquareBubbleColor copy$default(SquareBubbleColor squareBubbleColor, String str, String str2, String str3, SquareLikeButtonColor squareLikeButtonColor, SquareLikeButtonColor squareLikeButtonColor2, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = squareBubbleColor.fontColor;
        }
        if ((i3 & 2) != 0) {
            str2 = squareBubbleColor.assistColor;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = squareBubbleColor.listenMusicColor;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            squareLikeButtonColor = squareBubbleColor.selectColor;
        }
        SquareLikeButtonColor squareLikeButtonColor3 = squareLikeButtonColor;
        if ((i3 & 16) != 0) {
            squareLikeButtonColor2 = squareBubbleColor.unselectColor;
        }
        SquareLikeButtonColor squareLikeButtonColor4 = squareLikeButtonColor2;
        if ((i3 & 32) != 0) {
            str4 = squareBubbleColor.iconColor;
        }
        return squareBubbleColor.copy(str, str5, str6, squareLikeButtonColor3, squareLikeButtonColor4, str4);
    }
}
