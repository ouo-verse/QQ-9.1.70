package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MobileQbossReportExceptionReq extends JceStruct {
    static ArrayList<ReportExceptionInfo> cache_vecRepInfo = new ArrayList<>();
    public long uiUin;
    public ArrayList<ReportExceptionInfo> vecRepInfo;

    static {
        cache_vecRepInfo.add(new ReportExceptionInfo());
    }

    public MobileQbossReportExceptionReq() {
        this.uiUin = 0L;
        this.vecRepInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiUin = jceInputStream.read(this.uiUin, 0, false);
        this.vecRepInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecRepInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiUin, 0);
        ArrayList<ReportExceptionInfo> arrayList = this.vecRepInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public MobileQbossReportExceptionReq(long j3, ArrayList<ReportExceptionInfo> arrayList) {
        this.uiUin = j3;
        this.vecRepInfo = arrayList;
    }
}
