package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FocusMpIdRsp extends JceStruct {
    public int err_code;

    public FocusMpIdRsp() {
        this.err_code = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.err_code = jceInputStream.read(this.err_code, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.err_code, 0);
    }

    public FocusMpIdRsp(int i3) {
        this.err_code = i3;
    }
}
