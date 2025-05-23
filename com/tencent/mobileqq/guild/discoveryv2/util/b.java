package com.tencent.mobileqq.guild.discoveryv2.util;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017Ju\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/util/b;", "", "Landroid/view/View;", "view", "", "id", IECDtReport.ACTION_IDENTIFIER, "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "endExposurePolicy", "", "params", "", "exposureMinRate", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "", "a", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;Ljava/util/Map;Ljava/lang/Double;Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;)V", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f217789a = new b();

    b() {
    }

    @JvmStatic
    public static final void a(@NotNull View view, @NotNull String id5, @NotNull String identifier, @NotNull ClickPolicy clickPolicy, @NotNull ExposurePolicy exposurePolicy, @NotNull EndExposurePolicy endExposurePolicy, @Nullable Map<String, ? extends Object> params, @Nullable Double exposureMinRate, @Nullable IDynamicParams dynamicParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
        Intrinsics.checkNotNullParameter(endExposurePolicy, "endExposurePolicy");
        VideoReport.setElementId(view, id5);
        VideoReport.setElementReuseIdentifier(view, identifier + "#" + view.hashCode());
        VideoReport.setEventType(view, EventAgingType.REALTIME);
        if (params != null) {
            VideoReport.setElementParams(view, params);
        }
        if (dynamicParams != null) {
            VideoReport.setEventDynamicParams(view, dynamicParams);
        }
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
        VideoReport.setElementExposureMinTime(view, 0L);
        if (exposureMinRate != null) {
            exposureMinRate.doubleValue();
            VideoReport.setElementExposureMinRate(view, exposureMinRate.doubleValue());
        }
    }

    public static /* synthetic */ void b(View view, String str, String str2, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, Map map, Double d16, IDynamicParams iDynamicParams, int i3, Object obj) {
        ClickPolicy clickPolicy2;
        ExposurePolicy exposurePolicy2;
        EndExposurePolicy endExposurePolicy2;
        Double d17;
        IDynamicParams iDynamicParams2;
        if ((i3 & 8) != 0) {
            clickPolicy2 = ClickPolicy.REPORT_NONE;
        } else {
            clickPolicy2 = clickPolicy;
        }
        if ((i3 & 16) != 0) {
            exposurePolicy2 = ExposurePolicy.REPORT_NONE;
        } else {
            exposurePolicy2 = exposurePolicy;
        }
        if ((i3 & 32) != 0) {
            endExposurePolicy2 = EndExposurePolicy.REPORT_NONE;
        } else {
            endExposurePolicy2 = endExposurePolicy;
        }
        if ((i3 & 128) != 0) {
            d17 = null;
        } else {
            d17 = d16;
        }
        if ((i3 & 256) != 0) {
            iDynamicParams2 = null;
        } else {
            iDynamicParams2 = iDynamicParams;
        }
        a(view, str, str2, clickPolicy2, exposurePolicy2, endExposurePolicy2, map, d17, iDynamicParams2);
    }
}
