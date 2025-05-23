package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_del_icfeed_req extends JceStruct {
    static Map<String, String> cache_mapEx;
    public int appid;
    public String clientkey;
    public Map<String, String> mapEx;
    public String skey;
    public long time;
    public int typeId;
    public long uflag;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_mapEx = hashMap;
        hashMap.put("", "");
    }

    public operation_del_icfeed_req() {
        this.skey = "";
        this.mapEx = null;
        this.clientkey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.appid = jceInputStream.read(this.appid, 1, false);
        this.typeId = jceInputStream.read(this.typeId, 2, false);
        this.skey = jceInputStream.readString(3, false);
        this.time = jceInputStream.read(this.time, 4, false);
        this.uflag = jceInputStream.read(this.uflag, 5, false);
        this.mapEx = (Map) jceInputStream.read((JceInputStream) cache_mapEx, 6, false);
        this.clientkey = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.typeId, 2);
        String str = this.skey;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.time, 4);
        jceOutputStream.write(this.uflag, 5);
        Map<String, String> map = this.mapEx;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        String str2 = this.clientkey;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
    }

    public operation_del_icfeed_req(long j3, int i3, int i16, String str, long j16, long j17, Map<String, String> map, String str2) {
        this.uin = j3;
        this.appid = i3;
        this.typeId = i16;
        this.skey = str;
        this.time = j16;
        this.uflag = j17;
        this.mapEx = map;
        this.clientkey = str2;
    }
}
