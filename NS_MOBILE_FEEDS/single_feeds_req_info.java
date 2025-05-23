package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class single_feeds_req_info extends JceStruct {
    static ArrayList<SimpleComment> cache_all_commont_list = new ArrayList<>();
    public ArrayList<SimpleComment> all_commont_list;
    public int appId;
    public long feeds_time;
    public boolean pullAll;
    public String ugc_key;
    public long uin;

    static {
        cache_all_commont_list.add(new SimpleComment());
    }

    public single_feeds_req_info() {
        this.uin = 0L;
        this.appId = 0;
        this.feeds_time = 0L;
        this.ugc_key = "";
        this.all_commont_list = null;
        this.pullAll = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.appId = jceInputStream.read(this.appId, 1, false);
        this.feeds_time = jceInputStream.read(this.feeds_time, 2, false);
        this.ugc_key = jceInputStream.readString(3, false);
        this.all_commont_list = (ArrayList) jceInputStream.read((JceInputStream) cache_all_commont_list, 4, false);
        this.pullAll = jceInputStream.read(this.pullAll, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.appId, 1);
        jceOutputStream.write(this.feeds_time, 2);
        String str = this.ugc_key;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        ArrayList<SimpleComment> arrayList = this.all_commont_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        jceOutputStream.write(this.pullAll, 5);
    }

    public single_feeds_req_info(long j3, int i3, long j16, String str, ArrayList<SimpleComment> arrayList, boolean z16) {
        this.uin = j3;
        this.appId = i3;
        this.feeds_time = j16;
        this.ugc_key = str;
        this.all_commont_list = arrayList;
        this.pullAll = z16;
    }
}
