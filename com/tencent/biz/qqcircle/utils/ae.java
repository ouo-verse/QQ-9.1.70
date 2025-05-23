package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ae {
    public static boolean a(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean == null || !qCircleInitBean.isEnableSplash() || !com.tencent.biz.qqcircle.f.v().z() || !uq3.c.m0()) {
            return false;
        }
        return true;
    }
}
