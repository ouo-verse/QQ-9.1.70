package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AcsGetMsgListReq extends JceStruct {
    static AcsHead cache_head = new AcsHead();
    public AcsHead head;
    public int record_size;
    public int record_start;
    public long uin;

    public AcsGetMsgListReq() {
        this.head = null;
        this.uin = 0L;
        this.record_start = 0;
        this.record_size = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.head = (AcsHead) jceInputStream.read((JceStruct) cache_head, 0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.record_start = jceInputStream.read(this.record_start, 2, true);
        this.record_size = jceInputStream.read(this.record_size, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AcsHead acsHead = this.head;
        if (acsHead != null) {
            jceOutputStream.write((JceStruct) acsHead, 0);
        }
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.record_start, 2);
        jceOutputStream.write(this.record_size, 3);
    }

    public AcsGetMsgListReq(AcsHead acsHead, long j3, int i3, int i16) {
        this.head = acsHead;
        this.uin = j3;
        this.record_start = i3;
        this.record_size = i16;
    }
}
