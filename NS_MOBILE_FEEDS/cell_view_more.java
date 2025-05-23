package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_view_more extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    public int actiontype;
    public Map<Integer, String> busi_param;
    public String guide_content;
    public String jump_url;

    static {
        cache_busi_param.put(0, "");
    }

    public cell_view_more() {
        this.guide_content = "";
        this.busi_param = null;
        this.actiontype = 0;
        this.jump_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.guide_content = jceInputStream.readString(0, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 1, false);
        this.actiontype = jceInputStream.read(this.actiontype, 2, false);
        this.jump_url = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.guide_content;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        jceOutputStream.write(this.actiontype, 2);
        String str2 = this.jump_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public cell_view_more(String str, Map<Integer, String> map, int i3, String str2) {
        this.guide_content = str;
        this.busi_param = map;
        this.actiontype = i3;
        this.jump_url = str2;
    }
}
