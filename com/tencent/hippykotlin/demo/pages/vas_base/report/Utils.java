package com.tencent.hippykotlin.demo.pages.vas_base.report;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.manager.c;
import defpackage.k;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Utils {
    public static final Utils INSTANCE = new Utils();
    public static final Map<QQKuiklyPlatformApi.QQNetworkType, String> networkMap;

    static {
        Map<QQKuiklyPlatformApi.QQNetworkType, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QQKuiklyPlatformApi.QQNetworkType.X2G, "2G"), TuplesKt.to(QQKuiklyPlatformApi.QQNetworkType.X3G, "3G"), TuplesKt.to(QQKuiklyPlatformApi.QQNetworkType.X4G, "4G"), TuplesKt.to(QQKuiklyPlatformApi.QQNetworkType.X5G, "5G"), TuplesKt.to(QQKuiklyPlatformApi.QQNetworkType.WIFI, Global.TRACKING_WIFI), TuplesKt.to(QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE, "OFFLINE"));
        networkMap = mapOf;
    }

    public final String network() {
        String str = networkMap.get(((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).getNetworkType());
        if (str == null) {
            str = "UNKNOWN";
        }
        return str;
    }

    public final String platform() {
        if (k.a(c.f117352a)) {
            return "android";
        }
        return "ios";
    }
}
