package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetWatermarkDictRsp extends JceStruct {
    static Map<String, String> cache_WatermarkDict;
    public int Code;
    public Map<String, String> WatermarkDict;

    static {
        HashMap hashMap = new HashMap();
        cache_WatermarkDict = hashMap;
        hashMap.put("", "");
    }

    public GetWatermarkDictRsp() {
        this.Code = 0;
        this.WatermarkDict = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.WatermarkDict = (Map) jceInputStream.read((JceInputStream) cache_WatermarkDict, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        jceOutputStream.write((Map) this.WatermarkDict, 1);
    }

    public GetWatermarkDictRsp(int i3, Map<String, String> map) {
        this.Code = i3;
        this.WatermarkDict = map;
    }
}
