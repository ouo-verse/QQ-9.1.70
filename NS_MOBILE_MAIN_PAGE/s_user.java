package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_user extends JceStruct {
    public String answer;
    public int appid;
    public String birthday_time;
    public int comm_friend_num;
    public String dateval;
    public long fans_num;
    public String fans_num_express;
    public int from;
    public boolean isFamousQzone;
    public int is_annual_vip;
    public boolean is_concerned;
    public boolean is_in_fromhidelist;
    public boolean is_in_hidelist;
    public int is_isolate_user;
    public boolean is_lunar;
    public boolean is_new_birthday_friend;
    public boolean is_new_visitor;
    public boolean is_qq_friend;
    public boolean is_send;
    public String nickname;
    public String profile_url;
    public String question;
    public String reason;
    public byte relat_days;
    public String ugc_content_id;
    public long uin;
    public String uinkey;
    public int vip_flag;
    public int vip_level;
    public String visit_info;
    public String visit_info_content;
    public String visit_info_prefix;
    public byte visit_mod;
    public long vtime;

    public s_user() {
        this.nickname = "";
        this.uinkey = "";
        this.dateval = "";
        this.is_send = true;
        this.profile_url = "";
        this.is_lunar = true;
        this.birthday_time = "";
        this.question = "";
        this.answer = "";
        this.is_qq_friend = true;
        this.visit_info = "";
        this.is_new_visitor = true;
        this.isFamousQzone = true;
        this.fans_num_express = "";
        this.is_concerned = true;
        this.reason = "";
        this.ugc_content_id = "";
        this.visit_info_prefix = "";
        this.visit_info_content = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.nickname = jceInputStream.readString(1, false);
        this.from = jceInputStream.read(this.from, 2, false);
        this.vtime = jceInputStream.read(this.vtime, 3, false);
        this.uinkey = jceInputStream.readString(4, false);
        this.dateval = jceInputStream.readString(5, false);
        this.is_send = jceInputStream.read(this.is_send, 6, false);
        this.comm_friend_num = jceInputStream.read(this.comm_friend_num, 7, false);
        this.profile_url = jceInputStream.readString(8, false);
        this.is_lunar = jceInputStream.read(this.is_lunar, 9, false);
        this.birthday_time = jceInputStream.readString(10, false);
        this.question = jceInputStream.readString(11, false);
        this.answer = jceInputStream.readString(12, false);
        this.is_qq_friend = jceInputStream.read(this.is_qq_friend, 13, false);
        this.visit_info = jceInputStream.readString(14, false);
        this.is_new_visitor = jceInputStream.read(this.is_new_visitor, 15, false);
        this.isFamousQzone = jceInputStream.read(this.isFamousQzone, 16, false);
        this.fans_num = jceInputStream.read(this.fans_num, 17, false);
        this.fans_num_express = jceInputStream.readString(18, false);
        this.is_concerned = jceInputStream.read(this.is_concerned, 19, false);
        this.visit_mod = jceInputStream.read(this.visit_mod, 20, false);
        this.reason = jceInputStream.readString(21, false);
        this.is_new_birthday_friend = jceInputStream.read(this.is_new_birthday_friend, 22, false);
        this.relat_days = jceInputStream.read(this.relat_days, 23, false);
        this.appid = jceInputStream.read(this.appid, 24, false);
        this.ugc_content_id = jceInputStream.readString(25, false);
        this.visit_info_prefix = jceInputStream.readString(26, false);
        this.visit_info_content = jceInputStream.readString(27, false);
        this.is_in_hidelist = jceInputStream.read(this.is_in_hidelist, 28, false);
        this.is_in_fromhidelist = jceInputStream.read(this.is_in_fromhidelist, 29, false);
        this.vip_flag = jceInputStream.read(this.vip_flag, 30, false);
        this.vip_level = jceInputStream.read(this.vip_level, 31, false);
        this.is_annual_vip = jceInputStream.read(this.is_annual_vip, 32, false);
        this.is_isolate_user = jceInputStream.read(this.is_isolate_user, 33, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.from, 2);
        jceOutputStream.write(this.vtime, 3);
        String str2 = this.uinkey;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.dateval;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        jceOutputStream.write(this.is_send, 6);
        jceOutputStream.write(this.comm_friend_num, 7);
        String str4 = this.profile_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        jceOutputStream.write(this.is_lunar, 9);
        String str5 = this.birthday_time;
        if (str5 != null) {
            jceOutputStream.write(str5, 10);
        }
        String str6 = this.question;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
        String str7 = this.answer;
        if (str7 != null) {
            jceOutputStream.write(str7, 12);
        }
        jceOutputStream.write(this.is_qq_friend, 13);
        String str8 = this.visit_info;
        if (str8 != null) {
            jceOutputStream.write(str8, 14);
        }
        jceOutputStream.write(this.is_new_visitor, 15);
        jceOutputStream.write(this.isFamousQzone, 16);
        jceOutputStream.write(this.fans_num, 17);
        String str9 = this.fans_num_express;
        if (str9 != null) {
            jceOutputStream.write(str9, 18);
        }
        jceOutputStream.write(this.is_concerned, 19);
        jceOutputStream.write(this.visit_mod, 20);
        String str10 = this.reason;
        if (str10 != null) {
            jceOutputStream.write(str10, 21);
        }
        jceOutputStream.write(this.is_new_birthday_friend, 22);
        jceOutputStream.write(this.relat_days, 23);
        jceOutputStream.write(this.appid, 24);
        String str11 = this.ugc_content_id;
        if (str11 != null) {
            jceOutputStream.write(str11, 25);
        }
        String str12 = this.visit_info_prefix;
        if (str12 != null) {
            jceOutputStream.write(str12, 26);
        }
        String str13 = this.visit_info_content;
        if (str13 != null) {
            jceOutputStream.write(str13, 27);
        }
        jceOutputStream.write(this.is_in_hidelist, 28);
        jceOutputStream.write(this.is_in_fromhidelist, 29);
        jceOutputStream.write(this.vip_flag, 30);
        jceOutputStream.write(this.vip_level, 31);
        jceOutputStream.write(this.is_annual_vip, 32);
        jceOutputStream.write(this.is_isolate_user, 33);
    }

    public s_user(long j3, String str, int i3, long j16, String str2, String str3, boolean z16, int i16, String str4, boolean z17, String str5, String str6, String str7, boolean z18, String str8, boolean z19, boolean z26, long j17, String str9, boolean z27, byte b16, String str10, boolean z28, byte b17, int i17, String str11, String str12, String str13, boolean z29, boolean z36, int i18, int i19, int i26, int i27) {
        this.uin = j3;
        this.nickname = str;
        this.from = i3;
        this.vtime = j16;
        this.uinkey = str2;
        this.dateval = str3;
        this.is_send = z16;
        this.comm_friend_num = i16;
        this.profile_url = str4;
        this.is_lunar = z17;
        this.birthday_time = str5;
        this.question = str6;
        this.answer = str7;
        this.is_qq_friend = z18;
        this.visit_info = str8;
        this.is_new_visitor = z19;
        this.isFamousQzone = z26;
        this.fans_num = j17;
        this.fans_num_express = str9;
        this.is_concerned = z27;
        this.visit_mod = b16;
        this.reason = str10;
        this.is_new_birthday_friend = z28;
        this.relat_days = b17;
        this.appid = i17;
        this.ugc_content_id = str11;
        this.visit_info_prefix = str12;
        this.visit_info_content = str13;
        this.is_in_hidelist = z29;
        this.is_in_fromhidelist = z36;
        this.vip_flag = i18;
        this.vip_level = i19;
        this.is_annual_vip = i26;
        this.is_isolate_user = i27;
    }
}
