package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_setspaceright_rsp extends JceStruct {
    public long cur_seq;

    public mobile_sub_setspaceright_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cur_seq = jceInputStream.read(this.cur_seq, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cur_seq, 0);
    }

    public mobile_sub_setspaceright_rsp(long j3) {
        this.cur_seq = j3;
    }
}
