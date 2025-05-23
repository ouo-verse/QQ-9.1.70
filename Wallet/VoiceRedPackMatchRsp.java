package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class VoiceRedPackMatchRsp extends JceStruct {
    public long grabUin = 0;
    public String billno = "";
    public long makeUin = 0;
    public int status = 0;
    public int timeInterval = 0;
    public String strErr = "";
    public String degree = "";

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.grabUin = jceInputStream.read(this.grabUin, 0, false);
        this.billno = jceInputStream.readString(1, false);
        this.makeUin = jceInputStream.read(this.makeUin, 2, false);
        this.status = jceInputStream.read(this.status, 3, false);
        this.timeInterval = jceInputStream.read(this.timeInterval, 4, false);
        this.strErr = jceInputStream.readString(5, false);
        this.degree = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "VoiceRedPackMatchRsp{grabUin=" + this.grabUin + ", billno='" + this.billno + "', makeUin=" + this.makeUin + ", status=" + this.status + ", timeInterval=" + this.timeInterval + ", strErr='" + this.strErr + "', degree='" + this.degree + "'}";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.grabUin, 0);
        String str = this.billno;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.makeUin, 2);
        jceOutputStream.write(this.status, 3);
        jceOutputStream.write(this.timeInterval, 4);
        String str2 = this.strErr;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.degree;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
    }
}
