package VA_PROFILE_COMM_TASK;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommHeader extends JceStruct {
    static Map<String, String> cache_map_ext;
    public String auth_key;
    public long auth_type;
    public long client_ip;
    public Map<String, String> map_ext;
    public long platform;
    public long ptlogin_id;
    public String qqver;
    public String qua;
    public long server_ip;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_map_ext = hashMap;
        hashMap.put("", "");
    }

    public CommHeader() {
        this.uin = 0L;
        this.auth_type = 0L;
        this.auth_key = "";
        this.ptlogin_id = 0L;
        this.client_ip = 0L;
        this.server_ip = 0L;
        this.qua = "";
        this.qqver = "";
        this.platform = 0L;
        this.map_ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.auth_type = jceInputStream.read(this.auth_type, 1, false);
        this.auth_key = jceInputStream.readString(2, false);
        this.ptlogin_id = jceInputStream.read(this.ptlogin_id, 3, false);
        this.client_ip = jceInputStream.read(this.client_ip, 4, false);
        this.server_ip = jceInputStream.read(this.server_ip, 5, false);
        this.qua = jceInputStream.readString(6, false);
        this.qqver = jceInputStream.readString(7, false);
        this.platform = jceInputStream.read(this.platform, 8, false);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.auth_type, 1);
        String str = this.auth_key;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.ptlogin_id, 3);
        jceOutputStream.write(this.client_ip, 4);
        jceOutputStream.write(this.server_ip, 5);
        String str2 = this.qua;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        String str3 = this.qqver;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        jceOutputStream.write(this.platform, 8);
        Map<String, String> map = this.map_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 9);
        }
    }

    public CommHeader(long j3, long j16, String str, long j17, long j18, long j19, String str2, String str3, long j26, Map<String, String> map) {
        this.uin = j3;
        this.auth_type = j16;
        this.auth_key = str;
        this.ptlogin_id = j17;
        this.client_ip = j18;
        this.server_ip = j19;
        this.qua = str2;
        this.qqver = str3;
        this.platform = j26;
        this.map_ext = map;
    }
}
