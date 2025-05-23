package NeighborSvc;

import NeighborComm.MerchantType;
import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespNeighborInfo extends JceStruct {
    static int cache_eMerchantType;
    static byte[] cache_vFaceID;
    static byte[] cache_vIntroContent;
    static VipBaseInfo cache_vipBaseInfo;
    public byte bIsSingle;
    public byte cAge;
    public byte cGroupId;
    public byte cSex;
    public int eMerchantType;
    public int iDistance;
    public int iRank;
    public int iVoteIncrement;
    public long lNBID;
    public int lTime;
    public long lTotalVisitorsNum;
    public int nFaceNum;
    public short shIntroType;
    public String strCertification;
    public String strCompanyName;
    public String strDescription;
    public String strNick;
    public String strPYFaceUrl;
    public String strPYName;
    public String strSchoolName;
    public byte[] vFaceID;
    public byte[] vIntroContent;
    public VipBaseInfo vipBaseInfo;

    public RespNeighborInfo() {
        this.lNBID = 0L;
        this.iDistance = 0;
        this.lTime = 0;
        this.strDescription = "";
        this.cGroupId = (byte) 0;
        this.cSex = (byte) -1;
        this.cAge = (byte) -1;
        this.strPYFaceUrl = "";
        this.strSchoolName = "";
        this.strCompanyName = "";
        this.strPYName = "";
        this.eMerchantType = MerchantType.MerchantType_Nomal.value();
        this.strNick = "";
        this.nFaceNum = 0;
        this.strCertification = "";
        this.shIntroType = (short) 0;
        this.vIntroContent = null;
        this.vFaceID = null;
        this.iVoteIncrement = -1;
        this.bIsSingle = (byte) 0;
        this.iRank = 0;
        this.lTotalVisitorsNum = 0L;
        this.vipBaseInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lNBID = jceInputStream.read(this.lNBID, 0, true);
        this.iDistance = jceInputStream.read(this.iDistance, 1, true);
        this.lTime = jceInputStream.read(this.lTime, 2, true);
        this.strDescription = jceInputStream.readString(3, false);
        this.cGroupId = jceInputStream.read(this.cGroupId, 4, false);
        this.cSex = jceInputStream.read(this.cSex, 5, false);
        this.cAge = jceInputStream.read(this.cAge, 6, false);
        this.strPYFaceUrl = jceInputStream.readString(7, false);
        this.strSchoolName = jceInputStream.readString(8, false);
        this.strCompanyName = jceInputStream.readString(9, false);
        this.strPYName = jceInputStream.readString(10, false);
        this.eMerchantType = jceInputStream.read(this.eMerchantType, 11, false);
        this.strNick = jceInputStream.readString(12, false);
        this.nFaceNum = jceInputStream.read(this.nFaceNum, 13, false);
        this.strCertification = jceInputStream.readString(14, false);
        this.shIntroType = jceInputStream.read(this.shIntroType, 15, false);
        if (cache_vIntroContent == null) {
            cache_vIntroContent = r0;
            byte[] bArr = {0};
        }
        this.vIntroContent = jceInputStream.read(cache_vIntroContent, 16, false);
        if (cache_vFaceID == null) {
            cache_vFaceID = r0;
            byte[] bArr2 = {0};
        }
        this.vFaceID = jceInputStream.read(cache_vFaceID, 17, false);
        this.iVoteIncrement = jceInputStream.read(this.iVoteIncrement, 18, false);
        this.bIsSingle = jceInputStream.read(this.bIsSingle, 19, false);
        this.iRank = jceInputStream.read(this.iRank, 20, false);
        this.lTotalVisitorsNum = jceInputStream.read(this.lTotalVisitorsNum, 21, false);
        if (cache_vipBaseInfo == null) {
            cache_vipBaseInfo = new VipBaseInfo();
        }
        this.vipBaseInfo = (VipBaseInfo) jceInputStream.read((JceStruct) cache_vipBaseInfo, 22, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lNBID, 0);
        jceOutputStream.write(this.iDistance, 1);
        jceOutputStream.write(this.lTime, 2);
        String str = this.strDescription;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.cGroupId, 4);
        jceOutputStream.write(this.cSex, 5);
        jceOutputStream.write(this.cAge, 6);
        String str2 = this.strPYFaceUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        String str3 = this.strSchoolName;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        String str4 = this.strCompanyName;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        String str5 = this.strPYName;
        if (str5 != null) {
            jceOutputStream.write(str5, 10);
        }
        jceOutputStream.write(this.eMerchantType, 11);
        String str6 = this.strNick;
        if (str6 != null) {
            jceOutputStream.write(str6, 12);
        }
        jceOutputStream.write(this.nFaceNum, 13);
        String str7 = this.strCertification;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
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
        jceOutputStream.write(this.iVoteIncrement, 18);
        jceOutputStream.write(this.bIsSingle, 19);
        jceOutputStream.write(this.iRank, 20);
        jceOutputStream.write(this.lTotalVisitorsNum, 21);
        VipBaseInfo vipBaseInfo = this.vipBaseInfo;
        if (vipBaseInfo != null) {
            jceOutputStream.write((JceStruct) vipBaseInfo, 22);
        }
    }

    public RespNeighborInfo(long j3, int i3, int i16, String str, byte b16, byte b17, byte b18, String str2, String str3, String str4, String str5, int i17, String str6, int i18, String str7, short s16, byte[] bArr, byte[] bArr2, int i19, byte b19, int i26, long j16, VipBaseInfo vipBaseInfo) {
        this.lNBID = 0L;
        this.iDistance = 0;
        this.lTime = 0;
        this.strDescription = "";
        this.cGroupId = (byte) 0;
        this.cSex = (byte) -1;
        this.cAge = (byte) -1;
        this.strPYFaceUrl = "";
        this.strSchoolName = "";
        this.strCompanyName = "";
        this.strPYName = "";
        MerchantType.MerchantType_Nomal.value();
        this.lNBID = j3;
        this.iDistance = i3;
        this.lTime = i16;
        this.strDescription = str;
        this.cGroupId = b16;
        this.cSex = b17;
        this.cAge = b18;
        this.strPYFaceUrl = str2;
        this.strSchoolName = str3;
        this.strCompanyName = str4;
        this.strPYName = str5;
        this.eMerchantType = i17;
        this.strNick = str6;
        this.nFaceNum = i18;
        this.strCertification = str7;
        this.shIntroType = s16;
        this.vIntroContent = bArr;
        this.vFaceID = bArr2;
        this.iVoteIncrement = i19;
        this.bIsSingle = b19;
        this.iRank = i26;
        this.lTotalVisitorsNum = j16;
        this.vipBaseInfo = vipBaseInfo;
    }
}
