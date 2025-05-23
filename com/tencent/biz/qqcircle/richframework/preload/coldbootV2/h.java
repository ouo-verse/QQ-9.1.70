package com.tencent.biz.qqcircle.richframework.preload.coldbootV2;

import com.tencent.biz.qqcircle.utils.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h {
    public static boolean a() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_pre_load_feed_exchange_url", true) && !l.h("qqcircle_pre_load_feed_exchange_url_black_list_time", System.currentTimeMillis())) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_red_point_feed_back_up_rsp", true);
    }

    public static boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_remove_expired_feed", true);
    }
}
