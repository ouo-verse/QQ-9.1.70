package com.tencent.mobileqq.troop.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopMsgDTReportApi extends QRouteApi {
    void reportLongTapMsg(String str, String str2, String str3, long j3);

    void reportTapMsgLinkJump(String str, String str2, String str3, String str4, long j3);
}
