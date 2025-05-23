package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallFlowerGeneralCardConfig {
    public final boolean playFlowerAnimation;
    public final String title;
    public final float titleFontSize;

    public /* synthetic */ LoveWallFlowerGeneralCardConfig(String str, float f16, int i3) {
        this(str, (i3 & 2) != 0 ? 32.0f : f16, (i3 & 4) != 0);
    }

    public LoveWallFlowerGeneralCardConfig(String str, float f16, boolean z16) {
        this.title = str;
        this.titleFontSize = f16;
        this.playFlowerAnimation = z16;
    }
}
