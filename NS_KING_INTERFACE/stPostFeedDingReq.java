package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaReportDataItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class stPostFeedDingReq extends JceStruct {
    static ArrayList<stMetaReportDataItem> cache_data = new ArrayList<>();
    public ArrayList<stMetaReportDataItem> data;
    public int dingAction;
    public String feed_id;

    static {
        cache_data.add(new stMetaReportDataItem());
    }

    public stPostFeedDingReq() {
        this.feed_id = "";
        this.data = null;
        this.dingAction = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feed_id = jceInputStream.readString(1, true);
        this.data = (ArrayList) jceInputStream.read((JceInputStream) cache_data, 2, false);
        this.dingAction = jceInputStream.read(this.dingAction, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.feed_id, 1);
        ArrayList<stMetaReportDataItem> arrayList = this.data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.dingAction, 3);
    }

    public stPostFeedDingReq(String str, ArrayList<stMetaReportDataItem> arrayList, int i3) {
        this.feed_id = str;
        this.data = arrayList;
        this.dingAction = i3;
    }
}
