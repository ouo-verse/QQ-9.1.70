package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProvinceModel {
    public final Pair<String, Integer>[] cityList;
    public final int percent;
    public final String provinceName;

    public ProvinceModel(int i3, String str, Pair<String, Integer>[] pairArr) {
        this.percent = i3;
        this.provinceName = str;
        this.cityList = pairArr;
    }

    public final int hashCode() {
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.provinceName, this.percent * 31, 31) + Arrays.hashCode(this.cityList);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProvinceModel(percent=");
        m3.append(this.percent);
        m3.append(", provinceName=");
        m3.append(this.provinceName);
        m3.append(", cityList=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, Arrays.toString(this.cityList), ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProvinceModel)) {
            return false;
        }
        ProvinceModel provinceModel = (ProvinceModel) obj;
        return this.percent == provinceModel.percent && Intrinsics.areEqual(this.provinceName, provinceModel.provinceName) && Intrinsics.areEqual(this.cityList, provinceModel.cityList);
    }
}
