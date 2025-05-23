package com.tencent.state.publicchat.view;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\u0005H\u00d6\u0001J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/publicchat/view/MsgNewBtnConfig;", "", "text", "", "textColor", "", "textSize", "", "showIcon", "", LayoutAttrDefine.Gravity.Gravity, NodeProps.PADDING_LEFT, "(Ljava/lang/String;IFZII)V", "getGravity", "()I", "getPaddingLeft", "getShowIcon", "()Z", "getText", "()Ljava/lang/String;", "getTextColor", "getTextSize", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MsgNewBtnConfig {
    private final int gravity;
    private final int paddingLeft;
    private final boolean showIcon;
    private final String text;
    private final int textColor;
    private final float textSize;

    public MsgNewBtnConfig(String text, int i3, float f16, boolean z16, int i16, int i17) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.textColor = i3;
        this.textSize = f16;
        this.showIcon = z16;
        this.gravity = i16;
        this.paddingLeft = i17;
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    /* renamed from: component3, reason: from getter */
    public final float getTextSize() {
        return this.textSize;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getShowIcon() {
        return this.showIcon;
    }

    /* renamed from: component5, reason: from getter */
    public final int getGravity() {
        return this.gravity;
    }

    /* renamed from: component6, reason: from getter */
    public final int getPaddingLeft() {
        return this.paddingLeft;
    }

    public final MsgNewBtnConfig copy(String text, int textColor, float textSize, boolean showIcon, int gravity, int paddingLeft) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new MsgNewBtnConfig(text, textColor, textSize, showIcon, gravity, paddingLeft);
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final int getPaddingLeft() {
        return this.paddingLeft;
    }

    public final boolean getShowIcon() {
        return this.showIcon;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.text;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.textColor) * 31) + Float.floatToIntBits(this.textSize)) * 31;
        boolean z16 = this.showIcon;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((hashCode + i3) * 31) + this.gravity) * 31) + this.paddingLeft;
    }

    public String toString() {
        return "MsgNewBtnConfig(text=" + this.text + ", textColor=" + this.textColor + ", textSize=" + this.textSize + ", showIcon=" + this.showIcon + ", gravity=" + this.gravity + ", paddingLeft=" + this.paddingLeft + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgNewBtnConfig)) {
            return false;
        }
        MsgNewBtnConfig msgNewBtnConfig = (MsgNewBtnConfig) other;
        return Intrinsics.areEqual(this.text, msgNewBtnConfig.text) && this.textColor == msgNewBtnConfig.textColor && Float.compare(this.textSize, msgNewBtnConfig.textSize) == 0 && this.showIcon == msgNewBtnConfig.showIcon && this.gravity == msgNewBtnConfig.gravity && this.paddingLeft == msgNewBtnConfig.paddingLeft;
    }

    public static /* synthetic */ MsgNewBtnConfig copy$default(MsgNewBtnConfig msgNewBtnConfig, String str, int i3, float f16, boolean z16, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            str = msgNewBtnConfig.text;
        }
        if ((i18 & 2) != 0) {
            i3 = msgNewBtnConfig.textColor;
        }
        int i19 = i3;
        if ((i18 & 4) != 0) {
            f16 = msgNewBtnConfig.textSize;
        }
        float f17 = f16;
        if ((i18 & 8) != 0) {
            z16 = msgNewBtnConfig.showIcon;
        }
        boolean z17 = z16;
        if ((i18 & 16) != 0) {
            i16 = msgNewBtnConfig.gravity;
        }
        int i26 = i16;
        if ((i18 & 32) != 0) {
            i17 = msgNewBtnConfig.paddingLeft;
        }
        return msgNewBtnConfig.copy(str, i19, f17, z17, i26, i17);
    }
}
