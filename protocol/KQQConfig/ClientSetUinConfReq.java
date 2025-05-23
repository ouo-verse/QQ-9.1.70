package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ClientSetUinConfReq extends JceStruct {
    static Map<String, ArrayList<byte[]>> cache_uinConf;
    public Map<String, ArrayList<byte[]>> uinConf;

    public ClientSetUinConfReq() {
        this.uinConf = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_uinConf == null) {
            cache_uinConf = new HashMap();
            ArrayList<byte[]> arrayList = new ArrayList<>();
            arrayList.add(new byte[]{0});
            cache_uinConf.put("", arrayList);
        }
        this.uinConf = (Map) jceInputStream.read((JceInputStream) cache_uinConf, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.uinConf, 1);
    }

    public ClientSetUinConfReq(Map<String, ArrayList<byte[]>> map) {
        this.uinConf = map;
    }
}
