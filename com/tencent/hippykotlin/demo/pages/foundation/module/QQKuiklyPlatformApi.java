package com.tencent.hippykotlin.demo.pages.foundation.module;

import c45.a;
import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.apache.httpcore.message.TokenParser;
import x35.b;

/* loaded from: classes31.dex */
public final class QQKuiklyPlatformApi extends Module {
    public static final Companion Companion = new Companion();
    public final Lazy psKeyRequestingMap$delegate;

    /* loaded from: classes31.dex */
    public static final class Companion {
        public static void closePage$default() {
            Companion companion = QQKuiklyPlatformApi.Companion;
            ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).closePage(false);
        }

        public static void openPage$default(String str, boolean z16, int i3) {
            Companion companion = QQKuiklyPlatformApi.Companion;
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).openPage(str, z16, null);
        }

        public static void sendPbRequest$default(final BasePbRequest basePbRequest, String str, final Function1 function1, int i3) {
            Companion companion = QQKuiklyPlatformApi.Companion;
            if ((i3 & 2) != 0) {
                str = "";
            }
            QQKuiklyPlatformApi qQKuiklyPlatformApi = (QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi");
            qQKuiklyPlatformApi.getClass();
            qQKuiklyPlatformApi.syncToNativeMethod("sendPbRequest", new Object[]{basePbRequest.getCmd(), i.d(basePbRequest.getRequest()), str, 0}, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi$sendPbRequest$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    Object orNull;
                    Object orNull2;
                    Object orNull3;
                    e eVar = null;
                    if (obj instanceof Object[]) {
                        Object[] objArr = (Object[]) obj;
                        orNull = ArraysKt___ArraysKt.getOrNull(objArr, 0);
                        Number number = orNull instanceof Number ? (Number) orNull : null;
                        int intValue = number != null ? number.intValue() : -20003;
                        orNull2 = ArraysKt___ArraysKt.getOrNull(objArr, 1);
                        String str2 = orNull2 instanceof String ? (String) orNull2 : null;
                        if (str2 == null) {
                            str2 = "";
                        }
                        orNull3 = ArraysKt___ArraysKt.getOrNull(objArr, 2);
                        byte[] bArr = orNull3 instanceof byte[] ? (byte[]) orNull3 : null;
                        if (bArr == null) {
                            function1.invoke(new PbResponse<>(false, intValue, AgreementConsentViewKt$$ExternalSyntheticOutline0.m("fail decode pb bytes, msg: ", str2), null));
                        } else if (intValue == 0) {
                            Function1<PbResponse<e>, Unit> function12 = function1;
                            BasePbRequest<Object, Object> basePbRequest2 = basePbRequest;
                            basePbRequest2.getClass();
                            try {
                                eVar = basePbRequest2.decodeResponse(bArr);
                            } catch (Throwable unused) {
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("parse pb error: cmd: ");
                                m3.append(basePbRequest2.getCmd());
                                kLog.e("BasePbRequest", m3.toString());
                            }
                            function12.invoke(new PbResponse<>(true, intValue, str2, eVar));
                        } else {
                            function1.invoke(new PbResponse<>(false, intValue, str2, null));
                        }
                    } else {
                        function1.invoke(new PbResponse<>(false, -20002, "pb result is not array", null));
                    }
                    return Unit.INSTANCE;
                }
            });
        }

        public final QQNetworkType getNetworkType() {
            return ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).getNetworkType();
        }

        public final String getUid(String str) {
            return ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).toNative(false, "getUid", str, null, true).toString();
        }

        public final String getUin() {
            return ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).getUin();
        }

        public final void qqToast(String str, QToastMode qToastMode) {
            ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast(str, qToastMode);
        }

        public final <Req extends e, Rsp extends e, BaseOIDBReq extends BaseOIDBRequest<Req, Rsp>> void sendOIDBRequest(final BaseOIDBReq baseoidbreq, boolean z16, final Function1<? super OIDBResponse<Rsp>, Unit> function1) {
            c cVar = c.f117352a;
            QQKuiklyPlatformApi qQKuiklyPlatformApi = (QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi");
            qQKuiklyPlatformApi.getClass();
            qQKuiklyPlatformApi.syncToNativeMethod("sendPbRequest", new Object[]{baseoidbreq.getCmd(), i.d(new b(Integer.valueOf(baseoidbreq.getOidbCmd()), Integer.valueOf(baseoidbreq.getOidbServiceType()), 0, new a(i.d(baseoidbreq.getRequest())), cVar.g().getPageData().getPlatform() + TokenParser.SP + cVar.g().getPageData().getAppVersion(), 33)), "", Integer.valueOf(z16 ? 1 : 0)}, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi$sendOIDBRequest$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    Object orNull;
                    Object orNull2;
                    Object orNull3;
                    byte[] bArr;
                    if (obj instanceof Object[]) {
                        Object[] objArr = (Object[]) obj;
                        orNull = ArraysKt___ArraysKt.getOrNull(objArr, 0);
                        Number number = orNull instanceof Number ? (Number) orNull : null;
                        int intValue = number != null ? number.intValue() : -20003;
                        orNull2 = ArraysKt___ArraysKt.getOrNull(objArr, 1);
                        String str = orNull2 instanceof String ? (String) orNull2 : null;
                        if (str == null) {
                            str = "";
                        }
                        orNull3 = ArraysKt___ArraysKt.getOrNull(objArr, 2);
                        byte[] bArr2 = orNull3 instanceof byte[] ? (byte[]) orNull3 : null;
                        if (bArr2 == null) {
                            Function1<OIDBResponse<e>, Unit> function12 = function1;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fail decode oidb ");
                            m3.append(baseoidbreq.getCmd());
                            m3.append(" bytes, msg: ");
                            m3.append(str);
                            function12.invoke(new OIDBResponse<>(false, intValue, m3.toString(), null));
                        } else if (intValue == 0) {
                            BaseOIDBRequest<Object, Object> baseOIDBRequest = baseoidbreq;
                            baseOIDBRequest.getClass();
                            b bVar = (b) i.b(new b(null, null, null, null, null, 127), bArr2);
                            a aVar = bVar.f447168i;
                            Pair pair = new Pair(bVar, (aVar == null || (bArr = aVar.f30291a) == null) ? null : baseOIDBRequest.decodeResponse(bArr));
                            Integer num = ((b) pair.getFirst()).f447167h;
                            if (num != null && num.intValue() == 0) {
                                function1.invoke(new OIDBResponse<>(true, 0, "", (e) pair.getSecond()));
                            } else {
                                Function1<OIDBResponse<e>, Unit> function13 = function1;
                                Integer num2 = ((b) pair.getFirst()).f447167h;
                                int intValue2 = num2 != null ? num2.intValue() : -1;
                                String str2 = ((b) pair.getFirst()).f447169m;
                                function13.invoke(new OIDBResponse<>(false, intValue2, str2 != null ? str2 : "", null));
                            }
                        } else {
                            function1.invoke(new OIDBResponse<>(false, intValue, str, null));
                        }
                    } else {
                        Function1<OIDBResponse<e>, Unit> function14 = function1;
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("oidb ");
                        m16.append(baseoidbreq.getCmd());
                        m16.append(" result is not array");
                        function14.invoke(new OIDBResponse<>(false, -20002, m16.toString(), null));
                    }
                    return Unit.INSTANCE;
                }
            });
        }

        public final void setEdgePopWidth(float f16) {
            ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).setEdgePopWidth(f16);
        }
    }

    /* loaded from: classes31.dex */
    public enum QQNetworkType {
        NOT_REACHABLE,
        WIFI,
        X2G,
        X3G,
        X4G,
        X5G
    }

    public QQKuiklyPlatformApi() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Map<String, ArrayList<Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, ? extends Unit>>>>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi$psKeyRequestingMap$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ArrayList<Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, ? extends Unit>>> invoke() {
                return new LinkedHashMap();
            }
        });
        this.psKeyRequestingMap$delegate = lazy;
    }

    public final void clearImageMemoryCache() {
        callNativeMethod("clearImageMemoryCache", null);
    }

    public final DeviceInfo getDeviceInfo() {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar;
        String syncCallNativeMethod = syncCallNativeMethod("getDeviceInfo", null, null);
        try {
            eVar = new com.tencent.kuikly.core.nvi.serialization.json.e(syncCallNativeMethod);
        } catch (Throwable unused) {
            KLog.INSTANCE.e("QQKuiklyPlatformApi", "getDeviceInfo, error string: " + syncCallNativeMethod);
            eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        }
        return new DeviceInfo(eVar.p("systemName"), eVar.p("systemVersion"), eVar.p("model"), eVar.p("fingerprint"), eVar.p("incremental"), eVar.p("macAddress"), eVar.p(MobileInfoUtil.IMSI), eVar.p(TVKLiveRequestBuilder.RequestParamKey.QIMEI36), eVar.p("qimei36"), eVar.p("totalMemory"), eVar.p("availableMemory"), eVar.p("cpuType"), eVar.j("cpuNum"), eVar.j("isGrayOrAppstore"), eVar.p("msfImei"), eVar.p("msf_identifier"), eVar.p("idfa"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000c. Please report as an issue. */
    public final QQNetworkType getNetworkType() {
        String syncCallNativeMethod = syncCallNativeMethod("getNetworkType", null, null);
        switch (syncCallNativeMethod.hashCode()) {
            case 48:
                if (syncCallNativeMethod.equals("0")) {
                    return QQNetworkType.NOT_REACHABLE;
                }
                return QQNetworkType.X5G;
            case 49:
                if (syncCallNativeMethod.equals("1")) {
                    return QQNetworkType.WIFI;
                }
                return QQNetworkType.X5G;
            case 50:
                if (syncCallNativeMethod.equals("2")) {
                    return QQNetworkType.X2G;
                }
                return QQNetworkType.X5G;
            case 51:
                if (syncCallNativeMethod.equals("3")) {
                    return QQNetworkType.X3G;
                }
                return QQNetworkType.X5G;
            case 52:
                if (syncCallNativeMethod.equals("4")) {
                    return QQNetworkType.X4G;
                }
                return QQNetworkType.X5G;
            case 53:
                if (syncCallNativeMethod.equals("5")) {
                    return QQNetworkType.X5G;
                }
                return QQNetworkType.X5G;
            default:
                return QQNetworkType.X5G;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.util.ArrayList] */
    public final void getPSkey(String str, Function1 function1) {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(str);
        m3.append(d.b(false));
        m3.append("");
        String sb5 = m3.toString();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r36 = ((Map) this.psKeyRequestingMap$delegate.getValue()).get(sb5);
        objectRef.element = r36;
        if (r36 == 0) {
            objectRef.element = new ArrayList();
            ((Map) this.psKeyRequestingMap$delegate.getValue()).put(sb5, objectRef.element);
        }
        if (!((Collection) objectRef.element).isEmpty()) {
            ((ArrayList) objectRef.element).add(function1);
            return;
        }
        ((ArrayList) objectRef.element).add(function1);
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("domain", str);
        eVar.t("ignoreCache", d.b(false));
        syncCallNativeMethod("getPSkey", eVar, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi$getPSkey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar2) {
                List list;
                com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = eVar2;
                list = CollectionsKt___CollectionsKt.toList(objectRef.element);
                objectRef.element.clear();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(eVar3);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final String getUin() {
        return syncCallNativeMethod("getUin", null, null);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "QQKuiklyPlatformApi";
    }

    public final void qqToast(String str, QToastMode qToastMode) {
        if (QQUtils.INSTANCE.compare("9.1.20") < 0) {
            ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast(str, qToastMode);
            return;
        }
        com.tencent.kuikly.core.nvi.serialization.json.e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("content", str);
        m3.t("mode", qToastMode.value);
        callNativeMethod("qqToast", m3);
    }

    public final void setEdgePopWidth(float f16) {
        if (c.f117352a.g().getPageData().n().k("buildVersion", 0) >= 2) {
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            eVar.v("width", Float.valueOf(f16));
            Unit unit = Unit.INSTANCE;
            callNativeMethod("setEdgePopWidth", eVar);
        }
    }

    public final void closePage(boolean z16) {
        callNativeMethod("closePage", z16 ? RoleCardKt$$ExternalSyntheticOutline0.m("handleAsTaskRoot", 1) : null);
    }

    public final void openPage(String str, boolean z16, com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
        if (eVar != null) {
            str = QQComposeViewExtCreator$$ExternalSyntheticOutline0.m(str, "&user_data=", ((com.tencent.kuikly.core.module.d) c.f117352a.g().acquireModule("KRCodecModule")).b(eVar.toString()));
        }
        com.tencent.kuikly.core.nvi.serialization.json.e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("url", str);
        m3.t("closeCurPage", d.b(z16));
        callNativeMethod(IndividuationPlugin.Method_OpenPage, m3);
    }

    public final String syncCallNativeMethod(String str, com.tencent.kuikly.core.nvi.serialization.json.e eVar, Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit> function1) {
        return toNative(false, str, eVar != null ? eVar.toString() : null, function1, true).toString();
    }

    public final void callNativeMethod(String str, com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
        toNative(false, str, eVar != null ? eVar.toString() : null, null, false);
    }

    public static /* synthetic */ void openPage$default(QQKuiklyPlatformApi qQKuiklyPlatformApi, String str, boolean z16, int i3) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        qQKuiklyPlatformApi.openPage(str, z16, null);
    }
}
