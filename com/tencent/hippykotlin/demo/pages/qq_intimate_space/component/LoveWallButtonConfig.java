package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import com.tencent.kuikly.core.base.j;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallButtonConfig {
    public final String backgroundImageUrl;
    public final String text;
    public final List<j> textGradientColorStops;
    public final float textSize;

    public LoveWallButtonConfig(String str, float f16, List<j> list, String str2) {
        this.text = str;
        this.textSize = f16;
        this.textGradientColorStops = list;
        this.backgroundImageUrl = str2;
    }

    public /* synthetic */ LoveWallButtonConfig(String str) {
        this(str, 22.0f, LoveWallButtonTextColor.Companion.getBLUE_BUTTON_COLORS(), "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_pw8ii1YCshi.png");
    }
}
