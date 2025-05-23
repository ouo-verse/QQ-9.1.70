package if1;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001ao\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Landroid/view/View;", "", "elementId", "reusedId", "", "", "params", "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "endExposurePolicy", "", "exposureMinRate", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "", "a", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;Ljava/lang/Double;Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;)V", "qqguild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    public static final void a(@NotNull View view, @NotNull String elementId, @NotNull String reusedId, @NotNull Map<String, ? extends Object> params, @NotNull ExposurePolicy exposurePolicy, @NotNull ClickPolicy clickPolicy, @NotNull EndExposurePolicy endExposurePolicy, @Nullable Double d16, @Nullable IDynamicParams iDynamicParams) {
        boolean isBlank;
        Map mutableMap;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(reusedId, "reusedId");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        Intrinsics.checkNotNullParameter(endExposurePolicy, "endExposurePolicy");
        VideoReport.setElementId(view, elementId);
        isBlank = StringsKt__StringsJVMKt.isBlank(reusedId);
        if (!isBlank) {
            VideoReport.setElementReuseIdentifier(view, reusedId);
        }
        if (!params.isEmpty()) {
            mutableMap = MapsKt__MapsKt.toMutableMap(params);
            VideoReport.setElementParams(view, mutableMap);
        }
        VideoReport.setEventDynamicParams(view, iDynamicParams);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
        if (d16 != null) {
            d16.doubleValue();
            VideoReport.setElementExposureMinRate(view, d16.doubleValue());
        }
    }

    public static /* synthetic */ void b(View view, String str, String str2, Map map, ExposurePolicy exposurePolicy, ClickPolicy clickPolicy, EndExposurePolicy endExposurePolicy, Double d16, IDynamicParams iDynamicParams, int i3, Object obj) {
        String str3;
        Map map2;
        ExposurePolicy exposurePolicy2;
        ClickPolicy clickPolicy2;
        EndExposurePolicy endExposurePolicy2;
        Double d17;
        if ((i3 & 2) != 0) {
            str3 = "";
        } else {
            str3 = str2;
        }
        if ((i3 & 4) != 0) {
            map2 = MapsKt__MapsKt.emptyMap();
        } else {
            map2 = map;
        }
        if ((i3 & 8) != 0) {
            exposurePolicy2 = ExposurePolicy.REPORT_ALL;
        } else {
            exposurePolicy2 = exposurePolicy;
        }
        if ((i3 & 16) != 0) {
            clickPolicy2 = ClickPolicy.REPORT_ALL;
        } else {
            clickPolicy2 = clickPolicy;
        }
        if ((i3 & 32) != 0) {
            endExposurePolicy2 = EndExposurePolicy.REPORT_NONE;
        } else {
            endExposurePolicy2 = endExposurePolicy;
        }
        IDynamicParams iDynamicParams2 = null;
        if ((i3 & 64) != 0) {
            d17 = null;
        } else {
            d17 = d16;
        }
        if ((i3 & 128) == 0) {
            iDynamicParams2 = iDynamicParams;
        }
        a(view, str, str3, map2, exposurePolicy2, clickPolicy2, endExposurePolicy2, d17, iDynamicParams2);
    }
}
