package com.tencent.qqnt.kernel.utils;

import android.net.NetworkInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qqnt.kernel.nativeinterface.NetStatusType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/NetStatusType;", "a", "kernel_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g {
    @NotNull
    public static final NetStatusType a() {
        NetworkInfo recentNetworkInfo;
        int i3 = -1;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106156", false)) {
            if (AppNetConnInfo.isNetSupport()) {
                if (AppNetConnInfo.isWifiConn()) {
                    return NetStatusType.KREACHABLEVIAWIFI;
                }
                if (AppNetConnInfo.isMobileConn()) {
                    int mobileInfo = AppNetConnInfo.getMobileInfo();
                    if (mobileInfo != -1) {
                        if (mobileInfo != 0) {
                            if (mobileInfo != 1) {
                                if (mobileInfo != 2) {
                                    if (mobileInfo != 3) {
                                        if (mobileInfo != 4) {
                                            return NetStatusType.KREACHABLEUNKNOWN;
                                        }
                                        return NetStatusType.KREACHABLEVIA5G;
                                    }
                                    return NetStatusType.KREACHABLEVIA4G;
                                }
                                return NetStatusType.KREACHABLEVIA3G;
                            }
                            return NetStatusType.KREACHABLEVIA2G;
                        }
                        return NetStatusType.KREACHABLEUNKNOWN;
                    }
                    return NetStatusType.KNOTREACHABLE;
                }
                return NetStatusType.KREACHABLEUNKNOWN;
            }
            return NetStatusType.KNOTREACHABLE;
        }
        if (AppNetConnInfo.isNetSupport() && (recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo()) != null) {
            i3 = NetworkMonitor.getType(recentNetworkInfo);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 6) {
                                return NetStatusType.KREACHABLEUNKNOWN;
                            }
                            return NetStatusType.KREACHABLEVIA5G;
                        }
                        return NetStatusType.KREACHABLEVIA4G;
                    }
                    return NetStatusType.KREACHABLEVIA3G;
                }
                return NetStatusType.KREACHABLEVIA2G;
            }
            return NetStatusType.KREACHABLEVIAWIFI;
        }
        return NetStatusType.KNOTREACHABLE;
    }
}
