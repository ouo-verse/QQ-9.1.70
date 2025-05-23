package com.qzone.module.feedcomponent.ui;

import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SmallTailReportUtil {
    public static String getUseMode() {
        int i3;
        if (com.qzone.adapter.feedcomponent.i.H().v1()) {
            i3 = 1;
        } else {
            i3 = com.qzone.adapter.feedcomponent.i.H().w1() ? 2 : 0;
        }
        return String.valueOf(i3);
    }

    public static void reportBigSmallTailClick() {
        com.qzone.adapter.feedcomponent.i.H().g(803, 2, 2, getUseMode(), "", "");
    }

    public static void reportBigSmallTailExpose() {
        com.qzone.adapter.feedcomponent.i.H().g(803, 2, 1, getUseMode(), "", "");
    }

    public static void reportBigSmallTailClick(DittoArea dittoArea) {
        if (dittoArea instanceof DittoAreaGroup) {
            com.qzone.adapter.feedcomponent.i.H().g(803, 2, 2, getUseMode(), "", "");
        }
    }
}
