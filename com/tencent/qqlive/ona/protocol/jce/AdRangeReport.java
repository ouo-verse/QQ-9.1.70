package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdRangeReport extends JceStruct {
    static AdReport cache_adReport = new AdReport();
    public AdReport adReport;
    public int reportBegin;
    public int reportEnd;

    public AdRangeReport() {
        this.reportBegin = 0;
        this.reportEnd = 0;
        this.adReport = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reportBegin = jceInputStream.read(this.reportBegin, 0, false);
        this.reportEnd = jceInputStream.read(this.reportEnd, 1, false);
        this.adReport = (AdReport) jceInputStream.read((JceStruct) cache_adReport, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reportBegin, 0);
        jceOutputStream.write(this.reportEnd, 1);
        AdReport adReport = this.adReport;
        if (adReport != null) {
            jceOutputStream.write((JceStruct) adReport, 2);
        }
    }

    public AdRangeReport(int i3, int i16, AdReport adReport) {
        this.reportBegin = i3;
        this.reportEnd = i16;
        this.adReport = adReport;
    }
}
