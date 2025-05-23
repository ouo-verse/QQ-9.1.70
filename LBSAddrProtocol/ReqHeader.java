package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqHeader extends JceStruct {
    static int cache_eUinType;
    public int eUinType;
    public int iClientIp;
    public int iServerIp;
    public short shVersion;
    public String strAuthName;
    public String strAuthPassword;
    public String strCookie;
    public String strUin;

    public ReqHeader() {
        this.shVersion = (short) 2;
        this.eUinType = 0;
        this.strUin = "";
        this.iClientIp = 0;
        this.iServerIp = 0;
        this.strAuthName = "";
        this.strAuthPassword = "";
        this.strCookie = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.eUinType = jceInputStream.read(this.eUinType, 1, true);
        this.strUin = jceInputStream.readString(2, true);
        this.iClientIp = jceInputStream.read(this.iClientIp, 3, true);
        this.iServerIp = jceInputStream.read(this.iServerIp, 4, true);
        this.strAuthName = jceInputStream.readString(5, true);
        this.strAuthPassword = jceInputStream.readString(6, true);
        this.strCookie = jceInputStream.readString(7, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.eUinType, 1);
        jceOutputStream.write(this.strUin, 2);
        jceOutputStream.write(this.iClientIp, 3);
        jceOutputStream.write(this.iServerIp, 4);
        jceOutputStream.write(this.strAuthName, 5);
        jceOutputStream.write(this.strAuthPassword, 6);
        jceOutputStream.write(this.strCookie, 7);
    }

    public ReqHeader(short s16, int i3, String str, int i16, int i17, String str2, String str3, String str4) {
        this.shVersion = s16;
        this.eUinType = i3;
        this.strUin = str;
        this.iClientIp = i16;
        this.iServerIp = i17;
        this.strAuthName = str2;
        this.strAuthPassword = str3;
        this.strCookie = str4;
    }
}
