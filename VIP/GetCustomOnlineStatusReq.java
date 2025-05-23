package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetCustomOnlineStatusReq extends JceStruct {
    public int iModelNum;
    public long lUin;
    public String sIMei;

    public GetCustomOnlineStatusReq() {
        this.lUin = 0L;
        this.sIMei = "";
        this.iModelNum = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, false);
        this.sIMei = jceInputStream.readString(1, false);
        this.iModelNum = jceInputStream.read(this.iModelNum, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        String str = this.sIMei;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.iModelNum, 2);
    }

    public GetCustomOnlineStatusReq(long j3, String str, int i3) {
        this.lUin = j3;
        this.sIMei = str;
        this.iModelNum = i3;
    }
}
