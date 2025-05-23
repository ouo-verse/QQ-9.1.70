package com.tencent.mobileqq.guild.util;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018JL\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007JT\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fJ6\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/util/bt;", "", "Landroid/view/View;", "view", "", DTConstants.TAG.ELEMENT, "", "elementParams", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "endExposurePolicy", "", "c", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "e", "elementId", "event", "map", "g", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bt f235484a = new bt();

    bt() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(@NotNull View view, @NotNull String element) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(element, "element");
        d(view, element, null, null, null, null, 60, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void b(@NotNull View view, @NotNull String element, @NotNull Map<String, ? extends Object> elementParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(elementParams, "elementParams");
        d(view, element, elementParams, null, null, null, 56, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void c(@NotNull View view, @NotNull String element, @NotNull Map<String, ? extends Object> elementParams, @NotNull ClickPolicy clickPolicy, @NotNull ExposurePolicy exposurePolicy, @NotNull EndExposurePolicy endExposurePolicy) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(elementParams, "elementParams");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
        Intrinsics.checkNotNullParameter(endExposurePolicy, "endExposurePolicy");
        VideoReport.setElementId(view, element);
        VideoReport.setElementParams(view, elementParams);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
    }

    public static /* synthetic */ void d(View view, String str, Map map, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = Collections.emptyMap();
            Intrinsics.checkNotNullExpressionValue(map, "emptyMap()");
        }
        Map map2 = map;
        if ((i3 & 8) != 0) {
            clickPolicy = ClickPolicy.REPORT_ALL;
        }
        ClickPolicy clickPolicy2 = clickPolicy;
        if ((i3 & 16) != 0) {
            exposurePolicy = ExposurePolicy.REPORT_ALL;
        }
        ExposurePolicy exposurePolicy2 = exposurePolicy;
        if ((i3 & 32) != 0) {
            endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        }
        c(view, str, map2, clickPolicy2, exposurePolicy2, endExposurePolicy);
    }

    public static /* synthetic */ void f(bt btVar, View view, String str, Map map, IDynamicParams iDynamicParams, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, int i3, Object obj) {
        Map map2;
        ClickPolicy clickPolicy2;
        ExposurePolicy exposurePolicy2;
        EndExposurePolicy endExposurePolicy2;
        if ((i3 & 4) != 0) {
            Map emptyMap = Collections.emptyMap();
            Intrinsics.checkNotNullExpressionValue(emptyMap, "emptyMap()");
            map2 = emptyMap;
        } else {
            map2 = map;
        }
        if ((i3 & 16) != 0) {
            clickPolicy2 = ClickPolicy.REPORT_ALL;
        } else {
            clickPolicy2 = clickPolicy;
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
        btVar.e(view, str, map2, iDynamicParams, clickPolicy2, exposurePolicy2, endExposurePolicy2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(bt btVar, View view, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = new HashMap();
        }
        btVar.g(view, str, str2, map);
    }

    public final void e(@NotNull View view, @NotNull String element, @NotNull Map<String, ? extends Object> elementParams, @Nullable IDynamicParams dynamicParams, @NotNull ClickPolicy clickPolicy, @NotNull ExposurePolicy exposurePolicy, @NotNull EndExposurePolicy endExposurePolicy) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(elementParams, "elementParams");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
        Intrinsics.checkNotNullParameter(endExposurePolicy, "endExposurePolicy");
        VideoReport.setElementId(view, element);
        VideoReport.setElementParams(view, elementParams);
        if (dynamicParams != null) {
            VideoReport.setEventDynamicParams(view, dynamicParams);
        }
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
    }

    public final void g(@NotNull View view, @NotNull String elementId, @NotNull String event, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(map, "map");
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent(event, view, map);
        VideoReport.setElementId(view, "");
    }
}
