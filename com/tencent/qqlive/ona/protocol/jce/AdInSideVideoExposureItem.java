package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInSideVideoExposureItem extends JceStruct {
    static AdReport cache_emptyReport;
    static ArrayList<AdReport> cache_exposureReportList;
    static ArrayList<AdReport> cache_originExposureReportList = new ArrayList<>();
    static AdReport cache_playbackReport;
    static ArrayList<AdRangeReport> cache_rangeReportList;
    public String adReportKey;
    public String adReportParams;
    public AdReport emptyReport;
    public ArrayList<AdReport> exposureReportList;
    public ArrayList<AdReport> originExposureReportList;
    public AdReport playbackReport;
    public ArrayList<AdRangeReport> rangeReportList;
    public long reportDelayTime;

    static {
        cache_originExposureReportList.add(new AdReport());
        cache_exposureReportList = new ArrayList<>();
        cache_exposureReportList.add(new AdReport());
        cache_emptyReport = new AdReport();
        cache_playbackReport = new AdReport();
        cache_rangeReportList = new ArrayList<>();
        cache_rangeReportList.add(new AdRangeReport());
    }

    public AdInSideVideoExposureItem() {
        this.originExposureReportList = null;
        this.exposureReportList = null;
        this.emptyReport = null;
        this.adReportKey = "";
        this.adReportParams = "";
        this.playbackReport = null;
        this.rangeReportList = null;
        this.reportDelayTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.originExposureReportList = (ArrayList) jceInputStream.read((JceInputStream) cache_originExposureReportList, 0, false);
        this.exposureReportList = (ArrayList) jceInputStream.read((JceInputStream) cache_exposureReportList, 1, false);
        this.emptyReport = (AdReport) jceInputStream.read((JceStruct) cache_emptyReport, 2, false);
        this.adReportKey = jceInputStream.readString(3, false);
        this.adReportParams = jceInputStream.readString(4, false);
        this.playbackReport = (AdReport) jceInputStream.read((JceStruct) cache_playbackReport, 5, false);
        this.rangeReportList = (ArrayList) jceInputStream.read((JceInputStream) cache_rangeReportList, 6, false);
        this.reportDelayTime = jceInputStream.read(this.reportDelayTime, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<AdReport> arrayList = this.originExposureReportList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        ArrayList<AdReport> arrayList2 = this.exposureReportList;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 1);
        }
        AdReport adReport = this.emptyReport;
        if (adReport != null) {
            jceOutputStream.write((JceStruct) adReport, 2);
        }
        String str = this.adReportKey;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.adReportParams;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        AdReport adReport2 = this.playbackReport;
        if (adReport2 != null) {
            jceOutputStream.write((JceStruct) adReport2, 5);
        }
        ArrayList<AdRangeReport> arrayList3 = this.rangeReportList;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 6);
        }
        jceOutputStream.write(this.reportDelayTime, 7);
    }

    public AdInSideVideoExposureItem(ArrayList<AdReport> arrayList, ArrayList<AdReport> arrayList2, AdReport adReport, String str, String str2, AdReport adReport2, ArrayList<AdRangeReport> arrayList3, long j3) {
        this.originExposureReportList = arrayList;
        this.exposureReportList = arrayList2;
        this.emptyReport = adReport;
        this.adReportKey = str;
        this.adReportParams = str2;
        this.playbackReport = adReport2;
        this.rangeReportList = arrayList3;
        this.reportDelayTime = j3;
    }
}
