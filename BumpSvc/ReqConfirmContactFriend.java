package BumpSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqConfirmContactFriend extends JceStruct {
    static byte[] cache_vSig;
    public byte bGroupId;
    public byte bType;
    public long lFromMobile;
    public long lToMID;
    public long lToMobile;
    public String strNickName;
    public String strReason;
    public byte[] vSig;

    public ReqConfirmContactFriend() {
        this.bType = (byte) 0;
        this.lToMID = 0L;
        this.lFromMobile = 0L;
        this.lToMobile = 0L;
        this.vSig = null;
        this.bGroupId = (byte) 0;
        this.strReason = "";
        this.strNickName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bType = jceInputStream.read(this.bType, 0, true);
        this.lToMID = jceInputStream.read(this.lToMID, 1, false);
        this.lFromMobile = jceInputStream.read(this.lFromMobile, 2, false);
        this.lToMobile = jceInputStream.read(this.lToMobile, 3, false);
        if (cache_vSig == null) {
            cache_vSig = r0;
            byte[] bArr = {0};
        }
        this.vSig = jceInputStream.read(cache_vSig, 4, true);
        this.bGroupId = jceInputStream.read(this.bGroupId, 5, false);
        this.strReason = jceInputStream.readString(6, false);
        this.strNickName = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bType, 0);
        jceOutputStream.write(this.lToMID, 1);
        jceOutputStream.write(this.lFromMobile, 2);
        jceOutputStream.write(this.lToMobile, 3);
        jceOutputStream.write(this.vSig, 4);
        jceOutputStream.write(this.bGroupId, 5);
        String str = this.strReason;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        String str2 = this.strNickName;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
    }

    public ReqConfirmContactFriend(byte b16, long j3, long j16, long j17, byte[] bArr, byte b17, String str, String str2) {
        this.bType = b16;
        this.lToMID = j3;
        this.lFromMobile = j16;
        this.lToMobile = j17;
        this.vSig = bArr;
        this.bGroupId = b17;
        this.strReason = str;
        this.strNickName = str2;
    }
}
