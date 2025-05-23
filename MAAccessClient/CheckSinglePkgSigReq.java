package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class CheckSinglePkgSigReq extends JceStruct {
    public int marketVer;
    public String pkgName;
    public String pkgSig;
    public int sysVer;
    public int versionCode;

    public CheckSinglePkgSigReq() {
        this.pkgName = "";
        this.pkgSig = "";
        this.versionCode = 0;
        this.sysVer = 0;
        this.marketVer = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pkgName = jceInputStream.readString(0, true);
        this.pkgSig = jceInputStream.readString(1, true);
        this.versionCode = jceInputStream.read(this.versionCode, 2, true);
        this.sysVer = jceInputStream.read(this.sysVer, 3, false);
        this.marketVer = jceInputStream.read(this.marketVer, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.pkgName, 0);
        jceOutputStream.write(this.pkgSig, 1);
        jceOutputStream.write(this.versionCode, 2);
        jceOutputStream.write(this.sysVer, 3);
        jceOutputStream.write(this.marketVer, 4);
    }

    public CheckSinglePkgSigReq(String str, String str2, int i3, int i16, int i17) {
        this.pkgName = str;
        this.pkgSig = str2;
        this.versionCode = i3;
        this.sysVer = i16;
        this.marketVer = i17;
    }
}
