package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class comm_qzone_report_req extends JceStruct {
    static Map<Integer, byte[]> cache_mapQzoneReportReq = new HashMap();
    public Map<Integer, byte[]> mapQzoneReportReq;

    static {
        cache_mapQzoneReportReq.put(0, new byte[]{0});
    }

    public comm_qzone_report_req() {
        this.mapQzoneReportReq = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mapQzoneReportReq = (Map) jceInputStream.read((JceInputStream) cache_mapQzoneReportReq, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, byte[]> map = this.mapQzoneReportReq;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public comm_qzone_report_req(Map<Integer, byte[]> map) {
        this.mapQzoneReportReq = map;
    }
}
