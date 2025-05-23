package NS_MOBILE_QQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RES_ITEM_COVER extends JceStruct {
    static Map<String, String> cache_extendinfo;
    public Map<String, String> extendinfo;
    public String strJumpQzone;

    static {
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public RES_ITEM_COVER() {
        this.strJumpQzone = "";
        this.extendinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strJumpQzone = jceInputStream.readString(0, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strJumpQzone;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public RES_ITEM_COVER(String str, Map<String, String> map) {
        this.strJumpQzone = str;
        this.extendinfo = map;
    }
}
