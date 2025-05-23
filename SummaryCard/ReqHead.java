package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqHead extends JceStruct {
    public int iVersion;

    public ReqHead() {
        this.iVersion = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iVersion = jceInputStream.read(this.iVersion, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iVersion, 0);
    }

    public ReqHead(int i3) {
        this.iVersion = i3;
    }
}
