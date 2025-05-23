package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class newest_feeds_req extends JceStruct {
    static Map<Long, Long> cache_mapUinTimes;
    static ArrayList<Long> cache_vec_uinlist = new ArrayList<>();
    public int cmd;
    public long last_feed_time;
    public long login_uin;
    public Map<Long, Long> mapUinTimes;
    public String strQua;
    public String str_attach;
    public ArrayList<Long> vec_uinlist;

    static {
        cache_vec_uinlist.add(0L);
        cache_mapUinTimes = new HashMap();
        cache_mapUinTimes.put(0L, 0L);
    }

    public newest_feeds_req() {
        this.cmd = 0;
        this.login_uin = 0L;
        this.vec_uinlist = null;
        this.last_feed_time = 0L;
        this.str_attach = "";
        this.strQua = "";
        this.mapUinTimes = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cmd = jceInputStream.read(this.cmd, 0, false);
        this.login_uin = jceInputStream.read(this.login_uin, 1, false);
        this.vec_uinlist = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_uinlist, 2, false);
        this.last_feed_time = jceInputStream.read(this.last_feed_time, 3, false);
        this.str_attach = jceInputStream.readString(4, false);
        this.strQua = jceInputStream.readString(5, false);
        this.mapUinTimes = (Map) jceInputStream.read((JceInputStream) cache_mapUinTimes, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cmd, 0);
        jceOutputStream.write(this.login_uin, 1);
        ArrayList<Long> arrayList = this.vec_uinlist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.last_feed_time, 3);
        String str = this.str_attach;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.strQua;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        Map<Long, Long> map = this.mapUinTimes;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
    }

    public newest_feeds_req(int i3, long j3, ArrayList<Long> arrayList, long j16, String str, String str2, Map<Long, Long> map) {
        this.cmd = i3;
        this.login_uin = j3;
        this.vec_uinlist = arrayList;
        this.last_feed_time = j16;
        this.str_attach = str;
        this.strQua = str2;
        this.mapUinTimes = map;
    }
}
