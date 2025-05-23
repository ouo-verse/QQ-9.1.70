package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleHostClassHelper {
    public static Class getChatActivityClass() {
        return QCircleServiceImpl.getChatActivityApi().getChatActivityClass();
    }

    public static Class getForwardRecentActivityClass() {
        return QCircleServiceImpl.getForwardApi().getForwardRecentActivityClass();
    }

    public static Class getForwardRecentTranslucentActivityClass() {
        return QCircleServiceImpl.getForwardApi().getForwardRecentTranslucentActivityClass();
    }

    public static Class getJumpActivityClass() {
        return QCircleServiceImpl.getJumpApi().getJumpActivityClass();
    }
}
