package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l35.a;
import n35.ac;
import n35.ak;
import n35.k;
import n35.o;
import n35.v;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BDHService {
    public static final BDHService INSTANCE = new BDHService();
    public static final Map<String, String> cacheMap = new LinkedHashMap();
    public static Boolean isUseHttps;

    static {
        new LinkedHashMap();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>] */
    public final void reqDownPhoto(final v vVar, final Function1<? super String, Unit> function1) {
        e eVar;
        boolean g16;
        if (vVar == null) {
            function1.invoke("");
            return;
        }
        String str = (String) cacheMap.get(vVar.f418268e);
        if (str != null) {
            function1.invoke(str);
            return;
        }
        if (isUseHttps == null) {
            String stringFromQQCommonConfig = QQNearbyModule.Companion.getInstance().getStringFromQQCommonConfig("105701", "{}");
            if (stringFromQQCommonConfig.length() == 0) {
                g16 = false;
            } else {
                try {
                    eVar = new e(stringFromQQCommonConfig);
                } catch (Exception unused) {
                    eVar = new e();
                }
                g16 = eVar.g("enabledUrlUseHttps", false);
            }
            isUseHttps = Boolean.valueOf(g16);
        }
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(new DownloadPicReq(vVar), false, new Function1<OIDBResponse<ak>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.BDHService$reqDownPhoto$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0127, code lost:
            
                if (r11 == null) goto L28;
             */
            /* JADX WARN: Type inference failed for: r0v5, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(OIDBResponse<ak> oIDBResponse) {
                String str2;
                o oVar;
                List list;
                String m3;
                Object firstOrNull;
                OIDBResponse<ak> oIDBResponse2 = oIDBResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("kuikly reqDownPhoto, ");
                m16.append(oIDBResponse2.code);
                m16.append(", ");
                m16.append(oIDBResponse2.f114186msg);
                m16.append(", fileUUid: ");
                m16.append(v.this.f418268e);
                m16.append(", isUseHttps: ");
                Boolean bool = BDHService.isUseHttps;
                Boolean bool2 = Boolean.TRUE;
                m16.append(Intrinsics.areEqual(bool, bool2));
                kLog.i("BDHService", m16.toString());
                if (!oIDBResponse2.success) {
                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("req download pic error: ");
                    m17.append(oIDBResponse2.code);
                    m17.append(", fileUUid: ");
                    m17.append(v.this.f418268e);
                    kLog.e("BDHService", m17.toString());
                }
                ak akVar = oIDBResponse2.rsp;
                if (akVar != null && (oVar = akVar.f418166f) != null) {
                    boolean areEqual = Intrinsics.areEqual(BDHService.isUseHttps, bool2);
                    k kVar = oVar.f418248f;
                    if (kVar == null) {
                        list = CollectionsKt__CollectionsKt.emptyList();
                    } else {
                        ac acVar = kVar.f418241m;
                        if (acVar == null) {
                            list = CollectionsKt__CollectionsKt.emptyList();
                        } else {
                            String str3 = acVar.f418136e;
                            List<a> list2 = kVar.f418239h;
                            ArrayList arrayList = new ArrayList();
                            for (a aVar : list2) {
                                int i3 = aVar.f413781d;
                                String str4 = (i3 & 255) + "." + ((i3 >> 8) & 255) + "." + ((i3 >> 16) & 255) + "." + ((i3 >> 24) & 255);
                                if (areEqual) {
                                    StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("https://");
                                    m18.append(kVar.f418236d);
                                    m18.append(':');
                                    m18.append(kVar.f418238f);
                                    m18.append(kVar.f418237e);
                                    m3 = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(m18, oVar.f418246d, str3);
                                } else {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("http://");
                                    sb5.append(str4);
                                    sb5.append(':');
                                    sb5.append(aVar.f413782e);
                                    sb5.append(kVar.f418237e);
                                    m3 = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb5, oVar.f418246d, str3);
                                }
                                if (m3 != null) {
                                    arrayList.add(m3);
                                }
                            }
                            list = arrayList;
                        }
                    }
                    if (list != null) {
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                        str2 = (String) firstOrNull;
                    }
                }
                str2 = "";
                if (str2.length() > 0) {
                    ?? r06 = BDHService.cacheMap;
                    if (r06.size() >= 200) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = r06.entrySet().iterator();
                        while (it.hasNext()) {
                            arrayList2.add(((Map.Entry) it.next()).getKey());
                            if (arrayList2.size() >= 50) {
                                break;
                            }
                        }
                        Iterator it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            BDHService.cacheMap.remove((String) it5.next());
                        }
                    }
                    BDHService.cacheMap.put(v.this.f418268e, str2);
                }
                function1.invoke(str2);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>] */
    public final String getUrlFromCache(v vVar) {
        if (vVar == null) {
            return null;
        }
        return (String) cacheMap.get(vVar.f418268e);
    }
}
