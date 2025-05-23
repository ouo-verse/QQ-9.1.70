package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_album_entrance extends JceStruct {
    static Map<String, String> cache_busi_param;
    public Map<String, String> busi_param;
    public int button_actiontype;
    public String button_title;
    public String guide_icon;
    public String guide_title;
    public String guide_url;
    public int iAttr;
    public String strButtonColor;

    static {
        HashMap hashMap = new HashMap();
        cache_busi_param = hashMap;
        hashMap.put("", "");
    }

    public cell_album_entrance() {
        this.guide_icon = "";
        this.guide_title = "";
        this.button_title = "";
        this.guide_url = "";
        this.button_actiontype = -1;
        this.iAttr = 0;
        this.strButtonColor = "";
        this.busi_param = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.guide_icon = jceInputStream.readString(0, false);
        this.guide_title = jceInputStream.readString(1, false);
        this.button_title = jceInputStream.readString(2, false);
        this.guide_url = jceInputStream.readString(3, false);
        this.button_actiontype = jceInputStream.read(this.button_actiontype, 4, false);
        this.iAttr = jceInputStream.read(this.iAttr, 5, false);
        this.strButtonColor = jceInputStream.readString(6, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.guide_icon;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.guide_title;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.button_title;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.guide_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.button_actiontype, 4);
        jceOutputStream.write(this.iAttr, 5);
        String str5 = this.strButtonColor;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        Map<String, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
    }

    public cell_album_entrance(String str, String str2, String str3, String str4, int i3, int i16, String str5, Map<String, String> map) {
        this.guide_icon = str;
        this.guide_title = str2;
        this.button_title = str3;
        this.guide_url = str4;
        this.button_actiontype = i3;
        this.iAttr = i16;
        this.strButtonColor = str5;
        this.busi_param = map;
    }
}
