package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class MovePositionRequest {
    public boolean beforeTarget;
    public CommonTabEmojiInfo tabElement = new CommonTabEmojiInfo();
    public CommonTabEmojiInfo targetTabElement = new CommonTabEmojiInfo();

    public boolean getBeforeTarget() {
        return this.beforeTarget;
    }

    public CommonTabEmojiInfo getTabElement() {
        return this.tabElement;
    }

    public CommonTabEmojiInfo getTargetTabElement() {
        return this.targetTabElement;
    }

    public String toString() {
        return "MovePositionRequest{tabElement=" + this.tabElement + ",targetTabElement=" + this.targetTabElement + ",beforeTarget=" + this.beforeTarget + ",}";
    }
}
