package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AcsDelMsgReq extends JceStruct {
    static AcsHead cache_head = new AcsHead();
    public String domain;
    public AcsHead head;
    public long mn_appid;
    public String msg_id;
    public int source;
    public long uin;

    public AcsDelMsgReq() {
        this.head = null;
        this.uin = 0L;
        this.msg_id = "";
        this.domain = "";
        this.source = 0;
        this.mn_appid = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.head = (AcsHead) jceInputStream.read((JceStruct) cache_head, 0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.msg_id = jceInputStream.readString(2, false);
        this.domain = jceInputStream.readString(3, false);
        this.source = jceInputStream.read(this.source, 4, false);
        this.mn_appid = jceInputStream.read(this.mn_appid, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AcsHead acsHead = this.head;
        if (acsHead != null) {
            jceOutputStream.write((JceStruct) acsHead, 0);
        }
        jceOutputStream.write(this.uin, 1);
        String str = this.msg_id;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.domain;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.source, 4);
        jceOutputStream.write(this.mn_appid, 5);
    }

    public AcsDelMsgReq(AcsHead acsHead, long j3, String str, String str2, int i3, long j16) {
        this.head = acsHead;
        this.uin = j3;
        this.msg_id = str;
        this.domain = str2;
        this.source = i3;
        this.mn_appid = j16;
    }
}
