package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdActionReport extends JceStruct {
    static AdReport cache_clickReport = new AdReport();
    static AdReport cache_effectReport = new AdReport();
    static AdReport cache_feedBackReport = new AdReport();
    public String adReportKey;
    public String adReportParams;
    public AdReport clickReport;
    public AdReport effectReport;
    public AdReport feedBackReport;

    public AdActionReport() {
        this.clickReport = null;
        this.effectReport = null;
        this.feedBackReport = null;
        this.adReportKey = "";
        this.adReportParams = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.clickReport = (AdReport) jceInputStream.read((JceStruct) cache_clickReport, 0, false);
        this.effectReport = (AdReport) jceInputStream.read((JceStruct) cache_effectReport, 1, false);
        this.feedBackReport = (AdReport) jceInputStream.read((JceStruct) cache_feedBackReport, 2, false);
        this.adReportKey = jceInputStream.readString(3, false);
        this.adReportParams = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AdReport adReport = this.clickReport;
        if (adReport != null) {
            jceOutputStream.write((JceStruct) adReport, 0);
        }
        AdReport adReport2 = this.effectReport;
        if (adReport2 != null) {
            jceOutputStream.write((JceStruct) adReport2, 1);
        }
        AdReport adReport3 = this.feedBackReport;
        if (adReport3 != null) {
            jceOutputStream.write((JceStruct) adReport3, 2);
        }
        String str = this.adReportKey;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.adReportParams;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public AdActionReport(AdReport adReport, AdReport adReport2, AdReport adReport3, String str, String str2) {
        this.clickReport = adReport;
        this.effectReport = adReport2;
        this.feedBackReport = adReport3;
        this.adReportKey = str;
        this.adReportParams = str2;
    }
}
