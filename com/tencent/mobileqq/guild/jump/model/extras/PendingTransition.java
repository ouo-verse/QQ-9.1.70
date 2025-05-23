package com.tencent.mobileqq.guild.jump.model.extras;

/* loaded from: classes13.dex */
public class PendingTransition extends AbsJumpExtra {
    public final int enterAnim;
    public final int exitAnim;

    public PendingTransition(int i3, int i16) {
        this.enterAnim = i3;
        this.exitAnim = i16;
    }

    public String toString() {
        return "PendingTransition{enterAnim=" + this.enterAnim + ", exitAnim=" + this.exitAnim + '}';
    }
}
