package com.tencent.qqnt.robot.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/robot/api/IRobotShareDebugApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getQRCodeGenerateFailSwitch", "", "setQRCodeGenerateFailSwitch", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRobotShareDebugApi extends QRouteApi {
    boolean getQRCodeGenerateFailSwitch();

    void setQRCodeGenerateFailSwitch(boolean r16);
}
