package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IDataReportMgr extends QRouteApi {
    Map<String, String> getCurrentRoomReportInfo();
}
