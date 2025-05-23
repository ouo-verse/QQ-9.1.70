package SWEET_NEW_PRIVILEGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sweet_style_info_item extends JceStruct {
    static Map<String, String> cache_map_ext;
    public String jump_url;
    public long level;
    public Map<String, String> map_ext;
    public String pic_url;

    static {
        HashMap hashMap = new HashMap();
        cache_map_ext = hashMap;
        hashMap.put("", "");
    }

    public sweet_style_info_item() {
        this.level = 0L;
        this.pic_url = "";
        this.jump_url = "";
        this.map_ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.level = jceInputStream.read(this.level, 0, false);
        this.pic_url = jceInputStream.readString(1, false);
        this.jump_url = jceInputStream.readString(2, false);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.level, 0);
        String str = this.pic_url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.jump_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        Map<String, String> map = this.map_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public sweet_style_info_item(long j3, String str, String str2, Map<String, String> map) {
        this.level = j3;
        this.pic_url = str;
        this.jump_url = str2;
        this.map_ext = map;
    }
}
