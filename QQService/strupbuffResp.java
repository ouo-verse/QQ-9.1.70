package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class strupbuffResp extends JceStruct {
    public int seqno;

    public strupbuffResp() {
        this.seqno = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.seqno = jceInputStream.read(this.seqno, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.seqno, 0);
    }

    public strupbuffResp(int i3) {
        this.seqno = i3;
    }
}
