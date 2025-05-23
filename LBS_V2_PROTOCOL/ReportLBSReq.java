package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReportLBSReq extends JceStruct {
    static ReportLBSInfo cache_stReportInfo = new ReportLBSInfo();
    public ReportLBSInfo stReportInfo;

    public ReportLBSReq() {
        this.stReportInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stReportInfo = (ReportLBSInfo) jceInputStream.read((JceStruct) cache_stReportInfo, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ReportLBSInfo reportLBSInfo = this.stReportInfo;
        if (reportLBSInfo != null) {
            jceOutputStream.write((JceStruct) reportLBSInfo, 0);
        }
    }

    public ReportLBSReq(ReportLBSInfo reportLBSInfo) {
        this.stReportInfo = reportLBSInfo;
    }
}
