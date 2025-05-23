package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stOperaData extends JceStruct {
    static Map<Integer, String> cache_extendinfo = new HashMap();
    public int actiontype;
    public Map<Integer, String> extendinfo;
    public String strData;

    static {
        cache_extendinfo.put(0, "");
    }

    public stOperaData() {
        this.strData = "";
        this.actiontype = 0;
        this.extendinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strData = jceInputStream.readString(0, false);
        this.actiontype = jceInputStream.read(this.actiontype, 1, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strData;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.actiontype, 1);
        Map<Integer, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public stOperaData(String str, int i3, Map<Integer, String> map) {
        this.strData = str;
        this.actiontype = i3;
        this.extendinfo = map;
    }
}
