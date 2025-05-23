package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class AcsPullMsgReq extends JceStruct {
    static AcsHead cache_head = new AcsHead();
    public String day;
    public AcsHead head;
    public long uin;

    public AcsPullMsgReq() {
        this.head = null;
        this.uin = 0L;
        this.day = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.head = (AcsHead) jceInputStream.read((JceStruct) cache_head, 0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.day = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AcsHead acsHead = this.head;
        if (acsHead != null) {
            jceOutputStream.write((JceStruct) acsHead, 0);
        }
        jceOutputStream.write(this.uin, 1);
        String str = this.day;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public AcsPullMsgReq(AcsHead acsHead, long j3, String str) {
        this.head = acsHead;
        this.uin = j3;
        this.day = str;
    }
}
