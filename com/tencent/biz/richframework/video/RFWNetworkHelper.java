package com.tencent.biz.richframework.video;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWNetworkHelper {
    public static final AtomicInteger MSF_CUR_WEAK_REASON = new AtomicInteger(-1);
    public static final AtomicBoolean IS_CUR_MSF_WEAK_NET = new AtomicBoolean(false);

    public static int getMsfWeakReason() {
        return MSF_CUR_WEAK_REASON.get();
    }

    public static boolean isMsfWeakNet() {
        return IS_CUR_MSF_WEAK_NET.get();
    }

    public static void updateMsfWeakNet(boolean z16, int i3) {
        MSF_CUR_WEAK_REASON.set(i3);
        IS_CUR_MSF_WEAK_NET.set(z16);
    }
}
