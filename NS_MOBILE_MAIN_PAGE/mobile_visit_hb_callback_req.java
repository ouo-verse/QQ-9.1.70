package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_visit_hb_callback_req extends JceStruct {
    static Map<String, String> cache_trans_info;
    public String client_key;
    public String comment;
    public String hb_id;
    public short hb_type;
    public Map<String, String> trans_info;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_trans_info = hashMap;
        hashMap.put("", "");
    }

    public mobile_visit_hb_callback_req() {
        this.uin = 0L;
        this.hb_type = (short) 0;
        this.hb_id = "";
        this.comment = "";
        this.client_key = "";
        this.trans_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.hb_type = jceInputStream.read(this.hb_type, 1, false);
        this.hb_id = jceInputStream.readString(2, false);
        this.comment = jceInputStream.readString(3, false);
        this.client_key = jceInputStream.readString(4, false);
        this.trans_info = (Map) jceInputStream.read((JceInputStream) cache_trans_info, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.hb_type, 1);
        String str = this.hb_id;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.comment;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.client_key;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        Map<String, String> map = this.trans_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
    }

    public mobile_visit_hb_callback_req(long j3, short s16, String str, String str2, String str3, Map<String, String> map) {
        this.uin = j3;
        this.hb_type = s16;
        this.hb_id = str;
        this.comment = str2;
        this.client_key = str3;
        this.trans_info = map;
    }
}
