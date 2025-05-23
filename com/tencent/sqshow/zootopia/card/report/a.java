package com.tencent.sqshow.zootopia.card.report;

import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.e;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaCardGroupData;
import com.tencent.sqshow.zootopia.data.ZootopiaTabConfigData;
import id3.d;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pu4.g;
import pv4.s;
import pv4.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ|\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\rj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001`\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013Jf\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\rj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001`\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0007R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/report/a;", "", "Landroid/view/View;", "view", "", "cardPos", "elementPos", "", "elementType", "Lcom/tencent/sqshow/zootopia/data/c;", "cardFullData", "Lpv4/s;", "sceneIndexModuleDetail", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extParams", "elementId", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "", "autoReportExpose", "", "c", "a", "Lid3/d;", "Lid3/d;", "dtReportHelper", "<init>", "()V", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private final d dtReportHelper = new d(null, 1, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0002Jj\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102$\b\u0002\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0012j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u0013JD\u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0002R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0014\u0010 \u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/report/a$a;", "", "", "schemeUrl", "e", "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "defaultType", "f", "", "cardPos", "elementPos", "elementType", "Lcom/tencent/sqshow/zootopia/data/c;", "cardFullData", "jumpSchemeUrl", "Lpv4/s;", "sceneIndexModuleDetail", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extParams", "", "a", "pageId", "elementId", "Lorg/json/JSONObject;", "c", "CARD_ELEMENT_TYPE_BANNER", "Ljava/lang/String;", "CARD_ELEMENT_TYPE_BUTTON", "CARD_ELEMENT_TYPE_ICON", "CARD_ELEMENT_TYPE_VIDEO", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.card.report.a$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String e(String schemeUrl) {
            return ((ISchemeApi) QRoute.api(ISchemeApi.class)).convertSchemeToJsonForReport(schemeUrl);
        }

        public final Map<String, Object> a(int cardPos, int elementPos, String elementType, ZootopiaCardData cardFullData, String jumpSchemeUrl, s sceneIndexModuleDetail, HashMap<String, Object> extParams) {
            String str;
            String tabConfig;
            Intrinsics.checkNotNullParameter(elementType, "elementType");
            Intrinsics.checkNotNullParameter(cardFullData, "cardFullData");
            Intrinsics.checkNotNullParameter(jumpSchemeUrl, "jumpSchemeUrl");
            Intrinsics.checkNotNullParameter(extParams, "extParams");
            HashMap hashMap = new HashMap();
            hashMap.putAll(extParams);
            hashMap.put("zplan_card_type", Integer.valueOf(cardFullData.getType()));
            hashMap.put("zplan_card_id", Integer.valueOf(cardFullData.getCardId()));
            ZootopiaCardGroupData groupData = cardFullData.getGroupData();
            hashMap.put("zplan_group_id", Integer.valueOf(groupData != null ? groupData.getGroupId() : 0));
            hashMap.put("zplan_card_pos", Integer.valueOf(cardPos));
            hashMap.put("zplan_elem_pos", Integer.valueOf(elementPos));
            hashMap.put("zplan_element_type", elementType);
            hashMap.put("scheme_info", e(jumpSchemeUrl));
            String str2 = "";
            if (sceneIndexModuleDetail != null) {
                u uVar = sceneIndexModuleDetail.f427683d;
                String str3 = uVar != null ? uVar.f427702a : null;
                if (str3 == null) {
                    str3 = "";
                }
                hashMap.put("zplan_element_name", str3);
                hashMap.put("zplan_element_id", Integer.valueOf(sceneIndexModuleDetail.f427690k));
            }
            HashMap hashMap2 = new HashMap();
            ZootopiaTabConfigData parentListTabConfig = cardFullData.getParentListTabConfig();
            if (parentListTabConfig == null || (str = parentListTabConfig.getTabConfig()) == null) {
                str = "";
            }
            hashMap2.put("scene_abtest", str);
            ZootopiaTabConfigData tabConfig2 = cardFullData.getTabConfig();
            if (tabConfig2 != null && (tabConfig = tabConfig2.getTabConfig()) != null) {
                str2 = tabConfig;
            }
            hashMap2.put("module_abtest", str2);
            hashMap.put("abtest_info", hashMap2);
            return hashMap;
        }

        public final JSONObject c(int cardPos, int elementPos, String elementType, ZootopiaCardData cardFullData, s sceneIndexModuleDetail, String pageId, String elementId) {
            String str;
            String tabConfig;
            Intrinsics.checkNotNullParameter(elementType, "elementType");
            Intrinsics.checkNotNullParameter(cardFullData, "cardFullData");
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pgid", pageId);
            jSONObject.put("eid", elementId);
            jSONObject.put("card_id", String.valueOf(cardFullData.getCardId()));
            jSONObject.put("card_type", String.valueOf(cardFullData.getType()));
            jSONObject.put("card_pos", String.valueOf(cardPos));
            if (sceneIndexModuleDetail != null) {
                jSONObject.put("element_id", String.valueOf(sceneIndexModuleDetail.f427690k));
            }
            jSONObject.put("element_type", elementType);
            jSONObject.put("elem_pos", String.valueOf(elementPos));
            JSONObject jSONObject2 = new JSONObject();
            ZootopiaTabConfigData parentListTabConfig = cardFullData.getParentListTabConfig();
            String str2 = "";
            if (parentListTabConfig == null || (str = parentListTabConfig.getTabConfig()) == null) {
                str = "";
            }
            jSONObject2.put("scene_abtest", str);
            ZootopiaTabConfigData tabConfig2 = cardFullData.getTabConfig();
            if (tabConfig2 != null && (tabConfig = tabConfig2.getTabConfig()) != null) {
                str2 = tabConfig;
            }
            jSONObject2.put("module_abtest", str2);
            jSONObject.put("abtest_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("zplan_ref_info", jSONObject);
            return jSONObject3;
        }

        public final String f(g r26, String defaultType) {
            Intrinsics.checkNotNullParameter(defaultType, "defaultType");
            return e.f328302a.a(r26) ? "3" : defaultType;
        }

        Companion() {
        }

        public static /* synthetic */ String g(Companion companion, g gVar, String str, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = "1";
            }
            return companion.f(gVar, str);
        }
    }

    public final void a(View view, int cardPos, int elementPos, String elementType, ZootopiaCardData cardFullData, s sceneIndexModuleDetail, HashMap<String, Object> extParams, String elementId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        Intrinsics.checkNotNullParameter(cardFullData, "cardFullData");
        Intrinsics.checkNotNullParameter(sceneIndexModuleDetail, "sceneIndexModuleDetail");
        Intrinsics.checkNotNullParameter(extParams, "extParams");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Companion companion = INSTANCE;
        String str = sceneIndexModuleDetail.f427682c;
        Intrinsics.checkNotNullExpressionValue(str, "sceneIndexModuleDetail.jumpUrl");
        d.i(this.dtReportHelper, view, elementId, companion.a(cardPos, elementPos, elementType, cardFullData, str, sceneIndexModuleDetail, extParams), false, false, null, false, false, 224, null);
        this.dtReportHelper.c("clck", view, new LinkedHashMap());
    }

    public static /* synthetic */ void b(a aVar, View view, int i3, int i16, String str, ZootopiaCardData zootopiaCardData, s sVar, HashMap hashMap, String str2, int i17, Object obj) {
        aVar.a(view, i3, i16, str, zootopiaCardData, sVar, (i17 & 64) != 0 ? new HashMap() : hashMap, (i17 & 128) != 0 ? "em_zplan_element" : str2);
    }

    public static /* synthetic */ void d(a aVar, View view, int i3, int i16, String str, ZootopiaCardData zootopiaCardData, s sVar, HashMap hashMap, String str2, IDynamicParams iDynamicParams, boolean z16, int i17, Object obj) {
        aVar.c(view, i3, i16, str, zootopiaCardData, sVar, (i17 & 64) != 0 ? new HashMap() : hashMap, (i17 & 128) != 0 ? "em_zplan_element" : str2, (i17 & 256) != 0 ? null : iDynamicParams, (i17 & 512) != 0 ? true : z16);
    }

    public final void c(View view, int cardPos, int elementPos, String elementType, ZootopiaCardData cardFullData, s sceneIndexModuleDetail, HashMap<String, Object> extParams, String elementId, IDynamicParams dynamicParams, boolean autoReportExpose) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        Intrinsics.checkNotNullParameter(cardFullData, "cardFullData");
        Intrinsics.checkNotNullParameter(sceneIndexModuleDetail, "sceneIndexModuleDetail");
        Intrinsics.checkNotNullParameter(extParams, "extParams");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Companion companion = INSTANCE;
        String str = sceneIndexModuleDetail.f427682c;
        Intrinsics.checkNotNullExpressionValue(str, "sceneIndexModuleDetail.jumpUrl");
        Map<String, Object> a16 = companion.a(cardPos, elementPos, elementType, cardFullData, str, sceneIndexModuleDetail, extParams);
        d.i(this.dtReportHelper, view, elementId, a16, false, autoReportExpose, null, false, false, 224, null);
        if (dynamicParams != null) {
            this.dtReportHelper.b(view, dynamicParams);
        }
        if (autoReportExpose) {
            return;
        }
        this.dtReportHelper.c("imp", view, a16);
    }
}
