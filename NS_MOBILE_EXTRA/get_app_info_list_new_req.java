package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_app_info_list_new_req extends JceStruct {
    static Map<Integer, Integer> cache_current_serial_map;
    public int current_list_serial;
    public Map<Integer, Integer> current_serial_map;

    public get_app_info_list_new_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_current_serial_map == null) {
            cache_current_serial_map = new HashMap();
            cache_current_serial_map.put(0, 0);
        }
        this.current_serial_map = (Map) jceInputStream.read((JceInputStream) cache_current_serial_map, 0, false);
        this.current_list_serial = jceInputStream.read(this.current_list_serial, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, Integer> map = this.current_serial_map;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        jceOutputStream.write(this.current_list_serial, 1);
    }

    public get_app_info_list_new_req(Map<Integer, Integer> map, int i3) {
        this.current_serial_map = map;
        this.current_list_serial = i3;
    }
}
