package com.tencent.hippykotlin.demo.pages.foundation.lib.aegis;

import com.tencent.aegiskmm.bean.AegisConfig;
import com.tencent.aegiskmm.bean.PageLoadStrategy;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUser;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqDevice;
import com.tencent.hippykotlin.demo.pages.foundation.module.DeviceInfo;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPerformanceModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import defpackage.k;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQAegis {
    public static final QQAegis INSTANCE = new QQAegis();
    public static final AegisConfig extendConfig;
    public static final g pageData;
    public static final String qimei;
    public static final String qimei36;

    static {
        e eVar;
        boolean g16;
        PageLoadStrategy pageLoadStrategy;
        c cVar = c.f117352a;
        pageData = cVar.g().getPageData();
        qimei36 = ((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).getDeviceInfo().qimei36;
        qimei = ((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).getDeviceInfo().qimei;
        try {
            eVar = new e(((QQKuiklyPerformanceModule) cVar.g().acquireModule("QQKuiklyPerformanceModule")).getLaunchPerformanceData());
        } catch (Throwable unused) {
            eVar = new e();
        }
        c cVar2 = c.f117352a;
        if (k.a(cVar2)) {
            g16 = eVar.j("is_force_update_load") == 0;
        } else {
            g16 = eVar.g("is_force_update_load", true);
        }
        if (g16) {
            pageLoadStrategy = PageLoadStrategy.NetworkFetchLatest;
        } else {
            pageLoadStrategy = PageLoadStrategy.CacheFetchLatest;
        }
        String value = pageLoadStrategy.getValue();
        DeviceInfo deviceInfo = (DeviceInfo) ((MqqDevice) Mqq.device$delegate.getValue()).lazyDeviceInfo$delegate.getValue();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(cVar2.g().getPageData().getAppVersion());
        sb5.append(util.base64_pad_url);
        g gVar = pageData;
        sb5.append(PageDataExtKt.getResVersion(gVar));
        String sb6 = sb5.toString();
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("session-");
        m3.append(b.c((b) cVar2.g().acquireModule("KRCalendarModule"), 0L, 1, null).a());
        String sb7 = m3.toString();
        String pageName = cVar2.g().getPageName();
        String str = qimei36;
        String str2 = str.length() == 0 ? qimei : str;
        if (QQUser.uin.length() == 0) {
            QQUser.uin = cVar2.g().getPageData().n().p("uin");
        }
        extendConfig = new AegisConfig(null, null, QQUser.uin, sb6, null, str2, null, null, null, null, null, null, sb7, pageName, null, 0, 0, 0.0f, 0, false, null, false, gVar.getAppVersion(), gVar.getOsVersion(), String.valueOf(PageDataExtKt.getResVersion(cVar2.g().getPageData())), null, value, null, deviceInfo.model, str.length() == 0 ? qimei : str, 171954131, null);
    }
}
