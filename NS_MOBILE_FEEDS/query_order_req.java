package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class query_order_req extends JceStruct {
    static Map<String, String> cache_extendinfo;
    public Map<String, String> extendinfo;
    public String strIMSI;
    public String strIphoneNum;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public query_order_req() {
        this.uin = 0L;
        this.strIphoneNum = "";
        this.strIMSI = "";
        this.extendinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.strIphoneNum = jceInputStream.readString(1, false);
        this.strIMSI = jceInputStream.readString(2, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.strIphoneNum;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strIMSI;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public query_order_req(long j3, String str, String str2, Map<String, String> map) {
        this.uin = j3;
        this.strIphoneNum = str;
        this.strIMSI = str2;
        this.extendinfo = map;
    }
}
