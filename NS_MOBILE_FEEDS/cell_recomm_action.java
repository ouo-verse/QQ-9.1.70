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
public final class cell_recomm_action extends JceStruct {
    static Map<Integer, String> cache_extend_info;
    static s_button cache_left_bottom_button;
    static ArrayList<s_user> cache_relation_chain;
    static s_rank cache_s_app_rank = new s_rank();
    static ArrayList<s_user> cache_userlist = new ArrayList<>();
    public int actiontype;
    public String add_group_url;
    public int adv_pos;
    public int allcount;
    public String alternate_ad_identification;
    public int btn_type;
    public int button_actiontype;
    public int button_style;
    public String button_text;
    public String button_url;
    public String channel;
    public int count_down_timer;
    public String currency_pass_field;
    public int dest_type;
    public String dest_url;
    public int detail_actiontype;
    public String detail_text;
    public String detail_url;
    public Map<Integer, String> extend_info;
    public String installed_buttontxt;
    public String interact_left_text;
    public int is_hide_action_area;
    public int is_report;
    public s_button left_bottom_button;
    public int multi_adv_offset;
    public int product_type;
    public long productid;
    public ArrayList<s_user> relation_chain;
    public int relation_total_number;
    public String remark;
    public String report_url;

    /* renamed from: rl, reason: collision with root package name */
    public String f24985rl;
    public s_rank s_app_rank;
    public int style;
    public int templ_layout;
    public String tips_icon;
    public ArrayList<s_user> userlist;
    public String via;

    static {
        cache_userlist.add(new s_user());
        cache_relation_chain = new ArrayList<>();
        cache_relation_chain.add(new s_user());
        cache_extend_info = new HashMap();
        cache_extend_info.put(0, "");
        cache_left_bottom_button = new s_button();
    }

