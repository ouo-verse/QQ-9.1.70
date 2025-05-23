package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_event_tag extends JceStruct {
    static Map<String, String> cache_extendInfo;
    static ArrayList<famous_user> cache_fans_list;
    static s_join_list cache_join_list = new s_join_list();
    static famous_user cache_star;
    public String backgd_picurl;
    public String count_desc;
    public Map<String, String> extendInfo;
    public ArrayList<famous_user> fans_list;

    /* renamed from: id, reason: collision with root package name */
    public String f24992id;
    public boolean is_default;
    public boolean is_star;
    public s_join_list join_list;
    public int pic_height;
    public String pic_url;
    public int pic_width;
    public String show_desc;
    public String show_txt;
    public famous_user star;
    public int status;
    public long time;
    public String title;
    public long uin;
    public boolean update_flag;
    public long view_count;
    public String view_str;

    static {
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
        cache_star = new famous_user();
        cache_fans_list = new ArrayList<>();
        cache_fans_list.add(new famous_user());
    }

    public s_event_tag() {
        this.uin = 0L;
        this.time = 0L;
        this.f24992id = "";
        this.title = "";
        this.show_txt = "";
        this.show_desc = "";
        this.pic_url = "";
        this.pic_width = 0;
        this.pic_height = 0;
        this.count_desc = "";
        this.join_list = null;
        this.is_default = false;
        this.extendInfo = null;
        this.view_count = 0L;
        this.backgd_picurl = "";
        this.update_flag = false;
        this.star = null;
        this.fans_list = null;
        this.is_star = true;
        this.view_str = "";
        this.status = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.time = jceInputStream.read(this.time, 1, false);
        this.f24992id = jceInputStream.readString(2, false);
        this.title = jceInputStream.readString(3, false);
        this.show_txt = jceInputStream.readString(4, false);
        this.show_desc = jceInputStream.readString(5, false);
        this.pic_url = jceInputStream.readString(6, false);
        this.pic_width = jceInputStream.read(this.pic_width, 7, false);
        this.pic_height = jceInputStream.read(this.pic_height, 8, false);
        this.count_desc = jceInputStream.readString(9, false);
        this.join_list = (s_join_list) jceInputStream.read((JceStruct) cache_join_list, 10, false);
        this.is_default = jceInputStream.read(this.is_default, 11, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 12, false);
        this.view_count = jceInputStream.read(this.view_count, 13, false);
        this.backgd_picurl = jceInputStream.readString(14, false);
        this.update_flag = jceInputStream.read(this.update_flag, 15, false);
        this.star = (famous_user) jceInputStream.read((JceStruct) cache_star, 16, false);
        this.fans_list = (ArrayList) jceInputStream.read((JceInputStream) cache_fans_list, 17, false);
        this.is_star = jceInputStream.read(this.is_star, 18, false);
        this.view_str = jceInputStream.readString(19, false);
        this.status = jceInputStream.read(this.status, 20, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.time, 1);
        String str = this.f24992id;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.title;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.show_txt;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.show_desc;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.pic_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        jceOutputStream.write(this.pic_width, 7);
        jceOutputStream.write(this.pic_height, 8);
        String str6 = this.count_desc;
        if (str6 != null) {
            jceOutputStream.write(str6, 9);
        }
        s_join_list s_join_listVar = this.join_list;
        if (s_join_listVar != null) {
            jceOutputStream.write((JceStruct) s_join_listVar, 10);
        }
        jceOutputStream.write(this.is_default, 11);
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 12);
        }
        jceOutputStream.write(this.view_count, 13);
        String str7 = this.backgd_picurl;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
        }
        jceOutputStream.write(this.update_flag, 15);
        famous_user famous_userVar = this.star;
        if (famous_userVar != null) {
            jceOutputStream.write((JceStruct) famous_userVar, 16);
        }
        ArrayList<famous_user> arrayList = this.fans_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 17);
        }
        jceOutputStream.write(this.is_star, 18);
        String str8 = this.view_str;
        if (str8 != null) {
            jceOutputStream.write(str8, 19);
        }
        jceOutputStream.write(this.status, 20);
    }

    public s_event_tag(long j3, long j16, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, s_join_list s_join_listVar, boolean z16, Map<String, String> map, long j17, String str7, boolean z17, famous_user famous_userVar, ArrayList<famous_user> arrayList, boolean z18, String str8, int i17) {
        this.uin = j3;
        this.time = j16;
        this.f24992id = str;
        this.title = str2;
        this.show_txt = str3;
        this.show_desc = str4;
        this.pic_url = str5;
        this.pic_width = i3;
        this.pic_height = i16;
        this.count_desc = str6;
        this.join_list = s_join_listVar;
        this.is_default = z16;
        this.extendInfo = map;
        this.view_count = j17;
        this.backgd_picurl = str7;
        this.update_flag = z17;
        this.star = famous_userVar;
        this.fans_list = arrayList;
        this.is_star = z18;
        this.view_str = str8;
        this.status = i17;
    }
}
