package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH&J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u0014\u001a\u00020\u0007H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyForTest;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isQrEnable", "isTestEnabled", "isTestSwitchOn", "isSwitchOn", "", "setTestSwitchStatus", "", "resId", "getCacheVersion", "", "version", "cacheQRResult", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/j;", DownloadInfo.spKey_Config, "cacheSpecificConfig", "getCacheSpecificConfig", "removeSpecificConfig", QCircleLpReportDc05507.KEY_CLEAR, "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQKuiklyForTest extends QRouteApi {
    void cacheQRResult(@NotNull String resId, long version);

    void cacheSpecificConfig(@NotNull String resId, @NotNull QQKuiklyBundleSpecificConfig config);

    void clear();

    @Nullable
    QQKuiklyBundleSpecificConfig getCacheSpecificConfig(@NotNull String resId);

    @NotNull
    String getCacheVersion(@NotNull String resId);

    boolean isQrEnable();

    boolean isTestEnabled();

    boolean isTestSwitchOn();

    void removeSpecificConfig(@NotNull String resId);

    void setTestSwitchStatus(boolean isSwitchOn);
}
