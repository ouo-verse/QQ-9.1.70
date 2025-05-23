package protocol.GrayVersion;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ApplyReq extends JceStruct {
    public long appid;
    public String gateway_ip;
    public long uin;

    public ApplyReq() {
        this.appid = 0L;
        this.uin = 0L;
        this.gateway_ip = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.gateway_ip = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.uin, 1);
        String str = this.gateway_ip;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public ApplyReq(long j3, long j16, String str) {
        this.appid = j3;
        this.uin = j16;
        this.gateway_ip = str;
    }
}
