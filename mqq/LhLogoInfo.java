package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LhLogoInfo extends JceStruct {
    static Map<Integer, LhLogoResources> cache_lhLogoResources = new HashMap();
    public int bUpdate;
    public Map<Integer, LhLogoResources> lhLogoResources;

    static {
        cache_lhLogoResources.put(0, new LhLogoResources());
    }

    public LhLogoInfo() {
        this.bUpdate = 0;
        this.lhLogoResources = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bUpdate = jceInputStream.read(this.bUpdate, 0, false);
        this.lhLogoResources = (Map) jceInputStream.read((JceInputStream) cache_lhLogoResources, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bUpdate, 0);
        Map<Integer, LhLogoResources> map = this.lhLogoResources;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public LhLogoInfo(int i3, Map<Integer, LhLogoResources> map) {
        this.bUpdate = i3;
        this.lhLogoResources = map;
    }
}
