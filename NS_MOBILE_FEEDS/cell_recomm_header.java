package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_recomm_header extends JceStruct {
    static s_button cache_left_top_button;
    static Map<String, s_picurl> cache_mapCoverUrl = new HashMap();
    static s_picurl cache_rightBgPic;
    public String action_type;
    public String action_url;
    public byte btn_type;
    public String custom_icon;
    public String desc;
    public int icon_height;
    public int icon_width;
    public String left_title;
    public s_button left_top_button;
    public Map<String, s_picurl> mapCoverUrl;
    public long recomm_uin;
    public s_picurl rightBgPic;
    public String right_title;

    static {
        cache_mapCoverUrl.put("", new s_picurl());
        cache_left_top_button = new s_button();
        cache_rightBgPic = new s_picurl();
    }

    public cell_recomm_header() {
        this.left_title = "";
        this.btn_type = (byte) 0;
        this.right_title = "";
        this.custom_icon = "";
        this.icon_width = 0;
        this.icon_height = 0;
        this.desc = "";
        this.mapCoverUrl = null;
        this.recomm_uin = 0L;
        this.action_url = "";
        this.action_type = "";
        this.left_top_button = null;
        this.rightBgPic = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.left_title = jceInputStream.readString(0, false);
        this.btn_type = jceInputStream.read(this.btn_type, 1, false);
        this.right_title = jceInputStream.readString(2, false);
        this.custom_icon = jceInputStream.readString(3, false);
        this.icon_width = jceInputStream.read(this.icon_width, 4, false);
        this.icon_height = jceInputStream.read(this.icon_height, 5, false);
        this.desc = jceInputStream.readString(6, false);
        this.mapCoverUrl = (Map) jceInputStream.read((JceInputStream) cache_mapCoverUrl, 7, false);
        this.recomm_uin = jceInputStream.read(this.recomm_uin, 8, false);
        this.action_url = jceInputStream.readString(9, false);
        this.action_type = jceInputStream.readString(10, false);
        this.left_top_button = (s_button) jceInputStream.read((JceStruct) cache_left_top_button, 11, false);
        this.rightBgPic = (s_picurl) jceInputStream.read((JceStruct) cache_rightBgPic, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.left_title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.btn_type, 1);
        String str2 = this.right_title;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.custom_icon;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.icon_width, 4);
        jceOutputStream.write(this.icon_height, 5);
        String str4 = this.desc;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        Map<String, s_picurl> map = this.mapCoverUrl;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
        jceOutputStream.write(this.recomm_uin, 8);
        String str5 = this.action_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        String str6 = this.action_type;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        s_button s_buttonVar = this.left_top_button;
        if (s_buttonVar != null) {
            jceOutputStream.write((JceStruct) s_buttonVar, 11);
        }
        s_picurl s_picurlVar = this.rightBgPic;
        if (s_picurlVar != null) {
            jceOutputStream.write((JceStruct) s_picurlVar, 12);
        }
    }

    public cell_recomm_header(String str, byte b16, String str2, String str3, int i3, int i16, String str4, Map<String, s_picurl> map, long j3, String str5, String str6, s_button s_buttonVar, s_picurl s_picurlVar) {
        this.left_title = str;
        this.btn_type = b16;
        this.right_title = str2;
        this.custom_icon = str3;
        this.icon_width = i3;
        this.icon_height = i16;
        this.desc = str4;
        this.mapCoverUrl = map;
        this.recomm_uin = j3;
        this.action_url = str5;
        this.action_type = str6;
        this.left_top_button = s_buttonVar;
        this.rightBgPic = s_picurlVar;
    }
}
