package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_delugc_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    static Map<String, String> cache_mapEx;
    public int appid;
    public Map<Integer, String> busi_param;
    public String clientKey;
    public String content;
    public int isverified;
    public Map<String, String> mapEx;
    public long ownuin;
    public String srcId;
    public String srcSubid;
    public long uin;

    static {
        cache_busi_param.put(0, "");
        HashMap hashMap = new HashMap();
        cache_mapEx = hashMap;
        hashMap.put("", "");
    }

    public operation_delugc_req() {
        this.appid = 0;
        this.uin = 0L;
        this.ownuin = 0L;
        this.srcId = "";
        this.srcSubid = "";
        this.content = "";
        this.isverified = 0;
        this.busi_param = null;
        this.mapEx = null;
        this.clientKey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.ownuin = jceInputStream.read(this.ownuin, 2, false);
        this.srcId = jceInputStream.readString(3, false);
        this.srcSubid = jceInputStream.readString(4, false);
        this.content = jceInputStream.readString(5, false);
        this.isverified = jceInputStream.read(this.isverified, 6, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 7, false);
        this.mapEx = (Map) jceInputStream.read((JceInputStream) cache_mapEx, 8, false);
        this.clientKey = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.ownuin, 2);
        String str = this.srcId;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.srcSubid;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.content;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        jceOutputStream.write(this.isverified, 6);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
        Map<String, String> map2 = this.mapEx;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 8);
        }
        String str4 = this.clientKey;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
    }

    public operation_delugc_req(int i3, long j3, long j16, String str, String str2, String str3, int i16, Map<Integer, String> map, Map<String, String> map2, String str4) {
        this.appid = i3;
        this.uin = j3;
        this.ownuin = j16;
        this.srcId = str;
        this.srcSubid = str2;
        this.content = str3;
        this.isverified = i16;
        this.busi_param = map;
        this.mapEx = map2;
        this.clientKey = str4;
    }
}
