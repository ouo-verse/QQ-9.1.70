package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_recomm_item extends JceStruct {
    static Map<String, String> cache_extendinfo;
    public int ButtonType;
    public String content;
    public String desc_after_click;
    public String desc_before_click;
    public Map<String, String> extendinfo;
    public s_picurl icon_after_click;
    public s_picurl icon_before_click;
    public s_user userinfo;
    static s_user cache_userinfo = new s_user();
    static s_picurl cache_icon_before_click = new s_picurl();
    static s_picurl cache_icon_after_click = new s_picurl();

    static {
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public cell_recomm_item() {
        this.userinfo = null;
        this.icon_before_click = null;
        this.icon_after_click = null;
        this.desc_before_click = "";
        this.desc_after_click = "";
        this.content = "";
        this.extendinfo = null;
        this.ButtonType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.userinfo = (s_user) jceInputStream.read((JceStruct) cache_userinfo, 0, false);
        this.icon_before_click = (s_picurl) jceInputStream.read((JceStruct) cache_icon_before_click, 1, false);
        this.icon_after_click = (s_picurl) jceInputStream.read((JceStruct) cache_icon_after_click, 2, false);
        this.desc_before_click = jceInputStream.readString(3, false);
        this.desc_after_click = jceInputStream.readString(4, false);
        this.content = jceInputStream.readString(5, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 6, false);
        this.ButtonType = jceInputStream.read(this.ButtonType, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_user s_userVar = this.userinfo;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 0);
        }
        s_picurl s_picurlVar = this.icon_before_click;
        if (s_picurlVar != null) {
            jceOutputStream.write((JceStruct) s_picurlVar, 1);
        }
        s_picurl s_picurlVar2 = this.icon_after_click;
        if (s_picurlVar2 != null) {
            jceOutputStream.write((JceStruct) s_picurlVar2, 2);
        }
        String str = this.desc_before_click;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.desc_after_click;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.content;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        jceOutputStream.write(this.ButtonType, 7);
    }

    public cell_recomm_item(s_user s_userVar, s_picurl s_picurlVar, s_picurl s_picurlVar2, String str, String str2, String str3, Map<String, String> map, int i3) {
        this.userinfo = s_userVar;
        this.icon_before_click = s_picurlVar;
        this.icon_after_click = s_picurlVar2;
        this.desc_before_click = str;
        this.desc_after_click = str2;
        this.content = str3;
        this.extendinfo = map;
        this.ButtonType = i3;
    }
}
