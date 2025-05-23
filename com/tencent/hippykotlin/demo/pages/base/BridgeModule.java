package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.model.KTVAlertInfo;
import com.tencent.hippykotlin.demo.pages.base.model.KTVDeviceInfo;
import com.tencent.hippykotlin.demo.pages.base.model.KTVEntry;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.h;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BridgeModule extends Module {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static void preDownloadImage$default(BridgeModule bridgeModule, String str) {
        bridgeModule.getClass();
        e eVar = new e();
        eVar.v("url", str);
        final Function1 function1 = null;
        bridgeModule.callNativeMethod("preDownloadImage", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$preDownloadImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                Function1<e, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(eVar3);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final String base64Code(String str, boolean z16) {
        e eVar = new e();
        eVar.v("msg", str);
        eVar.w("isEncode", z16);
        return syncToNativeMethod("base64Code", eVar, (Function1<? super e, Unit>) null);
    }

    public final List base64CodeBatch(String[] strArr) {
        e eVar = new e();
        b bVar = new b();
        for (String str : strArr) {
            bVar.t(str);
        }
        Unit unit = Unit.INSTANCE;
        eVar.v("msg", bVar);
        eVar.w("isEncode", true);
        String syncToNativeMethod = syncToNativeMethod("base64CodeBatch", eVar, (Function1<? super e, Unit>) null);
        ArrayList arrayList = new ArrayList();
        try {
            b bVar2 = new b(syncToNativeMethod);
            int c16 = bVar2.c();
            for (int i3 = 0; i3 < c16; i3++) {
                String o16 = bVar2.o(i3);
                if (o16 == null) {
                    o16 = "";
                }
                arrayList.add(o16);
            }
        } catch (JSONException e16) {
            Utils utils = Utils.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("#base64CodeBatch ");
            m3.append(e16.getMessage());
            utils.logToNative(m3.toString());
        }
        return arrayList;
    }

    public final boolean canOpenMiniApp() {
        Integer intOrNull;
        if (c.f117352a.k(getPagerId()).getPageData().getIsAndroid()) {
            return true;
        }
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(syncToNativeMethod("canOpenMiniApp", (e) null, (Function1<? super e, Unit>) null));
        int intValue = intOrNull != null ? intOrNull.intValue() : 0;
        Utils.INSTANCE.logToNative("canOpenMiniApp:" + intValue);
        return intValue > 0;
    }

    public final void cleanPB(ArrayList<String> arrayList) {
        if (arrayList.size() <= 0) {
            return;
        }
        e eVar = new e();
        b bVar = new b();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            bVar.t(it.next());
        }
        eVar.v("tokenArray", bVar);
        callNativeMethod("cleanPB", eVar, null);
    }

    public final void copyToPasteboard(String str) {
        e eVar = new e();
        eVar.v("content", str);
        callNativeMethod("copyToPasteboard", eVar, null);
    }

    public final long currentTimeStamp() {
        String syncToNativeMethod = syncToNativeMethod("currentTimestamp", (e) null, (Function1<? super e, Unit>) null);
        if (syncToNativeMethod.length() > 0) {
            return Long.parseLong(syncToNativeMethod);
        }
        return 0L;
    }

    public final String getCachedFromNative(String str) {
        e eVar = new e();
        eVar.v("key", str);
        return syncToNativeMethod("getCachedFromNative", eVar, (Function1<? super e, Unit>) null);
    }

    public final String getCurrentAccount() {
        return syncToNativeMethod("getAccount", new e(), (Function1<? super e, Unit>) null);
    }

    public final KTVDeviceInfo getDeviceInfo() {
        e eVar;
        ArrayList arrayList = null;
        String syncToNativeMethod = syncToNativeMethod("getDeviceInfo", new e(), (Function1<? super e, Unit>) null);
        try {
            eVar = new e(syncToNativeMethod);
        } catch (Throwable unused) {
            KLog.INSTANCE.e("BridgeModule", "getDeviceInfo, error string: " + syncToNativeMethod);
            eVar = new e();
        }
        String q16 = eVar.q("app_version", "");
        int i3 = 0;
        int k3 = eVar.k("os", 0);
        String q17 = eVar.q("device_id", "");
        String q18 = eVar.q(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "");
        String q19 = eVar.q("qimei36", "");
        int k16 = eVar.k("network", 0);
        String q26 = eVar.q("ip", "");
        String q27 = eVar.q("terminal_id", "");
        String q28 = eVar.q(AudienceReportConst.TERMINAL_TYPE, "");
        String q29 = eVar.q("manufacturer", "");
        String q36 = eVar.q("device_brand_and_model", "");
        b l3 = eVar.l("ext");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            while (i3 < c16) {
                int i16 = c16;
                Object d16 = l3.d(i3);
                b bVar = l3;
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new KTVEntry(eVar2.q("key", ""), eVar2.q("value", "")));
                }
                i3++;
                c16 = i16;
                l3 = bVar;
            }
        }
        return new KTVDeviceInfo(q16, k3, q17, q18, q19, k16, q26, q27, q28, q29, q36, arrayList);
    }

    public final int getFriendStatus(String str) {
        Integer intOrNull;
        e eVar = new e();
        eVar.v("uin", str);
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(syncToNativeMethod("getFriendStatus", eVar, (Function1<? super e, Unit>) null));
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 0;
    }

    public final String getQua() {
        return syncToNativeMethod("getQCircleQua", (e) null, (Function1<? super e, Unit>) null);
    }

    public final boolean isWifiConnected() {
        return ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).getNetworkType() == QQKuiklyPlatformApi.QQNetworkType.WIFI;
    }

    public final void joinTroop(String str, String str2, boolean z16, String str3, final Function1<? super Integer, Unit> function1) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("troopUin", str, "troopName", str2);
        m3.v("authSign", str3);
        m3.w("isExactSearch", z16);
        m3.v("sourceId", String.valueOf(z16 ? 30021 : 30023));
        callNativeMethod("joinTroop", m3, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$joinTroop$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                Integer num;
                e eVar2 = eVar;
                if (eVar2 != null) {
                    Function1<Integer, Unit> function12 = function1;
                    int j3 = eVar2.j("code");
                    Utils.INSTANCE.logToNative("#joinTroop code=" + j3);
                    if (j3 == 1) {
                        num = 0;
                    } else if (j3 != 2) {
                        num = j3 != 3 ? null : 2;
                    } else {
                        num = 1;
                    }
                    if (num != null) {
                        int intValue = num.intValue();
                        if (function12 != null) {
                            function12.invoke(Integer.valueOf(intValue));
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void joinTroopV2(String str, String str2, boolean z16, String str3, String str4, final Function1<? super Integer, Unit> function1) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("troopUin", str, "troopName", str2);
        m3.v("authSign", str3);
        m3.w("isExactSearch", z16);
        m3.v("sourceId", str4);
        callNativeMethod("joinTroop", m3, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$joinTroopV2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                Integer num;
                e eVar2 = eVar;
                if (eVar2 != null) {
                    Function1<Integer, Unit> function12 = function1;
                    int j3 = eVar2.j("code");
                    Utils.INSTANCE.logToNative("#joinTroopV2 code=" + j3);
                    if (j3 == 1) {
                        num = 0;
                    } else if (j3 != 2) {
                        num = j3 != 3 ? null : 2;
                    } else {
                        num = 1;
                    }
                    if (num != null) {
                        int intValue = num.intValue();
                        if (function12 != null) {
                            function12.invoke(Integer.valueOf(intValue));
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void localServeTime(Function1<? super e, Unit> function1) {
        callNativeMethod("localServeTime", null, function1);
    }

    public final void log(String str) {
        e eVar = new e();
        eVar.v("content", str);
        callNativeMethod("log", eVar, null);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "HRBridgeModule";
    }

    public final void openLogisticsPage(b bVar) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("infoTitle", "\u670d\u52a1\u4fdd\u969c", "pageName", "qshop_detail_logistics");
        m3.v("dataArray", bVar);
        callNativeMethod("openLogisticsPage", m3, null);
    }

    public final void openQQCirLayerPage(List list, long j3, String str, String str2, Map map) {
        b bVar = new b();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("openQQCirLayerPage:    feedPbToken:", str3, KLog.INSTANCE, "BridgeModule");
            bVar.t(str3);
        }
        e eVar = new e();
        eVar.v("feedPbTokens", bVar);
        eVar.t("playIndex", 0);
        eVar.u("playPosition", j3);
        eVar.t("sourceType", 70);
        eVar.t("subSourceType", 0);
        eVar.w("useOneDragN", false);
        eVar.v("keyword", str);
        eVar.v("pageName", str2);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                eVar.v((String) entry.getKey(), entry.getValue());
            }
        }
        callNativeMethod("openQQCirLayerPageForSearch", eVar, null);
    }

    public final void openTroopPage(String str, String str2, boolean z16, String str3, String str4, String str5) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("troopUin", str, "troopName", str2);
        m3.w("isExactSearch", z16);
        m3.v("authSign", str3);
        m3.v("transInfo", str4);
        m3.v("keyword", str5);
        m3.v("sourceId", String.valueOf(z16 ? 30022 : 30024));
        callNativeMethod("openTroopPage", m3, null);
    }

    public final void openTroopPageV2(String str, String str2, boolean z16, String str3, String str4, String str5, String str6) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("troopUin", str, "troopName", str2);
        m3.w("isExactSearch", z16);
        m3.v("authSign", str3);
        m3.v("transInfo", str4);
        m3.v("keyword", str5);
        m3.v("sourceId", str6);
        callNativeMethod("openTroopPage", m3, null);
    }

    public final void preloadPB(String str, String str2, String str3) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("pbClassName", str, BaseConstants.ATTRIBUTE_KEY_PB_DATA, str2);
        m3.v("feedPbToken", str3);
        callNativeMethod("preloadPB", m3, null);
    }

    public final void qCircleDTReport(String str, String str2, e eVar) {
        e eVar2 = new e();
        eVar2.v("extraParam", eVar);
        eVar2.v("feedPbToken", str);
        eVar2.v(AdMetricTag.EVENT_NAME, str2);
        callNativeMethod("qCircleDTReport", eVar2, null);
    }

    public final void qCircleOpenPersonalDetailPage(String str) {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("feedPbToken", str);
        Unit unit = Unit.INSTANCE;
        callNativeMethod("qCircleOpenPersonalDetailPage", m3, null);
    }

    public final void qCirclePreloadFeeds(ArrayList<String> arrayList) {
        e eVar = new e();
        b bVar = new b();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            bVar.t(it.next());
        }
        eVar.v("feedsPbToken", bVar);
        callNativeMethod("qCirclePreloadFeeds", eVar, null);
    }

    @Deprecated(message = "\u4f7f\u7528  QQBridgeApi.platformModule.qqToast \u6216\u8005 QQKuiklyPlatformApi.qqToast \u66ff\u4ee3")
    public final void qToast(String str, QToastMode qToastMode) {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("content", str);
        m3.t("mode", qToastMode.value);
        callNativeMethod("qToast", m3, null);
    }

    public final void reportCustomDtEvent(String str, e eVar) {
        e eVar2 = new e();
        Object obj = h.a().getExtProps().get("vr_page_data");
        e eVar3 = obj instanceof e ? (e) obj : null;
        if (eVar3 == null) {
            if (eVar == null) {
                eVar = new e();
            }
        } else if (eVar == null) {
            eVar = eVar3;
        } else {
            Iterator<String> c16 = eVar3.c();
            while (c16.hasNext()) {
                String next = c16.next();
                if (!eVar.a(next)) {
                    eVar.v(next, eVar3.p(next));
                }
            }
        }
        Iterator<String> c17 = eVar.c();
        Object obj2 = null;
        while (c17.hasNext()) {
            String next2 = c17.next();
            Object e16 = eVar.e(next2);
            if (Intrinsics.areEqual(next2, "cur_pg")) {
                obj2 = e16;
            }
            if (!(e16 instanceof String) && !(e16 instanceof Number)) {
                eVar.v(next2, String.valueOf(e16));
            }
        }
        if (h.a().getPageData().getIsIOS() && (obj2 instanceof e)) {
            e eVar4 = (e) obj2;
            Iterator<String> c18 = eVar4.c();
            while (c18.hasNext()) {
                String next3 = c18.next();
                Object e17 = eVar4.e(next3);
                if ((e17 instanceof String) || (e17 instanceof Number)) {
                    eVar.v(next3, e17);
                }
            }
        }
        eVar2.v("eventCode", str);
        eVar2.v("data", eVar);
        callNativeMethod("reportCustomDtEvent", eVar2, null);
    }

    public final void reportDT(String str, e eVar) {
        e eVar2 = new e();
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            Object e16 = eVar.e(next);
            if (!(e16 instanceof String) && !(e16 instanceof Number)) {
                eVar.v(next, String.valueOf(e16));
            }
        }
        eVar2.v("eventCode", str);
        eVar2.v("data", eVar);
        callNativeMethod("reportDT", eVar2, null);
    }

    public final void sendQCirclePanelStateEvent(String str, boolean z16) {
        if (c.f117352a.k(getPagerId()).getPageData().getIsIOS()) {
            return;
        }
        e eVar = new e();
        eVar.v("circle_feed_id", str);
        eVar.w("is_showing", z16);
        callNativeMethod("sendQCirclePanelStateEvent", eVar, null);
    }

    public final long serverTimeMillis() {
        return Long.parseLong(syncToNativeMethod("serverTimeMillis", (e) null, (Function1<? super e, Unit>) null));
    }

    public final void setBlackStatusBarStyle() {
        callNativeMethod("setBlackStatusBarStyle", null, null);
    }

    public final void setCachedToNative(String str, String str2, final Function1<? super e, Unit> function1) {
        callNativeMethod("setCachedToNative", AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("key", str, "value", str2), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$setCachedToNative$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                Function1<e, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(eVar2);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void setWhiteStatusBarStyle() {
        callNativeMethod("setWhiteStatusBarStyle", null, null);
    }

    @Deprecated(message = "\u8be5\u65b9\u6cd5\u5b89\u5353\u591c\u95f4\u9002\u914d\u6709\u95ee\u9898\uff0c\u5efa\u8bae\u5207\u6362\u81f3QQBridgeApi.uiModule.openAlertDialog()")
    public final void showAlert(String str, String str2, String str3, String str4, final Function1<? super e, Unit> function1) {
        e eVar = new e();
        b bVar = new b();
        if (str3 != null) {
            bVar.t(str3);
        }
        if (str4 != null) {
            bVar.t(str4);
        }
        eVar.v("buttons", bVar);
        if (str != null) {
            eVar.v("title", str);
        }
        if (str2 != null) {
            eVar.v("message", str2);
        }
        callNativeMethod("showAlert", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$showAlert$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                function1.invoke(eVar2);
                return Unit.INSTANCE;
            }
        });
    }

    public final void showPhotoBrowser(e eVar) {
        callNativeMethod("showPhotoBrowser", eVar, null);
    }

    public final void ssoRequest(String str, e eVar, boolean z16, Function1<? super e, Unit> function1) {
        e eVar2 = new e();
        eVar2.v("cmd", str);
        eVar2.v("reqParam", eVar);
        eVar2.w("useOriginalPath", z16);
        callNativeMethod("ssoRequest", eVar2, function1);
    }

    public final void toast(String str) {
        e eVar = new e();
        eVar.v("content", str);
        callNativeMethod("toast", eVar, null);
    }

    public final String urlDecode(String str) {
        e eVar = new e();
        eVar.v(HippyControllerProps.STRING, str);
        return syncToNativeMethod("urlDecode", eVar, (Function1<? super e, Unit>) null);
    }

    public final String urlEncode(String str) {
        e eVar = new e();
        eVar.v(HippyControllerProps.STRING, str);
        return syncToNativeMethod("urlEncode", eVar, (Function1<? super e, Unit>) null);
    }

    public final void callNativeMethod(String str, e eVar, Function1<? super e, Unit> function1) {
        toNative(false, str, eVar != null ? eVar.toString() : null, function1, false);
    }

    public static void openGuildChannel$default(BridgeModule bridgeModule, long j3, String str, String str2, int i3, String str3, String str4, String str5, int i16) {
        Object obj = (i16 & 64) != 0 ? "search" : null;
        String str6 = (i16 & 128) != 0 ? "" : null;
        if ((i16 & 256) != 0) {
            str5 = "";
        }
        bridgeModule.getClass();
        e eVar = new e();
        eVar.v("guildId", String.valueOf(j3));
        eVar.v("joinGuildSig", str);
        eVar.v("query", str2);
        eVar.t("joinedGuild", i3);
        eVar.v("traceId", str3);
        eVar.v("mainSource", obj);
        eVar.v("subSource", str4);
        if (str6.length() > 0) {
            eVar.v("sgrp_stream_pgin_source_name", str6);
        }
        eVar.v(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, str5);
        bridgeModule.callNativeMethod("openGuildChannelPage", eVar, null);
    }

    public final void showAlert(KTVAlertInfo kTVAlertInfo, String str, String str2, final Function1<? super e, Unit> function1) {
        e eVar = new e();
        b bVar = new b();
        if (str != null) {
            bVar.t(str);
        }
        if (str2 != null) {
            bVar.t(str2);
        }
        eVar.v("buttons", bVar);
        kTVAlertInfo.getClass();
        e eVar2 = new e();
        String str3 = kTVAlertInfo.title;
        if (str3 != null) {
            eVar2.v("title", str3);
        }
        String str4 = kTVAlertInfo.message;
        if (str4 != null) {
            eVar2.v("message", str4);
        }
        eVar2.v("messageFontSize", Float.valueOf(kTVAlertInfo.messageFontSize));
        eVar2.t("messageAlignment", BoxType$EnumUnboxingSharedUtility.ordinal(kTVAlertInfo.messageAlignment));
        eVar.v("info", eVar2);
        callNativeMethod("showAlert", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$showAlert$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar3) {
                function1.invoke(eVar3);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void closePage$default(BridgeModule bridgeModule, e eVar, Function1 function1, int i3) {
        if ((i3 & 1) != 0) {
            eVar = null;
        }
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        bridgeModule.callNativeMethod("closePage", eVar, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void openPage$default(BridgeModule bridgeModule, String str, boolean z16, e eVar, Function1 function1, int i3) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            eVar = null;
        }
        if ((i3 & 16) != 0) {
            function1 = null;
        }
        bridgeModule.getClass();
        e eVar2 = new e();
        eVar2.v("url", str);
        eVar2.t("closeCurPage", d.b(z16));
        eVar2.t("closeAllKTVPage", d.b(false));
        if (eVar != null) {
            eVar2.v("userData", eVar);
        }
        bridgeModule.callNativeMethod(IndividuationPlugin.Method_OpenPage, eVar2, function1);
    }

    public final String dateFormatter(long j3, String str) {
        if (!(j3 >= 1000000000000L)) {
            j3 *= 1000;
        }
        if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(c.f117352a)) {
            if (j3 >= 1000000000000L) {
                j3 /= 1000;
            }
        }
        e eVar = new e();
        eVar.u(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, j3);
        eVar.v("format", str);
        return syncToNativeMethod("dateFormatter", eVar, (Function1<? super e, Unit>) null);
    }
}
