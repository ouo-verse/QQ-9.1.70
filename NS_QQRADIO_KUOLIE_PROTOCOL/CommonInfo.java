package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommonInfo extends JceStruct {
    static Map<String, String> cache_mapExt;
    public String cookie;
    public byte hasMore;
    public byte isRefresh;
    public Map<String, String> mapExt;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public CommonInfo() {
        this.cookie = "";
        this.hasMore = (byte) 0;
        this.mapExt = null;
        this.isRefresh = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cookie = jceInputStream.readString(0, false);
        this.hasMore = jceInputStream.read(this.hasMore, 1, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 2, false);
        this.isRefresh = jceInputStream.read(this.isRefresh, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.cookie;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.hasMore, 1);
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        jceOutputStream.write(this.isRefresh, 3);
    }

    public CommonInfo(String str, byte b16, Map<String, String> map, byte b17) {
        this.cookie = str;
        this.hasMore = b16;
        this.mapExt = map;
        this.isRefresh = b17;
    }
}
