package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;

/* loaded from: classes31.dex */
public final class PageViewData {
    public final int curStep;
    public final int curViewFlag;

    public PageViewData(int i3, int i16) {
        this.curStep = i3;
        this.curViewFlag = i16;
    }

    public final int hashCode() {
        return this.curViewFlag + (this.curStep * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("PageViewData(curStep=");
        m3.append(this.curStep);
        m3.append(", curViewFlag=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.curViewFlag, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageViewData)) {
            return false;
        }
        PageViewData pageViewData = (PageViewData) obj;
        return this.curStep == pageViewData.curStep && this.curViewFlag == pageViewData.curViewFlag;
    }
}
