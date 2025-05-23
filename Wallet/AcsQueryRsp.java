package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AcsQueryRsp extends JceStruct {
    public String err_str;
    public int ret_code;
    public int subscribed;

    public AcsQueryRsp() {
        this.ret_code = 0;
        this.err_str = "";
        this.subscribed = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret_code = jceInputStream.read(this.ret_code, 0, false);
        this.err_str = jceInputStream.readString(1, false);
        this.subscribed = jceInputStream.read(this.subscribed, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret_code, 0);
        String str = this.err_str;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.subscribed, 2);
    }

    public AcsQueryRsp(int i3, String str, int i16) {
        this.ret_code = i3;
        this.err_str = str;
        this.subscribed = i16;
    }
}
