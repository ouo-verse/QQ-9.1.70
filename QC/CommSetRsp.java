package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommSetRsp extends JceStruct {
    public int ret;
    public String strRsp;

    public CommSetRsp() {
        this.ret = 0;
        this.strRsp = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.strRsp = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.strRsp;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public CommSetRsp(int i3, String str) {
        this.ret = i3;
        this.strRsp = str;
    }
}
