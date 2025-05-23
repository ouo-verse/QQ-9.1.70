package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_concern_push_req extends JceStruct {
    static Map<Integer, String> cache_map_ext = new HashMap();
    public Map<Integer, String> map_ext;
    public long objuin;
    public int push_type;

    static {
        cache_map_ext.put(0, "");
    }

    public mobile_sub_concern_push_req() {
        this.objuin = 0L;
        this.push_type = 0;
        this.map_ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.objuin = jceInputStream.read(this.objuin, 0, true);
        this.push_type = jceInputStream.read(this.push_type, 1, true);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.objuin, 0);
        jceOutputStream.write(this.push_type, 1);
        Map<Integer, String> map = this.map_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public mobile_sub_concern_push_req(long j3, int i3, Map<Integer, String> map) {
        this.objuin = j3;
        this.push_type = i3;
        this.map_ext = map;
    }
}
