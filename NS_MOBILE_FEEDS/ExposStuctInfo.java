package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ExposStuctInfo extends JceStruct {
    static Map<String, String> cache_extendInfo;
    public int appid;
    public Map<String, String> extendInfo;
    public byte opType;
    public String recordId;

    static {
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
    }

    public ExposStuctInfo() {
        this.recordId = "";
        this.appid = 0;
        this.opType = (byte) 0;
        this.extendInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.recordId = jceInputStream.readString(0, false);
        this.appid = jceInputStream.read(this.appid, 1, false);
        this.opType = jceInputStream.read(this.opType, 2, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.recordId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.opType, 2);
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public ExposStuctInfo(String str, int i3, byte b16, Map<String, String> map) {
        this.recordId = str;
        this.appid = i3;
        this.opType = b16;
        this.extendInfo = map;
    }
}
