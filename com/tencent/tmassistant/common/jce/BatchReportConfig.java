package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class BatchReportConfig extends JceStruct {
    public long batchReportInterval;
    public int batchReportMaxCount;
    public int reportRetryCount;

    public BatchReportConfig() {
        this.batchReportMaxCount = 0;
        this.batchReportInterval = 0L;
        this.reportRetryCount = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.batchReportMaxCount = jceInputStream.read(this.batchReportMaxCount, 0, true);
        this.batchReportInterval = jceInputStream.read(this.batchReportInterval, 1, true);
        this.reportRetryCount = jceInputStream.read(this.reportRetryCount, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.batchReportMaxCount, 0);
        jceOutputStream.write(this.batchReportInterval, 1);
        jceOutputStream.write(this.reportRetryCount, 2);
    }

    public BatchReportConfig(int i3, long j3, int i16) {
        this.batchReportMaxCount = i3;
        this.batchReportInterval = j3;
        this.reportRetryCount = i16;
    }
}
