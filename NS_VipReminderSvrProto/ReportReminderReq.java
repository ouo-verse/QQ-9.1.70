package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReportReminderReq extends JceStruct {
    public int iReportType;
    public int iZoneId;
    public String sReportValue;
    public long uiUin;

    public ReportReminderReq() {
        this.iReportType = 1;
        this.sReportValue = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiUin = jceInputStream.read(this.uiUin, 0, true);
        this.iZoneId = jceInputStream.read(this.iZoneId, 1, true);
        this.iReportType = jceInputStream.read(this.iReportType, 2, true);
        this.sReportValue = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiUin, 0);
        jceOutputStream.write(this.iZoneId, 1);
        jceOutputStream.write(this.iReportType, 2);
        jceOutputStream.write(this.sReportValue, 3);
    }

    public ReportReminderReq(long j3, int i3, int i16, String str) {
        this.uiUin = j3;
        this.iZoneId = i3;
        this.iReportType = i16;
        this.sReportValue = str;
    }
}
