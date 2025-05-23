package com.tencent.mobileqq.wink.report;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016JZ\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ6\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJ.\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/report/a;", "", "Landroid/view/View;", "view", "", "eid", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", IECDtReport.ACTION_IDENTIFIER, "", "elementParams", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "", "c", "evenId", "pgId", "a", "e", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a */
    @NotNull
    public static final a f326259a = new a();

    a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(a aVar, String str, String str2, String str3, Map map, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = null;
        }
        aVar.a(str, str2, str3, map);
    }

    public static /* synthetic */ void d(a aVar, View view, String str, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy, String str2, Map map, IDynamicParams iDynamicParams, int i3, Object obj) {
        ClickPolicy clickPolicy2;
        ExposurePolicy exposurePolicy2;
        String str3;
        Map map2;
        IDynamicParams iDynamicParams2;
        if ((i3 & 4) != 0) {
            clickPolicy2 = ClickPolicy.REPORT_ALL;
        } else {
            clickPolicy2 = clickPolicy;
        }
        if ((i3 & 8) != 0) {
            exposurePolicy2 = ExposurePolicy.REPORT_ALL;
        } else {
            exposurePolicy2 = exposurePolicy;
        }
        if ((i3 & 16) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i3 & 32) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        if ((i3 & 64) != 0) {
            iDynamicParams2 = null;
        } else {
            iDynamicParams2 = iDynamicParams;
        }
        aVar.c(view, str, clickPolicy2, exposurePolicy2, str3, map2, iDynamicParams2);
    }

    public final void a(@NotNull String eid, @NotNull String evenId, @NotNull String pgId, @Nullable Map<String, ? extends Object> elementParams) {
        Intrinsics.checkNotNullParameter(eid, "eid");
        Intrinsics.checkNotNullParameter(evenId, "evenId");
        Intrinsics.checkNotNullParameter(pgId, "pgId");
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        if (elementParams != null) {
            map.putAll(elementParams);
        }
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_eid", eid);
        map.put("dt_eid", eid);
        map.put("xsj_custom_pgid", pgId);
        map.put("dt_pgid", pgId);
        VideoReport.reportEvent(evenId, map);
    }

    public final void c(@NotNull View view, @NotNull String eid, @NotNull ClickPolicy r46, @NotNull ExposurePolicy exposurePolicy, @Nullable String r65, @Nullable Map<String, String> elementParams, @Nullable IDynamicParams dynamicParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eid, "eid");
        Intrinsics.checkNotNullParameter(r46, "clickPolicy");
        Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
        VideoReport.setElementId(view, eid);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (elementParams != null) {
            buildElementParams.putAll(elementParams);
        }
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setEventDynamicParams(view, dynamicParams);
        VideoReport.setElementClickPolicy(view, r46);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementReuseIdentifier(view, r65);
    }

    public final void e(@NotNull Object view, @NotNull String eid, @Nullable Map<String, ? extends Object> elementParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eid, "eid");
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (elementParams != null) {
            buildElementParams.putAll(elementParams);
        }
        VideoReport.setElementId(view, eid);
        VideoReport.reportEvent("dt_clck", view, elementParams);
    }
}
