package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PushSwitchData extends JceStruct {
    public long appid;
    public byte cPushSwitch;
    public long uin;

    public PushSwitchData() {
        this.uin = 0L;
        this.appid = 0L;
        this.cPushSwitch = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.appid = jceInputStream.read(this.appid, 1, true);
        this.cPushSwitch = jceInputStream.read(this.cPushSwitch, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.cPushSwitch, 2);
    }

    public PushSwitchData(long j3, long j16, byte b16) {
        this.uin = j3;
        this.appid = j16;
        this.cPushSwitch = b16;
    }
}
