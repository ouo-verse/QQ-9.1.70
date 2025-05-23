package com.tencent.mobileqq.search.report;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J,\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0005JB\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00022\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\fJ:\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00022\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\fJj\u0010\u001e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001cJ\u0016\u0010 \u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0002J`\u0010(\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010#\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&J2\u0010,\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00022\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010$J\u001e\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010$2\b\u0010.\u001a\u0004\u0018\u00010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/search/report/a;", "", "", "eventID", "obj", "", "businessParams", "", "e", "target", "view", ISchemeApi.KEY_PAGE_ID, "Lcom/tencent/qqlive/module/videoreport/constants/PageReportPolicy;", "policy", "j", "targetView", "k", "Landroid/view/View;", "elementID", "", "isAsync", IECDtReport.ACTION_IDENTIFIER, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", IECDtReport.ACTION_EXPOSE_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "endExposePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "", "rate", h.F, "id", "g", "resueId", "eid", "endExposurePolicy", "", "params", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "a", "eventId", "reportEId", "elementParam", "d", "Lcom/tencent/qqlive/module/videoreport/page/PageInfo;", "pageInfo", "c", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f283716a = new a();

    a() {
    }

    public static /* synthetic */ void b(a aVar, String str, String str2, View view, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, ClickPolicy clickPolicy, Map map, IDynamicParams iDynamicParams, int i3, Object obj) {
        ExposurePolicy exposurePolicy2;
        EndExposurePolicy endExposurePolicy2;
        ClickPolicy clickPolicy2;
        Map map2;
        IDynamicParams iDynamicParams2;
        Map emptyMap;
        if ((i3 & 8) != 0) {
            exposurePolicy2 = ExposurePolicy.REPORT_ALL;
        } else {
            exposurePolicy2 = exposurePolicy;
        }
        if ((i3 & 16) != 0) {
            endExposurePolicy2 = EndExposurePolicy.REPORT_NONE;
        } else {
            endExposurePolicy2 = endExposurePolicy;
        }
        if ((i3 & 32) != 0) {
            clickPolicy2 = ClickPolicy.REPORT_ALL;
        } else {
            clickPolicy2 = clickPolicy;
        }
        if ((i3 & 64) != 0) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            map2 = emptyMap;
        } else {
            map2 = map;
        }
        if ((i3 & 128) != 0) {
            iDynamicParams2 = null;
        } else {
            iDynamicParams2 = iDynamicParams;
        }
        aVar.a(str, str2, view, exposurePolicy2, endExposurePolicy2, clickPolicy2, map2, iDynamicParams2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(a aVar, String str, Object obj, Map map, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            map = new LinkedHashMap();
        }
        aVar.e(str, obj, map);
    }

    public static /* synthetic */ void i(a aVar, View view, String str, Map map, boolean z16, String str2, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, ClickPolicy clickPolicy, double d16, int i3, Object obj) {
        Map map2;
        boolean z17;
        String str3;
        ExposurePolicy exposurePolicy2;
        EndExposurePolicy endExposurePolicy2;
        ClickPolicy clickPolicy2;
        double d17;
        if ((i3 & 4) != 0) {
            map2 = new LinkedHashMap();
        } else {
            map2 = map;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        if ((i3 & 16) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i3 & 32) != 0) {
            exposurePolicy2 = ExposurePolicy.REPORT_ALL;
        } else {
            exposurePolicy2 = exposurePolicy;
        }
        if ((i3 & 64) != 0) {
            endExposurePolicy2 = EndExposurePolicy.REPORT_ALL;
        } else {
            endExposurePolicy2 = endExposurePolicy;
        }
        if ((i3 & 128) != 0) {
            clickPolicy2 = ClickPolicy.REPORT_ALL;
        } else {
            clickPolicy2 = clickPolicy;
        }
        if ((i3 & 256) != 0) {
            d17 = 0.5d;
        } else {
            d17 = d16;
        }
        aVar.h(view, str, map2, z17, str3, exposurePolicy2, endExposurePolicy2, clickPolicy2, d17);
    }

    public final void a(@NotNull String resueId, @NotNull String eid, @NotNull View view, @NotNull ExposurePolicy exposePolicy, @NotNull EndExposurePolicy endExposurePolicy, @NotNull ClickPolicy clickPolicy, @NotNull Map<String, ? extends Object> params, @Nullable IDynamicParams dynamicParams) {
        boolean z16;
        Intrinsics.checkNotNullParameter(resueId, "resueId");
        Intrinsics.checkNotNullParameter(eid, "eid");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(exposePolicy, "exposePolicy");
        Intrinsics.checkNotNullParameter(endExposurePolicy, "endExposurePolicy");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        Intrinsics.checkNotNullParameter(params, "params");
        VideoReport.setElementId(view, eid);
        if (resueId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            VideoReport.setElementReuseIdentifier(view, resueId);
        }
        VideoReport.setElementExposePolicy(view, exposePolicy);
        VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementParams(view, params);
        if (dynamicParams != null) {
            VideoReport.setEventDynamicParams(view, dynamicParams);
        }
    }

    @NotNull
    public final Map<String, Object> c(@Nullable PageInfo pageInfo) {
        Map<String, Object> emptyMap;
        Object page;
        Map<String, ?> pageParams;
        if (pageInfo == null || (page = pageInfo.getPage()) == null || (pageParams = DataRWProxy.getPageParams(page)) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        return pageParams;
    }

    public final void d(@NotNull String eventId, @NotNull View view, @NotNull String reportEId, @NotNull Map<String, ? extends Object> elementParam) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(reportEId, "reportEId");
        Intrinsics.checkNotNullParameter(elementParam, "elementParam");
        QLog.i("SearchDTReportHelper", 4, "reportEvent eventID:" + eventId + ", obj:" + view + ", reportEId:" + reportEId);
        VideoReport.setElementId(view, reportEId);
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.putAll(elementParam);
        VideoReport.setElementParams(view, hashMap);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent(eventId, view, elementParam);
    }

    public final synchronized void e(@NotNull String eventID, @NotNull Object obj, @NotNull Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        QLog.i("SearchDTReportHelper", 4, "reportEvent eventID:" + eventID + ", obj:" + obj + ", businessParams:" + businessParams);
        try {
            VideoReport.reportEvent(eventID, obj, businessParams);
        } catch (Exception e16) {
            QLog.e("SearchDTReportHelper", 1, "reportEvent throw e: " + e16.getMessage());
        }
    }

    public final synchronized void g(@NotNull Object target, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(id5, "id");
        VideoReport.setElementId(target, id5);
    }

    public final synchronized void h(@NotNull View view, @NotNull String elementID, @NotNull Map<String, Object> businessParams, boolean isAsync, @Nullable String identifier, @NotNull ExposurePolicy exposePolicy, @NotNull EndExposurePolicy endExposePolicy, @NotNull ClickPolicy clickPolicy, double rate) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        Intrinsics.checkNotNullParameter(exposePolicy, "exposePolicy");
        Intrinsics.checkNotNullParameter(endExposePolicy, "endExposePolicy");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        VideoReport.setElementId(view, elementID);
        VideoReport.setElementExposePolicy(view, exposePolicy);
        VideoReport.setElementEndExposePolicy(view, endExposePolicy);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementParams(view, businessParams);
        if (identifier != null) {
            VideoReport.setElementReuseIdentifier(view, identifier);
        }
        if (isAsync) {
            VideoReport.traverseExposure();
        }
        VideoReport.setElementExposureMinRate(view, rate);
    }

    public final synchronized void j(@NotNull Object target, @NotNull Object view, @NotNull String pageID, @Nullable Map<String, Object> businessParams, @NotNull PageReportPolicy policy) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        Intrinsics.checkNotNullParameter(policy, "policy");
        if ((target instanceof Activity) || (target instanceof Fragment) || (target instanceof View) || (target instanceof Dialog)) {
            if (target instanceof Fragment) {
                VideoReport.addToDetectionWhitelist(((Fragment) target).getActivity());
            }
            if (target instanceof Activity) {
                VideoReport.addToDetectionWhitelist((Activity) target);
            }
        }
        k(view, pageID, businessParams, policy);
    }

    public final synchronized void k(@NotNull Object targetView, @NotNull String pageID, @Nullable Map<String, Object> businessParams, @NotNull PageReportPolicy policy) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        Intrinsics.checkNotNullParameter(policy, "policy");
        if (!(targetView instanceof Activity) && !(targetView instanceof Fragment) && !(targetView instanceof View) && !(targetView instanceof Dialog)) {
            QLog.e("SearchDTReportHelper", 1, "setPageInfo targetView \u4e0d\u662fActivity Fragment\u6216\u8005View");
        }
        if (targetView instanceof Fragment) {
            VideoReport.addToDetectionWhitelist(((Fragment) targetView).getActivity());
        }
        if (targetView instanceof Activity) {
            VideoReport.addToDetectionWhitelist((Activity) targetView);
        }
        if (businessParams == null) {
            businessParams = new LinkedHashMap<>();
        }
        PageParams pageParams = new PageParams((Map<String, ?>) businessParams);
        VideoReport.setPageId(targetView, pageID);
        VideoReport.setPageReportPolicy(targetView, policy);
        VideoReport.setPageParams(targetView, pageParams);
    }
}
