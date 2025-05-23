package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetCameraConfigRsp extends JceStruct {
    static Map<String, CameraConfig> cache_ConfigMap = new HashMap();
    public int Code;
    public Map<String, CameraConfig> ConfigMap;

    static {
        cache_ConfigMap.put("", new CameraConfig());
    }

    public GetCameraConfigRsp() {
        this.Code = 0;
        this.ConfigMap = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.ConfigMap = (Map) jceInputStream.read((JceInputStream) cache_ConfigMap, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        Map<String, CameraConfig> map = this.ConfigMap;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public GetCameraConfigRsp(int i3, Map<String, CameraConfig> map) {
        this.Code = i3;
        this.ConfigMap = map;
    }
}
