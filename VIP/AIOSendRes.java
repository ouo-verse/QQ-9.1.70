package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AIOSendRes extends JceStruct {
    static Map<String, String> cache_mHighLightMap;
    public int iPopGrayStip;
    public Map<String, String> mHighLightMap;
    public String sGrayStipMsg;

    static {
        HashMap hashMap = new HashMap();
        cache_mHighLightMap = hashMap;
        hashMap.put("", "");
    }

    public AIOSendRes() {
        this.iPopGrayStip = 0;
        this.sGrayStipMsg = "";
        this.mHighLightMap = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iPopGrayStip = jceInputStream.read(this.iPopGrayStip, 0, true);
        this.sGrayStipMsg = jceInputStream.readString(1, true);
        this.mHighLightMap = (Map) jceInputStream.read((JceInputStream) cache_mHighLightMap, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iPopGrayStip, 0);
        jceOutputStream.write(this.sGrayStipMsg, 1);
        jceOutputStream.write((Map) this.mHighLightMap, 2);
    }

    public AIOSendRes(int i3, String str, Map<String, String> map) {
        this.iPopGrayStip = i3;
        this.sGrayStipMsg = str;
        this.mHighLightMap = map;
    }
}
