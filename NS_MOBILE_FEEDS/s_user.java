package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_user extends JceStruct {
    static s_medal cache_authqzoneMedalInfo;
    static byte[] cache_decoration;
    static s_kuolie_info cache_kuoliestate;
    static s_medal cache_liveshowMedalInfo;
    static ArrayList<s_nameplate> cache_nameplateList;
    static s_openid_user cache_openid_users;
    static byte[] cache_tmall_deco;
    static ArrayList<String> cache_user_tags;
    public int actiontype;
    public String actionurl;
    public int age;
    public s_medal authqzoneMedalInfo;
    public String avatarRecomBar;
    public byte[] decoration;
    public String descicon;
    public int displayflag;
    public long eUserTypeReport;
    public int from;
    public int iCurUserType;
    public int iVipActType;
    public int icon_height;
    public int icon_width;
    public byte isAnnualVip;
    public int isCmtVerifyOpen;
    public int isFamousWhite;
    public int isPrivateMode;
    public int isQzoneUser;
    public byte isSafeModeUser;
    public byte isSetNickGlint;
    public int isSweetVip;
    public int isVideoCircleVUser;
    public int is_own;
    public int is_owner;
    public s_kuolie_info kuoliestate;
    public int level;
    public s_medal liveshowMedalInfo;
    public String logo;
    public s_medal medalInfo;
    public int namePlate;
    public ArrayList<s_nameplate> nameplateList;
    public String nickname;
    public s_openid_user openid_users;
    public int operation_mask;
    public int portrait_id;
    public String qzonedesc;
    public String qzonedesc_token;
    public byte sex;
    public String strPortraitId;
    public combine_diamond_info stuCombineDiamondInfo;
    public star_info stuStarInfo;
    public ArrayList<s_yytag> tagInfos;
    public String talk_id;
    public int timestamp;
    public byte[] tmall_deco;
    public long uFansCount;
    public long uFeedsCount;
    public long uVisitorCount;
    public String uid;
    public long uin;
    public String uinkey;
    public String under_nickname_desc;
    public ArrayList<String> user_tags;
    public int vip;
    public byte vipShowType;
    public int viplevel;
    public int viptype;
    public long vtime;
    static s_medal cache_medalInfo = new s_medal();
    static star_info cache_stuStarInfo = new star_info();
    static combine_diamond_info cache_stuCombineDiamondInfo = new combine_diamond_info();
    static ArrayList<s_yytag> cache_tagInfos = new ArrayList<>();

    static {
        cache_decoration = r1;
        byte[] bArr = {0};
        cache_tagInfos.add(new s_yytag());
        cache_liveshowMedalInfo = new s_medal();
        cache_authqzoneMedalInfo = new s_medal();
        cache_openid_users = new s_openid_user();
        cache_kuoliestate = new s_kuolie_info();
        ArrayList<String> arrayList = new ArrayList<>();
        cache_user_tags = arrayList;
        arrayList.add("");
        cache_nameplateList = new ArrayList<>();
        cache_nameplateList.add(new s_nameplate());
        cache_tmall_deco = r0;
        byte[] bArr2 = {0};
    }

    public s_user() {
        this.uin = 0L;
        this.nickname = "";
        this.timestamp = 0;
        this.from = 1;
        this.uinkey = "";
        this.logo = "";
        this.vip = 0;
        this.level = 0;
        this.viplevel = 0;
        this.viptype = 0;
        this.qzonedesc = "";
        this.is_owner = 0;
        this.operation_mask = 0;
        this.uid = "";
        this.talk_id = "";
        this.portrait_id = 0;
        this.is_own = 0;
        this.isFamousWhite = 0;
        this.isQzoneUser = 0;
        this.isAnnualVip = (byte) 0;
        this.isSetNickGlint = (byte) 0;
        this.medalInfo = null;
        this.descicon = "";
        this.icon_width = 0;
        this.icon_height = 0;
        this.isSweetVip = 0;
        this.stuStarInfo = null;
        this.stuCombineDiamondInfo = null;
        this.isSafeModeUser = (byte) 0;
        this.vipShowType = (byte) -1;
        this.namePlate = 0;
        this.actiontype = 0;
        this.actionurl = "";
        this.decoration = null;
        this.tagInfos = null;
        this.strPortraitId = "";
        this.under_nickname_desc = "";
        this.liveshowMedalInfo = null;
        this.uFansCount = 0L;
        this.uVisitorCount = 0L;
        this.isCmtVerifyOpen = 0;
        this.iCurUserType = 0;
        this.displayflag = 0;
        this.vtime = 0L;
        this.authqzoneMedalInfo = null;
        this.eUserTypeReport = 0L;
        this.iVipActType = 0;
        this.openid_users = null;
        this.sex = (byte) 0;
        this.kuoliestate = null;
        this.isPrivateMode = 0;
        this.avatarRecomBar = "";
        this.user_tags = null;
        this.age = 0;
        this.isVideoCircleVUser = 0;
        this.uFeedsCount = 0L;
        this.qzonedesc_token = "";
        this.nameplateList = null;
        this.tmall_deco = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.nickname = jceInputStream.readString(1, false);
        this.timestamp = jceInputStream.read(this.timestamp, 2, false);
        this.from = jceInputStream.read(this.from, 3, false);
        this.uinkey = jceInputStream.readString(4, false);
        this.logo = jceInputStream.readString(5, false);
        this.vip = jceInputStream.read(this.vip, 6, false);
        this.level = jceInputStream.read(this.level, 7, false);
        this.viplevel = jceInputStream.read(this.viplevel, 8, false);
        this.viptype = jceInputStream.read(this.viptype, 9, false);
        this.qzonedesc = jceInputStream.readString(10, false);
        this.is_owner = jceInputStream.read(this.is_owner, 11, false);
        this.operation_mask = jceInputStream.read(this.operation_mask, 12, false);
        this.uid = jceInputStream.readString(13, false);
        this.talk_id = jceInputStream.readString(14, false);
        this.portrait_id = jceInputStream.read(this.portrait_id, 15, false);
        this.is_own = jceInputStream.read(this.is_own, 16, false);
        this.isFamousWhite = jceInputStream.read(this.isFamousWhite, 17, false);
        this.isQzoneUser = jceInputStream.read(this.isQzoneUser, 18, false);
        this.isAnnualVip = jceInputStream.read(this.isAnnualVip, 19, false);
        this.isSetNickGlint = jceInputStream.read(this.isSetNickGlint, 20, false);
        this.medalInfo = (s_medal) jceInputStream.read((JceStruct) cache_medalInfo, 21, false);
        this.descicon = jceInputStream.readString(22, false);
        this.icon_width = jceInputStream.read(this.icon_width, 23, false);
        this.icon_height = jceInputStream.read(this.icon_height, 24, false);
        this.isSweetVip = jceInputStream.read(this.isSweetVip, 25, false);
        this.stuStarInfo = (star_info) jceInputStream.read((JceStruct) cache_stuStarInfo, 26, false);
        this.stuCombineDiamondInfo = (combine_diamond_info) jceInputStream.read((JceStruct) cache_stuCombineDiamondInfo, 27, false);
        this.isSafeModeUser = jceInputStream.read(this.isSafeModeUser, 28, false);
        this.vipShowType = jceInputStream.read(this.vipShowType, 29, false);
        this.namePlate = jceInputStream.read(this.namePlate, 30, false);
        this.actiontype = jceInputStream.read(this.actiontype, 31, false);
        this.actionurl = jceInputStream.readString(32, false);
        this.decoration = jceInputStream.read(cache_decoration, 33, false);
        this.tagInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_tagInfos, 34, false);
        this.strPortraitId = jceInputStream.readString(35, false);
        this.under_nickname_desc = jceInputStream.readString(36, false);
        this.liveshowMedalInfo = (s_medal) jceInputStream.read((JceStruct) cache_liveshowMedalInfo, 37, false);
        this.uFansCount = jceInputStream.read(this.uFansCount, 38, false);
        this.uVisitorCount = jceInputStream.read(this.uVisitorCount, 39, false);
        this.isCmtVerifyOpen = jceInputStream.read(this.isCmtVerifyOpen, 40, false);
        this.iCurUserType = jceInputStream.read(this.iCurUserType, 41, false);
        this.displayflag = jceInputStream.read(this.displayflag, 42, false);
        this.vtime = jceInputStream.read(this.vtime, 43, false);
        this.authqzoneMedalInfo = (s_medal) jceInputStream.read((JceStruct) cache_authqzoneMedalInfo, 44, false);
        this.eUserTypeReport = jceInputStream.read(this.eUserTypeReport, 45, false);
        this.iVipActType = jceInputStream.read(this.iVipActType, 46, false);
        this.openid_users = (s_openid_user) jceInputStream.read((JceStruct) cache_openid_users, 47, false);
        this.sex = jceInputStream.read(this.sex, 48, false);
        this.kuoliestate = (s_kuolie_info) jceInputStream.read((JceStruct) cache_kuoliestate, 49, false);
        this.isPrivateMode = jceInputStream.read(this.isPrivateMode, 50, false);
        this.avatarRecomBar = jceInputStream.readString(51, false);
        this.user_tags = (ArrayList) jceInputStream.read((JceInputStream) cache_user_tags, 52, false);
        this.age = jceInputStream.read(this.age, 53, false);
        this.isVideoCircleVUser = jceInputStream.read(this.isVideoCircleVUser, 54, false);
        this.uFeedsCount = jceInputStream.read(this.uFeedsCount, 55, false);
        this.qzonedesc_token = jceInputStream.readString(56, false);
        this.nameplateList = (ArrayList) jceInputStream.read((JceInputStream) cache_nameplateList, 57, false);
        this.tmall_deco = jceInputStream.read(cache_tmall_deco, 58, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.timestamp, 2);
        jceOutputStream.write(this.from, 3);
        String str2 = this.uinkey;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.logo;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        jceOutputStream.write(this.vip, 6);
        jceOutputStream.write(this.level, 7);
        jceOutputStream.write(this.viplevel, 8);
        jceOutputStream.write(this.viptype, 9);
        String str4 = this.qzonedesc;
        if (str4 != null) {
            jceOutputStream.write(str4, 10);
        }
        jceOutputStream.write(this.is_owner, 11);
        jceOutputStream.write(this.operation_mask, 12);
        String str5 = this.uid;
        if (str5 != null) {
            jceOutputStream.write(str5, 13);
        }
        String str6 = this.talk_id;
        if (str6 != null) {
            jceOutputStream.write(str6, 14);
        }
        jceOutputStream.write(this.portrait_id, 15);
        jceOutputStream.write(this.is_own, 16);
        jceOutputStream.write(this.isFamousWhite, 17);
        jceOutputStream.write(this.isQzoneUser, 18);
        jceOutputStream.write(this.isAnnualVip, 19);
        jceOutputStream.write(this.isSetNickGlint, 20);
        s_medal s_medalVar = this.medalInfo;
        if (s_medalVar != null) {
            jceOutputStream.write((JceStruct) s_medalVar, 21);
        }
        String str7 = this.descicon;
        if (str7 != null) {
            jceOutputStream.write(str7, 22);
        }
        jceOutputStream.write(this.icon_width, 23);
        jceOutputStream.write(this.icon_height, 24);
        jceOutputStream.write(this.isSweetVip, 25);
        star_info star_infoVar = this.stuStarInfo;
        if (star_infoVar != null) {
            jceOutputStream.write((JceStruct) star_infoVar, 26);
        }
        combine_diamond_info combine_diamond_infoVar = this.stuCombineDiamondInfo;
        if (combine_diamond_infoVar != null) {
            jceOutputStream.write((JceStruct) combine_diamond_infoVar, 27);
        }
        jceOutputStream.write(this.isSafeModeUser, 28);
        jceOutputStream.write(this.vipShowType, 29);
        jceOutputStream.write(this.namePlate, 30);
        jceOutputStream.write(this.actiontype, 31);
        String str8 = this.actionurl;
        if (str8 != null) {
            jceOutputStream.write(str8, 32);
        }
        byte[] bArr = this.decoration;
        if (bArr != null) {
            jceOutputStream.write(bArr, 33);
        }
        ArrayList<s_yytag> arrayList = this.tagInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 34);
        }
        String str9 = this.strPortraitId;
        if (str9 != null) {
            jceOutputStream.write(str9, 35);
        }
        String str10 = this.under_nickname_desc;
        if (str10 != null) {
            jceOutputStream.write(str10, 36);
        }
        s_medal s_medalVar2 = this.liveshowMedalInfo;
        if (s_medalVar2 != null) {
            jceOutputStream.write((JceStruct) s_medalVar2, 37);
        }
        jceOutputStream.write(this.uFansCount, 38);
        jceOutputStream.write(this.uVisitorCount, 39);
        jceOutputStream.write(this.isCmtVerifyOpen, 40);
        jceOutputStream.write(this.iCurUserType, 41);
        jceOutputStream.write(this.displayflag, 42);
        jceOutputStream.write(this.vtime, 43);
        s_medal s_medalVar3 = this.authqzoneMedalInfo;
        if (s_medalVar3 != null) {
            jceOutputStream.write((JceStruct) s_medalVar3, 44);
        }
        jceOutputStream.write(this.eUserTypeReport, 45);
        jceOutputStream.write(this.iVipActType, 46);
        s_openid_user s_openid_userVar = this.openid_users;
        if (s_openid_userVar != null) {
            jceOutputStream.write((JceStruct) s_openid_userVar, 47);
        }
        jceOutputStream.write(this.sex, 48);
        s_kuolie_info s_kuolie_infoVar = this.kuoliestate;
        if (s_kuolie_infoVar != null) {
            jceOutputStream.write((JceStruct) s_kuolie_infoVar, 49);
        }
        jceOutputStream.write(this.isPrivateMode, 50);
        String str11 = this.avatarRecomBar;
        if (str11 != null) {
            jceOutputStream.write(str11, 51);
        }
        ArrayList<String> arrayList2 = this.user_tags;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 52);
        }
        jceOutputStream.write(this.age, 53);
        jceOutputStream.write(this.isVideoCircleVUser, 54);
        jceOutputStream.write(this.uFeedsCount, 55);
        String str12 = this.qzonedesc_token;
        if (str12 != null) {
            jceOutputStream.write(str12, 56);
        }
        ArrayList<s_nameplate> arrayList3 = this.nameplateList;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 57);
        }
        byte[] bArr2 = this.tmall_deco;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 58);
        }
    }

    public s_user(long j3, String str, int i3, int i16, String str2, String str3, int i17, int i18, int i19, int i26, String str4, int i27, int i28, String str5, String str6, int i29, int i36, int i37, int i38, byte b16, byte b17, s_medal s_medalVar, String str7, int i39, int i46, int i47, star_info star_infoVar, combine_diamond_info combine_diamond_infoVar, byte b18, byte b19, int i48, int i49, String str8, byte[] bArr, ArrayList<s_yytag> arrayList, String str9, String str10, s_medal s_medalVar2, long j16, long j17, int i56, int i57, int i58, long j18, s_medal s_medalVar3, long j19, int i59, s_openid_user s_openid_userVar, byte b26, s_kuolie_info s_kuolie_infoVar, int i65, String str11, ArrayList<String> arrayList2, int i66, int i67, long j26, String str12, ArrayList<s_nameplate> arrayList3, byte[] bArr2) {
        this.uin = j3;
        this.nickname = str;
        this.timestamp = i3;
        this.from = i16;
        this.uinkey = str2;
        this.logo = str3;
        this.vip = i17;
        this.level = i18;
        this.viplevel = i19;
        this.viptype = i26;
        this.qzonedesc = str4;
        this.is_owner = i27;
        this.operation_mask = i28;
        this.uid = str5;
        this.talk_id = str6;
        this.portrait_id = i29;
        this.is_own = i36;
        this.isFamousWhite = i37;
        this.isQzoneUser = i38;
        this.isAnnualVip = b16;
        this.isSetNickGlint = b17;
        this.medalInfo = s_medalVar;
        this.descicon = str7;
        this.icon_width = i39;
        this.icon_height = i46;
        this.isSweetVip = i47;
        this.stuStarInfo = star_infoVar;
        this.stuCombineDiamondInfo = combine_diamond_infoVar;
        this.isSafeModeUser = b18;
        this.vipShowType = b19;
        this.namePlate = i48;
        this.actiontype = i49;
        this.actionurl = str8;
        this.decoration = bArr;
        this.tagInfos = arrayList;
        this.strPortraitId = str9;
        this.under_nickname_desc = str10;
        this.liveshowMedalInfo = s_medalVar2;
        this.uFansCount = j16;
        this.uVisitorCount = j17;
        this.isCmtVerifyOpen = i56;
        this.iCurUserType = i57;
        this.displayflag = i58;
        this.vtime = j18;
        this.authqzoneMedalInfo = s_medalVar3;
        this.eUserTypeReport = j19;
        this.iVipActType = i59;
        this.openid_users = s_openid_userVar;
        this.sex = b26;
        this.kuoliestate = s_kuolie_infoVar;
        this.isPrivateMode = i65;
        this.avatarRecomBar = str11;
        this.user_tags = arrayList2;
        this.age = i66;
        this.isVideoCircleVUser = i67;
        this.uFeedsCount = j26;
        this.qzonedesc_token = str12;
        this.nameplateList = arrayList3;
        this.tmall_deco = bArr2;
    }
}
