package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes16.dex */
public class bx {
    public static boolean a() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("push_token_params");
    }
}
