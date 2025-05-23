package com.tencent.qq.minibox.proxy;

import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.minibox.proxy.ReportProxy;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0090\u0001\u0010\u0017\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qq/minibox/proxy/r;", "Lcom/tencent/minibox/proxy/ReportProxy;", "Lorg/json/JSONObject;", "reportJson", "", "target", "", "report", "", "appId", "actionType", "subActionType", "reserves", "reserves2", "reserves3", "reserves4", "reserves5", "reserves6", "reserves7", "reserves8", "scene", "via", "reportData", "reportToDC04239", "<init>", "()V", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class r implements ReportProxy {
    @Override // com.tencent.minibox.proxy.ReportProxy
    public void report(@Nullable JSONObject reportJson, int target) {
        if (QLog.isDevelopLevel()) {
            QLog.i("ReportProxyImpl", 4, "report:" + reportJson);
        }
        ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).report(reportJson, target);
    }

    @Override // com.tencent.minibox.proxy.ReportProxy
    public void reportToDC04239(@Nullable String appId, @NotNull String actionType, @Nullable String subActionType, @Nullable String reserves, @Nullable String reserves2, @Nullable String reserves3, @Nullable String reserves4, @Nullable String reserves5, @Nullable String reserves6, @Nullable String reserves7, @Nullable String reserves8, int scene, @Nullable String via, @Nullable String reportData) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniGameVirtual(appId, actionType, subActionType, "", reserves2, reserves8, String.valueOf(scene), via, reportData);
    }
}
