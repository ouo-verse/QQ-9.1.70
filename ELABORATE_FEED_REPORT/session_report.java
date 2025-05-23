package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class session_report extends JceStruct {
    static ArrayList<feed_report_info> cache_vecFeedReportInfo = new ArrayList<>();
    public String strSession;
    public int uReqId;
    public ArrayList<feed_report_info> vecFeedReportInfo;

    static {
        cache_vecFeedReportInfo.add(new feed_report_info());
    }

    public session_report() {
        this.uReqId = 0;
        this.vecFeedReportInfo = null;
        this.strSession = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uReqId = jceInputStream.read(this.uReqId, 0, false);
        this.vecFeedReportInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecFeedReportInfo, 1, false);
        this.strSession = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uReqId, 0);
        ArrayList<feed_report_info> arrayList = this.vecFeedReportInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.strSession;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public session_report(int i3, ArrayList<feed_report_info> arrayList, String str) {
        this.uReqId = i3;
        this.vecFeedReportInfo = arrayList;
        this.strSession = str;
    }
}
