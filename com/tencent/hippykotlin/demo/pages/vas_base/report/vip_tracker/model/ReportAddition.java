package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.vas_base.report.Utils;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ReportAddition {
    public static final Companion Companion = new Companion();
    public static final e addition = new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportAddition$Companion$addition$1
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(e eVar) {
            String str;
            e eVar2 = eVar;
            c cVar = c.f117352a;
            eVar2.z("app_version", cVar.g().getPageData().getAppVersion());
            eVar2.z("city_code", "");
            if (PageDataExtKt.isTim(cVar.g().getPageData())) {
                str = "tim";
            } else {
                str = "qq";
            }
            eVar2.z(AudienceReportConst.CLIENT_TYPE, str);
            eVar2.z("guid", "");
            eVar2.z("ip_addr", "");
            eVar2.z("latitude", 0);
            eVar2.z("longitude", 0);
            eVar2.z("market", "");
            eVar2.z("mobile_type", ((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).getDeviceInfo().systemName);
            Utils utils = Utils.INSTANCE;
            eVar2.z("network_type", utils.network());
            eVar2.z("operators", "");
            eVar2.z("os_version", ((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).getDeviceInfo().systemVersion);
            eVar2.z("platform", utils.platform());
            eVar2.z(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, ((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).getDeviceInfo().qimei);
            eVar2.z("qua", ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).getQua());
            eVar2.z("to_uin", 0);
            eVar2.z("uin", cVar.g().getPageData().n().q("uin", ""));
            eVar2.C("user_tag", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportAddition$Companion$addition$1.1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(e eVar3) {
                    return Unit.INSTANCE;
                }
            });
            return Unit.INSTANCE;
        }
    });

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
    }
}
