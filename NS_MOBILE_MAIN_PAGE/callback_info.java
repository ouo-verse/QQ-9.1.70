package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class callback_info extends JceStruct {
    static Map<String, String> cache_trans_info;
    public String content;
    public String h5hb_url;
    public boolean has_grabed;
    public short hb_type;
    public Map<String, String> trans_info;

    static {
        HashMap hashMap = new HashMap();
        cache_trans_info = hashMap;
        hashMap.put("", "");
    }

    public callback_info() {
        this.hb_type = (short) 0;
        this.has_grabed = true;
        this.content = "";
        this.trans_info = null;
        this.h5hb_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hb_type = jceInputStream.read(this.hb_type, 0, false);
        this.has_grabed = jceInputStream.read(this.has_grabed, 1, false);
        this.content = jceInputStream.readString(2, false);
        this.trans_info = (Map) jceInputStream.read((JceInputStream) cache_trans_info, 3, false);
        this.h5hb_url = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.hb_type, 0);
        jceOutputStream.write(this.has_grabed, 1);
        String str = this.content;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        Map<String, String> map = this.trans_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        String str2 = this.h5hb_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public callback_info(short s16, boolean z16, String str, Map<String, String> map, String str2) {
        this.hb_type = s16;
        this.has_grabed = z16;
        this.content = str;
        this.trans_info = map;
        this.h5hb_url = str2;
    }
}
