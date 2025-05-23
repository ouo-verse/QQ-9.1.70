package com.tencent.mobileqq.guild.data;

import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes13.dex */
public class v {
    public static String a(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 5) {
                    if (i3 != 7) {
                        if (i3 != 8) {
                            return "";
                        }
                        return "world";
                    }
                    return Method.POST;
                }
                return "stream";
            }
            return "voice";
        }
        return "chat";
    }

    public static int b(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                return 2;
            }
            if (i3 == 2) {
                return 1;
            }
            return 4;
        }
        return 3;
    }

    public static int c(String str) {
        IGProGuildInfo iGProGuildInfo;
        try {
            iGProGuildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(str);
        } catch (Exception unused) {
            com.tencent.xaction.log.b.a("IGPSService", 1, "IGPSService not init");
            iGProGuildInfo = null;
        }
        if (iGProGuildInfo == null) {
            return 4;
        }
        return d(iGProGuildInfo.isMember(), iGProGuildInfo.getUserType());
    }

    public static int d(boolean z16, int i3) {
        if (!z16) {
            return 4;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                return 2;
            }
            if (i3 != 2) {
                return 4;
            }
            return 1;
        }
        return 3;
    }
}
