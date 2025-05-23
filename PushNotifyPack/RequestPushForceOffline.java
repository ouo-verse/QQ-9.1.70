package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class RequestPushForceOffline extends JceStruct {
    public byte bSameDevice;
    public long lUin;
    public String strTips;
    public String strTitle;

    public RequestPushForceOffline() {
        this.lUin = 0L;
        this.strTitle = "";
        this.strTips = "";
        this.bSameDevice = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.strTitle = jceInputStream.readString(1, false);
        this.strTips = jceInputStream.readString(2, false);
        this.bSameDevice = jceInputStream.read(this.bSameDevice, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        String str = this.strTitle;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strTips;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.bSameDevice, 3);
    }

    public RequestPushForceOffline(long j3, String str, String str2, byte b16) {
        this.lUin = j3;
        this.strTitle = str;
        this.strTips = str2;
        this.bSameDevice = b16;
    }
}
