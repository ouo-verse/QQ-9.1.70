package GIFT_MALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class doufu_piece_req extends JceStruct {
    static Map<String, String> cache_mapExt;
    public Map<String, String> mapExt;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public doufu_piece_req() {
        this.uin = 0L;
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public doufu_piece_req(long j3, Map<String, String> map) {
        this.uin = j3;
        this.mapExt = map;
    }
}
