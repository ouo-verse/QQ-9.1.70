package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_online_report_req extends JceStruct {
    static ArrayList<mobile_online_report_item> cache_vecOnlineItem = new ArrayList<>();
    public int appid;
    public int type_id;
    public long uin;
    public ArrayList<mobile_online_report_item> vecOnlineItem;

    static {
        cache_vecOnlineItem.add(new mobile_online_report_item());
    }

    public mobile_online_report_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.appid = jceInputStream.read(this.appid, 1, true);
        this.type_id = jceInputStream.read(this.type_id, 2, true);
        this.vecOnlineItem = (ArrayList) jceInputStream.read((JceInputStream) cache_vecOnlineItem, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.type_id, 2);
        ArrayList<mobile_online_report_item> arrayList = this.vecOnlineItem;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
    }

    public mobile_online_report_req(long j3, int i3, int i16, ArrayList<mobile_online_report_item> arrayList) {
        this.uin = j3;
        this.appid = i3;
        this.type_id = i16;
        this.vecOnlineItem = arrayList;
    }
}
