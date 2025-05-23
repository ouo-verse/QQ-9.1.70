package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MeasureInfo extends JceStruct {
    public byte bDefault;
    public byte bLinkType;
    public byte bProxy;
    public int iPort;
    public String sIP;
    public String sImsi;

    public MeasureInfo() {
        this.sIP = "";
        this.iPort = 0;
        this.bLinkType = (byte) 0;
        this.sImsi = "";
        this.bProxy = (byte) 1;
        this.bDefault = (byte) 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sIP = jceInputStream.readString(1, true);
        this.iPort = jceInputStream.read(this.iPort, 2, true);
        this.bLinkType = jceInputStream.read(this.bLinkType, 3, true);
        this.sImsi = jceInputStream.readString(4, false);
        this.bProxy = jceInputStream.read(this.bProxy, 5, false);
        this.bDefault = jceInputStream.read(this.bDefault, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sIP, 1);
        jceOutputStream.write(this.iPort, 2);
        jceOutputStream.write(this.bLinkType, 3);
        String str = this.sImsi;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.bProxy, 5);
        jceOutputStream.write(this.bDefault, 6);
    }

    public MeasureInfo(String str, int i3, byte b16, String str2, byte b17, byte b18) {
        this.sIP = str;
        this.iPort = i3;
        this.bLinkType = b16;
        this.sImsi = str2;
        this.bProxy = b17;
        this.bDefault = b18;
    }
}
