package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQRScanReportApi extends QRouteApi {
    void doFrame();

    boolean isBaseTestSwitchOn();

    void markScanConsume(int i3, int i16);

    void markScanEnd(int i3);

    void markScanStart();

    void onAIOMiniCodeResultReport(boolean z16, boolean z17);

    void onAIOScanRecogTypeReport(int i3);

    void onDetectFirstCost(int i3, int i16);

    void onDetectInitCost(int i3, int i16);

    void onDetectInitInternalCost(int i3, int i16);

    void onDetectSupportEasyReport(int i3, int i16);

    void onDetectSupportReport(int i3, int i16);

    void onSoCoverReport(boolean z16, int i3, String str);

    long readLong(String str, long j3);

    void setSaveDetectImage(boolean z16);

    void stopFrame();

    void writeLong(String str, long j3);
}
