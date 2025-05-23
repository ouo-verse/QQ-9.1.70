package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class stTroopNum extends JceStruct {
    static byte[] cache_vecGroupRemark;
    public long GroupCode;
    public long GroupUin;
    public byte cFlag;
    public byte cIsConfGroup;
    public byte cIsModifyConfGroupFace;
    public byte cIsModifyConfGroupName;
    public long dwAdditionalFlag;
    public long dwAppPrivilegeFlag;
    public long dwAppealDeadline;
    public long dwCertificationType;
    public long dwCmdUinGroupMask;
    public long dwCmdUinUinFlag;
    public long dwCmduinJoinTime;
    public long dwGroupClassExt;
    public long dwGroupFlag;
    public long dwGroupFlagExt;
    public long dwGroupFlagExt3;
    public long dwGroupFlagExt4;
    public long dwGroupInfoSeq;
    public long dwGroupOwnerUin;
    public long dwGroupRankSeq;
    public long dwGroupSecType;
    public long dwGroupSecTypeInfo;
    public long dwGroupTypeFlag;
    public long dwMaxGroupMemberNum;
    public long dwMemberCardSeq;
    public long dwMemberNum;
    public long dwMemberNumSeq;
    public long dwMyShutupTimestamp;
    public long dwShutupTimestamp;
    public long dwSubscriptionUin;
    public long dwTransGroupConfMaxMsgSeq;
    public long dwTransGroupConfUin;
    public String strGroupMemo;
    public String strGroupName;
    public long udwCmdUinFlagEx2;
    public long udwCmdUinRingtoneID;
    public long udwHLGuildAppid;
    public long udwHLGuildSubType;
    public long ulCompanyId;
    public byte[] vecGroupRemark;

    static {
        cache_vecGroupRemark = r0;
        byte[] bArr = {0};
    }

    public stTroopNum() {
        this.GroupUin = 0L;
        this.GroupCode = 0L;
        this.cFlag = (byte) 0;
        this.dwGroupInfoSeq = 0L;
        this.strGroupName = "";
        this.strGroupMemo = "";
        this.dwGroupFlagExt = 0L;
        this.dwGroupRankSeq = 0L;
        this.dwCertificationType = 0L;
        this.dwShutupTimestamp = 0L;
        this.dwMyShutupTimestamp = 0L;
        this.dwCmdUinUinFlag = 0L;
        this.dwAdditionalFlag = 0L;
        this.dwGroupTypeFlag = 0L;
        this.dwGroupSecType = 0L;
        this.dwGroupSecTypeInfo = 0L;
        this.dwGroupClassExt = 0L;
        this.dwAppPrivilegeFlag = 0L;
        this.dwSubscriptionUin = 0L;
        this.dwMemberNum = 0L;
        this.dwMemberNumSeq = 0L;
        this.dwMemberCardSeq = 0L;
        this.dwGroupFlagExt3 = 0L;
        this.dwGroupOwnerUin = 0L;
        this.cIsConfGroup = (byte) 0;
        this.cIsModifyConfGroupFace = (byte) 0;
        this.cIsModifyConfGroupName = (byte) 0;
        this.dwCmduinJoinTime = 0L;
        this.ulCompanyId = 0L;
        this.dwMaxGroupMemberNum = 0L;
        this.dwCmdUinGroupMask = 0L;
        this.udwHLGuildAppid = 0L;
        this.udwHLGuildSubType = 0L;
        this.udwCmdUinRingtoneID = 0L;
        this.udwCmdUinFlagEx2 = 0L;
        this.dwGroupFlagExt4 = 0L;
        this.dwAppealDeadline = 0L;
        this.dwGroupFlag = 0L;
        this.vecGroupRemark = null;
        this.dwTransGroupConfUin = 0L;
        this.dwTransGroupConfMaxMsgSeq = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.GroupUin = jceInputStream.read(this.GroupUin, 0, true);
        this.GroupCode = jceInputStream.read(this.GroupCode, 1, true);
        this.cFlag = jceInputStream.read(this.cFlag, 2, false);
        this.dwGroupInfoSeq = jceInputStream.read(this.dwGroupInfoSeq, 3, false);
        this.strGroupName = jceInputStream.readString(4, false);
        this.strGroupMemo = jceInputStream.readString(5, false);
        this.dwGroupFlagExt = jceInputStream.read(this.dwGroupFlagExt, 6, false);
        this.dwGroupRankSeq = jceInputStream.read(this.dwGroupRankSeq, 7, false);
        this.dwCertificationType = jceInputStream.read(this.dwCertificationType, 8, false);
        this.dwShutupTimestamp = jceInputStream.read(this.dwShutupTimestamp, 9, false);
        this.dwMyShutupTimestamp = jceInputStream.read(this.dwMyShutupTimestamp, 10, false);
        this.dwCmdUinUinFlag = jceInputStream.read(this.dwCmdUinUinFlag, 11, false);
        this.dwAdditionalFlag = jceInputStream.read(this.dwAdditionalFlag, 12, false);
        this.dwGroupTypeFlag = jceInputStream.read(this.dwGroupTypeFlag, 13, false);
        this.dwGroupSecType = jceInputStream.read(this.dwGroupSecType, 14, false);
        this.dwGroupSecTypeInfo = jceInputStream.read(this.dwGroupSecTypeInfo, 15, false);
        this.dwGroupClassExt = jceInputStream.read(this.dwGroupClassExt, 16, false);
        this.dwAppPrivilegeFlag = jceInputStream.read(this.dwAppPrivilegeFlag, 17, false);
        this.dwSubscriptionUin = jceInputStream.read(this.dwSubscriptionUin, 18, false);
        this.dwMemberNum = jceInputStream.read(this.dwMemberNum, 19, false);
        this.dwMemberNumSeq = jceInputStream.read(this.dwMemberNumSeq, 20, false);
        this.dwMemberCardSeq = jceInputStream.read(this.dwMemberCardSeq, 21, false);
        this.dwGroupFlagExt3 = jceInputStream.read(this.dwGroupFlagExt3, 22, false);
        this.dwGroupOwnerUin = jceInputStream.read(this.dwGroupOwnerUin, 23, false);
        this.cIsConfGroup = jceInputStream.read(this.cIsConfGroup, 24, false);
        this.cIsModifyConfGroupFace = jceInputStream.read(this.cIsModifyConfGroupFace, 25, false);
        this.cIsModifyConfGroupName = jceInputStream.read(this.cIsModifyConfGroupName, 26, false);
        this.dwCmduinJoinTime = jceInputStream.read(this.dwCmduinJoinTime, 27, false);
        this.ulCompanyId = jceInputStream.read(this.ulCompanyId, 28, false);
        this.dwMaxGroupMemberNum = jceInputStream.read(this.dwMaxGroupMemberNum, 29, false);
        this.dwCmdUinGroupMask = jceInputStream.read(this.dwCmdUinGroupMask, 30, false);
        this.udwHLGuildAppid = jceInputStream.read(this.udwHLGuildAppid, 31, false);
        this.udwHLGuildSubType = jceInputStream.read(this.udwHLGuildSubType, 32, false);
        this.udwCmdUinRingtoneID = jceInputStream.read(this.udwCmdUinRingtoneID, 33, false);
        this.udwCmdUinFlagEx2 = jceInputStream.read(this.udwCmdUinFlagEx2, 34, false);
        this.dwGroupFlagExt4 = jceInputStream.read(this.dwGroupFlagExt4, 35, false);
        this.dwAppealDeadline = jceInputStream.read(this.dwAppealDeadline, 36, false);
        this.dwGroupFlag = jceInputStream.read(this.dwGroupFlag, 37, false);
        this.vecGroupRemark = jceInputStream.read(cache_vecGroupRemark, 38, false);
        this.dwTransGroupConfUin = jceInputStream.read(this.dwTransGroupConfUin, 39, false);
        this.dwTransGroupConfMaxMsgSeq = jceInputStream.read(this.dwTransGroupConfMaxMsgSeq, 40, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.GroupUin, 0);
        jceOutputStream.write(this.GroupCode, 1);
        jceOutputStream.write(this.cFlag, 2);
        jceOutputStream.write(this.dwGroupInfoSeq, 3);
        String str = this.strGroupName;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.strGroupMemo;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.dwGroupFlagExt, 6);
        jceOutputStream.write(this.dwGroupRankSeq, 7);
        jceOutputStream.write(this.dwCertificationType, 8);
        jceOutputStream.write(this.dwShutupTimestamp, 9);
        jceOutputStream.write(this.dwMyShutupTimestamp, 10);
        jceOutputStream.write(this.dwCmdUinUinFlag, 11);
        jceOutputStream.write(this.dwAdditionalFlag, 12);
        jceOutputStream.write(this.dwGroupTypeFlag, 13);
        jceOutputStream.write(this.dwGroupSecType, 14);
        jceOutputStream.write(this.dwGroupSecTypeInfo, 15);
        jceOutputStream.write(this.dwGroupClassExt, 16);
        jceOutputStream.write(this.dwAppPrivilegeFlag, 17);
        jceOutputStream.write(this.dwSubscriptionUin, 18);
        jceOutputStream.write(this.dwMemberNum, 19);
        jceOutputStream.write(this.dwMemberNumSeq, 20);
        jceOutputStream.write(this.dwMemberCardSeq, 21);
        jceOutputStream.write(this.dwGroupFlagExt3, 22);
        jceOutputStream.write(this.dwGroupOwnerUin, 23);
        jceOutputStream.write(this.cIsConfGroup, 24);
        jceOutputStream.write(this.cIsModifyConfGroupFace, 25);
        jceOutputStream.write(this.cIsModifyConfGroupName, 26);
        jceOutputStream.write(this.dwCmduinJoinTime, 27);
        jceOutputStream.write(this.ulCompanyId, 28);
        jceOutputStream.write(this.dwMaxGroupMemberNum, 29);
        jceOutputStream.write(this.dwCmdUinGroupMask, 30);
        jceOutputStream.write(this.udwHLGuildAppid, 31);
        jceOutputStream.write(this.udwHLGuildSubType, 32);
        jceOutputStream.write(this.udwCmdUinRingtoneID, 33);
        jceOutputStream.write(this.udwCmdUinFlagEx2, 34);
        jceOutputStream.write(this.dwGroupFlagExt4, 35);
        jceOutputStream.write(this.dwAppealDeadline, 36);
        jceOutputStream.write(this.dwGroupFlag, 37);
        byte[] bArr = this.vecGroupRemark;
        if (bArr != null) {
            jceOutputStream.write(bArr, 38);
        }
        jceOutputStream.write(this.dwTransGroupConfUin, 39);
        jceOutputStream.write(this.dwTransGroupConfMaxMsgSeq, 40);
    }

    public stTroopNum(long j3, long j16, byte b16, long j17, String str, String str2, long j18, long j19, long j26, long j27, long j28, long j29, long j36, long j37, long j38, long j39, long j46, long j47, long j48, long j49, long j56, long j57, long j58, long j59, byte b17, byte b18, byte b19, long j65, long j66, long j67, long j68, long j69, long j75, long j76, long j77, long j78, long j79, long j85, byte[] bArr, long j86, long j87) {
        this.GroupUin = j3;
        this.GroupCode = j16;
        this.cFlag = b16;
        this.dwGroupInfoSeq = j17;
        this.strGroupName = str;
        this.strGroupMemo = str2;
        this.dwGroupFlagExt = j18;
        this.dwGroupRankSeq = j19;
        this.dwCertificationType = j26;
        this.dwShutupTimestamp = j27;
        this.dwMyShutupTimestamp = j28;
        this.dwCmdUinUinFlag = j29;
        this.dwAdditionalFlag = j36;
        this.dwGroupTypeFlag = j37;
        this.dwGroupSecType = j38;
        this.dwGroupSecTypeInfo = j39;
        this.dwGroupClassExt = j46;
        this.dwAppPrivilegeFlag = j47;
        this.dwSubscriptionUin = j48;
        this.dwMemberNum = j49;
        this.dwMemberNumSeq = j56;
        this.dwMemberCardSeq = j57;
        this.dwGroupFlagExt3 = j58;
        this.dwGroupOwnerUin = j59;
        this.cIsConfGroup = b17;
        this.cIsModifyConfGroupFace = b18;
        this.cIsModifyConfGroupName = b19;
        this.dwCmduinJoinTime = j65;
        this.ulCompanyId = j66;
        this.dwMaxGroupMemberNum = j67;
        this.dwCmdUinGroupMask = j68;
        this.udwHLGuildAppid = j69;
        this.udwHLGuildSubType = j75;
        this.udwCmdUinRingtoneID = j76;
        this.udwCmdUinFlagEx2 = j77;
        this.dwGroupFlagExt4 = j78;
        this.dwAppealDeadline = j79;
        this.dwGroupFlag = j85;
        this.vecGroupRemark = bArr;
        this.dwTransGroupConfUin = j86;
        this.dwTransGroupConfMaxMsgSeq = j87;
    }
}
