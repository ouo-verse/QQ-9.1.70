package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_host_hb_info_rsp extends JceStruct {
    static callback_info cache_hb_info = new callback_info();
    public int auth_res;
    public long channel;
    public String encryp_key;
    public String err_msg;
    public String feeds_id;
    public boolean has_available;
    public String hb_id;
    public callback_info hb_info;

    public mobile_host_hb_info_rsp() {
        this.has_available = true;
        this.hb_id = "";
        this.feeds_id = "";
        this.auth_res = 0;
        this.encryp_key = "";
        this.channel = 0L;
        this.hb_info = null;
        this.err_msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.has_available = jceInputStream.read(this.has_available, 0, true);
        this.hb_id = jceInputStream.readString(1, false);
        this.feeds_id = jceInputStream.readString(2, false);
        this.auth_res = jceInputStream.read(this.auth_res, 3, false);
        this.encryp_key = jceInputStream.readString(4, false);
        this.channel = jceInputStream.read(this.channel, 5, false);
        this.hb_info = (callback_info) jceInputStream.read((JceStruct) cache_hb_info, 6, false);
        this.err_msg = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.has_available, 0);
        String str = this.hb_id;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.feeds_id;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.auth_res, 3);
        String str3 = this.encryp_key;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.channel, 5);
        callback_info callback_infoVar = this.hb_info;
        if (callback_infoVar != null) {
            jceOutputStream.write((JceStruct) callback_infoVar, 6);
        }
        String str4 = this.err_msg;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
    }

    public mobile_host_hb_info_rsp(boolean z16, String str, String str2, int i3, String str3, long j3, callback_info callback_infoVar, String str4) {
        this.has_available = z16;
        this.hb_id = str;
        this.feeds_id = str2;
        this.auth_res = i3;
        this.encryp_key = str3;
        this.channel = j3;
        this.hb_info = callback_infoVar;
        this.err_msg = str4;
    }
}
