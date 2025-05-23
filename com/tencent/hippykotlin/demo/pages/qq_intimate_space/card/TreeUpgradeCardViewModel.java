package com.tencent.hippykotlin.demo.pages.qq_intimate_space.card;

import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.MathUtilsKt;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class TreeUpgradeCardViewModel {
    public int achieveDays;
    public float formatedStartHeight;
    public float formatedToHeight;
    public final String treeImage = "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_G65kRDLTBk0.png";

    public TreeUpgradeCardViewModel(float f16, float f17, long j3) {
        this.formatedStartHeight = f16;
        this.formatedToHeight = f17;
        this.achieveDays = ((int) ((Mqq.INSTANCE.getUtil().currentTime() - (j3 * 1000)) / 86400000)) + 1;
        this.formatedStartHeight = MathUtilsKt.roundToDecimalPlaces(f16);
        this.formatedToHeight = MathUtilsKt.roundToDecimalPlaces(f17);
    }
}
