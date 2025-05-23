package com.tencent.mobileqq.hippy;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HippyBundleHelper {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, Boolean> f236842a = new ConcurrentHashMap<>();

    public static void a(String str, String str2) {
        a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101322");
        if (aVar == null || !aVar.getDownloadEnable() || f236842a.containsKey(str)) {
            return;
        }
        f236842a.put(str, Boolean.TRUE);
        int moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(str);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            return;
        }
        boolean isFollowUin = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isFollowUin((AppInterface) peekAppRuntime, str2);
        if (moduleVersion < 0 && isFollowUin) {
            ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(str, "updateApiHippy", null);
        }
    }

    public static void b() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.hippy.HippyBundleHelper.1
            @Override // java.lang.Runnable
            public void run() {
                HippyBundleHelper.a(HippyQQConstants.ModuleName.QQ_WEATHER, "2658655094");
                HippyBundleHelper.a(HippyQQConstants.ModuleName.QQ_SPORT, IPublicAccountUtil.UIN_FOR_HEALTH);
            }
        }, 128, null, false, 3000L);
    }
}
