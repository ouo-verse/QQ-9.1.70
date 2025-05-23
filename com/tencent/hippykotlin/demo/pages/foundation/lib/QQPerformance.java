package com.tencent.hippykotlin.demo.pages.foundation.lib;

import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPerformanceModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import defpackage.k;

/* loaded from: classes31.dex */
public final class QQPerformance {
    public static final QQPerformance INSTANCE = new QQPerformance();

    public final LaunchCost getLaunchCost() {
        LaunchTimestamps launchTimestamps = getLaunchTimestamps();
        long j3 = launchTimestamps.contentViewCreated;
        if (j3 <= 0) {
            return null;
        }
        long j16 = launchTimestamps.fetchContextEnd;
        return new LaunchCost(j16 - launchTimestamps.fetchContextStart, launchTimestamps.renderLayerReadCacheEnd - launchTimestamps.renderLayerReadCacheStart, launchTimestamps.renderLayerRenderCacheEnd - launchTimestamps.renderLayerRenderCacheStart, launchTimestamps.renderContextEnd - j16, launchTimestamps.viewLoadEnd - launchTimestamps.viewLoadStart, launchTimestamps.layoutEnd - launchTimestamps.layoutStart, j3 - j16, j3 - launchTimestamps.openPage, launchTimestamps.isForceUpdate);
    }

    public final LaunchTimestamps getLaunchTimestamps() {
        e eVar;
        boolean g16;
        boolean z16;
        try {
            eVar = new e(((QQKuiklyPerformanceModule) c.f117352a.g().acquireModule("QQKuiklyPerformanceModule")).getLaunchPerformanceData());
        } catch (Throwable th5) {
            KLog.INSTANCE.i("QQPerformance", "getLaunchTimestamps error: " + th5);
            eVar = new e();
        }
        long n3 = eVar.n(KuiklyLaunchParams.PARAM_OPEN_PAGE_TS);
        long n16 = eVar.n("fetch_context_code_start");
        long n17 = eVar.n("fetch_context_code_end");
        long n18 = eVar.n("render_layer_read_cache_start");
        long n19 = eVar.n("render_layer_read_cache_end");
        long n26 = eVar.n("render_layer_render_cache_start");
        long n27 = eVar.n("render_layer_render_cache_end");
        long n28 = eVar.n("render_context_init_start");
        long n29 = eVar.n("render_context_init_end");
        long n36 = eVar.n("view_load_start");
        long n37 = eVar.n("view_load_end");
        long n38 = eVar.n("layout_start");
        long n39 = eVar.n("layout_end");
        long n46 = eVar.n("content_view_created");
        if (k.a(c.f117352a)) {
            if (eVar.j("is_force_update_load") == 0) {
                z16 = true;
                return new LaunchTimestamps(n3, n16, n17, n18, n19, n26, n27, n28, n29, n36, n37, n38, n39, n46, z16);
            }
            g16 = false;
        } else {
            g16 = eVar.g("is_force_update_load", true);
        }
        z16 = g16;
        return new LaunchTimestamps(n3, n16, n17, n18, n19, n26, n27, n28, n29, n36, n37, n38, n39, n46, z16);
    }
}
