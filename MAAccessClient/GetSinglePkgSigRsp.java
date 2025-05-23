package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetSinglePkgSigRsp extends JceStruct {
    public String pkgSig;
    public int ret;

    public GetSinglePkgSigRsp() {
        this.ret = 0;
        this.pkgSig = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.pkgSig = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.pkgSig, 1);
    }

    public GetSinglePkgSigRsp(int i3, String str) {
        this.ret = i3;
        this.pkgSig = str;
    }
}
