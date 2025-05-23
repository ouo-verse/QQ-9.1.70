package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupMngReq extends JceStruct {
    static byte[] cache_joinGroupTransInfo;
    static int cache_reqtype;
    static byte[] cache_secSign;
    static byte[] cache_vecBody;
    static byte[] cache_vecJoinGroupRichMsg;
    public byte cCheckInGroup;
    public byte cIfGetAuthInfo;
    public byte cIsSupportAuthQuestionJoin;
    public byte cStatOption;
    public long dwDiscussUin;
    public long dwJoinVerifyType;
    public byte[] joinGroupTransInfo;
    public int reqtype;
    public String sGroupLocation;
    public String sJoinGroupAuth;
    public String sJoinGroupKey;
    public String sJoinGroupPicUrl;
    public String sJoinGroupVerifyToken;
    public byte[] secSign;
    public long uin;
    public byte[] vecBody;
    public byte[] vecJoinGroupRichMsg;
    public int wSourceID;
    public int wSourceSubID;

    static {
        cache_vecBody = r1;
        byte[] bArr = {0};
        cache_vecJoinGroupRichMsg = r1;
        byte[] bArr2 = {0};
        cache_secSign = r1;
        byte[] bArr3 = {0};
        cache_joinGroupTransInfo = r0;
        byte[] bArr4 = {0};
    }

    public GroupMngReq() {
        this.reqtype = 0;
        this.uin = 0L;
        this.vecBody = null;
        this.cCheckInGroup = (byte) 0;
        this.sGroupLocation = "";
        this.cStatOption = (byte) 0;
        this.wSourceID = 0;
        this.wSourceSubID = 0;
        this.cIsSupportAuthQuestionJoin = (byte) 0;
        this.cIfGetAuthInfo = (byte) 0;
        this.dwDiscussUin = 0L;
        this.sJoinGroupKey = "";
        this.sJoinGroupPicUrl = "";
        this.vecJoinGroupRichMsg = null;
        this.sJoinGroupAuth = "";
        this.sJoinGroupVerifyToken = "";
        this.dwJoinVerifyType = 0L;
        this.secSign = null;
        this.joinGroupTransInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reqtype = jceInputStream.read(this.reqtype, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.vecBody = jceInputStream.read(cache_vecBody, 2, true);
        this.cCheckInGroup = jceInputStream.read(this.cCheckInGroup, 3, false);
        this.sGroupLocation = jceInputStream.readString(4, false);
        this.cStatOption = jceInputStream.read(this.cStatOption, 5, false);
        this.wSourceID = jceInputStream.read(this.wSourceID, 6, false);
        this.wSourceSubID = jceInputStream.read(this.wSourceSubID, 7, false);
        this.cIsSupportAuthQuestionJoin = jceInputStream.read(this.cIsSupportAuthQuestionJoin, 8, false);
        this.cIfGetAuthInfo = jceInputStream.read(this.cIfGetAuthInfo, 9, false);
        this.dwDiscussUin = jceInputStream.read(this.dwDiscussUin, 10, false);
        this.sJoinGroupKey = jceInputStream.readString(11, false);
        this.sJoinGroupPicUrl = jceInputStream.readString(12, false);
        this.vecJoinGroupRichMsg = jceInputStream.read(cache_vecJoinGroupRichMsg, 13, false);
        this.sJoinGroupAuth = jceInputStream.readString(14, false);
        this.sJoinGroupVerifyToken = jceInputStream.readString(15, false);
        this.dwJoinVerifyType = jceInputStream.read(this.dwJoinVerifyType, 16, false);
        this.secSign = jceInputStream.read(cache_secSign, 17, false);
        this.joinGroupTransInfo = jceInputStream.read(cache_joinGroupTransInfo, 18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reqtype, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.vecBody, 2);
        jceOutputStream.write(this.cCheckInGroup, 3);
        String str = this.sGroupLocation;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.cStatOption, 5);
        jceOutputStream.write(this.wSourceID, 6);
        jceOutputStream.write(this.wSourceSubID, 7);
        jceOutputStream.write(this.cIsSupportAuthQuestionJoin, 8);
        jceOutputStream.write(this.cIfGetAuthInfo, 9);
        jceOutputStream.write(this.dwDiscussUin, 10);
        String str2 = this.sJoinGroupKey;
        if (str2 != null) {
            jceOutputStream.write(str2, 11);
        }
        String str3 = this.sJoinGroupPicUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 12);
        }
        byte[] bArr = this.vecJoinGroupRichMsg;
        if (bArr != null) {
            jceOutputStream.write(bArr, 13);
        }
        String str4 = this.sJoinGroupAuth;
        if (str4 != null) {
            jceOutputStream.write(str4, 14);
        }
        String str5 = this.sJoinGroupVerifyToken;
        if (str5 != null) {
            jceOutputStream.write(str5, 15);
        }
        jceOutputStream.write(this.dwJoinVerifyType, 16);
        byte[] bArr2 = this.secSign;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 17);
        }
        byte[] bArr3 = this.joinGroupTransInfo;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 18);
        }
    }

    public GroupMngReq(int i3, long j3, byte[] bArr, byte b16, String str, byte b17, int i16, int i17, byte b18, byte b19, long j16, String str2, String str3, byte[] bArr2, String str4, String str5, long j17, byte[] bArr3, byte[] bArr4) {
        this.reqtype = i3;
        this.uin = j3;
        this.vecBody = bArr;
        this.cCheckInGroup = b16;
        this.sGroupLocation = str;
        this.cStatOption = b17;
        this.wSourceID = i16;
        this.wSourceSubID = i17;
        this.cIsSupportAuthQuestionJoin = b18;
        this.cIfGetAuthInfo = b19;
        this.dwDiscussUin = j16;
        this.sJoinGroupKey = str2;
        this.sJoinGroupPicUrl = str3;
        this.vecJoinGroupRichMsg = bArr2;
        this.sJoinGroupAuth = str4;
        this.sJoinGroupVerifyToken = str5;
        this.dwJoinVerifyType = j17;
        this.secSign = bArr3;
        this.joinGroupTransInfo = bArr4;
    }
}
