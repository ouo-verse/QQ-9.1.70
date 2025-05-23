package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class stTroopMemberInfo extends JceStruct {
    static QzoneUserInfo cache_qzusrinfo = new QzoneUserInfo();
    static byte[] cache_vecGroupHonor;
    static byte[] cache_vecName;
    public byte Age;
    public short FaceId;
    public byte Gender;
    public String MemberUid;
    public long MemberUin;
    public String Nick;
    public byte Status;
    public String bytes_job;
    public byte cApolloFlag;
    public byte cConcerned;
    public byte cGender;
    public byte cRichCardNameVer;
    public byte cRichFlag;
    public byte cShielded;
    public long dwApolloTimestamp;
    public long dwBigClubFlag;
    public long dwBigClubLevel;
    public long dwCreditLevel;
    public long dwFlag;
    public long dwFlagExt;
    public long dwGlobalGroupLevel;
    public long dwGlobalGroupPoint;
    public long dwJoinTime;
    public long dwLastSpeakTime;
    public long dwMemberLevel;
    public long dwNameplate;
    public long dwPoint;
    public long dwShutupTimestap;
    public long dwSpecialTitleExpireTime;
    public long dwTitleId;
    public long dwVipLevel;
    public long dwVipType;
    public QzoneUserInfo qzusrinfo;
    public String sEmail;
    public String sMemo;
    public String sName;
    public String sPhone;
    public String sShowName;
    public String sSpecialTitle;
    public String strAutoRemark;
    public byte[] vecGroupHonor;
    public byte[] vecName;

    static {
        cache_vecGroupHonor = r1;
        byte[] bArr = {0};
        cache_vecName = r0;
        byte[] bArr2 = {0};
    }

    public stTroopMemberInfo() {
        this.MemberUin = 0L;
        this.FaceId = (short) 0;
        this.Age = (byte) 0;
        this.Gender = (byte) 0;
        this.Nick = "";
        this.Status = QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA;
        this.sShowName = "";
        this.sName = "";
        this.cGender = (byte) 0;
        this.sPhone = "";
        this.sEmail = "";
        this.sMemo = "";
        this.strAutoRemark = "";
        this.dwMemberLevel = 0L;
        this.dwJoinTime = 0L;
        this.dwLastSpeakTime = 0L;
        this.dwCreditLevel = 0L;
        this.dwFlag = 0L;
        this.dwFlagExt = 0L;
        this.dwPoint = 0L;
        this.cConcerned = (byte) 0;
        this.cShielded = (byte) 0;
        this.sSpecialTitle = "";
        this.dwSpecialTitleExpireTime = 0L;
        this.bytes_job = "";
        this.cApolloFlag = (byte) 0;
        this.dwApolloTimestamp = 0L;
        this.dwGlobalGroupLevel = 0L;
        this.dwTitleId = 0L;
        this.dwShutupTimestap = 0L;
        this.dwGlobalGroupPoint = 0L;
        this.qzusrinfo = null;
        this.cRichCardNameVer = (byte) 0;
        this.dwVipType = 0L;
        this.dwVipLevel = 0L;
        this.dwBigClubLevel = 0L;
        this.dwBigClubFlag = 0L;
        this.dwNameplate = 0L;
        this.vecGroupHonor = null;
        this.vecName = null;
        this.cRichFlag = (byte) 0;
        this.MemberUid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.MemberUin = jceInputStream.read(this.MemberUin, 0, true);
        this.FaceId = jceInputStream.read(this.FaceId, 1, true);
        this.Age = jceInputStream.read(this.Age, 2, true);
        this.Gender = jceInputStream.read(this.Gender, 3, true);
        this.Nick = jceInputStream.readString(4, true);
        this.Status = jceInputStream.read(this.Status, 5, true);
        this.sShowName = jceInputStream.readString(6, false);
        this.sName = jceInputStream.readString(8, false);
        this.cGender = jceInputStream.read(this.cGender, 9, false);
        this.sPhone = jceInputStream.readString(10, false);
        this.sEmail = jceInputStream.readString(11, false);
        this.sMemo = jceInputStream.readString(12, false);
        this.strAutoRemark = jceInputStream.readString(13, false);
        this.dwMemberLevel = jceInputStream.read(this.dwMemberLevel, 14, false);
        this.dwJoinTime = jceInputStream.read(this.dwJoinTime, 15, false);
        this.dwLastSpeakTime = jceInputStream.read(this.dwLastSpeakTime, 16, false);
        this.dwCreditLevel = jceInputStream.read(this.dwCreditLevel, 17, false);
        this.dwFlag = jceInputStream.read(this.dwFlag, 18, false);
        this.dwFlagExt = jceInputStream.read(this.dwFlagExt, 19, false);
        this.dwPoint = jceInputStream.read(this.dwPoint, 20, false);
        this.cConcerned = jceInputStream.read(this.cConcerned, 21, false);
        this.cShielded = jceInputStream.read(this.cShielded, 22, false);
        this.sSpecialTitle = jceInputStream.readString(23, false);
        this.dwSpecialTitleExpireTime = jceInputStream.read(this.dwSpecialTitleExpireTime, 24, false);
        this.bytes_job = jceInputStream.readString(25, false);
        this.cApolloFlag = jceInputStream.read(this.cApolloFlag, 26, false);
        this.dwApolloTimestamp = jceInputStream.read(this.dwApolloTimestamp, 27, false);
        this.dwGlobalGroupLevel = jceInputStream.read(this.dwGlobalGroupLevel, 28, false);
        this.dwTitleId = jceInputStream.read(this.dwTitleId, 29, false);
        this.dwShutupTimestap = jceInputStream.read(this.dwShutupTimestap, 30, false);
        this.dwGlobalGroupPoint = jceInputStream.read(this.dwGlobalGroupPoint, 31, false);
        this.qzusrinfo = (QzoneUserInfo) jceInputStream.read((JceStruct) cache_qzusrinfo, 32, false);
        this.cRichCardNameVer = jceInputStream.read(this.cRichCardNameVer, 33, false);
        this.dwVipType = jceInputStream.read(this.dwVipType, 34, false);
        this.dwVipLevel = jceInputStream.read(this.dwVipLevel, 35, false);
        this.dwBigClubLevel = jceInputStream.read(this.dwBigClubLevel, 36, false);
        this.dwBigClubFlag = jceInputStream.read(this.dwBigClubFlag, 37, false);
        this.dwNameplate = jceInputStream.read(this.dwNameplate, 38, false);
        this.vecGroupHonor = jceInputStream.read(cache_vecGroupHonor, 39, false);
        this.vecName = jceInputStream.read(cache_vecName, 40, false);
        this.cRichFlag = jceInputStream.read(this.cRichFlag, 41, false);
        this.MemberUid = jceInputStream.readString(42, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.MemberUin, 0);
        jceOutputStream.write(this.FaceId, 1);
        jceOutputStream.write(this.Age, 2);
        jceOutputStream.write(this.Gender, 3);
        jceOutputStream.write(this.Nick, 4);
        jceOutputStream.write(this.Status, 5);
        String str = this.sShowName;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        String str2 = this.sName;
        if (str2 != null) {
            jceOutputStream.write(str2, 8);
        }
        jceOutputStream.write(this.cGender, 9);
        String str3 = this.sPhone;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        String str4 = this.sEmail;
        if (str4 != null) {
            jceOutputStream.write(str4, 11);
        }
        String str5 = this.sMemo;
        if (str5 != null) {
            jceOutputStream.write(str5, 12);
        }
        String str6 = this.strAutoRemark;
        if (str6 != null) {
            jceOutputStream.write(str6, 13);
        }
        jceOutputStream.write(this.dwMemberLevel, 14);
        jceOutputStream.write(this.dwJoinTime, 15);
        jceOutputStream.write(this.dwLastSpeakTime, 16);
        jceOutputStream.write(this.dwCreditLevel, 17);
        jceOutputStream.write(this.dwFlag, 18);
        jceOutputStream.write(this.dwFlagExt, 19);
        jceOutputStream.write(this.dwPoint, 20);
        jceOutputStream.write(this.cConcerned, 21);
        jceOutputStream.write(this.cShielded, 22);
        String str7 = this.sSpecialTitle;
        if (str7 != null) {
            jceOutputStream.write(str7, 23);
        }
        jceOutputStream.write(this.dwSpecialTitleExpireTime, 24);
        String str8 = this.bytes_job;
        if (str8 != null) {
            jceOutputStream.write(str8, 25);
        }
        jceOutputStream.write(this.cApolloFlag, 26);
        jceOutputStream.write(this.dwApolloTimestamp, 27);
        jceOutputStream.write(this.dwGlobalGroupLevel, 28);
        jceOutputStream.write(this.dwTitleId, 29);
        jceOutputStream.write(this.dwShutupTimestap, 30);
        jceOutputStream.write(this.dwGlobalGroupPoint, 31);
        QzoneUserInfo qzoneUserInfo = this.qzusrinfo;
        if (qzoneUserInfo != null) {
            jceOutputStream.write((JceStruct) qzoneUserInfo, 32);
        }
        jceOutputStream.write(this.cRichCardNameVer, 33);
        jceOutputStream.write(this.dwVipType, 34);
        jceOutputStream.write(this.dwVipLevel, 35);
        jceOutputStream.write(this.dwBigClubLevel, 36);
        jceOutputStream.write(this.dwBigClubFlag, 37);
        jceOutputStream.write(this.dwNameplate, 38);
        byte[] bArr = this.vecGroupHonor;
        if (bArr != null) {
            jceOutputStream.write(bArr, 39);
        }
        byte[] bArr2 = this.vecName;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 40);
        }
        jceOutputStream.write(this.cRichFlag, 41);
        String str9 = this.MemberUid;
        if (str9 != null) {
            jceOutputStream.write(str9, 42);
        }
    }

    public stTroopMemberInfo(long j3, short s16, byte b16, byte b17, String str, byte b18, String str2, String str3, byte b19, String str4, String str5, String str6, String str7, long j16, long j17, long j18, long j19, long j26, long j27, long j28, byte b26, byte b27, String str8, long j29, String str9, byte b28, long j36, long j37, long j38, long j39, long j46, QzoneUserInfo qzoneUserInfo, byte b29, long j47, long j48, long j49, long j56, long j57, byte[] bArr, byte[] bArr2, byte b36, String str10) {
        this.MemberUin = j3;
        this.FaceId = s16;
        this.Age = b16;
        this.Gender = b17;
        this.Nick = str;
        this.Status = b18;
        this.sShowName = str2;
        this.sName = str3;
        this.cGender = b19;
        this.sPhone = str4;
        this.sEmail = str5;
        this.sMemo = str6;
        this.strAutoRemark = str7;
        this.dwMemberLevel = j16;
        this.dwJoinTime = j17;
        this.dwLastSpeakTime = j18;
        this.dwCreditLevel = j19;
        this.dwFlag = j26;
        this.dwFlagExt = j27;
        this.dwPoint = j28;
        this.cConcerned = b26;
        this.cShielded = b27;
        this.sSpecialTitle = str8;
        this.dwSpecialTitleExpireTime = j29;
        this.bytes_job = str9;
        this.cApolloFlag = b28;
        this.dwApolloTimestamp = j36;
        this.dwGlobalGroupLevel = j37;
        this.dwTitleId = j38;
        this.dwShutupTimestap = j39;
        this.dwGlobalGroupPoint = j46;
        this.qzusrinfo = qzoneUserInfo;
        this.cRichCardNameVer = b29;
        this.dwVipType = j47;
        this.dwVipLevel = j48;
        this.dwBigClubLevel = j49;
        this.dwBigClubFlag = j56;
        this.dwNameplate = j57;
        this.vecGroupHonor = bArr;
        this.vecName = bArr2;
        this.cRichFlag = b36;
        this.MemberUid = str10;
    }
}
