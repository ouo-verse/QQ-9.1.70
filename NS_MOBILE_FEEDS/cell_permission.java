package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_permission extends JceStruct {
    static Map<Integer, String> cache_map_permission_msg = new HashMap();
    public Map<Integer, String> map_permission_msg;
    public String permission_info;
    public String permission_jumpurl;
    public int permission_mask;
    public int permission_source;
    public String permission_tips;
    public byte permission_visit;
    public String status_info;

    static {
        cache_map_permission_msg.put(0, "");
    }

    public cell_permission() {
        this.permission_info = "";
        this.status_info = "";
        this.permission_tips = "";
        this.map_permission_msg = null;
        this.permission_jumpurl = "";
        this.permission_source = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.permission_info = jceInputStream.readString(0, false);
        this.permission_mask = jceInputStream.read(this.permission_mask, 1, false);
        this.status_info = jceInputStream.readString(2, false);
        this.permission_visit = jceInputStream.read(this.permission_visit, 3, false);
        this.permission_tips = jceInputStream.readString(4, false);
        this.map_permission_msg = (Map) jceInputStream.read((JceInputStream) cache_map_permission_msg, 5, false);
        this.permission_jumpurl = jceInputStream.readString(6, false);
        this.permission_source = jceInputStream.read(this.permission_source, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.permission_info;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.permission_mask, 1);
        String str2 = this.status_info;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.permission_visit, 3);
        String str3 = this.permission_tips;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        Map<Integer, String> map = this.map_permission_msg;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        String str4 = this.permission_jumpurl;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        jceOutputStream.write(this.permission_source, 7);
    }

    public cell_permission(String str, int i3, String str2, byte b16, String str3, Map<Integer, String> map, String str4, int i16) {
        this.permission_info = str;
        this.permission_mask = i3;
        this.status_info = str2;
        this.permission_visit = b16;
        this.permission_tips = str3;
        this.map_permission_msg = map;
        this.permission_jumpurl = str4;
        this.permission_source = i16;
    }
}
