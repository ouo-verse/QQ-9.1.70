package com.tencent.mobileqq.vas.social.config;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010)J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J&\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0016J<\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J6\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J^\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000fH\u0016R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/s;", "Lcom/tencent/state/square/IReporter;", "", "eventId", "", "obj", "", "businessParams", "", "reportEvent", "params", "reportToBeacon", "Landroid/view/View;", "view", "elementId", "", "autoReportClick", "autoReportExpose", "setElementInfo", "target", "pageId", "setPageInfo", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "endExposurePolicy", IECDtReport.ACTION_IDENTIFIER, "isAsync", "fullExposure", "a", "Ljava/lang/String;", "getAppKey", "()Ljava/lang/String;", com.heytap.mcssdk.a.a.f36102l, "Lid3/d;", "b", "Lid3/d;", "reportHelper", "<init>", "(Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class s implements IReporter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String appKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final id3.d reportHelper;

    public s(String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        this.appKey = appKey;
        this.reportHelper = new id3.d(appKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(s this$0, Object target, Object view, String pageId, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(target, "$target");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(pageId, "$pageId");
        this$0.reportHelper.j(target, view, pageId, map);
    }

    @Override // com.tencent.state.square.IReporter
    public void reportEvent(String eventId, Object obj, Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reportHelper.c(eventId, obj, businessParams);
    }

    @Override // com.tencent.state.square.IReporter
    public void reportToBeacon(String eventId, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        t74.r.d("0AND0YAG6R40RLM6", eventId, params);
    }

    @Override // com.tencent.state.square.IReporter
    public void setElementInfo(View view, String elementId, Map<String, Object> businessParams, boolean autoReportClick, boolean autoReportExpose) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        id3.d.i(this.reportHelper, view, elementId, businessParams, autoReportClick, autoReportExpose, null, false, false, 224, null);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.state.square.IReporter
    public void setPageInfo(final Object target, final Object view, final String pageId, final Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if ((target instanceof Fragment) && (view instanceof View)) {
            View view2 = (View) view;
            if (!ViewCompatUtils.isAttachedToWindow(view2)) {
                view2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.social.config.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.b(s.this, target, view, pageId, businessParams);
                    }
                });
                return;
            }
        }
        this.reportHelper.j(target, view, pageId, businessParams);
    }

    @Override // com.tencent.state.square.IReporter
    public void reportEvent(String eventId, Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reportHelper.d(eventId, businessParams);
    }

    public /* synthetic */ s(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? SquareReportConst.APP_KEY : str);
    }

    @Override // com.tencent.state.square.IReporter
    public void setElementInfo(View view, String elementId, Map<String, Object> businessParams, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, String identifier, boolean isAsync, boolean fullExposure) {
        s sVar;
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
        Intrinsics.checkNotNullParameter(endExposurePolicy, "endExposurePolicy");
        boolean z17 = clickPolicy == ClickPolicy.REPORT_ALL;
        if (exposurePolicy != ExposurePolicy.REPORT_NONE) {
            sVar = this;
            z16 = true;
        } else {
            sVar = this;
            z16 = false;
        }
        sVar.reportHelper.g(view, elementId, businessParams, z17, z16, identifier, isAsync, fullExposure);
    }
}
