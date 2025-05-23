package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_tab_list_item extends JceStruct {
    static Map<String, String> cacheExtInfo;
    static int cache_tab_id;
    public boolean can_edit;
    public Map<String, String> extInfo;
    public String icon_url;
    public boolean is_custom;
    public String jump_url;
    public boolean need_clear_red;
    public int red_id_mainpage;
    public int red_id_undelcount;
    public String right_text;
    public int tab_id;
    public String text;

    static {
        HashMap hashMap = new HashMap();
        cacheExtInfo = hashMap;
        hashMap.put("", "");
    }

    public s_tab_list_item() {
        this.tab_id = 0;
        this.icon_url = "";
        this.jump_url = "";
        this.text = "";
        this.is_custom = true;
        this.red_id_mainpage = 0;
        this.red_id_undelcount = 0;
        this.can_edit = true;
        this.need_clear_red = true;
        this.right_text = "";
        this.extInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.tab_id = jceInputStream.read(this.tab_id, 0, true);
        this.icon_url = jceInputStream.readString(1, true);
        this.jump_url = jceInputStream.readString(2, true);
        this.text = jceInputStream.readString(3, true);
        this.is_custom = jceInputStream.read(this.is_custom, 4, true);
        this.red_id_mainpage = jceInputStream.read(this.red_id_mainpage, 5, true);
        this.red_id_undelcount = jceInputStream.read(this.red_id_undelcount, 6, true);
        this.can_edit = jceInputStream.read(this.can_edit, 7, true);
        this.need_clear_red = jceInputStream.read(this.need_clear_red, 8, false);
        this.right_text = jceInputStream.readString(9, false);
        this.extInfo = (Map) jceInputStream.read((JceInputStream) cacheExtInfo, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.tab_id, 0);
        String str = this.right_text;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.jump_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.text;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.is_custom, 4);
        jceOutputStream.write(this.red_id_mainpage, 5);
        jceOutputStream.write(this.red_id_undelcount, 6);
        jceOutputStream.write(this.can_edit, 7);
        jceOutputStream.write(this.need_clear_red, 8);
        String str4 = this.right_text;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        Map<String, String> map = this.extInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 10);
        }
    }

    public s_tab_list_item(int i3, String str, String str2, String str3, boolean z16, int i16, int i17, boolean z17, boolean z18, String str4, Map<String, String> map) {
        this.tab_id = i3;
        this.icon_url = str;
        this.jump_url = str2;
        this.text = str3;
        this.is_custom = z16;
        this.red_id_mainpage = i16;
        this.red_id_undelcount = i17;
        this.can_edit = z17;
        this.need_clear_red = z18;
        this.right_text = str4;
        this.extInfo = map;
    }
}
