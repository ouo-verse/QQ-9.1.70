package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetBroadCastHbIdiomRsp extends JceStruct {
    static Map<String, BroadCastInfo> cache_sendlistIdiomInfoDict = new HashMap();
    public Map<String, BroadCastInfo> sendlistIdiomInfoDict;

    static {
        cache_sendlistIdiomInfoDict.put("", new BroadCastInfo());
    }

    public GetBroadCastHbIdiomRsp() {
        this.sendlistIdiomInfoDict = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sendlistIdiomInfoDict = (Map) jceInputStream.read((JceInputStream) cache_sendlistIdiomInfoDict, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, BroadCastInfo> map = this.sendlistIdiomInfoDict;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public GetBroadCastHbIdiomRsp(Map<String, BroadCastInfo> map) {
        this.sendlistIdiomInfoDict = map;
    }
}
