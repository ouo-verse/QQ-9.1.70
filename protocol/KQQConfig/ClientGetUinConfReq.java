package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ClientGetUinConfReq extends JceStruct {
    static Map<String, Integer> cache_uinConf;
    public Map<String, Integer> uinConf;

    public ClientGetUinConfReq() {
        this.uinConf = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_uinConf == null) {
            cache_uinConf = new HashMap();
            cache_uinConf.put("", 0);
        }
        this.uinConf = (Map) jceInputStream.read((JceInputStream) cache_uinConf, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.uinConf, 1);
    }

    public ClientGetUinConfReq(Map<String, Integer> map) {
        this.uinConf = map;
    }
}
