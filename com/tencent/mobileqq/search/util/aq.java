package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f285015a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f285016b;

    public static boolean a() {
        if (f285015a) {
            return f285016b;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return false;
        }
        boolean isFeatureSwitchOn = ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("search_ui_switch");
        f285016b = isFeatureSwitchOn;
        f285015a = true;
        return isFeatureSwitchOn;
    }
}
