package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_set_photo_wall_combinepic_rsp extends JceStruct {
    static Map<String, String> cache_extinfo;
    public Map<String, String> extinfo;
    public int ret;

    public mobile_sub_set_photo_wall_combinepic_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        if (cache_extinfo == null) {
            HashMap hashMap = new HashMap();
            cache_extinfo = hashMap;
            hashMap.put("", "");
        }
        this.extinfo = (Map) jceInputStream.read((JceInputStream) cache_extinfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        Map<String, String> map = this.extinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public mobile_sub_set_photo_wall_combinepic_rsp(int i3, Map<String, String> map) {
        this.ret = i3;
        this.extinfo = map;
    }
}
