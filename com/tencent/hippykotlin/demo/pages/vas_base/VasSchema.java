package com.tencent.hippykotlin.demo.pages.vas_base;

import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VasSchema {
    public static final VasSchema INSTANCE = new VasSchema();
    public static final Map<String, String> necessaryParams;

    static {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("version", "1"), TuplesKt.to(ISchemeApi.KEY_IOS_SRC_TYPE, "web"), TuplesKt.to(KuiklyLaunchParams.PARAM_QQMC_CONFIG, "vas_kuikly_config"));
        necessaryParams = mapOf;
    }
}
