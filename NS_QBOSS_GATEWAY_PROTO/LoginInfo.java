package NS_QBOSS_GATEWAY_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LoginInfo extends JceStruct {
    public String strAuthKey;
    public long uAuthType;
    public long uHostUin;
    public long uPtId;
    public long uUserIpNet;

    public LoginInfo() {
        this.uAuthType = 0L;
        this.strAuthKey = "";
        this.uUserIpNet = 0L;
        this.uHostUin = 0L;
        this.uPtId = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uAuthType = jceInputStream.read(this.uAuthType, 0, false);
        this.strAuthKey = jceInputStream.readString(1, false);
        this.uUserIpNet = jceInputStream.read(this.uUserIpNet, 2, false);
        this.uHostUin = jceInputStream.read(this.uHostUin, 3, false);
        this.uPtId = jceInputStream.read(this.uPtId, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uAuthType, 0);
        String str = this.strAuthKey;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.uUserIpNet, 2);
        jceOutputStream.write(this.uHostUin, 3);
        jceOutputStream.write(this.uPtId, 4);
    }

    public LoginInfo(long j3, String str, long j16, long j17, long j18) {
        this.uAuthType = j3;
        this.strAuthKey = str;
        this.uUserIpNet = j16;
        this.uHostUin = j17;
        this.uPtId = j18;
    }
}
