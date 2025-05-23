package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupMngRes extends JceStruct {
    static int cache_reqtype;
    static byte[] cache_vecBody;
    static byte[] cache_vecJoinPrompt;
    static byte[] cache_vecKaiyangTransInfo;
    public String ErrorString;
    public byte cIsInGroup;
    public byte cIsMemInvite;
    public long dwDis2GrpLimitType;
    public short errorCode;
    public int reqtype;
    public byte result;
    public String sAuthGrpInfo;
    public String sGroupLocation;
    public String sJoinAnswer;
    public String sJoinQuestion;
    public byte[] vecBody;
    public byte[] vecJoinPrompt;
    public byte[] vecKaiyangTransInfo;

    static {
        cache_vecBody = r1;
        byte[] bArr = {0};
        cache_vecJoinPrompt = r1;
        byte[] bArr2 = {0};
        cache_vecKaiyangTransInfo = r0;
        byte[] bArr3 = {0};
    }

    public GroupMngRes() {
        this.reqtype = 0;
        this.result = (byte) 0;
        this.vecBody = null;
        this.ErrorString = "";
        this.errorCode = (short) 0;
        this.cIsInGroup = (byte) 0;
        this.sGroupLocation = "";
        this.cIsMemInvite = (byte) 0;
        this.sAuthGrpInfo = "";
        this.sJoinQuestion = "";
        this.sJoinAnswer = "";
        this.dwDis2GrpLimitType = 0L;
        this.vecJoinPrompt = null;
        this.vecKaiyangTransInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reqtype = jceInputStream.read(this.reqtype, 0, true);
        this.result = jceInputStream.read(this.result, 1, true);
        this.vecBody = jceInputStream.read(cache_vecBody, 2, true);
        this.ErrorString = jceInputStream.readString(3, true);
        this.errorCode = jceInputStream.read(this.errorCode, 4, false);
        this.cIsInGroup = jceInputStream.read(this.cIsInGroup, 5, false);
        this.sGroupLocation = jceInputStream.readString(6, false);
        this.cIsMemInvite = jceInputStream.read(this.cIsMemInvite, 7, false);
        this.sAuthGrpInfo = jceInputStream.readString(8, false);
        this.sJoinQuestion = jceInputStream.readString(9, false);
        this.sJoinAnswer = jceInputStream.readString(10, false);
        this.dwDis2GrpLimitType = jceInputStream.read(this.dwDis2GrpLimitType, 11, false);
        this.vecJoinPrompt = jceInputStream.read(cache_vecJoinPrompt, 12, false);
        this.vecKaiyangTransInfo = jceInputStream.read(cache_vecKaiyangTransInfo, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reqtype, 0);
        jceOutputStream.write(this.result, 1);
        jceOutputStream.write(this.vecBody, 2);
        jceOutputStream.write(this.ErrorString, 3);
        jceOutputStream.write(this.errorCode, 4);
        jceOutputStream.write(this.cIsInGroup, 5);
        String str = this.sGroupLocation;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        jceOutputStream.write(this.cIsMemInvite, 7);
        String str2 = this.sAuthGrpInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 8);
        }
        String str3 = this.sJoinQuestion;
        if (str3 != null) {
            jceOutputStream.write(str3, 9);
        }
        String str4 = this.sJoinAnswer;
        if (str4 != null) {
            jceOutputStream.write(str4, 10);
        }
        jceOutputStream.write(this.dwDis2GrpLimitType, 11);
        byte[] bArr = this.vecJoinPrompt;
        if (bArr != null) {
            jceOutputStream.write(bArr, 12);
        }
        byte[] bArr2 = this.vecKaiyangTransInfo;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 13);
        }
    }

    public GroupMngRes(int i3, byte b16, byte[] bArr, String str, short s16, byte b17, String str2, byte b18, String str3, String str4, String str5, long j3, byte[] bArr2, byte[] bArr3) {
        this.reqtype = i3;
        this.result = b16;
        this.vecBody = bArr;
        this.ErrorString = str;
        this.errorCode = s16;
        this.cIsInGroup = b17;
        this.sGroupLocation = str2;
        this.cIsMemInvite = b18;
        this.sAuthGrpInfo = str3;
        this.sJoinQuestion = str4;
        this.sJoinAnswer = str5;
        this.dwDis2GrpLimitType = j3;
        this.vecJoinPrompt = bArr2;
        this.vecKaiyangTransInfo = bArr3;
    }
}
