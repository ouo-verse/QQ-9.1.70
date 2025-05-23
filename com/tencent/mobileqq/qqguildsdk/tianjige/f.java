package com.tencent.mobileqq.qqguildsdk.tianjige;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qqguildsdk.config.GProSdkTjgConfigParser;
import com.tencent.mobileqq.qqguildsdk.tianjige.e;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f {
    public static e a() {
        try {
            GProSdkTjgConfigParser.Config e16 = com.tencent.mobileqq.qqguildsdk.manager.c.d().e();
            boolean isTraceSdkEnable = e16.getIsTraceSdkEnable();
            boolean isColorUser = e16.getIsColorUser();
            double traceSample = e16.getTraceSample();
            double traceSampleEvent = e16.getTraceSampleEvent();
            if (isTraceSdkEnable) {
                String str = AppSetting.f99551k;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                String str2 = "";
                if (peekAppRuntime != null) {
                    str2 = peekAppRuntime.getCurrentUin();
                }
                String c16 = com.tencent.mobileqq.qqguildsdk.util.i.c(str2);
                e.a o16 = new e.a().m("qq").l(traceSample).k(traceSampleEvent).o(str2);
                if (c16 == null) {
                    c16 = "0";
                }
                return o16.n(c16).i(str).j(isColorUser).h();
            }
            return null;
        } catch (Exception e17) {
            com.tencent.mobileqq.qqguildsdk.util.h.k("OpenTelemetryConfigManager", 1, DownloadInfo.spKey_Config, e17.toString());
            return null;
        }
    }
}
