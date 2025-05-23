package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_get_config_rsp extends JceStruct {
    static Map<String, byte[]> cache_config;
    public Map<String, byte[]> config;
    public String cookies;
    public int scene_flag;

    public mobile_get_config_rsp() {
        this.cookies = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_config == null) {
            HashMap hashMap = new HashMap();
            cache_config = hashMap;
            hashMap.put("", new byte[]{0});
        }
        this.config = (Map) jceInputStream.read((JceInputStream) cache_config, 0, false);
        this.cookies = jceInputStream.readString(1, false);
        this.scene_flag = jceInputStream.read(this.scene_flag, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, byte[]> map = this.config;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        String str = this.cookies;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.scene_flag, 2);
    }

    public mobile_get_config_rsp(Map<String, byte[]> map, String str, int i3) {
        this.config = map;
        this.cookies = str;
        this.scene_flag = i3;
    }
}
