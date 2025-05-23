package NS_MOBILE_BITMAP_4TH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class bmp4_get_rsp extends JceStruct {
    static Map<Long, bmp4_values> cache_map_rsp = new HashMap();
    public String errmsg;
    public Map<Long, bmp4_values> map_rsp;
    public int retCode;

    static {
        cache_map_rsp.put(0L, new bmp4_values());
    }

    public bmp4_get_rsp() {
        this.retCode = 0;
        this.errmsg = "";
        this.map_rsp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.retCode = jceInputStream.read(this.retCode, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
        this.map_rsp = (Map) jceInputStream.read((JceInputStream) cache_map_rsp, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.retCode, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<Long, bmp4_values> map = this.map_rsp;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public bmp4_get_rsp(int i3, String str, Map<Long, bmp4_values> map) {
        this.retCode = i3;
        this.errmsg = str;
        this.map_rsp = map;
    }
}
