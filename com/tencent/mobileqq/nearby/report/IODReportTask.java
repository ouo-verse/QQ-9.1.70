package com.tencent.mobileqq.nearby.report;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IODReportTask extends QRouteApi {
    IODReportTask addKeyValue(String str, double d16);

    IODReportTask addKeyValue(String str, int i3);

    IODReportTask addKeyValue(String str, long j3);

    IODReportTask addKeyValue(String str, String str2);

    IODReportTask obj1(int i3);

    IODReportTask obj2(String str);

    IODReportTask obj3(int i3);

    void report();

    IODReportTask setAction(String str);

    IODReportTask setAnchor(long j3);

    IODReportTask setAnchorId(long j3);

    IODReportTask setBid(String str);

    IODReportTask setExtCol1(String str);

    IODReportTask setExtCol2(String str);

    IODReportTask setExtCol3(String str);

    IODReportTask setExtCol4(String str);

    IODReportTask setExtCol5(String str);

    IODReportTask setInstallSrc(String str);

    IODReportTask setIntCol1(int i3);

    IODReportTask setIntCol1(long j3);

    IODReportTask setIntCol2(int i3);

    IODReportTask setIntCol2(long j3);

    IODReportTask setModule(String str);

    IODReportTask setOperName(String str);

    IODReportTask setReferId(String str);

    IODReportTask setRes1(double d16);

    IODReportTask setRes1(String str);

    IODReportTask setRes2(double d16);

    IODReportTask setRes2(String str);

    IODReportTask setRes3(double d16);

    IODReportTask setRes3(String str);

    IODReportTask setRoomId(int i3);

    IODReportTask setSource(String str);

    IODReportTask setTDBankImpDate(String str);

    IODReportTask setTid(String str);

    IODReportTask setType(String str);

    IODReportTask setUin(String str);

    IODReportTask setUserId(String str);
}
