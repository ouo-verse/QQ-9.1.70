package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.h;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\b\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qrscan/api/IScanCacheApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/qrscan/h;", "data", "", "saveTempCameraData", "", "getTempCameraDataPath", QCircleLpReportDc05507.KEY_CLEAR, "qqqrscan-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IScanCacheApi extends QRouteApi {
    void clear();

    @Nullable
    String getTempCameraDataPath();

    void saveTempCameraData(@Nullable h data);
}
