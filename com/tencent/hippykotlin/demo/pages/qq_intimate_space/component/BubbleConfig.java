package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import com.tencent.kuikly.core.base.h;
import yo3.Size;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class BubbleConfig {
    public final h backgroundColor;
    public final float borderRadius;
    public final float bubbleContainerFoldHeight;
    public final float bubbleContainerHeight;
    public final float bubbleFoldWidth;
    public float bubbleUnfoldWidth;
    public final float buttonFontSize;
    public final float buttonHeight;
    public final String buttonTitle;
    public final float buttonWidth;
    public final FoldAnimation foldAnimation;
    public final String iconUrl;
    public final BubbleStatus startStatus;
    public final String text;
    public final BubbleTriangleDirection triangleDirection;
    public final Size triangleSize;

    public BubbleConfig(float f16, float f17, float f18, float f19, float f26, FoldAnimation foldAnimation, h hVar, String str, String str2, Size size, BubbleTriangleDirection bubbleTriangleDirection, BubbleStatus bubbleStatus, String str3, float f27, float f28, float f29) {
        this.bubbleUnfoldWidth = f16;
        this.bubbleFoldWidth = f17;
        this.bubbleContainerHeight = f18;
        this.bubbleContainerFoldHeight = f19;
        this.borderRadius = f26;
        this.foldAnimation = foldAnimation;
        this.backgroundColor = hVar;
        this.iconUrl = str;
        this.text = str2;
        this.triangleSize = size;
        this.triangleDirection = bubbleTriangleDirection;
        this.startStatus = bubbleStatus;
        this.buttonTitle = str3;
        this.buttonFontSize = f27;
        this.buttonWidth = f28;
        this.buttonHeight = f29;
    }

    public final BubbleStatus getStartStatus() {
        return this.startStatus;
    }

    public /* synthetic */ BubbleConfig(float f16, FoldAnimation foldAnimation, String str, String str2, BubbleTriangleDirection bubbleTriangleDirection, BubbleStatus bubbleStatus, String str3, int i3) {
        this((i3 & 1) != 0 ? 226 : f16, (i3 & 2) != 0 ? 40 : 0.0f, (i3 & 4) != 0 ? 39 : 0.0f, (i3 & 8) != 0 ? 34 : 0.0f, (i3 & 16) != 0 ? 37 : 0.0f, (i3 & 32) != 0 ? null : foldAnimation, (i3 & 64) != 0 ? h.INSTANCE.m() : null, (i3 & 128) != 0 ? null : str, str2, (i3 & 512) != 0 ? new Size(11, 5) : null, (i3 & 1024) != 0 ? BubbleTriangleDirection.DOWN_CENTER : bubbleTriangleDirection, (i3 & 2048) != 0 ? BubbleStatus.UNFOLD : bubbleStatus, (i3 & 4096) != 0 ? null : str3, (i3 & 8192) != 0 ? 11.49f : 0.0f, (i3 & 16384) != 0 ? 64.0f : 0.0f, (i3 & 32768) != 0 ? 25.0f : 0.0f);
    }
}
