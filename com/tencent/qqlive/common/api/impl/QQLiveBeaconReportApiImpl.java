package com.tencent.qqlive.common.api.impl;

import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qqlive.common.api.IQQLiveBeaconReportApi;
import ft3.c;
import ft3.d;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QQLiveBeaconReportApiImpl implements IQQLiveBeaconReportApi {
    @Override // com.tencent.qqlive.common.api.IQQLiveBeaconReportApi
    public void init() {
        QQBeaconReport.start();
    }

    @Override // com.tencent.qqlive.common.api.IQQLiveBeaconReportApi
    public c newReportTask() {
        return new d();
    }
}
