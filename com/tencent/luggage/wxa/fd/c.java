package com.tencent.luggage.wxa.fd;

import com.tencent.luggage.wxa.tn.w0;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f125705a = new c();

    public static final void a(String appId, JSONObject injectConfig) {
        JSONArray optJSONArray;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(injectConfig, "injectConfig");
        long c16 = w0.c();
        JSONObject optJSONObject = injectConfig.optJSONObject("tabBar");
        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("list")) != null) {
            Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(\"list\")");
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                optJSONArray.getJSONObject(i3).remove("iconData");
                optJSONArray.getJSONObject(i3).remove("selectedIconData");
            }
        }
        JSONArray optJSONArray2 = injectConfig.optJSONArray("subPackages");
        if (optJSONArray2 != null) {
            Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(\"subPackages\")");
            int length2 = optJSONArray2.length();
            for (int i16 = 0; i16 < length2; i16++) {
                optJSONArray2.getJSONObject(i16).remove("pages");
            }
        }
        JSONArray optJSONArray3 = injectConfig.optJSONArray("subpackages");
        if (optJSONArray3 != null) {
            Intrinsics.checkNotNullExpressionValue(optJSONArray3, "optJSONArray(\"subpackages\")");
            int length3 = optJSONArray3.length();
            for (int i17 = 0; i17 < length3; i17++) {
                optJSONArray3.getJSONObject(i17).remove("pages");
            }
        }
        injectConfig.remove("page");
        injectConfig.remove("preloadRule");
        injectConfig.remove("preloadResources");
        injectConfig.remove("preloadSubpackages");
        injectConfig.remove("manualSplashScreen");
        injectConfig.remove("useCommandBuffer");
        injectConfig.remove(QCircleDaTongConstant.ElementParamValue.PERMISSION);
        injectConfig.remove("navigateToMiniProgramAppIdList");
        com.tencent.luggage.wxa.tn.w.a("Luggage.WXA.AppBrandAppConfigTrimHelper", "trimOffInjectConfigFields appId[" + appId + "] cost[" + (w0.c() - c16) + "ms]");
    }
}
