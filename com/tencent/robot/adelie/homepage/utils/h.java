package com.tencent.robot.adelie.homepage.utils;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012JX\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/h;", "", "Landroid/view/View;", "view", "", "elementID", "", "businessParams", IECDtReport.ACTION_IDENTIFIER, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", IECDtReport.ACTION_EXPOSE_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "endExposePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class h {

    /* renamed from: a */
    @NotNull
    public static final h f366661a = new h();

    h() {
    }

    public static /* synthetic */ void b(h hVar, View view, String str, Map map, String str2, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, ClickPolicy clickPolicy, int i3, Object obj) {
        Map map2;
        String str3;
        ExposurePolicy exposurePolicy2;
        EndExposurePolicy endExposurePolicy2;
        ClickPolicy clickPolicy2;
        if ((i3 & 4) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        if ((i3 & 8) != 0) {
            str3 = null;
        } else {
            str3 = str2;
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
        if ((i3 & 64) != 0) {
            clickPolicy2 = ClickPolicy.REPORT_NONE;
        } else {
            clickPolicy2 = clickPolicy;
        }
        hVar.a(view, str, map2, str3, exposurePolicy2, endExposurePolicy2, clickPolicy2);
    }

    public final void a(@NotNull View view, @NotNull String elementID, @Nullable Map<String, ? extends Object> businessParams, @Nullable String r56, @NotNull ExposurePolicy r65, @NotNull EndExposurePolicy endExposePolicy, @NotNull ClickPolicy r85) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(r65, "exposePolicy");
        Intrinsics.checkNotNullParameter(endExposePolicy, "endExposePolicy");
        Intrinsics.checkNotNullParameter(r85, "clickPolicy");
        VideoReport.setElementId(view, elementID);
        VideoReport.setElementExposePolicy(view, r65);
        VideoReport.setElementEndExposePolicy(view, endExposePolicy);
        VideoReport.setElementClickPolicy(view, r85);
        if (r56 != null) {
            VideoReport.setElementReuseIdentifier(view, r56);
        }
        VideoReport.setElementParams(view, businessParams);
    }
}
