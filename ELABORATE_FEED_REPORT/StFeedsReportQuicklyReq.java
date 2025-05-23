package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class StFeedsReportQuicklyReq extends JceStruct {
    static ArrayList<SingleExposeInfo> cache_exposeList = new ArrayList<>();
    public ArrayList<SingleExposeInfo> exposeList;

    static {
        cache_exposeList.add(new SingleExposeInfo());
    }

    public StFeedsReportQuicklyReq() {
        this.exposeList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.exposeList = (ArrayList) jceInputStream.read((JceInputStream) cache_exposeList, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<SingleExposeInfo> arrayList = this.exposeList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public StFeedsReportQuicklyReq(ArrayList<SingleExposeInfo> arrayList) {
        this.exposeList = arrayList;
    }
}
