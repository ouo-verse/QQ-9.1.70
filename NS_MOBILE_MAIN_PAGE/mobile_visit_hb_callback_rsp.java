package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_visit_hb_callback_rsp extends JceStruct {
    static Map<String, String> cache_ext_info;
    public String err_msg;
    public Map<String, String> ext_info;
    public int ret;

    static {
        HashMap hashMap = new HashMap();
        cache_ext_info = hashMap;
        hashMap.put("", "");
    }

    public mobile_visit_hb_callback_rsp() {
        this.ret = 0;
        this.err_msg = "";
        this.ext_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.err_msg = jceInputStream.readString(1, false);
        this.ext_info = (Map) jceInputStream.read((JceInputStream) cache_ext_info, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.err_msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<String, String> map = this.ext_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public mobile_visit_hb_callback_rsp(int i3, String str, Map<String, String> map) {
        this.ret = i3;
        this.err_msg = str;
        this.ext_info = map;
    }
}
