package BOSSStrategyCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class tPullADVResponse extends JceStruct {
    static Map<Integer, tAdvDesc> cache_map_adv_desc = new HashMap();
    public Map<Integer, tAdvDesc> map_adv_desc;
    public int ret;
    public String s_ret_msg;

    static {
        cache_map_adv_desc.put(0, new tAdvDesc());
    }

    public tPullADVResponse() {
        this.ret = 0;
        this.s_ret_msg = "";
        this.map_adv_desc = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.s_ret_msg = jceInputStream.readString(1, true);
        this.map_adv_desc = (Map) jceInputStream.read((JceInputStream) cache_map_adv_desc, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.s_ret_msg, 1);
        jceOutputStream.write((Map) this.map_adv_desc, 2);
    }

    public tPullADVResponse(int i3, String str, Map<Integer, tAdvDesc> map) {
        this.ret = i3;
        this.s_ret_msg = str;
        this.map_adv_desc = map;
    }
}
