package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stShareInfo extends JceStruct {
    static Map<Integer, stShareBody> cache_body_map = new HashMap();
    static Map<Integer, stShareBody> cache_haibao_body_map;
    static stSqArk cache_sq_ark_info;
    static stWxMiniProg cache_wx_mini_program;
    public int activity_type;
    public String background_title_color;
    public String background_url;
    public Map<Integer, stShareBody> body_map;
    public String feed_cover_updtime;
    public Map<Integer, stShareBody> haibao_body_map;
    public String haibao_desc;
    public String haibao_jump_url;
    public String jump_url;
    public String share_icon_title;
    public String share_icon_url;
    public int share_num;
    public stSqArk sq_ark_info;
    public stWxMiniProg wx_mini_program;

    static {
        cache_body_map.put(0, new stShareBody());
        cache_wx_mini_program = new stWxMiniProg();
        cache_sq_ark_info = new stSqArk();
        cache_haibao_body_map = new HashMap();
        cache_haibao_body_map.put(0, new stShareBody());
    }

    public stShareInfo() {
        this.jump_url = "";
        this.body_map = null;
        this.wx_mini_program = null;
        this.sq_ark_info = null;
        this.share_icon_url = "";
        this.share_icon_title = "";
        this.background_url = "";
        this.activity_type = 0;
        this.haibao_jump_url = "";
        this.haibao_body_map = null;
        this.background_title_color = "";
        this.haibao_desc = "";
        this.share_num = 0;
        this.feed_cover_updtime = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.jump_url = jceInputStream.readString(0, false);
        this.body_map = (Map) jceInputStream.read((JceInputStream) cache_body_map, 1, false);
        this.wx_mini_program = (stWxMiniProg) jceInputStream.read((JceStruct) cache_wx_mini_program, 2, false);
        this.sq_ark_info = (stSqArk) jceInputStream.read((JceStruct) cache_sq_ark_info, 3, false);
        this.share_icon_url = jceInputStream.readString(4, false);
        this.share_icon_title = jceInputStream.readString(5, false);
        this.background_url = jceInputStream.readString(6, false);
        this.activity_type = jceInputStream.read(this.activity_type, 7, false);
        this.haibao_jump_url = jceInputStream.readString(8, false);
        this.haibao_body_map = (Map) jceInputStream.read((JceInputStream) cache_haibao_body_map, 9, false);
        this.background_title_color = jceInputStream.readString(10, false);
        this.haibao_desc = jceInputStream.readString(11, false);
        this.share_num = jceInputStream.read(this.share_num, 12, false);
        this.feed_cover_updtime = jceInputStream.readString(13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.jump_url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        Map<Integer, stShareBody> map = this.body_map;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        stWxMiniProg stwxminiprog = this.wx_mini_program;
        if (stwxminiprog != null) {
            jceOutputStream.write((JceStruct) stwxminiprog, 2);
        }
        stSqArk stsqark = this.sq_ark_info;
        if (stsqark != null) {
            jceOutputStream.write((JceStruct) stsqark, 3);
        }
        String str2 = this.share_icon_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.share_icon_title;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.background_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        jceOutputStream.write(this.activity_type, 7);
        String str5 = this.haibao_jump_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        Map<Integer, stShareBody> map2 = this.haibao_body_map;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 9);
        }
        String str6 = this.background_title_color;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        String str7 = this.haibao_desc;
        if (str7 != null) {
            jceOutputStream.write(str7, 11);
        }
        jceOutputStream.write(this.share_num, 12);
        String str8 = this.feed_cover_updtime;
        if (str8 != null) {
            jceOutputStream.write(str8, 13);
        }
    }

    public stShareInfo(String str, Map<Integer, stShareBody> map, stWxMiniProg stwxminiprog, stSqArk stsqark, String str2, String str3, String str4, int i3, String str5, Map<Integer, stShareBody> map2, String str6, String str7, int i16, String str8) {
        this.jump_url = str;
        this.body_map = map;
        this.wx_mini_program = stwxminiprog;
        this.sq_ark_info = stsqark;
        this.share_icon_url = str2;
        this.share_icon_title = str3;
        this.background_url = str4;
        this.activity_type = i3;
        this.haibao_jump_url = str5;
        this.haibao_body_map = map2;
        this.background_title_color = str6;
        this.haibao_desc = str7;
        this.share_num = i16;
        this.feed_cover_updtime = str8;
    }
}
