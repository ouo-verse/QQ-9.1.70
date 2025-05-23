package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_facade_get_rsp extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    static Facade cache_stFacade = new Facade();
    public int iCode;
    public int iShowOnFriDyn;
    public Map<String, String> mapExtInfo;
    public Facade stFacade;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public mobile_facade_get_rsp() {
        this.iCode = 0;
        this.stFacade = null;
        this.mapExtInfo = null;
        this.iShowOnFriDyn = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iCode = jceInputStream.read(this.iCode, 0, false);
        this.stFacade = (Facade) jceInputStream.read((JceStruct) cache_stFacade, 1, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 2, false);
        this.iShowOnFriDyn = jceInputStream.read(this.iShowOnFriDyn, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iCode, 0);
        Facade facade = this.stFacade;
        if (facade != null) {
            jceOutputStream.write((JceStruct) facade, 1);
        }
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        jceOutputStream.write(this.iShowOnFriDyn, 3);
    }

    public mobile_facade_get_rsp(int i3, Facade facade, Map<String, String> map, int i16) {
        this.iCode = i3;
        this.stFacade = facade;
        this.mapExtInfo = map;
        this.iShowOnFriDyn = i16;
    }
}
