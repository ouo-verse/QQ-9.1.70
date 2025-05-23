package com.tencent.robot.discover.adapter.section;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J2\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/discover/adapter/section/e;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lk34/a;", "Landroid/app/Activity;", "p", "Landroid/view/View;", "view", "", "id", "", "", "elementParams", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "Landroid/app/Activity;", "mActivity", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class e extends Section<k34.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity mActivity;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void r(e eVar, View view, String str, Map map, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                map = null;
            }
            eVar.q(view, str, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setElementReport");
    }

    @Nullable
    public final Activity p() {
        if (this.mActivity == null) {
            this.mActivity = u64.g.f438512a.f(this.mRootView);
        }
        return this.mActivity;
    }

    public final void q(@Nullable View view, @Nullable String id5, @Nullable Map<String, ? extends Object> elementParams) {
        VideoReport.setElementId(view, id5);
        if (elementParams != null) {
            VideoReport.setElementParams(view, elementParams);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }
}
