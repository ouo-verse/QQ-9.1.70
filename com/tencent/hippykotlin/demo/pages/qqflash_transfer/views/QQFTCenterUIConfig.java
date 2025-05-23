package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.manager.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCenterUIConfig {
    public static final float columnSpacing;
    public static final float insetLeft;
    public static final float lineSpacing;
    public static final float shareSecondMarginLeft;
    public static final float shareViewMarginLeft;
    public static final QQFTCenterUIConfig INSTANCE = new QQFTCenterUIConfig();
    public static final float listCardHeight = 72;
    public static final float topMarginScale = 0.18292683f;
    public static final float bottomMarginScale = 0.06097561f;
    public static final float leftRightMarginScale = 0.0f;
    public static final float singleImageLeftRightScale = 0.056179777f;

    static {
        float f16 = 16;
        insetLeft = f16;
        float f17 = 32;
        columnSpacing = f17;
        lineSpacing = f16;
        shareViewMarginLeft = f17;
        shareSecondMarginLeft = f16;
    }

    public final float getDoubleCardWidth() {
        float f16 = 2;
        return ((GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a) - (insetLeft * f16)) - columnSpacing) / f16;
    }
}
