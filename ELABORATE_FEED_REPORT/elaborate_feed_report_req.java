package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class elaborate_feed_report_req extends JceStruct {
    static ArrayList<session_report> cache_vecSessionReport = new ArrayList<>();
    public ArrayList<session_report> vecSessionReport;

    static {
        cache_vecSessionReport.add(new session_report());
    }

    public elaborate_feed_report_req() {
        this.vecSessionReport = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecSessionReport = (ArrayList) jceInputStream.read((JceInputStream) cache_vecSessionReport, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<session_report> arrayList = this.vecSessionReport;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public elaborate_feed_report_req(ArrayList<session_report> arrayList) {
        this.vecSessionReport = arrayList;
    }
}