    public cell_recomm_action() {
        this.s_app_rank = null;
        this.remark = "";
        this.userlist = null;
        this.actiontype = 0;
        this.btn_type = 0;
        this.is_hide_action_area = 0;
        this.is_report = 0;
        this.report_url = "";
        this.allcount = 0;
        this.button_text = "";
        this.button_actiontype = 0;
        this.button_url = "";
        this.button_style = 0;
        this.detail_text = "";
        this.detail_actiontype = 0;
        this.detail_url = "";
        this.tips_icon = "";
        this.adv_pos = 0;
        this.multi_adv_offset = 0;
        this.interact_left_text = "";
        this.installed_buttontxt = "";
        this.alternate_ad_identification = "";
        this.relation_chain = null;
        this.relation_total_number = 0;
        this.extend_info = null;
        this.left_bottom_button = null;
        this.currency_pass_field = "";
        this.via = "";
        this.channel = "";
        this.productid = 0L;
        this.templ_layout = 0;
        this.dest_type = 0;
        this.product_type = 0;
        this.dest_url = "";
        this.f24985rl = "";
        this.style = 0;
        this.add_group_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.s_app_rank = (s_rank) jceInputStream.read((JceStruct) cache_s_app_rank, 0, false);
        this.remark = jceInputStream.readString(1, false);
        this.userlist = (ArrayList) jceInputStream.read((JceInputStream) cache_userlist, 2, false);
        this.actiontype = jceInputStream.read(this.actiontype, 3, false);
        this.btn_type = jceInputStream.read(this.btn_type, 4, false);
        this.is_hide_action_area = jceInputStream.read(this.is_hide_action_area, 5, false);
        this.is_report = jceInputStream.read(this.is_report, 6, false);
        this.report_url = jceInputStream.readString(7, false);
        this.allcount = jceInputStream.read(this.allcount, 8, false);
        this.button_text = jceInputStream.readString(9, false);
        this.button_actiontype = jceInputStream.read(this.button_actiontype, 10, false);
        this.button_url = jceInputStream.readString(11, false);
        this.button_style = jceInputStream.read(this.button_style, 12, false);
        this.detail_text = jceInputStream.readString(13, false);
        this.detail_actiontype = jceInputStream.read(this.detail_actiontype, 14, false);
        this.detail_url = jceInputStream.readString(15, false);
        this.tips_icon = jceInputStream.readString(17, false);
        this.adv_pos = jceInputStream.read(this.adv_pos, 18, false);
        this.multi_adv_offset = jceInputStream.read(this.multi_adv_offset, 19, false);
        this.interact_left_text = jceInputStream.readString(20, false);
        this.installed_buttontxt = jceInputStream.readString(21, false);
        this.alternate_ad_identification = jceInputStream.readString(22, false);
        this.relation_chain = (ArrayList) jceInputStream.read((JceInputStream) cache_relation_chain, 23, false);
        this.relation_total_number = jceInputStream.read(this.relation_total_number, 24, false);
        this.count_down_timer = jceInputStream.read(this.count_down_timer, 25, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 26, false);
        this.left_bottom_button = (s_button) jceInputStream.read((JceStruct) cache_left_bottom_button, 28, false);
        this.currency_pass_field = jceInputStream.readString(29, false);
        this.via = jceInputStream.readString(30, false);
        this.channel = jceInputStream.readString(31, false);
        this.productid = jceInputStream.read(this.productid, 32, false);
        this.templ_layout = jceInputStream.read(this.templ_layout, 33, false);
        this.dest_type = jceInputStream.read(this.dest_type, 34, false);
        this.product_type = jceInputStream.read(this.product_type, 35, false);
        this.dest_url = jceInputStream.read(this.dest_url, 36, false);
        this.f24985rl = jceInputStream.read(this.f24985rl, 37, false);
        this.style = jceInputStream.read(this.style, 38, false);
        this.add_group_url = jceInputStream.read(this.add_group_url, 39, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_rank s_rankVar = this.s_app_rank;
        if (s_rankVar != null) {
            jceOutputStream.write((JceStruct) s_rankVar, 0);
        }
        String str = this.remark;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<s_user> arrayList = this.userlist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.actiontype, 3);
        jceOutputStream.write(this.btn_type, 4);
        jceOutputStream.write(this.is_hide_action_area, 5);
        jceOutputStream.write(this.is_report, 6);
        String str2 = this.report_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        jceOutputStream.write(this.allcount, 8);
        String str3 = this.button_text;
        if (str3 != null) {
            jceOutputStream.write(str3, 9);
        }
        jceOutputStream.write(this.button_actiontype, 10);
        String str4 = this.button_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 11);
        }
        jceOutputStream.write(this.button_style, 12);
        String str5 = this.detail_text;
        if (str5 != null) {
            jceOutputStream.write(str5, 13);
        }
        jceOutputStream.write(this.detail_actiontype, 14);
        String str6 = this.detail_url;
        if (str6 != null) {
            jceOutputStream.write(str6, 15);
        }
        String str7 = this.tips_icon;
        if (str7 != null) {
            jceOutputStream.write(str7, 17);
        }
        jceOutputStream.write(this.adv_pos, 18);
        jceOutputStream.write(this.multi_adv_offset, 19);
        String str8 = this.interact_left_text;
        if (str8 != null) {
            jceOutputStream.write(str8, 20);
        }
        String str9 = this.installed_buttontxt;
        if (str9 != null) {
            jceOutputStream.write(str9, 21);
        }
        String str10 = this.alternate_ad_identification;
        if (str10 != null) {
            jceOutputStream.write(str10, 22);
        }
        ArrayList<s_user> arrayList2 = this.relation_chain;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 23);
        }
        jceOutputStream.write(this.relation_total_number, 24);
        jceOutputStream.write(this.count_down_timer, 25);
        Map<Integer, String> map = this.extend_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 26);
        }
        s_button s_buttonVar = this.left_bottom_button;
        if (s_buttonVar != null) {
            jceOutputStream.write((JceStruct) s_buttonVar, 28);
        }
        String str11 = this.currency_pass_field;
        if (str11 != null) {
            jceOutputStream.write(str11, 29);
        }
        String str12 = this.via;
        if (str12 != null) {
            jceOutputStream.write(str12, 30);
        }
        String str13 = this.channel;
        if (str13 != null) {
            jceOutputStream.write(str13, 31);
        }
        jceOutputStream.write(this.productid, 32);
        jceOutputStream.write(this.templ_layout, 33);
        jceOutputStream.write(this.dest_type, 34);
        jceOutputStream.write(this.product_type, 35);
        String str14 = this.dest_url;
        if (str14 != null) {
            jceOutputStream.write(str14, 36);
        }
        String str15 = this.f24985rl;
        if (str15 != null) {
            jceOutputStream.write(str15, 37);
        }
        jceOutputStream.write(this.style, 38);
        String str16 = this.add_group_url;
        if (str16 != null) {
            jceOutputStream.write(str16, 39);
        }
    }

    public cell_recomm_action(s_rank s_rankVar, String str, ArrayList<s_user> arrayList, int i3, int i16, int i17, int i18, String str2, int i19, String str3, int i26, String str4, int i27, String str5, int i28, String str6, String str7, int i29, int i36, String str8, String str9, String str10, ArrayList<s_user> arrayList2, int i37, int i38, Map<Integer, String> map, s_button s_buttonVar, String str11, String str12, String str13, long j3, int i39, int i46, int i47, String str14, String str15, int i48, String str16) {
        this.s_app_rank = s_rankVar;
        this.remark = str;
        this.userlist = arrayList;
        this.actiontype = i3;
        this.btn_type = i16;
        this.is_hide_action_area = i17;
        this.is_report = i18;
        this.report_url = str2;
        this.allcount = i19;
        this.button_text = str3;
        this.button_actiontype = i26;
        this.button_url = str4;
        this.button_style = i27;
        this.detail_text = str5;
        this.detail_actiontype = i28;
        this.detail_url = str6;
        this.tips_icon = str7;
        this.adv_pos = i29;
        this.multi_adv_offset = i36;
        this.interact_left_text = str8;
        this.installed_buttontxt = str9;
        this.alternate_ad_identification = str10;
        this.relation_chain = arrayList2;
        this.relation_total_number = i37;
        this.count_down_timer = i38;
        this.extend_info = map;
        this.left_bottom_button = s_buttonVar;
        this.currency_pass_field = str11;
        this.via = str12;
        this.channel = str13;
        this.productid = j3;
        this.templ_layout = i39;
        this.dest_type = i46;
        this.product_type = i47;
        this.dest_url = str14;
        this.f24985rl = str15;
        this.style = i48;
        this.add_group_url = str16;
    }
}
