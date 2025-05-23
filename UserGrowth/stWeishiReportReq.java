package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stWeishiReportReq extends JceStruct {
    static ArrayList<stReportItem> cache_report_list = new ArrayList<>();
    public ArrayList<stReportItem> report_list;

    static {
        cache_report_list.add(new stReportItem());
    }

    public stWeishiReportReq() {
        this.report_list = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.report_list = (ArrayList) jceInputStream.read((JceInputStream) cache_report_list, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<stReportItem> arrayList = this.report_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public stWeishiReportReq(ArrayList<stReportItem> arrayList) {
        this.report_list = arrayList;
    }
}
