package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PageInfo extends JceStruct {
    public long iPos;

    public PageInfo() {
        this.iPos = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iPos = jceInputStream.read(this.iPos, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iPos, 0);
    }

    public PageInfo(long j3) {
        this.iPos = j3;
    }
}
