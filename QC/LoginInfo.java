package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LoginInfo extends JceStruct {
    public int iKeyType;
    public int iOpplat;
    public long lUin;
    public String sClientIp;
    public String sClientVer;
    public String sSKey;

    public LoginInfo() {
        this.lUin = 0L;
        this.iKeyType = 1;
        this.sSKey = "";
        this.sClientIp = "";
        this.iOpplat = 0;
        this.sClientVer = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, false);
        this.iKeyType = jceInputStream.read(this.iKeyType, 1, false);
        this.sSKey = jceInputStream.readString(2, false);
        this.sClientIp = jceInputStream.readString(3, false);
        this.iOpplat = jceInputStream.read(this.iOpplat, 4, false);
        this.sClientVer = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.iKeyType, 1);
        String str = this.sSKey;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.sClientIp;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.iOpplat, 4);
        String str3 = this.sClientVer;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public LoginInfo(long j3, int i3, String str, String str2, int i16, String str3) {
        this.lUin = j3;
        this.iKeyType = i3;
        this.sSKey = str;
        this.sClientIp = str2;
        this.iOpplat = i16;
        this.sClientVer = str3;
    }
}
