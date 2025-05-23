package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NoCheckMarket extends JceStruct {
    public String pkgName;
    public String signatureMd5;
    public int versionCode;

    public NoCheckMarket() {
        this.pkgName = "";
        this.signatureMd5 = "";
        this.versionCode = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pkgName = jceInputStream.readString(0, false);
        this.signatureMd5 = jceInputStream.readString(1, false);
        this.versionCode = jceInputStream.read(this.versionCode, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.pkgName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.signatureMd5;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.versionCode, 2);
    }

    public NoCheckMarket(String str, String str2, int i3) {
        this.pkgName = str;
        this.signatureMd5 = str2;
        this.versionCode = i3;
    }
}
