package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_main_page extends JceStruct {
    public String addblack_msg;
    public String family_des;
    public String family_url;
    public String family_url_traceinfo;
    public long follow_flag;
    public int frd_num;
    public String info_askfor_friend;
    public int is_askfor_friend;
    public int is_black;
    public int is_both_friend;
    public boolean is_concerned;
    public boolean is_family_open;
    public boolean is_flower_switch_open;
    public int is_friend;
    public int is_host_gray_follow_usr;
    public int is_host_gray_tongcheng_usr;
    public int is_in_visitor_notify_list;
    public int is_open_follow;
    public boolean is_readspace_followed;
    public int is_realname;
    public int is_recipient_yellow_banner;
    public int is_reverse_black;
    public int is_special;
    public boolean is_special_concerned;
    public int is_uncare;
    public int is_visitor_gray_follow_usr;
    public int is_visitor_gray_tongcheng_usr;

    /* renamed from: msg, reason: collision with root package name */
    public String f25007msg;
    public Map<Integer, String> prompt_msg;
    public s_question question;
    public int relation;
    public int visit_right;
    static s_question cache_question = new s_question();
    static Map<Integer, String> cache_prompt_msg = new HashMap();

    static {
        cache_prompt_msg.put(0, "");
    }

    public s_main_page() {
        this.relation = 0;
        this.is_askfor_friend = 0;
        this.info_askfor_friend = "";
        this.is_special = 0;
        this.question = null;
        this.f25007msg = "";
        this.is_concerned = true;
        this.is_black = 0;
        this.is_uncare = 0;
        this.is_realname = 0;
        this.addblack_msg = "";
        this.prompt_msg = null;
        this.is_readspace_followed = true;
        this.is_both_friend = 0;
        this.is_reverse_black = 0;
        this.visit_right = 0;
        this.is_recipient_yellow_banner = 0;
        this.is_in_visitor_notify_list = 0;
        this.is_friend = 0;
        this.is_open_follow = 0;
        this.is_visitor_gray_follow_usr = 0;
        this.is_host_gray_follow_usr = 0;
        this.is_visitor_gray_tongcheng_usr = 0;
        this.is_host_gray_tongcheng_usr = 0;
        this.is_special_concerned = false;
        this.follow_flag = 0L;
        this.is_flower_switch_open = false;
        this.is_family_open = false;
        this.family_url = "";
        this.frd_num = 0;
        this.family_des = "";
        this.family_url_traceinfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.relation = jceInputStream.read(this.relation, 0, false);
        this.is_askfor_friend = jceInputStream.read(this.is_askfor_friend, 1, false);
        this.info_askfor_friend = jceInputStream.readString(2, false);
        this.is_special = jceInputStream.read(this.is_special, 3, false);
        this.question = (s_question) jceInputStream.read((JceStruct) cache_question, 4, false);
        this.f25007msg = jceInputStream.readString(5, false);
        this.is_concerned = jceInputStream.read(this.is_concerned, 6, false);
        this.is_black = jceInputStream.read(this.is_black, 7, false);
        this.is_uncare = jceInputStream.read(this.is_uncare, 8, false);
        this.is_realname = jceInputStream.read(this.is_realname, 9, false);
        this.addblack_msg = jceInputStream.readString(10, false);
        this.prompt_msg = (Map) jceInputStream.read((JceInputStream) cache_prompt_msg, 11, false);
        this.is_readspace_followed = jceInputStream.read(this.is_readspace_followed, 12, false);
        this.is_both_friend = jceInputStream.read(this.is_both_friend, 13, false);
        this.is_reverse_black = jceInputStream.read(this.is_reverse_black, 14, false);
        this.visit_right = jceInputStream.read(this.visit_right, 15, false);
        this.is_recipient_yellow_banner = jceInputStream.read(this.is_recipient_yellow_banner, 16, false);
        this.is_in_visitor_notify_list = jceInputStream.read(this.is_in_visitor_notify_list, 17, false);
        this.is_friend = jceInputStream.read(this.is_friend, 18, false);
        this.is_open_follow = jceInputStream.read(this.is_open_follow, 19, false);
        this.is_visitor_gray_follow_usr = jceInputStream.read(this.is_visitor_gray_follow_usr, 20, false);
        this.is_host_gray_follow_usr = jceInputStream.read(this.is_host_gray_follow_usr, 21, false);
        this.is_visitor_gray_tongcheng_usr = jceInputStream.read(this.is_visitor_gray_tongcheng_usr, 22, false);
        this.is_host_gray_tongcheng_usr = jceInputStream.read(this.is_host_gray_tongcheng_usr, 23, false);
        this.is_special_concerned = jceInputStream.read(this.is_special_concerned, 24, false);
        this.follow_flag = jceInputStream.read(this.follow_flag, 25, false);
        this.is_flower_switch_open = jceInputStream.read(this.is_flower_switch_open, 26, false);
        this.is_family_open = jceInputStream.read(this.is_family_open, 27, false);
        this.family_url = jceInputStream.readString(28, false);
        this.frd_num = jceInputStream.read(this.frd_num, 29, false);
        this.family_des = jceInputStream.readString(30, false);
        this.family_url_traceinfo = jceInputStream.readString(31, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.relation, 0);
        jceOutputStream.write(this.is_askfor_friend, 1);
        String str = this.info_askfor_friend;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.is_special, 3);
        s_question s_questionVar = this.question;
        if (s_questionVar != null) {
            jceOutputStream.write((JceStruct) s_questionVar, 4);
        }
        String str2 = this.f25007msg;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.is_concerned, 6);
        jceOutputStream.write(this.is_black, 7);
        jceOutputStream.write(this.is_uncare, 8);
        jceOutputStream.write(this.is_realname, 9);
        String str3 = this.addblack_msg;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        Map<Integer, String> map = this.prompt_msg;
        if (map != null) {
            jceOutputStream.write((Map) map, 11);
        }
        jceOutputStream.write(this.is_readspace_followed, 12);
        jceOutputStream.write(this.is_both_friend, 13);
        jceOutputStream.write(this.is_reverse_black, 14);
        jceOutputStream.write(this.visit_right, 15);
        jceOutputStream.write(this.is_recipient_yellow_banner, 16);
        jceOutputStream.write(this.is_in_visitor_notify_list, 17);
        jceOutputStream.write(this.is_friend, 18);
        jceOutputStream.write(this.is_open_follow, 19);
        jceOutputStream.write(this.is_visitor_gray_follow_usr, 20);
        jceOutputStream.write(this.is_host_gray_follow_usr, 21);
        jceOutputStream.write(this.is_visitor_gray_tongcheng_usr, 22);
        jceOutputStream.write(this.is_host_gray_tongcheng_usr, 23);
        jceOutputStream.write(this.is_special_concerned, 24);
        jceOutputStream.write(this.follow_flag, 25);
        jceOutputStream.write(this.is_flower_switch_open, 26);
        jceOutputStream.write(this.is_family_open, 27);
        String str4 = this.family_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 28);
        }
        jceOutputStream.write(this.frd_num, 29);
        String str5 = this.family_des;
        if (str5 != null) {
            jceOutputStream.write(str5, 30);
        }
        String str6 = this.family_url_traceinfo;
        if (str6 != null) {
            jceOutputStream.write(str6, 31);
        }
    }

    public s_main_page(int i3, int i16, String str, int i17, s_question s_questionVar, String str2, boolean z16, int i18, int i19, int i26, String str3, Map<Integer, String> map, boolean z17, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46, int i47, int i48, int i49, boolean z18, long j3, boolean z19, boolean z26, String str4, int i56, String str5, String str6) {
        this.relation = i3;
        this.is_askfor_friend = i16;
        this.info_askfor_friend = str;
        this.is_special = i17;
        this.question = s_questionVar;
        this.f25007msg = str2;
        this.is_concerned = z16;
        this.is_black = i18;
        this.is_uncare = i19;
        this.is_realname = i26;
        this.addblack_msg = str3;
        this.prompt_msg = map;
        this.is_readspace_followed = z17;
        this.is_both_friend = i27;
        this.is_reverse_black = i28;
        this.visit_right = i29;
        this.is_recipient_yellow_banner = i36;
        this.is_in_visitor_notify_list = i37;
        this.is_friend = i38;
        this.is_open_follow = i39;
        this.is_visitor_gray_follow_usr = i46;
        this.is_host_gray_follow_usr = i47;
        this.is_visitor_gray_tongcheng_usr = i48;
        this.is_host_gray_tongcheng_usr = i49;
        this.is_special_concerned = z18;
        this.follow_flag = j3;
        this.is_flower_switch_open = z19;
        this.is_family_open = z26;
        this.family_url = str4;
        this.frd_num = i56;
        this.family_des = str5;
        this.family_url_traceinfo = str6;
    }
}
