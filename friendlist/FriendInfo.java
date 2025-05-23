package friendlist;

import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FriendInfo extends JceStruct {
    static byte[] cache_vecCardID;
    static byte[] cache_vecExtInfo;
    static byte[] cache_vecExtOnlineBusinessInfo;
    static byte[] cache_vecExtSnsFrdData;
    static byte[] cache_vecIMGroupID;
    static byte[] cache_vecIntimateInfo;
    static byte[] cache_vecMSFGroupID;
    static byte[] cache_vecMusicInfo;
    static byte[] cache_vecMutualMarkData;
    static byte[] cache_vecPoiInfo;
    static byte[] cache_vecRing;
    public byte cApolloFlag;
    public byte cCentiShow3DFlag;
    public byte cKingOfGloryFlag;
    public byte cNetwork;
    public byte cNewLoverDiamondFlag;
    public byte cOlympicTorch;
    public byte cSex;
    public byte cShowNameplate;
    public byte cSpecialFlag;
    public byte detalStatusFlag;
    public int eIconType;
    public int eNetworkType;
    public short faceId;
    public long friendUin;
    public byte groupId;
    public int iBatteryStatus;
    public int iTermType;
    public byte isIphoneOnline;
    public byte isMqqOnLine;
    public byte isRemark;
    public byte memberLevel;
    public String nick;
    public VipBaseInfo oVipInfo;
    public String remark;
    public String sDOVId;
    public String sShowName;
    public byte sqqOnLineState;
    public byte sqqOnLineStateV2;
    public byte sqqtype;
    public byte status;
    public String strEimId;
    public String strEimMobile;
    public String strMasterUin;
    public String strTermDesc;
    public long uAbiFlag;
    public long uApolloSignTime;
    public long uApolloTimestamp;
    public long uBothFlag;
    public long uColorRing;
    public long uExtOnlineStatus;
    public long uFaceStoreId;
    public long uFontEffect;
    public long uFounderFont;
    public long uGameAppid;
    public long uGameLastLoginTime;
    public long uLastMedalUpdateTime;
    public long uLaviUin;
    public long uRobotType;
    public long uRobotVersion;
    public long uTagUpdateTime;
    public long uVipFont;
    public String uid;
    public long ulBitSet;
    public long ulFaceAddonId;
    public long ulKingOfGloryRank;
    public byte[] vecCardID;
    public byte[] vecExtInfo;
    public byte[] vecExtOnlineBusinessInfo;
    public byte[] vecExtSnsFrdData;
    public byte[] vecIMGroupID;
    public byte[] vecIntimateInfo;
    public byte[] vecMSFGroupID;
    public byte[] vecMusicInfo;
    public byte[] vecMutualMarkData;
    public byte[] vecPoiInfo;
    public byte[] vecRing;
    static VipBaseInfo cache_oVipInfo = new VipBaseInfo();
    static int cache_eNetworkType = 0;
    static int cache_eIconType = 0;

    static {
        cache_vecIMGroupID = r1;
        byte[] bArr = {0};
        cache_vecMSFGroupID = r1;
        byte[] bArr2 = {0};
        cache_vecRing = r1;
        byte[] bArr3 = {0};
        cache_vecCardID = r1;
        byte[] bArr4 = {0};
        cache_vecIntimateInfo = r1;
        byte[] bArr5 = {0};
        cache_vecExtSnsFrdData = r1;
        byte[] bArr6 = {0};
        cache_vecMutualMarkData = r1;
        byte[] bArr7 = {0};
        cache_vecMusicInfo = r1;
        byte[] bArr8 = {0};
        cache_vecPoiInfo = r1;
        byte[] bArr9 = {0};
        cache_vecExtOnlineBusinessInfo = r1;
        byte[] bArr10 = {0};
        cache_vecExtInfo = r0;
        byte[] bArr11 = {0};
    }

    public FriendInfo() {
        this.friendUin = 0L;
        this.groupId = (byte) 0;
        this.faceId = (short) 0;
        this.remark = "";
        this.sqqtype = (byte) 0;
        this.status = QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA;
        this.memberLevel = (byte) 0;
        this.isMqqOnLine = (byte) 0;
        this.sqqOnLineState = (byte) 0;
        this.isIphoneOnline = (byte) 0;
        this.detalStatusFlag = (byte) 0;
        this.sqqOnLineStateV2 = (byte) 0;
        this.sShowName = "";
        this.isRemark = (byte) 0;
        this.nick = "";
        this.cSpecialFlag = (byte) 0;
        this.vecIMGroupID = null;
        this.vecMSFGroupID = null;
        this.iTermType = 0;
        this.oVipInfo = null;
        this.cNetwork = (byte) 0;
        this.vecRing = null;
        this.uAbiFlag = 0L;
        this.ulFaceAddonId = 0L;
        this.eNetworkType = 0;
        this.uVipFont = 0L;
        this.eIconType = 0;
        this.strTermDesc = "";
        this.uColorRing = 0L;
        this.cApolloFlag = (byte) 0;
        this.uApolloTimestamp = 0L;
        this.cSex = (byte) 0;
        this.uFounderFont = 0L;
        this.strEimId = "";
        this.strEimMobile = "";
        this.cOlympicTorch = (byte) 0;
        this.uApolloSignTime = 0L;
        this.uLaviUin = 0L;
        this.uTagUpdateTime = 0L;
        this.uGameLastLoginTime = 0L;
        this.uGameAppid = 0L;
        this.vecCardID = null;
        this.ulBitSet = 0L;
        this.cKingOfGloryFlag = (byte) 0;
        this.ulKingOfGloryRank = 0L;
        this.strMasterUin = "";
        this.uLastMedalUpdateTime = 0L;
        this.uFaceStoreId = 0L;
        this.uFontEffect = 0L;
        this.sDOVId = "";
        this.uBothFlag = 0L;
        this.cCentiShow3DFlag = (byte) 0;
        this.vecIntimateInfo = null;
        this.cShowNameplate = (byte) 0;
        this.cNewLoverDiamondFlag = (byte) 0;
        this.vecExtSnsFrdData = null;
        this.vecMutualMarkData = null;
        this.uExtOnlineStatus = 0L;
        this.iBatteryStatus = 0;
        this.vecMusicInfo = null;
        this.vecPoiInfo = null;
        this.vecExtOnlineBusinessInfo = null;
        this.vecExtInfo = null;
        this.uid = "";
        this.uRobotType = 0L;
        this.uRobotVersion = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.friendUin = jceInputStream.read(this.friendUin, 0, true);
        this.groupId = jceInputStream.read(this.groupId, 1, true);
        this.faceId = jceInputStream.read(this.faceId, 2, true);
        this.remark = jceInputStream.readString(3, true);
        this.sqqtype = jceInputStream.read(this.sqqtype, 4, true);
        this.status = jceInputStream.read(this.status, 5, true);
        this.memberLevel = jceInputStream.read(this.memberLevel, 6, false);
        this.isMqqOnLine = jceInputStream.read(this.isMqqOnLine, 7, false);
        this.sqqOnLineState = jceInputStream.read(this.sqqOnLineState, 8, false);
        this.isIphoneOnline = jceInputStream.read(this.isIphoneOnline, 9, false);
        this.detalStatusFlag = jceInputStream.read(this.detalStatusFlag, 10, false);
        this.sqqOnLineStateV2 = jceInputStream.read(this.sqqOnLineStateV2, 11, false);
        this.sShowName = jceInputStream.readString(12, false);
        this.isRemark = jceInputStream.read(this.isRemark, 13, false);
        this.nick = jceInputStream.readString(14, false);
        this.cSpecialFlag = jceInputStream.read(this.cSpecialFlag, 15, false);
        this.vecIMGroupID = jceInputStream.read(cache_vecIMGroupID, 16, false);
        this.vecMSFGroupID = jceInputStream.read(cache_vecMSFGroupID, 17, false);
        this.iTermType = jceInputStream.read(this.iTermType, 18, false);
        this.oVipInfo = (VipBaseInfo) jceInputStream.read((JceStruct) cache_oVipInfo, 19, false);
        this.cNetwork = jceInputStream.read(this.cNetwork, 20, false);
        this.vecRing = jceInputStream.read(cache_vecRing, 21, false);
        this.uAbiFlag = jceInputStream.read(this.uAbiFlag, 22, false);
        this.ulFaceAddonId = jceInputStream.read(this.ulFaceAddonId, 23, false);
        this.eNetworkType = jceInputStream.read(this.eNetworkType, 24, false);
        this.uVipFont = jceInputStream.read(this.uVipFont, 25, false);
        this.eIconType = jceInputStream.read(this.eIconType, 26, false);
        this.strTermDesc = jceInputStream.readString(27, false);
        this.uColorRing = jceInputStream.read(this.uColorRing, 28, false);
        this.cApolloFlag = jceInputStream.read(this.cApolloFlag, 29, false);
        this.uApolloTimestamp = jceInputStream.read(this.uApolloTimestamp, 30, false);
        this.cSex = jceInputStream.read(this.cSex, 31, false);
        this.uFounderFont = jceInputStream.read(this.uFounderFont, 32, false);
        this.strEimId = jceInputStream.readString(33, false);
        this.strEimMobile = jceInputStream.readString(34, false);
        this.cOlympicTorch = jceInputStream.read(this.cOlympicTorch, 35, false);
        this.uApolloSignTime = jceInputStream.read(this.uApolloSignTime, 36, false);
        this.uLaviUin = jceInputStream.read(this.uLaviUin, 37, false);
        this.uTagUpdateTime = jceInputStream.read(this.uTagUpdateTime, 38, false);
        this.uGameLastLoginTime = jceInputStream.read(this.uGameLastLoginTime, 39, false);
        this.uGameAppid = jceInputStream.read(this.uGameAppid, 40, false);
        this.vecCardID = jceInputStream.read(cache_vecCardID, 41, false);
        this.ulBitSet = jceInputStream.read(this.ulBitSet, 42, false);
        this.cKingOfGloryFlag = jceInputStream.read(this.cKingOfGloryFlag, 43, false);
        this.ulKingOfGloryRank = jceInputStream.read(this.ulKingOfGloryRank, 44, false);
        this.strMasterUin = jceInputStream.readString(45, false);
        this.uLastMedalUpdateTime = jceInputStream.read(this.uLastMedalUpdateTime, 46, false);
        this.uFaceStoreId = jceInputStream.read(this.uFaceStoreId, 47, false);
        this.uFontEffect = jceInputStream.read(this.uFontEffect, 48, false);
        this.sDOVId = jceInputStream.readString(49, false);
        this.uBothFlag = jceInputStream.read(this.uBothFlag, 50, false);
        this.cCentiShow3DFlag = jceInputStream.read(this.cCentiShow3DFlag, 51, false);
        this.vecIntimateInfo = jceInputStream.read(cache_vecIntimateInfo, 52, false);
        this.cShowNameplate = jceInputStream.read(this.cShowNameplate, 53, false);
        this.cNewLoverDiamondFlag = jceInputStream.read(this.cNewLoverDiamondFlag, 54, false);
        this.vecExtSnsFrdData = jceInputStream.read(cache_vecExtSnsFrdData, 55, false);
        this.vecMutualMarkData = jceInputStream.read(cache_vecMutualMarkData, 56, false);
        this.uExtOnlineStatus = jceInputStream.read(this.uExtOnlineStatus, 57, false);
        this.iBatteryStatus = jceInputStream.read(this.iBatteryStatus, 58, false);
        this.vecMusicInfo = jceInputStream.read(cache_vecMusicInfo, 59, false);
        this.vecPoiInfo = jceInputStream.read(cache_vecPoiInfo, 60, false);
        this.vecExtOnlineBusinessInfo = jceInputStream.read(cache_vecExtOnlineBusinessInfo, 61, false);
        this.vecExtInfo = jceInputStream.read(cache_vecExtInfo, 62, false);
        this.uid = jceInputStream.readString(63, false);
        this.uRobotType = jceInputStream.read(this.uRobotType, 64, false);
        this.uRobotVersion = jceInputStream.read(this.uRobotVersion, 65, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.friendUin, 0);
        jceOutputStream.write(this.groupId, 1);
        jceOutputStream.write(this.faceId, 2);
        jceOutputStream.write(this.remark, 3);
        jceOutputStream.write(this.sqqtype, 4);
        jceOutputStream.write(this.status, 5);
        jceOutputStream.write(this.memberLevel, 6);
        jceOutputStream.write(this.isMqqOnLine, 7);
        jceOutputStream.write(this.sqqOnLineState, 8);
        jceOutputStream.write(this.isIphoneOnline, 9);
        jceOutputStream.write(this.detalStatusFlag, 10);
        jceOutputStream.write(this.sqqOnLineStateV2, 11);
        String str = this.sShowName;
        if (str != null) {
            jceOutputStream.write(str, 12);
        }
        jceOutputStream.write(this.isRemark, 13);
        String str2 = this.nick;
        if (str2 != null) {
            jceOutputStream.write(str2, 14);
        }
        jceOutputStream.write(this.cSpecialFlag, 15);
        byte[] bArr = this.vecIMGroupID;
        if (bArr != null) {
            jceOutputStream.write(bArr, 16);
        }
        byte[] bArr2 = this.vecMSFGroupID;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 17);
        }
        jceOutputStream.write(this.iTermType, 18);
        VipBaseInfo vipBaseInfo = this.oVipInfo;
        if (vipBaseInfo != null) {
            jceOutputStream.write((JceStruct) vipBaseInfo, 19);
        }
        jceOutputStream.write(this.cNetwork, 20);
        byte[] bArr3 = this.vecRing;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 21);
        }
        jceOutputStream.write(this.uAbiFlag, 22);
        jceOutputStream.write(this.ulFaceAddonId, 23);
        jceOutputStream.write(this.eNetworkType, 24);
        jceOutputStream.write(this.uVipFont, 25);
        jceOutputStream.write(this.eIconType, 26);
        String str3 = this.strTermDesc;
        if (str3 != null) {
            jceOutputStream.write(str3, 27);
        }
        jceOutputStream.write(this.uColorRing, 28);
        jceOutputStream.write(this.cApolloFlag, 29);
        jceOutputStream.write(this.uApolloTimestamp, 30);
        jceOutputStream.write(this.cSex, 31);
        jceOutputStream.write(this.uFounderFont, 32);
        String str4 = this.strEimId;
        if (str4 != null) {
            jceOutputStream.write(str4, 33);
        }
        String str5 = this.strEimMobile;
        if (str5 != null) {
            jceOutputStream.write(str5, 34);
        }
        jceOutputStream.write(this.cOlympicTorch, 35);
        jceOutputStream.write(this.uApolloSignTime, 36);
        jceOutputStream.write(this.uLaviUin, 37);
        jceOutputStream.write(this.uTagUpdateTime, 38);
        jceOutputStream.write(this.uGameLastLoginTime, 39);
        jceOutputStream.write(this.uGameAppid, 40);
        byte[] bArr4 = this.vecCardID;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 41);
        }
        jceOutputStream.write(this.ulBitSet, 42);
        jceOutputStream.write(this.cKingOfGloryFlag, 43);
        jceOutputStream.write(this.ulKingOfGloryRank, 44);
        String str6 = this.strMasterUin;
        if (str6 != null) {
            jceOutputStream.write(str6, 45);
        }
        jceOutputStream.write(this.uLastMedalUpdateTime, 46);
        jceOutputStream.write(this.uFaceStoreId, 47);
        jceOutputStream.write(this.uFontEffect, 48);
        String str7 = this.sDOVId;
        if (str7 != null) {
            jceOutputStream.write(str7, 49);
        }
        jceOutputStream.write(this.uBothFlag, 50);
        jceOutputStream.write(this.cCentiShow3DFlag, 51);
        byte[] bArr5 = this.vecIntimateInfo;
        if (bArr5 != null) {
            jceOutputStream.write(bArr5, 52);
        }
        jceOutputStream.write(this.cShowNameplate, 53);
        jceOutputStream.write(this.cNewLoverDiamondFlag, 54);
        byte[] bArr6 = this.vecExtSnsFrdData;
        if (bArr6 != null) {
            jceOutputStream.write(bArr6, 55);
        }
        byte[] bArr7 = this.vecMutualMarkData;
        if (bArr7 != null) {
            jceOutputStream.write(bArr7, 56);
        }
        jceOutputStream.write(this.uExtOnlineStatus, 57);
        jceOutputStream.write(this.iBatteryStatus, 58);
        byte[] bArr8 = this.vecMusicInfo;
        if (bArr8 != null) {
            jceOutputStream.write(bArr8, 59);
        }
        byte[] bArr9 = this.vecPoiInfo;
        if (bArr9 != null) {
            jceOutputStream.write(bArr9, 60);
        }
        byte[] bArr10 = this.vecExtOnlineBusinessInfo;
        if (bArr10 != null) {
            jceOutputStream.write(bArr10, 61);
        }
        byte[] bArr11 = this.vecExtInfo;
        if (bArr11 != null) {
            jceOutputStream.write(bArr11, 62);
        }
        String str8 = this.uid;
        if (str8 != null) {
            jceOutputStream.write(str8, 63);
        }
        jceOutputStream.write(this.uRobotType, 64);
        jceOutputStream.write(this.uRobotVersion, 65);
    }

    public FriendInfo(long j3, byte b16, short s16, String str, byte b17, byte b18, byte b19, byte b26, byte b27, byte b28, byte b29, byte b36, String str2, byte b37, String str3, byte b38, byte[] bArr, byte[] bArr2, int i3, VipBaseInfo vipBaseInfo, byte b39, byte[] bArr3, long j16, long j17, int i16, long j18, int i17, String str4, long j19, byte b46, long j26, byte b47, long j27, String str5, String str6, byte b48, long j28, long j29, long j36, long j37, long j38, byte[] bArr4, long j39, byte b49, long j46, String str7, long j47, long j48, long j49, String str8, long j56, byte b56, byte[] bArr5, byte b57, byte b58, byte[] bArr6, byte[] bArr7, long j57, int i18, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, String str9, long j58, long j59) {
        this.friendUin = j3;
        this.groupId = b16;
        this.faceId = s16;
        this.remark = str;
        this.sqqtype = b17;
        this.status = b18;
        this.memberLevel = b19;
        this.isMqqOnLine = b26;
        this.sqqOnLineState = b27;
        this.isIphoneOnline = b28;
        this.detalStatusFlag = b29;
        this.sqqOnLineStateV2 = b36;
        this.sShowName = str2;
        this.isRemark = b37;
        this.nick = str3;
        this.cSpecialFlag = b38;
        this.vecIMGroupID = bArr;
        this.vecMSFGroupID = bArr2;
        this.iTermType = i3;
        this.oVipInfo = vipBaseInfo;
        this.cNetwork = b39;
        this.vecRing = bArr3;
        this.uAbiFlag = j16;
        this.ulFaceAddonId = j17;
        this.eNetworkType = i16;
        this.uVipFont = j18;
        this.eIconType = i17;
        this.strTermDesc = str4;
        this.uColorRing = j19;
        this.cApolloFlag = b46;
        this.uApolloTimestamp = j26;
        this.cSex = b47;
        this.uFounderFont = j27;
        this.strEimId = str5;
        this.strEimMobile = str6;
        this.cOlympicTorch = b48;
        this.uApolloSignTime = j28;
        this.uLaviUin = j29;
        this.uTagUpdateTime = j36;
        this.uGameLastLoginTime = j37;
        this.uGameAppid = j38;
        this.vecCardID = bArr4;
        this.ulBitSet = j39;
        this.cKingOfGloryFlag = b49;
        this.ulKingOfGloryRank = j46;
        this.strMasterUin = str7;
        this.uLastMedalUpdateTime = j47;
        this.uFaceStoreId = j48;
        this.uFontEffect = j49;
        this.sDOVId = str8;
        this.uBothFlag = j56;
        this.cCentiShow3DFlag = b56;
        this.vecIntimateInfo = bArr5;
        this.cShowNameplate = b57;
        this.cNewLoverDiamondFlag = b58;
        this.vecExtSnsFrdData = bArr6;
        this.vecMutualMarkData = bArr7;
        this.uExtOnlineStatus = j57;
        this.iBatteryStatus = i18;
        this.vecMusicInfo = bArr8;
        this.vecPoiInfo = bArr9;
        this.vecExtOnlineBusinessInfo = bArr10;
        this.vecExtInfo = bArr11;
        this.uid = str9;
        this.uRobotType = j58;
        this.uRobotVersion = j59;
    }
}
