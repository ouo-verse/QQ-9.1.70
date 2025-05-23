package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import e25.i;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveSproutCardConfig {
    public final String buttonApngUrl;
    public final String buttonText;
    public final i flower;
    public final float introFontSize;
    public final boolean playFlowerAnimation;
    public final float titleFontSize;

    public LoveSproutCardConfig(i iVar, String str, String str2, boolean z16, float f16, float f17) {
        this.flower = iVar;
        this.buttonText = str;
        this.buttonApngUrl = str2;
        this.playFlowerAnimation = z16;
        this.titleFontSize = f16;
        this.introFontSize = f17;
    }

    public final i getFlower() {
        return this.flower;
    }

    public /* synthetic */ LoveSproutCardConfig(i iVar, String str, String str2, float f16, float f17, int i3) {
        this(iVar, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0, (i3 & 16) != 0 ? 32.0f : f16, (i3 & 32) != 0 ? 14.0f : f17);
    }
}
