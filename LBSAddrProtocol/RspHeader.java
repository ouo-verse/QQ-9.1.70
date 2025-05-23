package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RspHeader extends JceStruct {
    static int cache_eResult;
    static int cache_eUinType;
    public int eResult;
    public int eUinType;
    public short shVersion;
    public String strCookie;
    public String strErrMsg;
    public String strUin;

    public RspHeader() {
        this.shVersion = (short) 2;
        this.eUinType = 0;
        this.strUin = "";
        this.strCookie = "";
        this.eResult = 0;
        this.strErrMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.eUinType = jceInputStream.read(this.eUinType, 1, true);
        this.strUin = jceInputStream.readString(2, true);
        this.strCookie = jceInputStream.readString(3, true);
        this.eResult = jceInputStream.read(this.eResult, 4, true);
        this.strErrMsg = jceInputStream.readString(5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.eUinType, 1);
        jceOutputStream.write(this.strUin, 2);
        jceOutputStream.write(this.strCookie, 3);
        jceOutputStream.write(this.eResult, 4);
        jceOutputStream.write(this.strErrMsg, 5);
    }

    public RspHeader(short s16, int i3, String str, String str2, int i16, String str3) {
        this.shVersion = s16;
        this.eUinType = i3;
        this.strUin = str;
        this.strCookie = str2;
        this.eResult = i16;
        this.strErrMsg = str3;
    }
}
