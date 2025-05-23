package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.vas.api.IVas04586Report;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0084\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/Vas04586ReportImpl;", "Lcom/tencent/mobileqq/vas/api/IVas04586Report;", "()V", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "", "appid", "", "pageId", "moduleId", "subModuleId", "itemId", "subItemId", "itemType", "actionId", "", "actionValue", "actionAttr", "ruleId", "busiInfo", "positionId", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class Vas04586ReportImpl implements IVas04586Report {
    @Override // com.tencent.mobileqq.vas.api.IVas04586Report
    public void reportAction(@Nullable String appid, @Nullable String pageId, @Nullable String moduleId, @Nullable String subModuleId, @Nullable String itemId, @Nullable String subItemId, @Nullable String itemType, int actionId, int actionValue, int actionAttr, @Nullable String ruleId, @Nullable String busiInfo, @Nullable String positionId) {
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(appid, pageId, moduleId, subModuleId, itemId, subItemId, itemType, actionId, actionValue, actionAttr, ruleId, busiInfo, positionId);
    }
}
