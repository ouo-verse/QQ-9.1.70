package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class stTroopInfoV2 extends JceStruct {
    public byte cGroupOption;
    public long dwCertificationType;
    public long dwGroupClassExt;
    public long dwGroupCode;
    public long dwGroupFlagExt;
    public long dwGroupOwnerUin;
    public long dwGroupUin;
    public int memberNum;
    public String strFingerMemo;
    public String strGroupMemo;
    public String strGroupName;
    public int wGroupFace;

    public stTroopInfoV2() {
        this.dwGroupUin = 0L;
        this.dwGroupCode = 0L;
        this.strGroupName = "";
        this.strGroupMemo = "";
        this.dwGroupOwnerUin = 0L;
        this.dwGroupClassExt = 0L;
        this.wGroupFace = 0;
        this.strFingerMemo = "";
        this.cGroupOption = (byte) 0;
        this.memberNum = 0;
        this.dwGroupFlagExt = 0L;
        this.dwCertificationType = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwGroupUin = jceInputStream.read(this.dwGroupUin, 0, true);
        this.dwGroupCode = jceInputStream.read(this.dwGroupCode, 1, true);
        this.strGroupName = jceInputStream.readString(2, true);
        this.strGroupMemo = jceInputStream.readString(3, true);
        this.dwGroupOwnerUin = jceInputStream.read(this.dwGroupOwnerUin, 4, false);
        this.dwGroupClassExt = jceInputStream.read(this.dwGroupClassExt, 5, false);
        this.wGroupFace = jceInputStream.read(this.wGroupFace, 6, false);
        this.strFingerMemo = jceInputStream.readString(7, false);
        this.cGroupOption = jceInputStream.read(this.cGroupOption, 8, false);
        this.memberNum = jceInputStream.read(this.memberNum, 9, false);
        this.dwGroupFlagExt = jceInputStream.read(this.dwGroupFlagExt, 10, false);
        this.dwCertificationType = jceInputStream.read(this.dwCertificationType, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwGroupUin, 0);
        jceOutputStream.write(this.dwGroupCode, 1);
        jceOutputStream.write(this.strGroupName, 2);
        jceOutputStream.write(this.strGroupMemo, 3);
        jceOutputStream.write(this.dwGroupOwnerUin, 4);
        jceOutputStream.write(this.dwGroupClassExt, 5);
        jceOutputStream.write(this.wGroupFace, 6);
        String str = this.strFingerMemo;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        jceOutputStream.write(this.cGroupOption, 8);
        jceOutputStream.write(this.memberNum, 9);
        jceOutputStream.write(this.dwGroupFlagExt, 10);
        jceOutputStream.write(this.dwCertificationType, 11);
    }

    public stTroopInfoV2(long j3, long j16, String str, String str2, long j17, long j18, int i3, String str3, byte b16, int i16, long j19, long j26) {
        this.dwGroupUin = j3;
        this.dwGroupCode = j16;
        this.strGroupName = str;
        this.strGroupMemo = str2;
        this.dwGroupOwnerUin = j17;
        this.dwGroupClassExt = j18;
        this.wGroupFace = i3;
        this.strFingerMemo = str3;
        this.cGroupOption = b16;
        this.memberNum = i16;
        this.dwGroupFlagExt = j19;
        this.dwCertificationType = j26;
    }
}
