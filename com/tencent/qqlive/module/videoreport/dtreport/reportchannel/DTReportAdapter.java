package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.common.IReporter;
import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTReportAdapter implements IReporter {
    private final IDTReport mDTReport;

    public DTReportAdapter(IDTReport iDTReport) {
        this.mDTReport = iDTReport;
    }

    @Override // com.tencent.qqlive.module.videoreport.common.IReporter
    public void report(ReportEvent reportEvent) {
        boolean z16;
        if (reportEvent.getType() == EventAgingType.REALTIME) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        if (TextUtils.isEmpty(reportEvent.getAppKey())) {
            this.mDTReport.dtEvent(reportEvent.getSource(), reportEvent.getKey(), reportEvent.getParams(), z17);
        } else {
            this.mDTReport.dtEvent(reportEvent.getSource(), reportEvent.getKey(), reportEvent.getParams(), z17, reportEvent.getAppKey());
        }
    }
}
