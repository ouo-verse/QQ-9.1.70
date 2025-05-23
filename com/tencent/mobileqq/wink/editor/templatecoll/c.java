package com.tencent.mobileqq.wink.editor.templatecoll;

import android.view.View;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a)\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Landroid/view/View;", "view", "", "elementId", "", BaseProfileQZoneComponent.KEY_IS_VIDEO, "", "a", "b", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/Boolean;)V", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {
    public static final void a(@NotNull View view, @NotNull String elementId, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(view, elementId);
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, "1");
        if (z16) {
            str = "video";
        } else {
            str = "pic";
        }
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_EDIT_VIDEO, str);
        VideoReport.setElementParams(view, params);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static final void b(@NotNull View view, @NotNull String elementId, @Nullable Boolean bool) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_eid", elementId);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, "1");
        if (bool != null) {
            if (bool.booleanValue()) {
                str = "video";
            } else {
                str = "pic";
            }
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_EDIT_VIDEO, str);
        }
        VideoReport.setElementId(view, elementId);
        VideoReport.reportEvent("ev_xsj_camera_action", view, params);
    }

    public static /* synthetic */ void c(View view, String str, Boolean bool, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bool = null;
        }
        b(view, str, bool);
    }
}
