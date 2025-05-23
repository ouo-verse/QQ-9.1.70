package com.tencent.state.square;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\bH&J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\bH&J(\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH&Jd\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0017H&J@\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017H&J6\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/square/IReporter;", "", "reportEvent", "", "eventId", "", "obj", "businessParams", "", "reportToBeacon", "params", "setElementInfo", "view", "Landroid/view/View;", "elementId", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", "exposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "endExposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", IECDtReport.ACTION_IDENTIFIER, "isAsync", "", "fullExposure", "autoReportClick", "autoReportExpose", "setPageInfo", "target", "pageId", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface IReporter {
    void reportEvent(@NotNull String eventId, @NotNull Object obj, @NotNull Map<String, Object> businessParams);

    void reportEvent(@NotNull String eventId, @NotNull Map<String, Object> businessParams);

    void reportToBeacon(@NotNull String eventId, @Nullable Map<String, String> params);

    void setElementInfo(@NotNull View view, @NotNull String elementId, @NotNull Map<String, Object> businessParams, @NotNull ClickPolicy clickPolicy, @NotNull ExposurePolicy exposurePolicy, @NotNull EndExposurePolicy endExposurePolicy, @Nullable String identifier, boolean isAsync, boolean fullExposure);

    void setElementInfo(@NotNull View view, @NotNull String elementId, @NotNull Map<String, Object> businessParams, boolean autoReportClick, boolean autoReportExpose);

    void setPageInfo(@NotNull Object target, @NotNull Object view, @NotNull String pageId, @Nullable Map<String, Object> businessParams);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportToBeacon$default(IReporter iReporter, String str, Map map, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    map = null;
                }
                iReporter.reportToBeacon(str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportToBeacon");
        }

        public static /* synthetic */ void setElementInfo$default(IReporter iReporter, View view, String str, Map map, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                iReporter.setElementInfo(view, str, map, (i3 & 8) != 0 ? true : z16, (i3 & 16) != 0 ? true : z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setElementInfo");
        }

        public static /* synthetic */ void setElementInfo$default(IReporter iReporter, View view, String str, Map map, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, String str2, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                iReporter.setElementInfo(view, str, map, clickPolicy, exposurePolicy, endExposurePolicy, (i3 & 64) != 0 ? null : str2, (i3 & 128) != 0 ? false : z16, (i3 & 256) != 0 ? false : z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setElementInfo");
        }
    }
}
