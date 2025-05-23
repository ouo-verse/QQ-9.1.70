package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AIOSendReq extends JceStruct {
    public int iSend;
    public String sAid;
    public String sFriendUin;
    public String sUin;

    public AIOSendReq() {
        this.sUin = "";
        this.sFriendUin = "";
        this.iSend = 0;
        this.sAid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sUin = jceInputStream.readString(0, true);
        this.sFriendUin = jceInputStream.readString(1, true);
        this.iSend = jceInputStream.read(this.iSend, 2, true);
        this.sAid = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sUin, 0);
        jceOutputStream.write(this.sFriendUin, 1);
        jceOutputStream.write(this.iSend, 2);
        jceOutputStream.write(this.sAid, 3);
    }

    public AIOSendReq(String str, String str2, int i3, String str3) {
        this.sUin = str;
        this.sFriendUin = str2;
        this.iSend = i3;
        this.sAid = str3;
    }
}
