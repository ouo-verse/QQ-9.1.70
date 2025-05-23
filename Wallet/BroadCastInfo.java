package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BroadCastInfo extends JceStruct {
    static int cache_subchannel;
    public String hbIdiom = "";
    public int idiomSeq = 0;
    public String billno = "";
    public long idiomUin = 0;
    public int isFinished = 0;
    public String hbIdiomLastPY = "";
    public int subchannel = 0;
    public String hbPoemRule = "";

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hbIdiom = jceInputStream.readString(0, false);
        this.idiomSeq = jceInputStream.read(this.idiomSeq, 1, false);
        this.billno = jceInputStream.readString(2, false);
        this.idiomUin = jceInputStream.read(this.idiomUin, 3, false);
        this.isFinished = jceInputStream.read(this.isFinished, 4, false);
        this.hbIdiomLastPY = jceInputStream.readString(5, false);
        this.subchannel = jceInputStream.read(this.subchannel, 6, false);
        this.hbPoemRule = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.hbIdiom;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.idiomSeq, 1);
        String str2 = this.billno;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.idiomUin, 3);
        jceOutputStream.write(this.isFinished, 4);
        String str3 = this.hbIdiomLastPY;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        jceOutputStream.write(this.subchannel, 6);
        String str4 = this.hbPoemRule;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
    }
}
