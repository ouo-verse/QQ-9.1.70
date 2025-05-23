package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AcsAckMsgRsp extends JceStruct {
    public String err_str;
    public int ret_code;

    public AcsAckMsgRsp() {
        this.ret_code = 0;
        this.err_str = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret_code = jceInputStream.read(this.ret_code, 0, false);
        this.err_str = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret_code, 0);
        String str = this.err_str;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public AcsAckMsgRsp(int i3, String str) {
        this.ret_code = i3;
        this.err_str = str;
    }
}
