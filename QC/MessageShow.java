package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MessageShow extends JceStruct {
    public boolean bOpen;

    public MessageShow() {
        this.bOpen = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bOpen = jceInputStream.read(this.bOpen, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bOpen, 0);
    }

    public MessageShow(boolean z16) {
        this.bOpen = z16;
    }
}
