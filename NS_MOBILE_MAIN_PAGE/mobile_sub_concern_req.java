package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_concern_req extends JceStruct {
    static Map<Integer, String> cache_map_ext = new HashMap();
    public int isconcern;
    public Map<Integer, String> map_ext;
    public long objuin;
    public int source;

    static {
        cache_map_ext.put(0, "");
    }

    public mobile_sub_concern_req() {
        this.objuin = 0L;
        this.isconcern = 0;
        this.source = 0;
        this.map_ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.objuin = jceInputStream.read(this.objuin, 0, true);
        this.isconcern = jceInputStream.read(this.isconcern, 1, true);
        this.source = jceInputStream.read(this.source, 2, false);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.objuin, 0);
        jceOutputStream.write(this.isconcern, 1);
        jceOutputStream.write(this.source, 2);
        Map<Integer, String> map = this.map_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public mobile_sub_concern_req(long j3, int i3, int i16, Map<Integer, String> map) {
        this.objuin = j3;
        this.isconcern = i3;
        this.source = i16;
        this.map_ext = map;
    }
}
