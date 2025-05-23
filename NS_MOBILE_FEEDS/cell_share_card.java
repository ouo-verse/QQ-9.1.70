package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_share_card extends JceStruct {
    static byte[] cache_content_buf;
    static Map<String, String> cache_mapExt;
    public byte[] content_buf;
    public Map<String, String> mapExt;

    static {
        cache_content_buf = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public cell_share_card() {
        this.content_buf = null;
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.content_buf = jceInputStream.read(cache_content_buf, 0, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.content_buf;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public cell_share_card(byte[] bArr, Map<String, String> map) {
        this.content_buf = bArr;
        this.mapExt = map;
    }
}
