package com.tencent.hippykotlin.demo.pages.foundation.lib.mqq;

import com.tencent.hippykotlin.demo.pages.foundation.module.DeviceInfo;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.manager.c;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MqqDevice {
    public final Lazy lazyDeviceInfo$delegate;
    public final Map<QQKuiklyPlatformApi.QQNetworkType, String> networkTypeMap;

    public MqqDevice() {
        Lazy lazy;
        Map<QQKuiklyPlatformApi.QQNetworkType, String> mapOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DeviceInfo>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqDevice$lazyDeviceInfo$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final DeviceInfo invoke() {
                MqqDevice.this.getClass();
                return ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).getDeviceInfo();
            }
        });
        this.lazyDeviceInfo$delegate = lazy;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QQKuiklyPlatformApi.QQNetworkType.X2G, "2G"), TuplesKt.to(QQKuiklyPlatformApi.QQNetworkType.X3G, "3G"), TuplesKt.to(QQKuiklyPlatformApi.QQNetworkType.X4G, "4G"), TuplesKt.to(QQKuiklyPlatformApi.QQNetworkType.X5G, "5G"), TuplesKt.to(QQKuiklyPlatformApi.QQNetworkType.WIFI, "WiFi"));
        this.networkTypeMap = mapOf;
    }
}
