package com.tencent.ecommerce.base.report.api;

import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u00a2\u0001\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0005H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/base/report/api/IECMobileReportManager;", "", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "", "appId", "", "pageId", "moduleId", "subModuleId", "itemId", "subItemId", "itemType", "actionId", "", "actionValue", "actionAttr", "ruleId", "busiInfo", "positionId", "traceDetail", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECMobileReportManager {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ void a(IECMobileReportManager iECMobileReportManager, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, int i16, int i17, String str8, String str9, String str10, String str11, int i18, Object obj) {
            if (obj == null) {
                iECMobileReportManager.reportAction(str, str2, str3, (i18 & 8) != 0 ? "" : str4, (i18 & 16) != 0 ? "" : str5, (i18 & 32) != 0 ? "" : str6, (i18 & 64) != 0 ? "" : str7, (i18 & 128) != 0 ? 0 : i3, (i18 & 256) != 0 ? 0 : i16, (i18 & 512) != 0 ? 0 : i17, (i18 & 1024) != 0 ? "" : str8, (i18 & 2048) != 0 ? "" : str9, (i18 & 4096) != 0 ? "" : str10, (i18 & 8192) != 0 ? "" : str11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportAction");
        }
    }

    void reportAction(@Nullable String appId, @Nullable String pageId, @Nullable String moduleId, @Nullable String subModuleId, @Nullable String itemId, @Nullable String subItemId, @Nullable String itemType, int actionId, int actionValue, int actionAttr, @Nullable String ruleId, @Nullable String busiInfo, @Nullable String positionId, @NotNull String traceDetail);
}
