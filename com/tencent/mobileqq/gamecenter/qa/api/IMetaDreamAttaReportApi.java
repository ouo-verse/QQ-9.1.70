package com.tencent.mobileqq.gamecenter.qa.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001JL\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/api/IMetaDreamAttaReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "report", "", "operId", "", "operType", "pageId", "moduleId", "pageName", "moduleName", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IMetaDreamAttaReportApi extends QRouteApi {
    void report(@NotNull String operId, @NotNull String operType, @NotNull String pageId, @NotNull String moduleId, @NotNull String pageName, @NotNull String moduleName, @NotNull Map<String, ? extends Object> reportParams);
}
