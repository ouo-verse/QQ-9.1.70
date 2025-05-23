package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountRefreshCtrl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import uq3.k;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountRefreshCtrlImpl;", "Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountRefreshCtrl;", "()V", "isTimeToRefreshImmersive", "", "isTimeToRefreshStaggered", "updateImmersiveExitTime", "", "updateStaggeredExitTime", "Companion", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountRefreshCtrlImpl implements IQCirclePublicAccountRefreshCtrl {
    public static final int DEFAULT_IMMERSIVE_REFRESH_INTERVAL_MIN = 30;
    public static final int DEFAULT_STAGGER_REFRESH_INTERVAL_MIN = 30;

    @NotNull
    public static final String SP_KEY_QCIRCLE_PUBLIC_ACCOUNT_IMMERSIVE_EXIT_TIME = "qcircle_public_account_exit_time";

    @NotNull
    public static final String SP_KEY_QCIRCLE_PUBLIC_ACCOUNT_STAGGER_EXIT_TIME = "qcircle_public_account_stagger_exit_time";

    @NotNull
    public static final String TAG = "QCirclePublicAccountRefreshCtrlImpl";

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountRefreshCtrl
    public boolean isTimeToRefreshImmersive() {
        boolean z16;
        Integer X0 = uq3.c.X0("qqcircle", "qqcircle_public_account_immersive_refresh_interval_time", 30);
        long f16 = k.a().f(SP_KEY_QCIRCLE_PUBLIC_ACCOUNT_IMMERSIVE_EXIT_TIME, 0L);
        if (f16 == 0) {
            f16 = k.b().f(SP_KEY_QCIRCLE_PUBLIC_ACCOUNT_IMMERSIVE_EXIT_TIME, 0L);
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (serverTimeMillis - f16 > X0.intValue() * 60 * 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i(TAG, 1, "isTimeToRefreshImmersive\uff0cneedForceReFreshFeed, refreshInterval=" + X0 + ",lastExitTimeMills=" + f16 + ",currentTimeMills=" + serverTimeMillis + ", needForceRefresh=" + z16);
        if (!z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountRefreshCtrl
    public boolean isTimeToRefreshStaggered() {
        boolean z16;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        Integer X0 = uq3.c.X0("qqcircle", "qqcircle_public_account_stagger_refresh_interval_time", 30);
        long f16 = k.a().f(SP_KEY_QCIRCLE_PUBLIC_ACCOUNT_STAGGER_EXIT_TIME, 0L);
        if (serverTimeMillis - f16 > X0.intValue() * 60 * 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i(TAG, 1, "isTimeToRefreshTraStaggered\uff0cneedForceReFreshFeed, refreshInterval=" + X0 + ",lastExitTimeMills=" + f16 + ",currentTimeMills=" + serverTimeMillis + ", needForceRefresh=" + z16);
        if (!z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountRefreshCtrl
    public void updateImmersiveExitTime() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        QLog.i(TAG, 1, "updateImmersiveExitTime, time=" + serverTimeMillis);
        k.a().n(SP_KEY_QCIRCLE_PUBLIC_ACCOUNT_IMMERSIVE_EXIT_TIME, serverTimeMillis);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountRefreshCtrl
    public void updateStaggeredExitTime() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        QLog.i(TAG, 1, "updateStaggeredExitTime, time=" + serverTimeMillis);
        k.a().n(SP_KEY_QCIRCLE_PUBLIC_ACCOUNT_STAGGER_EXIT_TIME, serverTimeMillis);
    }
}
