package com.tencent.mobileqq.gamecenter.api;

import com.tencent.mobileqq.gamecenter.data.p;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J(\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/IGameCenterVideoReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/gamecenter/data/p;", "baseReportData", "", "reportPlayStart", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "reportPlayError", "reportVideoPrepared", "reportVideoBufferingStart", "reportVideoBufferingEnd", "reportVideoComplete", "reportVideoRelease", "", "url", "", "getHippyReportInterceptor", "", "checkIfReport", "checkIfDetectDropFrame", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameCenterVideoReportApi extends QRouteApi {
    boolean checkIfDetectDropFrame(@Nullable String url);

    boolean checkIfReport(@Nullable String url);

    @NotNull
    Object getHippyReportInterceptor(@Nullable String url);

    void reportPlayError(@NotNull p baseReportData, int module, int errorType, int errorCode);

    void reportPlayStart(@NotNull p baseReportData);

    void reportVideoBufferingEnd(@NotNull p baseReportData);

    void reportVideoBufferingStart(@NotNull p baseReportData);

    void reportVideoComplete(@NotNull p baseReportData);

    void reportVideoPrepared(@NotNull p baseReportData);

    void reportVideoRelease(@NotNull p baseReportData);
}
