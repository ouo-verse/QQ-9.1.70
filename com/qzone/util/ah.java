package com.qzone.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ah {
    public static boolean a() {
        String expPostBtnMode = ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getExpPostBtnMode();
        return QQTheme.isNowSimpleUI() && (QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_B.equals(expPostBtnMode) || QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_C.equals(expPostBtnMode)) && ((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin());
    }

    public static boolean b() {
        com.qzone.reborn.util.k kVar = com.qzone.reborn.util.k.f59549a;
        if (kVar.a()) {
            QLog.i("QZoneZPlanUtil", 1, "elder mode not show entrance");
            return false;
        }
        if (!kVar.g()) {
            return true;
        }
        QLog.i("QZoneZPlanUtil", 1, "teenage mode not show entrance");
        return false;
    }
}
