package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniCheckForQzoneRsp extends JceStruct {
    public String errmsg;
    public int ret;

    public UniCheckForQzoneRsp() {
        this.ret = 0;
        this.errmsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public UniCheckForQzoneRsp(int i3, String str) {
        this.ret = i3;
        this.errmsg = str;
    }
}
