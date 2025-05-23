package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class IdiomRedPackMatchRsp extends JceStruct {
    static int cache_subchannel;
    public long grabUin = 0;
    public String billno = "";
    public long makeUin = 0;
    public int status = 0;
    public int timeInterval = 0;
    public String strErr = "";
    public String hbIdiom = "";
    public int idiomSeq = 0;
    public int fromType = 0;
    public String groupid = "";
    public int isFinished = 0;
    public String hbIdiomLastPY = "";
    public int subchannel = 0;
    public String hbPoemRule = "";

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.grabUin = jceInputStream.read(this.grabUin, 0, false);
        this.billno = jceInputStream.readString(1, false);
        this.makeUin = jceInputStream.read(this.makeUin, 2, false);
        this.status = jceInputStream.read(this.status, 3, false);
        this.timeInterval = jceInputStream.read(this.timeInterval, 4, false);
        this.strErr = jceInputStream.readString(5, false);
        this.hbIdiom = jceInputStream.readString(6, false);
        this.idiomSeq = jceInputStream.read(this.idiomSeq, 7, false);
        this.fromType = jceInputStream.read(this.fromType, 8, false);
        this.groupid = jceInputStream.readString(9, false);
        this.isFinished = jceInputStream.read(this.isFinished, 10, false);
        this.hbIdiomLastPY = jceInputStream.readString(11, false);
        this.subchannel = jceInputStream.read(this.subchannel, 12, false);
        this.hbPoemRule = jceInputStream.readString(13, false);
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
        String str3 = this.hbIdiom;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        jceOutputStream.write(this.idiomSeq, 7);
        jceOutputStream.write(this.fromType, 8);
        String str4 = this.groupid;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        jceOutputStream.write(this.isFinished, 10);
        String str5 = this.hbIdiomLastPY;
        if (str5 != null) {
            jceOutputStream.write(str5, 11);
        }
        jceOutputStream.write(this.subchannel, 12);
        String str6 = this.hbPoemRule;
        if (str6 != null) {
            jceOutputStream.write(str6, 13);
        }
    }
}
