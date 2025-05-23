package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_auth_get_hb_req extends JceStruct {
    static Map<String, String> cache_ext_info;
    public long cuin;
    public Map<String, String> ext_info;
    public String hb_id;
    public short hb_type;
    public long huin;
    public int huin_type;

    static {
        HashMap hashMap = new HashMap();
        cache_ext_info = hashMap;
        hashMap.put("", "");
    }

    public mobile_auth_get_hb_req() {
        this.huin = 0L;
        this.huin_type = 0;
        this.cuin = 0L;
        this.hb_id = "";
        this.hb_type = (short) 0;
        this.ext_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.huin = jceInputStream.read(this.huin, 0, true);
        this.huin_type = jceInputStream.read(this.huin_type, 1, false);
        this.cuin = jceInputStream.read(this.cuin, 2, false);
        this.hb_id = jceInputStream.readString(3, false);
        this.hb_type = jceInputStream.read(this.hb_type, 4, false);
        this.ext_info = (Map) jceInputStream.read((JceInputStream) cache_ext_info, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.huin, 0);
        jceOutputStream.write(this.huin_type, 1);
        jceOutputStream.write(this.cuin, 2);
        String str = this.hb_id;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.hb_type, 4);
        Map<String, String> map = this.ext_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
    }

    public mobile_auth_get_hb_req(long j3, int i3, long j16, String str, short s16, Map<String, String> map) {
        this.huin = j3;
        this.huin_type = i3;
        this.cuin = j16;
        this.hb_id = str;
        this.hb_type = s16;
        this.ext_info = map;
    }
}
