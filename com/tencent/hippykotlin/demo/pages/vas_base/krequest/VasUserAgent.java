package com.tencent.hippykotlin.demo.pages.vas_base.krequest;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQBrowser;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.VersionMode;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUtil;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyVasJSIModule;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.debug.DebugTools;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.pager.h;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import zz0.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VasUserAgent {
    public static final VasUserAgent INSTANCE = new VasUserAgent();
    public static long lastUpdateTime = 0;
    public static String userAgent = "";

    public final String getCACHE_KEY() {
        return c.f117352a.g().getPageData().n().q("uin", "") + "_VasUserAgent";
    }

    public final void log(String str) {
        boolean contains;
        DebugTools debugTools = DebugTools.INSTANCE;
        VersionMode versionMode = VersionMode.Debug;
        VersionMode versionMode2 = VersionMode.CI;
        VersionMode[] versionModeArr = {versionMode, versionMode2};
        c cVar = c.f117352a;
        if (!cVar.g().getPageData().u()) {
            versionMode = PageDataExtKt.isPublic(cVar.g().getPageData()) ? VersionMode.Public : versionMode2;
        }
        contains = ArraysKt___ArraysKt.contains(versionModeArr, versionMode);
        if (contains) {
            KLog.INSTANCE.i("VasUserAgent", str);
        }
    }

    public final void updateUserAgent() {
        String str;
        String value;
        a aVar = a.f453719a;
        if (aVar.a() - lastUpdateTime <= 2000) {
            log("not update UA");
            return;
        }
        log("start update UA");
        lastUpdateTime = aVar.a();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.krequest.VasUserAgent$updateUserAgent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(String str2) {
                boolean contains;
                String str3 = str2;
                if (!(str3 == null || str3.length() == 0)) {
                    String str4 = "update UA finish,cost time=" + (a.f453719a.a() - VasUserAgent.lastUpdateTime);
                    DebugTools debugTools = DebugTools.INSTANCE;
                    VersionMode versionMode = VersionMode.Debug;
                    VersionMode versionMode2 = VersionMode.CI;
                    VersionMode[] versionModeArr = {versionMode, versionMode2};
                    c cVar = c.f117352a;
                    if (!cVar.g().getPageData().u()) {
                        versionMode = PageDataExtKt.isPublic(cVar.g().getPageData()) ? VersionMode.Public : versionMode2;
                    }
                    contains = ArraysKt___ArraysKt.contains(versionModeArr, versionMode);
                    if (contains) {
                        KLog.INSTANCE.i("VasUserAgent", str4);
                    }
                    VasUserAgent vasUserAgent = VasUserAgent.this;
                    VasUserAgent.userAgent = str3;
                    vasUserAgent.getClass();
                    MqqUtil util = Mqq.INSTANCE.getUtil();
                    String cache_key = vasUserAgent.getCACHE_KEY();
                    String str5 = VasUserAgent.userAgent;
                    util.getClass();
                    if (QQUtils.INSTANCE.compare("9.1.50") >= 0) {
                        ((e) h.a().acquireModule("KRDiskCacheModule")).g(cache_key, str5);
                    } else {
                        ((CacheModule) cVar.g().acquireModule("HRCacheModule")).setItem(cache_key, str5);
                    }
                }
                return Unit.INSTANCE;
            }
        };
        if (QQBrowser.userAgent.length() > 0) {
            function1.invoke(QQBrowser.userAgent);
            return;
        }
        try {
            QQKuiklyVasJSIModule qQKuiklyVasJSIModule = (QQKuiklyVasJSIModule) c.f117352a.g().acquireModule("QQKuiklyVasJSIModule");
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit> function12 = new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.QQBrowser$getUserAgent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar2) {
                    String str2;
                    String value2;
                    String str3;
                    String value3;
                    com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = eVar2;
                    if (QQBrowser.userAgent.length() > 0) {
                        function1.invoke(QQBrowser.userAgent);
                    } else if (eVar3 == null) {
                        Function1<String, Unit> function13 = function1;
                        c cVar = c.f117352a;
                        b g16 = cVar.g();
                        String appVersion = g16.getPageData().getAppVersion();
                        if (appVersion.length() == 0) {
                            appVersion = ((BridgeModule) g16.acquireModule("HRBridgeModule")).getDeviceInfo().appVersion;
                        }
                        MatchResult matchEntire = new Regex("^\\d+\\.\\d+\\.\\d+").matchEntire(appVersion);
                        if (matchEntire != null && (value3 = matchEntire.getValue()) != null) {
                            appVersion = value3;
                        }
                        if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
                            str3 = "Mozilla/5.0 (iPhone; CPU iPhone OS 13_1_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 QQ/" + appVersion + " V1_IPH_SQ_" + appVersion + "_1_APP_A Pixel/1080 Core/UIWebView Device/Apple(iPhone 8Plus) NetType/WIFI QBWebViewType/1";
                        } else {
                            str3 = "Mozilla/5.0 (Linux; Android 10; VOG-AL10 Build/HUAWEIVOG-AL10; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/045114 Mobile Safari/537.36 V1_AND_SQ_" + appVersion + "_1320_YYB_D gamecenter QQ/" + appVersion + " NetType/WIFI WebP/0.3.0 Pixel/1080 StatusBarHeight/75 SimpleUISwitch/0";
                        }
                        function13.invoke(str3);
                    } else {
                        String p16 = eVar3.p("userAgent");
                        QQBrowser.userAgent = p16;
                        if (p16.length() == 0) {
                            Function1<String, Unit> function14 = function1;
                            c cVar2 = c.f117352a;
                            b g17 = cVar2.g();
                            String appVersion2 = g17.getPageData().getAppVersion();
                            if (appVersion2.length() == 0) {
                                appVersion2 = ((BridgeModule) g17.acquireModule("HRBridgeModule")).getDeviceInfo().appVersion;
                            }
                            MatchResult matchEntire2 = new Regex("^\\d+\\.\\d+\\.\\d+").matchEntire(appVersion2);
                            if (matchEntire2 != null && (value2 = matchEntire2.getValue()) != null) {
                                appVersion2 = value2;
                            }
                            if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar2)) {
                                str2 = "Mozilla/5.0 (iPhone; CPU iPhone OS 13_1_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 QQ/" + appVersion2 + " V1_IPH_SQ_" + appVersion2 + "_1_APP_A Pixel/1080 Core/UIWebView Device/Apple(iPhone 8Plus) NetType/WIFI QBWebViewType/1";
                            } else {
                                str2 = "Mozilla/5.0 (Linux; Android 10; VOG-AL10 Build/HUAWEIVOG-AL10; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/045114 Mobile Safari/537.36 V1_AND_SQ_" + appVersion2 + "_1320_YYB_D gamecenter QQ/" + appVersion2 + " NetType/WIFI WebP/0.3.0 Pixel/1080 StatusBarHeight/75 SimpleUISwitch/0";
                            }
                            function14.invoke(str2);
                        } else {
                            function1.invoke(QQBrowser.userAgent);
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            qQKuiklyVasJSIModule.getClass();
            qQKuiklyVasJSIModule.toNative(false, "getDefaultUserAgent", eVar.toString(), function12, false);
        } catch (RuntimeException unused) {
            c cVar = c.f117352a;
            b g16 = cVar.g();
            String appVersion = g16.getPageData().getAppVersion();
            if (appVersion.length() == 0) {
                appVersion = ((BridgeModule) g16.acquireModule("HRBridgeModule")).getDeviceInfo().appVersion;
            }
            MatchResult matchEntire = new Regex("^\\d+\\.\\d+\\.\\d+").matchEntire(appVersion);
            if (matchEntire != null && (value = matchEntire.getValue()) != null) {
                appVersion = value;
            }
            if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
                str = "Mozilla/5.0 (iPhone; CPU iPhone OS 13_1_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 QQ/" + appVersion + " V1_IPH_SQ_" + appVersion + "_1_APP_A Pixel/1080 Core/UIWebView Device/Apple(iPhone 8Plus) NetType/WIFI QBWebViewType/1";
            } else {
                str = "Mozilla/5.0 (Linux; Android 10; VOG-AL10 Build/HUAWEIVOG-AL10; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/045114 Mobile Safari/537.36 V1_AND_SQ_" + appVersion + "_1320_YYB_D gamecenter QQ/" + appVersion + " NetType/WIFI WebP/0.3.0 Pixel/1080 StatusBarHeight/75 SimpleUISwitch/0";
            }
            function1.invoke(str);
        }
    }
}
