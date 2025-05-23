package EncounterSvc;

import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespEncounterInfo extends JceStruct {
    static int cache_eMerchantType;
    static int cache_eUserIdentityType;
    static byte[] cache_sig;
    static byte[] cache_vDateFaceInfo;
    static byte[] cache_vDateInfo;
    static byte[] cache_vDateVideoInfo;
    static byte[] cache_vFaceID;
    static byte[] cache_vInterestInfo;
    static byte[] cache_vIntroContent;
    static byte[] cache_vTheSameLabels;
    public String actionData;
    public byte authFlag;
    public String avatarBgGif;
    public byte bIsSingle;
    public byte cAge;
    public byte cGroupId;
    public byte cSex;
    public byte cSpecialFlag;
    public int charm;
    public int charm_level;
    public byte charm_shown;
    public int common_face_timestamp;
    public byte constellation;
    public int eMerchantType;
    public int eUserIdentityType;
    public String enc_id;
    public byte god_flag;
    public int hasAvatarAnimation;
    public byte host_flag;
    public byte host_online_flag;
    public int iDistance;
    public int iLat;
    public int iLon;
    public int iRank;
    public int iVoteIncrement;
    public int iVoteNum;
    public byte is_trav;
    public long lEctID;
    public int lTime;
    public long lTotalVisitorsNum;
    public byte live_flag;
    public byte marriage;
    public int nFaceNum;
    public String nowBoardcastGif;
    public String nowBoardcastWording;
    public String personal_imprint;
    public int profession_id;
    public RishState richState;
    public int ruleId;
    public short shIntroType;
    public byte[] sig;
    public String strCertification;
    public String strCompanyName;
    public String strDescription;
    public String strNick;
    public String strPYFaceUrl;
    public String strPYName;
    public String strSchoolName;
    public int stranger_face_timestamp;
    public long tiny_id;
    public String uid;
    public byte[] vDateFaceInfo;
    public byte[] vDateInfo;
    public byte[] vDateVideoInfo;
    public byte[] vFaceID;
    public byte[] vInterestInfo;
    public byte[] vIntroContent;
    public byte[] vTheSameLabels;
    public VipBaseInfo vipBaseInfo;
    public short wFace;
    public byte watch_color;
    static VipBaseInfo cache_vipBaseInfo = new VipBaseInfo();
    static RishState cache_richState = new RishState();

    static {
        cache_vIntroContent = r1;
        byte[] bArr = {0};
        cache_vFaceID = r1;
        byte[] bArr2 = {0};
        cache_sig = r1;
        byte[] bArr3 = {0};
        cache_vDateInfo = r1;
        byte[] bArr4 = {0};
        cache_vInterestInfo = r1;
        byte[] bArr5 = {0};
        cache_vTheSameLabels = r1;
        byte[] bArr6 = {0};
        cache_vDateFaceInfo = r1;
        byte[] bArr7 = {0};
        cache_vDateVideoInfo = r0;
        byte[] bArr8 = {0};
    }

    public RespEncounterInfo() {
        this.lEctID = 0L;
        this.iDistance = -1;
        this.lTime = 0;
        this.strDescription = "";
        this.wFace = (short) 0;
        this.cSex = (byte) -1;
        this.cAge = (byte) -1;
        this.strNick = "";
        this.cGroupId = (byte) 0;
        this.strPYFaceUrl = "";
        this.strSchoolName = "";
        this.strCompanyName = "";
        this.strPYName = "";
        this.nFaceNum = 0;
        this.strCertification = "";
        this.shIntroType = (short) 0;
        this.vIntroContent = null;
        this.vFaceID = null;
        this.eMerchantType = 0;
        this.eUserIdentityType = 0;
        this.iVoteIncrement = -1;
        this.bIsSingle = (byte) 0;
        this.iLat = 900000000;
        this.iLon = 900000000;
        this.iRank = 0;
        this.lTotalVisitorsNum = 0L;
        this.cSpecialFlag = (byte) 0;
        this.vipBaseInfo = null;
        this.richState = null;
        this.sig = null;
        this.enc_id = "";
        this.uid = "";
        this.is_trav = (byte) 0;
        this.constellation = (byte) 0;
        this.profession_id = 0;
        this.vDateInfo = null;
        this.marriage = (byte) 0;
        this.tiny_id = 0L;
        this.common_face_timestamp = 0;
        this.stranger_face_timestamp = 0;
        this.authFlag = (byte) 0;
        this.iVoteNum = 0;
        this.god_flag = (byte) 0;
        this.charm = 0;
        this.charm_level = 0;
        this.watch_color = (byte) 0;
        this.charm_shown = (byte) 0;
        this.vInterestInfo = null;
        this.host_flag = (byte) 0;
        this.host_online_flag = (byte) 0;
        this.vTheSameLabels = null;
        this.vDateFaceInfo = null;
        this.vDateVideoInfo = null;
        this.ruleId = 0;
        this.live_flag = (byte) 0;
        this.personal_imprint = "";
        this.actionData = "";
        this.avatarBgGif = "";
        this.nowBoardcastGif = "";
        this.nowBoardcastWording = "";
        this.hasAvatarAnimation = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lEctID = jceInputStream.read(this.lEctID, 0, true);
        this.iDistance = jceInputStream.read(this.iDistance, 1, true);
        this.lTime = jceInputStream.read(this.lTime, 2, true);
        this.strDescription = jceInputStream.readString(3, true);
        this.wFace = jceInputStream.read(this.wFace, 4, true);
        this.cSex = jceInputStream.read(this.cSex, 5, true);
        this.cAge = jceInputStream.read(this.cAge, 6, true);
        this.strNick = jceInputStream.readString(7, true);
        this.cGroupId = jceInputStream.read(this.cGroupId, 8, false);
        this.strPYFaceUrl = jceInputStream.readString(9, false);
        this.strSchoolName = jceInputStream.readString(10, false);
        this.strCompanyName = jceInputStream.readString(11, false);
        this.strPYName = jceInputStream.readString(12, false);
        this.nFaceNum = jceInputStream.read(this.nFaceNum, 13, false);
        this.strCertification = jceInputStream.readString(14, false);
        this.shIntroType = jceInputStream.read(this.shIntroType, 15, false);
        this.vIntroContent = jceInputStream.read(cache_vIntroContent, 16, false);
        this.vFaceID = jceInputStream.read(cache_vFaceID, 17, false);
        this.eMerchantType = jceInputStream.read(this.eMerchantType, 18, false);
        this.eUserIdentityType = jceInputStream.read(this.eUserIdentityType, 19, false);
        this.iVoteIncrement = jceInputStream.read(this.iVoteIncrement, 20, false);
        this.bIsSingle = jceInputStream.read(this.bIsSingle, 21, false);
        this.iLat = jceInputStream.read(this.iLat, 22, false);
        this.iLon = jceInputStream.read(this.iLon, 23, false);
        this.iRank = jceInputStream.read(this.iRank, 24, false);
        this.lTotalVisitorsNum = jceInputStream.read(this.lTotalVisitorsNum, 25, false);
        this.cSpecialFlag = jceInputStream.read(this.cSpecialFlag, 26, false);
        this.vipBaseInfo = (VipBaseInfo) jceInputStream.read((JceStruct) cache_vipBaseInfo, 27, false);
        this.richState = (RishState) jceInputStream.read((JceStruct) cache_richState, 28, false);
        this.sig = jceInputStream.read(cache_sig, 29, false);
        this.enc_id = jceInputStream.readString(30, false);
        this.uid = jceInputStream.readString(31, false);
        this.is_trav = jceInputStream.read(this.is_trav, 32, false);
        this.constellation = jceInputStream.read(this.constellation, 33, false);
        this.profession_id = jceInputStream.read(this.profession_id, 34, false);
        this.vDateInfo = jceInputStream.read(cache_vDateInfo, 35, false);
        this.marriage = jceInputStream.read(this.marriage, 36, false);
        this.tiny_id = jceInputStream.read(this.tiny_id, 37, false);
        this.common_face_timestamp = jceInputStream.read(this.common_face_timestamp, 38, false);
        this.stranger_face_timestamp = jceInputStream.read(this.stranger_face_timestamp, 39, false);
        this.authFlag = jceInputStream.read(this.authFlag, 40, false);
        this.iVoteNum = jceInputStream.read(this.iVoteNum, 41, false);
        this.god_flag = jceInputStream.read(this.god_flag, 42, false);
        this.charm = jceInputStream.read(this.charm, 43, false);
        this.charm_level = jceInputStream.read(this.charm_level, 44, false);
        this.watch_color = jceInputStream.read(this.watch_color, 45, false);
        this.charm_shown = jceInputStream.read(this.charm_shown, 46, false);
        this.vInterestInfo = jceInputStream.read(cache_vInterestInfo, 47, false);
        this.host_flag = jceInputStream.read(this.host_flag, 48, false);
        this.host_online_flag = jceInputStream.read(this.host_online_flag, 49, false);
        this.vTheSameLabels = jceInputStream.read(cache_vTheSameLabels, 50, false);
        this.vDateFaceInfo = jceInputStream.read(cache_vDateFaceInfo, 51, false);
        this.vDateVideoInfo = jceInputStream.read(cache_vDateVideoInfo, 52, false);
        this.ruleId = jceInputStream.read(this.ruleId, 53, false);
        this.live_flag = jceInputStream.read(this.live_flag, 54, false);
        this.personal_imprint = jceInputStream.readString(55, false);
        this.actionData = jceInputStream.readString(56, false);
        this.avatarBgGif = jceInputStream.readString(57, false);
        this.nowBoardcastGif = jceInputStream.readString(58, false);
        this.nowBoardcastWording = jceInputStream.readString(59, false);
        this.hasAvatarAnimation = jceInputStream.read(this.hasAvatarAnimation, 60, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lEctID, 0);
        jceOutputStream.write(this.iDistance, 1);
        jceOutputStream.write(this.lTime, 2);
        jceOutputStream.write(this.strDescription, 3);
        jceOutputStream.write(this.wFace, 4);
        jceOutputStream.write(this.cSex, 5);
        jceOutputStream.write(this.cAge, 6);
        jceOutputStream.write(this.strNick, 7);
        jceOutputStream.write(this.cGroupId, 8);
        String str = this.strPYFaceUrl;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        String str2 = this.strSchoolName;
        if (str2 != null) {
            jceOutputStream.write(str2, 10);
        }
        String str3 = this.strCompanyName;
        if (str3 != null) {
            jceOutputStream.write(str3, 11);
        }
        String str4 = this.strPYName;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
        jceOutputStream.write(this.nFaceNum, 13);
        String str5 = this.strCertification;
        if (str5 != null) {
            jceOutputStream.write(str5, 14);
        }
        jceOutputStream.write(this.shIntroType, 15);
        byte[] bArr = this.vIntroContent;
        if (bArr != null) {
            jceOutputStream.write(bArr, 16);
        }
        byte[] bArr2 = this.vFaceID;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 17);
        }
        jceOutputStream.write(this.eMerchantType, 18);
        jceOutputStream.write(this.eUserIdentityType, 19);
        jceOutputStream.write(this.iVoteIncrement, 20);
        jceOutputStream.write(this.bIsSingle, 21);
        jceOutputStream.write(this.iLat, 22);
        jceOutputStream.write(this.iLon, 23);
        jceOutputStream.write(this.iRank, 24);
        jceOutputStream.write(this.lTotalVisitorsNum, 25);
        jceOutputStream.write(this.cSpecialFlag, 26);
        VipBaseInfo vipBaseInfo = this.vipBaseInfo;
        if (vipBaseInfo != null) {
            jceOutputStream.write((JceStruct) vipBaseInfo, 27);
        }
        RishState rishState = this.richState;
        if (rishState != null) {
            jceOutputStream.write((JceStruct) rishState, 28);
        }
        byte[] bArr3 = this.sig;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 29);
        }
        String str6 = this.enc_id;
        if (str6 != null) {
            jceOutputStream.write(str6, 30);
        }
        String str7 = this.uid;
        if (str7 != null) {
            jceOutputStream.write(str7, 31);
        }
        jceOutputStream.write(this.is_trav, 32);
        jceOutputStream.write(this.constellation, 33);
        jceOutputStream.write(this.profession_id, 34);
        byte[] bArr4 = this.vDateInfo;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 35);
        }
        jceOutputStream.write(this.marriage, 36);
        jceOutputStream.write(this.tiny_id, 37);
        jceOutputStream.write(this.common_face_timestamp, 38);
        jceOutputStream.write(this.stranger_face_timestamp, 39);
        jceOutputStream.write(this.authFlag, 40);
        jceOutputStream.write(this.iVoteNum, 41);
        jceOutputStream.write(this.god_flag, 42);
        jceOutputStream.write(this.charm, 43);
        jceOutputStream.write(this.charm_level, 44);
        jceOutputStream.write(this.watch_color, 45);
        jceOutputStream.write(this.charm_shown, 46);
        byte[] bArr5 = this.vInterestInfo;
        if (bArr5 != null) {
            jceOutputStream.write(bArr5, 47);
        }
        jceOutputStream.write(this.host_flag, 48);
        jceOutputStream.write(this.host_online_flag, 49);
        byte[] bArr6 = this.vTheSameLabels;
        if (bArr6 != null) {
            jceOutputStream.write(bArr6, 50);
        }
        byte[] bArr7 = this.vDateFaceInfo;
        if (bArr7 != null) {
            jceOutputStream.write(bArr7, 51);
        }
        byte[] bArr8 = this.vDateVideoInfo;
        if (bArr8 != null) {
            jceOutputStream.write(bArr8, 52);
        }
        jceOutputStream.write(this.ruleId, 53);
        jceOutputStream.write(this.live_flag, 54);
        String str8 = this.personal_imprint;
        if (str8 != null) {
            jceOutputStream.write(str8, 55);
        }
        String str9 = this.actionData;
        if (str9 != null) {
            jceOutputStream.write(str9, 56);
        }
        String str10 = this.avatarBgGif;
        if (str10 != null) {
            jceOutputStream.write(str10, 57);
        }
        String str11 = this.nowBoardcastGif;
        if (str11 != null) {
            jceOutputStream.write(str11, 58);
        }
        String str12 = this.nowBoardcastWording;
        if (str12 != null) {
            jceOutputStream.write(str12, 59);
        }
        jceOutputStream.write(this.hasAvatarAnimation, 60);
    }

    public RespEncounterInfo(long j3, int i3, int i16, String str, short s16, byte b16, byte b17, String str2, byte b18, String str3, String str4, String str5, String str6, int i17, String str7, short s17, byte[] bArr, byte[] bArr2, int i18, int i19, int i26, byte b19, int i27, int i28, int i29, long j16, byte b26, VipBaseInfo vipBaseInfo, RishState rishState, byte[] bArr3, String str8, String str9, byte b27, byte b28, int i36, byte[] bArr4, byte b29, long j17, int i37, int i38, byte b36, int i39, byte b37, int i46, int i47, byte b38, byte b39, byte[] bArr5, byte b46, byte b47, byte[] bArr6, byte[] bArr7, byte[] bArr8, int i48, byte b48, String str10, String str11, String str12, String str13, String str14, int i49) {
        this.lEctID = j3;
        this.iDistance = i3;
        this.lTime = i16;
        this.strDescription = str;
        this.wFace = s16;
        this.cSex = b16;
        this.cAge = b17;
        this.strNick = str2;
        this.cGroupId = b18;
        this.strPYFaceUrl = str3;
        this.strSchoolName = str4;
        this.strCompanyName = str5;
        this.strPYName = str6;
        this.nFaceNum = i17;
        this.strCertification = str7;
        this.shIntroType = s17;
        this.vIntroContent = bArr;
        this.vFaceID = bArr2;
        this.eMerchantType = i18;
        this.eUserIdentityType = i19;
        this.iVoteIncrement = i26;
        this.bIsSingle = b19;
        this.iLat = i27;
        this.iLon = i28;
        this.iRank = i29;
        this.lTotalVisitorsNum = j16;
        this.cSpecialFlag = b26;
        this.vipBaseInfo = vipBaseInfo;
        this.richState = rishState;
        this.sig = bArr3;
        this.enc_id = str8;
        this.uid = str9;
        this.is_trav = b27;
        this.constellation = b28;
        this.profession_id = i36;
        this.vDateInfo = bArr4;
        this.marriage = b29;
        this.tiny_id = j17;
        this.common_face_timestamp = i37;
        this.stranger_face_timestamp = i38;
        this.authFlag = b36;
        this.iVoteNum = i39;
        this.god_flag = b37;
        this.charm = i46;
        this.charm_level = i47;
        this.watch_color = b38;
        this.charm_shown = b39;
        this.vInterestInfo = bArr5;
        this.host_flag = b46;
        this.host_online_flag = b47;
        this.vTheSameLabels = bArr6;
        this.vDateFaceInfo = bArr7;
        this.vDateVideoInfo = bArr8;
        this.ruleId = i48;
        this.live_flag = b48;
        this.personal_imprint = str10;
        this.actionData = str11;
        this.avatarBgGif = str12;
        this.nowBoardcastGif = str13;
        this.nowBoardcastWording = str14;
        this.hasAvatarAnimation = i49;
    }
}
