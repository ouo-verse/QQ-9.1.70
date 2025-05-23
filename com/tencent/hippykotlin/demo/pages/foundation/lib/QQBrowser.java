package com.tencent.hippykotlin.demo.pages.foundation.lib;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyVasJSIModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQBrowser {
    public static final QQBrowser INSTANCE = new QQBrowser();
    public static String userAgent = "";

    public final String getFakeUserAgent() {
        String value;
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
            return "Mozilla/5.0 (iPhone; CPU iPhone OS 13_1_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 QQ/" + appVersion + " V1_IPH_SQ_" + appVersion + "_1_APP_A Pixel/1080 Core/UIWebView Device/Apple(iPhone 8Plus) NetType/WIFI QBWebViewType/1";
        }
        return "Mozilla/5.0 (Linux; Android 10; VOG-AL10 Build/HUAWEIVOG-AL10; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/045114 Mobile Safari/537.36 V1_AND_SQ_" + appVersion + "_1320_YYB_D gamecenter QQ/" + appVersion + " NetType/WIFI WebP/0.3.0 Pixel/1080 StatusBarHeight/75 SimpleUISwitch/0";
    }

    public final Object getUserAgent(Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        if (!(userAgent.length() > 0)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            try {
                QQKuiklyVasJSIModule qQKuiklyVasJSIModule = (QQKuiklyVasJSIModule) c.f117352a.g().acquireModule("QQKuiklyVasJSIModule");
                e eVar = new e();
                Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.QQBrowser$getUserAgent$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar2) {
                        String value;
                        e eVar3 = eVar2;
                        AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("[ getUserAgent ] defaultUserAgent = ", eVar3, KLog.INSTANCE, "Kukly.QQBrowser");
                        if (eVar3 != null) {
                            QQBrowser.userAgent = eVar3.p("userAgent");
                        }
                        Continuation<String> continuation2 = safeContinuation;
                        String str = QQBrowser.userAgent;
                        if (str.length() == 0) {
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
                        }
                        continuation2.resumeWith(Result.m476constructorimpl(str));
                        return Unit.INSTANCE;
                    }
                };
                qQKuiklyVasJSIModule.getClass();
                qQKuiklyVasJSIModule.toNative(false, "getDefaultUserAgent", eVar.toString(), function1, false);
            } catch (RuntimeException e16) {
                KLog.INSTANCE.i("Kukly.QQBrowser", "[ getUserAgent ] catch RuntimeException = " + e16);
                String str = userAgent;
                if (str.length() == 0) {
                    str = INSTANCE.getFakeUserAgent();
                }
                safeContinuation.resumeWith(Result.m476constructorimpl(str));
            } catch (Exception e17) {
                KLog.INSTANCE.i("Kukly.QQBrowser", "[ getUserAgent ] catch Exception = " + e17);
                String str2 = userAgent;
                if (str2.length() == 0) {
                    str2 = INSTANCE.getFakeUserAgent();
                }
                safeContinuation.resumeWith(Result.m476constructorimpl(str2));
            }
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[ getUserAgent ] userAgent.isNotEmpty() = "), userAgent, KLog.INSTANCE, "Kukly.QQBrowser");
        return userAgent;
    }
}
