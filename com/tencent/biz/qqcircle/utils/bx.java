package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.thirdsig.api.IThirdSigService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bx {

    /* renamed from: a, reason: collision with root package name */
    private static String f92733a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements com.tencent.mobileqq.thirdsig.api.b {
        a() {
        }

        @Override // com.tencent.mobileqq.thirdsig.api.b
        public void onFail(int i3, @NonNull String str) {
            QLog.d("QFSOpenIdUtil", 1, "getOpenIdFromThirdSigService fail.");
        }

        @Override // com.tencent.mobileqq.thirdsig.api.b
        public void onSuccess(@NonNull String str) {
            bx.f92733a = str;
        }
    }

    public static void b() {
        f92733a = "";
    }

    public static String c() {
        return f92733a;
    }

    private static void d(AppRuntime appRuntime, int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("QFSOpenIdUtil", 1, "[getOpenIdFromThirdSigService] token empty");
        } else {
            ((IThirdSigService) appRuntime.getRuntimeService(IThirdSigService.class, "all")).getOpenId(appRuntime.getLongAccountUin(), i3, str, new a());
        }
    }

    public static void e() {
        AppRuntime peekAppRuntime;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_preset_ad_req_ams_qq_open_id_9095", false) && TextUtils.isEmpty(f92733a) && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && com.tencent.mobileqq.thirdsig.api.i.f292824a.a()) {
            d(peekAppRuntime, 101414945, ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_enable_preset_ad_req_ams_qq_open_id_9095", "v2_5y0MZ7CR70pjVmHFsYhBaAnXYkySFvfwqtmbBNhF51k__JAS2xma3em-AtN777c"));
        }
    }
}
