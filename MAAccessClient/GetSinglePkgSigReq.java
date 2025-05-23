package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetSinglePkgSigReq extends JceStruct {
    public int marketVer;
    public String pkgName;
    public int sysVer;
    public int versionCode;

    public GetSinglePkgSigReq() {
        this.pkgName = "";
        this.versionCode = 0;
        this.sysVer = 0;
        this.marketVer = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pkgName = jceInputStream.readString(0, true);
        this.versionCode = jceInputStream.read(this.versionCode, 1, true);
        this.sysVer = jceInputStream.read(this.sysVer, 2, false);
        this.marketVer = jceInputStream.read(this.marketVer, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.pkgName, 0);
        jceOutputStream.write(this.versionCode, 1);
        jceOutputStream.write(this.sysVer, 2);
        jceOutputStream.write(this.marketVer, 3);
    }

    public GetSinglePkgSigReq(String str, int i3, int i16, int i17) {
        this.pkgName = str;
        this.versionCode = i3;
        this.sysVer = i16;
        this.marketVer = i17;
    }
}
