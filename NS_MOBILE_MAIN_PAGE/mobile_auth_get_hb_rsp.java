package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_auth_get_hb_rsp extends JceStruct {
    static callback_info cache_hb_info = new callback_info();
    static Map<Long, String> cache_uin_nick = new HashMap();
    public int auth_res;
    public long channel;
    public String encryp_key;
    public String err_msg;
    public callback_info hb_info;
    public int operate_type;
    public Map<Long, String> uin_nick;

    static {
        cache_uin_nick.put(0L, "");
    }

    public mobile_auth_get_hb_rsp() {
        this.auth_res = 0;
        this.encryp_key = "";
        this.channel = 0L;
        this.hb_info = null;
        this.err_msg = "";
        this.operate_type = 0;
        this.uin_nick = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.auth_res = jceInputStream.read(this.auth_res, 0, true);
        this.encryp_key = jceInputStream.readString(1, false);
        this.channel = jceInputStream.read(this.channel, 2, false);
        this.hb_info = (callback_info) jceInputStream.read((JceStruct) cache_hb_info, 3, false);
        this.err_msg = jceInputStream.readString(4, false);
        this.operate_type = jceInputStream.read(this.operate_type, 5, false);
        this.uin_nick = (Map) jceInputStream.read((JceInputStream) cache_uin_nick, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.auth_res, 0);
        String str = this.encryp_key;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.channel, 2);
        callback_info callback_infoVar = this.hb_info;
        if (callback_infoVar != null) {
            jceOutputStream.write((JceStruct) callback_infoVar, 3);
        }
        String str2 = this.err_msg;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.operate_type, 5);
        Map<Long, String> map = this.uin_nick;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
    }

    public mobile_auth_get_hb_rsp(int i3, String str, long j3, callback_info callback_infoVar, String str2, int i16, Map<Long, String> map) {
        this.auth_res = i3;
        this.encryp_key = str;
        this.channel = j3;
        this.hb_info = callback_infoVar;
        this.err_msg = str2;
        this.operate_type = i16;
        this.uin_nick = map;
    }
}
