package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0084\u0001\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVas04586Report;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "", "appid", "", "pageId", "moduleId", "subModuleId", "itemId", "subItemId", "itemType", "actionId", "", "actionValue", "actionAttr", "ruleId", "busiInfo", "positionId", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVas04586Report extends QRouteApi {
    void reportAction(@Nullable String appid, @Nullable String pageId, @Nullable String moduleId, @Nullable String subModuleId, @Nullable String itemId, @Nullable String subItemId, @Nullable String itemType, int actionId, int actionValue, int actionAttr, @Nullable String ruleId, @Nullable String busiInfo, @Nullable String positionId);
}
