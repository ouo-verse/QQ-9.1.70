package com.tencent.biz.qqcircle.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"", "b", "a", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class n {
    public static final boolean a() {
        return !b();
    }

    public static final boolean b() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_new_fans_and_follower_page", true);
        com.tencent.xaction.log.b.a("QCircleABTestUtilsPYMK", 1, "isSwitchOnNewFansAndFollowPage: " + isSwitchOn);
        return isSwitchOn;
    }
}
