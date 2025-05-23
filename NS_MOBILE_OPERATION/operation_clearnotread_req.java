package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_clearnotread_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    static Map<String, String> cache_mapEx;
    public int appid;
    public Map<Integer, String> busi_param;
    public int clear_type;
    public Map<String, String> mapEx;
    public long uin;

    static {
        cache_busi_param.put(0, "");
        HashMap hashMap = new HashMap();
        cache_mapEx = hashMap;
        hashMap.put("", "");
    }

    public operation_clearnotread_req() {
        this.appid = 0;
        this.uin = 0L;
        this.clear_type = 0;
        this.busi_param = null;
        this.mapEx = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.clear_type = jceInputStream.read(this.clear_type, 2, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 3, false);
        this.mapEx = (Map) jceInputStream.read((JceInputStream) cache_mapEx, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.clear_type, 2);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        Map<String, String> map2 = this.mapEx;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 4);
        }
    }

    public operation_clearnotread_req(int i3, long j3, int i16, Map<Integer, String> map, Map<String, String> map2) {
        this.appid = i3;
        this.uin = j3;
        this.clear_type = i16;
        this.busi_param = map;
        this.mapEx = map2;
    }
}
