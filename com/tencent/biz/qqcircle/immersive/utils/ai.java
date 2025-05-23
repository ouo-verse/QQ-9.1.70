package com.tencent.biz.qqcircle.immersive.utils;

import qqcircle.QQCircleCounter$RedPointInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ai {
    public static boolean a() {
        return com.tencent.biz.qqcircle.helpers.y.g().p();
    }

    public static boolean b(int i3) {
        if (i3 == 3 && !com.tencent.biz.qqcircle.publish.plusentry.helper.a.c()) {
            return true;
        }
        return false;
    }

    public static boolean c(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (qQCircleCounter$RedPointInfo == null || qQCircleCounter$RedPointInfo.redType.get() != 2 || qQCircleCounter$RedPointInfo.showType.get() == 0) {
            return false;
        }
        return true;
    }
}
