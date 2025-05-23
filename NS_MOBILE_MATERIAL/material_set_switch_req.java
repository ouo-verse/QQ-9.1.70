package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_set_switch_req extends JceStruct {
    static int cache_iSwitchState;
    static Map<String, String> cache_mapExtInfo;
    public int iAppid;
    public int iSwitchState;
    public long lUin;
    public Map<String, String> mapExtInfo;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public material_set_switch_req() {
        this.lUin = 0L;
        this.iAppid = 0;
        this.iSwitchState = 0;
        this.mapExtInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.iAppid = jceInputStream.read(this.iAppid, 1, true);
        this.iSwitchState = jceInputStream.read(this.iSwitchState, 2, true);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.iAppid, 1);
        jceOutputStream.write(this.iSwitchState, 2);
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public material_set_switch_req(long j3, int i3, int i16, Map<String, String> map) {
        this.lUin = j3;
        this.iAppid = i3;
        this.iSwitchState = i16;
        this.mapExtInfo = map;
    }
}
