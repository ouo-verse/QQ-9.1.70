package com.tencent.hippykotlin.demo.pages.vas_base.misc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.VersionMode;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.KRequest;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Middlewares;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.VasUserAgent;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage.StorageMiddleware;
import com.tencent.hippykotlin.demo.pages.vas_base.report.keport.Keport;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceHelper;
import com.tencent.kuikly.core.manager.c;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VipRequest extends KRequest {
    public static final Companion Companion = new Companion();
    public static final KRequest instance;
    public static final List<String> urlSamplingList;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Middleware>, java.util.ArrayList] */
    static {
        List<String> listOf;
        Map mutableMapOf;
        Map mutableMapOf2;
        VersionMode versionMode;
        String sb5;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://h5.vip.qq.com/p/qzone_report/report/action", "https://h.trace.qq.com/kv", "https://club.vip.qq.com/mono/api/trpc/qqread/heartbeat/heartbeat/Heartbeat/ReadProgressReport", "https://club.vip.qq.com/mono/api/trpc/qqread/heartbeat/heartbeat/Heartbeat/ReadDurationReport"});
        urlSamplingList = listOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("ADTAG", TraceHelper.INSTANCE.getEnteranceId()));
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("https://club.vip.qq.com/kuikly/");
        c cVar = c.f117352a;
        m3.append(cVar.g().getPageName());
        m3.append('/');
        m3.append(PageDataExtKt.getResVersion(cVar.g().getPageData()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("Referer", m3.toString()));
        VipRequest vipRequest = new VipRequest(new RequestConfig(null, null, mutableMapOf2, mutableMapOf, null, 15, null, 935));
        vipRequest.middlewares.add(new StorageMiddleware(null));
        KRequest use = vipRequest.use(Middlewares.qqLogin);
        if (cVar.g().getPageData().u()) {
            versionMode = VersionMode.Debug;
        } else if (PageDataExtKt.isPublic(cVar.g().getPageData())) {
            versionMode = VersionMode.Public;
        } else {
            versionMode = VersionMode.CI;
        }
        VersionMode versionMode2 = VersionMode.Public;
        if (versionMode == versionMode2) {
            sb5 = "";
        } else {
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("__");
            if (cVar.g().getPageData().u()) {
                versionMode2 = VersionMode.Debug;
            } else if (!PageDataExtKt.isPublic(cVar.g().getPageData())) {
                versionMode2 = VersionMode.CI;
            }
            m16.append(versionMode2);
            sb5 = m16.toString();
        }
        KRequest use2 = use.use(new VipRequest$Companion$createApiReport$1(new Keport("https://h5.qzone.qq.com/v2/vip/keport"), AgreementConsentViewKt$$ExternalSyntheticOutline0.m("vip.qq.com", sb5), null));
        VasUserAgent.INSTANCE.updateUserAgent();
        instance = use2;
    }

    public VipRequest(RequestConfig requestConfig) {
        super(requestConfig);
    }
}
