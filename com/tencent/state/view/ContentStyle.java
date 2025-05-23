package com.tencent.state.view;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012JX\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020\u0007H\u00d6\u0001J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/state/view/ContentStyle;", "", "textContent", "", "textSize", "", "textColor", "", "isBold", "", LayoutAttrDefine.Gravity.Gravity, NodeProps.MARGIN_TOP, NodeProps.MARGIN_BOTTOM, "(Ljava/lang/String;FIZILjava/lang/Integer;Ljava/lang/Integer;)V", "getGravity", "()I", "()Z", "getMarginBottom", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMarginTop", "getTextColor", "getTextContent", "()Ljava/lang/String;", "getTextSize", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;FIZILjava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/state/view/ContentStyle;", "equals", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class ContentStyle {
    private final int gravity;
    private final boolean isBold;
    private final Integer marginBottom;
    private final Integer marginTop;
    private final int textColor;
    private final String textContent;
    private final float textSize;

    public ContentStyle(String textContent, float f16, int i3, boolean z16, int i16, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        this.textContent = textContent;
        this.textSize = f16;
        this.textColor = i3;
        this.isBold = z16;
        this.gravity = i16;
        this.marginTop = num;
        this.marginBottom = num2;
    }

    /* renamed from: component1, reason: from getter */
    public final String getTextContent() {
        return this.textContent;
    }

    /* renamed from: component2, reason: from getter */
    public final float getTextSize() {
        return this.textSize;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsBold() {
        return this.isBold;
    }

    /* renamed from: component5, reason: from getter */
    public final int getGravity() {
        return this.gravity;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getMarginTop() {
        return this.marginTop;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getMarginBottom() {
        return this.marginBottom;
    }

    public final ContentStyle copy(String textContent, float textSize, int textColor, boolean isBold, int gravity, Integer marginTop, Integer marginBottom) {
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        return new ContentStyle(textContent, textSize, textColor, isBold, gravity, marginTop, marginBottom);
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final Integer getMarginBottom() {
        return this.marginBottom;
    }

    public final Integer getMarginTop() {
        return this.marginTop;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.textContent;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + Float.floatToIntBits(this.textSize)) * 31) + this.textColor) * 31;
        boolean z16 = this.isBold;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (((hashCode + i3) * 31) + this.gravity) * 31;
        Integer num = this.marginTop;
        int hashCode2 = (i16 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.marginBottom;
        return hashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public final boolean isBold() {
        return this.isBold;
    }

    public String toString() {
        return "ContentStyle(textContent=" + this.textContent + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", isBold=" + this.isBold + ", gravity=" + this.gravity + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ")";
    }

    public /* synthetic */ ContentStyle(String str, float f16, int i3, boolean z16, int i16, Integer num, Integer num2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i17 & 2) != 0 ? 14.0f : f16, (i17 & 4) != 0 ? -16777216 : i3, (i17 & 8) != 0 ? false : z16, (i17 & 16) != 0 ? 3 : i16, (i17 & 32) != 0 ? null : num, (i17 & 64) == 0 ? num2 : null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentStyle)) {
            return false;
        }
        ContentStyle contentStyle = (ContentStyle) other;
        return Intrinsics.areEqual(this.textContent, contentStyle.textContent) && Float.compare(this.textSize, contentStyle.textSize) == 0 && this.textColor == contentStyle.textColor && this.isBold == contentStyle.isBold && this.gravity == contentStyle.gravity && Intrinsics.areEqual(this.marginTop, contentStyle.marginTop) && Intrinsics.areEqual(this.marginBottom, contentStyle.marginBottom);
    }

    public static /* synthetic */ ContentStyle copy$default(ContentStyle contentStyle, String str, float f16, int i3, boolean z16, int i16, Integer num, Integer num2, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = contentStyle.textContent;
        }
        if ((i17 & 2) != 0) {
            f16 = contentStyle.textSize;
        }
        float f17 = f16;
        if ((i17 & 4) != 0) {
            i3 = contentStyle.textColor;
        }
        int i18 = i3;
        if ((i17 & 8) != 0) {
            z16 = contentStyle.isBold;
        }
        boolean z17 = z16;
        if ((i17 & 16) != 0) {
            i16 = contentStyle.gravity;
        }
        int i19 = i16;
        if ((i17 & 32) != 0) {
            num = contentStyle.marginTop;
        }
        Integer num3 = num;
        if ((i17 & 64) != 0) {
            num2 = contentStyle.marginBottom;
        }
        return contentStyle.copy(str, f17, i18, z17, i19, num3, num2);
    }
}
