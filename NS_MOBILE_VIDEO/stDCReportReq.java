package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDCReportReq extends JceStruct {
    static ArrayList<stMetaReportDataItem> cache_data = new ArrayList<>();
    public ArrayList<stMetaReportDataItem> data;
    public String dcid;

    static {
        cache_data.add(new stMetaReportDataItem());
    }

    public stDCReportReq() {
        this.dcid = "";
        this.data = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dcid = jceInputStream.readString(0, true);
        this.data = (ArrayList) jceInputStream.read((JceInputStream) cache_data, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dcid, 0);
        jceOutputStream.write((Collection) this.data, 1);
    }

    public stDCReportReq(String str, ArrayList<stMetaReportDataItem> arrayList) {
        this.dcid = str;
        this.data = arrayList;
    }
}
