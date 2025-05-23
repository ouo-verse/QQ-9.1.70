package com.tencent.qqlive.module.videoreport.inner;

import com.tencent.qqlive.module.videoreport.common.IReporter;
import com.tencent.qqlive.module.videoreport.common.ReportEvent;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OldReporterAdapter implements IReporter {
    private final com.tencent.qqlive.module.videoreport.IReporter mOldReporter;

    public OldReporterAdapter(com.tencent.qqlive.module.videoreport.IReporter iReporter) {
        this.mOldReporter = iReporter;
    }

    @Override // com.tencent.qqlive.module.videoreport.common.IReporter
    public void report(ReportEvent reportEvent) {
        com.tencent.qqlive.module.videoreport.IReporter iReporter = this.mOldReporter;
        if (iReporter != null) {
            iReporter.report(reportEvent.getSource(), reportEvent.getKey(), reportEvent.getRawParams());
        }
    }
}
