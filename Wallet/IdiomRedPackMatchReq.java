package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class IdiomRedPackMatchReq extends JceStruct {
    static int cache_subchannel;
    public long appid;
    public String billno;
    public int fromType;
    public long grabUin;
    public String groupid;
    public String hbIdiom;
    public String inputIdiom;
    public long makeUin;
    public int platform;
    public String qqVersion;
    public String sKey;
    public int subchannel;

    public IdiomRedPackMatchReq() {
        this.grabUin = 0L;
        this.billno = "";
        this.inputIdiom = "";
        this.hbIdiom = "";
        this.makeUin = 0L;
        this.sKey = "";
        this.appid = 0L;
        this.fromType = 0;
        this.platform = 0;
        this.qqVersion = "";
        this.groupid = "";
        this.subchannel = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.grabUin = jceInputStream.read(this.grabUin, 0, false);
        this.billno = jceInputStream.readString(1, false);
        this.inputIdiom = jceInputStream.readString(2, false);
        this.hbIdiom = jceInputStream.readString(3, false);
        this.makeUin = jceInputStream.read(this.makeUin, 4, false);
        this.sKey = jceInputStream.readString(5, false);
        this.appid = jceInputStream.read(this.appid, 6, false);
        this.fromType = jceInputStream.read(this.fromType, 7, false);
        this.platform = jceInputStream.read(this.platform, 8, false);
        this.qqVersion = jceInputStream.readString(9, false);
        this.groupid = jceInputStream.readString(10, false);
        this.subchannel = jceInputStream.read(this.subchannel, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.grabUin, 0);
        String str = this.billno;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.inputIdiom;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.hbIdiom;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.makeUin, 4);
        String str4 = this.sKey;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.appid, 6);
        jceOutputStream.write(this.fromType, 7);
        jceOutputStream.write(this.platform, 8);
        String str5 = this.qqVersion;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        String str6 = this.groupid;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        jceOutputStream.write(this.subchannel, 11);
    }

    public IdiomRedPackMatchReq(long j3, String str, String str2, String str3, long j16, String str4, long j17, int i3, int i16, String str5, String str6, int i17) {
        this.grabUin = j3;
        this.billno = str;
        this.inputIdiom = str2;
        this.hbIdiom = str3;
        this.makeUin = j16;
        this.sKey = str4;
        this.appid = j17;
        this.fromType = i3;
        this.platform = i16;
        this.qqVersion = str5;
        this.groupid = str6;
        this.subchannel = i17;
    }
}
