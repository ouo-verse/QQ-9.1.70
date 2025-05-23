package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_profile extends JceStruct {
    static byte[] cache_QzmallProfileDecoGetRsp;
    public byte[] QzmallProfileDecoGetRsp;
    public byte age;
    public String astro;
    public String authinfo;
    public int birthday;
    public int brand_flag;
    public String city;
    public String country;
    public int fans_limit;
    public long fans_num;
    public String fans_num_express;
    public int follow_num;
    public byte gender;
    public byte isAnnualVip;
    public boolean isFamousQzone;
    public boolean is_famouse_custom_homepage_white;
    public boolean is_readspace;
    public boolean is_sweet_user;
    public int nameplate_flag;
    public String nick;
    public String nickname;
    public String province;
    public int qzone_right_flag;
    public String qzonename;
    public String readspace_picurl;
    public boolean show_menu_panel;
    public String space_desc;
    public int sqqlevel;
    public String strvipoverday;
    public combine_diamond_info stuCombineDiamondInfo;
    public star_info stuStarInfo;
    public long uin;
    public int user_type;
    public byte vip;
    public int vip_keepdays;
    public int vipexpiretime;
    public int viplevel;
    public int vipratio;
    public int vipscore;
    public int vipspeed;
    public int viptype;
    public String vipurl;
    public String weishi_schema;
    static star_info cache_stuStarInfo = new star_info();
    static combine_diamond_info cache_stuCombineDiamondInfo = new combine_diamond_info();

    static {
        cache_QzmallProfileDecoGetRsp = r0;
        byte[] bArr = {0};
    }

    public s_profile() {
        this.uin = 0L;
        this.nickname = "";
        this.qzonename = "";
        this.vip = (byte) 0;
        this.gender = (byte) 0;
        this.age = (byte) 0;
        this.birthday = 0;
        this.astro = "";
        this.country = "";
        this.province = "";
        this.city = "";
        this.viplevel = 0;
        this.sqqlevel = 0;
        this.isFamousQzone = true;
        this.fans_num = 0L;
        this.fans_num_express = "";
        this.viptype = 0;
        this.nick = "";
        this.is_readspace = true;
        this.authinfo = "";
        this.vipscore = 0;
        this.vipspeed = 0;
        this.vipratio = 0;
        this.vipexpiretime = 0;
        this.strvipoverday = "";
        this.readspace_picurl = "";
        this.qzone_right_flag = 0;
        this.is_famouse_custom_homepage_white = true;
        this.isAnnualVip = (byte) 0;
        this.is_sweet_user = false;
        this.stuStarInfo = null;
        this.stuCombineDiamondInfo = null;
        this.nameplate_flag = 0;
        this.QzmallProfileDecoGetRsp = null;
        this.user_type = 0;
        this.vipurl = "";
        this.follow_num = 0;
        this.show_menu_panel = true;
        this.fans_limit = 0;
        this.brand_flag = 0;
        this.space_desc = "";
        this.weishi_schema = "";
        this.vip_keepdays = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.nickname = jceInputStream.readString(1, false);
        this.qzonename = jceInputStream.readString(2, false);
        this.vip = jceInputStream.read(this.vip, 3, false);
        this.gender = jceInputStream.read(this.gender, 4, false);
        this.age = jceInputStream.read(this.age, 5, false);
        this.birthday = jceInputStream.read(this.birthday, 6, false);
        this.astro = jceInputStream.readString(7, false);
        this.country = jceInputStream.readString(8, false);
        this.province = jceInputStream.readString(9, false);
        this.city = jceInputStream.readString(10, false);
        this.viplevel = jceInputStream.read(this.viplevel, 11, false);
        this.sqqlevel = jceInputStream.read(this.sqqlevel, 12, false);
        this.isFamousQzone = jceInputStream.read(this.isFamousQzone, 13, false);
        this.fans_num = jceInputStream.read(this.fans_num, 14, false);
        this.fans_num_express = jceInputStream.readString(15, false);
        this.viptype = jceInputStream.read(this.viptype, 16, false);
        this.nick = jceInputStream.readString(17, false);
        this.is_readspace = jceInputStream.read(this.is_readspace, 18, false);
        this.authinfo = jceInputStream.readString(19, false);
        this.vipscore = jceInputStream.read(this.vipscore, 20, false);
        this.vipspeed = jceInputStream.read(this.vipspeed, 21, false);
        this.vipratio = jceInputStream.read(this.vipratio, 22, false);
        this.vipexpiretime = jceInputStream.read(this.vipexpiretime, 23, false);
        this.strvipoverday = jceInputStream.readString(24, false);
        this.readspace_picurl = jceInputStream.readString(25, false);
        this.qzone_right_flag = jceInputStream.read(this.qzone_right_flag, 26, false);
        this.is_famouse_custom_homepage_white = jceInputStream.read(this.is_famouse_custom_homepage_white, 27, false);
        this.isAnnualVip = jceInputStream.read(this.isAnnualVip, 28, false);
        this.is_sweet_user = jceInputStream.read(this.is_sweet_user, 29, false);
        this.stuStarInfo = (star_info) jceInputStream.read((JceStruct) cache_stuStarInfo, 30, false);
        this.stuCombineDiamondInfo = (combine_diamond_info) jceInputStream.read((JceStruct) cache_stuCombineDiamondInfo, 31, false);
        this.nameplate_flag = jceInputStream.read(this.nameplate_flag, 32, false);
        this.QzmallProfileDecoGetRsp = jceInputStream.read(cache_QzmallProfileDecoGetRsp, 33, false);
        this.user_type = jceInputStream.read(this.user_type, 34, false);
        this.vipurl = jceInputStream.readString(35, false);
        this.follow_num = jceInputStream.read(this.follow_num, 36, false);
        this.show_menu_panel = jceInputStream.read(this.show_menu_panel, 37, false);
        this.fans_limit = jceInputStream.read(this.fans_limit, 38, false);
        this.brand_flag = jceInputStream.read(this.brand_flag, 39, false);
        this.space_desc = jceInputStream.readString(40, false);
        this.weishi_schema = jceInputStream.readString(41, false);
        this.vip_keepdays = jceInputStream.read(this.vip_keepdays, 42, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.qzonename;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.vip, 3);
        jceOutputStream.write(this.gender, 4);
        jceOutputStream.write(this.age, 5);
        jceOutputStream.write(this.birthday, 6);
        String str3 = this.astro;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        String str4 = this.country;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        String str5 = this.province;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        String str6 = this.city;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        jceOutputStream.write(this.viplevel, 11);
        jceOutputStream.write(this.sqqlevel, 12);
        jceOutputStream.write(this.isFamousQzone, 13);
        jceOutputStream.write(this.fans_num, 14);
        String str7 = this.fans_num_express;
        if (str7 != null) {
            jceOutputStream.write(str7, 15);
        }
        jceOutputStream.write(this.viptype, 16);
        String str8 = this.nick;
        if (str8 != null) {
            jceOutputStream.write(str8, 17);
        }
        jceOutputStream.write(this.is_readspace, 18);
        String str9 = this.authinfo;
        if (str9 != null) {
            jceOutputStream.write(str9, 19);
        }
        jceOutputStream.write(this.vipscore, 20);
        jceOutputStream.write(this.vipspeed, 21);
        jceOutputStream.write(this.vipratio, 22);
        jceOutputStream.write(this.vipexpiretime, 23);
        String str10 = this.strvipoverday;
        if (str10 != null) {
            jceOutputStream.write(str10, 24);
        }
        String str11 = this.readspace_picurl;
        if (str11 != null) {
            jceOutputStream.write(str11, 25);
        }
        jceOutputStream.write(this.qzone_right_flag, 26);
        jceOutputStream.write(this.is_famouse_custom_homepage_white, 27);
        jceOutputStream.write(this.isAnnualVip, 28);
        jceOutputStream.write(this.is_sweet_user, 29);
        star_info star_infoVar = this.stuStarInfo;
        if (star_infoVar != null) {
            jceOutputStream.write((JceStruct) star_infoVar, 30);
        }
        combine_diamond_info combine_diamond_infoVar = this.stuCombineDiamondInfo;
        if (combine_diamond_infoVar != null) {
            jceOutputStream.write((JceStruct) combine_diamond_infoVar, 31);
        }
        jceOutputStream.write(this.nameplate_flag, 32);
        byte[] bArr = this.QzmallProfileDecoGetRsp;
        if (bArr != null) {
            jceOutputStream.write(bArr, 33);
        }
        jceOutputStream.write(this.user_type, 34);
        String str12 = this.vipurl;
        if (str12 != null) {
            jceOutputStream.write(str12, 35);
        }
        jceOutputStream.write(this.follow_num, 36);
        jceOutputStream.write(this.show_menu_panel, 37);
        jceOutputStream.write(this.fans_limit, 38);
        jceOutputStream.write(this.brand_flag, 39);
        String str13 = this.space_desc;
        if (str13 != null) {
            jceOutputStream.write(str13, 40);
        }
        String str14 = this.weishi_schema;
        if (str14 != null) {
            jceOutputStream.write(str14, 41);
        }
        jceOutputStream.write(this.vip_keepdays, 42);
    }

    public s_profile(long j3, String str, String str2, byte b16, byte b17, byte b18, int i3, String str3, String str4, String str5, String str6, int i16, int i17, boolean z16, long j16, String str7, int i18, String str8, boolean z17, String str9, int i19, int i26, int i27, int i28, String str10, String str11, int i29, boolean z18, byte b19, boolean z19, star_info star_infoVar, combine_diamond_info combine_diamond_infoVar, int i36, byte[] bArr, int i37, String str12, int i38, boolean z26, int i39, int i46, String str13, String str14, int i47) {
        this.uin = j3;
        this.nickname = str;
        this.qzonename = str2;
        this.vip = b16;
        this.gender = b17;
        this.age = b18;
        this.birthday = i3;
        this.astro = str3;
        this.country = str4;
        this.province = str5;
        this.city = str6;
        this.viplevel = i16;
        this.sqqlevel = i17;
        this.isFamousQzone = z16;
        this.fans_num = j16;
        this.fans_num_express = str7;
        this.viptype = i18;
        this.nick = str8;
        this.is_readspace = z17;
        this.authinfo = str9;
        this.vipscore = i19;
        this.vipspeed = i26;
        this.vipratio = i27;
        this.vipexpiretime = i28;
        this.strvipoverday = str10;
        this.readspace_picurl = str11;
        this.qzone_right_flag = i29;
        this.is_famouse_custom_homepage_white = z18;
        this.isAnnualVip = b19;
        this.is_sweet_user = z19;
        this.stuStarInfo = star_infoVar;
        this.stuCombineDiamondInfo = combine_diamond_infoVar;
        this.nameplate_flag = i36;
        this.QzmallProfileDecoGetRsp = bArr;
        this.user_type = i37;
        this.vipurl = str12;
        this.follow_num = i38;
        this.show_menu_panel = z26;
        this.fans_limit = i39;
        this.brand_flag = i46;
        this.space_desc = str13;
        this.weishi_schema = str14;
        this.vip_keepdays = i47;
    }
}
