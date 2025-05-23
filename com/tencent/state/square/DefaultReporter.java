package com.tencent.state.square;

import android.util.Log;
import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\nH\u0016J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\nH\u0016J&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0016J^\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J<\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J6\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/DefaultReporter;", "Lcom/tencent/state/square/IReporter;", "()V", "reportEvent", "", "eventId", "", "obj", "", "businessParams", "", "reportToBeacon", "params", "setElementInfo", "view", "Landroid/view/View;", "elementId", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", "exposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "endExposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", IECDtReport.ACTION_IDENTIFIER, "isAsync", "", "fullExposure", "autoReportClick", "autoReportExpose", "setPageInfo", "target", "pageId", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultReporter implements IReporter {
    private static final String TAG = "DefaultReporter";

    @Override // com.tencent.state.square.IReporter
    public void reportEvent(@NotNull String eventId, @NotNull Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        Log.d(TAG, "setPageInfo eventId:" + eventId + " businessParams:" + businessParams);
    }

    @Override // com.tencent.state.square.IReporter
    public void reportToBeacon(@NotNull String eventId, @Nullable Map<String, String> params) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Log.d(TAG, "reportToDT eventId:" + eventId + " params:" + params);
    }

    @Override // com.tencent.state.square.IReporter
    public void setElementInfo(@NotNull View view, @NotNull String elementId, @NotNull Map<String, Object> businessParams, boolean autoReportClick, boolean autoReportExpose) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        Log.d(TAG, "setPageInfo elementId:" + elementId + " businessParams:" + businessParams);
    }

    @Override // com.tencent.state.square.IReporter
    public void setPageInfo(@NotNull Object target, @NotNull Object view, @NotNull String pageId, @Nullable Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Log.d(TAG, "setPageInfo pageID:" + pageId + " businessParams:" + businessParams);
    }

    @Override // com.tencent.state.square.IReporter
    public void reportEvent(@NotNull String eventId, @NotNull Object obj, @NotNull Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        Log.d(TAG, "reportEvent eventId:" + eventId + " businessParams:" + businessParams);
    }

    @Override // com.tencent.state.square.IReporter
    public void setElementInfo(@NotNull View view, @NotNull String elementId, @NotNull Map<String, Object> businessParams, @NotNull ClickPolicy clickPolicy, @NotNull ExposurePolicy exposurePolicy, @NotNull EndExposurePolicy endExposurePolicy, @Nullable String identifier, boolean isAsync, boolean fullExposure) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
        Intrinsics.checkNotNullParameter(endExposurePolicy, "endExposurePolicy");
        Log.d(TAG, "setPageInfo elementId:" + elementId + " businessParams:" + businessParams);
    }
}
