package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SsoServerListInfo extends JceStruct {
    public byte bLinkType;
    public byte bProtocolType;
    public byte bProxy;
    public int iPort;
    public int iTimeOut;
    public String sIP;

    public SsoServerListInfo() {
        this.sIP = "";
        this.iPort = 0;
        this.bLinkType = (byte) 0;
        this.bProxy = (byte) 0;
        this.bProtocolType = (byte) 0;
        this.iTimeOut = 10;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sIP = jceInputStream.readString(1, true);
        this.iPort = jceInputStream.read(this.iPort, 2, true);
        this.bLinkType = jceInputStream.read(this.bLinkType, 3, true);
        this.bProxy = jceInputStream.read(this.bProxy, 4, true);
        this.bProtocolType = jceInputStream.read(this.bProtocolType, 5, false);
        this.iTimeOut = jceInputStream.read(this.iTimeOut, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sIP, 1);
        jceOutputStream.write(this.iPort, 2);
        jceOutputStream.write(this.bLinkType, 3);
        jceOutputStream.write(this.bProxy, 4);
        jceOutputStream.write(this.bProtocolType, 5);
        jceOutputStream.write(this.iTimeOut, 6);
    }

    public SsoServerListInfo(String str, int i3, byte b16, byte b17, byte b18, int i16) {
        this.sIP = str;
        this.iPort = i3;
        this.bLinkType = b16;
        this.bProxy = b17;
        this.bProtocolType = b18;
        this.iTimeOut = i16;
    }
}
