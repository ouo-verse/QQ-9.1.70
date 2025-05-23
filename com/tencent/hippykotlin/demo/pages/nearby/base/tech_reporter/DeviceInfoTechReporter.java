package com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter;

import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPDeviceInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class DeviceInfoTechReporter extends NearbyTechReporter {
    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final String getKey() {
        return "ev_nearby_tech_perf_device_info";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final void report() {
        super.report();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final e toParams() {
        e eVar;
        NBPDeviceInfo nBPDeviceInfo;
        c cVar = c.f117352a;
        String a16 = ((b) cVar.g().acquireModule("KRCalendarModule")).a(APICallTechReporterKt.NBPCurrentTime(), TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        if (Intrinsics.areEqual(a16, ((CacheModule) cVar.g().acquireModule("HRCacheModule")).getItem("NBP_TECH_REPORT_REPORT_DEVICE_INFO_DATE"))) {
            return null;
        }
        ((CacheModule) cVar.g().acquireModule("HRCacheModule")).setItem("NBP_TECH_REPORT_REPORT_DEVICE_INFO_DATE", a16);
        try {
            eVar = new e(QQNearbyModule.Companion.getInstance().toNative(false, "getDeviceInfo", null, null, true).toString());
        } catch (Exception e16) {
            KLog kLog = KLog.INSTANCE;
            NearbyConst nearbyConst = NearbyConst.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getDeviceInfo error: ");
            m3.append(e16.getMessage());
            kLog.e("feed_detail_page", m3.toString());
            eVar = null;
        }
        if (eVar == null) {
            nBPDeviceInfo = null;
        } else {
            nBPDeviceInfo = new NBPDeviceInfo();
            nBPDeviceInfo.osName = eVar.q(DKEngine.GlobalKey.OS_NAME, "");
            nBPDeviceInfo.systemUiVersion = eVar.q("systemUiVersion", "");
            nBPDeviceInfo.coreName = eVar.q("coreName", "");
            nBPDeviceInfo.cpuName = eVar.q("cpuName", "");
            nBPDeviceInfo.gpuName = eVar.q("gpuName", "");
            nBPDeviceInfo.ramSize = eVar.q("ramSize", "");
            nBPDeviceInfo.displayWidth = eVar.q("displayWidth", "");
            nBPDeviceInfo.displayHeight = eVar.q("displayHeight", "");
            nBPDeviceInfo.displayDensity = eVar.q("displayDensity", "");
            nBPDeviceInfo.cpuCoreCount = eVar.q("cpuCoreCount", "");
            nBPDeviceInfo.cpuFreq = eVar.q("cpuFreq", "");
        }
        if (nBPDeviceInfo == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.v("nearby_hi_os", nBPDeviceInfo.osName);
        eVar2.v("nearby_hi_ui_version", nBPDeviceInfo.systemUiVersion);
        eVar2.v("nearby_hi_core_name", nBPDeviceInfo.coreName);
        eVar2.v("nearby_hi_cpu_name", nBPDeviceInfo.cpuName);
        eVar2.v("nearby_hi_gpu_name", nBPDeviceInfo.gpuName);
        eVar2.v("nearby_hi_ram", nBPDeviceInfo.ramSize);
        eVar2.v("nearby_hi_width", nBPDeviceInfo.displayWidth);
        eVar2.v("nearby_hi_height", nBPDeviceInfo.displayHeight);
        eVar2.v("nearby_hi_density", nBPDeviceInfo.displayDensity);
        eVar2.v("nearby_hi_cpu_core_count", nBPDeviceInfo.cpuCoreCount);
        eVar2.v("nearby_hi_cpu_freq", nBPDeviceInfo.cpuFreq);
        return eVar2;
    }
}
