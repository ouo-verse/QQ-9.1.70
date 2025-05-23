package com.tencent.hippy.qq.api;

import com.tencent.hippy.qq.obj.HippyEngineReportData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyReportCache extends QRouteApi {
    void clearAllReportData();

    void clearReportData(@NotNull String str);

    HippyEngineReportData getReportData(@NotNull String str);

    void saveReportData(@NotNull String str, HippyEngineReportData hippyEngineReportData);
}
